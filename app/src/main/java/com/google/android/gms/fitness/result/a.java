package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.List;

public class a implements Creator<BleDevicesResult> {
    static void a(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        b.c(parcel, 1000, bleDevicesResult.getVersionCode());
        b.a(parcel, 2, bleDevicesResult.getStatus(), i, false);
        b.H(parcel, H);
    }

    public BleDevicesResult cd(Parcel parcel) {
        Status status = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, BleDevice.CREATOR);
                    break;
                case 2:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, Status.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new BleDevicesResult(i, list, status);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cd(x0);
    }

    public BleDevicesResult[] dy(int i) {
        return new BleDevicesResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dy(x0);
    }
}
