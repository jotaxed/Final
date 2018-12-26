package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;

public final class CircleOptions implements SafeParcelable {
    public static final c CREATOR = new c();
    private final int CK;
    private LatLng alS;
    private double alT;
    private float alU;
    private int alV;
    private int alW;
    private float alX;
    private boolean alY;

    public CircleOptions() {
        this.alS = null;
        this.alT = 0.0d;
        this.alU = 10.0f;
        this.alV = -16777216;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.CK = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.alS = null;
        this.alT = 0.0d;
        this.alU = 10.0f;
        this.alV = -16777216;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.CK = versionCode;
        this.alS = center;
        this.alT = radius;
        this.alU = strokeWidth;
        this.alV = strokeColor;
        this.alW = fillColor;
        this.alX = zIndex;
        this.alY = visible;
    }

    public CircleOptions center(LatLng center) {
        this.alS = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.alW = color;
        return this;
    }

    public LatLng getCenter() {
        return this.alS;
    }

    public int getFillColor() {
        return this.alW;
    }

    public double getRadius() {
        return this.alT;
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

    public boolean isVisible() {
        return this.alY;
    }

    public CircleOptions radius(double radius) {
        this.alT = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.alV = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.alU = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            d.a(this, out, flags);
        } else {
            c.a(this, out, flags);
        }
    }

    public CircleOptions zIndex(float zIndex) {
        this.alX = zIndex;
        return this;
    }
}
