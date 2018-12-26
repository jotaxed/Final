package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails implements SafeParcelable {
    public static final Creator<ObjectChangedDetails> CREATOR = new a();
    final int CK;
    final int SO;
    final int SP;

    ObjectChangedDetails(int versionCode, int valueIndex, int valueCount) {
        this.CK = versionCode;
        this.SO = valueIndex;
        this.SP = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
