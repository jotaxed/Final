package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.hl.a;

public class hm implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, aVar.Dc, i, false);
        b.c(parcel, 1000, aVar.CK);
        b.H(parcel, H);
    }

    public a[] N(int i) {
        return new a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return p(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return N(x0);
    }

    public a p(Parcel parcel) {
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        Account account = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, Account.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new a(i, account);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }
}
