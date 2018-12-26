package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.List;
import java.util.Map;

class w extends dg {
    private static final String ID = a.DATA_LAYER_WRITE.toString();
    private static final String VALUE = b.VALUE.toString();
    private static final String ark = b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer aqn;

    public w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.aqn = dataLayer;
    }

    private void a(d.a aVar) {
        if (aVar != null && aVar != di.qV()) {
            String j = di.j(aVar);
            if (j != di.ra()) {
                this.aqn.cx(j);
            }
        }
    }

    private void b(d.a aVar) {
        if (aVar != null && aVar != di.qV()) {
            Object o = di.o(aVar);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.aqn.push((Map) o2);
                    }
                }
            }
        }
    }

    public void D(Map<String, d.a> map) {
        b((d.a) map.get(VALUE));
        a((d.a) map.get(ark));
    }
}
