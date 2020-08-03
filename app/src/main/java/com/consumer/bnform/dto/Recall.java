package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Recall implements Parcelable {

    private Integer id;

    private Integer mRecallNumber;

    private Date mRecallDate;

    private String mDescription;

    private String mUrl;

    private String mTitle;

    private String mConsumerContact;

    private String mLastPublishDate;

    private Product products;

    private Inconjuctions mInconjuctions;

    private Images mImage;

    private Injuries mInjuries;

    private Manufacturers mManufacturers;

    private Retailers mRetailers;

    private Importers mImporters;

    private Distributors mDistributors;

    private String mSoldAtLabel;

    private ManufacturerCountries mManufacturerCountries;

    private ProductUPC mProductUPC;

    private Hazards mHazards;

    private Remedies mRemedies;

    private RemedyOptions mRemedyOptions;


    protected Recall(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            mRecallNumber = null;
        } else {
            mRecallNumber = in.readInt();
        }
        mDescription = in.readString();
        mUrl = in.readString();
        mTitle = in.readString();
        mConsumerContact = in.readString();
        mLastPublishDate = in.readString();
        products = in.readParcelable(Product.class.getClassLoader());
        mInconjuctions = in.readParcelable(Inconjuctions.class.getClassLoader());
        mImage = in.readParcelable(Images.class.getClassLoader());
        mInjuries = in.readParcelable(Injuries.class.getClassLoader());
        mManufacturers = in.readParcelable(Manufacturers.class.getClassLoader());
        mRetailers = in.readParcelable(Retailers.class.getClassLoader());
        mImporters = in.readParcelable(Importers.class.getClassLoader());
        mDistributors = in.readParcelable(Distributors.class.getClassLoader());
        mSoldAtLabel = in.readString();
        mManufacturerCountries = in.readParcelable(ManufacturerCountries.class.getClassLoader());
        mProductUPC = in.readParcelable(ProductUPC.class.getClassLoader());
        mHazards = in.readParcelable(Hazards.class.getClassLoader());
        mRemedies = in.readParcelable(Remedies.class.getClassLoader());
        mRemedyOptions = in.readParcelable(RemedyOptions.class.getClassLoader());
    }

    public static final Creator<Recall> CREATOR = new Creator<Recall>() {
        @Override
        public Recall createFromParcel(Parcel in) {
            return new Recall(in);
        }

        @Override
        public Recall[] newArray(int size) {
            return new Recall[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        if (mRecallNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(mRecallNumber);
        }
        parcel.writeString(mDescription);
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
        parcel.writeString(mConsumerContact);
        parcel.writeString(mLastPublishDate);
        parcel.writeParcelable(products, i);
        parcel.writeParcelable(mInconjuctions, i);
        parcel.writeParcelable(mImage, i);
        parcel.writeParcelable(mInjuries, i);
        parcel.writeParcelable(mManufacturers, i);
        parcel.writeParcelable(mRetailers, i);
        parcel.writeParcelable(mImporters, i);
        parcel.writeParcelable(mDistributors, i);
        parcel.writeString(mSoldAtLabel);
        parcel.writeParcelable(mManufacturerCountries, i);
        parcel.writeParcelable(mProductUPC, i);
        parcel.writeParcelable(mHazards, i);
        parcel.writeParcelable(mRemedies, i);
        parcel.writeParcelable(mRemedyOptions, i);
    }
}
