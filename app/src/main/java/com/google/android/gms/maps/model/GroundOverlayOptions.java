package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final e CREATOR = new e();
    public static final float NO_DIMENSION = -1.0f;
    private final int CK;
    private float alQ;
    private float alX;
    private boolean alY;
    private BitmapDescriptor ama;
    private LatLng amb;
    private float amc;
    private float amd;
    private LatLngBounds ame;
    private float amf;
    private float amg;
    private float amh;

    public GroundOverlayOptions() {
        this.alY = true;
        this.amf = 0.0f;
        this.amg = 0.5f;
        this.amh = 0.5f;
        this.CK = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.alY = true;
        this.amf = 0.0f;
        this.amg = 0.5f;
        this.amh = 0.5f;
        this.CK = versionCode;
        this.ama = new BitmapDescriptor(a.ap(wrappedImage));
        this.amb = location;
        this.amc = width;
        this.amd = height;
        this.ame = bounds;
        this.alQ = bearing;
        this.alX = zIndex;
        this.alY = visible;
        this.amf = transparency;
        this.amg = anchorU;
        this.amh = anchorV;
    }

    private GroundOverlayOptions a(LatLng latLng, float f, float f2) {
        this.amb = latLng;
        this.amc = f;
        this.amd = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.amg = u;
        this.amh = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.alQ = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.amg;
    }

    public float getAnchorV() {
        return this.amh;
    }

    public float getBearing() {
        return this.alQ;
    }

    public LatLngBounds getBounds() {
        return this.ame;
    }

    public float getHeight() {
        return this.amd;
    }

    public BitmapDescriptor getImage() {
        return this.ama;
    }

    public LatLng getLocation() {
        return this.amb;
    }

    public float getTransparency() {
        return this.amf;
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

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.ama = image;
        return this;
    }

    public boolean isVisible() {
        return this.alY;
    }

    IBinder od() {
        return this.ama.nA().asBinder();
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        jx.a(this.ame == null, "Position has already been set using positionFromBounds");
        jx.b(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        jx.b(z, (Object) "Width must be non-negative");
        return a(location, width, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        jx.a(this.ame == null, "Position has already been set using positionFromBounds");
        jx.b(location != null, (Object) "Location must be specified");
        jx.b(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        jx.b(z, (Object) "Height must be non-negative");
        return a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        jx.a(this.amb == null, "Position has already been set using position: " + this.amb);
        this.ame = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= TextTrackStyle.DEFAULT_FONT_SCALE;
        jx.b(z, (Object) "Transparency must be in the range [0..1]");
        this.amf = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            f.a(this, out, flags);
        } else {
            e.a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.alX = zIndex;
        return this;
    }
}
