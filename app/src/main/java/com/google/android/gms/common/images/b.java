package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<WebImage> {
    static void a(WebImage webImage, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, webImage.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, webImage.getUrl(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, webImage.getWidth());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, webImage.getHeight());
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public WebImage C(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            Uri uri2;
            int g;
            int F = a.F(parcel);
            int i4;
            switch (a.aH(F)) {
                case 1:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = a.g(parcel, F);
                    F = i4;
                    break;
                case 2:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    F = i;
                    i = i4;
                    break;
                case 3:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = a.g(parcel, F);
                    F = i4;
                    break;
                case 4:
                    F = a.g(parcel, F);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    a.b(parcel, F);
                    F = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public WebImage[] aA(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return C(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
