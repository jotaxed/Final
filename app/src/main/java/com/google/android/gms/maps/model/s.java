package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class s implements Creator<StreetViewPanoramaLocation> {
    static void a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        b.a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        b.a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        b.a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dk(x0);
    }

    public StreetViewPanoramaLocation dk(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < G) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int g;
            String str2;
            int F = a.F(parcel);
            String str3;
            switch (a.aH(F)) {
                case 1:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = a.g(parcel, F);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) a.b(parcel, F, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    str3 = str;
                    latLng2 = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = a.o(parcel, F);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
            }
            i = g;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaLocation[] fg(int i) {
        return new StreetViewPanoramaLocation[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fg(x0);
    }
}
