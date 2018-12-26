package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final o CREATOR = new o();
    private final int CK;
    private float alX;
    private boolean alY;
    private float amc;
    private final List<LatLng> amx;
    private boolean amz;
    private int mColor;

    public PolylineOptions() {
        this.amc = 10.0f;
        this.mColor = -16777216;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = 1;
        this.amx = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.amc = 10.0f;
        this.mColor = -16777216;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = versionCode;
        this.amx = points;
        this.amc = width;
        this.mColor = color;
        this.alX = zIndex;
        this.alY = visible;
        this.amz = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.amx.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.amx.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.amx.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.mColor = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.amz = geodesic;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.amx;
    }

    int getVersionCode() {
        return this.CK;
    }

    public float getWidth() {
        return this.amc;
    }

    public float getZIndex() {
        return this.alX;
    }

    public boolean isGeodesic() {
        return this.amz;
    }

    public boolean isVisible() {
        return this.alY;
    }

    public PolylineOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.amc = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            p.a(this, out, flags);
        } else {
            o.a(this, out, flags);
        }
    }

    public PolylineOptions zIndex(float zIndex) {
        this.alX = zIndex;
        return this;
    }
}
