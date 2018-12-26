package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface mc extends IInterface {

    public static abstract class a extends Binder implements mc {

        private static class a implements mc {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(SessionStopResult sessionStopResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    if (sessionStopResult != null) {
                        obtain.writeInt(1);
                        sessionStopResult.writeToParcel(obtain, 0);
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
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionStopCallback");
        }

        public static mc ay(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof mc)) ? new a(iBinder) : (mc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    a(data.readInt() != 0 ? (SessionStopResult) SessionStopResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(SessionStopResult sessionStopResult) throws RemoteException;
}
