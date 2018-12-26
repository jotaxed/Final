package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class c implements Creator<BleDevice> {
    static void a(BleDevice bleDevice, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, bleDevice.getAddress(), false);
        b.c(parcel, 1000, bleDevice.getVersionCode());
        b.a(parcel, 2, bleDevice.getName(), false);
        b.b(parcel, 3, bleDevice.getSupportedProfiles(), false);
        b.c(parcel, 4, bleDevice.getDataTypes(), false);
        b.H(parcel, H);
    }

    public BleDevice br(Parcel parcel) {
        List list = null;
        int G = a.G(parcel);
        int i = 0;
        List list2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str2 = a.o(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    list2 = a.C(parcel, F);
                    break;
                case 4:
                    list = a.c(parcel, F, DataType.CREATOR);
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
            return new BleDevice(i, str2, str, list2, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public BleDevice[] cI(int i) {
        return new BleDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return br(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cI(x0);
    }
}
