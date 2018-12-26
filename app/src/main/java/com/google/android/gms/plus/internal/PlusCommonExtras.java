package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.jv;

public class PlusCommonExtras implements SafeParcelable {
    public static final f CREATOR = new f();
    public static String TAG = "PlusCommonExtras";
    private final int CK;
    private String anN;
    private String anO;

    public PlusCommonExtras() {
        this.CK = 1;
        this.anN = "";
        this.anO = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.CK = versionCode;
        this.anN = gpsrc;
        this.anO = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.CK == plusCommonExtras.CK && jv.equal(this.anN, plusCommonExtras.anN) && jv.equal(this.anO, plusCommonExtras.anO);
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.anN, this.anO);
    }

    public String ox() {
        return this.anN;
    }

    public String oy() {
        return this.anO;
    }

    public void q(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", c.a(this));
    }

    public String toString() {
        return jv.h(this).a("versionCode", Integer.valueOf(this.CK)).a("Gpsrc", this.anN).a("ClientCallingPackage", this.anO).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        f.a(this, out, flags);
    }
}
