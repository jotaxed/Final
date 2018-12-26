package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ha implements Parcelable {
    @Deprecated
    public static final Creator<ha> CREATOR = new Creator<ha>() {
        @Deprecated
        public ha[] I(int i) {
            return new ha[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return k(x0);
        }

        @Deprecated
        public ha k(Parcel parcel) {
            return new ha(parcel);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return I(x0);
        }
    };
    private String CE;
    private String CF;
    private String mValue;

    @Deprecated
    ha(Parcel parcel) {
        readFromParcel(parcel);
    }

    public ha(String str, String str2, String str3) {
        this.CE = str;
        this.CF = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.CE = in.readString();
        this.CF = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.CE;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.CE);
        out.writeString(this.CF);
        out.writeString(this.mValue);
    }
}
