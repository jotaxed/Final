package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class he implements Creator<hd> {
    static void a(hd hdVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, hdVar.CL, i, false);
        b.c(parcel, 1000, hdVar.CK);
        b.a(parcel, 2, hdVar.CM, false);
        b.a(parcel, 3, hdVar.CN);
        b.a(parcel, 4, hdVar.account, i, false);
        b.H(parcel, H);
    }

    public hd[] J(int i) {
        return new hd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return l(x0);
    }

    public hd l(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int G = a.G(parcel);
        String str = null;
        hh[] hhVarArr = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    hhVarArr = (hh[]) a.b(parcel, F, hh.CREATOR);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    z = a.c(parcel, F);
                    break;
                case 4:
                    account = (Account) a.a(parcel, F, Account.CREATOR);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hd(i, hhVarArr, str, z, account);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return J(x0);
    }
}
