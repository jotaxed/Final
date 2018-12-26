package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k implements Creator<MarkerOptions> {
    static void a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, markerOptions.getVersionCode());
        b.a(parcel, 2, markerOptions.getPosition(), i, false);
        b.a(parcel, 3, markerOptions.getTitle(), false);
        b.a(parcel, 4, markerOptions.getSnippet(), false);
        b.a(parcel, 5, markerOptions.oe(), false);
        b.a(parcel, 6, markerOptions.getAnchorU());
        b.a(parcel, 7, markerOptions.getAnchorV());
        b.a(parcel, 8, markerOptions.isDraggable());
        b.a(parcel, 9, markerOptions.isVisible());
        b.a(parcel, 10, markerOptions.isFlat());
        b.a(parcel, 11, markerOptions.getRotation());
        b.a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        b.a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        b.a(parcel, 14, markerOptions.getAlpha());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return df(x0);
    }

    public MarkerOptions df(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = TextTrackStyle.DEFAULT_FONT_SCALE;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    latLng = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    str2 = a.o(parcel, F);
                    break;
                case 5:
                    iBinder = a.p(parcel, F);
                    break;
                case 6:
                    f = a.l(parcel, F);
                    break;
                case 7:
                    f2 = a.l(parcel, F);
                    break;
                case 8:
                    z = a.c(parcel, F);
                    break;
                case 9:
                    z2 = a.c(parcel, F);
                    break;
                case 10:
                    z3 = a.c(parcel, F);
                    break;
                case 11:
                    f3 = a.l(parcel, F);
                    break;
                case 12:
                    f4 = a.l(parcel, F);
                    break;
                case 13:
                    f5 = a.l(parcel, F);
                    break;
                case 14:
                    f6 = a.l(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public MarkerOptions[] fb(int i) {
        return new MarkerOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fb(x0);
    }
}
