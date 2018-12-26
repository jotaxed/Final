package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<d> {
    static void a(d dVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, dVar.getVersionCode());
        b.a(parcel, 2, dVar.auJ, i, false);
        b.a(parcel, 3, dVar.auK, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dM(x0);
    }

    public d dM(Parcel parcel) {
        OfferWalletObject offerWalletObject = null;
        int G = a.G(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < G) {
            LoyaltyWalletObject loyaltyWalletObject2;
            int g;
            OfferWalletObject offerWalletObject2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = a.g(parcel, F);
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case 2:
                    g = i;
                    LoyaltyWalletObject loyaltyWalletObject3 = (LoyaltyWalletObject) a.a(parcel, F, LoyaltyWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject3;
                    break;
                case 3:
                    offerWalletObject2 = (OfferWalletObject) a.a(parcel, F, OfferWalletObject.CREATOR);
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
            }
            i = g;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
        }
        if (parcel.dataPosition() == G) {
            return new d(i, loyaltyWalletObject, offerWalletObject);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public d[] fT(int i) {
        return new d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fT(x0);
    }
}
