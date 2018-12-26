package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<CountrySpecification> {
    static void a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, countrySpecification.getVersionCode());
        b.a(parcel, 2, countrySpecification.vk, false);
        b.H(parcel, H);
    }

    public CountrySpecification cG(Parcel parcel) {
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
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
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CountrySpecification(i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cG(x0);
    }

    public CountrySpecification[] et(int i) {
        return new CountrySpecification[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return et(x0);
    }
}
