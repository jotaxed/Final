package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.request.e;
import com.google.android.gms.fitness.request.j;
import com.google.android.gms.fitness.request.m;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.fitness.request.q;
import com.google.android.gms.fitness.request.u;
import com.google.android.gms.fitness.request.w;
import com.google.android.gms.fitness.request.y;

public interface lz extends IInterface {

    public static abstract class a extends Binder implements lz {

        private static class a implements lz {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(DataDeleteRequest dataDeleteRequest, md mdVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(mdVar != null ? mdVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(DataReadRequest dataReadRequest, lw lwVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lwVar != null) {
                        iBinder = lwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(DataSourcesRequest dataSourcesRequest, lx lxVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lxVar != null) {
                        iBinder = lxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(DataTypeCreateRequest dataTypeCreateRequest, ly lyVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lyVar != null) {
                        iBinder = lyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(SessionInsertRequest sessionInsertRequest, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(SessionReadRequest sessionReadRequest, mb mbVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mbVar != null) {
                        iBinder = mbVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(StartBleScanRequest startBleScanRequest, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(aa aaVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (aaVar != null) {
                        obtain.writeInt(1);
                        aaVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(21, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(ad adVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (adVar != null) {
                        obtain.writeInt(1);
                        adVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(af afVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (afVar != null) {
                        obtain.writeInt(1);
                        afVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(ah ahVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(aj ajVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ajVar != null) {
                        obtain.writeInt(1);
                        ajVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(b bVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(e eVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (eVar != null) {
                        obtain.writeInt(1);
                        eVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(j jVar, ly lyVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (jVar != null) {
                        obtain.writeInt(1);
                        jVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lyVar != null) {
                        iBinder = lyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(m mVar, ma maVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mVar != null) {
                        obtain.writeInt(1);
                        mVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (maVar != null) {
                        iBinder = maVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(o oVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (oVar != null) {
                        obtain.writeInt(1);
                        oVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(q qVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (qVar != null) {
                        obtain.writeInt(1);
                        qVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(u uVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (uVar != null) {
                        obtain.writeInt(1);
                        uVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(w wVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (wVar != null) {
                        obtain.writeInt(1);
                        wVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(y yVar, mc mcVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (yVar != null) {
                        obtain.writeInt(1);
                        yVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mcVar != null) {
                        iBinder = mcVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(22, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(mp mpVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mpVar != null) {
                        iBinder = mpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(24, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void b(md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(23, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static lz av(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof lz)) ? new a(iBinder) : (lz) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            aa aaVar = null;
            switch (code) {
                case 1:
                    DataSourcesRequest dataSourcesRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(data);
                    }
                    a(dataSourcesRequest, com.google.android.gms.internal.lx.a.at(data.readStrongBinder()), data.readString());
                    return true;
                case 2:
                    o oVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        oVar = (o) o.CREATOR.createFromParcel(data);
                    }
                    a(oVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 3:
                    q qVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        qVar = (q) q.CREATOR.createFromParcel(data);
                    }
                    a(qVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 4:
                    af afVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        afVar = (af) af.CREATOR.createFromParcel(data);
                    }
                    a(afVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 5:
                    aj ajVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        ajVar = (aj) aj.CREATOR.createFromParcel(data);
                    }
                    a(ajVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 6:
                    m mVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        mVar = (m) m.CREATOR.createFromParcel(data);
                    }
                    a(mVar, com.google.android.gms.internal.ma.a.aw(data.readStrongBinder()), data.readString());
                    return true;
                case 7:
                    e eVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        eVar = (e) e.CREATOR.createFromParcel(data);
                    }
                    a(eVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 8:
                    DataReadRequest dataReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(data);
                    }
                    a(dataReadRequest, com.google.android.gms.internal.lw.a.as(data.readStrongBinder()), data.readString());
                    return true;
                case 9:
                    SessionInsertRequest sessionInsertRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        sessionInsertRequest = (SessionInsertRequest) SessionInsertRequest.CREATOR.createFromParcel(data);
                    }
                    a(sessionInsertRequest, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 10:
                    SessionReadRequest sessionReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        sessionReadRequest = (SessionReadRequest) SessionReadRequest.CREATOR.createFromParcel(data);
                    }
                    a(sessionReadRequest, com.google.android.gms.internal.mb.a.ax(data.readStrongBinder()), data.readString());
                    return true;
                case 11:
                    w wVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        wVar = (w) w.CREATOR.createFromParcel(data);
                    }
                    a(wVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 12:
                    y yVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        yVar = (y) y.CREATOR.createFromParcel(data);
                    }
                    a(yVar, com.google.android.gms.internal.mc.a.ay(data.readStrongBinder()), data.readString());
                    return true;
                case 13:
                    DataTypeCreateRequest dataTypeCreateRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataTypeCreateRequest = (DataTypeCreateRequest) DataTypeCreateRequest.CREATOR.createFromParcel(data);
                    }
                    a(dataTypeCreateRequest, com.google.android.gms.internal.ly.a.au(data.readStrongBinder()), data.readString());
                    return true;
                case 14:
                    j jVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        jVar = (j) j.CREATOR.createFromParcel(data);
                    }
                    a(jVar, com.google.android.gms.internal.ly.a.au(data.readStrongBinder()), data.readString());
                    return true;
                case 15:
                    StartBleScanRequest startBleScanRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(data);
                    }
                    a(startBleScanRequest, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 16:
                    ad adVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        adVar = (ad) ad.CREATOR.createFromParcel(data);
                    }
                    a(adVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 17:
                    b bVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        bVar = (b) b.CREATOR.createFromParcel(data);
                    }
                    a(bVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 18:
                    ah ahVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        ahVar = (ah) ah.CREATOR.createFromParcel(data);
                    }
                    a(ahVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    DataDeleteRequest dataDeleteRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(data);
                    }
                    a(dataDeleteRequest, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 20:
                    u uVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        uVar = (u) u.CREATOR.createFromParcel(data);
                    }
                    a(uVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        aaVar = (aa) aa.CREATOR.createFromParcel(data);
                    }
                    a(aaVar, com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    a(com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    b(com.google.android.gms.internal.md.a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    a(com.google.android.gms.internal.mp.a.aA(data.readStrongBinder()), data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(DataDeleteRequest dataDeleteRequest, md mdVar, String str) throws RemoteException;

    void a(DataReadRequest dataReadRequest, lw lwVar, String str) throws RemoteException;

    void a(DataSourcesRequest dataSourcesRequest, lx lxVar, String str) throws RemoteException;

    void a(DataTypeCreateRequest dataTypeCreateRequest, ly lyVar, String str) throws RemoteException;

    void a(SessionInsertRequest sessionInsertRequest, md mdVar, String str) throws RemoteException;

    void a(SessionReadRequest sessionReadRequest, mb mbVar, String str) throws RemoteException;

    void a(StartBleScanRequest startBleScanRequest, md mdVar, String str) throws RemoteException;

    void a(aa aaVar, md mdVar, String str) throws RemoteException;

    void a(ad adVar, md mdVar, String str) throws RemoteException;

    void a(af afVar, md mdVar, String str) throws RemoteException;

    void a(ah ahVar, md mdVar, String str) throws RemoteException;

    void a(aj ajVar, md mdVar, String str) throws RemoteException;

    void a(b bVar, md mdVar, String str) throws RemoteException;

    void a(e eVar, md mdVar, String str) throws RemoteException;

    void a(j jVar, ly lyVar, String str) throws RemoteException;

    void a(m mVar, ma maVar, String str) throws RemoteException;

    void a(o oVar, md mdVar, String str) throws RemoteException;

    void a(q qVar, md mdVar, String str) throws RemoteException;

    void a(u uVar, md mdVar, String str) throws RemoteException;

    void a(w wVar, md mdVar, String str) throws RemoteException;

    void a(y yVar, mc mcVar, String str) throws RemoteException;

    void a(md mdVar, String str) throws RemoteException;

    void a(mp mpVar, String str) throws RemoteException;

    void b(md mdVar, String str) throws RemoteException;
}
