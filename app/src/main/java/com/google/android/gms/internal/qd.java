package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface qd extends IInterface {

    public static abstract class a extends Binder implements qd {

        private static class a implements qd {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public qa a(d dVar, c cVar, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qbVar != null) {
                        iBinder = qbVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    qa bP = com.google.android.gms.internal.qa.a.bP(obtain2.readStrongBinder());
                    return bP;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static qd bS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qd)) ? new a(iBinder) : (qd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    qa a = a(com.google.android.gms.dynamic.d.a.ap(data.readStrongBinder()), com.google.android.gms.dynamic.c.a.ao(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.qb.a.bQ(data.readStrongBinder()));
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    qa a(d dVar, c cVar, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws RemoteException;
}
