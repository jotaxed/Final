package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import java.util.List;

public class f implements Creator<SessionReadResult> {
    static void a(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, sessionReadResult.getSessions(), false);
        b.c(parcel, 1000, sessionReadResult.getVersionCode());
        b.c(parcel, 2, sessionReadResult.kv(), false);
        b.a(parcel, 3, sessionReadResult.getStatus(), i, false);
        b.H(parcel, H);
    }

    public SessionReadResult ci(Parcel parcel) {
        Status status = null;
        int G = a.G(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list2 = a.c(parcel, F, Session.CREATOR);
                    break;
                case 2:
                    list = a.c(parcel, F, q.CREATOR);
                    break;
                case 3:
                    status = (Status) a.a(parcel, F, Status.CREATOR);
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
            return new SessionReadResult(i, list2, list, status);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ci(x0);
    }

    public SessionReadResult[] dD(int i) {
        return new SessionReadResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dD(x0);
    }
}
