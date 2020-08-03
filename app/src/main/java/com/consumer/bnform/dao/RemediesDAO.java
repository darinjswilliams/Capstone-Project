package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class RemediesDAO implements Parcelable {
    private String name;

    protected RemediesDAO(Parcel in) {
        name = in.readString();
    }

    public static final Creator<RemediesDAO> CREATOR = new Creator<RemediesDAO>() {
        @Override
        public RemediesDAO createFromParcel(Parcel in) {
            return new RemediesDAO(in);
        }

        @Override
        public RemediesDAO[] newArray(int size) {
            return new RemediesDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
