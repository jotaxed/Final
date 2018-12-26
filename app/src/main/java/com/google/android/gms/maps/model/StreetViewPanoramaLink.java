package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final r CREATOR = new r();
    private final int CK;
    public final float bearing;
    public final String panoId;

    StreetViewPanoramaLink(int versionCode, String panoId, float bearing) {
        this.CK = versionCode;
        this.panoId = panoId;
        if (((double) bearing) <= 0.0d) {
            bearing = (bearing % 360.0f) + 360.0f;
        }
        this.bearing = bearing % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) o;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return jv.h(this).a("panoId", this.panoId).a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        r.a(this, out, flags);
    }
}
