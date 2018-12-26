package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class l implements Creator<Operator> {
    static void a(Operator operator, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, operator.CK);
        b.a(parcel, 1, operator.mTag, false);
        b.H(parcel, H);
    }

    public Operator bb(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
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
            return new Operator(i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Operator[] cq(int i) {
        return new Operator[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cq(x0);
    }
}
