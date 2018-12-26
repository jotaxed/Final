package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CameraPosition;

public class a implements Creator<GoogleMapOptions> {
    static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, googleMapOptions.getVersionCode());
        b.a(parcel, 2, googleMapOptions.nD());
        b.a(parcel, 3, googleMapOptions.nE());
        b.c(parcel, 4, googleMapOptions.getMapType());
        b.a(parcel, 5, googleMapOptions.getCamera(), i, false);
        b.a(parcel, 6, googleMapOptions.nF());
        b.a(parcel, 7, googleMapOptions.nG());
        b.a(parcel, 8, googleMapOptions.nH());
        b.a(parcel, 9, googleMapOptions.nI());
        b.a(parcel, 10, googleMapOptions.nJ());
        b.a(parcel, 11, googleMapOptions.nK());
        b.a(parcel, 12, googleMapOptions.nL());
        b.a(parcel, 14, googleMapOptions.nM());
        b.H(parcel, H);
    }

    public GoogleMapOptions cX(Parcel parcel) {
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        byte b9 = (byte) 0;
        byte b10 = (byte) 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    b = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 3:
                    b2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 7:
                    b4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 8:
                    b5 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 9:
                    b6 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 10:
                    b7 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 11:
                    b8 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 12:
                    b9 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                case 14:
                    b10 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cX(x0);
    }

    public GoogleMapOptions[] eT(int i) {
        return new GoogleMapOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eT(x0);
    }
}
