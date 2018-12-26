package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR = new q();
    final int CK;
    final String SM;
    final boolean SN;
    final int mIndex;

    ParcelableIndexReference(int versionCode, String objectId, int index, boolean canBeDeleted) {
        this.CK = versionCode;
        this.SM = objectId;
        this.mIndex = index;
        this.SN = canBeDeleted;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        q.a(this, dest, flags);
    }
}
