package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class t implements Creator<SessionReadRequest> {
    static void a(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, sessionReadRequest.getSessionName(), false);
        b.c(parcel, 1000, sessionReadRequest.getVersionCode());
        b.a(parcel, 2, sessionReadRequest.getSessionId(), false);
        b.a(parcel, 3, sessionReadRequest.jo());
        b.a(parcel, 4, sessionReadRequest.jp());
        b.c(parcel, 5, sessionReadRequest.getDataTypes(), false);
        b.c(parcel, 6, sessionReadRequest.getDataSources(), false);
        b.a(parcel, 7, sessionReadRequest.kj());
        b.a(parcel, 8, sessionReadRequest.jV());
        b.b(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        b.H(parcel, H);
    }

    public SessionReadRequest bT(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
                    j2 = a.i(parcel, F);
                    break;
                case 5:
                    list = a.c(parcel, F, DataType.CREATOR);
                    break;
                case 6:
                    list2 = a.c(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    z = a.c(parcel, F);
                    break;
                case 8:
                    z2 = a.c(parcel, F);
                    break;
                case 9:
                    list3 = a.C(parcel, F);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bT(x0);
    }

    public SessionReadRequest[] do(int i) {
        return new SessionReadRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return do(x0);
    }
}
