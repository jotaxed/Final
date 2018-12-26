package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p implements Creator<ParcelableCollaborator> {
    static void a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, parcelableCollaborator.CK);
        b.a(parcel, 2, parcelableCollaborator.SH);
        b.a(parcel, 3, parcelableCollaborator.SI);
        b.a(parcel, 4, parcelableCollaborator.vZ, false);
        b.a(parcel, 5, parcelableCollaborator.SJ, false);
        b.a(parcel, 6, parcelableCollaborator.OS, false);
        b.a(parcel, 7, parcelableCollaborator.SK, false);
        b.a(parcel, 8, parcelableCollaborator.SL, false);
        b.H(parcel, H);
    }

    public ParcelableCollaborator be(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = a.G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    z2 = a.c(parcel, F);
                    break;
                case 3:
                    z = a.c(parcel, F);
                    break;
                case 4:
                    str5 = a.o(parcel, F);
                    break;
                case 5:
                    str4 = a.o(parcel, F);
                    break;
                case 6:
                    str3 = a.o(parcel, F);
                    break;
                case 7:
                    str2 = a.o(parcel, F);
                    break;
                case 8:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return be(x0);
    }

    public ParcelableCollaborator[] cu(int i) {
        return new ParcelableCollaborator[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cu(x0);
    }
}
