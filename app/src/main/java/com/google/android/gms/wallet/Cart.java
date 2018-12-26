package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new b();
    private final int CK;
    String auF;
    String auG;
    ArrayList<LineItem> auH;

    public final class Builder {
        final /* synthetic */ Cart auI;

        private Builder(Cart cart) {
            this.auI = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.auI.auH.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.auI;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.auI.auG = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            this.auI.auH.clear();
            this.auI.auH.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.auI.auF = totalPrice;
            return this;
        }
    }

    Cart() {
        this.CK = 1;
        this.auH = new ArrayList();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.CK = versionCode;
        this.auF = totalPrice;
        this.auG = currencyCode;
        this.auH = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.auG;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.auH;
    }

    public String getTotalPrice() {
        return this.auF;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        b.a(this, dest, flags);
    }
}
