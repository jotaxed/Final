package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dz implements Creator<ea> {
    static void a(ea eaVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, eaVar.versionCode);
        b.a(parcel, 3, eaVar.cu(), false);
        b.a(parcel, 4, eaVar.cv(), false);
        b.a(parcel, 5, eaVar.cw(), false);
        b.a(parcel, 6, eaVar.ct(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return g(x0);
    }

    public ea g(Parcel parcel) {
        IBinder iBinder = null;
        int G = a.G(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 3:
                    iBinder4 = a.p(parcel, F);
                    break;
                case 4:
                    iBinder3 = a.p(parcel, F);
                    break;
                case 5:
                    iBinder2 = a.p(parcel, F);
                    break;
                case 6:
                    iBinder = a.p(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ea(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return o(x0);
    }

    public ea[] o(int i) {
        return new ea[i];
    }
}
