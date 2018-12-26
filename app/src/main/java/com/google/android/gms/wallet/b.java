package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public class b implements Creator<Cart> {
    static void a(Cart cart, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, cart.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, cart.auF, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, cart.auG, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, cart.auH, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dK(x0);
    }

    public Cart dK(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                    arrayList = a.c(parcel, F, LineItem.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Cart[] fR(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fR(x0);
    }
}
