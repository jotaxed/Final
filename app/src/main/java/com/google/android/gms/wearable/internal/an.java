package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class an implements SafeParcelable {
    public static final Creator<an> CREATOR = new ao();
    public final long ayc;
    public final String label;
    public final String packageName;
    public final int versionCode;

    an(int i, String str, String str2, long j) {
        this.versionCode = i;
        this.packageName = str;
        this.label = str2;
        this.ayc = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        ao.a(this, out, flags);
    }
}
