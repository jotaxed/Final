package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class y implements DriveResource {
    protected final DriveId Oj;

    private abstract class d extends q<MetadataResult> {
        final /* synthetic */ y Qt;

        private d(y yVar, GoogleApiClient googleApiClient) {
            this.Qt = yVar;
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return u(status);
        }

        public MetadataResult u(Status status) {
            return new c(status, null);
        }
    }

    private static class a extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<MetadataBufferResult> Ea;

        public a(com.google.android.gms.common.api.BaseImplementation.b<MetadataBufferResult> bVar) {
            this.Ea = bVar;
        }

        public void a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.Ea.b(new f(Status.Kw, new MetadataBuffer(onListParentsResponse.iT(), null), false));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new f(status, null, false));
        }
    }

    private static class b extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<MetadataResult> Ea;

        public b(com.google.android.gms.common.api.BaseImplementation.b<MetadataResult> bVar) {
            this.Ea = bVar;
        }

        public void a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.Ea.b(new c(Status.Kw, new m(onMetadataResponse.iU())));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new c(status, null));
        }
    }

    private static class c implements MetadataResult {
        private final Status Eb;
        private final Metadata Qv;

        public c(Status status, Metadata metadata) {
            this.Eb = status;
            this.Qv = metadata;
        }

        public Metadata getMetadata() {
            return this.Qv;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    protected y(DriveId driveId) {
        this.Oj = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((r) apiClient.a(Drive.DQ)).a(apiClient, this.Oj, 1, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((r) apiClient.a(Drive.DQ)).a(apiClient, this.Oj, 1);
    }

    public DriveId getDriveId() {
        return this.Oj;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.a(new d(this, apiClient) {
            final /* synthetic */ y Qt;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().a(new GetMetadataRequest(this.Qt.Oj), new b(this));
            }
        });
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.a(new g(this, apiClient) {
            final /* synthetic */ y Qt;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().a(new ListParentsRequest(this.Qt.Oj), new a(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((r) apiClient.a(Drive.DQ)).b(apiClient, this.Oj, 1, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((r) apiClient.a(Drive.DQ)).b(apiClient, this.Oj, 1);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (parentIds.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            final List arrayList = new ArrayList(parentIds);
            return apiClient.b(new a(this, apiClient) {
                final /* synthetic */ y Qt;

                protected void a(r rVar) throws RemoteException {
                    rVar.iG().a(new SetResourceParentsRequest(this.Qt.Oj, arrayList), new bg(this));
                }
            });
        }
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.b(new d(this, apiClient) {
                final /* synthetic */ y Qt;

                protected void a(r rVar) throws RemoteException {
                    changeSet.iz().setContext(rVar.getContext());
                    rVar.iG().a(new UpdateMetadataRequest(this.Qt.Oj, changeSet.iz()), new b(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
