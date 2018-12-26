package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        private static class a implements d {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(ParcelableCollaborator parcelableCollaborator) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcelableCollaborator != null) {
                        obtain.writeInt(1);
                        parcelableCollaborator.writeToParcel(obtain, 0);
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

            public void b(ParcelableCollaborator parcelableCollaborator) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcelableCollaborator != null) {
                        obtain.writeInt(1);
                        parcelableCollaborator.writeToParcel(obtain, 0);
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
        }

        public static d ac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new a(iBinder) : (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelableCollaborator parcelableCollaborator = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (data.readInt() != 0) {
                        parcelableCollaborator = (ParcelableCollaborator) ParcelableCollaborator.CREATOR.createFromParcel(data);
                    }
                    a(parcelableCollaborator);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (data.readInt() != 0) {
                        parcelableCollaborator = (ParcelableCollaborator) ParcelableCollaborator.CREATOR.createFromParcel(data);
                    }
                    b(parcelableCollaborator);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(ParcelableCollaborator parcelableCollaborator) throws RemoteException;

    void b(ParcelableCollaborator parcelableCollaborator) throws RemoteException;
}
