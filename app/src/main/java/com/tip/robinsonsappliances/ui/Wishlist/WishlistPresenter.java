package com.tip.robinsonsappliances.ui.Wishlist;


import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.models.data.Wishlist;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class WishlistPresenter extends MvpNullObjectBasePresenter<WishlistView> {

    private Realm realm;



    RealmResults<Wishlist> appliances;


    public void start() {
        realm = Realm.getDefaultInstance();

        appliances = realm.where(Wishlist.class).findAllAsync();

        appliances.addChangeListener(new RealmChangeListener<RealmResults<Wishlist>>() {
            @Override
            public void onChange(RealmResults<Wishlist> element) {
                if (appliances.isLoaded() && appliances.isValid()) {
                    getView().setAppliance(realm.copyFromRealm(appliances));
                }
            }
        });

    }

    User getUser(){
        return realm.where(User.class).findFirst();
    }

    public void stop() {
        appliances.removeChangeListeners();
        realm.close();
    }

}
