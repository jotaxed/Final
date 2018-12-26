package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.Query;

public class bb implements Creator<QueryRequest> {
    static void a(QueryRequest queryRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, queryRequest.CK);
        b.a(parcel, 2, queryRequest.QV, i, false);
        b.H(parcel, H);
    }

    public QueryRequest aF(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    query = (Query) a.a(parcel, F, Query.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new QueryRequest(i, query);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public QueryRequest[] bU(int i) {
        return new QueryRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bU(x0);
    }
}
