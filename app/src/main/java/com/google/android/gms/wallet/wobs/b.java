package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class b implements SafeParcelable {
    public static final Creator<b> CREATOR = new c();
    private final int CK;
    String label;
    String value;

    b() {
        this.CK = 1;
    }

    b(int i, String str, String str2) {
        this.CK = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
