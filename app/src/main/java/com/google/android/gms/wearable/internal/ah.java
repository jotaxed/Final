package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ah implements MessageApi {

    private static final class a extends d<Status> {
        private IntentFilter[] axD;
        private MessageListener axV;

        private a(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.axV = messageListener;
            this.axD = intentFilterArr;
        }

        protected void a(ba baVar) throws RemoteException {
            baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, this.axV, this.axD);
            this.axV = null;
            this.axD = null;
        }

        public Status b(Status status) {
            this.axV = null;
            this.axD = null;
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public static class b implements SendMessageResult {
        private final Status Eb;
        private final int ve;

        public b(Status status, int i) {
            this.Eb = status;
            this.ve = i;
        }

        public int getRequestId() {
            return this.ve;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private PendingResult<Status> a(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.a(new a(googleApiClient, messageListener, intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return a(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.a(new d<Status>(this, client) {
            final /* synthetic */ ah axT;

            protected void a(ba baVar) throws RemoteException {
                baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, listener);
            }

            public Status b(Status status) {
                return status;
            }

            public /* synthetic */ Result c(Status status) {
                return b(status);
            }
        });
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        final String str = nodeId;
        final String str2 = action;
        final byte[] bArr = data;
        return client.a(new d<SendMessageResult>(this, client) {
            final /* synthetic */ ah axT;

            protected void a(ba baVar) throws RemoteException {
                baVar.a(this, str, str2, bArr);
            }

            protected SendMessageResult aI(Status status) {
                return new b(status, -1);
            }

            protected /* synthetic */ Result c(Status status) {
                return aI(status);
            }
        });
    }
}
