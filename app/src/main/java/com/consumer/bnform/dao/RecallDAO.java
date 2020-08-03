package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class RecallDAO implements Parcelable {

    private Integer id;

    private Integer mRecallNumber;

    private Date mRecallDate;

    private String mDescription;

    private String mUrl;

    private String mTitle;

    private String mConsumerContact;

    private String mLastPublishDate;

    private ProductDAO products;

    private InconjuctionsDAO mInconjuctions;

    private ImagesDAO mImage;

    private InjuriesDAO mInjuries;

    private ManufacturersDAO mManufacturers;

    private RetailersDAO mRetailers;

    private ImportersDAO mImporters;

    private DistributorsDAO mDistributors;

    private String mSoldAtLabel;

    private ManufacturerCountriesDAO mManufacturerCountries;

    private ProductUpcDAO mProductUPC;

    private HazardsDAO mHazards;

    private RemediesDAO mRemedies;

    private RemedyOptionsDAO mRemedyOptions;


    protected RecallDAO(Parcel in) {
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
        products = in.readParcelable(ProductDAO.class.getClassLoader());
        mInconjuctions = in.readParcelable(InconjuctionsDAO.class.getClassLoader());
        mImage = in.readParcelable(ImagesDAO.class.getClassLoader());
        mInjuries = in.readParcelable(InjuriesDAO.class.getClassLoader());
        mManufacturers = in.readParcelable(ManufacturersDAO.class.getClassLoader());
        mRetailers = in.readParcelable(RetailersDAO.class.getClassLoader());
        mImporters = in.readParcelable(ImportersDAO.class.getClassLoader());
        mDistributors = in.readParcelable(DistributorsDAO.class.getClassLoader());
        mSoldAtLabel = in.readString();
        mManufacturerCountries = in.readParcelable(ManufacturerCountriesDAO.class.getClassLoader());
        mProductUPC = in.readParcelable(ProductUpcDAO.class.getClassLoader());
        mHazards = in.readParcelable(HazardsDAO.class.getClassLoader());
        mRemedies = in.readParcelable(RemediesDAO.class.getClassLoader());
        mRemedyOptions = in.readParcelable(RemedyOptionsDAO.class.getClassLoader());
    }

    public static final Creator<RecallDAO> CREATOR = new Creator<RecallDAO>() {
        @Override
        public RecallDAO createFromParcel(Parcel in) {
            return new RecallDAO(in);
        }

        @Override
        public RecallDAO[] newArray(int size) {
            return new RecallDAO[size];
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
