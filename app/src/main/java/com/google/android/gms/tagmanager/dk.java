package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class dk extends aj {
    private static final String ID = a.UPPERCASE_STRING.toString();
    private static final String arp = b.ARG0.toString();

    public dk() {
        super(ID, arp);
    }

    public d.a B(Map<String, d.a> map) {
        return di.u(di.j((d.a) map.get(arp)).toUpperCase());
    }

    public boolean pe() {
        return true;
    }
}
