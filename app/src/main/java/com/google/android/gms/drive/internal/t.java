package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class t extends y implements DriveFile {

    private static class a implements DownloadProgressListener {
        private final d<DownloadProgressListener> Qe;

        public a(d<DownloadProgressListener> dVar) {
            this.Qe = dVar;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.Qe.a(new b<DownloadProgressListener>(this) {
                final /* synthetic */ a Qh;

                public void a(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                public /* synthetic */ void c(Object obj) {
                    a((DownloadProgressListener) obj);
                }

                public void gG() {
                }
            });
        }
    }

    public t(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener a(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new a(googleApiClient.d(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener a = a(apiClient, listener);
            return apiClient.a(new b(this, apiClient) {
                final /* synthetic */ t Qd;

                protected void a(r rVar) throws RemoteException {
                    rVar.iG().a(new OpenContentsRequest(this.Qd.getDriveId(), mode, 0), new az(this, a));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
