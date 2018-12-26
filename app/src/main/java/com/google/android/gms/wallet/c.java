package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<CountrySpecification> {
    static void a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, countrySpecification.getVersionCode());
        b.a(parcel, 2, countrySpecification.vk, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dL(x0);
    }

    public CountrySpecification dL(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CountrySpecification(i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CountrySpecification[] fS(int i) {
        return new CountrySpecification[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fS(x0);
    }
}
