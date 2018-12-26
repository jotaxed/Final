package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.kr.a;

public class kt implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, aVar.getVersionCode());
        b.c(parcel, 2, aVar.hI());
        b.a(parcel, 3, aVar.hO());
        b.c(parcel, 4, aVar.hJ());
        b.a(parcel, 5, aVar.hP());
        b.a(parcel, 6, aVar.hQ(), false);
        b.c(parcel, 7, aVar.hR());
        b.a(parcel, 8, aVar.hT(), false);
        b.a(parcel, 9, aVar.hV(), i, false);
        b.H(parcel, H);
    }

    public a M(Parcel parcel) {
        km kmVar = null;
        int i = 0;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 9:
                    kmVar = (km) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, km.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new a(i4, i3, z2, i2, z, str2, i, str, kmVar);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public a[] aN(int i) {
        return new a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aN(x0);
    }
}
