package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;

public class x implements Creator<w> {
    static void a(w wVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, wVar.getSession(), i, false);
        b.c(parcel, 1000, wVar.getVersionCode());
        b.H(parcel, H);
    }

    public w bV(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    session = (Session) a.a(parcel, F, Session.CREATOR);
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
            return new w(i, session);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bV(x0);
    }

    public w[] dq(int i) {
        return new w[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dq(x0);
    }
}
