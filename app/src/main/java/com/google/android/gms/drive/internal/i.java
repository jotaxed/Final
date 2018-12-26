package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.jx;

public class i {
    private String OH;
    private DriveId OJ;
    protected MetadataChangeSet Pu;
    private Integer Pv;
    private final int Pw;

    public i(int i) {
        this.Pw = i;
    }

    public void a(DriveId driveId) {
        this.OJ = (DriveId) jx.i(driveId);
    }

    public void a(MetadataChangeSet metadataChangeSet) {
        this.Pu = (MetadataChangeSet) jx.i(metadataChangeSet);
    }

    public void bl(String str) {
        this.OH = (String) jx.i(str);
    }

    public void bq(int i) {
        this.Pv = Integer.valueOf(i);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        jx.b(this.Pu, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        jx.a(apiClient.isConnected(), "Client must be connected");
        r rVar = (r) apiClient.a(Drive.DQ);
        this.Pu.iz().setContext(rVar.getContext());
        try {
            return rVar.iG().a(new CreateFileIntentSenderRequest(this.Pu.iz(), this.Pv == null ? -1 : this.Pv.intValue(), this.OH, this.OJ, this.Pw));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }
}
