package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class ak implements Creator<aj> {
    static void a(aj ajVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, ajVar.getDataType(), i, false);
        b.c(parcel, 1000, ajVar.getVersionCode());
        b.a(parcel, 2, ajVar.getDataSource(), i, false);
        b.H(parcel, H);
    }

    public aj cc(Parcel parcel) {
        DataSource dataSource = null;
        int G = a.G(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < G) {
            int i2;
            DataSource dataSource2;
            DataType dataType2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = i;
                    DataType dataType3 = (DataType) a.a(parcel, F, DataType.CREATOR);
                    dataSource2 = dataSource;
                    dataType2 = dataType3;
                    break;
                case 2:
                    dataSource2 = (DataSource) a.a(parcel, F, DataSource.CREATOR);
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    DataSource dataSource3 = dataSource;
                    dataType2 = dataType;
                    i2 = a.g(parcel, F);
                    dataSource2 = dataSource3;
                    break;
                default:
                    a.b(parcel, F);
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            dataSource = dataSource2;
        }
        if (parcel.dataPosition() == G) {
            return new aj(i, dataType, dataSource);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cc(x0);
    }

    public aj[] dx(int i) {
        return new aj[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dx(x0);
    }
}
