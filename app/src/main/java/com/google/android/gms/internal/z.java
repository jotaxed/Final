package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class z implements Creator<y> {
    static void a(y yVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, yVar.versionCode);
        b.a(parcel, 2, yVar.mi);
        b.a(parcel, 3, yVar.ms);
        b.H(parcel, H);
    }

    public y a(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    z2 = a.c(parcel, F);
                    break;
                case 3:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new y(i, z2, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public y[] b(int i) {
        return new y[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return b(x0);
    }
}
