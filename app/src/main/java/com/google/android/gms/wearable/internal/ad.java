package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface ad extends IInterface {

    public static abstract class a extends Binder implements ad {

        private static class a implements ad {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ap apVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (apVar != null) {
                        obtain.writeInt(1);
                        apVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(at atVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (atVar != null) {
                        obtain.writeInt(1);
                        atVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(aw awVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (awVar != null) {
                        obtain.writeInt(1);
                        awVar.writeToParcel(obtain, 0);
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

            public void a(p pVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (pVar != null) {
                        obtain.writeInt(1);
                        pVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(r rVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (rVar != null) {
                        obtain.writeInt(1);
                        rVar.writeToParcel(obtain, 0);
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

            public void a(t tVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (tVar != null) {
                        obtain.writeInt(1);
                        tVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (vVar != null) {
                        obtain.writeInt(1);
                        vVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(x xVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (xVar != null) {
                        obtain.writeInt(1);
                        xVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(z zVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (zVar != null) {
                        obtain.writeInt(1);
                        zVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ab(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5, obtain, obtain2, 0);
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
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        public static ad bX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ad)) ? new a(iBinder) : (ad) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            aw awVar = null;
            switch (code) {
                case 2:
                    r rVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        rVar = (r) r.CREATOR.createFromParcel(data);
                    }
                    a(rVar);
                    reply.writeNoException();
                    return true;
                case 3:
                    ap apVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        apVar = (ap) ap.CREATOR.createFromParcel(data);
                    }
                    a(apVar);
                    reply.writeNoException();
                    return true;
                case 4:
                    x xVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        xVar = (x) x.CREATOR.createFromParcel(data);
                    }
                    a(xVar);
                    reply.writeNoException();
                    return true;
                case 5:
                    DataHolder B;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        B = DataHolder.CREATOR.B(data);
                    }
                    ab(B);
                    reply.writeNoException();
                    return true;
                case 6:
                    p pVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        pVar = (p) p.CREATOR.createFromParcel(data);
                    }
                    a(pVar);
                    reply.writeNoException();
                    return true;
                case 7:
                    at atVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        atVar = (at) at.CREATOR.createFromParcel(data);
                    }
                    a(atVar);
                    reply.writeNoException();
                    return true;
                case 8:
                    z zVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        zVar = (z) z.CREATOR.createFromParcel(data);
                    }
                    a(zVar);
                    reply.writeNoException();
                    return true;
                case 9:
                    ab abVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        abVar = (ab) ab.CREATOR.createFromParcel(data);
                    }
                    a(abVar);
                    reply.writeNoException();
                    return true;
                case 10:
                    v vVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        vVar = (v) v.CREATOR.createFromParcel(data);
                    }
                    a(vVar);
                    reply.writeNoException();
                    return true;
                case 11:
                    Status createFromParcel;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    a(createFromParcel);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        awVar = (aw) aw.CREATOR.createFromParcel(data);
                    }
                    a(awVar);
                    reply.writeNoException();
                    return true;
                case 13:
                    t tVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        tVar = (t) t.CREATOR.createFromParcel(data);
                    }
                    a(tVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(Status status) throws RemoteException;

    void a(ab abVar) throws RemoteException;

    void a(ap apVar) throws RemoteException;

    void a(at atVar) throws RemoteException;

    void a(aw awVar) throws RemoteException;

    void a(p pVar) throws RemoteException;

    void a(r rVar) throws RemoteException;

    void a(t tVar) throws RemoteException;

    void a(v vVar) throws RemoteException;

    void a(x xVar) throws RemoteException;

    void a(z zVar) throws RemoteException;

    void ab(DataHolder dataHolder) throws RemoteException;
}
