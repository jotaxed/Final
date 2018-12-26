package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class bj extends aj {
    private static final String ID = a.LOWERCASE_STRING.toString();
    private static final String arp = b.ARG0.toString();

    public bj() {
        super(ID, arp);
    }

    public d.a B(Map<String, d.a> map) {
        return di.u(di.j((d.a) map.get(arp)).toLowerCase());
    }

    public boolean pe() {
        return true;
    }
}
