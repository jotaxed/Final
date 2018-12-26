package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class u extends aj {
    private static final String ID = a.CUSTOM_VAR.toString();
    private static final String NAME = b.NAME.toString();
    private static final String aqZ = b.DEFAULT_VALUE.toString();
    private final DataLayer aqn;

    public u(DataLayer dataLayer) {
        super(ID, NAME);
        this.aqn = dataLayer;
    }

    public d.a B(Map<String, d.a> map) {
        Object obj = this.aqn.get(di.j((d.a) map.get(NAME)));
        if (obj != null) {
            return di.u(obj);
        }
        d.a aVar = (d.a) map.get(aqZ);
        return aVar != null ? aVar : di.rb();
    }

    public boolean pe() {
        return false;
    }
}
