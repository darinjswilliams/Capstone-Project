package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductUPC implements Parcelable {
    private String upc;

    protected ProductUPC(Parcel in) {
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

    public static final Creator<ProductUPC> CREATOR = new Creator<ProductUPC>() {
        @Override
        public ProductUPC createFromParcel(Parcel in) {
            return new ProductUPC(in);
        }

        @Override
        public ProductUPC[] newArray(int size) {
            return new ProductUPC[size];
        }
    };
}
