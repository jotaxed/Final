package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class y implements SafeParcelable {
    public static final z CREATOR = new z();
    private final Point alK;
    private final int versionCode;

    public y(int i, Point point) {
        this.versionCode = i;
        this.alK = point;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof y)) {
            return false;
        }
        return this.alK.equals(((y) o).alK);
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.alK.hashCode();
    }

    public Point oa() {
        return this.alK;
    }

    public String toString() {
        return this.alK.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        z.a(this, out, flags);
    }
}
