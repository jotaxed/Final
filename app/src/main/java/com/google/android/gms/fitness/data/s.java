package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class s implements Creator<Subscription> {
    static void a(Subscription subscription, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, subscription.getDataSource(), i, false);
        b.c(parcel, 1000, subscription.getVersionCode());
        b.a(parcel, 2, subscription.getDataType(), i, false);
        b.a(parcel, 3, subscription.jI());
        b.c(parcel, 4, subscription.getAccuracyMode());
        b.H(parcel, H);
    }

    public Subscription bE(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int G = a.G(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, F, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) a.a(parcel, F, DataType.CREATOR);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Subscription[] cY(int i) {
        return new Subscription[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cY(x0);
    }
}
