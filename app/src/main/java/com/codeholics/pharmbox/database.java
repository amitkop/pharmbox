package com.codeholics.pharmbox;

import android.os.Parcel;
import android.os.Parcelable;

public class database implements Parcelable {
    private String shopname;
    private String address;
    private String medicine;
    private String disease;
    private String description;
    private String type;
    private String price;

    public database() {
    }

    public database(String shopname, String address, String medicine, String disease, String description, String type, String price) {
        this.shopname = shopname;
        this.address = address;
        this.medicine = medicine;
        this.disease = disease;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.shopname);
        dest.writeString(this.address);
        dest.writeString(this.medicine);
        dest.writeString(this.disease);
        dest.writeString(this.description);
        dest.writeString(this.type);
        dest.writeString(this.price);
    }

    protected database(Parcel in) {
        this.shopname = in.readString();
        this.address = in.readString();
        this.medicine = in.readString();
        this.disease = in.readString();
        this.description = in.readString();
        this.type = in.readString();
        this.price = in.readString();
    }

    public static final Parcelable.Creator<database> CREATOR = new Parcelable.Creator<database>() {
        @Override
        public database createFromParcel(Parcel source) {
            return new database(source);
        }

        @Override
        public database[] newArray(int size) {
            return new database[size];
        }
    };
}
