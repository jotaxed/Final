package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;

public interface id extends IInterface {

    public static abstract class a extends Binder implements id {

        private static class a implements id {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(ic icVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    this.le.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ic icVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.le.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ic icVar, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.le.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ic icVar, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.le.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void b(ic icVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    this.le.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(ic icVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.le.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(ic icVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    this.le.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int fL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.le.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int fM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.le.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static id J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof id)) ? new a(iBinder) : (id) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int fL;
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    fL = fL();
                    reply.writeNoException();
                    reply.writeInt(fL);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    fL = fM();
                    reply.writeNoException();
                    reply.writeInt(fL);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    a(com.google.android.gms.internal.ic.a.I(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    a(com.google.android.gms.internal.ic.a.I(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    a(com.google.android.gms.internal.ic.a.I(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    a(com.google.android.gms.internal.ic.a.I(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /*5007*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    b(com.google.android.gms.internal.ic.a.I(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /*5008*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    b(com.google.android.gms.internal.ic.a.I(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /*5009*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    c(com.google.android.gms.internal.ic.a.I(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(ic icVar) throws RemoteException;

    void a(ic icVar, int i) throws RemoteException;

    void a(ic icVar, int i, String str, byte[] bArr) throws RemoteException;

    void a(ic icVar, int i, byte[] bArr) throws RemoteException;

    void b(ic icVar) throws RemoteException;

    void b(ic icVar, int i) throws RemoteException;

    void c(ic icVar) throws RemoteException;

    int fL() throws RemoteException;

    int fM() throws RemoteException;
}
