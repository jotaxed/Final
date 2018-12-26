package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class n implements SafeParcelable {
    public static final Creator<n> CREATOR = new o();
    private final int CK;
    String awW;
    String description;

    n() {
        this.CK = 1;
    }

    n(int i, String str, String str2) {
        this.CK = i;
        this.awW = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        o.a(this, dest, flags);
    }
}
