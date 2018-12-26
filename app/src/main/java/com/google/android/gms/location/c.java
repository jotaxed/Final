package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.nk;

@Deprecated
public class c implements GooglePlayServicesClient {
    private final nk agq;

    public interface a {
        void a(int i, String[] strArr);
    }

    public interface b {
        void a(int i, PendingIntent pendingIntent);

        void b(int i, String[] strArr);
    }

    public void connect() {
        this.agq.connect();
    }

    public void disconnect() {
        this.agq.disconnect();
    }

    public boolean isConnected() {
        return this.agq.isConnected();
    }

    public boolean isConnecting() {
        return this.agq.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.agq.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.agq.isConnectionFailedListenerRegistered(listener);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.agq.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.agq.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.agq.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.agq.unregisterConnectionFailedListener(listener);
    }
}
