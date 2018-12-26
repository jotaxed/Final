package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class l implements SafeParcelable {
    public static final Creator<l> CREATOR = new m();
    private final int CK;
    long awU;
    long awV;

    l() {
        this.CK = 1;
    }

    l(int i, long j, long j2) {
        this.CK = i;
        this.awU = j;
        this.awV = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        m.a(this, dest, flags);
    }
}
