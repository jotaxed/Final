package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class nl implements SafeParcelable {
    public static final nm CREATOR = new nm();
    static final List<nd> ahg = Collections.emptyList();
    private final int CK;
    LocationRequest We;
    boolean ahh;
    boolean ahi;
    boolean ahj;
    List<nd> ahk;
    final String mTag;

    nl(int i, LocationRequest locationRequest, boolean z, boolean z2, boolean z3, List<nd> list, String str) {
        this.CK = i;
        this.We = locationRequest;
        this.ahh = z;
        this.ahi = z2;
        this.ahj = z3;
        this.ahk = list;
        this.mTag = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof nl)) {
            return false;
        }
        nl nlVar = (nl) other;
        return jv.equal(this.We, nlVar.We) && this.ahh == nlVar.ahh && this.ahi == nlVar.ahi && this.ahj == nlVar.ahj && jv.equal(this.ahk, nlVar.ahk);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return this.We.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.We.toString());
        stringBuilder.append(" requestNlpDebugInfo=");
        stringBuilder.append(this.ahh);
        stringBuilder.append(" restorePendingIntentListeners=");
        stringBuilder.append(this.ahi);
        stringBuilder.append(" triggerUpdate=");
        stringBuilder.append(this.ahj);
        stringBuilder.append(" clients=");
        stringBuilder.append(this.ahk);
        if (this.mTag != null) {
            stringBuilder.append(" tag=");
            stringBuilder.append(this.mTag);
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        nm.a(this, parcel, flags);
    }
}
