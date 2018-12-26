package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class r implements Creator<q> {
    static void a(q qVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, qVar.kg(), false);
        b.c(parcel, 1000, qVar.getVersionCode());
        b.a(parcel, 2, qVar.kb(), i, false);
        b.H(parcel, H);
    }

    public q bR(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int G = a.G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    iBinder = a.p(parcel, F);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) a.a(parcel, F, PendingIntent.CREATOR);
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
            return new q(i, iBinder, pendingIntent);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bR(x0);
    }

    public q[] dm(int i) {
        return new q[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dm(x0);
    }
}
