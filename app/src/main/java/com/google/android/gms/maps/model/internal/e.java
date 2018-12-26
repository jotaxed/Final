package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class e implements SafeParcelable {
    public static final f CREATOR = new f();
    private final int CK;
    private a amM;

    public e() {
        this.CK = 1;
    }

    e(int i, a aVar) {
        this.CK = i;
        this.amM = aVar;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public a oj() {
        return this.amM;
    }

    public void writeToParcel(Parcel out, int flags) {
        f.a(this, out, flags);
    }
}
