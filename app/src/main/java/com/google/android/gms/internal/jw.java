package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.jg.a;
import java.util.List;

public class jw implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, aVar.getAccountName(), false);
        b.c(parcel, 1000, aVar.getVersionCode());
        b.b(parcel, 2, aVar.ho(), false);
        b.c(parcel, 3, aVar.hn());
        b.a(parcel, 4, aVar.hq(), false);
        b.H(parcel, H);
    }

    public a E(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 2:
                    list = com.google.android.gms.common.internal.safeparcel.a.C(parcel, F);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new a(i2, str2, list, i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public a[] aG(int i) {
        return new a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return E(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
