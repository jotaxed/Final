package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class l implements Creator<MaskedWalletRequest> {
    static void a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, maskedWalletRequest.getVersionCode());
        b.a(parcel, 2, maskedWalletRequest.auM, false);
        b.a(parcel, 3, maskedWalletRequest.avz);
        b.a(parcel, 4, maskedWalletRequest.avA);
        b.a(parcel, 5, maskedWalletRequest.avB);
        b.a(parcel, 6, maskedWalletRequest.avC, false);
        b.a(parcel, 7, maskedWalletRequest.auG, false);
        b.a(parcel, 8, maskedWalletRequest.avD, false);
        b.a(parcel, 9, maskedWalletRequest.auV, i, false);
        b.a(parcel, 10, maskedWalletRequest.avE);
        b.a(parcel, 11, maskedWalletRequest.avF);
        b.a(parcel, 12, maskedWalletRequest.avG, i, false);
        b.a(parcel, 13, maskedWalletRequest.avH);
        b.a(parcel, 14, maskedWalletRequest.avI);
        b.c(parcel, 15, maskedWalletRequest.avJ, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dT(x0);
    }

    public MaskedWalletRequest dT(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = a.c(parcel, F);
                    break;
                case 4:
                    z2 = a.c(parcel, F);
                    break;
                case 5:
                    z3 = a.c(parcel, F);
                    break;
                case 6:
                    str2 = a.o(parcel, F);
                    break;
                case 7:
                    str3 = a.o(parcel, F);
                    break;
                case 8:
                    str4 = a.o(parcel, F);
                    break;
                case 9:
                    cart = (Cart) a.a(parcel, F, Cart.CREATOR);
                    break;
                case 10:
                    z4 = a.c(parcel, F);
                    break;
                case 11:
                    z5 = a.c(parcel, F);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) a.b(parcel, F, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = a.c(parcel, F);
                    break;
                case 14:
                    z7 = a.c(parcel, F);
                    break;
                case 15:
                    arrayList = a.c(parcel, F, CountrySpecification.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public MaskedWalletRequest[] ga(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ga(x0);
    }
}
