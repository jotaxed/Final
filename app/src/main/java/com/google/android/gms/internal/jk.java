package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jk implements Creator<jj> {
    static void a(jj jjVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, jjVar.version);
        b.c(parcel, 2, jjVar.MD);
        b.c(parcel, 3, jjVar.ME);
        b.a(parcel, 4, jjVar.MF, false);
        b.a(parcel, 5, jjVar.MG, false);
        b.a(parcel, 6, jjVar.MH, i, false);
        b.a(parcel, 7, jjVar.MI, false);
        b.H(parcel, H);
    }

    public jj D(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int G = a.G(parcel);
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                case 5:
                    iBinder = a.p(parcel, F);
                    break;
                case 6:
                    scopeArr = (Scope[]) a.b(parcel, F, Scope.CREATOR);
                    break;
                case 7:
                    bundle = a.q(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new jj(i3, i2, i, str, iBinder, scopeArr, bundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public jj[] aC(int i) {
        return new jj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return D(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aC(x0);
    }
}
