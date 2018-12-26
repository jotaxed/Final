package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new a();
    private final int CK;
    String vk;

    CountrySpecification(int versionCode, String countryCode) {
        this.CK = versionCode;
        this.vk = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.CK = 1;
        this.vk = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.vk;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
