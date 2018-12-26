package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dq implements Creator<dr> {
    static void a(dr drVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, drVar.versionCode);
        b.a(parcel, 2, drVar.sb, i, false);
        b.a(parcel, 3, drVar.ck(), false);
        b.a(parcel, 4, drVar.cl(), false);
        b.a(parcel, 5, drVar.cm(), false);
        b.a(parcel, 6, drVar.cn(), false);
        b.a(parcel, 7, drVar.sg, false);
        b.a(parcel, 8, drVar.sh);
        b.a(parcel, 9, drVar.si, false);
        b.a(parcel, 10, drVar.cp(), false);
        b.c(parcel, 11, drVar.orientation);
        b.c(parcel, 12, drVar.sk);
        b.a(parcel, 13, drVar.rH, false);
        b.a(parcel, 14, drVar.lO, i, false);
        b.a(parcel, 15, drVar.co(), false);
        b.a(parcel, 17, drVar.sn, i, false);
        b.a(parcel, 16, drVar.sm, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return f(x0);
    }

    public dr f(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        do doVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        gs gsVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        y yVar = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    doVar = (do) a.a(parcel, F, do.CREATOR);
                    break;
                case 3:
                    iBinder = a.p(parcel, F);
                    break;
                case 4:
                    iBinder2 = a.p(parcel, F);
                    break;
                case 5:
                    iBinder3 = a.p(parcel, F);
                    break;
                case 6:
                    iBinder4 = a.p(parcel, F);
                    break;
                case 7:
                    str = a.o(parcel, F);
                    break;
                case 8:
                    z = a.c(parcel, F);
                    break;
                case 9:
                    str2 = a.o(parcel, F);
                    break;
                case 10:
                    iBinder5 = a.p(parcel, F);
                    break;
                case 11:
                    i2 = a.g(parcel, F);
                    break;
                case 12:
                    i3 = a.g(parcel, F);
                    break;
                case 13:
                    str3 = a.o(parcel, F);
                    break;
                case 14:
                    gsVar = (gs) a.a(parcel, F, (Creator) gs.CREATOR);
                    break;
                case 15:
                    iBinder6 = a.p(parcel, F);
                    break;
                case 16:
                    str4 = a.o(parcel, F);
                    break;
                case 17:
                    yVar = (y) a.a(parcel, F, (Creator) y.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new dr(i, doVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, gsVar, iBinder6, str4, yVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public dr[] n(int i) {
        return new dr[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return n(x0);
    }
}
