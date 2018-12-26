package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class p implements DriveApi {

    static abstract class g extends q<MetadataBufferResult> {
        g(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return q(status);
        }

        public MetadataBufferResult q(Status status) {
            return new f(status, null, false);
        }
    }

    static abstract class b extends q<DriveContentsResult> {
        b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return o(status);
        }

        public DriveContentsResult o(Status status) {
            return new a(status, null);
        }
    }

    static abstract class e extends q<DriveIdResult> {
        e(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return p(status);
        }

        public DriveIdResult p(Status status) {
            return new d(status, null);
        }
    }

    static class a implements DriveContentsResult {
        private final Status Eb;
        private final DriveContents Om;

        public a(Status status, DriveContents driveContents) {
            this.Eb = status;
            this.Om = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.Om;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    static class c extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<DriveIdResult> Ea;

        public c(com.google.android.gms.common.api.BaseImplementation.b<DriveIdResult> bVar) {
            this.Ea = bVar;
        }

        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.b(new d(Status.Kw, onDriveIdResponse.getDriveId()));
        }

        public void a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.Ea.b(new d(Status.Kw, new m(onMetadataResponse.iU()).getDriveId()));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new d(status, null));
        }
    }

    private static class d implements DriveIdResult {
        private final Status Eb;
        private final DriveId Oj;

        public d(Status status, DriveId driveId) {
            this.Eb = status;
            this.Oj = driveId;
        }

        public DriveId getDriveId() {
            return this.Oj;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    static class f implements MetadataBufferResult {
        private final Status Eb;
        private final MetadataBuffer PI;
        private final boolean PJ;

        public f(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.Eb = status;
            this.PI = metadataBuffer;
            this.PJ = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.PI;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static class h extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<DriveContentsResult> Ea;

        public h(com.google.android.gms.common.api.BaseImplementation.b<DriveContentsResult> bVar) {
            this.Ea = bVar;
        }

        public void a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.Ea.b(new a(Status.Kw, new s(onContentsResponse.iL())));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new a(status, null));
        }
    }

    private static class i extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<MetadataBufferResult> Ea;

        public i(com.google.android.gms.common.api.BaseImplementation.b<MetadataBufferResult> bVar) {
            this.Ea = bVar;
        }

        public void a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.Ea.b(new f(Status.Kw, new MetadataBuffer(onListEntriesResponse.iR(), null), onListEntriesResponse.iS()));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new f(status, null, false));
        }
    }

    static class j extends a {
        j(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            b((Result) status);
        }

        protected void a(r rVar) {
        }
    }

    public PendingResult<DriveContentsResult> a(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.a(new b(this, googleApiClient) {
            final /* synthetic */ p PF;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().a(new CreateContentsRequest(i), new h(this));
            }
        });
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((r) apiClient.a(Drive.DQ)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.a(new e(this, apiClient) {
            final /* synthetic */ p PF;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().a(new GetMetadataRequest(DriveId.bi(resourceId)), new c(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId iI = ((r) apiClient.a(Drive.DQ)).iI();
            return iI != null ? new v(iI) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new t(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new v(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new v(((r) apiClient.a(Drive.DQ)).iH());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return a(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.a(new g(this, apiClient) {
                final /* synthetic */ p PF;

                protected void a(r rVar) throws RemoteException {
                    rVar.iG().a(new QueryRequest(query), new i(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.b(new a(this, apiClient) {
            final /* synthetic */ p PF;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().a(new bg(this));
            }
        });
    }
}
