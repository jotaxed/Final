package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nw implements SafeParcelable {
    public static final nx CREATOR = new nx();
    final int CK;
    private final String ahx;
    private final String ahy;
    private final String mTag;

    nw(int i, String str, String str2, String str3) {
        this.CK = i;
        this.ahx = str;
        this.mTag = str2;
        this.ahy = str3;
    }

    public int describeContents() {
        nx nxVar = CREATOR;
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof nw)) {
            return false;
        }
        nw nwVar = (nw) that;
        return jv.equal(this.ahx, nwVar.ahx) && jv.equal(this.mTag, nwVar.mTag) && jv.equal(this.ahy, nwVar.ahy);
    }

    public String getSource() {
        return this.ahy;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return jv.hashCode(this.ahx, this.mTag, this.ahy);
    }

    public String nw() {
        return this.ahx;
    }

    public String toString() {
        return jv.h(this).a("mPlaceId", this.ahx).a("mTag", this.mTag).a("mSource", this.ahy).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        nx nxVar = CREATOR;
        nx.a(this, out, flags);
    }
}
