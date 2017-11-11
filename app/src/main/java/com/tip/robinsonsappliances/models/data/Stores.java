package com.tip.robinsonsappliances.models.data;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Stores extends RealmObject {

//    @PrimaryKey
//    @SerializedName("id")
//    @Expose
//    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("contact")
    @Expose
    private String contact;

    @SerializedName("address")
    @Expose
    private String address;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
//    public boolean equals(Object o) {
//        return (o instanceof Stores && getId() == ((Stores) o).getId());
//    }

}
