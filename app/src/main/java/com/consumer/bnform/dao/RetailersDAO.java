package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class RetailersDAO implements Parcelable {
    private String name;
    private String companyId;

    protected RetailersDAO(Parcel in) {
        name = in.readString();
        companyId = in.readString();
    }

    public static final Creator<RetailersDAO> CREATOR = new Creator<RetailersDAO>() {
        @Override
        public RetailersDAO createFromParcel(Parcel in) {
            return new RetailersDAO(in);
        }

        @Override
        public RetailersDAO[] newArray(int size) {
            return new RetailersDAO[size];
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
