package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class as implements Creator<OnListParentsResponse> {
    static void a(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onListParentsResponse.CK);
        b.a(parcel, 2, onListParentsResponse.QR, i, false);
        b.H(parcel, H);
    }

    public OnListParentsResponse ax(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    dataHolder = (DataHolder) a.a(parcel, F, DataHolder.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnListParentsResponse[] bM(int i) {
        return new OnListParentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ax(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bM(x0);
    }
}
