package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class if implements SafeParcelable {
    public static final ig CREATOR = new ig();
    final Bundle Ep;
    final byte[] Eq;
    final int responseCode;
    final int versionCode;

    public if(int i, int i2, Bundle bundle, byte[] bArr) {
        this.versionCode = i;
        this.responseCode = i2;
        this.Ep = bundle;
        this.Eq = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ig.a(this, parcel, flags);
    }
}
