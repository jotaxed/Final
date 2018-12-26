package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ih extends IInterface {

    public static abstract class a extends Binder implements ih {

        private static class a implements ih {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(int i, String str, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void a(if ifVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    if (ifVar != null) {
                        obtain.writeInt(1);
                        ifVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
            attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
        }

        public static ih K(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ih)) ? new a(iBinder) : (ih) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PendingIntent pendingIntent = null;
            switch (code) {
                case 1:
                    if t;
                    data.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    if (data.readInt() != 0) {
                        t = if.CREATOR.t(data);
                    }
                    a(t);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    int readInt = data.readInt();
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    a(readInt, readString, pendingIntent);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(int i, String str, PendingIntent pendingIntent) throws RemoteException;

    void a(if ifVar) throws RemoteException;
}
