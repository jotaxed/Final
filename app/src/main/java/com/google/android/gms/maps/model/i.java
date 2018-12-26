package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<LatLng> {
    static void a(LatLng latLng, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, latLng.getVersionCode());
        b.a(parcel, 2, latLng.latitude);
        b.a(parcel, 3, latLng.longitude);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return de(x0);
    }

    public LatLng de(Parcel parcel) {
        double d = 0.0d;
        int G = a.G(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    d2 = a.m(parcel, F);
                    break;
                case 3:
                    d = a.m(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LatLng(i, d2, d);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public LatLng[] fa(int i) {
        return new LatLng[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fa(x0);
    }
}
