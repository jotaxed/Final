package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

public class e implements Creator<d> {
    static void a(d dVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, dVar.getVersionCode());
        b.a(parcel, 2, dVar.awJ, false);
        b.a(parcel, 3, dVar.awK, false);
        b.c(parcel, 4, dVar.awL, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ee(x0);
    }

    public d ee(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        ArrayList ie = la.ie();
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    ie = a.c(parcel, F, b.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new d(i, str2, str, ie);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public d[] gn(int i) {
        return new d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gn(x0);
    }
}
