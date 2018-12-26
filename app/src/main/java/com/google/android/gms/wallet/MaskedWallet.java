package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.jx;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new k();
    private final int CK;
    String auL;
    String auM;
    String auO;
    Address auP;
    Address auQ;
    String[] auR;
    UserAddress auS;
    UserAddress auT;
    InstrumentInfo[] auU;
    LoyaltyWalletObject[] avw;
    OfferWalletObject[] avx;

    public final class Builder {
        final /* synthetic */ MaskedWallet avy;

        private Builder(MaskedWallet maskedWallet) {
            this.avy = maskedWallet;
        }

        public MaskedWallet build() {
            return this.avy;
        }

        public Builder setBillingAddress(Address billingAddress) {
            this.avy.auP = billingAddress;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress buyerBillingAddress) {
            this.avy.auS = buyerBillingAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress buyerShippingAddress) {
            this.avy.auT = buyerShippingAddress;
            return this;
        }

        public Builder setEmail(String email) {
            this.avy.auO = email;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.avy.auL = googleTransactionId;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfos) {
            this.avy.auU = instrumentInfos;
            return this;
        }

        public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] loyaltyWalletObjects) {
            this.avy.avw = loyaltyWalletObjects;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.avy.auM = merchantTransactionId;
            return this;
        }

        public Builder setOfferWalletObjects(OfferWalletObject[] offerWalletObjects) {
            this.avy.avx = offerWalletObjects;
            return this;
        }

        public Builder setPaymentDescriptions(String[] paymentDescriptions) {
            this.avy.auR = paymentDescriptions;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            this.avy.auQ = shippingAddress;
            return this;
        }
    }

    private MaskedWallet() {
        this.CK = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.CK = versionCode;
        this.auL = googleTransactionId;
        this.auM = merchantTransactionId;
        this.auR = paymentDescriptions;
        this.auO = email;
        this.auP = billingAddress;
        this.auQ = shippingAddress;
        this.avw = loyaltyWalletObjects;
        this.avx = offerWalletObjects;
        this.auS = buyerBillingAddress;
        this.auT = buyerShippingAddress;
        this.auU = instrumentInfos;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        jx.i(maskedWallet);
        return rd().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).setLoyaltyWalletObjects(maskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder rd() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.auP;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.auS;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.auT;
    }

    public String getEmail() {
        return this.auO;
    }

    public String getGoogleTransactionId() {
        return this.auL;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.auU;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.avw;
    }

    public String getMerchantTransactionId() {
        return this.auM;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.avx;
    }

    public String[] getPaymentDescriptions() {
        return this.auR;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.auQ;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        k.a(this, dest, flags);
    }
}
