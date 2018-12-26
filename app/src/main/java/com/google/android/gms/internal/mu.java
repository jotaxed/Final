package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public interface mu extends IInterface {

    public static abstract class a extends Binder implements mu {
        public a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ms msVar = null;
            switch (code) {
                case 1:
                    mq mqVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        mqVar = (mq) mq.CREATOR.createFromParcel(data);
                    }
                    a(mqVar, com.google.android.gms.internal.lx.a.at(data.readStrongBinder()));
                    return true;
                case 2:
                    FitnessSensorServiceRequest fitnessSensorServiceRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessSensorServiceRequest = (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(data);
                    }
                    a(fitnessSensorServiceRequest, com.google.android.gms.internal.md.a.az(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        msVar = (ms) ms.CREATOR.createFromParcel(data);
                    }
                    a(msVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(FitnessSensorServiceRequest fitnessSensorServiceRequest, md mdVar) throws RemoteException;

    void a(mq mqVar, lx lxVar) throws RemoteException;

    void a(ms msVar, md mdVar) throws RemoteException;
}
