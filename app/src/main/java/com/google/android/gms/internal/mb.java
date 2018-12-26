package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

public interface mb extends IInterface {

    public static abstract class a extends Binder implements mb {

        private static class a implements mb {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(SessionReadResult sessionReadResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    if (sessionReadResult != null) {
                        obtain.writeInt(1);
                        sessionReadResult.writeToParcel(obtain, 0);
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
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionReadCallback");
        }

        public static mb ax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof mb)) ? new a(iBinder) : (mb) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    a(data.readInt() != 0 ? (SessionReadResult) SessionReadResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(SessionReadResult sessionReadResult) throws RemoteException;
}
