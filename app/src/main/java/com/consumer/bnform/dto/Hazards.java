package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Hazards implements Parcelable {

    private String name;
    private String hazardType;
    private String hazardTypeId;

    protected Hazards(Parcel in) {
        name = in.readString();
        hazardType = in.readString();
        hazardTypeId = in.readString();
    }

    public static final Creator<Hazards> CREATOR = new Creator<Hazards>() {
        @Override
        public Hazards createFromParcel(Parcel in) {
            return new Hazards(in);
        }

        @Override
        public Hazards[] newArray(int size) {
            return new Hazards[size];
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
