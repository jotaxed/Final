package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public final class a implements SafeParcelable {
    public static final Creator<a> CREATOR = new b();
    public static final a TT = new a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    private final int CK;
    private final String CS;
    private final String TU;
    private final String TV;

    a(int i, String str, String str2, String str3) {
        this.CK = i;
        this.CS = (String) jx.i(str);
        this.TU = "";
        this.TV = str3;
    }

    public a(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    private boolean a(a aVar) {
        return this.CS.equals(aVar.CS) && jv.equal(this.TU, aVar.TU) && jv.equal(this.TV, aVar.TV);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof a) && a((a) that));
    }

    public String getPackageName() {
        return this.CS;
    }

    public String getVersion() {
        return this.TU;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.CS, this.TU, this.TV);
    }

    public String jk() {
        return this.TV;
    }

    a jl() {
        return new a(mg.bw(this.CS), mg.bw(this.TU), mg.bw(this.TV));
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.CS, this.TU, this.TV});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        b.a(this, parcel, flags);
    }
}
