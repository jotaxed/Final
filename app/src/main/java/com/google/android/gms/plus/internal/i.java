package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<h> {
    static void a(h hVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, hVar.getAccountName(), false);
        b.c(parcel, 1000, hVar.getVersionCode());
        b.a(parcel, 2, hVar.oz(), false);
        b.a(parcel, 3, hVar.oA(), false);
        b.a(parcel, 4, hVar.oB(), false);
        b.a(parcel, 5, hVar.oC(), false);
        b.a(parcel, 6, hVar.oD(), false);
        b.a(parcel, 7, hVar.oE(), false);
        b.a(parcel, 8, hVar.oF(), false);
        b.a(parcel, 9, hVar.oG(), i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dw(x0);
    }

    public h dw(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str5 = a.o(parcel, F);
                    break;
                case 2:
                    strArr3 = a.A(parcel, F);
                    break;
                case 3:
                    strArr2 = a.A(parcel, F);
                    break;
                case 4:
                    strArr = a.A(parcel, F);
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
                case 9:
                    plusCommonExtras = (PlusCommonExtras) a.a(parcel, F, PlusCommonExtras.CREATOR);
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
            return new h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public h[] fu(int i) {
        return new h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fu(x0);
    }
}
