package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;

public interface IStreetViewPanoramaViewDelegate extends IInterface {

    public static abstract class a extends Binder implements IStreetViewPanoramaViewDelegate {

        private static class a implements IStreetViewPanoramaViewDelegate {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            public IStreetViewPanoramaDelegate getStreetViewPanorama() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaDelegate br = com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate.a.br(obtain2.readStrongBinder());
                    return br;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getStreetViewPanoramaAsync(u callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public d getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    d ap = com.google.android.gms.dynamic.d.a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCreate(Bundle savedInstanceState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.le.transact(5, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.le.transact(6, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.le.transact(4, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.le.transact(3, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    if (outState != null) {
                        obtain.writeInt(1);
                        outState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(7, obtain, obtain2, 0);
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
        }

        public static IStreetViewPanoramaViewDelegate bt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaViewDelegate)) ? new a(iBinder) : (IStreetViewPanoramaViewDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            Bundle bundle;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    IStreetViewPanoramaDelegate streetViewPanorama = getStreetViewPanorama();
                    reply.writeNoException();
                    if (streetViewPanorama != null) {
                        iBinder = streetViewPanorama.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    onCreate(bundle);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    onResume();
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    onPause();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    onDestroy();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    onLowMemory();
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    onSaveInstanceState(bundle);
                    reply.writeNoException();
                    if (bundle != null) {
                        reply.writeInt(1);
                        bundle.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    d view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        iBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    getStreetViewPanoramaAsync(com.google.android.gms.maps.internal.u.a.bo(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IStreetViewPanoramaDelegate getStreetViewPanorama() throws RemoteException;

    void getStreetViewPanoramaAsync(u uVar) throws RemoteException;

    d getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;
}
