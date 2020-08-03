package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductDAO implements Parcelable {

    private String name;
    private String description;
    private String model;
    private String type;
    private String categoryId;
    private String numOfUnits;

    protected ProductDAO(Parcel in) {
        name = in.readString();
        description = in.readString();
        model = in.readString();
        type = in.readString();
        categoryId = in.readString();
        numOfUnits = in.readString();
    }

    public static final Creator<ProductDAO> CREATOR = new Creator<ProductDAO>() {
        @Override
        public ProductDAO createFromParcel(Parcel in) {
            return new ProductDAO(in);
        }

        @Override
        public ProductDAO[] newArray(int size) {
            return new ProductDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(model);
        parcel.writeString(type);
        parcel.writeString(categoryId);
        parcel.writeString(numOfUnits);
    }
}
