package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dm {
    private static bz<a> a(bz<a> bzVar) {
        try {
            return new bz(di.u(dg(di.j((a) bzVar.getObject()))), bzVar.pX());
        } catch (Throwable e) {
            bh.b("Escape URI: unsupported encoding", e);
            return bzVar;
        }
    }

    private static bz<a> a(bz<a> bzVar, int i) {
        if (q((a) bzVar.getObject())) {
            switch (i) {
                case 12:
                    return a(bzVar);
                default:
                    bh.T("Unsupported Value Escaping: " + i);
                    return bzVar;
            }
        }
        bh.T("Escaping can only be applied to strings.");
        return bzVar;
    }

    static bz<a> a(bz<a> bzVar, int... iArr) {
        bz a;
        for (int a2 : iArr) {
            a = a(a, a2);
        }
        return a;
    }

    static String dg(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean q(a aVar) {
        return di.o(aVar) instanceof String;
    }
}
