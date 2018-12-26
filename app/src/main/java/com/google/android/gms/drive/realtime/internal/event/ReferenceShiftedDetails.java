package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR = new d();
    final int CK;
    final String Te;
    final String Tf;
    final int Tg;
    final int Th;

    ReferenceShiftedDetails(int versionCode, String oldObjectId, String newObjectId, int oldIndex, int newIndex) {
        this.CK = versionCode;
        this.Te = oldObjectId;
        this.Tf = newObjectId;
        this.Tg = oldIndex;
        this.Th = newIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        d.a(this, dest, flags);
    }
}
