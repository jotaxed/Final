package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.Arrays;

public class h implements SafeParcelable {
    public static final i CREATOR = new i();
    private final int CK;
    private final String DZ;
    private final String[] anQ;
    private final String[] anR;
    private final String[] anS;
    private final String anT;
    private final String anU;
    private final String anV;
    private final String anW;
    private final PlusCommonExtras anX;

    h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.CK = i;
        this.DZ = str;
        this.anQ = strArr;
        this.anR = strArr2;
        this.anS = strArr3;
        this.anT = str2;
        this.anU = str3;
        this.anV = str4;
        this.anW = str5;
        this.anX = plusCommonExtras;
    }

    public h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.CK = 1;
        this.DZ = str;
        this.anQ = strArr;
        this.anR = strArr2;
        this.anS = strArr3;
        this.anT = str2;
        this.anU = str3;
        this.anV = str4;
        this.anW = null;
        this.anX = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.CK == hVar.CK && jv.equal(this.DZ, hVar.DZ) && Arrays.equals(this.anQ, hVar.anQ) && Arrays.equals(this.anR, hVar.anR) && Arrays.equals(this.anS, hVar.anS) && jv.equal(this.anT, hVar.anT) && jv.equal(this.anU, hVar.anU) && jv.equal(this.anV, hVar.anV) && jv.equal(this.anW, hVar.anW) && jv.equal(this.anX, hVar.anX);
    }

    public String getAccountName() {
        return this.DZ;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.DZ, this.anQ, this.anR, this.anS, this.anT, this.anU, this.anV, this.anW, this.anX);
    }

    public String[] oA() {
        return this.anR;
    }

    public String[] oB() {
        return this.anS;
    }

    public String oC() {
        return this.anT;
    }

    public String oD() {
        return this.anU;
    }

    public String oE() {
        return this.anV;
    }

    public String oF() {
        return this.anW;
    }

    public PlusCommonExtras oG() {
        return this.anX;
    }

    public Bundle oH() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.anX.q(bundle);
        return bundle;
    }

    public String[] oz() {
        return this.anQ;
    }

    public String toString() {
        return jv.h(this).a("versionCode", Integer.valueOf(this.CK)).a("accountName", this.DZ).a("requestedScopes", this.anQ).a("visibleActivities", this.anR).a("requiredFeatures", this.anS).a("packageNameForAuth", this.anT).a("callingPackageName", this.anU).a("applicationName", this.anV).a("extra", this.anX.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        i.a(this, out, flags);
    }
}
