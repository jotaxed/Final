package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class cf extends aj {
    private static final String ID = a.RANDOM.toString();
    private static final String asu = b.MIN.toString();
    private static final String asv = b.MAX.toString();

    public cf() {
        super(ID, new String[0]);
    }

    public d.a B(Map<String, d.a> map) {
        double doubleValue;
        double d;
        d.a aVar = (d.a) map.get(asu);
        d.a aVar2 = (d.a) map.get(asv);
        if (!(aVar == null || aVar == di.rb() || aVar2 == null || aVar2 == di.rb())) {
            dh k = di.k(aVar);
            dh k2 = di.k(aVar2);
            if (!(k == di.qZ() || k2 == di.qZ())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return di.u(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return di.u(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }

    public boolean pe() {
        return false;
    }
}
