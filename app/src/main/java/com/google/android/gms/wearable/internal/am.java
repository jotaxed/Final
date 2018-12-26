package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class am implements Creator<al> {
    static void a(al alVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, alVar.CK);
        b.a(parcel, 2, alVar.getId(), false);
        b.a(parcel, 3, alVar.getDisplayName(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ez(x0);
    }

    public al ez(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
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
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new al(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public al[] gI(int i) {
        return new al[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gI(x0);
    }
}
