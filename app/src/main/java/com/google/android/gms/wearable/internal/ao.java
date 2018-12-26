package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ao implements Creator<an> {
    static void a(an anVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, anVar.versionCode);
        b.a(parcel, 2, anVar.packageName, false);
        b.a(parcel, 3, anVar.label, false);
        b.a(parcel, 4, anVar.ayc);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eA(x0);
    }

    public an eA(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        long j = 0;
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
                    j = a.i(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new an(i, str2, str, j);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public an[] gJ(int i) {
        return new an[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gJ(x0);
    }
}
