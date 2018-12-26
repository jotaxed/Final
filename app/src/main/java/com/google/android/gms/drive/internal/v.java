package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

public class v extends y implements DriveFolder {

    static abstract class d extends q<DriveFileResult> {
        d(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return r(status);
        }

        public DriveFileResult r(Status status) {
            return new c(status, null);
        }
    }

    static abstract class f extends q<DriveFolderResult> {
        f(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return s(status);
        }

        public DriveFolderResult s(Status status) {
            return new e(status, null);
        }
    }

    private static class a extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<DriveFileResult> Ea;

        public a(com.google.android.gms.common.api.BaseImplementation.b<DriveFileResult> bVar) {
            this.Ea = bVar;
        }

        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.b(new c(Status.Kw, new t(onDriveIdResponse.getDriveId())));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new c(status, null));
        }
    }

    private static class b extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<DriveFolderResult> Ea;

        public b(com.google.android.gms.common.api.BaseImplementation.b<DriveFolderResult> bVar) {
            this.Ea = bVar;
        }

        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.b(new e(Status.Kw, new v(onDriveIdResponse.getDriveId())));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new e(status, null));
        }
    }

    private static class c implements DriveFileResult {
        private final Status Eb;
        private final DriveFile Qn;

        public c(Status status, DriveFile driveFile) {
            this.Eb = status;
            this.Qn = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Qn;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static class e implements DriveFolderResult {
        private final Status Eb;
        private final DriveFolder Qo;

        public e(Status status, DriveFolder driveFolder) {
            this.Eb = status;
            this.Qo = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Qo;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public v(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.a(googleApiClient, executionOptions);
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final int i4 = i2;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.b(new d(this, googleApiClient) {
            final /* synthetic */ v Qm;

            protected void a(r rVar) throws RemoteException {
                metadataChangeSet2.iz().setContext(rVar.getContext());
                rVar.iG().a(new CreateFileRequest(this.Qm.getDriveId(), metadataChangeSet2.iz(), i3, i4, executionOptions2), new a(this));
            }
        });
    }

    private PendingResult<DriveFileResult> a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.ir().getRequestId();
            driveContents.is();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return a(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (executionOptions.ix() == 0) {
            return a(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.b(new f(this, apiClient) {
                final /* synthetic */ v Qm;

                protected void a(r rVar) throws RemoteException {
                    changeSet.iz().setContext(rVar.getContext());
                    rVar.iG().a(new CreateFolderRequest(this.Qm.getDriveId(), changeSet.iz()), new b(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Query.Builder addFilter = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return new p().query(apiClient, addFilter.build());
    }
}
