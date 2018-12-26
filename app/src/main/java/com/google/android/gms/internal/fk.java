package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class fk implements Creator<fj> {
    static void a(fj fjVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, fjVar.versionCode);
        b.a(parcel, 2, fjVar.sg, false);
        b.a(parcel, 3, fjVar.tU, false);
        b.b(parcel, 4, fjVar.qw, false);
        b.c(parcel, 5, fjVar.errorCode);
        b.b(parcel, 6, fjVar.qx, false);
        b.a(parcel, 7, fjVar.tV);
        b.a(parcel, 8, fjVar.tW);
        b.a(parcel, 9, fjVar.tX);
        b.b(parcel, 10, fjVar.tY, false);
        b.a(parcel, 11, fjVar.qA);
        b.c(parcel, 12, fjVar.orientation);
        b.a(parcel, 13, fjVar.tZ, false);
        b.a(parcel, 14, fjVar.ua);
        b.a(parcel, 15, fjVar.ub, false);
        b.a(parcel, 19, fjVar.ud, false);
        b.a(parcel, 18, fjVar.uc);
        b.a(parcel, 21, fjVar.ue, false);
        b.a(parcel, 23, fjVar.ug);
        b.a(parcel, 22, fjVar.uf);
        b.a(parcel, 25, fjVar.uh);
        b.a(parcel, 24, fjVar.tT);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return i(x0);
    }

    public fj i(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    list = a.C(parcel, F);
                    break;
                case 5:
                    i2 = a.g(parcel, F);
                    break;
                case 6:
                    list2 = a.C(parcel, F);
                    break;
                case 7:
                    j = a.i(parcel, F);
                    break;
                case 8:
                    z = a.c(parcel, F);
                    break;
                case 9:
                    j2 = a.i(parcel, F);
                    break;
                case 10:
                    list3 = a.C(parcel, F);
                    break;
                case 11:
                    j3 = a.i(parcel, F);
                    break;
                case 12:
                    i3 = a.g(parcel, F);
                    break;
                case 13:
                    str3 = a.o(parcel, F);
                    break;
                case 14:
                    j4 = a.i(parcel, F);
                    break;
                case 15:
                    str4 = a.o(parcel, F);
                    break;
                case 18:
                    z2 = a.c(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str5 = a.o(parcel, F);
                    break;
                case 21:
                    str6 = a.o(parcel, F);
                    break;
                case 22:
                    z3 = a.c(parcel, F);
                    break;
                case 23:
                    z4 = a.c(parcel, F);
                    break;
                case 24:
                    z5 = a.c(parcel, F);
                    break;
                case 25:
                    z6 = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new fj(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return r(x0);
    }

    public fj[] r(int i) {
        return new fj[i];
    }
}
