package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

public class a implements Creator<FitnessSensorServiceRequest> {
    static void a(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, fitnessSensorServiceRequest.getDataSource(), i, false);
        b.c(parcel, 1000, fitnessSensorServiceRequest.getVersionCode());
        b.a(parcel, 2, fitnessSensorServiceRequest.kg(), false);
        b.a(parcel, 3, fitnessSensorServiceRequest.jI());
        b.a(parcel, 4, fitnessSensorServiceRequest.kx());
        b.H(parcel, H);
    }

    public FitnessSensorServiceRequest ck(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, DataSource.CREATOR);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.a.p(parcel, F);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, F);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, F);
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
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ck(x0);
    }

    public FitnessSensorServiceRequest[] dF(int i) {
        return new FitnessSensorServiceRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dF(x0);
    }
}
