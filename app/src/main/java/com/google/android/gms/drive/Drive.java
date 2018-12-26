package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.u;
import com.google.android.gms.drive.internal.x;
import com.google.android.gms.drive.internal.z;
import com.google.android.gms.internal.jg;
import java.util.List;

public final class Drive {
    public static final Api<NoOptions> API = new Api(new a<NoOptions>() {
        protected Bundle a(NoOptions noOptions) {
            return new Bundle();
        }
    }, DQ, new Scope[0]);
    public static final c<r> DQ = new c();
    public static final DriveApi DriveApi = new p();
    public static final DrivePreferencesApi DrivePreferencesApi = new x();
    public static final Scope Oo = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope Op = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<b> Oq = new Api(new a<b>() {
        protected Bundle a(b bVar) {
            return bVar == null ? new Bundle() : bVar.iq();
        }
    }, DQ, new Scope[0]);
    public static final b Or = new u();
    public static final e Os = new z();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);

    public static abstract class a<O extends ApiOptions> implements com.google.android.gms.common.api.Api.b<r, O> {
        protected abstract Bundle a(O o);

        public r a(Context context, Looper looper, jg jgVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List ho = jgVar.ho();
            return new r(context, looper, jgVar, connectionCallbacks, onConnectionFailedListener, (String[]) ho.toArray(new String[ho.size()]), a(o));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static class b implements Optional {
        private final Bundle DJ;

        private b() {
            this(new Bundle());
        }

        private b(Bundle bundle) {
            this.DJ = bundle;
        }

        public Bundle iq() {
            return this.DJ;
        }
    }

    private Drive() {
    }
}
