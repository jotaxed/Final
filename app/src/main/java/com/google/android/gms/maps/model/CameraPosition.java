package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class CameraPosition implements SafeParcelable {
    public static final a CREATOR = new a();
    private final int CK;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private LatLng alN;
        private float alO;
        private float alP;
        private float alQ;

        public Builder(CameraPosition previous) {
            this.alN = previous.target;
            this.alO = previous.zoom;
            this.alP = previous.tilt;
            this.alQ = previous.bearing;
        }

        public Builder bearing(float bearing) {
            this.alQ = bearing;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.alN, this.alO, this.alP, this.alQ);
        }

        public Builder target(LatLng location) {
            this.alN = location;
            return this;
        }

        public Builder tilt(float tilt) {
            this.alP = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.alO = zoom;
            return this;
        }
    }

    CameraPosition(int versionCode, LatLng target, float zoom, float tilt, float bearing) {
        jx.b((Object) target, (Object) "null camera target");
        boolean z = 0.0f <= tilt && tilt <= 90.0f;
        jx.b(z, (Object) "Tilt needs to be between 0 and 90 inclusive");
        this.CK = versionCode;
        this.target = target;
        this.zoom = zoom;
        this.tilt = tilt + 0.0f;
        if (((double) bearing) <= 0.0d) {
            bearing = (bearing % 360.0f) + 360.0f;
        }
        this.bearing = bearing % 360.0f;
    }

    public CameraPosition(LatLng target, float zoom, float tilt, float bearing) {
        this(1, target, zoom, tilt, bearing);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition camera) {
        return new Builder(camera);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng target, float zoom) {
        return new CameraPosition(target, zoom, 0.0f, 0.0f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) o;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return jv.h(this).a("target", this.target).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            b.a(this, out, flags);
        } else {
            a.a(this, out, flags);
        }
    }
}
