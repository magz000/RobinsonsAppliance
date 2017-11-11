package com.tip.robinsonsappliances.ui.Tabbed.fragment;


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

public class TabbedFragmentPresenter extends MvpNullObjectBasePresenter<TabbedFragmentView> {

    private Realm realm;
    private RealmResults<Appliances> appliances;

    void onStart(String type) {
        realm = Realm.getDefaultInstance();

        appliances = realm.where(Appliances.class)
                .equalTo(Constants.TYPE, type)
                .findAllSortedAsync(Constants.ACTUALPRICE, Sort.DESCENDING);


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



    User getUser(){

        User user = realm.where(User.class).findFirst();

        return user;
    }


}
