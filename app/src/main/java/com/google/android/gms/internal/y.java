package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class y implements SafeParcelable {
    public static final z CREATOR = new z();
    public final boolean mi;
    public final boolean ms;
    public final int versionCode;

    y(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.mi = z;
        this.ms = z2;
    }

    public y(boolean z, boolean z2) {
        this.versionCode = 1;
        this.mi = z;
        this.ms = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        z.a(this, out, flags);
    }
}
