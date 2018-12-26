package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<e> {
    static void a(e eVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, eVar.agw);
        b.c(parcel, 1000, eVar.getVersionCode());
        b.c(parcel, 2, eVar.agx);
        b.a(parcel, 3, eVar.agy);
        b.H(parcel, H);
    }

    public e cK(Parcel parcel) {
        int i = 1;
        int G = a.G(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
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
            return new e(i2, i3, i, j);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cK(x0);
    }

    public e[] eE(int i) {
        return new e[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eE(x0);
    }
}
