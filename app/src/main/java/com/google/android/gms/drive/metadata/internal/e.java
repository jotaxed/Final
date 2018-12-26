package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import com.google.android.gms.internal.lr;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private static Map<String, MetadataField<?>> Rh = new HashMap();

    static {
        b(ln.Rj);
        b(ln.RJ);
        b(ln.RA);
        b(ln.RH);
        b(ln.RK);
        b(ln.Ru);
        b(ln.Rv);
        b(ln.Rs);
        b(ln.Rx);
        b(ln.RF);
        b(ln.Rk);
        b(ln.RC);
        b(ln.Rm);
        b(ln.Rt);
        b(ln.Rn);
        b(ln.Ro);
        b(ln.Rp);
        b(ln.Rz);
        b(ln.Rw);
        b(ln.RB);
        b(ln.RD);
        b(ln.RE);
        b(ln.RG);
        b(ln.RL);
        b(ln.RM);
        b(ln.Rr);
        b(ln.Rq);
        b(ln.RI);
        b(ln.Ry);
        b(ln.Rl);
        b(ln.RN);
        b(ln.RO);
        b(ln.RP);
        b(lp.RQ);
        b(lp.RS);
        b(lp.RT);
        b(lp.RU);
        b(lp.RR);
        b(lr.RW);
        b(lr.RX);
    }

    private static void b(MetadataField<?> metadataField) {
        if (Rh.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        Rh.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> bm(String str) {
        return (MetadataField) Rh.get(str);
    }

    public static Collection<MetadataField<?>> iY() {
        return Collections.unmodifiableCollection(Rh.values());
    }
}
