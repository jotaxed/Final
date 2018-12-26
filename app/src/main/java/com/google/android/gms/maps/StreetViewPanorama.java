package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.r.a;
import com.google.android.gms.maps.internal.s;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate alg;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate sv) {
        this.alg = (IStreetViewPanoramaDelegate) jx.i(sv);
    }

    public void animateTo(StreetViewPanoramaCamera camera, long duration) {
        try {
            this.alg.animateTo(camera, duration);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.alg.getStreetViewPanoramaLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.alg.getPanoramaCamera();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.alg.isPanningGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.alg.isStreetNamesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.alg.isUserNavigationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.alg.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IStreetViewPanoramaDelegate nQ() {
        return this.alg;
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation orientation) {
        try {
            d orientationToPoint = this.alg.orientationToPoint(orientation);
            return orientationToPoint == null ? null : (Point) e.f(orientationToPoint);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.alg.pointToOrientation(e.k(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.alg.setOnStreetViewPanoramaCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.alg.setOnStreetViewPanoramaCameraChangeListener(new a(this) {
            final /* synthetic */ StreetViewPanorama ali;

            public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) {
                listener.onStreetViewPanoramaCameraChange(camera);
            }
        });
    }

    public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener listener) {
        if (listener == null) {
            try {
                this.alg.setOnStreetViewPanoramaChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.alg.setOnStreetViewPanoramaChangeListener(new s.a(this) {
            final /* synthetic */ StreetViewPanorama ali;

            public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {
                listener.onStreetViewPanoramaChange(location);
            }
        });
    }

    public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener listener) {
        if (listener == null) {
            try {
                this.alg.setOnStreetViewPanoramaClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.alg.setOnStreetViewPanoramaClickListener(new t.a(this) {
            final /* synthetic */ StreetViewPanorama ali;

            public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) {
                listener.onStreetViewPanoramaClick(orientation);
            }
        });
    }

    public void setPanningGesturesEnabled(boolean enablePanning) {
        try {
            this.alg.enablePanning(enablePanning);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position) {
        try {
            this.alg.setPosition(position);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position, int radius) {
        try {
            this.alg.setPositionWithRadius(position, radius);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(String panoId) {
        try {
            this.alg.setPositionWithID(panoId);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStreetNamesEnabled(boolean enableStreetNames) {
        try {
            this.alg.enableStreetNames(enableStreetNames);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setUserNavigationEnabled(boolean enableUserNavigation) {
        try {
            this.alg.enableUserNavigation(enableUserNavigation);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean enableZoom) {
        try {
            this.alg.enableZoom(enableZoom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
