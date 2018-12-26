package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hq implements Creator<hp> {
    static void a(hp hpVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, hpVar.name, false);
        b.c(parcel, 1000, hpVar.CK);
        b.a(parcel, 2, hpVar.Dh, false);
        b.a(parcel, 3, hpVar.Di);
        b.c(parcel, 4, hpVar.weight);
        b.a(parcel, 5, hpVar.Dj);
        b.a(parcel, 6, hpVar.Dk, false);
        b.a(parcel, 7, hpVar.Dl, i, false);
        b.a(parcel, 8, hpVar.Dm, false);
        b.a(parcel, 11, hpVar.Dn, false);
        b.H(parcel, H);
    }

    public hp[] R(int i) {
        return new hp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return R(x0);
    }

    public hp r(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = a.G(parcel);
        int i = 1;
        int[] iArr = null;
        hj[] hjVarArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str4 = a.o(parcel, F);
                    break;
                case 2:
                    str3 = a.o(parcel, F);
                    break;
                case 3:
                    z2 = a.c(parcel, F);
                    break;
                case 4:
                    i = a.g(parcel, F);
                    break;
                case 5:
                    z = a.c(parcel, F);
                    break;
                case 6:
                    str2 = a.o(parcel, F);
                    break;
                case 7:
                    hjVarArr = (hj[]) a.b(parcel, F, hj.CREATOR);
                    break;
                case 8:
                    iArr = a.u(parcel, F);
                    break;
                case 11:
                    str = a.o(parcel, F);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hp(i2, str4, str3, z2, i, z, str2, hjVarArr, iArr, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
