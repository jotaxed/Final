package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class t implements Creator<StreetViewPanoramaOrientation> {
    static void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, streetViewPanoramaOrientation.getVersionCode());
        b.a(parcel, 2, streetViewPanoramaOrientation.tilt);
        b.a(parcel, 3, streetViewPanoramaOrientation.bearing);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dl(x0);
    }

    public StreetViewPanoramaOrientation dl(Parcel parcel) {
        float f = 0.0f;
        int G = a.G(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    f2 = a.l(parcel, F);
                    break;
                case 3:
                    f = a.l(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaOrientation[] fh(int i) {
        return new StreetViewPanoramaOrientation[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fh(x0);
    }
}
