package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public final class ak implements NodeApi {

    private static final class a extends d<Status> {
        private NodeListener axZ;

        private a(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.axZ = nodeListener;
        }

        protected void a(ba baVar) throws RemoteException {
            baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, this.axZ);
            this.axZ = null;
        }

        public Status b(Status status) {
            this.axZ = null;
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public static class b implements GetConnectedNodesResult {
        private final Status Eb;
        private final List<Node> aya;

        public b(Status status, List<Node> list) {
            this.Eb = status;
            this.aya = list;
        }

        public List<Node> getNodes() {
            return this.aya;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public static class c implements GetLocalNodeResult {
        private final Status Eb;
        private final Node ayb;

        public c(Status status, Node node) {
            this.Eb = status;
            this.ayb = node;
        }

        public Node getNode() {
            return this.ayb;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return client.a(new a(client, listener));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.a(new d<GetConnectedNodesResult>(this, client) {
            final /* synthetic */ ak axX;

            protected void a(ba baVar) throws RemoteException {
                baVar.p(this);
            }

            protected GetConnectedNodesResult aK(Status status) {
                return new b(status, null);
            }

            protected /* synthetic */ Result c(Status status) {
                return aK(status);
            }
        });
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.a(new d<GetLocalNodeResult>(this, client) {
            final /* synthetic */ ak axX;

            protected void a(ba baVar) throws RemoteException {
                baVar.o(this);
            }

            protected GetLocalNodeResult aJ(Status status) {
                return new c(status, null);
            }

            protected /* synthetic */ Result c(Status status) {
                return aJ(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeListener listener) {
        return client.a(new d<Status>(this, client) {
            final /* synthetic */ ak axX;

            protected void a(ba baVar) throws RemoteException {
                baVar.b((com.google.android.gms.common.api.BaseImplementation.b) this, listener);
            }

            public Status b(Status status) {
                return status;
            }

            public /* synthetic */ Result c(Status status) {
                return b(status);
            }
        });
    }
}
