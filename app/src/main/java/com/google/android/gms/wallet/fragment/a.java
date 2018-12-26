package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class a implements Creator<WalletFragmentInitParams> {
    static void a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, walletFragmentInitParams.CK);
        b.a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        b.a(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        b.c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        b.a(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dZ(x0);
    }

    public WalletFragmentInitParams dZ(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 3:
                    maskedWalletRequest = (MaskedWalletRequest) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, MaskedWallet.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentInitParams[] gh(int i) {
        return new WalletFragmentInitParams[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gh(x0);
    }
}
