package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class DistributorsDAO implements Parcelable {
    private String name;
    private String companyId;

    protected DistributorsDAO(Parcel in) {
        name = in.readString();
        companyId = in.readString();
    }

    public static final Creator<DistributorsDAO> CREATOR = new Creator<DistributorsDAO>() {
        @Override
        public DistributorsDAO createFromParcel(Parcel in) {
            return new DistributorsDAO(in);
        }

        @Override
        public DistributorsDAO[] newArray(int size) {
            return new DistributorsDAO[size];
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
