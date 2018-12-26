package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class gs implements SafeParcelable {
    public static final gt CREATOR = new gt();
    public final int versionCode;
    public String wS;
    public int wT;
    public int wU;
    public boolean wV;

    public gs(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? "0" : "1"), i, i2, z);
    }

    gs(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.wS = str;
        this.wT = i2;
        this.wU = i3;
        this.wV = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        gt.a(this, out, flags);
    }
}
