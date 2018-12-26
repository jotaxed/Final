package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class oh implements SafeParcelable {
    public static final oi CREATOR = new oi();
    public static final oh akf = new oh(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, Locale.ENGLISH, null);
    public final String akg;
    public final String akh;
    public final String aki;
    public final String akj;
    public final int versionCode;

    public oh(int i, String str, String str2, String str3, String str4) {
        this.versionCode = i;
        this.akg = str;
        this.akh = str2;
        this.aki = str3;
        this.akj = str4;
    }

    public oh(String str, Locale locale, String str2) {
        this(1, str, locale.toString(), str2, null);
    }

    public int describeContents() {
        oi oiVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof oh)) {
            return false;
        }
        oh ohVar = (oh) object;
        return this.akh.equals(ohVar.akh) && this.akg.equals(ohVar.akg) && jv.equal(this.aki, ohVar.aki) && jv.equal(this.akj, ohVar.akj);
    }

    public int hashCode() {
        return jv.hashCode(this.akg, this.akh, this.aki);
    }

    public String toString() {
        return jv.h(this).a("clientPackageName", this.akg).a("locale", this.akh).a("accountName", this.aki).a("gCoreClientName", this.akj).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        oi oiVar = CREATOR;
        oi.a(this, out, flags);
    }
}
