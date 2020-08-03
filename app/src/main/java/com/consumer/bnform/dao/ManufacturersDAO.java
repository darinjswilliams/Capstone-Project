package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class ManufacturersDAO implements Parcelable {

    private String name;
    private String companyId;

    protected ManufacturersDAO(Parcel in) {
        name = in.readString();
        companyId = in.readString();
    }

    public static final Creator<ManufacturersDAO> CREATOR = new Creator<ManufacturersDAO>() {
        @Override
        public ManufacturersDAO createFromParcel(Parcel in) {
            return new ManufacturersDAO(in);
        }

        @Override
        public ManufacturersDAO[] newArray(int size) {
            return new ManufacturersDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(companyId);
    }
}
