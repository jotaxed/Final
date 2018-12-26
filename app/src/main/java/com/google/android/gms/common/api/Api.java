package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final b<?, O> Jm;
    private final c<?> Jn;
    private final ArrayList<Scope> Jo;

    public interface b<T extends a, O> {
        T a(Context context, Looper looper, jg jgVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public interface a {
        void connect();

        void disconnect();

        boolean isConnected();
    }

    public static final class c<C extends a> {
    }

    public <C extends a> Api(b<C, O> clientBuilder, c<C> clientKey, Scope... impliedScopes) {
        this.Jm = clientBuilder;
        this.Jn = clientKey;
        this.Jo = new ArrayList(Arrays.asList(impliedScopes));
    }

    public b<?, O> gx() {
        return this.Jm;
    }

    public List<Scope> gy() {
        return this.Jo;
    }

    public c<?> gz() {
        return this.Jn;
    }
}
