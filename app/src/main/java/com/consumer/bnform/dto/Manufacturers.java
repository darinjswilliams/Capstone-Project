package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Manufacturers implements Parcelable {

    private String name;
    private String companyId;

    protected Manufacturers(Parcel in) {
        name = in.readString();
        companyId = in.readString();
    }

    public static final Creator<Manufacturers> CREATOR = new Creator<Manufacturers>() {
        @Override
        public Manufacturers createFromParcel(Parcel in) {
            return new Manufacturers(in);
        }

        @Override
        public Manufacturers[] newArray(int size) {
            return new Manufacturers[size];
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
