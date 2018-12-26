package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult;

public class f extends AbstractPendingResult<Status> {
    public f(Looper looper) {
        super(looper);
    }

    protected Status b(Status status) {
        return status;
    }

    protected /* synthetic */ Result c(Status status) {
        return b(status);
    }
}
