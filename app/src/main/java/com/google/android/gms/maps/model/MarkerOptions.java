package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.internal.aa;

public final class MarkerOptions implements SafeParcelable {
    public static final k CREATOR = new k();
    private final int CK;
    private String OH;
    private boolean alY;
    private LatLng alt;
    private float amg;
    private float amh;
    private String amp;
    private BitmapDescriptor amq;
    private boolean amr;
    private boolean ams;
    private float amt;
    private float amu;
    private float amv;
    private float mAlpha;

    public MarkerOptions() {
        this.amg = 0.5f;
        this.amh = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.alY = true;
        this.ams = false;
        this.amt = 0.0f;
        this.amu = 0.5f;
        this.amv = 0.0f;
        this.mAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.CK = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV, float alpha) {
        this.amg = 0.5f;
        this.amh = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.alY = true;
        this.ams = false;
        this.amt = 0.0f;
        this.amu = 0.5f;
        this.amv = 0.0f;
        this.mAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.CK = versionCode;
        this.alt = position;
        this.OH = title;
        this.amp = snippet;
        this.amq = wrappedIcon == null ? null : new BitmapDescriptor(a.ap(wrappedIcon));
        this.amg = anchorU;
        this.amh = anchorV;
        this.amr = draggable;
        this.alY = visible;
        this.ams = flat;
        this.amt = rotation;
        this.amu = infoWindowAnchorU;
        this.amv = infoWindowAnchorV;
        this.mAlpha = alpha;
    }

    public MarkerOptions alpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public MarkerOptions anchor(float u, float v) {
        this.amg = u;
        this.amh = v;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.amr = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.ams = flat;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.amg;
    }

    public float getAnchorV() {
        return this.amh;
    }

    public BitmapDescriptor getIcon() {
        return this.amq;
    }

    public float getInfoWindowAnchorU() {
        return this.amu;
    }

    public float getInfoWindowAnchorV() {
        return this.amv;
    }

    public LatLng getPosition() {
        return this.alt;
    }

    public float getRotation() {
        return this.amt;
    }

    public String getSnippet() {
        return this.amp;
    }

    public String getTitle() {
        return this.OH;
    }

    int getVersionCode() {
        return this.CK;
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.amq = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.amu = u;
        this.amv = v;
        return this;
    }

    public boolean isDraggable() {
        return this.amr;
    }

    public boolean isFlat() {
        return this.ams;
    }

    public boolean isVisible() {
        return this.alY;
    }

    IBinder oe() {
        return this.amq == null ? null : this.amq.nA().asBinder();
    }

    public MarkerOptions position(LatLng position) {
        this.alt = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.amt = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.amp = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.OH = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            l.a(this, out, flags);
        } else {
            k.a(this, out, flags);
        }
    }
}
