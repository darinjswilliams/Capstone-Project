package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class InconjuctionsDAO implements Parcelable {

    private String url;

    protected InconjuctionsDAO(Parcel in) {
        url = in.readString();
    }

    public static final Creator<InconjuctionsDAO> CREATOR = new Creator<InconjuctionsDAO>() {
        @Override
        public InconjuctionsDAO createFromParcel(Parcel in) {
            return new InconjuctionsDAO(in);
        }

        @Override
        public InconjuctionsDAO[] newArray(int size) {
            return new InconjuctionsDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
    }
}
