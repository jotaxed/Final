package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hp.a;

public class hh implements SafeParcelable {
    public static final hi CREATOR = new hi();
    public static final int CV = Integer.parseInt("-1");
    private static final hp CW = new a("SsbContext").G(true).at("blob").fG();
    final int CK;
    public final String CX;
    final hp CY;
    public final int CZ;
    public final byte[] Da;

    hh(int i, String str, hp hpVar, int i2, byte[] bArr) {
        boolean z = i2 == CV || ho.P(i2) != null;
        jx.b(z, "Invalid section type " + i2);
        this.CK = i;
        this.CX = str;
        this.CY = hpVar;
        this.CZ = i2;
        this.Da = bArr;
        String fE = fE();
        if (fE != null) {
            throw new IllegalArgumentException(fE);
        }
    }

    public hh(String str, hp hpVar) {
        this(1, str, hpVar, CV, null);
    }

    public hh(String str, hp hpVar, String str2) {
        this(1, str, hpVar, ho.as(str2), null);
    }

    public hh(byte[] bArr, hp hpVar) {
        this(1, null, hpVar, CV, bArr);
    }

    public int describeContents() {
        hi hiVar = CREATOR;
        return 0;
    }

    public String fE() {
        return (this.CZ == CV || ho.P(this.CZ) != null) ? (this.CX == null || this.Da == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.CZ;
    }

    public void writeToParcel(Parcel dest, int flags) {
        hi hiVar = CREATOR;
        hi.a(this, dest, flags);
    }
}
