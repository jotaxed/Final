package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class nr implements Creator<nq> {
    static void a(nq nqVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, nqVar.nr());
        b.c(parcel, 1000, nqVar.CK);
        b.c(parcel, 2, nqVar.ahn, false);
        b.H(parcel, H);
    }

    public nq cO(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    z = a.c(parcel, F);
                    break;
                case 2:
                    list = a.c(parcel, F, oa.CREATOR);
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
            return new nq(i, z, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cO(x0);
    }

    public nq[] eK(int i) {
        return new nq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eK(x0);
    }
}
