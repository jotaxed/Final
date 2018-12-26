package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

public class a implements Creator<UserAddressRequest> {
    static void a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, userAddressRequest.getVersionCode());
        b.c(parcel, 2, userAddressRequest.afH, false);
        b.H(parcel, H);
    }

    public UserAddressRequest cF(Parcel parcel) {
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, CountrySpecification.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserAddressRequest(i, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cF(x0);
    }

    public UserAddressRequest[] es(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return es(x0);
    }
}
