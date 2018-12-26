package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.e;
import com.google.android.gms.maps.model.internal.h;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.j;
import com.google.android.gms.maps.model.internal.l;
import com.google.android.gms.maps.model.internal.m;
import com.google.android.gms.maps.model.internal.n;
import com.google.android.gms.maps.model.internal.p;

public interface IGoogleMapDelegate extends IInterface {

    public static abstract class a extends Binder implements IGoogleMapDelegate {

        private static class a implements IGoogleMapDelegate {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public h addCircle(CircleOptions options) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    h bw = com.google.android.gms.maps.model.internal.h.a.bw(obtain2.readStrongBinder());
                    return bw;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public i addGroundOverlay(GroundOverlayOptions options) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    i bx = com.google.android.gms.maps.model.internal.i.a.bx(obtain2.readStrongBinder());
                    return bx;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public i addGroundOverlay2(GroundOverlayOptions options, e parcelableOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelableOptions != null) {
                        obtain.writeInt(1);
                        parcelableOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                    i bx = com.google.android.gms.maps.model.internal.i.a.bx(obtain2.readStrongBinder());
                    return bx;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public l addMarker(MarkerOptions options) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    l bA = com.google.android.gms.maps.model.internal.l.a.bA(obtain2.readStrongBinder());
                    return bA;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public l addMarker2(MarkerOptions options, p parcelableOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelableOptions != null) {
                        obtain.writeInt(1);
                        parcelableOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                    l bA = com.google.android.gms.maps.model.internal.l.a.bA(obtain2.readStrongBinder());
                    return bA;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public m addPolygon(PolygonOptions options) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    m bB = com.google.android.gms.maps.model.internal.m.a.bB(obtain2.readStrongBinder());
                    return bB;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IPolylineDelegate addPolyline(PolylineOptions options) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    IPolylineDelegate bC = com.google.android.gms.maps.model.internal.IPolylineDelegate.a.bC(obtain2.readStrongBinder());
                    return bC;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public n addTileOverlay(TileOverlayOptions options) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    n bD = com.google.android.gms.maps.model.internal.n.a.bD(obtain2.readStrongBinder());
                    return bD;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void animateCamera(d update) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(update != null ? update.asBinder() : null);
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void animateCamera2(c update) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (update != null) {
                        obtain.writeInt(1);
                        update.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void animateCameraWithCallback(d update, b callback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(update != null ? update.asBinder() : null);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void animateCameraWithCallback2(c update, b callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (update != null) {
                        obtain.writeInt(1);
                        update.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.le.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void animateCameraWithDurationAndCallback(d update, int durationMs, b callback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(update != null ? update.asBinder() : null);
                    obtain.writeInt(durationMs);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void animateCameraWithDurationAndCallback2(c update, int durationMs, b callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (update != null) {
                        obtain.writeInt(1);
                        update.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(durationMs);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.le.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void clear() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CameraPosition getCameraPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    CameraPosition da = obtain2.readInt() != 0 ? CameraPosition.CREATOR.da(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return da;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public j getFocusedBuilding() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    j by = com.google.android.gms.maps.model.internal.j.a.by(obtain2.readStrongBinder());
                    return by;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMapAsync(m callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.le.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMapType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getMaxZoomLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getMinZoomLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location getMyLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IProjectionDelegate getProjection() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    IProjectionDelegate bp = com.google.android.gms.maps.internal.IProjectionDelegate.a.bp(obtain2.readStrongBinder());
                    return bp;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IUiSettingsDelegate getUiSettings() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    IUiSettingsDelegate bu = com.google.android.gms.maps.internal.IUiSettingsDelegate.a.bu(obtain2.readStrongBinder());
                    return bu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isBuildingsEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isIndoorEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isMyLocationEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isTrafficEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void moveCamera(d update) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(update != null ? update.asBinder() : null);
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void moveCamera2(c update) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (update != null) {
                        obtain.writeInt(1);
                        update.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCreate(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLowMemory() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSaveInstanceState(Bundle outState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (outState != null) {
                        obtain.writeInt(1);
                        outState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        outState.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setBuildingsEnabled(boolean enabled) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (enabled) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setContentDescription(String description) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeString(description);
                    this.le.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setIndoorEnabled(boolean enabled) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(enabled ? 1 : 0);
                    this.le.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setInfoWindowAdapter(d adapter) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(adapter != null ? adapter.asBinder() : null);
                    this.le.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setInfoWindowRenderer(e infoWindowRenderer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(infoWindowRenderer != null ? infoWindowRenderer.asBinder() : null);
                    this.le.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setLocationSource(ILocationSourceDelegate source) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(source != null ? source.asBinder() : null);
                    this.le.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMapType(int type) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(type);
                    this.le.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMyLocationEnabled(boolean enabled) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (enabled) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnCameraChangeListener(f listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnIndoorStateChangeListener(g listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnInfoWindowClickListener(h listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnMapClickListener(j listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnMapLoadedCallback(k callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.le.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnMapLongClickListener(l listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnMarkerClickListener(n listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnMarkerDragListener(o listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnMyLocationButtonClickListener(p listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnMyLocationChangeListener(q listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPadding(int left, int top, int right, int bottom) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(left);
                    obtain.writeInt(top);
                    obtain.writeInt(right);
                    obtain.writeInt(bottom);
                    this.le.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTrafficEnabled(boolean enabled) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (enabled) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void snapshot(v callback, d bitmap) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (bitmap != null) {
                        iBinder = bitmap.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopAnimation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean useViewLifecycleWhenInFragment() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.le.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IGoogleMapDelegate aT(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGoogleMapDelegate)) ? new a(iBinder) : (IGoogleMapDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            IBinder iBinder = null;
            float maxZoomLevel;
            l addMarker;
            i addGroundOverlay;
            boolean isTrafficEnabled;
            boolean z;
            c dq;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    CameraPosition cameraPosition = getCameraPosition();
                    reply.writeNoException();
                    if (cameraPosition != null) {
                        reply.writeInt(1);
                        cameraPosition.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    maxZoomLevel = getMaxZoomLevel();
                    reply.writeNoException();
                    reply.writeFloat(maxZoomLevel);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    maxZoomLevel = getMinZoomLevel();
                    reply.writeNoException();
                    reply.writeFloat(maxZoomLevel);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    moveCamera(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    animateCamera(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    animateCameraWithCallback(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()), com.google.android.gms.maps.internal.b.a.aR(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()), data.readInt(), com.google.android.gms.maps.internal.b.a.aR(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    stopAnimation();
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IPolylineDelegate addPolyline = addPolyline(data.readInt() != 0 ? PolylineOptions.CREATOR.dh(data) : null);
                    reply.writeNoException();
                    if (addPolyline != null) {
                        iBinder = addPolyline.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    m addPolygon = addPolygon(data.readInt() != 0 ? PolygonOptions.CREATOR.dg(data) : null);
                    reply.writeNoException();
                    if (addPolygon != null) {
                        iBinder = addPolygon.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    addMarker = addMarker(data.readInt() != 0 ? MarkerOptions.CREATOR.df(data) : null);
                    reply.writeNoException();
                    if (addMarker != null) {
                        iBinder = addMarker.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    addGroundOverlay = addGroundOverlay(data.readInt() != 0 ? GroundOverlayOptions.CREATOR.dc(data) : null);
                    reply.writeNoException();
                    if (addGroundOverlay != null) {
                        iBinder = addGroundOverlay.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    n addTileOverlay = addTileOverlay(data.readInt() != 0 ? TileOverlayOptions.CREATOR.dn(data) : null);
                    reply.writeNoException();
                    if (addTileOverlay != null) {
                        iBinder = addTileOverlay.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    clear();
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int mapType = getMapType();
                    reply.writeNoException();
                    reply.writeInt(mapType);
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setMapType(data.readInt());
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    isTrafficEnabled = isTrafficEnabled();
                    reply.writeNoException();
                    reply.writeInt(isTrafficEnabled ? 1 : 0);
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setTrafficEnabled(z);
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    isTrafficEnabled = isIndoorEnabled();
                    reply.writeNoException();
                    if (isTrafficEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    isTrafficEnabled = setIndoorEnabled(data.readInt() != 0);
                    reply.writeNoException();
                    if (isTrafficEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    isTrafficEnabled = isMyLocationEnabled();
                    reply.writeNoException();
                    if (isTrafficEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setMyLocationEnabled(z);
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Location myLocation = getMyLocation();
                    reply.writeNoException();
                    if (myLocation != null) {
                        reply.writeInt(1);
                        myLocation.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setLocationSource(com.google.android.gms.maps.internal.ILocationSourceDelegate.a.aW(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IUiSettingsDelegate uiSettings = getUiSettings();
                    reply.writeNoException();
                    if (uiSettings != null) {
                        iBinder = uiSettings.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IProjectionDelegate projection = getProjection();
                    reply.writeNoException();
                    if (projection != null) {
                        iBinder = projection.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnCameraChangeListener(com.google.android.gms.maps.internal.f.a.aZ(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnMapClickListener(com.google.android.gms.maps.internal.j.a.bd(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnMapLongClickListener(com.google.android.gms.maps.internal.l.a.bf(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnMarkerClickListener(com.google.android.gms.maps.internal.n.a.bh(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnMarkerDragListener(com.google.android.gms.maps.internal.o.a.bi(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnInfoWindowClickListener(com.google.android.gms.maps.internal.h.a.bb(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setInfoWindowAdapter(com.google.android.gms.maps.internal.d.a.aU(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    h addCircle = addCircle(data.readInt() != 0 ? CircleOptions.CREATOR.db(data) : null);
                    reply.writeNoException();
                    if (addCircle != null) {
                        iBinder = addCircle.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnMyLocationChangeListener(com.google.android.gms.maps.internal.q.a.bk(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnMyLocationButtonClickListener(com.google.android.gms.maps.internal.p.a.bj(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    snapshot(com.google.android.gms.maps.internal.v.a.bq(data.readStrongBinder()), com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setPadding(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    isTrafficEnabled = isBuildingsEnabled();
                    reply.writeNoException();
                    if (isTrafficEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setBuildingsEnabled(z);
                    reply.writeNoException();
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnMapLoadedCallback(com.google.android.gms.maps.internal.k.a.be(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    j focusedBuilding = getFocusedBuilding();
                    reply.writeNoException();
                    if (focusedBuilding != null) {
                        iBinder = focusedBuilding.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 45:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setOnIndoorStateChangeListener(com.google.android.gms.maps.internal.g.a.ba(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    getMapAsync(com.google.android.gms.maps.internal.m.a.bg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 54:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    onCreate(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 55:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    onResume();
                    reply.writeNoException();
                    return true;
                case 56:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    onPause();
                    reply.writeNoException();
                    return true;
                case 57:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    onDestroy();
                    reply.writeNoException();
                    return true;
                case 58:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    onLowMemory();
                    reply.writeNoException();
                    return true;
                case 59:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    isTrafficEnabled = useViewLifecycleWhenInFragment();
                    reply.writeNoException();
                    if (isTrafficEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 60:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Bundle bundle = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                    onSaveInstanceState(bundle);
                    reply.writeNoException();
                    if (bundle != null) {
                        reply.writeInt(1);
                        bundle.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 61:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setContentDescription(data.readString());
                    reply.writeNoException();
                    return true;
                case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /*64*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (data.readInt() != 0) {
                        dq = c.CREATOR.dq(data);
                    }
                    moveCamera2(dq);
                    reply.writeNoException();
                    return true;
                case 65:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (data.readInt() != 0) {
                        dq = c.CREATOR.dq(data);
                    }
                    animateCamera2(dq);
                    reply.writeNoException();
                    return true;
                case 66:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (data.readInt() != 0) {
                        dq = c.CREATOR.dq(data);
                    }
                    animateCameraWithCallback2(dq, com.google.android.gms.maps.internal.b.a.aR(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 67:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (data.readInt() != 0) {
                        dq = c.CREATOR.dq(data);
                    }
                    animateCameraWithDurationAndCallback2(dq, data.readInt(), com.google.android.gms.maps.internal.b.a.aR(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 68:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    addMarker = addMarker2(data.readInt() != 0 ? MarkerOptions.CREATOR.df(data) : null, data.readInt() != 0 ? p.CREATOR.ds(data) : null);
                    reply.writeNoException();
                    if (addMarker != null) {
                        iBinder = addMarker.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 69:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    setInfoWindowRenderer(com.google.android.gms.maps.internal.e.a.aV(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 70:
                    data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    addGroundOverlay = addGroundOverlay2(data.readInt() != 0 ? GroundOverlayOptions.CREATOR.dc(data) : null, data.readInt() != 0 ? e.CREATOR.dr(data) : null);
                    reply.writeNoException();
                    if (addGroundOverlay != null) {
                        iBinder = addGroundOverlay.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    h addCircle(CircleOptions circleOptions) throws RemoteException;

    i addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    i addGroundOverlay2(GroundOverlayOptions groundOverlayOptions, e eVar) throws RemoteException;

    l addMarker(MarkerOptions markerOptions) throws RemoteException;

    l addMarker2(MarkerOptions markerOptions, p pVar) throws RemoteException;

    m addPolygon(PolygonOptions polygonOptions) throws RemoteException;

    IPolylineDelegate addPolyline(PolylineOptions polylineOptions) throws RemoteException;

    n addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void animateCamera(d dVar) throws RemoteException;

    void animateCamera2(c cVar) throws RemoteException;

    void animateCameraWithCallback(d dVar, b bVar) throws RemoteException;

    void animateCameraWithCallback2(c cVar, b bVar) throws RemoteException;

    void animateCameraWithDurationAndCallback(d dVar, int i, b bVar) throws RemoteException;

    void animateCameraWithDurationAndCallback2(c cVar, int i, b bVar) throws RemoteException;

    void clear() throws RemoteException;

    CameraPosition getCameraPosition() throws RemoteException;

    j getFocusedBuilding() throws RemoteException;

    void getMapAsync(m mVar) throws RemoteException;

    int getMapType() throws RemoteException;

    float getMaxZoomLevel() throws RemoteException;

    float getMinZoomLevel() throws RemoteException;

    Location getMyLocation() throws RemoteException;

    IProjectionDelegate getProjection() throws RemoteException;

    IUiSettingsDelegate getUiSettings() throws RemoteException;

    boolean isBuildingsEnabled() throws RemoteException;

    boolean isIndoorEnabled() throws RemoteException;

    boolean isMyLocationEnabled() throws RemoteException;

    boolean isTrafficEnabled() throws RemoteException;

    void moveCamera(d dVar) throws RemoteException;

    void moveCamera2(c cVar) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void setBuildingsEnabled(boolean z) throws RemoteException;

    void setContentDescription(String str) throws RemoteException;

    boolean setIndoorEnabled(boolean z) throws RemoteException;

    void setInfoWindowAdapter(d dVar) throws RemoteException;

    void setInfoWindowRenderer(e eVar) throws RemoteException;

    void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException;

    void setMapType(int i) throws RemoteException;

    void setMyLocationEnabled(boolean z) throws RemoteException;

    void setOnCameraChangeListener(f fVar) throws RemoteException;

    void setOnIndoorStateChangeListener(g gVar) throws RemoteException;

    void setOnInfoWindowClickListener(h hVar) throws RemoteException;

    void setOnMapClickListener(j jVar) throws RemoteException;

    void setOnMapLoadedCallback(k kVar) throws RemoteException;

    void setOnMapLongClickListener(l lVar) throws RemoteException;

    void setOnMarkerClickListener(n nVar) throws RemoteException;

    void setOnMarkerDragListener(o oVar) throws RemoteException;

    void setOnMyLocationButtonClickListener(p pVar) throws RemoteException;

    void setOnMyLocationChangeListener(q qVar) throws RemoteException;

    void setPadding(int i, int i2, int i3, int i4) throws RemoteException;

    void setTrafficEnabled(boolean z) throws RemoteException;

    void snapshot(v vVar, d dVar) throws RemoteException;

    void stopAnimation() throws RemoteException;

    boolean useViewLifecycleWhenInFragment() throws RemoteException;
}
