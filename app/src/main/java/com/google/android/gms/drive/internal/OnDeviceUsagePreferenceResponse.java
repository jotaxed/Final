package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR = new am();
    final int CK;
    final FileUploadPreferencesImpl QK;

    OnDeviceUsagePreferenceResponse(int versionCode, FileUploadPreferencesImpl preferences) {
        this.CK = versionCode;
        this.QK = preferences;
    }

    public int describeContents() {
        return 0;
    }

    public FileUploadPreferencesImpl iN() {
        return this.QK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        am.a(this, dest, flags);
    }
}
