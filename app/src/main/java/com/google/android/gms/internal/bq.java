package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;

public interface bq extends IInterface {

    public static abstract class a extends Binder implements bq {

        private static class a implements bq {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void av() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String bA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String bz() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
        }

        public static bq i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bq)) ? new a(iBinder) : (bq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String bz;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    bz = bz();
                    reply.writeNoException();
                    reply.writeString(bz);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    bz = bA();
                    reply.writeNoException();
                    reply.writeString(bz);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    a(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    av();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    aw();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(d dVar) throws RemoteException;

    void av() throws RemoteException;

    void aw() throws RemoteException;

    String bA() throws RemoteException;

    String bz() throws RemoteException;
}
