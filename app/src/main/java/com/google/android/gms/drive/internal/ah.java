package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ah extends IInterface {

    public static abstract class a extends Binder implements ah {

        private static class a implements ah {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void M(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static ah aa(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ah)) ? new a(iBinder) : (ah) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    M(data.readInt() != 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void M(boolean z) throws RemoteException;
}
