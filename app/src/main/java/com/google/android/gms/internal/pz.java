package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class pz implements Creator<py> {
    static void a(py pyVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, pyVar.getVersionCode());
        b.a(parcel, 2, pyVar.avY, false);
        b.a(parcel, 3, pyVar.avZ, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dY(x0);
    }

    public py dY(Parcel parcel) {
        String[] strArr = null;
        int G = a.G(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    strArr = a.A(parcel, F);
                    break;
                case 3:
                    bArr = a.s(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new py(i, strArr, bArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public py[] gf(int i) {
        return new py[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gf(x0);
    }
}
