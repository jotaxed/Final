package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class ax implements Creator<aw> {
    static void a(aw awVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, awVar.versionCode);
        b.c(parcel, 2, awVar.statusCode);
        b.a(parcel, 3, awVar.ayc);
        b.c(parcel, 4, awVar.aye, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eE(x0);
    }

    public aw eE(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        long j = 0;
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
                    j = a.i(parcel, F);
                    break;
                case 4:
                    list = a.c(parcel, F, an.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new aw(i2, i, j, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public aw[] gO(int i) {
        return new aw[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gO(x0);
    }
}
