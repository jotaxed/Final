package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class on implements PanoramaResult {
    private final Status Eb;
    private final Intent amR;

    public on(Status status, Intent intent) {
        this.Eb = (Status) jx.i(status);
        this.amR = intent;
    }

    public Status getStatus() {
        return this.Eb;
    }

    public Intent getViewerIntent() {
        return this.amR;
    }
}
