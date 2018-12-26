package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class az implements Creator<ay> {
    static void a(ay ayVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, ayVar.versionCode);
        b.a(parcel, 2, ayVar.op, false);
        b.c(parcel, 3, ayVar.height);
        b.c(parcel, 4, ayVar.heightPixels);
        b.a(parcel, 5, ayVar.oq);
        b.c(parcel, 6, ayVar.width);
        b.c(parcel, 7, ayVar.widthPixels);
        b.a(parcel, 8, ayVar.or, i, false);
        b.H(parcel, H);
    }

    public ay c(Parcel parcel) {
        ay[] ayVarArr = null;
        int i = 0;
        int G = a.G(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i5 = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    i4 = a.g(parcel, F);
                    break;
                case 4:
                    i3 = a.g(parcel, F);
                    break;
                case 5:
                    z = a.c(parcel, F);
                    break;
                case 6:
                    i2 = a.g(parcel, F);
                    break;
                case 7:
                    i = a.g(parcel, F);
                    break;
                case 8:
                    ayVarArr = (ay[]) a.b(parcel, F, ay.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ay(i5, str, i4, i3, z, i2, i, ayVarArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return c(x0);
    }

    public ay[] g(int i) {
        return new ay[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return g(x0);
    }
}
