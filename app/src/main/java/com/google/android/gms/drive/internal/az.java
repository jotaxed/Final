package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

class az extends c {
    private final b<DriveContentsResult> Ea;
    private final DownloadProgressListener QU;

    az(b<DriveContentsResult> bVar, DownloadProgressListener downloadProgressListener) {
        this.Ea = bVar;
        this.QU = downloadProgressListener;
    }

    public void a(OnContentsResponse onContentsResponse) throws RemoteException {
        this.Ea.b(new a(onContentsResponse.iM() ? new Status(-1) : Status.Kw, new s(onContentsResponse.iL())));
    }

    public void a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.QU != null) {
            this.QU.onProgress(onDownloadProgressResponse.iO(), onDownloadProgressResponse.iP());
        }
    }

    public void n(Status status) throws RemoteException {
        this.Ea.b(new a(status, null));
    }
}
