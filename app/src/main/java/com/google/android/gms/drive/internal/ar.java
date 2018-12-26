package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ar implements Creator<OnListEntriesResponse> {
    static void a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onListEntriesResponse.CK);
        b.a(parcel, 2, onListEntriesResponse.QQ, i, false);
        b.a(parcel, 3, onListEntriesResponse.PJ);
        b.H(parcel, H);
    }

    public OnListEntriesResponse aw(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            DataHolder dataHolder2;
            int g;
            boolean z2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    g = a.g(parcel, F);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DataHolder dataHolder3 = (DataHolder) a.a(parcel, F, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = a.c(parcel, F);
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
            }
            i = g;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnListEntriesResponse[] bL(int i) {
        return new OnListEntriesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bL(x0);
    }
}
