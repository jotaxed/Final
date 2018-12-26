package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR = new a();
    private final int CK;
    String afK;
    String afL;
    String afM;
    String afR;
    String afT;
    boolean afU;
    String afV;
    String auD;
    String auE;
    String name;
    String vk;

    Address() {
        this.CK = 1;
    }

    Address(int versionCode, String name, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.CK = versionCode;
        this.name = name;
        this.afK = address1;
        this.afL = address2;
        this.afM = address3;
        this.vk = countryCode;
        this.auD = city;
        this.auE = state;
        this.afR = postalCode;
        this.afT = phoneNumber;
        this.afU = isPostBox;
        this.afV = companyName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.afK;
    }

    public String getAddress2() {
        return this.afL;
    }

    public String getAddress3() {
        return this.afM;
    }

    public String getCity() {
        return this.auD;
    }

    public String getCompanyName() {
        return this.afV;
    }

    public String getCountryCode() {
        return this.vk;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.afT;
    }

    public String getPostalCode() {
        return this.afR;
    }

    public String getState() {
        return this.auE;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public boolean isPostBox() {
        return this.afU;
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}
