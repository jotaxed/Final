package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gt implements Creator<gs> {
    static void a(gs gsVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, gsVar.versionCode);
        b.a(parcel, 2, gsVar.wS, false);
        b.c(parcel, 3, gsVar.wT);
        b.c(parcel, 4, gsVar.wU);
        b.a(parcel, 5, gsVar.wV);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return j(x0);
    }

    public gs j(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    i2 = a.g(parcel, F);
                    break;
                case 4:
                    i = a.g(parcel, F);
                    break;
                case 5:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new gs(i3, str, i2, i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return w(x0);
    }

    public gs[] w(int i) {
        return new gs[i];
    }
}
