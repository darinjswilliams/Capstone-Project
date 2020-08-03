package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductUpcDAO implements Parcelable {
    private String upc;

    protected ProductUpcDAO(Parcel in) {
        upc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(upc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductUpcDAO> CREATOR = new Creator<ProductUpcDAO>() {
        @Override
        public ProductUpcDAO createFromParcel(Parcel in) {
            return new ProductUpcDAO(in);
        }

        @Override
        public ProductUpcDAO[] newArray(int size) {
            return new ProductUpcDAO[size];
        }
    };
}
