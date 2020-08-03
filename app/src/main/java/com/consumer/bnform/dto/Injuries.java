package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Injuries implements Parcelable {
    private String name;

    protected Injuries(Parcel in) {
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Injuries> CREATOR = new Creator<Injuries>() {
        @Override
        public Injuries createFromParcel(Parcel in) {
            return new Injuries(in);
        }

        @Override
        public Injuries[] newArray(int size) {
            return new Injuries[size];
        }
    };
}
