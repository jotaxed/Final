package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StatusCreator implements Creator<Status> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(Status status, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, status.getStatusCode());
        b.c(parcel, 1000, status.getVersionCode());
        b.a(parcel, 2, status.getStatusMessage(), false);
        b.a(parcel, 3, status.gP(), i, false);
        b.H(parcel, H);
    }

    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) a.a(parcel, F, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Status[] newArray(int size) {
        return new Status[size];
    }
}
