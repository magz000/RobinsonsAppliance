package com.tip.robinsonsappliances.ui.Appliances.list;


import android.location.Location;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.app.App;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.CurrentLocation;
import com.tip.robinsonsappliances.models.data.User;

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

public class AppliancesListPresenter extends MvpNullObjectBasePresenter<AppliancesListView> {

    private Realm realm;
    private RealmResults<Appliances> appliances;

    void onStart(String type) {
        realm = Realm.getDefaultInstance();

        appliances = realm.where(Appliances.class)
                //.equalTo(Constants.TYPE, type)
                .findAllSortedAsync(Constants.PRICE, Sort.DESCENDING);


        appliances.addChangeListener(new RealmChangeListener<RealmResults<Appliances>>() {
            @Override
            public void onChange(RealmResults<Appliances> element) {
                if (appliances.isLoaded() && appliances.isValid())
                    getView().setAppliances(realm.copyFromRealm(appliances));
            }
        });

    }

    void onStop() {
        appliances.removeChangeListeners();
        realm.close();
    }

    void search(String text, String type){
        List<Appliances> appliances = realm.where(Appliances.class)
                .beginGroup()
                .or().contains(Constants.BRAND, text, Case.INSENSITIVE)
                .or().contains(Constants.NAME, text, Case.INSENSITIVE)
                .or().contains(Constants.SPECS, text, Case.INSENSITIVE)
                .endGroup()
                .equalTo(Constants.TYPE, type, Case.INSENSITIVE)
                .findAllSorted(Constants.PRICE, Sort.DESCENDING);

        getView().setAppliances(appliances);

    }

    User getUser(){

        User user = realm.where(User.class).findFirst();

        return user;
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
