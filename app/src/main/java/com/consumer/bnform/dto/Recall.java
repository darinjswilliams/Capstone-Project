package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "recall")
@Data
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__({@Ignore}))

public class Recall implements Parcelable {

    @PrimaryKey
    @SerializedName("RecallID")
    @Expose
    private Integer recallId;

    @SerializedName("RecallNumber")
    @Expose
    private Integer recallNumber;

    @SerializedName("RecallDate")
    @Expose
    private Date mRecallDate;

    @SerializedName("Description")
    @Expose
    private String mDescription;

    @SerializedName("URL")
    @Expose
    private String mUrl;

    @SerializedName("Title")
    @Expose
    private String mTitle;

    @Ignore
    private String mConsumerContact;

    @SerializedName("LastPublishDate")
    @Expose
    private String mLastPublishDate;

    @Ignore
    private List<Product> mProducts;

    @Ignore
    private List<Inconjuctions> mInconjuctions;

    @Ignore
    private List<Images> mImage;

    @Ignore
    private List<Injuries> mInjuries;

    @Ignore
    private List<Manufacturers> mManufacturers;

    @Ignore
    private List<Retailers> mRetailers;

    @Ignore
    private List<Importers> mImporters;

    @Ignore
    private List<Distributors> mDistributors;

    @SerializedName("soldAtLabel")
    @Expose
    private String mSoldAtLabel;

    @Ignore
    private List<ManufacturerCountries> mManufacturerCountries;

    @Ignore
    private List<ProductUPC> mProductUPC;

    @Ignore
    private List<Hazards> mHazards;

    @Ignore
    private List<Remedies> mRemedies;

    @Ignore
    private List<RemedyOptions> mRemedyOptions;


    protected Recall(Parcel in) {
        if (in.readByte() == 0) {
            recallId = null;
        } else {
            recallId = in.readInt();
        }
        if (in.readByte() == 0) {
            recallNumber = null;
        } else {
            recallNumber = in.readInt();
        }
        mDescription = in.readString();
        mUrl = in.readString();
        mTitle = in.readString();
        mConsumerContact = in.readString();
        mLastPublishDate = in.readString();
        mProducts = in.createTypedArrayList(Product.CREATOR);
        mInconjuctions = in.createTypedArrayList(Inconjuctions.CREATOR);
        mImage = in.createTypedArrayList(Images.CREATOR);
        mInjuries = in.createTypedArrayList(Injuries.CREATOR);
        mManufacturers = in.createTypedArrayList(Manufacturers.CREATOR);
        mRetailers = in.createTypedArrayList(Retailers.CREATOR);
        mImporters = in.createTypedArrayList(Importers.CREATOR);
        mDistributors = in.createTypedArrayList(Distributors.CREATOR);
        mSoldAtLabel = in.readString();
        mManufacturerCountries = in.createTypedArrayList(ManufacturerCountries.CREATOR);
        mProductUPC = in.createTypedArrayList(ProductUPC.CREATOR);
        mHazards = in.createTypedArrayList(Hazards.CREATOR);
        mRemedies = in.createTypedArrayList(Remedies.CREATOR);
        mRemedyOptions = in.createTypedArrayList(RemedyOptions.CREATOR);
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
        if (recallId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(recallId);
        }
        if (recallNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(recallNumber);
        }
        parcel.writeString(mDescription);
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
        parcel.writeString(mConsumerContact);
        parcel.writeString(mLastPublishDate);
        parcel.writeTypedList(mProducts);
        parcel.writeTypedList(mInconjuctions);
        parcel.writeTypedList(mImage);
        parcel.writeTypedList(mInjuries);
        parcel.writeTypedList(mManufacturers);
        parcel.writeTypedList(mRetailers);
        parcel.writeTypedList(mImporters);
        parcel.writeTypedList(mDistributors);
        parcel.writeString(mSoldAtLabel);
        parcel.writeTypedList(mManufacturerCountries);
        parcel.writeTypedList(mProductUPC);
        parcel.writeTypedList(mHazards);
        parcel.writeTypedList(mRemedies);
        parcel.writeTypedList(mRemedyOptions);
    }
}
