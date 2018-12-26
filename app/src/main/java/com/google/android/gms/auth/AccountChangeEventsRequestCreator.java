package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AccountChangeEventsRequestCreator implements Creator<AccountChangeEventsRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, accountChangeEventsRequest.Ef);
        b.c(parcel, 2, accountChangeEventsRequest.Ei);
        b.a(parcel, 3, accountChangeEventsRequest.DZ, false);
        b.H(parcel, H);
    }

    public AccountChangeEventsRequest createFromParcel(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
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
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AccountChangeEventsRequest(i2, i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public AccountChangeEventsRequest[] newArray(int size) {
        return new AccountChangeEventsRequest[size];
    }
}
