package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class r implements Creator<StreetViewPanoramaLink> {
    static void a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        b.a(parcel, 2, streetViewPanoramaLink.panoId, false);
        b.a(parcel, 3, streetViewPanoramaLink.bearing);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dj(x0);
    }

    public StreetViewPanoramaLink dj(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
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
                    f = a.l(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaLink[] ff(int i) {
        return new StreetViewPanoramaLink[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ff(x0);
    }
}
