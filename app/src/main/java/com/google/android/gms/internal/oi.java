package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class oi implements Creator<oh> {
    static void a(oh ohVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, ohVar.akg, false);
        b.c(parcel, 1000, ohVar.versionCode);
        b.a(parcel, 2, ohVar.akh, false);
        b.a(parcel, 3, ohVar.aki, false);
        b.a(parcel, 4, ohVar.akj, false);
        b.H(parcel, H);
    }

    public oh cW(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str4 = a.o(parcel, F);
                    break;
                case 2:
                    str3 = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
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
            return new oh(i, str4, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cW(x0);
    }

    public oh[] eS(int i) {
        return new oh[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eS(x0);
    }
}
