package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hs implements Creator<hr> {
    static void a(hr hrVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, hrVar.Dw, i, false);
        b.c(parcel, 1000, hrVar.CK);
        b.a(parcel, 2, hrVar.Dx);
        b.c(parcel, 3, hrVar.Dy);
        b.a(parcel, 4, hrVar.pc, false);
        b.a(parcel, 5, hrVar.Dz, i, false);
        b.H(parcel, H);
    }

    public hr[] S(int i) {
        return new hr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return S(x0);
    }

    public hr s(Parcel parcel) {
        int i = 0;
        hd hdVar = null;
        int G = a.G(parcel);
        long j = 0;
        String str = null;
        hf hfVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    hfVar = (hf) a.a(parcel, F, hf.CREATOR);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                case 5:
                    hdVar = (hd) a.a(parcel, F, hd.CREATOR);
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
            return new hr(i2, hfVar, j, i, str, hdVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
