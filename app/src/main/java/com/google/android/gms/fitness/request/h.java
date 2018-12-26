package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class h implements Creator<DataSourcesRequest> {
    static void a(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        b.c(parcel, 1000, dataSourcesRequest.getVersionCode());
        b.a(parcel, 2, dataSourcesRequest.jZ(), false);
        b.a(parcel, 3, dataSourcesRequest.jY());
        b.H(parcel, H);
    }

    public DataSourcesRequest bM(Parcel parcel) {
        List list = null;
        boolean z = false;
        int G = a.G(parcel);
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list2 = a.c(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    list = a.B(parcel, F);
                    break;
                case 3:
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
            return new DataSourcesRequest(i, list2, list, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bM(x0);
    }

    public DataSourcesRequest[] dg(int i) {
        return new DataSourcesRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dg(x0);
    }
}
