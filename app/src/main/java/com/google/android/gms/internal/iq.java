package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

public interface iq extends IInterface {

    public static abstract class a extends Binder implements iq {

        private static class a implements iq {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(double d, double d2, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str, LaunchOptions launchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (launchOptions != null) {
                        obtain.writeInt(1);
                        launchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.le.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.le.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(boolean z, double d, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeDouble(d);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aH(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.le.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aI(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.le.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aJ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.le.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void fY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.le.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void g(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void k(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static iq M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof iq)) ? new a(iBinder) : (iq) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    disconnect();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    g(readString, z);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    k(data.readString(), data.readString());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    gl();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    aH(data.readString());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    fY();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(data.readDouble(), data.readDouble(), data.readInt() != 0);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    boolean z2 = data.readInt() != 0;
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(z2, readDouble, z);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(data.readString(), data.readString(), data.readLong());
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(data.readString(), data.createByteArray(), data.readLong());
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    aI(data.readString());
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    aJ(data.readString());
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    a(data.readString(), data.readInt() != 0 ? (LaunchOptions) LaunchOptions.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(double d, double d2, boolean z) throws RemoteException;

    void a(String str, LaunchOptions launchOptions) throws RemoteException;

    void a(String str, String str2, long j) throws RemoteException;

    void a(String str, byte[] bArr, long j) throws RemoteException;

    void a(boolean z, double d, boolean z2) throws RemoteException;

    void aH(String str) throws RemoteException;

    void aI(String str) throws RemoteException;

    void aJ(String str) throws RemoteException;

    void disconnect() throws RemoteException;

    void fY() throws RemoteException;

    void g(String str, boolean z) throws RemoteException;

    void gl() throws RemoteException;

    void k(String str, String str2) throws RemoteException;
}
