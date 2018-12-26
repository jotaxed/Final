package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.pi.c;
import com.google.android.gms.internal.pi.d;
import com.google.android.gms.internal.pi.f;
import com.google.android.gms.internal.pi.g;
import com.google.android.gms.internal.pi.h;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pj implements Creator<pi> {
    static void a(pi piVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = piVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, piVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, piVar.apl, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            b.a(parcel, 3, piVar.apm, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, piVar.apn, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, piVar.apo, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            b.c(parcel, 6, piVar.app);
        }
        if (set.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, piVar.apq, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            b.a(parcel, 8, piVar.apr, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            b.a(parcel, 9, piVar.OS, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            b.c(parcel, 12, piVar.ow);
        }
        if (set.contains(Integer.valueOf(14))) {
            b.a(parcel, 14, piVar.CE, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            b.a(parcel, 15, piVar.aps, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            b.a(parcel, 16, piVar.apt);
        }
        if (set.contains(Integer.valueOf(19))) {
            b.a(parcel, 19, piVar.apu, i, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            b.a(parcel, 18, piVar.FR, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            b.c(parcel, 21, piVar.apw);
        }
        if (set.contains(Integer.valueOf(20))) {
            b.a(parcel, 20, piVar.apv, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            b.c(parcel, 23, piVar.apy, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            b.c(parcel, 22, piVar.apx, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            b.c(parcel, 25, piVar.apA);
        }
        if (set.contains(Integer.valueOf(24))) {
            b.c(parcel, 24, piVar.apz);
        }
        if (set.contains(Integer.valueOf(27))) {
            b.a(parcel, 27, piVar.vf, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            b.a(parcel, 26, piVar.apB, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            b.a(parcel, 29, piVar.apD);
        }
        if (set.contains(Integer.valueOf(28))) {
            b.c(parcel, 28, piVar.apC, true);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dz(x0);
    }

    public pi dz(Parcel parcel) {
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        pi.a aVar = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        pi.b bVar = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        c cVar = null;
        boolean z = false;
        String str7 = null;
        d dVar = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    pi.a aVar2 = (pi.a) a.a(parcel, F, pi.a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    aVar = aVar2;
                    break;
                case 4:
                    str2 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    pi.b bVar2 = (pi.b) a.a(parcel, F, pi.b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    bVar = bVar2;
                    break;
                case 8:
                    str4 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    c cVar2 = (c) a.a(parcel, F, c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    cVar = cVar2;
                    break;
                case 16:
                    z = a.c(parcel, F);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    d dVar2 = (d) a.a(parcel, F, (Creator) d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    dVar = dVar2;
                    break;
                case 20:
                    str8 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = a.c(parcel, F, f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = a.c(parcel, F, g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = a.c(parcel, F, h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = a.c(parcel, F);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pi(hashSet, i, str, aVar, str2, str3, i2, bVar, str4, str5, i3, str6, cVar, z, str7, dVar, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public pi[] fx(int i) {
        return new pi[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fx(x0);
    }
}
