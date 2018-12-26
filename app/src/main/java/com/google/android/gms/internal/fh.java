package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@ey
public final class fh implements SafeParcelable {
    public static final fi CREATOR = new fi();
    public final ApplicationInfo applicationInfo;
    public final String lL;
    public final gs lO;
    public final ay lS;
    public final List<String> mc;
    public final Bundle tK;
    public final av tL;
    public final PackageInfo tM;
    public final String tN;
    public final String tO;
    public final String tP;
    public final Bundle tQ;
    public final int tR;
    public final Bundle tS;
    public final boolean tT;
    public final int versionCode;

    @ey
    public static final class a {
        public final ApplicationInfo applicationInfo;
        public final String lL;
        public final gs lO;
        public final ay lS;
        public final List<String> mc;
        public final Bundle tK;
        public final av tL;
        public final PackageInfo tM;
        public final String tO;
        public final String tP;
        public final Bundle tQ;
        public final int tR;
        public final Bundle tS;
        public final boolean tT;

        public a(Bundle bundle, av avVar, ay ayVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, gs gsVar, Bundle bundle2, List<String> list, Bundle bundle3, boolean z) {
            this.tK = bundle;
            this.tL = avVar;
            this.lS = ayVar;
            this.lL = str;
            this.applicationInfo = applicationInfo;
            this.tM = packageInfo;
            this.tO = str2;
            this.tP = str3;
            this.lO = gsVar;
            this.tQ = bundle2;
            this.tT = z;
            if (list == null || list.size() <= 0) {
                this.tR = 0;
                this.mc = null;
            } else {
                this.tR = 2;
                this.mc = list;
            }
            this.tS = bundle3;
        }
    }

    fh(int i, Bundle bundle, av avVar, ay ayVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, gs gsVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z) {
        this.versionCode = i;
        this.tK = bundle;
        this.tL = avVar;
        this.lS = ayVar;
        this.lL = str;
        this.applicationInfo = applicationInfo;
        this.tM = packageInfo;
        this.tN = str2;
        this.tO = str3;
        this.tP = str4;
        this.lO = gsVar;
        this.tQ = bundle2;
        this.tR = i2;
        this.mc = list;
        this.tS = bundle3;
        this.tT = z;
    }

    public fh(Bundle bundle, av avVar, ay ayVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, gs gsVar, Bundle bundle2, int i, List<String> list, Bundle bundle3, boolean z) {
        this(4, bundle, avVar, ayVar, str, applicationInfo, packageInfo, str2, str3, str4, gsVar, bundle2, i, list, bundle3, z);
    }

    public fh(a aVar, String str) {
        this(aVar.tK, aVar.tL, aVar.lS, aVar.lL, aVar.applicationInfo, aVar.tM, str, aVar.tO, aVar.tP, aVar.lO, aVar.tQ, aVar.tR, aVar.mc, aVar.tS, aVar.tT);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        fi.a(this, out, flags);
    }
}
