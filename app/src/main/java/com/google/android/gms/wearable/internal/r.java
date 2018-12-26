package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.c;

@Deprecated
public class r implements SafeParcelable {
    public static final Creator<r> CREATOR = new s();
    public final c axJ;
    public final int statusCode;
    public final int versionCode;

    r(int i, int i2, c cVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axJ = cVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        s.a(this, dest, flags);
    }
}
