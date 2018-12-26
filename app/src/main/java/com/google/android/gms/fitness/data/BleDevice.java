package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.ls;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR = new c();
    private final int CK;
    private final String TW;
    private final List<String> TX;
    private final List<DataType> TY;
    private final String mName;

    BleDevice(int versionCode, String address, String name, List<String> profiles, List<DataType> dataTypes) {
        this.CK = versionCode;
        this.TW = address;
        this.mName = name;
        this.TX = Collections.unmodifiableList(profiles);
        this.TY = Collections.unmodifiableList(dataTypes);
    }

    private boolean a(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.TW.equals(bleDevice.TW) && ls.a(bleDevice.TX, this.TX) && ls.a(this.TY, bleDevice.TY);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof BleDevice) && a((BleDevice) o));
    }

    public String getAddress() {
        return this.TW;
    }

    public List<DataType> getDataTypes() {
        return this.TY;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.TX;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.TW, this.TX, this.TY);
    }

    public String toString() {
        return jv.h(this).a("name", this.mName).a("address", this.TW).a("dataTypes", this.TY).a("supportedProfiles", this.TX).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        c.a(this, parcel, flags);
    }
}
