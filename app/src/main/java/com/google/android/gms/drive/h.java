package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<UserMetadata> {
    static void a(UserMetadata userMetadata, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, userMetadata.CK);
        b.a(parcel, 2, userMetadata.OR, false);
        b.a(parcel, 3, userMetadata.OS, false);
        b.a(parcel, 4, userMetadata.OT, false);
        b.a(parcel, 5, userMetadata.OU);
        b.a(parcel, 6, userMetadata.OV, false);
        b.H(parcel, H);
    }

    public UserMetadata W(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = a.G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str4 = a.o(parcel, F);
                    break;
                case 3:
                    str3 = a.o(parcel, F);
                    break;
                case 4:
                    str2 = a.o(parcel, F);
                    break;
                case 5:
                    z = a.c(parcel, F);
                    break;
                case 6:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public UserMetadata[] be(int i) {
        return new UserMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}
