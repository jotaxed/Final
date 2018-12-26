package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class at implements SafeParcelable {
    public static final Creator<at> CREATOR = new au();
    public final int ayd;
    public final int statusCode;
    public final int versionCode;

    at(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.ayd = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        au.a(this, dest, flags);
    }
}
