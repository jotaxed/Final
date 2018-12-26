package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class nb implements ActivityRecognitionApi {

    private static abstract class a extends com.google.android.gms.location.ActivityRecognition.a<Status> {
        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.b(new a(this, client) {
            final /* synthetic */ nb agC;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(callbackIntent);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        final long j = detectionIntervalMillis;
        final PendingIntent pendingIntent = callbackIntent;
        return client.b(new a(this, client) {
            final /* synthetic */ nb agC;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(j, pendingIntent);
                b(Status.Kw);
            }
        });
    }
}
