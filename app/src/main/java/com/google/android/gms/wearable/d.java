package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<c> {
    static void a(c cVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, cVar.CK);
        b.a(parcel, 2, cVar.getName(), false);
        b.a(parcel, 3, cVar.getAddress(), false);
        b.c(parcel, 4, cVar.getType());
        b.c(parcel, 5, cVar.getRole());
        b.a(parcel, 6, cVar.isEnabled());
        b.a(parcel, 7, cVar.isConnected());
        b.a(parcel, 8, cVar.rj(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return em(x0);
    }

    public c em(Parcel parcel) {
        String str = null;
        boolean z = false;
        int G = a.G(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    str3 = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    i = a.g(parcel, F);
                    break;
                case 6:
                    z2 = a.c(parcel, F);
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
            return new c(i3, str3, str2, i2, i, z2, z, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public c[] gv(int i) {
        return new c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gv(x0);
    }
}
