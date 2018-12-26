package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class x implements DrivePreferencesApi {

    private abstract class c extends q<FileUploadPreferencesResult> {
        final /* synthetic */ x Qq;

        public c(x xVar, GoogleApiClient googleApiClient) {
            this.Qq = xVar;
            super(googleApiClient);
        }

        protected /* synthetic */ Result c(Status status) {
            return t(status);
        }

        protected FileUploadPreferencesResult t(Status status) {
            return new b(status, null);
        }
    }

    private class a extends c {
        private final com.google.android.gms.common.api.BaseImplementation.b<FileUploadPreferencesResult> Ea;
        final /* synthetic */ x Qq;

        private a(x xVar, com.google.android.gms.common.api.BaseImplementation.b<FileUploadPreferencesResult> bVar) {
            this.Qq = xVar;
            this.Ea = bVar;
        }

        public void a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.Ea.b(new b(Status.Kw, onDeviceUsagePreferenceResponse.iN()));
        }

        public void n(Status status) throws RemoteException {
            this.Ea.b(new b(status, null));
        }
    }

    private class b implements FileUploadPreferencesResult {
        private final Status Eb;
        final /* synthetic */ x Qq;
        private final FileUploadPreferences Qs;

        private b(x xVar, Status status, FileUploadPreferences fileUploadPreferences) {
            this.Qq = xVar;
            this.Eb = status;
            this.Qs = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.Qs;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.a(new c(this, apiClient) {
            final /* synthetic */ x Qq;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().h(new a(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return apiClient.b(new a(this, apiClient) {
                final /* synthetic */ x Qq;

                protected void a(r rVar) throws RemoteException {
                    rVar.iG().a(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new bg(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
