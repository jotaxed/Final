package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;

public interface bx extends IInterface {

    public static abstract class a extends Binder implements bx {
        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            String bB;
            d bC;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    j(data.readInt());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    aw();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = bB();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bC = bC();
                    reply.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = getBody();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bC = bI();
                    reply.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = bE();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = bJ();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void aw() throws RemoteException;

    String bB() throws RemoteException;

    d bC() throws RemoteException;

    String bE() throws RemoteException;

    d bI() throws RemoteException;

    String bJ() throws RemoteException;

    String getBody() throws RemoteException;

    void j(int i) throws RemoteException;
}
