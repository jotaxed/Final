package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class nm implements Creator<nl> {
    static void a(nl nlVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, nlVar.We, i, false);
        b.c(parcel, 1000, nlVar.getVersionCode());
        b.a(parcel, 2, nlVar.ahh);
        b.a(parcel, 3, nlVar.ahi);
        b.a(parcel, 4, nlVar.ahj);
        b.c(parcel, 5, nlVar.ahk, false);
        b.a(parcel, 6, nlVar.mTag, false);
        b.H(parcel, H);
    }

    public nl cM(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int G = a.G(parcel);
        List list = nl.ahg;
        boolean z3 = true;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    locationRequest = (LocationRequest) a.a(parcel, F, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = a.c(parcel, F);
                    break;
                case 3:
                    z3 = a.c(parcel, F);
                    break;
                case 4:
                    z = a.c(parcel, F);
                    break;
                case 5:
                    list = a.c(parcel, F, nd.CREATOR);
                    break;
                case 6:
                    str = a.o(parcel, F);
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
            return new nl(i, locationRequest, z2, z3, z, list, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cM(x0);
    }

    public nl[] eG(int i) {
        return new nl[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eG(x0);
    }
}
