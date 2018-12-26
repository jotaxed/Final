package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d implements SafeParcelable {
    public static final Creator<d> CREATOR = new e();
    private final int CK;
    LoyaltyWalletObject auJ;
    OfferWalletObject auK;

    d() {
        this.CK = 2;
    }

    d(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject) {
        this.CK = i;
        this.auJ = loyaltyWalletObject;
        this.auK = offerWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        e.a(this, dest, flags);
    }
}
