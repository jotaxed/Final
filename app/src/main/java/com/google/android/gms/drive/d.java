package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<DrivePreferences> {
    static void a(DrivePreferences drivePreferences, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, drivePreferences.CK);
        b.a(parcel, 2, drivePreferences.Ox);
        b.H(parcel, H);
    }

    public DrivePreferences T(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DrivePreferences(i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DrivePreferences[] aZ(int i) {
        return new DrivePreferences[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aZ(x0);
    }
}
