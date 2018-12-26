package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface IStreetViewPanoramaDelegate extends IInterface {

    public static abstract class a extends Binder implements IStreetViewPanoramaDelegate {

        private static class a implements IStreetViewPanoramaDelegate {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void animateTo(StreetViewPanoramaCamera camera, long duration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (camera != null) {
                        obtain.writeInt(1);
                        camera.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(duration);
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void enablePanning(boolean enablePanning) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enablePanning) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableStreetNames(boolean enableStreetNames) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enableStreetNames) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableUserNavigation(boolean enableUserNavigation) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enableUserNavigation) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableZoom(boolean enableZoom) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (!enableZoom) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    StreetViewPanoramaCamera di = obtain2.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.di(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return di;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.le.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    StreetViewPanoramaLocation dk = obtain2.readInt() != 0 ? StreetViewPanoramaLocation.CREATOR.dk(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return dk;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isPanningGesturesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.le.transact(6, obtain, obtain2, 0);
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

            public boolean isStreetNamesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.le.transact(8, obtain, obtain2, 0);
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

            public boolean isUserNavigationEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.le.transact(7, obtain, obtain2, 0);
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

            public boolean isZoomGesturesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.le.transact(5, obtain, obtain2, 0);
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

            public d orientationToPoint(StreetViewPanoramaOrientation orientation) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (orientation != null) {
                        obtain.writeInt(1);
                        orientation.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    d ap = com.google.android.gms.dynamic.d.a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaOrientation pointToOrientation(d point) throws RemoteException {
                StreetViewPanoramaOrientation streetViewPanoramaOrientation = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(point != null ? point.asBinder() : null);
                    this.le.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        streetViewPanoramaOrientation = StreetViewPanoramaOrientation.CREATOR.dl(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return streetViewPanoramaOrientation;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaCameraChangeListener(r listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaChangeListener(s listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaClickListener(t listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.le.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPosition(LatLng position) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (position != null) {
                        obtain.writeInt(1);
                        position.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPositionWithID(String panoId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeString(panoId);
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPositionWithRadius(LatLng position, int radius) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (position != null) {
                        obtain.writeInt(1);
                        position.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(radius);
                    this.le.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IStreetViewPanoramaDelegate br(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaDelegate)) ? new a(iBinder) : (IStreetViewPanoramaDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            int i = 0;
            boolean z;
            boolean isZoomGesturesEnabled;
            LatLng de;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enableZoom(z);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enablePanning(z);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enableUserNavigation(z);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enableStreetNames(z);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isZoomGesturesEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isPanningGesturesEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isUserNavigationEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isStreetNamesEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    animateTo(data.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.di(data) : null, data.readLong());
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaCamera panoramaCamera = getPanoramaCamera();
                    reply.writeNoException();
                    if (panoramaCamera != null) {
                        reply.writeInt(1);
                        panoramaCamera.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setPositionWithID(data.readString());
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        de = LatLng.CREATOR.de(data);
                    }
                    setPosition(de);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        de = LatLng.CREATOR.de(data);
                    }
                    setPositionWithRadius(de, data.readInt());
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaLocation streetViewPanoramaLocation = getStreetViewPanoramaLocation();
                    reply.writeNoException();
                    if (streetViewPanoramaLocation != null) {
                        reply.writeInt(1);
                        streetViewPanoramaLocation.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setOnStreetViewPanoramaChangeListener(com.google.android.gms.maps.internal.s.a.bm(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setOnStreetViewPanoramaCameraChangeListener(com.google.android.gms.maps.internal.r.a.bl(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setOnStreetViewPanoramaClickListener(com.google.android.gms.maps.internal.t.a.bn(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaOrientation pointToOrientation = pointToOrientation(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    if (pointToOrientation != null) {
                        reply.writeInt(1);
                        pointToOrientation.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    d orientationToPoint = orientationToPoint(data.readInt() != 0 ? StreetViewPanoramaOrientation.CREATOR.dl(data) : null);
                    reply.writeNoException();
                    if (orientationToPoint != null) {
                        iBinder = orientationToPoint.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException;

    void enablePanning(boolean z) throws RemoteException;

    void enableStreetNames(boolean z) throws RemoteException;

    void enableUserNavigation(boolean z) throws RemoteException;

    void enableZoom(boolean z) throws RemoteException;

    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    d orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    StreetViewPanoramaOrientation pointToOrientation(d dVar) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(r rVar) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(s sVar) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(t tVar) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setPositionWithID(String str) throws RemoteException;

    void setPositionWithRadius(LatLng latLng, int i) throws RemoteException;
}
