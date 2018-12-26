package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class g implements Creator<DataReadRequest> {
    static void a(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, dataReadRequest.getDataTypes(), false);
        b.c(parcel, 1000, dataReadRequest.getVersionCode());
        b.c(parcel, 2, dataReadRequest.getDataSources(), false);
        b.a(parcel, 3, dataReadRequest.jo());
        b.a(parcel, 4, dataReadRequest.jp());
        b.c(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        b.c(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        b.c(parcel, 7, dataReadRequest.getBucketType());
        b.a(parcel, 8, dataReadRequest.jX());
        b.a(parcel, 9, dataReadRequest.getActivityDataSource(), i, false);
        b.c(parcel, 10, dataReadRequest.getLimit());
        b.a(parcel, 12, dataReadRequest.jW());
        b.a(parcel, 13, dataReadRequest.jV());
        b.H(parcel, H);
    }

    public DataReadRequest bL(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        long j = 0;
        long j2 = 0;
        List list3 = null;
        List list4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list = a.c(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    list2 = a.c(parcel, F, DataSource.CREATOR);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
                    j2 = a.i(parcel, F);
                    break;
                case 5:
                    list3 = a.c(parcel, F, DataType.CREATOR);
                    break;
                case 6:
                    list4 = a.c(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    i2 = a.g(parcel, F);
                    break;
                case 8:
                    j3 = a.i(parcel, F);
                    break;
                case 9:
                    dataSource = (DataSource) a.a(parcel, F, DataSource.CREATOR);
                    break;
                case 10:
                    i3 = a.g(parcel, F);
                    break;
                case 12:
                    z = a.c(parcel, F);
                    break;
                case 13:
                    z2 = a.c(parcel, F);
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
            return new DataReadRequest(i, list, list2, j, j2, list3, list4, i2, j3, dataSource, i3, z, z2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bL(x0);
    }

    public DataReadRequest[] df(int i) {
        return new DataReadRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return df(x0);
    }
}
