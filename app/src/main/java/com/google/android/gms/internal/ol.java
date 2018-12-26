package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class ol implements PanoramaApi {

    private static abstract class c<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, om> {
        protected c(GoogleApiClient googleApiClient) {
            super(Panorama.DQ, googleApiClient);
        }

        protected abstract void a(Context context, ok okVar) throws RemoteException;

        protected final void a(om omVar) throws RemoteException {
            a(omVar.getContext(), (ok) omVar.hw());
        }
    }

    private static abstract class a extends c<PanoramaResult> {
        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected PanoramaResult ay(Status status) {
            return new on(status, null);
        }

        protected /* synthetic */ Result c(Status status) {
            return ay(status);
        }
    }

    private static final class b extends com.google.android.gms.internal.oj.a {
        private final com.google.android.gms.common.api.BaseImplementation.b<PanoramaResult> Ea;

        public b(com.google.android.gms.common.api.BaseImplementation.b<PanoramaResult> bVar) {
            this.Ea = bVar;
        }

        public void a(int i, Bundle bundle, int i2, Intent intent) {
            this.Ea.b(new on(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static void a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void a(final Context context, ok okVar, final oj ojVar, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            okVar.a(new com.google.android.gms.internal.oj.a() {
                public void a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    ol.a(context, uri);
                    ojVar.a(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            a(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            a(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.a(new a(this, client) {
            final /* synthetic */ ol amP;

            protected void a(Context context, ok okVar) throws RemoteException {
                okVar.a(new b(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.a(new a(this, client) {
            final /* synthetic */ ol amP;

            protected void a(Context context, ok okVar) throws RemoteException {
                ol.a(context, okVar, new b(this), uri, null);
            }
        });
    }
}
