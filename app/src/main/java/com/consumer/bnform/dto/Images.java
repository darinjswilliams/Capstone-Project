package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Images implements Parcelable {

    private String url;
    private String caption;

    protected Images(Parcel in) {
        url = in.readString();
        caption = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(url);
        parcel.writeString(caption);
    }
}
