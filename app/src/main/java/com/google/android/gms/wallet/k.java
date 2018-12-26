package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class k implements Creator<MaskedWallet> {
    static void a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, maskedWallet.getVersionCode());
        b.a(parcel, 2, maskedWallet.auL, false);
        b.a(parcel, 3, maskedWallet.auM, false);
        b.a(parcel, 4, maskedWallet.auR, false);
        b.a(parcel, 5, maskedWallet.auO, false);
        b.a(parcel, 6, maskedWallet.auP, i, false);
        b.a(parcel, 7, maskedWallet.auQ, i, false);
        b.a(parcel, 8, maskedWallet.avw, i, false);
        b.a(parcel, 9, maskedWallet.avx, i, false);
        b.a(parcel, 10, maskedWallet.auS, i, false);
        b.a(parcel, 11, maskedWallet.auT, i, false);
        b.a(parcel, 12, maskedWallet.auU, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dS(x0);
    }

    public MaskedWallet dS(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    strArr = a.A(parcel, F);
                    break;
                case 5:
                    str3 = a.o(parcel, F);
                    break;
                case 6:
                    address = (Address) a.a(parcel, F, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) a.a(parcel, F, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) a.b(parcel, F, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) a.b(parcel, F, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) a.a(parcel, F, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) a.a(parcel, F, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) a.b(parcel, F, InstrumentInfo.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public MaskedWallet[] fZ(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fZ(x0);
    }
}
