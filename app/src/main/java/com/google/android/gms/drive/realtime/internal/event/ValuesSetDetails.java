package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR = new j();
    final int CK;
    final int SO;
    final int SP;
    final int mIndex;

    ValuesSetDetails(int versionCode, int index, int valueIndex, int valueCount) {
        this.CK = versionCode;
        this.mIndex = index;
        this.SO = valueIndex;
        this.SP = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        j.a(this, dest, flags);
    }
}
