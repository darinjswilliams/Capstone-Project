package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class ImportersDAO implements Parcelable {

    private String name;

    protected ImportersDAO(Parcel in) {
        name = in.readString();
    }

    public static final Creator<ImportersDAO> CREATOR = new Creator<ImportersDAO>() {
        @Override
        public ImportersDAO createFromParcel(Parcel in) {
            return new ImportersDAO(in);
        }

        @Override
        public ImportersDAO[] newArray(int size) {
            return new ImportersDAO[size];
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
