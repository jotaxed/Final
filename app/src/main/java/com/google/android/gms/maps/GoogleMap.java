package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.j;
import com.google.android.gms.maps.model.internal.l;
import com.google.android.gms.maps.model.internal.n;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate akm;
    private UiSettings akn;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class a extends com.google.android.gms.maps.internal.b.a {
        private final CancelableCallback akE;

        a(CancelableCallback cancelableCallback) {
            this.akE = cancelableCallback;
        }

        public void onCancel() {
            this.akE.onCancel();
        }

        public void onFinish() {
            this.akE.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.akm = (IGoogleMapDelegate) jx.i(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.akm.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            i addGroundOverlay = this.akm.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            l addMarker = this.akm.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.akm.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.akm.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            n addTileOverlay = this.akm.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.akm.animateCamera(update.nA());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.akm.animateCameraWithDurationAndCallback(update.nA(), durationMs, callback == null ? null : new a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.akm.animateCameraWithCallback(update.nA(), callback == null ? null : new a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.akm.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.akm.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            j focusedBuilding = this.akm.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.akm.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.akm.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.akm.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.akm.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.akm.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.akn == null) {
                this.akn = new UiSettings(this.akm.getUiSettings());
            }
            return this.akn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.akm.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.akm.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.akm.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.akm.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.akm.moveCamera(update.nA());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate nC() {
        return this.akm;
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.akm.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.akm.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.akm.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.akm.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setInfoWindowAdapter(new com.google.android.gms.maps.internal.d.a(this) {
            final /* synthetic */ GoogleMap akp;

            public d f(l lVar) {
                return e.k(adapter.getInfoWindow(new Marker(lVar)));
            }

            public d g(l lVar) {
                return e.k(adapter.getInfoContents(new Marker(lVar)));
            }
        });
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.akm.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setLocationSource(new com.google.android.gms.maps.internal.ILocationSourceDelegate.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void activate(final com.google.android.gms.maps.internal.i listener) {
                source.activate(new OnLocationChangedListener(this) {
                    final /* synthetic */ AnonymousClass6 akw;

                    public void onLocationChanged(Location location) {
                        try {
                            listener.d(location);
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                });
            }

            public void deactivate() {
                source.deactivate();
            }
        });
    }

    public final void setMapType(int type) {
        try {
            this.akm.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.akm.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnCameraChangeListener(new com.google.android.gms.maps.internal.f.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onCameraChange(CameraPosition position) {
                listener.onCameraChange(position);
            }
        });
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnIndoorStateChangeListener(new com.google.android.gms.maps.internal.g.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void a(j jVar) {
                listener.onIndoorLevelActivated(new IndoorBuilding(jVar));
            }

            public void onIndoorBuildingFocused() {
                listener.onIndoorBuildingFocused();
            }
        });
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnInfoWindowClickListener(new com.google.android.gms.maps.internal.h.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void e(l lVar) {
                listener.onInfoWindowClick(new Marker(lVar));
            }
        });
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapClickListener(new com.google.android.gms.maps.internal.j.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onMapClick(LatLng point) {
                listener.onMapClick(point);
            }
        });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.akm.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapLoadedCallback(new com.google.android.gms.maps.internal.k.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onMapLoaded() throws RemoteException {
                callback.onMapLoaded();
            }
        });
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapLongClickListener(new com.google.android.gms.maps.internal.l.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onMapLongClick(LatLng point) {
                listener.onMapLongClick(point);
            }
        });
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMarkerClickListener(new com.google.android.gms.maps.internal.n.a(this) {
            final /* synthetic */ GoogleMap akp;

            public boolean a(l lVar) {
                return listener.onMarkerClick(new Marker(lVar));
            }
        });
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMarkerDragListener(new com.google.android.gms.maps.internal.o.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void b(l lVar) {
                listener.onMarkerDragStart(new Marker(lVar));
            }

            public void c(l lVar) {
                listener.onMarkerDragEnd(new Marker(lVar));
            }

            public void d(l lVar) {
                listener.onMarkerDrag(new Marker(lVar));
            }
        });
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMyLocationButtonClickListener(new com.google.android.gms.maps.internal.p.a(this) {
            final /* synthetic */ GoogleMap akp;

            public boolean onMyLocationButtonClick() throws RemoteException {
                return listener.onMyLocationButtonClick();
            }
        });
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMyLocationChangeListener(new com.google.android.gms.maps.internal.q.a(this) {
            final /* synthetic */ GoogleMap akp;

            public void c(Location location) {
                listener.onMyLocationChange(location);
            }

            public void g(d dVar) {
                listener.onMyLocationChange((Location) e.f(dVar));
            }
        });
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.akm.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.akm.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.akm.snapshot(new com.google.android.gms.maps.internal.v.a(this) {
                final /* synthetic */ GoogleMap akp;

                public void h(d dVar) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) e.f(dVar));
                }

                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }
            }, (e) (bitmap != null ? e.k(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.akm.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
