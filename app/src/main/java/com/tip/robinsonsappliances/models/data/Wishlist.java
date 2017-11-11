package com.tip.robinsonsappliances.models.data;



import io.realm.RealmObject;

public class Wishlist extends RealmObject {

    Appliances appliances;

    public Appliances getAppliances() {
        return appliances;
    }

    public void setAppliances(Appliances appliances) {
        this.appliances = appliances;
    }
}
