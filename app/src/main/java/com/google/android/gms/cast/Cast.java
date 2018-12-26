package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final CastApi CastApi = new a();
    static final com.google.android.gms.common.api.Api.c<im> DQ = new com.google.android.gms.common.api.Api.c();
    private static final com.google.android.gms.common.api.Api.b<im, CastOptions> DR = new com.google.android.gms.common.api.Api.b<im, CastOptions>() {
        public im a(Context context, Looper looper, jg jgVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.b((Object) castOptions, (Object) "Setting the API options is required.");
            return new im(context, looper, castOptions.Fz, (long) castOptions.FB, castOptions.FA, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    protected static abstract class a<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, im> {
        public a(GoogleApiClient googleApiClient) {
            super(Cast.DQ, googleApiClient);
        }

        public void W(int i) {
            b(c(new Status(i)));
        }

        public void e(int i, String str) {
            b(c(new Status(i, str, null)));
        }
    }

    private static abstract class b extends a<Status> {
        b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    private static abstract class c extends a<ApplicationConnectionResult> {
        public c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return i(status);
        }

        public ApplicationConnectionResult i(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ c FF;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    public interface CastApi {

        public static final class a implements CastApi {
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.a(Cast.DQ)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.a(Cast.DQ)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.a(Cast.DQ)).fZ();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.a(Cast.DQ)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.b(new c(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.b(null, null, this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.b(new c(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.b(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.b(new c(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.b(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.b(new c(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.a(applicationId, false, (com.google.android.gms.common.api.BaseImplementation.b) this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.b(new c(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.a(applicationId, options, (com.google.android.gms.common.api.BaseImplementation.b) this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.b(new b(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.d((com.google.android.gms.common.api.BaseImplementation.b) this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((im) client.a(Cast.DQ)).aE(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((im) client.a(Cast.DQ)).fY();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.b(new b(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.a(namespace, message, (com.google.android.gms.common.api.BaseImplementation.b) this);
                        } catch (IllegalArgumentException e) {
                            W(2001);
                        } catch (IllegalStateException e2) {
                            W(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((im) client.a(Cast.DQ)).a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((im) client.a(Cast.DQ)).I(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((im) client.a(Cast.DQ)).a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.b(new b(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        try {
                            imVar.a("", (com.google.android.gms.common.api.BaseImplementation.b) this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.b(new b(this, client) {
                    final /* synthetic */ a Fv;

                    protected void a(im imVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            e(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            imVar.a(sessionId, (com.google.android.gms.common.api.BaseImplementation.b) this);
                        } catch (IllegalStateException e) {
                            W(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements HasOptions {
        final Listener FA;
        private final int FB;
        final CastDevice Fz;

        public static final class Builder {
            CastDevice FC;
            Listener FD;
            private int FE;

            private Builder(CastDevice castDevice, Listener castListener) {
                jx.b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                jx.b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.FC = castDevice;
                this.FD = castListener;
                this.FE = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.FE |= 1;
                } else {
                    this.FE &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.Fz = builder.FC;
            this.FA = builder.FD;
            this.FB = builder.FE;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    public static class Listener {
        public void X(int i) {
        }

        public void Y(int i) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private Cast() {
    }
}
