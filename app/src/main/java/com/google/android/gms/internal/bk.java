package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class bk implements Creator<bj> {
    static void a(bj bjVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, bjVar.versionCode);
        b.c(parcel, 2, bjVar.oQ);
        b.c(parcel, 3, bjVar.backgroundColor);
        b.c(parcel, 4, bjVar.oR);
        b.c(parcel, 5, bjVar.oS);
        b.c(parcel, 6, bjVar.oT);
        b.c(parcel, 7, bjVar.oU);
        b.c(parcel, 8, bjVar.oV);
        b.c(parcel, 9, bjVar.oW);
        b.a(parcel, 10, bjVar.oX, false);
        b.c(parcel, 11, bjVar.oY);
        b.a(parcel, 12, bjVar.oZ, false);
        b.c(parcel, 13, bjVar.pa);
        b.c(parcel, 14, bjVar.pb);
        b.a(parcel, 15, bjVar.pc, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return d(x0);
    }

    public bj d(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    i3 = a.g(parcel, F);
                    break;
                case 4:
                    i4 = a.g(parcel, F);
                    break;
                case 5:
                    i5 = a.g(parcel, F);
                    break;
                case 6:
                    i6 = a.g(parcel, F);
                    break;
                case 7:
                    i7 = a.g(parcel, F);
                    break;
                case 8:
                    i8 = a.g(parcel, F);
                    break;
                case 9:
                    i9 = a.g(parcel, F);
                    break;
                case 10:
                    str = a.o(parcel, F);
                    break;
                case 11:
                    i10 = a.g(parcel, F);
                    break;
                case 12:
                    str2 = a.o(parcel, F);
                    break;
                case 13:
                    i11 = a.g(parcel, F);
                    break;
                case 14:
                    i12 = a.g(parcel, F);
                    break;
                case 15:
                    str3 = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new bj(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public bj[] i(int i) {
        return new bj[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return i(x0);
    }
}
