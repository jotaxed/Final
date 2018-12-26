package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new l();
    private final int CK;
    String auG;
    String auM;
    Cart auV;
    boolean avA;
    boolean avB;
    String avC;
    String avD;
    boolean avE;
    boolean avF;
    CountrySpecification[] avG;
    boolean avH;
    boolean avI;
    ArrayList<CountrySpecification> avJ;
    boolean avz;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest avK;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.avK = maskedWalletRequest;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.avK.avJ == null) {
                this.avK.avJ = new ArrayList();
            }
            this.avK.avJ.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (this.avK.avJ == null) {
                    this.avK.avJ = new ArrayList();
                }
                this.avK.avJ.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return this.avK;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            this.avK.avI = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            this.avK.avH = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.avK.auV = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.avK.auG = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            this.avK.avC = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            this.avK.avF = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            this.avK.avD = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.avK.auM = merchantTransactionId;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            this.avK.avz = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            this.avK.avA = shippingAddressRequired;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean shouldRetrieveWalletObjects) {
            this.avK.avE = shouldRetrieveWalletObjects;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            this.avK.avB = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.CK = 3;
        this.avH = true;
        this.avI = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping) {
        this.CK = versionCode;
        this.auM = merchantTransactionId;
        this.avz = phoneNumberRequired;
        this.avA = shippingAddressRequired;
        this.avB = useMinimalBillingAddress;
        this.avC = estimatedTotalPrice;
        this.auG = currencyCode;
        this.avD = merchantName;
        this.auV = cart;
        this.avE = shouldRetrieveWalletObjects;
        this.avF = isBillingAgreement;
        this.avG = allowedShippingCountrySpecifications;
        this.avH = allowPrepaidCard;
        this.avI = allowDebitCard;
        this.avJ = allowedCountrySpecificationsForShipping;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.avI;
    }

    public boolean allowPrepaidCard() {
        return this.avH;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.avJ;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.avG;
    }

    public Cart getCart() {
        return this.auV;
    }

    public String getCurrencyCode() {
        return this.auG;
    }

    public String getEstimatedTotalPrice() {
        return this.avC;
    }

    public String getMerchantName() {
        return this.avD;
    }

    public String getMerchantTransactionId() {
        return this.auM;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public boolean isBillingAgreement() {
        return this.avF;
    }

    public boolean isPhoneNumberRequired() {
        return this.avz;
    }

    public boolean isShippingAddressRequired() {
        return this.avA;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.avE;
    }

    public boolean useMinimalBillingAddress() {
        return this.avB;
    }

    public void writeToParcel(Parcel dest, int flags) {
        l.a(this, dest, flags);
    }
}
