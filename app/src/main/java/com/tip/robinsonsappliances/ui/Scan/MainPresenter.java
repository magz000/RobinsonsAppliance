package com.tip.robinsonsappliances.ui.Scan;


import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.ComparedAppliances;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.models.data.Wishlist;

import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

public class MainPresenter extends MvpNullObjectBasePresenter<MainView> {

    private Realm realm;


    void start() {
        realm = Realm.getDefaultInstance();
    }

    User getUser(){
        return realm.where(User.class).findFirst();
    }

    Appliances getAppliance(String barcode){
        return realm.where(Appliances.class).equalTo(Constants.BARCODE, barcode).findFirst();
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

    List<Appliances> getSameBrand(String type, String brand){
        return realm.where(Appliances.class)
                .equalTo(Constants.TYPE, type)
                .equalTo(Constants.BRAND, brand)
                .findAllSorted(Constants.PRICE, Sort.DESCENDING);
    }

    long checkIfInCompared(Appliances appliances){
        return realm.where(ComparedAppliances.class).equalTo("appliances.id", appliances.getId()).count();
    }

    long checkIfInWishlist(Appliances appliances){
        return realm.where(Wishlist.class).equalTo("appliances.id", appliances.getId()).count();
    }

    void stop() {
        //appliances.removeChangeListeners();
        realm.close();
    }

}
