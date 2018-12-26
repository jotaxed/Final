package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<DataHolder> {
    static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataHolder.gY(), false);
        b.c(parcel, 1000, dataHolder.getVersionCode());
        b.a(parcel, 2, dataHolder.gZ(), i, false);
        b.c(parcel, 3, dataHolder.getStatusCode());
        b.a(parcel, 4, dataHolder.gV(), false);
        b.H(parcel, H);
    }

    public DataHolder B(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int G = a.G(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    strArr = a.A(parcel, F);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) a.b(parcel, F, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    bundle = a.q(parcel, F);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() != G) {
            throw new a.a("Overread allowed size end=" + G, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.gX();
        return dataHolder;
    }

    public DataHolder[] aw(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return B(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aw(x0);
    }
}
