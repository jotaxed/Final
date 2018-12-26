package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails implements SafeParcelable {
    public static final Creator<ValueChangedDetails> CREATOR = new g();
    final int CK;
    final int Tj;

    ValueChangedDetails(int versionCode, int keyIndex) {
        this.CK = versionCode;
        this.Tj = keyIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        g.a(this, dest, flags);
    }
}
