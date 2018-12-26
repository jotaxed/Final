package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.tagmanager.bg.a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class co implements Runnable {
    private volatile String aqI;
    private final String aqm;
    private final bn asA;
    private final String asB;
    private bg<j> asC;
    private volatile r asD;
    private volatile String asE;
    private final Context mContext;

    co(Context context, String str, bn bnVar, r rVar) {
        this.mContext = context;
        this.asA = bnVar;
        this.aqm = str;
        this.asD = rVar;
        this.asB = "/r?id=" + str;
        this.aqI = this.asB;
        this.asE = null;
    }

    public co(Context context, String str, r rVar) {
        this(context, str, new bn(), rVar);
    }

    private boolean qd() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.V("...no network connectivity");
        return false;
    }

    private void qe() {
        if (qd()) {
            bh.V("Start loading resource from network ...");
            String qf = qf();
            bm pO = this.asA.pO();
            try {
                InputStream cF = pO.cF(qf);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cr.b(cF, byteArrayOutputStream);
                    j b = j.b(byteArrayOutputStream.toByteArray());
                    bh.V("Successfully loaded supplemented resource: " + b);
                    if (b.gs == null && b.gr.length == 0) {
                        bh.V("No change for container: " + this.aqm);
                    }
                    this.asC.l(b);
                    bh.V("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.d("Error when parsing downloaded resources from url: " + qf + " " + e.getMessage(), e);
                    this.asC.a(a.SERVER_ERROR);
                    pO.close();
                }
            } catch (FileNotFoundException e2) {
                bh.W("No data is retrieved from the given url: " + qf + ". Make sure container_id: " + this.aqm + " is correct.");
                this.asC.a(a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.d("Error when loading resources from url: " + qf + " " + e3.getMessage(), e3);
                this.asC.a(a.IO_ERROR);
            } finally {
                pO.close();
            }
        } else {
            this.asC.a(a.NOT_AVAILABLE);
        }
    }

    void a(bg<j> bgVar) {
        this.asC = bgVar;
    }

    void cL(String str) {
        bh.S("Setting previous container version: " + str);
        this.asE = str;
    }

    void cw(String str) {
        if (str == null) {
            this.aqI = this.asB;
            return;
        }
        bh.S("Setting CTFE URL path: " + str);
        this.aqI = str;
    }

    String qf() {
        String str = this.asD.pu() + this.aqI + "&v=a65833898";
        if (!(this.asE == null || this.asE.trim().equals(""))) {
            str = str + "&pv=" + this.asE;
        }
        return ce.qa().qb().equals(a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.asC == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.asC.ps();
        qe();
    }
}
