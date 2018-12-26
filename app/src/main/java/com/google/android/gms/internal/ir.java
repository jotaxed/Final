package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public interface ir extends IInterface {

    public static abstract class a extends Binder implements ir {
        public a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            io ioVar = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ad(data.readInt());
                    return true;
                case 2:
                    ApplicationMetadata applicationMetadata;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data);
                    }
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(applicationMetadata, readString, readString2, z);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ae(data.readInt());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(readString3, readDouble, z);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    j(data.readString(), data.readString());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    b(data.readString(), data.createByteArray());
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ag(data.readInt());
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    af(data.readInt());
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(data.readString(), data.readLong());
                    return true;
                case 12:
                    ij ijVar;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        ijVar = (ij) ij.CREATOR.createFromParcel(data);
                    }
                    b(ijVar);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        ioVar = (io) io.CREATOR.createFromParcel(data);
                    }
                    b(ioVar);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void a(String str, double d, boolean z) throws RemoteException;

    void a(String str, long j) throws RemoteException;

    void a(String str, long j, int i) throws RemoteException;

    void ad(int i) throws RemoteException;

    void ae(int i) throws RemoteException;

    void af(int i) throws RemoteException;

    void ag(int i) throws RemoteException;

    void b(ij ijVar) throws RemoteException;

    void b(io ioVar) throws RemoteException;

    void b(String str, byte[] bArr) throws RemoteException;

    void j(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;
}
