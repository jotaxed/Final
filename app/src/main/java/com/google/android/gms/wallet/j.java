package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class j implements Creator<LoyaltyWalletObject> {
    static void a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, loyaltyWalletObject.getVersionCode());
        b.a(parcel, 2, loyaltyWalletObject.fl, false);
        b.a(parcel, 3, loyaltyWalletObject.avd, false);
        b.a(parcel, 4, loyaltyWalletObject.ave, false);
        b.a(parcel, 5, loyaltyWalletObject.avf, false);
        b.a(parcel, 6, loyaltyWalletObject.aki, false);
        b.a(parcel, 7, loyaltyWalletObject.avg, false);
        b.a(parcel, 8, loyaltyWalletObject.avh, false);
        b.a(parcel, 9, loyaltyWalletObject.avi, false);
        b.a(parcel, 10, loyaltyWalletObject.avj, false);
        b.a(parcel, 11, loyaltyWalletObject.avk, false);
        b.c(parcel, 12, loyaltyWalletObject.state);
        b.c(parcel, 13, loyaltyWalletObject.avl, false);
        b.a(parcel, 14, loyaltyWalletObject.avm, i, false);
        b.c(parcel, 15, loyaltyWalletObject.avn, false);
        b.a(parcel, 17, loyaltyWalletObject.avp, false);
        b.a(parcel, 16, loyaltyWalletObject.avo, false);
        b.a(parcel, 19, loyaltyWalletObject.avr);
        b.c(parcel, 18, loyaltyWalletObject.avq, false);
        b.c(parcel, 21, loyaltyWalletObject.avt, false);
        b.c(parcel, 20, loyaltyWalletObject.avs, false);
        b.a(parcel, 23, loyaltyWalletObject.avv, i, false);
        b.c(parcel, 22, loyaltyWalletObject.avu, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dR(x0);
    }

    public LoyaltyWalletObject dR(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList ie = la.ie();
        l lVar = null;
        ArrayList ie2 = la.ie();
        String str11 = null;
        String str12 = null;
        ArrayList ie3 = la.ie();
        boolean z = false;
        ArrayList ie4 = la.ie();
        ArrayList ie5 = la.ie();
        ArrayList ie6 = la.ie();
        f fVar = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    str3 = a.o(parcel, F);
                    break;
                case 5:
                    str4 = a.o(parcel, F);
                    break;
                case 6:
                    str5 = a.o(parcel, F);
                    break;
                case 7:
                    str6 = a.o(parcel, F);
                    break;
                case 8:
                    str7 = a.o(parcel, F);
                    break;
                case 9:
                    str8 = a.o(parcel, F);
                    break;
                case 10:
                    str9 = a.o(parcel, F);
                    break;
                case 11:
                    str10 = a.o(parcel, F);
                    break;
                case 12:
                    i2 = a.g(parcel, F);
                    break;
                case 13:
                    ie = a.c(parcel, F, p.CREATOR);
                    break;
                case 14:
                    lVar = (l) a.a(parcel, F, l.CREATOR);
                    break;
                case 15:
                    ie2 = a.c(parcel, F, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = a.o(parcel, F);
                    break;
                case 17:
                    str12 = a.o(parcel, F);
                    break;
                case 18:
                    ie3 = a.c(parcel, F, d.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = a.c(parcel, F);
                    break;
                case 20:
                    ie4 = a.c(parcel, F, n.CREATOR);
                    break;
                case 21:
                    ie5 = a.c(parcel, F, com.google.android.gms.wallet.wobs.j.CREATOR);
                    break;
                case 22:
                    ie6 = a.c(parcel, F, n.CREATOR);
                    break;
                case 23:
                    fVar = (f) a.a(parcel, F, f.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, ie, lVar, ie2, str11, str12, ie3, z, ie4, ie5, ie6, fVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public LoyaltyWalletObject[] fY(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fY(x0);
    }
}
