package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hf implements SafeParcelable {
    public static final hg CREATOR = new hg();
    final int CK;
    final String CS;
    final String CT;
    final String CU;

    hf(int i, String str, String str2, String str3) {
        this.CK = i;
        this.CS = str;
        this.CT = str2;
        this.CU = str3;
    }

    public hf(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    public int describeContents() {
        hg hgVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.CS, this.CT, this.CU});
    }

    public void writeToParcel(Parcel dest, int flags) {
        hg hgVar = CREATOR;
        hg.a(this, dest, flags);
    }
}
