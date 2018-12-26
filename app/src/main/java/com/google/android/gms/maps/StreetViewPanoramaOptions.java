package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final c CREATOR = new c();
    private final int CK;
    private Boolean akG;
    private Boolean akM;
    private StreetViewPanoramaCamera alr;
    private String als;
    private LatLng alt;
    private Integer alu;
    private Boolean alv;
    private Boolean alw;
    private Boolean alx;

    public StreetViewPanoramaOptions() {
        this.alv = Boolean.valueOf(true);
        this.akM = Boolean.valueOf(true);
        this.alw = Boolean.valueOf(true);
        this.alx = Boolean.valueOf(true);
        this.CK = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.alv = Boolean.valueOf(true);
        this.akM = Boolean.valueOf(true);
        this.alw = Boolean.valueOf(true);
        this.alx = Boolean.valueOf(true);
        this.CK = versionCode;
        this.alr = camera;
        this.alt = position;
        this.alu = radius;
        this.als = panoId;
        this.alv = a.a(userNavigationEnabled);
        this.akM = a.a(zoomGesturesEnabled);
        this.alw = a.a(panningGesturesEnabled);
        this.alx = a.a(streetNamesEnabled);
        this.akG = a.a(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.alw;
    }

    public String getPanoramaId() {
        return this.als;
    }

    public LatLng getPosition() {
        return this.alt;
    }

    public Integer getRadius() {
        return this.alu;
    }

    public Boolean getStreetNamesEnabled() {
        return this.alx;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.alr;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.akG;
    }

    public Boolean getUserNavigationEnabled() {
        return this.alv;
    }

    int getVersionCode() {
        return this.CK;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.akM;
    }

    byte nE() {
        return a.c(this.akG);
    }

    byte nI() {
        return a.c(this.akM);
    }

    byte nS() {
        return a.c(this.alv);
    }

    byte nT() {
        return a.c(this.alw);
    }

    byte nU() {
        return a.c(this.alx);
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.alw = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.alr = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.als = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.alt = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.alt = position;
        this.alu = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.alx = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.akG = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.alv = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        c.a(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.akM = Boolean.valueOf(enabled);
        return this;
    }
}
