package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aj implements Creator<ai> {
    static void a(ai aiVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, aiVar.CK);
        b.c(parcel, 2, aiVar.getRequestId());
        b.a(parcel, 3, aiVar.getPath(), false);
        b.a(parcel, 4, aiVar.getData(), false);
        b.a(parcel, 5, aiVar.getSourceNodeId(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ey(x0);
    }

    public ai ey(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = a.G(parcel);
        byte[] bArr = null;
        String str2 = null;
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
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    bArr = a.r(parcel, F);
                    break;
                case 5:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ai(i2, i, str2, bArr, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ai[] gH(int i) {
        return new ai[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gH(x0);
    }
}
