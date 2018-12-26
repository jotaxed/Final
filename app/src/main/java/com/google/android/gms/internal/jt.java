package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.games.Notifications;

public interface jt extends IInterface {

    public static abstract class a extends Binder implements jt {

        private static class a implements jt {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(js jsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void a(js jsVar, int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.le.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str, String str2, String str3, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.le.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str4);
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

            public void a(js jsVar, int i, String str, String[] strArr, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(js jsVar, jj jjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    if (jjVar != null) {
                        obtain.writeInt(1);
                        jjVar.writeToParcel(obtain, 0);
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

            public void b(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void b(js jsVar, int i, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.le.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void d(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void g(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void g(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void h(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void h(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void i(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void i(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void k(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void k(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void l(js jsVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void l(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void n(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void o(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void p(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void q(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void r(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void s(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void t(js jsVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static jt Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jt)) ? new a(iBinder) : (jt) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            jj jjVar = null;
            js P;
            int readInt;
            String readString;
            Bundle bundle;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    a(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    b(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    c(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    d(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    e(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readString(), data.readStrongBinder(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    f(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    g(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    h(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    i(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    j(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    k(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    l(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.createStringArray(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    b(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    c(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    n(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    d(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    o(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    e(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    p(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    b(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    f(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    g(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    h(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    i(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    q(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    r(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    j(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    s(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    k(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    t(P, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    l(com.google.android.gms.internal.js.a.P(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    P = com.google.android.gms.internal.js.a.P(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        jjVar = (jj) jj.CREATOR.createFromParcel(data);
                    }
                    a(P, jjVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(js jsVar, int i) throws RemoteException;

    void a(js jsVar, int i, String str) throws RemoteException;

    void a(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void a(js jsVar, int i, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(js jsVar, int i, String str, String str2) throws RemoteException;

    void a(js jsVar, int i, String str, String str2, String str3, String[] strArr) throws RemoteException;

    void a(js jsVar, int i, String str, String str2, String[] strArr) throws RemoteException;

    void a(js jsVar, int i, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException;

    void a(js jsVar, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException;

    void a(js jsVar, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException;

    void a(js jsVar, int i, String str, String[] strArr, String str2, Bundle bundle) throws RemoteException;

    void a(js jsVar, jj jjVar) throws RemoteException;

    void b(js jsVar, int i, String str) throws RemoteException;

    void b(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void b(js jsVar, int i, String str, String str2, String[] strArr) throws RemoteException;

    void c(js jsVar, int i, String str) throws RemoteException;

    void c(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void d(js jsVar, int i, String str) throws RemoteException;

    void d(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void e(js jsVar, int i, String str) throws RemoteException;

    void e(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void f(js jsVar, int i, String str) throws RemoteException;

    void f(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void g(js jsVar, int i, String str) throws RemoteException;

    void g(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void h(js jsVar, int i, String str) throws RemoteException;

    void h(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void i(js jsVar, int i, String str) throws RemoteException;

    void i(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void j(js jsVar, int i, String str) throws RemoteException;

    void j(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void k(js jsVar, int i, String str) throws RemoteException;

    void k(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void l(js jsVar, int i, String str) throws RemoteException;

    void l(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void m(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void n(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void o(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void p(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void q(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void r(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void s(js jsVar, int i, String str, Bundle bundle) throws RemoteException;

    void t(js jsVar, int i, String str, Bundle bundle) throws RemoteException;
}
