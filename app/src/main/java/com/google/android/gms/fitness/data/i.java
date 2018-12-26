package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<Device> {
    static void a(Device device, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, device.getManufacturer(), false);
        b.c(parcel, 1000, device.getVersionCode());
        b.a(parcel, 2, device.getModel(), false);
        b.a(parcel, 3, device.getVersion(), false);
        b.a(parcel, 4, device.jF(), false);
        b.c(parcel, 5, device.getType());
        b.c(parcel, 6, device.jC());
        b.H(parcel, H);
    }

    public Device bx(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = a.G(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str4 = a.o(parcel, F);
                    break;
                case 2:
                    str3 = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                case 5:
                    i2 = a.g(parcel, F);
                    break;
                case 6:
                    i = a.g(parcel, F);
                    break;
                case 1000:
                    i3 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Device[] cQ(int i) {
        return new Device[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cQ(x0);
    }
}
