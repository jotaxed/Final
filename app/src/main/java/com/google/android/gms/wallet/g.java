package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<FullWalletRequest> {
    static void a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, fullWalletRequest.getVersionCode());
        b.a(parcel, 2, fullWalletRequest.auL, false);
        b.a(parcel, 3, fullWalletRequest.auM, false);
        b.a(parcel, 4, fullWalletRequest.auV, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dO(x0);
    }

    public FullWalletRequest dO(Parcel parcel) {
        Cart cart = null;
        int G = a.G(parcel);
        int i = 0;
        String str = null;
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
                    cart = (Cart) a.a(parcel, F, Cart.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public FullWalletRequest[] fV(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fV(x0);
    }
}
