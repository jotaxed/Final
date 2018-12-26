package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ab implements Creator<aa> {
    static void a(aa aaVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, aaVar.kb(), i, false);
        b.c(parcel, 1000, aaVar.getVersionCode());
        b.H(parcel, H);
    }

    public aa bX(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
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
            return new aa(i, pendingIntent);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bX(x0);
    }

    public aa[] ds(int i) {
        return new aa[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ds(x0);
    }
}
