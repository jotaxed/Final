package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class aw implements Creator<av> {
    static void a(av avVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, avVar.versionCode);
        b.a(parcel, 2, avVar.od);
        b.a(parcel, 3, avVar.extras, false);
        b.c(parcel, 4, avVar.oe);
        b.b(parcel, 5, avVar.of, false);
        b.a(parcel, 6, avVar.og);
        b.c(parcel, 7, avVar.oh);
        b.a(parcel, 8, avVar.oi);
        b.a(parcel, 9, avVar.oj, false);
        b.a(parcel, 10, avVar.ok, i, false);
        b.a(parcel, 11, avVar.ol, i, false);
        b.a(parcel, 12, avVar.om, false);
        b.a(parcel, 13, avVar.on, false);
        b.H(parcel, H);
    }

    public av b(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        bj bjVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    bundle = a.q(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    list = a.C(parcel, F);
                    break;
                case 6:
                    z = a.c(parcel, F);
                    break;
                case 7:
                    i3 = a.g(parcel, F);
                    break;
                case 8:
                    z2 = a.c(parcel, F);
                    break;
                case 9:
                    str = a.o(parcel, F);
                    break;
                case 10:
                    bjVar = (bj) a.a(parcel, F, bj.CREATOR);
                    break;
                case 11:
                    location = (Location) a.a(parcel, F, Location.CREATOR);
                    break;
                case 12:
                    str2 = a.o(parcel, F);
                    break;
                case 13:
                    bundle2 = a.q(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new av(i, j, bundle, i2, list, z, i3, z2, str, bjVar, location, str2, bundle2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return b(x0);
    }

    public av[] f(int i) {
        return new av[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return f(x0);
    }
}
