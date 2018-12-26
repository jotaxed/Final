package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method apU = null;
    private static final Object ut = new Object();

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    private static void V(Context context) throws ClassNotFoundException, NoSuchMethodException {
        apU = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        jx.b((Object) context, (Object) "Context must not be null");
        GooglePlayServicesUtil.C(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (ut) {
            try {
                if (apU == null) {
                    V(remoteContext);
                }
                apU.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener listener) {
        jx.b((Object) context, (Object) "Context must not be null");
        jx.b((Object) listener, (Object) "Listener must not be null");
        jx.aU("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() {
            protected Integer c(Void... voidArr) {
                try {
                    ProviderInstaller.installIfNeeded(context);
                    return Integer.valueOf(0);
                } catch (GooglePlayServicesRepairableException e) {
                    return Integer.valueOf(e.getConnectionStatusCode());
                } catch (GooglePlayServicesNotAvailableException e2) {
                    return Integer.valueOf(e2.errorCode);
                }
            }

            protected void d(Integer num) {
                if (num.intValue() == 0) {
                    listener.onProviderInstalled();
                    return;
                }
                listener.onProviderInstallFailed(num.intValue(), GooglePlayServicesUtil.aj(num.intValue()));
            }

            protected /* synthetic */ Object doInBackground(Object[] x0) {
                return c((Void[]) x0);
            }

            protected /* synthetic */ void onPostExecute(Object x0) {
                d((Integer) x0);
            }
        }.execute(new Void[0]);
    }
}
