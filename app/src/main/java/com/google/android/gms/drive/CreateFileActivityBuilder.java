package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.i;
import com.google.android.gms.drive.internal.s;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final i Ol = new i(0);
    private DriveContents Om;
    private boolean On;

    public IntentSender build(GoogleApiClient apiClient) {
        jx.b(Boolean.valueOf(this.On), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        boolean z = apiClient.a(Drive.SCOPE_FILE) || apiClient.a(Drive.Oo);
        jx.b(z, (Object) "The apiClient must have suitable scope to create files");
        if (this.Om != null) {
            lh.a(this.Om.getParcelFileDescriptor());
            this.Om.is();
        }
        return this.Ol.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.Ol.a(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.Ol.bl(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.Ol.bq(1);
        } else if (!(driveContents instanceof s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.Ol.bq(driveContents.ir().getRequestId());
            this.Om = driveContents;
        }
        this.On = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.Ol.a(metadataChangeSet);
        return this;
    }
}
