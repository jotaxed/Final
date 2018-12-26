package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

class y implements aq {
    private static y arl;
    private static final Object xO = new Object();
    private cg aqC;
    private String arm;
    private String arn;
    private ar aro;

    private y(Context context) {
        this(as.Z(context), new cw());
    }

    y(ar arVar, cg cgVar) {
        this.aro = arVar;
        this.aqC = cgVar;
    }

    public static aq X(Context context) {
        aq aqVar;
        synchronized (xO) {
            if (arl == null) {
                arl = new y(context);
            }
            aqVar = arl;
        }
        return aqVar;
    }

    public boolean cB(String str) {
        if (this.aqC.fe()) {
            if (!(this.arm == null || this.arn == null)) {
                try {
                    str = this.arm + "?" + this.arn + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.V("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.d("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.aro.cE(str);
            return true;
        }
        bh.W("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
