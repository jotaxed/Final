package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p implements Creator<Session> {
    static void a(Session session, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, session.jo());
        b.c(parcel, 1000, session.getVersionCode());
        b.a(parcel, 2, session.jp());
        b.a(parcel, 3, session.getName(), false);
        b.a(parcel, 4, session.getIdentifier(), false);
        b.a(parcel, 5, session.getDescription(), false);
        b.c(parcel, 7, session.jm());
        b.a(parcel, 8, session.jx(), i, false);
        b.H(parcel, H);
    }

    public Session bC(Parcel parcel) {
        long j = 0;
        int i = 0;
        a aVar = null;
        int G = a.G(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    j2 = a.i(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    str3 = a.o(parcel, F);
                    break;
                case 4:
                    str2 = a.o(parcel, F);
                    break;
                case 5:
                    str = a.o(parcel, F);
                    break;
                case 7:
                    i = a.g(parcel, F);
                    break;
                case 8:
                    aVar = (a) a.a(parcel, F, a.CREATOR);
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
            return new Session(i2, j2, j, str3, str2, str, i, aVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Session[] cW(int i) {
        return new Session[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cW(x0);
    }
}
