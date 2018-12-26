package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR = new i();
    final int CK;
    final int SO;
    final int SP;
    final String Tm;
    final int Tn;
    final int mIndex;

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.CK = versionCode;
        this.mIndex = index;
        this.SO = valueIndex;
        this.SP = valueCount;
        this.Tm = movedToId;
        this.Tn = movedToIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        i.a(this, dest, flags);
    }
}
