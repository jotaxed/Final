package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class AccountChangeEventsResponseCreator implements Creator<AccountChangeEventsResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(AccountChangeEventsResponse accountChangeEventsResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, accountChangeEventsResponse.Ef);
        b.c(parcel, 2, accountChangeEventsResponse.mp, false);
        b.H(parcel, H);
    }

    public AccountChangeEventsResponse createFromParcel(Parcel parcel) {
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
                    list = a.c(parcel, F, AccountChangeEvent.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AccountChangeEventsResponse(i, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public AccountChangeEventsResponse[] newArray(int size) {
        return new AccountChangeEventsResponse[size];
    }
}
