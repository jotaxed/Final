package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class z implements Creator<y> {
    static void a(y yVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, yVar.getName(), false);
        b.c(parcel, 1000, yVar.getVersionCode());
        b.a(parcel, 2, yVar.getIdentifier(), false);
        b.H(parcel, H);
    }

    public y bW(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str2 = a.o(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
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
            return new y(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bW(x0);
    }

    public y[] dr(int i) {
        return new y[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dr(x0);
    }
}
