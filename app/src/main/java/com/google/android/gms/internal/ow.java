package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ow implements Creator<ov> {
    static void a(ov ovVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, ovVar.versionCode);
        b.a(parcel, 2, ovVar.packageName, false);
        b.c(parcel, 3, ovVar.ang);
        b.c(parcel, 4, ovVar.anh);
        b.a(parcel, 5, ovVar.ani, false);
        b.a(parcel, 6, ovVar.anj, false);
        b.a(parcel, 7, ovVar.ank);
        b.a(parcel, 8, ovVar.anl, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return du(x0);
    }

    public ov du(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = a.G(parcel);
        boolean z = true;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    str4 = a.o(parcel, F);
                    break;
                case 3:
                    i2 = a.g(parcel, F);
                    break;
                case 4:
                    i = a.g(parcel, F);
                    break;
                case 5:
                    str3 = a.o(parcel, F);
                    break;
                case 6:
                    str2 = a.o(parcel, F);
                    break;
                case 7:
                    z = a.c(parcel, F);
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
            return new ov(i3, str4, i2, i, str3, str2, z, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ov[] fr(int i) {
        return new ov[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fr(x0);
    }
}
