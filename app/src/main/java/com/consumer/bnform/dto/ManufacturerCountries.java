package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class ManufacturerCountries implements Parcelable {

    private String country;

    protected ManufacturerCountries(Parcel in) {
        country = in.readString();
    }

    public static final Creator<ManufacturerCountries> CREATOR = new Creator<ManufacturerCountries>() {
        @Override
        public ManufacturerCountries createFromParcel(Parcel in) {
            return new ManufacturerCountries(in);
        }

        @Override
        public ManufacturerCountries[] newArray(int size) {
            return new ManufacturerCountries[size];
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
