package com.tip.robinsonsappliances.ui.Appliances.details.fragment;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.ComparedAppliances;
import com.tip.robinsonsappliances.models.data.CurrentLocation;
import com.tip.robinsonsappliances.models.data.Wishlist;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.Sort;


public class FragmentAppliancesDetailPresenter extends MvpNullObjectBasePresenter<FragmentAppliancesDetailView> {

    private Realm realm;
    private Appliances appliances;

    void start(int id) {
        realm = Realm.getDefaultInstance();

        appliances = realm.where(Appliances.class).equalTo(Constants.ID, id).findFirstAsync();

        appliances.addChangeListener(new RealmChangeListener<Appliances>() {
            @Override
            public void onChange(Appliances element) {
                if (appliances.isLoaded() && appliances.isValid()) {
                    getView().setAppliances(realm.copyFromRealm(appliances));
                }
            }
        });

    }

    List<Appliances> getSameBrand(String type, String brand){
        return realm.where(Appliances.class)
                .equalTo(Constants.TYPE, type)
                .equalTo(Constants.BRAND, brand)
                .findAllSorted(Constants.PRICE, Sort.DESCENDING);
    }

    void addToCompare(Appliances appliances){
        realm.beginTransaction();

        ComparedAppliances comparedAppliances = realm.createObject(ComparedAppliances.class);
        comparedAppliances.setAppliances(appliances);

        realm.commitTransaction();
    }

    void addToWishlist(Appliances appliances){
        realm.beginTransaction();

        Wishlist wishlist = realm.createObject(Wishlist.class);
        wishlist.setAppliances(appliances);

        realm.commitTransaction();
    }

    CurrentLocation getCurrentLocation(){
        return realm.where(CurrentLocation.class).findFirst();
    }

    long checkIfInCompared(Appliances appliances){
        return realm.where(ComparedAppliances.class).equalTo("appliances.id", appliances.getId()).count();
    }

    long checkIfInWishlist(Appliances appliances){
        return realm.where(Wishlist.class).equalTo("appliances.id", appliances.getId()).count();
    }

    void stop() {
        appliances.removeChangeListeners();
        realm.close();
    }
}
