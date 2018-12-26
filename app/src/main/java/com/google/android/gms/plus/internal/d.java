package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.ky;
import java.util.List;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        private static class a implements d {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public jr a(b bVar, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.le.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    jr O = com.google.android.gms.internal.jr.a.O(obtain2.readStrongBinder());
                    return O;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ky kyVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (kyVar != null) {
                        obtain.writeInt(1);
                        kyVar.writeToParcel(obtain, 0);
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

            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(b bVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.le.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(b bVar, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void a(b bVar, ky kyVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (kyVar != null) {
                        obtain.writeInt(1);
                        kyVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(b bVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(b bVar, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeStringList(list);
                    this.le.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, kk kkVar, kk kkVar2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (kkVar != null) {
                        obtain.writeInt(1);
                        kkVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (kkVar2 != null) {
                        obtain.writeInt(1);
                        kkVar2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void b(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String ou() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.le.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean ov() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.le.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String ow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.le.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.le.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static d bM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new a(iBinder) : (d) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            kk kkVar = null;
            String accountName;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    a(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    a(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    b(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    a(data.readInt() != 0 ? ky.CREATOR.Q(data) : null);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    clearDefaultAccount();
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    a(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    a(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    a(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readInt(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 16:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    jr a = a(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        asBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    removeMoment(data.readString());
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    c(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    b(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    a(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    d(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = ou();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean ov = ov();
                    reply.writeNoException();
                    reply.writeInt(ov ? 1 : 0);
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = ow();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    e(com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 45:
                    ky Q;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    b bK = com.google.android.gms.plus.internal.b.a.bK(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        Q = ky.CREATOR.Q(data);
                    }
                    a(bK, Q);
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    String readString = data.readString();
                    kk I = data.readInt() != 0 ? kk.CREATOR.I(data) : null;
                    if (data.readInt() != 0) {
                        kkVar = kk.CREATOR.I(data);
                    }
                    a(readString, I, kkVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    jr a(b bVar, int i, int i2, int i3, String str) throws RemoteException;

    void a(ky kyVar) throws RemoteException;

    void a(b bVar) throws RemoteException;

    void a(b bVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void a(b bVar, Uri uri, Bundle bundle) throws RemoteException;

    void a(b bVar, ky kyVar) throws RemoteException;

    void a(b bVar, String str) throws RemoteException;

    void a(b bVar, String str, String str2) throws RemoteException;

    void a(b bVar, List<String> list) throws RemoteException;

    void a(String str, kk kkVar, kk kkVar2) throws RemoteException;

    void b(b bVar) throws RemoteException;

    void b(b bVar, String str) throws RemoteException;

    void c(b bVar, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    void d(b bVar, String str) throws RemoteException;

    void e(b bVar, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    String ou() throws RemoteException;

    boolean ov() throws RemoteException;

    String ow() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
