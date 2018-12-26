package com.google.android.gms.appindexing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hz;

public final class AppIndex {
    public static final Api<NoOptions> API = hc.CI;
    public static final Api<NoOptions> APP_INDEX_API = hc.CI;
    public static final AppIndexApi AppIndexApi = new hz();

    private AppIndex() {
    }
}
