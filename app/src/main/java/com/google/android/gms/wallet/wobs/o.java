package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o implements Creator<n> {
    static void a(n nVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, nVar.getVersionCode());
        b.a(parcel, 2, nVar.awW, false);
        b.a(parcel, 3, nVar.description, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ej(x0);
    }

    public n ej(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
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
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new n(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public n[] gs(int i) {
        return new n[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gs(x0);
    }
}
