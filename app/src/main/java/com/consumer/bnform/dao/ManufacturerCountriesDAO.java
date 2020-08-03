package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class ManufacturerCountriesDAO implements Parcelable {

    private String country;

    protected ManufacturerCountriesDAO(Parcel in) {
        country = in.readString();
    }

    public static final Creator<ManufacturerCountriesDAO> CREATOR = new Creator<ManufacturerCountriesDAO>() {
        @Override
        public ManufacturerCountriesDAO createFromParcel(Parcel in) {
            return new ManufacturerCountriesDAO(in);
        }

        @Override
        public ManufacturerCountriesDAO[] newArray(int size) {
            return new ManufacturerCountriesDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(country);
    }
}
