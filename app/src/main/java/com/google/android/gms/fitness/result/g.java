package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.List;

public class g implements Creator<SessionStopResult> {
    static void a(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, sessionStopResult.getVersionCode());
        b.a(parcel, 2, sessionStopResult.getStatus(), i, false);
        b.c(parcel, 3, sessionStopResult.getSessions(), false);
        b.H(parcel, H);
    }

    public SessionStopResult cj(Parcel parcel) {
        List list = null;
        int G = a.G(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < G) {
            int i2;
            Status status2;
            ArrayList c;
            int F = a.F(parcel);
            List list2;
            switch (a.aH(F)) {
                case 2:
                    i2 = i;
                    Status status3 = (Status) a.a(parcel, F, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 3:
                    c = a.c(parcel, F, Session.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = a.g(parcel, F);
                    list2 = list3;
                    break;
                default:
                    a.b(parcel, F);
                    c = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new SessionStopResult(i, status, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cj(x0);
    }

    public SessionStopResult[] dE(int i) {
        return new SessionStopResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dE(x0);
    }
}
