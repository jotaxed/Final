package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jx;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String OH;
    private String[] OI;
    private DriveId OJ;

    public IntentSender build(GoogleApiClient apiClient) {
        jx.a(apiClient.isConnected(), "Client must be connected");
        if (this.OI == null) {
            this.OI = new String[0];
        }
        try {
            return ((r) apiClient.a(Drive.DQ)).iG().a(new OpenFileIntentSenderRequest(this.OH, this.OI, this.OJ));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.OJ = (DriveId) jx.i(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.OH = (String) jx.i(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        jx.b(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.OI = mimeTypes;
        return this;
    }
}
