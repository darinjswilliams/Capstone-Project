package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String name;
    private String description;
    private String model;
    private String type;
    private String categoryId;
    private String numOfUnits;

    protected Product(Parcel in) {
        name = in.readString();
        description = in.readString();
        model = in.readString();
        type = in.readString();
        categoryId = in.readString();
        numOfUnits = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
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
