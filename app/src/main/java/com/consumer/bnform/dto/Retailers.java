package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Retailers implements Parcelable {
    private String name;
    private String companyId;

    protected Retailers(Parcel in) {
        name = in.readString();
        companyId = in.readString();
    }

    public static final Creator<Retailers> CREATOR = new Creator<Retailers>() {
        @Override
        public Retailers createFromParcel(Parcel in) {
            return new Retailers(in);
        }

        @Override
        public Retailers[] newArray(int size) {
            return new Retailers[size];
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
