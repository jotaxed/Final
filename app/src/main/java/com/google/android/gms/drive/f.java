package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class f implements Creator<RealtimeDocumentSyncRequest> {
    static void a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, realtimeDocumentSyncRequest.CK);
        b.b(parcel, 2, realtimeDocumentSyncRequest.OK, false);
        b.b(parcel, 3, realtimeDocumentSyncRequest.OL, false);
        b.H(parcel, H);
    }

    public RealtimeDocumentSyncRequest U(Parcel parcel) {
        List list = null;
        int G = a.G(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    list2 = a.C(parcel, F);
                    break;
                case 3:
                    list = a.C(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RealtimeDocumentSyncRequest(i, list2, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public RealtimeDocumentSyncRequest[] bc(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bc(x0);
    }
}
