package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class od implements Creator<oc> {
    static void a(oc ocVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, ocVar.getName(), false);
        b.c(parcel, 1000, ocVar.CK);
        b.a(parcel, 2, ocVar.nx(), i, false);
        b.a(parcel, 3, ocVar.getAddress(), false);
        b.c(parcel, 4, ocVar.ny(), false);
        b.a(parcel, 5, ocVar.getPhoneNumber(), false);
        b.a(parcel, 6, ocVar.nz(), false);
        b.H(parcel, H);
    }

    public oc cU(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str4 = a.o(parcel, F);
                    break;
                case 2:
                    latLng = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = a.o(parcel, F);
                    break;
                case 4:
                    list = a.c(parcel, F, oa.CREATOR);
                    break;
                case 5:
                    str2 = a.o(parcel, F);
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
            return new oc(i, str4, latLng, str3, list, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cU(x0);
    }

    public oc[] eQ(int i) {
        return new oc[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eQ(x0);
    }
}
