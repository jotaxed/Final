package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.BleDevice;

public class c implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, bVar.getDeviceAddress(), false);
        b.c(parcel, 1000, bVar.getVersionCode());
        b.a(parcel, 2, bVar.jQ(), i, false);
        b.H(parcel, H);
    }

    public b bI(Parcel parcel) {
        BleDevice bleDevice = null;
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    bleDevice = (BleDevice) a.a(parcel, F, BleDevice.CREATOR);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new b(i, str, bleDevice);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bI(x0);
    }

    public b[] dc(int i) {
        return new b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dc(x0);
    }
}
