package com.google.android.gms.common.api;

import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status Eb;
    private final PendingResult<?>[] JC;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.Eb = status;
        this.JC = pendingResults;
    }

    public Status getStatus() {
        return this.Eb;
    }

    public <R extends Result> R take(BatchResultToken<R> resultToken) {
        jx.b(resultToken.mId < this.JC.length, (Object) "The result token does not belong to this batch");
        return this.JC[resultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
