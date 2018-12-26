package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR = new h();
    final int CK;
    final int SO;
    final int SP;
    final String Tk;
    final int Tl;
    final int mIndex;

    ValuesAddedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedFromId, int movedFromIndex) {
        this.CK = versionCode;
        this.mIndex = index;
        this.SO = valueIndex;
        this.SP = valueCount;
        this.Tk = movedFromId;
        this.Tl = movedFromIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        h.a(this, dest, flags);
    }
}
