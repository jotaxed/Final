package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ce {
    private static ce asm;
    private volatile String aqm;
    private volatile a asn;
    private volatile String aso;
    private volatile String asp;

    enum a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    ce() {
        clear();
    }

    private String cK(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String j(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static ce qa() {
        ce ceVar;
        synchronized (ce.class) {
            if (asm == null) {
                asm = new ce();
            }
            ceVar = asm;
        }
        return ceVar;
    }

    void clear() {
        this.asn = a.NONE;
        this.aso = null;
        this.aqm = null;
        this.asp = null;
    }

    String getContainerId() {
        return this.aqm;
    }

    synchronized boolean i(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    bh.V("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.asn = a.CONTAINER_DEBUG;
                    } else {
                        this.asn = a.CONTAINER;
                    }
                    this.asp = j(uri);
                    if (this.asn == a.CONTAINER || this.asn == a.CONTAINER_DEBUG) {
                        this.aso = "/r?" + this.asp;
                    }
                    this.aqm = cK(this.asp);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        bh.W("Invalid preview uri: " + decode);
                        z = false;
                    } else if (cK(uri.getQuery()).equals(this.aqm)) {
                        bh.V("Exit preview mode for container: " + this.aqm);
                        this.asn = a.NONE;
                        this.aso = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    a qb() {
        return this.asn;
    }

    String qc() {
        return this.aso;
    }
}
