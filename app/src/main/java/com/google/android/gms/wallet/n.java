package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class n implements Creator<OfferWalletObject> {
    static void a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, offerWalletObject.getVersionCode());
        b.a(parcel, 2, offerWalletObject.fl, false);
        b.a(parcel, 3, offerWalletObject.avN, false);
        b.a(parcel, 4, offerWalletObject.avO, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dV(x0);
    }

    public OfferWalletObject dV(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
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
                    commonWalletObject = (CommonWalletObject) a.a(parcel, F, CommonWalletObject.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OfferWalletObject[] gc(int i) {
        return new OfferWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gc(x0);
    }
}
