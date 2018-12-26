package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class ac extends aj {
    private static final String ID = a.ENCODE.toString();
    private static final String arp = b.ARG0.toString();
    private static final String arq = b.NO_PADDING.toString();
    private static final String arr = b.INPUT_FORMAT.toString();
    private static final String ars = b.OUTPUT_FORMAT.toString();

    public ac() {
        super(ID, arp);
    }

    public d.a B(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(arp);
        if (aVar == null || aVar == di.rb()) {
            return di.rb();
        }
        String j = di.j(aVar);
        aVar = (d.a) map.get(arr);
        String j2 = aVar == null ? "text" : di.j(aVar);
        aVar = (d.a) map.get(ars);
        String j3 = aVar == null ? "base16" : di.j(aVar);
        aVar = (d.a) map.get(arq);
        int i = (aVar == null || !di.n(aVar).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = j.co(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.T("Encode: unknown input format: " + j2);
                return di.rb();
            }
            if ("base16".equals(j3)) {
                d = j.d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.T("Encode: unknown output format: " + j3);
                return di.rb();
            }
            return di.u(d);
        } catch (IllegalArgumentException e) {
            bh.T("Encode: invalid input:");
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
