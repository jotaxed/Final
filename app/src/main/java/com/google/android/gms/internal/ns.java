package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ns implements SafeParcelable {
    public static final nt CREATOR = new nt();
    private final int CK;
    private final int agd;
    private final int ahp;
    private final nu ahq;

    ns(int i, int i2, int i3, nu nuVar) {
        this.CK = i;
        this.agd = i2;
        this.ahp = i3;
        this.ahq = nuVar;
    }

    public int describeContents() {
        nt ntVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ns)) {
            return false;
        }
        ns nsVar = (ns) object;
        return this.agd == nsVar.agd && this.ahp == nsVar.ahp && this.ahq.equals(nsVar.ahq);
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.agd), Integer.valueOf(this.ahp));
    }

    public int np() {
        return this.agd;
    }

    public int ns() {
        return this.ahp;
    }

    public nu nt() {
        return this.ahq;
    }

    public String toString() {
        return jv.h(this).a("transitionTypes", Integer.valueOf(this.agd)).a("loiteringTimeMillis", Integer.valueOf(this.ahp)).a("placeFilter", this.ahq).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        nt ntVar = CREATOR;
        nt.a(this, parcel, flags);
    }
}
