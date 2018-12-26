package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AccountChangeEventCreator implements Creator<AccountChangeEvent> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, accountChangeEvent.Ef);
        b.a(parcel, 2, accountChangeEvent.Eg);
        b.a(parcel, 3, accountChangeEvent.DZ, false);
        b.c(parcel, 4, accountChangeEvent.Eh);
        b.c(parcel, 5, accountChangeEvent.Ei);
        b.a(parcel, 6, accountChangeEvent.Ej, false);
        b.H(parcel, H);
    }

    public AccountChangeEvent createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = a.G(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    i = a.g(parcel, F);
                    break;
                case 6:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public AccountChangeEvent[] newArray(int size) {
        return new AccountChangeEvent[size];
    }
}
