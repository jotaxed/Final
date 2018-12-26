package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class e implements SafeParcelable {
    public static final f CREATOR = new f();
    private final int CK;
    int agw;
    int agx;
    long agy;

    public e(int i, int i2, int i3, long j) {
        this.CK = i;
        this.agw = i2;
        this.agx = i3;
        this.agy = j;
    }

    private String eB(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return this.agw == eVar.agw && this.agx == eVar.agx && this.agy == eVar.agy;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.agw), Integer.valueOf(this.agx), Long.valueOf(this.agy));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(eB(this.agw));
        stringBuilder.append(", wifi status: ").append(eB(this.agx));
        stringBuilder.append(", elapsed realtime ns: ").append(this.agy);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        f.a(this, parcel, flags);
    }
}
