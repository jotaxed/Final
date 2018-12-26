package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<InstrumentInfo> {
    static void a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, instrumentInfo.getVersionCode());
        b.a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        b.a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dP(x0);
    }

    public InstrumentInfo dP(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new InstrumentInfo(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public InstrumentInfo[] fW(int i) {
        return new InstrumentInfo[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fW(x0);
    }
}
