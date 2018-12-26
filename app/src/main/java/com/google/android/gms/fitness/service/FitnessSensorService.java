package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.ll;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.mq;
import com.google.android.gms.internal.ms;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private a Ww;

    private static class a extends com.google.android.gms.internal.mu.a {
        private final FitnessSensorService Wx;

        private a(FitnessSensorService fitnessSensorService) {
            this.Wx = fitnessSensorService;
        }

        private void kw() throws SecurityException {
            int callingUid = Binder.getCallingUid();
            String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
            if (ll.im()) {
                ((AppOpsManager) this.Wx.getSystemService("appops")).checkPackage(callingUid, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                return;
            }
            String[] packagesForUid = this.Wx.getPackageManager().getPackagesForUid(callingUid);
            if (packagesForUid != null) {
                int length = packagesForUid.length;
                int i = 0;
                while (i < length) {
                    if (!packagesForUid[i].equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
            throw new SecurityException("Unauthorized caller");
        }

        public void a(FitnessSensorServiceRequest fitnessSensorServiceRequest, md mdVar) throws RemoteException {
            kw();
            if (this.Wx.onRegister(fitnessSensorServiceRequest)) {
                mdVar.j(Status.Kw);
            } else {
                mdVar.j(new Status(13));
            }
        }

        public void a(mq mqVar, lx lxVar) throws RemoteException {
            kw();
            lxVar.a(new DataSourcesResult(this.Wx.onFindDataSources(mqVar.getDataTypes()), Status.Kw));
        }

        public void a(ms msVar, md mdVar) throws RemoteException {
            kw();
            if (this.Wx.onUnregister(msVar.getDataSource())) {
                mdVar.j(Status.Kw);
            } else {
                mdVar.j(new Status(13));
            }
        }
    }

    public final IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + intent + " received by " + getClass().getName());
        }
        return this.Ww.asBinder();
    }

    public void onCreate() {
        super.onCreate();
        this.Ww = new a();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);
}
