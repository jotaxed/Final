package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<Scope> {
    static void a(Scope scope, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, scope.CK);
        b.a(parcel, 2, scope.gO(), false);
        b.H(parcel, H);
    }

    public Scope[] am(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return am(x0);
    }

    public Scope z(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Scope(i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
