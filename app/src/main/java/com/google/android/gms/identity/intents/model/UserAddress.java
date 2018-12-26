package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR = new b();
    private final int CK;
    String afK;
    String afL;
    String afM;
    String afN;
    String afO;
    String afP;
    String afQ;
    String afR;
    String afS;
    String afT;
    boolean afU;
    String afV;
    String afW;
    String name;
    String vk;

    UserAddress() {
        this.CK = 1;
    }

    UserAddress(int versionCode, String name, String address1, String address2, String address3, String address4, String address5, String administrativeArea, String locality, String countryCode, String postalCode, String sortingCode, String phoneNumber, boolean isPostBox, String companyName, String emailAddress) {
        this.CK = versionCode;
        this.name = name;
        this.afK = address1;
        this.afL = address2;
        this.afM = address3;
        this.afN = address4;
        this.afO = address5;
        this.afP = administrativeArea;
        this.afQ = locality;
        this.vk = countryCode;
        this.afR = postalCode;
        this.afS = sortingCode;
        this.afT = phoneNumber;
        this.afU = isPostBox;
        this.afV = companyName;
        this.afW = emailAddress;
    }

    public static UserAddress fromIntent(Intent data) {
        return (data == null || !data.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) data.getParcelableExtra(Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.afN;
    }

    public String getAddress5() {
        return this.afO;
    }

    public String getAdministrativeArea() {
        return this.afP;
    }

    public String getCompanyName() {
        return this.afV;
    }

    public String getCountryCode() {
        return this.vk;
    }

    public String getEmailAddress() {
        return this.afW;
    }

    public String getLocality() {
        return this.afQ;
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

    public String getSortingCode() {
        return this.afS;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public boolean isPostBox() {
        return this.afU;
    }

    public void writeToParcel(Parcel out, int flags) {
        b.a(this, out, flags);
    }
}
