package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public class f implements Creator<DataSet> {
    static void a(DataSet dataSet, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataSet.getDataSource(), i, false);
        b.c(parcel, 1000, dataSet.getVersionCode());
        b.a(parcel, 2, dataSet.getDataType(), i, false);
        b.d(parcel, 3, dataSet.jv(), false);
        b.c(parcel, 4, dataSet.jw(), false);
        b.a(parcel, 5, dataSet.jn());
        b.H(parcel, H);
    }

    public DataSet bu(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = a.G(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
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
                    a.a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    list = a.c(parcel, F, DataSource.CREATOR);
                    break;
                case 5:
                    z = a.c(parcel, F);
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DataSet[] cN(int i) {
        return new DataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cN(x0);
    }
}
