package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;

public class b implements SafeParcelable {
    public static final Creator<b> CREATOR = new c();
    private final int CK;
    private final String VF;
    private final BleDevice VG;

    b(int i, String str, BleDevice bleDevice) {
        this.CK = i;
        this.VF = str;
        this.VG = bleDevice;
    }

    public b(BleDevice bleDevice) {
        this(2, bleDevice.getAddress(), bleDevice);
    }

    public b(String str) {
        this(2, str, null);
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.VF;
    }

    int getVersionCode() {
        return this.CK;
    }

    public BleDevice jQ() {
        return this.VG;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.VF, this.VG});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        c.a(this, parcel, flags);
    }
}
