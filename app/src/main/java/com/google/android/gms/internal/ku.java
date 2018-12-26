package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.kr.a;
import com.google.android.gms.internal.kv.b;

public class ku implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, bVar.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, bVar.fv, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, bVar.NZ, i, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public b N(Parcel parcel) {
        a aVar = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 3:
                    aVar = (a) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, a.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new b(i, str, aVar);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public b[] aO(int i) {
        return new b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aO(x0);
    }
}
