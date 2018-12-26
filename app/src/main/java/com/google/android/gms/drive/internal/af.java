package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.m;

public interface af extends IInterface {

    public static abstract class a extends Binder implements af {

        private static class a implements af {
            private IBinder le;

            a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void a(OnContentsResponse onContentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onContentsResponse != null) {
                        obtain.writeInt(1);
                        onContentsResponse.writeToParcel(obtain, 0);
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

            public void a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDeviceUsagePreferenceResponse != null) {
                        obtain.writeInt(1);
                        onDeviceUsagePreferenceResponse.writeToParcel(obtain, 0);
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

            public void a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDownloadProgressResponse != null) {
                        obtain.writeInt(1);
                        onDownloadProgressResponse.writeToParcel(obtain, 0);
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

            public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDriveIdResponse != null) {
                        obtain.writeInt(1);
                        onDriveIdResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(OnDrivePreferencesResponse onDrivePreferencesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDrivePreferencesResponse != null) {
                        obtain.writeInt(1);
                        onDrivePreferencesResponse.writeToParcel(obtain, 0);
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

            public void a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListEntriesResponse != null) {
                        obtain.writeInt(1);
                        onListEntriesResponse.writeToParcel(obtain, 0);
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

            public void a(OnListParentsResponse onListParentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListParentsResponse != null) {
                        obtain.writeInt(1);
                        onListParentsResponse.writeToParcel(obtain, 0);
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

            public void a(OnLoadRealtimeResponse onLoadRealtimeResponse, m mVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onLoadRealtimeResponse != null) {
                        obtain.writeInt(1);
                        onLoadRealtimeResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(OnMetadataResponse onMetadataResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onMetadataResponse != null) {
                        obtain.writeInt(1);
                        onMetadataResponse.writeToParcel(obtain, 0);
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

            public void a(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onResourceIdSetResponse != null) {
                        obtain.writeInt(1);
                        onResourceIdSetResponse.writeToParcel(obtain, 0);
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

            public void a(OnStorageStatsResponse onStorageStatsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onStorageStatsResponse != null) {
                        obtain.writeInt(1);
                        onStorageStatsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onSyncMoreResponse != null) {
                        obtain.writeInt(1);
                        onSyncMoreResponse.writeToParcel(obtain, 0);
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

            public IBinder asBinder() {
                return this.le;
            }

            public void n(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }

        public static af Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof af)) ? new a(iBinder) : (af) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse = null;
            switch (code) {
                case 1:
                    OnDownloadProgressResponse onDownloadProgressResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onDownloadProgressResponse = (OnDownloadProgressResponse) OnDownloadProgressResponse.CREATOR.createFromParcel(data);
                    }
                    a(onDownloadProgressResponse);
                    reply.writeNoException();
                    return true;
                case 2:
                    OnListEntriesResponse onListEntriesResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onListEntriesResponse = (OnListEntriesResponse) OnListEntriesResponse.CREATOR.createFromParcel(data);
                    }
                    a(onListEntriesResponse);
                    reply.writeNoException();
                    return true;
                case 3:
                    OnDriveIdResponse onDriveIdResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onDriveIdResponse = (OnDriveIdResponse) OnDriveIdResponse.CREATOR.createFromParcel(data);
                    }
                    a(onDriveIdResponse);
                    reply.writeNoException();
                    return true;
                case 4:
                    OnMetadataResponse onMetadataResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onMetadataResponse = (OnMetadataResponse) OnMetadataResponse.CREATOR.createFromParcel(data);
                    }
                    a(onMetadataResponse);
                    reply.writeNoException();
                    return true;
                case 5:
                    OnContentsResponse onContentsResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onContentsResponse = (OnContentsResponse) OnContentsResponse.CREATOR.createFromParcel(data);
                    }
                    a(onContentsResponse);
                    reply.writeNoException();
                    return true;
                case 6:
                    Status createFromParcel;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    n(createFromParcel);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    onSuccess();
                    reply.writeNoException();
                    return true;
                case 8:
                    OnListParentsResponse onListParentsResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onListParentsResponse = (OnListParentsResponse) OnListParentsResponse.CREATOR.createFromParcel(data);
                    }
                    a(onListParentsResponse);
                    reply.writeNoException();
                    return true;
                case 9:
                    OnSyncMoreResponse onSyncMoreResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onSyncMoreResponse = (OnSyncMoreResponse) OnSyncMoreResponse.CREATOR.createFromParcel(data);
                    }
                    a(onSyncMoreResponse);
                    reply.writeNoException();
                    return true;
                case 10:
                    OnStorageStatsResponse onStorageStatsResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onStorageStatsResponse = (OnStorageStatsResponse) OnStorageStatsResponse.CREATOR.createFromParcel(data);
                    }
                    a(onStorageStatsResponse);
                    reply.writeNoException();
                    return true;
                case 11:
                    OnLoadRealtimeResponse onLoadRealtimeResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onLoadRealtimeResponse = (OnLoadRealtimeResponse) OnLoadRealtimeResponse.CREATOR.createFromParcel(data);
                    }
                    a(onLoadRealtimeResponse, com.google.android.gms.drive.realtime.internal.m.a.al(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 12:
                    OnResourceIdSetResponse onResourceIdSetResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onResourceIdSetResponse = (OnResourceIdSetResponse) OnResourceIdSetResponse.CREATOR.createFromParcel(data);
                    }
                    a(onResourceIdSetResponse);
                    reply.writeNoException();
                    return true;
                case 13:
                    OnDrivePreferencesResponse onDrivePreferencesResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onDrivePreferencesResponse = (OnDrivePreferencesResponse) OnDrivePreferencesResponse.CREATOR.createFromParcel(data);
                    }
                    a(onDrivePreferencesResponse);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onDeviceUsagePreferenceResponse = (OnDeviceUsagePreferenceResponse) OnDeviceUsagePreferenceResponse.CREATOR.createFromParcel(data);
                    }
                    a(onDeviceUsagePreferenceResponse);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void a(OnContentsResponse onContentsResponse) throws RemoteException;

    void a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException;

    void a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException;

    void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException;

    void a(OnDrivePreferencesResponse onDrivePreferencesResponse) throws RemoteException;

    void a(OnListEntriesResponse onListEntriesResponse) throws RemoteException;

    void a(OnListParentsResponse onListParentsResponse) throws RemoteException;

    void a(OnLoadRealtimeResponse onLoadRealtimeResponse, m mVar) throws RemoteException;

    void a(OnMetadataResponse onMetadataResponse) throws RemoteException;

    void a(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException;

    void a(OnStorageStatsResponse onStorageStatsResponse) throws RemoteException;

    void a(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException;

    void n(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;
}
