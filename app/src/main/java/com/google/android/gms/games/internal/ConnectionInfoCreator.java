package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    static void a(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, connectionInfo.le(), false);
        b.c(parcel, 1000, connectionInfo.getVersionCode());
        b.c(parcel, 2, connectionInfo.lf());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ct(x0);
    }

    public ConnectionInfo ct(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
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
            return new ConnectionInfo(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ConnectionInfo[] dR(int i) {
        return new ConnectionInfo[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dR(x0);
    }
}
