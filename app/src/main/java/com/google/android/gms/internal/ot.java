package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ot implements Creator<or> {
    static void a(or orVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, orVar.versionCode);
        b.a(parcel, 2, orVar.amW);
        b.a(parcel, 3, orVar.tag, false);
        b.a(parcel, 4, orVar.amX, false);
        b.a(parcel, 5, orVar.amY, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dt(x0);
    }

    public or dt(Parcel parcel) {
        Bundle bundle = null;
        int G = a.G(parcel);
        int i = 0;
        long j = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    bArr = a.r(parcel, F);
                    break;
                case 5:
                    bundle = a.q(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new or(i, j, str, bArr, bundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public or[] fq(int i) {
        return new or[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fq(x0);
    }
}
