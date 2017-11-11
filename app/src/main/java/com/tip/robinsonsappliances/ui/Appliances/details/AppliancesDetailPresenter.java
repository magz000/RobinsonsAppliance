package com.tip.robinsonsappliances.ui.Appliances.details;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.models.data.Appliances;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;



public class AppliancesDetailPresenter extends MvpNullObjectBasePresenter<AppliancesDetailView> {

    private Realm realm;
    private RealmResults<Appliances> appliances;

    public void start(String type) {
        realm = Realm.getDefaultInstance();

        appliances = realm.where(Appliances.class).equalTo(Constants.TYPE, type).findAllSortedAsync(Constants.ACTUALPRICE, Sort.DESCENDING);

        appliances.addChangeListener(new RealmChangeListener<RealmResults<Appliances>>() {
            @Override
            public void onChange(RealmResults<Appliances> element) {
                if (appliances.isLoaded() && appliances.isValid()) {
                    getView().setAppliances(realm.copyFromRealm(appliances));
                }
            }
        });

    }

    public void stop() {
        appliances.removeChangeListeners();
        realm.close();
    }
}
