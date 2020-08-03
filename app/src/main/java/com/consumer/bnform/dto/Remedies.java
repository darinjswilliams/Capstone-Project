package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Remedies implements Parcelable {
    private String name;

    protected Remedies(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Remedies> CREATOR = new Creator<Remedies>() {
        @Override
        public Remedies createFromParcel(Parcel in) {
            return new Remedies(in);
        }

        @Override
        public Remedies[] newArray(int size) {
            return new Remedies[size];
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
