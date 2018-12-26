package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class c implements Creator<StreetViewPanoramaOptions> {
    static void a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        b.a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        b.a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        b.a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        b.a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        b.a(parcel, 6, streetViewPanoramaOptions.nS());
        b.a(parcel, 7, streetViewPanoramaOptions.nI());
        b.a(parcel, 8, streetViewPanoramaOptions.nT());
        b.a(parcel, 9, streetViewPanoramaOptions.nU());
        b.a(parcel, 10, streetViewPanoramaOptions.nE());
        b.H(parcel, H);
    }

    public StreetViewPanoramaOptions cY(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int G = a.G(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) a.a(parcel, F, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    latLng = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 5:
                    num = a.h(parcel, F);
                    break;
                case 6:
                    b5 = a.e(parcel, F);
                    break;
                case 7:
                    b4 = a.e(parcel, F);
                    break;
                case 8:
                    b3 = a.e(parcel, F);
                    break;
                case 9:
                    b2 = a.e(parcel, F);
                    break;
                case 10:
                    b = a.e(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cY(x0);
    }

    public StreetViewPanoramaOptions[] eU(int i) {
        return new StreetViewPanoramaOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eU(x0);
    }
}
