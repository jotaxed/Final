package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR = new f();
    private final int CK;
    String auL;
    String auM;
    ProxyCard auN;
    String auO;
    Address auP;
    Address auQ;
    String[] auR;
    UserAddress auS;
    UserAddress auT;
    InstrumentInfo[] auU;

    private FullWallet() {
        this.CK = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.CK = versionCode;
        this.auL = googleTransactionId;
        this.auM = merchantTransactionId;
        this.auN = proxyCard;
        this.auO = email;
        this.auP = billingAddress;
        this.auQ = shippingAddress;
        this.auR = paymentDescriptions;
        this.auS = buyerBillingAddress;
        this.auT = buyerShippingAddress;
        this.auU = instrumentInfos;
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

    public String getMerchantTransactionId() {
        return this.auM;
    }

    public String[] getPaymentDescriptions() {
        return this.auR;
    }

    public ProxyCard getProxyCard() {
        return this.auN;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.auQ;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel out, int flags) {
        f.a(this, out, flags);
    }
}
