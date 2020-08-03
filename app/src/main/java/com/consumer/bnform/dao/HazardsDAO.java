package com.consumer.bnform.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class HazardsDAO implements Parcelable {

    private String name;
    private String hazardType;
    private String hazardTypeId;

    protected HazardsDAO(Parcel in) {
        name = in.readString();
        hazardType = in.readString();
        hazardTypeId = in.readString();
    }

    public static final Creator<HazardsDAO> CREATOR = new Creator<HazardsDAO>() {
        @Override
        public HazardsDAO createFromParcel(Parcel in) {
            return new HazardsDAO(in);
        }

        @Override
        public HazardsDAO[] newArray(int size) {
            return new HazardsDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(hazardType);
        parcel.writeString(hazardTypeId);
    }
}
