package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class RemedyOptionsDAO implements Parcelable {

    private String option;

    protected RemedyOptionsDAO(Parcel in) {
        option = in.readString();
    }

    public static final Creator<RemedyOptionsDAO> CREATOR = new Creator<RemedyOptionsDAO>() {
        @Override
        public RemedyOptionsDAO createFromParcel(Parcel in) {
            return new RemedyOptionsDAO(in);
        }

        @Override
        public RemedyOptionsDAO[] newArray(int size) {
            return new RemedyOptionsDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(option);
    }
}
