package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class ax extends aj {
    private static final String ID = a.INSTALL_REFERRER.toString();
    private static final String aqd = b.COMPONENT.toString();
    private final Context lM;

    public ax(Context context) {
        super(ID, new String[0]);
        this.lM = context;
    }

    public d.a B(Map<String, d.a> map) {
        String e = ay.e(this.lM, ((d.a) map.get(aqd)) != null ? di.j((d.a) map.get(aqd)) : null);
        return e != null ? di.u(e) : di.rb();
    }

    public boolean pe() {
        return true;
    }
}
