package com.consumer.bnform.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Importers implements Parcelable {

    private String name;

    protected Importers(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Importers> CREATOR = new Creator<Importers>() {
        @Override
        public Importers createFromParcel(Parcel in) {
            return new Importers(in);
        }

        @Override
        public Importers[] newArray(int size) {
            return new Importers[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
