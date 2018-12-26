package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ah implements SafeParcelable {
    public static final Creator<ah> CREATOR = new ai();
    private final int CK;
    private final String VF;

    ah(int i, String str) {
        this.CK = i;
        this.VF = str;
    }

    public ah(String str) {
        this(3, str);
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

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.VF});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ai.a(this, parcel, flags);
    }
}
