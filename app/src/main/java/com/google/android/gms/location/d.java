package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<LocationRequest> {
    static void a(LocationRequest locationRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, locationRequest.mPriority);
        b.c(parcel, 1000, locationRequest.getVersionCode());
        b.a(parcel, 2, locationRequest.agr);
        b.a(parcel, 3, locationRequest.ags);
        b.a(parcel, 4, locationRequest.Wg);
        b.a(parcel, 5, locationRequest.age);
        b.c(parcel, 6, locationRequest.agt);
        b.a(parcel, 7, locationRequest.agu);
        b.a(parcel, 8, locationRequest.agv);
        b.H(parcel, H);
    }

    public LocationRequest cJ(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    j2 = a.i(parcel, F);
                    break;
                case 4:
                    z = a.c(parcel, F);
                    break;
                case 5:
                    j3 = a.i(parcel, F);
                    break;
                case 6:
                    i3 = a.g(parcel, F);
                    break;
                case 7:
                    f = a.l(parcel, F);
                    break;
                case 8:
                    j4 = a.i(parcel, F);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cJ(x0);
    }

    public LocationRequest[] eA(int i) {
        return new LocationRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eA(x0);
    }
}
