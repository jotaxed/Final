package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class cd extends aj {
    private static final String arp = b.ARG0.toString();
    private static final String ask = b.ARG1.toString();

    public cd(String str) {
        super(str, arp, ask);
    }

    public a B(Map<String, a> map) {
        for (a aVar : map.values()) {
            if (aVar == di.rb()) {
                return di.u(Boolean.valueOf(false));
            }
        }
        a aVar2 = (a) map.get(arp);
        a aVar3 = (a) map.get(ask);
        boolean a = (aVar2 == null || aVar3 == null) ? false : a(aVar2, aVar3, map);
        return di.u(Boolean.valueOf(a));
    }

    protected abstract boolean a(a aVar, a aVar2, Map<String, a> map);

    public boolean pe() {
        return true;
    }
}
