package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class j implements SafeParcelable {
    public static final Creator<j> CREATOR = new k();
    private final int CK;
    String awT;
    String tU;

    j() {
        this.CK = 1;
    }

    j(int i, String str, String str2) {
        this.CK = i;
        this.awT = str;
        this.tU = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        k.a(this, dest, flags);
    }
}
