package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new a();
    final int CK;
    private String DZ;
    private MaskedWalletRequest awg;
    private MaskedWallet awh;
    private int awu;

    public final class Builder {
        final /* synthetic */ WalletFragmentInitParams awv;

        private Builder(WalletFragmentInitParams walletFragmentInitParams) {
            this.awv = walletFragmentInitParams;
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (this.awv.awh != null && this.awv.awg == null) || (this.awv.awh == null && this.awv.awg != null);
            jx.a(z2, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (this.awv.awu < 0) {
                z = false;
            }
            jx.a(z, "masked wallet request code is required and must be non-negative");
            return this.awv;
        }

        public Builder setAccountName(String accountName) {
            this.awv.DZ = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            this.awv.awh = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            this.awv.awg = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            this.awv.awu = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.CK = 1;
        this.awu = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.CK = versionCode;
        this.DZ = accountName;
        this.awg = maskedWalletRequest;
        this.awu = maskedWalletRequestCode;
        this.awh = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.DZ;
    }

    public MaskedWallet getMaskedWallet() {
        return this.awh;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.awg;
    }

    public int getMaskedWalletRequestCode() {
        return this.awu;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
