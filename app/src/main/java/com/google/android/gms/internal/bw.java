package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;

public interface bw extends IInterface {

    public static abstract class a extends Binder implements bw {
        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    j(data.readInt());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    aw();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bB();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bC = bC();
                    reply.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = getBody();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bC = bD();
                    reply.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bE();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double bF = bF();
                    reply.writeNoException();
                    reply.writeDouble(bF);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bG();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bH();
                    reply.writeNoException();
                    reply.writeString(bB);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void aw() throws RemoteException;

    String bB() throws RemoteException;

    d bC() throws RemoteException;

    d bD() throws RemoteException;

    String bE() throws RemoteException;

    double bF() throws RemoteException;

    String bG() throws RemoteException;

    String bH() throws RemoteException;

    String getBody() throws RemoteException;

    void j(int i) throws RemoteException;
}
