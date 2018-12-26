package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.jx;

public interface SessionsApi {

    public static class ViewIntentBuilder {
        private String TP;
        private Session TQ;
        private boolean TR = false;
        private final Context mContext;

        public ViewIntentBuilder(Context context) {
            this.mContext = context;
        }

        private Intent i(Intent intent) {
            if (this.TP == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.TP);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.TP, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            jx.a(this.TQ != null, "Session must be set");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(Session.getMimeType(this.TQ.getActivity()));
            c.a(this.TQ, intent, Session.EXTRA_SESSION);
            if (!this.TR) {
                this.TP = this.TQ.getAppPackageName();
            }
            return i(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.TP = packageName;
            this.TR = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.TQ = session;
            return this;
        }
    }

    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);
}
