package com.tip.robinsonsappliances.ui.Compare;


import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.models.data.ComparedAppliances;
import com.tip.robinsonsappliances.models.data.User;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ComparePresenter extends MvpNullObjectBasePresenter<CompareView> {

    private Realm realm;



    RealmResults<ComparedAppliances> appliances;


    void start() {
        realm = Realm.getDefaultInstance();

        appliances = realm.where(ComparedAppliances.class).findAllAsync();

        appliances.addChangeListener(new RealmChangeListener<RealmResults<ComparedAppliances>>() {
            @Override
            public void onChange(RealmResults<ComparedAppliances> element) {
                if (appliances.isLoaded() && appliances.isValid()) {
                    getView().setAppliance(realm.copyFromRealm(appliances));
                }
            }
        });
    }

    User getUser(){
        return realm.where(User.class).findFirst();
    }

    void stop() {
        appliances.removeChangeListeners();
        realm.close();
    }

}
