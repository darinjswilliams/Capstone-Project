package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class RemedyOptions implements Parcelable {

    private String option;

    protected RemedyOptions(Parcel in) {
        option = in.readString();
    }

    public static final Creator<RemedyOptions> CREATOR = new Creator<RemedyOptions>() {
        @Override
        public RemedyOptions createFromParcel(Parcel in) {
            return new RemedyOptions(in);
        }

        @Override
        public RemedyOptions[] newArray(int size) {
            return new RemedyOptions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(option);
    }
}
