package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class ac implements Creator<StartBleScanRequest> {
    static void a(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, startBleScanRequest.getDataTypes(), false);
        b.c(parcel, 1000, startBleScanRequest.getVersionCode());
        b.a(parcel, 2, startBleScanRequest.km(), false);
        b.c(parcel, 3, startBleScanRequest.getTimeoutSecs());
        b.H(parcel, H);
    }

    public StartBleScanRequest bY(Parcel parcel) {
        IBinder iBinder = null;
        int i = 0;
        int G = a.G(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list = a.c(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    iBinder = a.p(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StartBleScanRequest(i2, list, iBinder, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bY(x0);
    }

    public StartBleScanRequest[] dt(int i) {
        return new StartBleScanRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dt(x0);
    }
}
