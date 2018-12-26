package com.google.android.gms.games.internal;

import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.lg;

public abstract class GamesDowngradeableSafeParcel extends ji {
    protected static boolean c(Integer num) {
        return num == null ? false : lg.aV(num.intValue());
    }
}
