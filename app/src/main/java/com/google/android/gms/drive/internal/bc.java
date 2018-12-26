package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class bc implements Creator<RemoveEventListenerRequest> {
    static void a(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, removeEventListenerRequest.CK);
        b.a(parcel, 2, removeEventListenerRequest.Oj, i, false);
        b.c(parcel, 3, removeEventListenerRequest.Pm);
        b.H(parcel, H);
    }

    public RemoveEventListenerRequest aG(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    g = a.g(parcel, F);
                    F = i3;
                    break;
                case 2:
                    g = i2;
                    DriveId driveId3 = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    F = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    F = a.g(parcel, F);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    a.b(parcel, F);
                    F = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public RemoveEventListenerRequest[] bV(int i) {
        return new RemoveEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bV(x0);
    }
}
