package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class c implements Creator<ParcelableEventList> {
    static void a(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, parcelableEventList.CK);
        b.c(parcel, 2, parcelableEventList.mp, false);
        b.a(parcel, 3, parcelableEventList.Tb, i, false);
        b.a(parcel, 4, parcelableEventList.Tc);
        b.b(parcel, 5, parcelableEventList.Td, false);
        b.H(parcel, H);
    }

    public ParcelableEventList bi(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = a.G(parcel);
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    list2 = a.c(parcel, F, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) a.a(parcel, F, DataHolder.CREATOR);
                    break;
                case 4:
                    z = a.c(parcel, F);
                    break;
                case 5:
                    list = a.C(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableEventList(i, list2, dataHolder, z, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bi(x0);
    }

    public ParcelableEventList[] cy(int i) {
        return new ParcelableEventList[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cy(x0);
    }
}
