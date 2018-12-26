package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

public class b implements Creator<CastDevice> {
    static void a(CastDevice castDevice, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, castDevice.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, castDevice.getDeviceId(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, castDevice.FH, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, castDevice.getFriendlyName(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, castDevice.getModelName(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, castDevice.getDeviceVersion(), false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 7, castDevice.getServicePort());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 8, castDevice.getIcons(), false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 9, castDevice.getCapabilities());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 10, castDevice.getStatus());
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public CastDevice[] Z(int i) {
        return new CastDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return Z(x0);
    }

    public CastDevice v(Parcel parcel) {
        int i = 0;
        List list = null;
        int G = a.G(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i4 = a.g(parcel, F);
                    break;
                case 2:
                    str5 = a.o(parcel, F);
                    break;
                case 3:
                    str4 = a.o(parcel, F);
                    break;
                case 4:
                    str3 = a.o(parcel, F);
                    break;
                case 5:
                    str2 = a.o(parcel, F);
                    break;
                case 6:
                    str = a.o(parcel, F);
                    break;
                case 7:
                    i3 = a.g(parcel, F);
                    break;
                case 8:
                    list = a.c(parcel, F, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = a.g(parcel, F);
                    break;
                case 10:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CastDevice(i4, str5, str4, str3, str2, str, i3, list, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
