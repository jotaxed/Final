package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface IRoomService extends IInterface {

    public static abstract class Stub extends Binder implements IRoomService {

        private static class Proxy implements IRoomService {
            private IBinder le;

            public void R(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException {
                IBinder iBinder2 = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeStrongBinder(iBinder);
                    if (iRoomServiceCallbacks != null) {
                        iBinder2 = iRoomServiceCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    this.le.transact(1001, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(DataHolder dataHolder, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(byte[] bArr, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(byte[] bArr, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void bQ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.le.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bR(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.le.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void c(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.le.transact(1004, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(1002, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(1003, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lQ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void v(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void w(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    a(data.readStrongBinder(), com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.aH(data.readStrongBinder()));
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lN();
                    return true;
                case 1003:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lO();
                    return true;
                case 1004:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    c(data.readString(), data.readString(), data.readString());
                    return true;
                case 1005:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lP();
                    return true;
                case 1006:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder B = data.readInt() != 0 ? DataHolder.CREATOR.B(data) : null;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(B, z);
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lQ();
                    return true;
                case 1008:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    R(z);
                    return true;
                case 1009:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    a(data.createByteArray(), data.readString(), data.readInt());
                    return true;
                case 1010:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    a(data.createByteArray(), data.createStringArray());
                    return true;
                case 1011:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    v(data.readString(), data.readInt());
                    return true;
                case 1012:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    w(data.readString(), data.readInt());
                    return true;
                case 1013:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    bQ(data.readString());
                    return true;
                case 1014:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    bR(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void R(boolean z) throws RemoteException;

    void a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException;

    void a(DataHolder dataHolder, boolean z) throws RemoteException;

    void a(byte[] bArr, String str, int i) throws RemoteException;

    void a(byte[] bArr, String[] strArr) throws RemoteException;

    void bQ(String str) throws RemoteException;

    void bR(String str) throws RemoteException;

    void c(String str, String str2, String str3) throws RemoteException;

    void lN() throws RemoteException;

    void lO() throws RemoteException;

    void lP() throws RemoteException;

    void lQ() throws RemoteException;

    void v(String str, int i) throws RemoteException;

    void w(String str, int i) throws RemoteException;
}
