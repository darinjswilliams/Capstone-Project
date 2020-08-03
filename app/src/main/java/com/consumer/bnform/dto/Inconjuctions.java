package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Inconjuctions implements Parcelable {

    private String url;

    protected Inconjuctions(Parcel in) {
        url = in.readString();
    }

    public static final Creator<Inconjuctions> CREATOR = new Creator<Inconjuctions>() {
        @Override
        public Inconjuctions createFromParcel(Parcel in) {
            return new Inconjuctions(in);
        }

        @Override
        public Inconjuctions[] newArray(int size) {
            return new Inconjuctions[size];
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
