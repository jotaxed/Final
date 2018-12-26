package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dn implements Creator<do> {
    static void a(do doVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, doVar.versionCode);
        b.a(parcel, 2, doVar.rG, false);
        b.a(parcel, 3, doVar.rH, false);
        b.a(parcel, 4, doVar.mimeType, false);
        b.a(parcel, 5, doVar.packageName, false);
        b.a(parcel, 6, doVar.rI, false);
        b.a(parcel, 7, doVar.rJ, false);
        b.a(parcel, 8, doVar.rK, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return e(x0);
    }

    public do e(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str7 = a.o(parcel, F);
                    break;
                case 3:
                    str6 = a.o(parcel, F);
                    break;
                case 4:
                    str5 = a.o(parcel, F);
                    break;
                case 5:
                    str4 = a.o(parcel, F);
                    break;
                case 6:
                    str3 = a.o(parcel, F);
                    break;
                case 7:
                    str2 = a.o(parcel, F);
                    break;
                case 8:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new do(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public do[] m(int i) {
        return new do[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m(x0);
    }
}
