package com.tip.robinsonsappliances.ui.Tabbed.activity;


import android.location.Location;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.app.App;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.CurrentLocation;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.ui.Tabbed.fragment.TabbedFragmentView;

import java.io.IOException;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabbedPresenter extends MvpNullObjectBasePresenter<TabbedView> {

    private Realm realm;

    private String type = "actualPrice";
    private String text = "";

    Sort sort = Sort.ASCENDING;

    void onStart() {
        realm = Realm.getDefaultInstance();



        /*
        Temportary statements to avoid login
         */



        realm.beginTransaction();
            realm.delete(User.class);

            User user = realm.createObject(User.class, "1");

            user.setFbId("100000404445423");
            user.setUserName("test");
            user.setFirstName("Sherwin");
            user.setLastName("Lorico");

        realm.commitTransaction();

    }

    void onStop() {
        realm.close();
    }

    void search(String text){

        this.text = text;

        if(!text.trim().equals("")) {
            List<Appliances> appliances = realm.where(Appliances.class)
                    .beginGroup()
                    .or().contains(Constants.BRAND, this.text, Case.INSENSITIVE)
                    .or().contains(Constants.NAME, this.text, Case.INSENSITIVE)
                    .or().contains(Constants.SPECS, this.text, Case.INSENSITIVE)
                    .or().contains(Constants.TYPE, this.text, Case.INSENSITIVE)
                    .endGroup()
                    .findAllSorted(this.type, sort);

            getView().setAppliances(appliances);
        }

    }

    User getUser(){

        User user = realm.where(User.class).findFirst();

        return user;
    }

    void changeType(String type){

        if(type.toLowerCase().equals("name")){
            type = "name";
        }else if(type.toLowerCase().equals("price")){
            type = "actualPrice";
        }

        if(this.type.equals(type)){
            if(sort == Sort.ASCENDING){
                sort = Sort.DESCENDING;
            }else{
                sort = Sort.ASCENDING;
            }
        }

        this.type = type;

        if(!text.trim().equals("")) {

            List<Appliances> appliances = realm.where(Appliances.class)
                    .beginGroup()
                    .or().contains(Constants.BRAND, this.text, Case.INSENSITIVE)
                    .or().contains(Constants.NAME, this.text, Case.INSENSITIVE)
                    .or().contains(Constants.SPECS, this.text, Case.INSENSITIVE)
                    .or().contains(Constants.TYPE, this.text, Case.INSENSITIVE)
                    .endGroup()
                    .findAllSorted(this.type, sort);

            getView().setAppliances(appliances);
        }else{

        }
    }

    void updateLocation(Location location){
        realm.beginTransaction();
            realm.delete(CurrentLocation.class);

            CurrentLocation currentLocation = new CurrentLocation();
            currentLocation.setLatitude(location.getLatitude());
            currentLocation.setLongitude(location.getLongitude());
            realm.insert(currentLocation);

        realm.commitTransaction();
    }

    void refresh() {
        App.getInstance().getApiInterface().getAppliances().enqueue(new Callback<List<Appliances>>() {
            @Override
            public void onResponse(Call<List<Appliances>> call, final Response<List<Appliances>> response) {
                getView().stopLoading();

                if (response.isSuccessful()) {

                    final Realm realm = Realm.getDefaultInstance();

                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            //realm.delete(Appliances.class);
                            realm.insertOrUpdate(response.body());

                        }
                    }, new Realm.Transaction.OnSuccess() {
                        @Override
                        public void onSuccess() {
                            realm.close();
                        }
                    }, new Realm.Transaction.OnError() {
                        @Override
                        public void onError(Throwable error) {
                            error.printStackTrace();
                            realm.close();
                            getView().showMessage("Error Saving to DB");
                        }
                    });
                } else {
                    try {
                        getView().showMessage(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                        getView().showMessage(response.message() != null ? response.message()
                                : "Unknown Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Appliances>> call, Throwable t) {
                t.printStackTrace();
                getView().stopLoading();
                getView().showMessage("Error Retrieving List");
            }
        });
    }



}
