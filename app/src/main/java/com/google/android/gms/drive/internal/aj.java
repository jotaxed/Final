package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class aj implements Creator<LoadRealtimeRequest> {
    static void a(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, loadRealtimeRequest.CK);
        b.a(parcel, 2, loadRealtimeRequest.Oj, i, false);
        b.a(parcel, 3, loadRealtimeRequest.QF);
        b.H(parcel, H);
    }

    public LoadRealtimeRequest ap(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            boolean z2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    boolean z3 = z;
                    driveId2 = driveId;
                    g = a.g(parcel, F);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case 3:
                    z2 = a.c(parcel, F);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    z2 = z;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new LoadRealtimeRequest(i, driveId, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public LoadRealtimeRequest[] bE(int i) {
        return new LoadRealtimeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ap(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
