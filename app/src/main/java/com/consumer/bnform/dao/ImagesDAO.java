package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class ImagesDAO implements Parcelable {

    private String url;
    private String caption;

    protected ImagesDAO(Parcel in) {
        url = in.readString();
        caption = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImagesDAO> CREATOR = new Creator<ImagesDAO>() {
        @Override
        public ImagesDAO createFromParcel(Parcel in) {
            return new ImagesDAO(in);
        }

        @Override
        public ImagesDAO[] newArray(int size) {
            return new ImagesDAO[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(url);
        parcel.writeString(caption);
    }
}
