package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ik implements Creator<ij> {
    static void a(ij ijVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, ijVar.getVersionCode());
        b.a(parcel, 2, ijVar.fT(), false);
        b.H(parcel, H);
    }

    public ij[] ac(int i) {
        return new ij[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ac(x0);
    }

    public ij x(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ij(i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
