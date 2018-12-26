package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.internal.g;

public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        private static class a implements c {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IMapViewDelegate a(d dVar, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate aY = com.google.android.gms.maps.internal.IMapViewDelegate.a.aY(obtain2.readStrongBinder());
                    return aY;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaViewDelegate a(d dVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate bt = com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.a.bt(obtain2.readStrongBinder());
                    return bt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(d dVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void i(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate j(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate aX = com.google.android.gms.maps.internal.IMapFragmentDelegate.a.aX(obtain2.readStrongBinder());
                    return aX;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaFragmentDelegate k(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate bs = com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.a.bs(obtain2.readStrongBinder());
                    return bs;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate nW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate aQ = com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.a.aQ(obtain2.readStrongBinder());
                    return aQ;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public g nX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    g bv = com.google.android.gms.maps.model.internal.g.a.bv(obtain2.readStrongBinder());
                    return bv;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static c aS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    i(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate j = j(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    if (j != null) {
                        iBinder = j.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = a(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.cX(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate nW = nW();
                    reply.writeNoException();
                    if (nW != null) {
                        iBinder = nW.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    g nX = nX();
                    reply.writeNoException();
                    if (nX != null) {
                        iBinder = nX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    a(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a2 = a(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.cY(data) : null);
                    reply.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate k = k(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    if (k != null) {
                        iBinder = k.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate a(d dVar, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate a(d dVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void a(d dVar, int i) throws RemoteException;

    void i(d dVar) throws RemoteException;

    IMapFragmentDelegate j(d dVar) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate k(d dVar) throws RemoteException;

    ICameraUpdateFactoryDelegate nW() throws RemoteException;

    g nX() throws RemoteException;
}
