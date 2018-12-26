package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class b extends aj {
    private static final String ID = a.ADVERTISER_ID.toString();
    private final a aqc;

    public b(Context context) {
        this(a.W(context));
    }

    b(a aVar) {
        super(ID, new String[0]);
        this.aqc = aVar;
    }

    public d.a B(Map<String, d.a> map) {
        String pa = this.aqc.pa();
        return pa == null ? di.rb() : di.u(pa);
    }

    public boolean pe() {
        return false;
    }
}
