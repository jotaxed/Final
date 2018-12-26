package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<WalletFragmentOptions> {
    static void a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, walletFragmentOptions.CK);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 2, walletFragmentOptions.getEnvironment());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, walletFragmentOptions.getTheme());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 5, walletFragmentOptions.getMode());
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ea(x0);
    }

    public WalletFragmentOptions ea(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int G = a.G(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i4 = a.g(parcel, F);
                    break;
                case 2:
                    i3 = a.g(parcel, F);
                    break;
                case 3:
                    i2 = a.g(parcel, F);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) a.a(parcel, F, WalletFragmentStyle.CREATOR);
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
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentOptions[] gi(int i) {
        return new WalletFragmentOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gi(x0);
    }
}
