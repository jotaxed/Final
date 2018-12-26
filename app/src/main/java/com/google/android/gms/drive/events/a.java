package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class a implements Creator<ChangeEvent> {
    static void a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, changeEvent.CK);
        b.a(parcel, 2, changeEvent.Oj, i, false);
        b.c(parcel, 3, changeEvent.OX);
        b.H(parcel, H);
    }

    public ChangeEvent X(Parcel parcel) {
        int i = 0;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    F = i3;
                    break;
                case 2:
                    g = i2;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, DriveId.CREATOR);
                    F = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    F = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
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
            return new ChangeEvent(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public ChangeEvent[] bf(int i) {
        return new ChangeEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return X(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bf(x0);
    }
}
