package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new o();
    private final int CK;
    String avP;
    String avQ;
    int avR;
    int avS;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.CK = versionCode;
        this.avP = pan;
        this.avQ = cvn;
        this.avR = expirationMonth;
        this.avS = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.avQ;
    }

    public int getExpirationMonth() {
        return this.avR;
    }

    public int getExpirationYear() {
        return this.avS;
    }

    public String getPan() {
        return this.avP;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel out, int flags) {
        o.a(this, out, flags);
    }
}
