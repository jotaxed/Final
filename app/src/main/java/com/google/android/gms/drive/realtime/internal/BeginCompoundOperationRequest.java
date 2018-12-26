package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Creator<BeginCompoundOperationRequest> CREATOR = new a();
    final int CK;
    final boolean SF;
    final boolean SG;
    final String mName;

    BeginCompoundOperationRequest(int versionCode, boolean isCreation, String name, boolean isUndoable) {
        this.CK = versionCode;
        this.SF = isCreation;
        this.mName = name;
        this.SG = isUndoable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
