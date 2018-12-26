package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<DataPoint> {
    static void a(DataPoint dataPoint, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataPoint.getDataSource(), i, false);
        b.c(parcel, 1000, dataPoint.getVersionCode());
        b.a(parcel, 3, dataPoint.getTimestampNanos());
        b.a(parcel, 4, dataPoint.ju());
        b.a(parcel, 5, dataPoint.jr(), i, false);
        b.a(parcel, 6, dataPoint.getOriginalDataSource(), i, false);
        b.a(parcel, 7, dataPoint.js());
        b.a(parcel, 8, dataPoint.jt());
        b.H(parcel, H);
    }

    public DataPoint bt(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, F, DataSource.CREATOR);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
                    j2 = a.i(parcel, F);
                    break;
                case 5:
                    valueArr = (Value[]) a.b(parcel, F, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) a.a(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = a.i(parcel, F);
                    break;
                case 8:
                    j4 = a.i(parcel, F);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DataPoint[] cM(int i) {
        return new DataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cM(x0);
    }
}
