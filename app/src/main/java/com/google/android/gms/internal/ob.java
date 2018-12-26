package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ob implements Creator<oa> {
    static void a(oa oaVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, oaVar.vc, false);
        b.c(parcel, 1000, oaVar.CK);
        b.H(parcel, H);
    }

    public oa cT(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
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
            return new oa(i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cT(x0);
    }

    public oa[] eP(int i) {
        return new oa[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eP(x0);
    }
}
