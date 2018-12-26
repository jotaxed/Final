package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m implements Creator<NotifyTransactionStatusRequest> {
    static void a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, notifyTransactionStatusRequest.CK);
        b.a(parcel, 2, notifyTransactionStatusRequest.auL, false);
        b.c(parcel, 3, notifyTransactionStatusRequest.status);
        b.a(parcel, 4, notifyTransactionStatusRequest.avL, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dU(x0);
    }

    public NotifyTransactionStatusRequest dU(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = a.G(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public NotifyTransactionStatusRequest[] gb(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gb(x0);
    }
}
