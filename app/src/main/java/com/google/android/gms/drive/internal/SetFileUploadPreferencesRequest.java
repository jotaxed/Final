package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
    public static final Creator<SetFileUploadPreferencesRequest> CREATOR = new be();
    final int CK;
    final FileUploadPreferencesImpl QK;

    SetFileUploadPreferencesRequest(int versionCode, FileUploadPreferencesImpl preferences) {
        this.CK = versionCode;
        this.QK = preferences;
    }

    public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl preferences) {
        this(1, preferences);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        be.a(this, dest, flags);
    }
}
