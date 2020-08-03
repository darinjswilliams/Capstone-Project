package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Distributors implements Parcelable {
    private String name;
    private String companyId;

    protected Distributors(Parcel in) {
        name = in.readString();
        companyId = in.readString();
    }

    public static final Creator<Distributors> CREATOR = new Creator<Distributors>() {
        @Override
        public Distributors createFromParcel(Parcel in) {
            return new Distributors(in);
        }

        @Override
        public Distributors[] newArray(int size) {
            return new Distributors[size];
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
