package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Contents> {
    static void a(Contents contents, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, contents.CK);
        b.a(parcel, 2, contents.LG, i, false);
        b.c(parcel, 3, contents.ve);
        b.c(parcel, 4, contents.Oi);
        b.a(parcel, 5, contents.Oj, i, false);
        b.a(parcel, 7, contents.Ok);
        b.H(parcel, H);
    }

    public Contents R(Parcel parcel) {
        DriveId driveId = null;
        boolean z = false;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 5:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, DriveId.CREATOR);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public Contents[] aX(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return R(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aX(x0);
    }
}
