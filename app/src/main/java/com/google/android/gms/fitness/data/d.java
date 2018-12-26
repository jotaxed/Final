package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class d implements Creator<Bucket> {
    static void a(Bucket bucket, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, bucket.jo());
        b.c(parcel, 1000, bucket.getVersionCode());
        b.a(parcel, 2, bucket.jp());
        b.a(parcel, 3, bucket.getSession(), i, false);
        b.c(parcel, 4, bucket.jm());
        b.c(parcel, 5, bucket.getDataSets(), false);
        b.c(parcel, 6, bucket.getBucketType());
        b.a(parcel, 7, bucket.jn());
        b.H(parcel, H);
    }

    public Bucket bs(Parcel parcel) {
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
                    list = a.c(parcel, F, DataSet.CREATOR);
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
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Bucket[] cK(int i) {
        return new Bucket[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cK(x0);
    }
}
