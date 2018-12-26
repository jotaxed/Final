package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class LatLngBounds implements SafeParcelable {
    public static final g CREATOR = new g();
    private final int CK;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double amk = Double.POSITIVE_INFINITY;
        private double aml = Double.NEGATIVE_INFINITY;
        private double amm = Double.NaN;
        private double amn = Double.NaN;

        private boolean d(double d) {
            boolean z = false;
            if (this.amm <= this.amn) {
                return this.amm <= d && d <= this.amn;
            } else {
                if (this.amm <= d || d <= this.amn) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            jx.a(!Double.isNaN(this.amm), "no included points");
            return new LatLngBounds(new LatLng(this.amk, this.amm), new LatLng(this.aml, this.amn));
        }

        public Builder include(LatLng point) {
            this.amk = Math.min(this.amk, point.latitude);
            this.aml = Math.max(this.aml, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.amm)) {
                this.amm = d;
                this.amn = d;
            } else if (!d(d)) {
                if (LatLngBounds.b(this.amm, d) < LatLngBounds.c(this.amn, d)) {
                    this.amm = d;
                } else {
                    this.amn = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest, LatLng northeast) {
        jx.b((Object) southwest, (Object) "null southwest");
        jx.b((Object) northeast, (Object) "null northeast");
        jx.b(northeast.latitude >= southwest.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest.latitude), Double.valueOf(northeast.latitude));
        this.CK = versionCode;
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(1, southwest, northeast);
    }

    private static double b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean c(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean d(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public boolean contains(LatLng point) {
        return c(point.latitude) && d(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = point.longitude;
        if (d(d3)) {
            d3 = d2;
            d2 = d;
        } else if (b(d2, d3) < c(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return jv.h(this).a("southwest", this.southwest).a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            h.a(this, out, flags);
        } else {
            g.a(this, out, flags);
        }
    }
}
