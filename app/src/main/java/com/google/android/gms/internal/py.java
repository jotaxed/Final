package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class py implements SafeParcelable {
    public static final Creator<py> CREATOR = new pz();
    private final int CK;
    String[] avY;
    byte[][] avZ;

    py() {
        this(1, new String[0], new byte[0][]);
    }

    py(int i, String[] strArr, byte[][] bArr) {
        this.CK = i;
        this.avY = strArr;
        this.avZ = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel out, int flags) {
        pz.a(this, out, flags);
    }
}
