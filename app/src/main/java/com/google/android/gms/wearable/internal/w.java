package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class w implements Creator<v> {
    static void a(v vVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, vVar.versionCode);
        b.c(parcel, 2, vVar.statusCode);
        b.c(parcel, 3, vVar.axL, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eu(x0);
    }

    public v eu(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 3:
                    list = a.c(parcel, F, al.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new v(i2, i, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public v[] gD(int i) {
        return new v[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gD(x0);
    }
}
