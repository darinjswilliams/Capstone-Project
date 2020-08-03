package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class InjuriesDAO implements Parcelable {
    private String name;

    protected InjuriesDAO(Parcel in) {
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

    public static final Creator<InjuriesDAO> CREATOR = new Creator<InjuriesDAO>() {
        @Override
        public InjuriesDAO createFromParcel(Parcel in) {
            return new InjuriesDAO(in);
        }

        @Override
        public InjuriesDAO[] newArray(int size) {
            return new InjuriesDAO[size];
        }
    };
}
