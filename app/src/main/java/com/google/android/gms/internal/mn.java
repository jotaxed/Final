package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.u;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.lu.c;

public class mn implements SessionsApi {

    private static class a extends com.google.android.gms.internal.mb.a {
        private final com.google.android.gms.common.api.BaseImplementation.b<SessionReadResult> Ea;

        private a(com.google.android.gms.common.api.BaseImplementation.b<SessionReadResult> bVar) {
            this.Ea = bVar;
        }

        public void a(SessionReadResult sessionReadResult) throws RemoteException {
            this.Ea.b(sessionReadResult);
        }
    }

    private static class b extends com.google.android.gms.internal.mc.a {
        private final com.google.android.gms.common.api.BaseImplementation.b<SessionStopResult> Ea;

        private b(com.google.android.gms.common.api.BaseImplementation.b<SessionStopResult> bVar) {
            this.Ea = bVar;
        }

        public void a(SessionStopResult sessionStopResult) {
            this.Ea.b(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> a(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.b(new com.google.android.gms.internal.lu.a<SessionStopResult>(this, googleApiClient) {
            final /* synthetic */ mn Vw;

            protected SessionStopResult A(Status status) {
                return SessionStopResult.H(status);
            }

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new com.google.android.gms.fitness.request.y.a().bx(str).by(str2).kl(), new b(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return A(status);
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.a(new c(this, client) {
            final /* synthetic */ mn Vw;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(request, new com.google.android.gms.internal.lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.a(new com.google.android.gms.internal.lu.a<SessionReadResult>(this, client) {
            final /* synthetic */ mn Vw;

            protected SessionReadResult B(Status status) {
                return SessionReadResult.G(status);
            }

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(request, new a(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return B(status);
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.b(new c(this, client) {
            final /* synthetic */ mn Vw;

            protected void a(lu luVar) throws RemoteException {
                md bVar = new com.google.android.gms.internal.lu.b(this);
                luVar.jM().a(new u(intent), bVar, luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        return client.b(new c(this, client) {
            final /* synthetic */ mn Vw;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new com.google.android.gms.fitness.request.w.a().b(session).kk(), new com.google.android.gms.internal.lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return a(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.b(new c(this, client) {
            final /* synthetic */ mn Vw;

            protected void a(lu luVar) throws RemoteException {
                md bVar = new com.google.android.gms.internal.lu.b(this);
                luVar.jM().a(new aa(intent), bVar, luVar.getContext().getPackageName());
            }
        });
    }
}
