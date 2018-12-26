package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Creator<OnLoadRealtimeResponse> CREATOR = new au();
    final int CK;
    final boolean wg;

    OnLoadRealtimeResponse(int versionCode, boolean isInitialized) {
        this.CK = versionCode;
        this.wg = isInitialized;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        au.a(this, dest, flags);
    }
}
