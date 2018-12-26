package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class av implements Creator<OnResourceIdSetResponse> {
    static void a(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onResourceIdSetResponse.getVersionCode());
        b.b(parcel, 2, onResourceIdSetResponse.iF(), false);
        b.H(parcel, H);
    }

    public OnResourceIdSetResponse aA(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    list = a.C(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnResourceIdSetResponse(i, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnResourceIdSetResponse[] bP(int i) {
        return new OnResourceIdSetResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bP(x0);
    }
}
