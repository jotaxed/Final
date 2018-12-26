package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<StreetViewPanoramaCamera> {
    static void a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, streetViewPanoramaCamera.getVersionCode());
        b.a(parcel, 2, streetViewPanoramaCamera.zoom);
        b.a(parcel, 3, streetViewPanoramaCamera.tilt);
        b.a(parcel, 4, streetViewPanoramaCamera.bearing);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return di(x0);
    }

    public StreetViewPanoramaCamera di(Parcel parcel) {
        float f = 0.0f;
        int G = a.G(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
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
                    f3 = a.l(parcel, F);
                    break;
                case 4:
                    f = a.l(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaCamera[] fe(int i) {
        return new StreetViewPanoramaCamera[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fe(x0);
    }
}
