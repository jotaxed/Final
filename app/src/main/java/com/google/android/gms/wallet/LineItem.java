package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new i();
    private final int CK;
    String auF;
    String auG;
    String auZ;
    String ava;
    int avb;
    String description;

    public final class Builder {
        final /* synthetic */ LineItem avc;

        private Builder(LineItem lineItem) {
            this.avc = lineItem;
        }

        public LineItem build() {
            return this.avc;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.avc.auG = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.avc.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.avc.auZ = quantity;
            return this;
        }

        public Builder setRole(int role) {
            this.avc.avb = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.avc.auF = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            this.avc.ava = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.CK = 1;
        this.avb = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.CK = versionCode;
        this.description = description;
        this.auZ = quantity;
        this.ava = unitPrice;
        this.auF = totalPrice;
        this.avb = role;
        this.auG = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.auG;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.auZ;
    }

    public int getRole() {
        return this.avb;
    }

    public String getTotalPrice() {
        return this.auF;
    }

    public String getUnitPrice() {
        return this.ava;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        i.a(this, dest, flags);
    }
}
