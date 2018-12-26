package com.google.android.gms.appindexing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.List;

public interface AppIndexApi {

    public interface ActionResult {
        PendingResult<Status> end(GoogleApiClient googleApiClient);

        PendingResult<Status> getPendingResult();
    }

    public static final class AppIndexingLink {
        public final Uri appIndexingUrl;
        public final int viewId;
        public final Uri webUrl;

        public AppIndexingLink(Uri appIndexingUrl, Uri webUrl, View view) {
            this.appIndexingUrl = appIndexingUrl;
            this.webUrl = webUrl;
            this.viewId = view.getId();
        }

        public AppIndexingLink(Uri appIndexingUrl, View view) {
            this(appIndexingUrl, null, view);
        }
    }

    ActionResult action(GoogleApiClient googleApiClient, Action action);

    @Deprecated
    PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexingLink> list);

    PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexingLink> list);

    @Deprecated
    PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent);

    PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri);
}
