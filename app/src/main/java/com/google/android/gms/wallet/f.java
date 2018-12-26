package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class f implements Creator<FullWallet> {
    static void a(FullWallet fullWallet, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, fullWallet.getVersionCode());
        b.a(parcel, 2, fullWallet.auL, false);
        b.a(parcel, 3, fullWallet.auM, false);
        b.a(parcel, 4, fullWallet.auN, i, false);
        b.a(parcel, 5, fullWallet.auO, false);
        b.a(parcel, 6, fullWallet.auP, i, false);
        b.a(parcel, 7, fullWallet.auQ, i, false);
        b.a(parcel, 8, fullWallet.auR, false);
        b.a(parcel, 9, fullWallet.auS, i, false);
        b.a(parcel, 10, fullWallet.auT, i, false);
        b.a(parcel, 11, fullWallet.auU, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dN(x0);
    }

    public FullWallet dN(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int G = a.G(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str3 = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    proxyCard = (ProxyCard) a.a(parcel, F, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = a.o(parcel, F);
                    break;
                case 6:
                    address2 = (Address) a.a(parcel, F, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) a.a(parcel, F, Address.CREATOR);
                    break;
                case 8:
                    strArr = a.A(parcel, F);
                    break;
                case 9:
                    userAddress2 = (UserAddress) a.a(parcel, F, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) a.a(parcel, F, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) a.b(parcel, F, InstrumentInfo.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public FullWallet[] fU(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fU(x0);
    }
}
