package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<WalletFragmentStyle> {
    static void a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, walletFragmentStyle.CK);
        b.a(parcel, 2, walletFragmentStyle.awy, false);
        b.c(parcel, 3, walletFragmentStyle.awz);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eb(x0);
    }

    public WalletFragmentStyle eb(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    bundle = a.q(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentStyle[] gj(int i) {
        return new WalletFragmentStyle[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gj(x0);
    }
}
