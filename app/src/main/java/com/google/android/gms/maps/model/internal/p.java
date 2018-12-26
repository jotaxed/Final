package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p implements SafeParcelable {
    public static final q CREATOR = new q();
    private final int CK;
    private a amN;

    public p() {
        this.CK = 1;
    }

    p(int i, a aVar) {
        this.CK = i;
        this.amN = aVar;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public a ol() {
        return this.amN;
    }

    public void writeToParcel(Parcel out, int flags) {
        q.a(this, out, flags);
    }
}
