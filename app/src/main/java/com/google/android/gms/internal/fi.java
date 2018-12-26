package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class fi implements Creator<fh> {
    static void a(fh fhVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, fhVar.versionCode);
        b.a(parcel, 2, fhVar.tK, false);
        b.a(parcel, 3, fhVar.tL, i, false);
        b.a(parcel, 4, fhVar.lS, i, false);
        b.a(parcel, 5, fhVar.lL, false);
        b.a(parcel, 6, fhVar.applicationInfo, i, false);
        b.a(parcel, 7, fhVar.tM, i, false);
        b.a(parcel, 8, fhVar.tN, false);
        b.a(parcel, 9, fhVar.tO, false);
        b.a(parcel, 10, fhVar.tP, false);
        b.a(parcel, 11, fhVar.lO, i, false);
        b.a(parcel, 12, fhVar.tQ, false);
        b.c(parcel, 13, fhVar.tR);
        b.b(parcel, 14, fhVar.mc, false);
        b.a(parcel, 15, fhVar.tS, false);
        b.a(parcel, 16, fhVar.tT);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return h(x0);
    }

    public fh h(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        Bundle bundle = null;
        av avVar = null;
        ay ayVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        gs gsVar = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    bundle = a.q(parcel, F);
                    break;
                case 3:
                    avVar = (av) a.a(parcel, F, av.CREATOR);
                    break;
                case 4:
                    ayVar = (ay) a.a(parcel, F, ay.CREATOR);
                    break;
                case 5:
                    str = a.o(parcel, F);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) a.a(parcel, F, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) a.a(parcel, F, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = a.o(parcel, F);
                    break;
                case 9:
                    str3 = a.o(parcel, F);
                    break;
                case 10:
                    str4 = a.o(parcel, F);
                    break;
                case 11:
                    gsVar = (gs) a.a(parcel, F, gs.CREATOR);
                    break;
                case 12:
                    bundle2 = a.q(parcel, F);
                    break;
                case 13:
                    i2 = a.g(parcel, F);
                    break;
                case 14:
                    list = a.C(parcel, F);
                    break;
                case 15:
                    bundle3 = a.q(parcel, F);
                    break;
                case 16:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new fh(i, bundle, avVar, ayVar, str, applicationInfo, packageInfo, str2, str3, str4, gsVar, bundle2, i2, list, bundle3, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return q(x0);
    }

    public fh[] q(int i) {
        return new fh[i];
    }
}
