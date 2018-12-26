package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hj implements SafeParcelable {
    public static final hk CREATOR = new hk();
    final int CK;
    final Bundle Db;
    public final int id;

    hj(int i, int i2, Bundle bundle) {
        this.CK = i;
        this.id = i2;
        this.Db = bundle;
    }

    public int describeContents() {
        hk hkVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        hk hkVar = CREATOR;
        hk.a(this, dest, flags);
    }
}
