package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface u extends IInterface {

    public static abstract class a extends Binder implements u {

        private static class a implements u {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    obtain.writeStrongBinder(iStreetViewPanoramaDelegate != null ? iStreetViewPanoramaDelegate.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
        }

        public static u bo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof u)) ? new a(iBinder) : (u) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    a(com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate.a.br(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException;
}
