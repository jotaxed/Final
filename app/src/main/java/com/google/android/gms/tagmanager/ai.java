package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.c.c;
import com.google.android.gms.internal.c.d;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ai {
    private static void a(DataLayer dataLayer, d dVar) {
        for (a j : dVar.fB) {
            dataLayer.cx(di.j(j));
        }
    }

    public static void a(DataLayer dataLayer, i iVar) {
        if (iVar.gq == null) {
            bh.W("supplemental missing experimentSupplemental");
            return;
        }
        a(dataLayer, iVar.gq);
        b(dataLayer, iVar.gq);
        c(dataLayer, iVar.gq);
    }

    private static void b(DataLayer dataLayer, d dVar) {
        for (a c : dVar.fA) {
            Map c2 = c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map<String, Object> c(a aVar) {
        Object o = di.o(aVar);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.W("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void c(DataLayer dataLayer, d dVar) {
        for (c cVar : dVar.fC) {
            if (cVar.fv == null) {
                bh.W("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(cVar.fv);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = cVar.fw;
                long j2 = cVar.fx;
                if (!cVar.fy || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.W("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.cx(cVar.fv);
                Map c = dataLayer.c(cVar.fv, obj);
                if (cVar.fz > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(cVar.fz));
                        } else {
                            bh.W("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(cVar.fz)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
