package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m implements Creator<l> {
    static void a(l lVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, lVar.getVersionCode());
        b.a(parcel, 2, lVar.awU);
        b.a(parcel, 3, lVar.awV);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ei(x0);
    }

    public l ei(Parcel parcel) {
        long j = 0;
        int G = a.G(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    j2 = a.i(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new l(i, j2, j);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public l[] gr(int i) {
        return new l[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gr(x0);
    }
}
