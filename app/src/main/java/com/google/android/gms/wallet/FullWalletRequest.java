package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR = new g();
    private final int CK;
    String auL;
    String auM;
    Cart auV;

    public final class Builder {
        final /* synthetic */ FullWalletRequest auW;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.auW = fullWalletRequest;
        }

        public FullWalletRequest build() {
            return this.auW;
        }

        public Builder setCart(Cart cart) {
            this.auW.auV = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.auW.auL = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.auW.auM = merchantTransactionId;
            return this;
        }
    }

    FullWalletRequest() {
        this.CK = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.CK = versionCode;
        this.auL = googleTransactionId;
        this.auM = merchantTransactionId;
        this.auV = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.auV;
    }

    public String getGoogleTransactionId() {
        return this.auL;
    }

    public String getMerchantTransactionId() {
        return this.auM;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        g.a(this, dest, flags);
    }
}
