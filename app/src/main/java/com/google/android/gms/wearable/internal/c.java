package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, bVar.CK);
        b.a(parcel, 2, bVar.rm(), false);
        b.a(parcel, 3, bVar.axw, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eo(x0);
    }

    public b eo(Parcel parcel) {
        IntentFilter[] intentFilterArr = null;
        int G = a.G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    iBinder = a.p(parcel, F);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) a.b(parcel, F, IntentFilter.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new b(i, iBinder, intentFilterArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public b[] gx(int i) {
        return new b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gx(x0);
    }
}
