package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;

public final class av {
    public static Status gN(int i) {
        return new Status(i, CommonStatusCodes.getStatusCodeString(i));
    }
}
