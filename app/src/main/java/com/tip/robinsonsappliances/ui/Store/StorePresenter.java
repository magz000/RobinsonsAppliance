package com.tip.robinsonsappliances.ui.Store;


import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.models.data.Stores;
import com.tip.robinsonsappliances.models.data.User;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class StorePresenter extends MvpNullObjectBasePresenter<StoreView> {

    private Realm realm;



    RealmResults<Stores> stores;


    void start() {
        realm = Realm.getDefaultInstance();

        stores = realm.where(Stores.class).findAllAsync();

        stores.addChangeListener(new RealmChangeListener<RealmResults<Stores>>() {
            @Override
            public void onChange(RealmResults<Stores> element) {
                if (stores.isLoaded() && stores.isValid()) {
                    getView().setStores(realm.copyFromRealm(stores));

                }
            }
        });

    }

    User getUser(){
        return realm.where(User.class).findFirst();
    }

    void stop() {
        stores.removeChangeListeners();
        realm.close();
    }

    void populate(){


        realm.beginTransaction();

        realm.delete(Stores.class);

        Stores stores = new Stores();

        stores.setName("Robinsons Galleria");
        stores.setAddress("3/F West Wing Robinsons Galleria, EDSA cor., Ortigas Ave. Quezon City");
        stores.setContact("(02) 650-1290  \n(02) 650-1291");
        realm.insert(stores);

        stores.setName("Robinsons Magnolia");
        stores.setAddress("LG/F Robinsons Magnolia, Aurora Blvd., Quezon City");
        stores.setContact("(02) 656-5598");
        realm.insert(stores);

        stores.setName("Robinsons Metro East");
        stores.setAddress("LG/F Robinsons Place Metro East Brgy. Dela Paz, Marcos Highway, Pasig City");
        stores.setContact("(02) 696-2815 ");
        realm.insert(stores);

        stores.setName("Robinsons Novaliches");
        stores.setAddress("G/F Robinsons Place Novaliches # 1199 Quirino Highway cor. Maligay Road Pasong Putik, Novaliches, Quezon City");
        stores.setContact("(02) 938-6901");
        realm.insert(stores);

        stores.setName("Robinsons Place Antipolo");
        stores.setAddress("G/F Robinsons Place Antipolo, Sumulong Highway cor. Circumferential Road, Antipolo City ");
        stores.setContact("(02) 655-6905");
        realm.insert(stores);

        stores.setName("Robinsons Place Cainta");
        stores.setAddress("2/F Robinsons Place Cainta Ortigas Ave., Ext., Brgy. Sto. Domingo Cainta, Rizal");
        stores.setContact("(02) 655-6607");
        realm.insert(stores);

        stores.setName("Robinsons Place Manila");
        stores.setAddress("2/F Pedro Gil Wing, Robinsons Place Manila 2/F Pedro Gil and Adriatico St., Ermita, Manila");
        stores.setContact("(02) 714-6755");
        realm.insert(stores);

        stores.setName("Robinsons Place Otis");
        stores.setAddress("G/F Robinsons Place Otis, Paz Nendoza St. Paco, Manila");
        stores.setContact("(02) 567-0866");
        realm.insert(stores);







//        realm.delete(Stores.class);
//
//        Stores stores = realm.createObject(Stores.class);
//        stores.setId(1);
//        stores.setName("Robinsons Galleria");
//        stores.setAddress("3/F West Wing Robinsons Galleria, EDSA cor., Ortigas Ave. Quezon City");
//        stores.setContact("(02) 650-1290  \n(02) 650-1291");

        realm.commitTransaction();



    }

}
