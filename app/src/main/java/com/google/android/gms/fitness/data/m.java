package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class m implements Creator<RawBucket> {
    static void a(RawBucket rawBucket, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, rawBucket.LW);
        b.c(parcel, 1000, rawBucket.CK);
        b.a(parcel, 2, rawBucket.TO);
        b.a(parcel, 3, rawBucket.TQ, i, false);
        b.c(parcel, 4, rawBucket.UI);
        b.c(parcel, 5, rawBucket.Ua, false);
        b.c(parcel, 6, rawBucket.Ub);
        b.a(parcel, 7, rawBucket.Uc);
        b.H(parcel, H);
    }

    public RawBucket bz(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int G = a.G(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
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
                    session = (Session) a.a(parcel, F, Session.CREATOR);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    list = a.c(parcel, F, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = a.g(parcel, F);
                    break;
                case 7:
                    z = a.c(parcel, F);
                    break;
                case 1000:
                    i3 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RawBucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public RawBucket[] cS(int i) {
        return new RawBucket[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cS(x0);
    }
}
