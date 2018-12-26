package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR = new c();
    final int CK;
    final DataHolder Tb;
    final boolean Tc;
    final List<String> Td;
    final List<ParcelableEvent> mp;

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds) {
        this.CK = versionCode;
        this.mp = events;
        this.Tb = eventData;
        this.Tc = undoRedoStateChanged;
        this.Td = affectedObjectIds;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
