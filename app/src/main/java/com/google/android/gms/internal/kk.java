package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class kk implements SafeParcelable {
    public static final kl CREATOR = new kl();
    final int CK;
    public final String ND;
    public final int NE;

    public kk(int i, String str, int i2) {
        this.CK = i;
        this.ND = str;
        this.NE = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        kl.a(this, out, flags);
    }
}
