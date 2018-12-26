package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final m CREATOR = new m();
    private final int CK;
    private float alU;
    private int alV;
    private int alW;
    private float alX;
    private boolean alY;
    private final List<LatLng> amx;
    private final List<List<LatLng>> amy;
    private boolean amz;

    public PolygonOptions() {
        this.alU = 10.0f;
        this.alV = -16777216;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = 1;
        this.amx = new ArrayList();
        this.amy = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.alU = 10.0f;
        this.alV = -16777216;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = versionCode;
        this.amx = points;
        this.amy = holes;
        this.alU = strokeWidth;
        this.alV = strokeColor;
        this.alW = fillColor;
        this.alX = zIndex;
        this.alY = visible;
        this.amz = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.amx.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.amx.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.amx.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.amy.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.alW = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.amz = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.alW;
    }

    public List<List<LatLng>> getHoles() {
        return this.amy;
    }

    public List<LatLng> getPoints() {
        return this.amx;
    }

    public int getStrokeColor() {
        return this.alV;
    }

    public float getStrokeWidth() {
        return this.alU;
    }

    int getVersionCode() {
        return this.CK;
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

    List of() {
        return this.amy;
    }

    public PolygonOptions strokeColor(int color) {
        this.alV = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.alU = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            n.a(this, out, flags);
        } else {
            m.a(this, out, flags);
        }
    }

    public PolygonOptions zIndex(float zIndex) {
        this.alX = zIndex;
        return this;
    }
}
