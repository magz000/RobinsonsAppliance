package com.tip.robinsonsappliances.models.data;




import com.google.gson.annotations.Expose;

import io.realm.RealmObject;

public class CurrentLocation extends RealmObject {

    @Expose
    double latitude;

    @Expose
    double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
