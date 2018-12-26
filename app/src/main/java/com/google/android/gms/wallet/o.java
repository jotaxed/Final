package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o implements Creator<ProxyCard> {
    static void a(ProxyCard proxyCard, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, proxyCard.getVersionCode());
        b.a(parcel, 2, proxyCard.avP, false);
        b.a(parcel, 3, proxyCard.avQ, false);
        b.c(parcel, 4, proxyCard.avR);
        b.c(parcel, 5, proxyCard.avS);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dW(x0);
    }

    public ProxyCard dW(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = a.G(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ProxyCard[] gd(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gd(x0);
    }
}
