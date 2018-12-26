package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class nv implements Creator<nu> {
    static void a(nu nuVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, nuVar.ahn, false);
        b.c(parcel, 1000, nuVar.CK);
        b.a(parcel, 2, nuVar.nu(), false);
        b.a(parcel, 3, nuVar.nv());
        b.c(parcel, 4, nuVar.aht, false);
        b.b(parcel, 6, nuVar.ahu, false);
        b.H(parcel, H);
    }

    public nu cQ(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = a.G(parcel);
        List list2 = null;
        String str = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list3 = a.c(parcel, F, oa.CREATOR);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    z = a.c(parcel, F);
                    break;
                case 4:
                    list2 = a.c(parcel, F, oe.CREATOR);
                    break;
                case 6:
                    list = a.C(parcel, F);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new nu(i, list3, str, z, list2, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cQ(x0);
    }

    public nu[] eM(int i) {
        return new nu[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eM(x0);
    }
}
