package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class c extends aj {
    private static final String ID = a.ADVERTISING_TRACKING_ENABLED.toString();
    private final a aqc;

    public c(Context context) {
        this(a.W(context));
    }

    c(a aVar) {
        super(ID, new String[0]);
        this.aqc = aVar;
    }

    public d.a B(Map<String, d.a> map) {
        return di.u(Boolean.valueOf(!this.aqc.isLimitAdTrackingEnabled()));
    }

    public boolean pe() {
        return false;
    }
}
