package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class g implements SafeParcelable {
    public static final Creator<g> CREATOR = new h();
    private final int CK;
    int awN;
    String awO;
    double awP;
    String awQ;
    long awR;
    int awS;

    g() {
        this.CK = 1;
        this.awS = -1;
        this.awN = -1;
        this.awP = -1.0d;
    }

    g(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.CK = i;
        this.awN = i2;
        this.awO = str;
        this.awP = d;
        this.awQ = str2;
        this.awR = j;
        this.awS = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        h.a(this, dest, flags);
    }
}
