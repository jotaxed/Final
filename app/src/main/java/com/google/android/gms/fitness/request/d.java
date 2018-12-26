package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class d implements Creator<DataDeleteRequest> {
    static void a(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataDeleteRequest.jo());
        b.c(parcel, 1000, dataDeleteRequest.getVersionCode());
        b.a(parcel, 2, dataDeleteRequest.jp());
        b.c(parcel, 3, dataDeleteRequest.getDataSources(), false);
        b.c(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        b.c(parcel, 5, dataDeleteRequest.getSessions(), false);
        b.a(parcel, 6, dataDeleteRequest.jR());
        b.a(parcel, 7, dataDeleteRequest.jS());
        b.H(parcel, H);
    }

    public DataDeleteRequest bJ(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int G = a.G(parcel);
        boolean z2 = false;
        List list2 = null;
        List list3 = null;
        long j2 = 0;
        int i = 0;
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
                    list3 = a.c(parcel, F, DataSource.CREATOR);
                    break;
                case 4:
                    list2 = a.c(parcel, F, DataType.CREATOR);
                    break;
                case 5:
                    list = a.c(parcel, F, Session.CREATOR);
                    break;
                case 6:
                    z2 = a.c(parcel, F);
                    break;
                case 7:
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
            return new DataDeleteRequest(i, j2, j, list3, list2, list, z2, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bJ(x0);
    }

    public DataDeleteRequest[] dd(int i) {
        return new DataDeleteRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dd(x0);
    }
}
