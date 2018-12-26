package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class hz implements AppIndexApi, ht {

    private static abstract class b<T extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<T, hx> {
        public b(GoogleApiClient googleApiClient) {
            super(hc.CG, googleApiClient);
        }

        protected abstract void a(hu huVar) throws RemoteException;

        protected final void a(hx hxVar) throws RemoteException {
            a(hxVar.fH());
        }
    }

    private static abstract class c<T extends Result> extends b<Status> {
        c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status b(Status status) {
            return status;
        }

        protected /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    private static final class a implements ActionResult {
        private hz DE;
        private PendingResult<Status> DF;
        private Action DG;
        private String DH;

        a(hz hzVar, PendingResult<Status> pendingResult, Action action, String str) {
            this.DE = hzVar;
            this.DF = pendingResult;
            this.DG = action;
            this.DH = str;
        }

        public PendingResult<Status> end(GoogleApiClient apiClient) {
            String packageName = ((hx) apiClient.a(hc.CG)).getContext().getPackageName();
            hr a = hy.a(this.DG, this.DH, System.currentTimeMillis(), packageName, 3);
            return this.DE.a(apiClient, a);
        }

        public PendingResult<Status> getPendingResult() {
            return this.DF;
        }
    }

    private static final class d extends hw<Status> {
        public d(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            super(bVar);
        }

        public void a(Status status) {
            this.DA.b(status);
        }
    }

    public static Intent a(String str, Uri uri) {
        b(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private static void b(String str, Uri uri) {
        if ("android-app".equals(uri.getScheme())) {
            String host = uri.getHost();
            if (str == null || str.equals(host)) {
                List pathSegments = uri.getPathSegments();
                if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                    throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
                }
                return;
            }
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    public static void c(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                b(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public PendingResult<Status> a(GoogleApiClient googleApiClient, final hr... hrVarArr) {
        final String packageName = ((hx) googleApiClient.a(hc.CG)).getContext().getPackageName();
        return googleApiClient.a(new c<Status>(this, googleApiClient) {
            final /* synthetic */ hz DD;

            protected void a(hu huVar) throws RemoteException {
                huVar.a(new d(this), packageName, hrVarArr);
            }
        });
    }

    public ActionResult action(GoogleApiClient apiClient, Action action) {
        String packageName = ((hx) apiClient.a(hc.CG)).getContext().getPackageName();
        return new a(this, a(apiClient, hy.a(action, String.valueOf(System.currentTimeMillis()), r2, packageName, 0)), action, String.valueOf(System.currentTimeMillis()));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = ((hx) apiClient.a(hc.CG)).getContext().getPackageName();
        c(outLinks);
        return a(apiClient, new hr(packageName, viewIntent, title, webUrl, null, (List) outLinks));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = ((hx) apiClient.a(hc.CG)).getContext().getPackageName();
        b(packageName, appIndexingUrl);
        return view(apiClient, activity, a(packageName, appIndexingUrl), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        hr hrVar = new hr(hr.a(((hx) apiClient.a(hc.CG)).getContext().getPackageName(), viewIntent), System.currentTimeMillis(), 3);
        return a(apiClient, hrVar);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl) {
        return viewEnd(apiClient, activity, a(((hx) apiClient.a(hc.CG)).getContext().getPackageName(), appIndexingUrl));
    }
}
