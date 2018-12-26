package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API = new Api(DR, DQ, SCOPE_APP_STATE);
    static final com.google.android.gms.common.api.Api.c<ib> DQ = new com.google.android.gms.common.api.Api.c();
    private static final com.google.android.gms.common.api.Api.b<ib, NoOptions> DR = new com.google.android.gms.common.api.Api.b<ib, NoOptions>() {
        public /* synthetic */ com.google.android.gms.common.api.Api.a a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return b(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public ib b(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ib(context, looper, connectionCallbacks, onConnectionFailedListener, jgVar.hm(), (String[]) jgVar.ho().toArray(new String[0]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, ib> {
        public a(GoogleApiClient googleApiClient) {
            super(AppStateManager.DQ, googleApiClient);
        }
    }

    private static abstract class e extends a<StateResult> {
        public e(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return h(status);
        }

        public StateResult h(Status status) {
            return AppStateManager.d(status);
        }
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    private static abstract class b extends a<StateDeletedResult> {
        b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    private static abstract class c extends a<StateListResult> {
        public c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return g(status);
        }

        public StateListResult g(final Status status) {
            return new StateListResult(this) {
                final /* synthetic */ c DY;

                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class d extends a<Status> {
        public d(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    private AppStateManager() {
    }

    public static ib a(GoogleApiClient googleApiClient) {
        boolean z = true;
        jx.b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ib ibVar = (ib) googleApiClient.a(DQ);
        if (ibVar == null) {
            z = false;
        }
        jx.a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return ibVar;
    }

    private static StateResult d(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.b(new b(googleApiClient) {
            protected void a(ib ibVar) {
                ibVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, stateKey);
            }

            public /* synthetic */ Result c(Status status) {
                return f(status);
            }

            public StateDeletedResult f(final Status status) {
                return new StateDeletedResult(this) {
                    final /* synthetic */ AnonymousClass5 DV;

                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return a(googleApiClient).fM();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return a(googleApiClient).fL();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.a(new c(googleApiClient) {
            protected void a(ib ibVar) {
                ibVar.a(this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.a(new e(googleApiClient) {
            protected void a(ib ibVar) {
                ibVar.b(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.b(new e(googleApiClient) {
            protected void a(ib ibVar) {
                ibVar.a(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.b(new d(googleApiClient) {
            protected void a(ib ibVar) {
                ibVar.b(this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.b(new e(googleApiClient) {
            protected void a(ib ibVar) {
                ibVar.a(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.b(new e(googleApiClient) {
            protected void a(ib ibVar) {
                ibVar.a(this, stateKey, data);
            }
        });
    }
}
