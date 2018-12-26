package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ap implements SafeParcelable {
    public static final Creator<ap> CREATOR = new aq();
    public final m axM;
    public final int statusCode;
    public final int versionCode;

    ap(int i, int i2, m mVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axM = mVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aq.a(this, dest, flags);
    }
}
