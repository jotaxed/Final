package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<f> {
    static void a(f fVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, fVar.getVersionCode());
        b.a(parcel, 2, fVar.label, false);
        b.a(parcel, 3, fVar.awM, i, false);
        b.a(parcel, 4, fVar.type, false);
        b.a(parcel, 5, fVar.avm, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eg(x0);
    }

    public f eg(Parcel parcel) {
        l lVar = null;
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        g gVar = null;
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
                    gVar = (g) a.a(parcel, F, g.CREATOR);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                case 5:
                    lVar = (l) a.a(parcel, F, l.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new f(i, str2, gVar, str, lVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public f[] gp(int i) {
        return new f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gp(x0);
    }
}
