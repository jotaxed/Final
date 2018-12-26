package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.ads.AdSize;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.b;
import com.google.android.gms.location.e;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface ni extends IInterface {

    public static abstract class a extends Binder implements ni {

        private static class a implements ni {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void S(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.le.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(nl nlVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nlVar != null) {
                        obtain.writeInt(1);
                        nlVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(nl nlVar, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nlVar != null) {
                        obtain.writeInt(1);
                        nlVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.le.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ns nsVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nsVar != null) {
                        obtain.writeInt(1);
                        nsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(nw nwVar, oh ohVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nwVar != null) {
                        obtain.writeInt(1);
                        nwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(ny nyVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nyVar != null) {
                        obtain.writeInt(1);
                        nyVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(oc ocVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (ocVar != null) {
                        obtain.writeInt(1);
                        ocVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(oe oeVar, LatLngBounds latLngBounds, List<String> list, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (oeVar != null) {
                        obtain.writeInt(1);
                        oeVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, nh nhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    this.le.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void a(LocationRequest locationRequest, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(LocationRequest locationRequest, b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(20, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(LatLng latLng, nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(LatLngBounds latLngBounds, int i, nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(LatLngBounds latLngBounds, int i, String str, nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, LatLngBounds latLngBounds, nq nqVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (nqVar != null) {
                        obtain.writeInt(1);
                        nqVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(List<nn> list, PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(List<String> list, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringList(list);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String[] strArr, nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void b(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(String str, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location bZ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.le.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public e ca(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.le.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    e cK = obtain2.readInt() != 0 ? e.CREATOR.cK(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return cK;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location ni() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder nj() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.le.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder nk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.le.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ni aO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ni)) ? new a(iBinder) : (ni) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            oh ohVar = null;
            Location ni;
            LocationRequest cJ;
            String readString;
            IBinder nj;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.createTypedArrayList(nn.CREATOR), data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.nh.a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.nh.a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.createStringArray(), com.google.android.gms.internal.nh.a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(com.google.android.gms.internal.nh.a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readLong(), data.readInt() != 0, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ni = ni();
                    reply.writeNoException();
                    if (ni != null) {
                        reply.writeInt(1);
                        ni.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        cJ = LocationRequest.CREATOR.cJ(data);
                    }
                    a(cJ, com.google.android.gms.location.b.a.aL(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? LocationRequest.CREATOR.cJ(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(com.google.android.gms.location.b.a.aL(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    b(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    S(z);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    b(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null, data.readInt(), data.readInt() != 0 ? nu.CREATOR.cQ(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    a(readString, ohVar, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLng de = data.readInt() != 0 ? LatLng.CREATOR.de(data) : null;
                    nu cQ = data.readInt() != 0 ? nu.CREATOR.cQ(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    a(de, cQ, ohVar, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nu cQ2 = data.readInt() != 0 ? nu.CREATOR.cQ(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    a(cQ2, ohVar, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? ny.CREATOR.cS(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        cJ = LocationRequest.CREATOR.cJ(data);
                    }
                    a(cJ, com.google.android.gms.location.b.a.aL(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ni = bZ(data.readString());
                    reply.writeNoException();
                    if (ni != null) {
                        reply.writeInt(1);
                        ni.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nw cR = data.readInt() != 0 ? nw.CREATOR.cR(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    a(cR, ohVar);
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null, data.readInt());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    e ca = ca(data.readString());
                    reply.writeNoException();
                    if (ca != null) {
                        reply.writeInt(1);
                        ca.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    b(readString, ohVar, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    oc ocVar = data.readInt() != 0 ? (oc) oc.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    a(ocVar, ohVar, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 47:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLngBounds dd = data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null;
                    int readInt = data.readInt();
                    String readString2 = data.readString();
                    nu cQ3 = data.readInt() != 0 ? nu.CREATOR.cQ(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    a(dd, readInt, readString2, cQ3, ohVar, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 48:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? ns.CREATOR.cP(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 49:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    b(data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? oe.CREATOR.cV(data) : null, data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null, data.createStringArrayList(), data.readInt() != 0 ? oh.CREATOR.cW(data) : null, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 51:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nj = nj();
                    reply.writeNoException();
                    reply.writeStrongBinder(nj);
                    return true;
                case 52:
                    nl cM;
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        cM = nl.CREATOR.cM(data);
                    }
                    a(cM, com.google.android.gms.location.b.a.aL(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? nl.CREATOR.cM(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 54:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nj = nk();
                    reply.writeNoException();
                    reply.writeStrongBinder(nj);
                    return true;
                case 55:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readString(), data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null, data.readInt() != 0 ? nq.CREATOR.cO(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 57:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(data.readInt() != 0 ? (GeofencingRequest) GeofencingRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.nh.a.aN(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 58:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    List createStringArrayList = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    a(createStringArrayList, ohVar, com.google.android.gms.internal.og.a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void S(boolean z) throws RemoteException;

    void a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void a(PendingIntent pendingIntent) throws RemoteException;

    void a(PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException;

    void a(Location location, int i) throws RemoteException;

    void a(nh nhVar, String str) throws RemoteException;

    void a(nl nlVar, PendingIntent pendingIntent) throws RemoteException;

    void a(nl nlVar, b bVar) throws RemoteException;

    void a(ns nsVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    void a(nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    void a(nw nwVar, oh ohVar) throws RemoteException;

    void a(ny nyVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    void a(oc ocVar, oh ohVar, og ogVar) throws RemoteException;

    void a(oe oeVar, LatLngBounds latLngBounds, List<String> list, oh ohVar, og ogVar) throws RemoteException;

    void a(oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, nh nhVar) throws RemoteException;

    void a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void a(LocationRequest locationRequest, b bVar) throws RemoteException;

    void a(LocationRequest locationRequest, b bVar, String str) throws RemoteException;

    void a(b bVar) throws RemoteException;

    void a(LatLng latLng, nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    void a(LatLngBounds latLngBounds, int i, nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    void a(LatLngBounds latLngBounds, int i, String str, nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    void a(String str, oh ohVar, og ogVar) throws RemoteException;

    void a(String str, LatLngBounds latLngBounds, nq nqVar, oh ohVar, og ogVar) throws RemoteException;

    void a(List<nn> list, PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException;

    void a(List<String> list, oh ohVar, og ogVar) throws RemoteException;

    void a(String[] strArr, nh nhVar, String str) throws RemoteException;

    void b(PendingIntent pendingIntent) throws RemoteException;

    void b(Location location) throws RemoteException;

    void b(oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    void b(String str, oh ohVar, og ogVar) throws RemoteException;

    Location bZ(String str) throws RemoteException;

    e ca(String str) throws RemoteException;

    Location ni() throws RemoteException;

    IBinder nj() throws RemoteException;

    IBinder nk() throws RemoteException;
}
