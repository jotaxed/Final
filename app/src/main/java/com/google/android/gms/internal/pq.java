package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.pi.f;
import java.util.HashSet;
import java.util.Set;

public class pq implements Creator<f> {
    static void a(f fVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = fVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, fVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, fVar.apP, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            b.a(parcel, 3, fVar.UO, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, fVar.aoK, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, fVar.apQ, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            b.a(parcel, 6, fVar.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, fVar.apR);
        }
        if (set.contains(Integer.valueOf(8))) {
            b.a(parcel, 8, fVar.apa, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            b.a(parcel, 9, fVar.OH, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            b.c(parcel, 10, fVar.Gt);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dG(x0);
    }

    public f dG(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = a.c(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public f[] fE(int i) {
        return new f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fE(x0);
    }
}
