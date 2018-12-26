package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.fl.a;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@ey
public final class fq extends a {
    private static final Object ut = new Object();
    private static fq uu;
    private final Context mContext;
    private final fw uv;
    private final cn uw;
    private final bm ux;

    fq(Context context, bm bmVar, cn cnVar, fw fwVar) {
        this.mContext = context;
        this.uv = fwVar;
        this.uw = cnVar;
        this.ux = bmVar;
    }

    private static gv.a I(final String str) {
        return new gv.a() {
            public void a(gu guVar) {
                String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", str});
                gr.V("About to execute: " + format);
                guVar.loadUrl(format);
            }
        };
    }

    private static fj a(Context context, bm bmVar, cn cnVar, fw fwVar, fh fhVar) {
        gr.S("Starting ad request from service.");
        cnVar.init();
        fv fvVar = new fv(context);
        if (fvVar.vr == -1) {
            gr.S("Device is offline.");
            return new fj(2);
        }
        String string;
        final fs fsVar = new fs(fhVar.applicationInfo.packageName);
        if (fhVar.tL.extras != null) {
            string = fhVar.tL.extras.getString("_ad");
            if (string != null) {
                return fr.a(context, fhVar, string);
            }
        }
        Location a = cnVar.a(250);
        String bu = bmVar.bu();
        string = fr.a(fhVar, fvVar, a, bmVar.bv(), bmVar.bw(), bmVar.bx());
        if (string == null) {
            return new fj(0);
        }
        final gv.a I = I(string);
        final Context context2 = context;
        final fh fhVar2 = fhVar;
        final fs fsVar2 = fsVar;
        final String str = bu;
        gq.wR.post(new Runnable() {
            public void run() {
                gu a = gu.a(context2, new ay(), false, false, null, fhVar2.lO);
                a.setWillNotDraw(true);
                fsVar2.b(a);
                gv dD = a.dD();
                dD.a("/invalidRequest", fsVar2.uG);
                dD.a("/loadAdURL", fsVar2.uH);
                dD.a("/log", cc.pX);
                dD.a(I);
                gr.S("Loading the JS library.");
                a.loadUrl(str);
            }
        });
        fj fjVar;
        try {
            fu fuVar = (fu) fsVar.cR().get(10, TimeUnit.SECONDS);
            if (fuVar == null) {
                fjVar = new fj(0);
                return fjVar;
            } else if (fuVar.getErrorCode() != -2) {
                fj fjVar2 = new fj(fuVar.getErrorCode());
                gq.wR.post(new Runnable() {
                    public void run() {
                        fsVar.cS();
                    }
                });
                return fjVar2;
            } else {
                String str2 = null;
                if (fuVar.cV()) {
                    str2 = fwVar.K(fhVar.tM.packageName);
                }
                fjVar = a(context, fhVar.lO.wS, fuVar.getUrl(), str2, fuVar);
                gq.wR.post(/* anonymous class already generated */);
                return fjVar;
            }
        } catch (Exception e) {
            fjVar = new fj(0);
            return fjVar;
        } finally {
            gq.wR.post(/* anonymous class already generated */);
        }
    }

    public static fj a(Context context, String str, String str2, String str3, fu fuVar) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            fj fjVar;
            ft ftVar = new ft();
            gr.S("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                gi.a(context, str, false, httpURLConnection);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                }
                if (!(fuVar == null || TextUtils.isEmpty(fuVar.cU()))) {
                    httpURLConnection.setDoOutput(true);
                    byte[] bytes = fuVar.cU().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < 200 || responseCode >= 300) {
                    a(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        gr.W("No location header to follow redirect.");
                        fjVar = new fj(0);
                        httpURLConnection.disconnect();
                        return fjVar;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        gr.W("Too many redirects.");
                        fjVar = new fj(0);
                        httpURLConnection.disconnect();
                        return fjVar;
                    }
                    ftVar.e(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String a = gi.a(new InputStreamReader(httpURLConnection.getInputStream()));
                    a(url3, headerFields, a, responseCode);
                    ftVar.a(url3, headerFields, a);
                    fjVar = ftVar.i(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return fjVar;
                }
            }
            gr.W("Received error HTTP response code: " + responseCode);
            fjVar = new fj(0);
            httpURLConnection.disconnect();
            return fjVar;
        } catch (IOException e) {
            gr.W("Error while connecting to ad server: " + e.getMessage());
            return new fj(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public static fq a(Context context, bm bmVar, cn cnVar, fw fwVar) {
        fq fqVar;
        synchronized (ut) {
            if (uu == null) {
                uu = new fq(context.getApplicationContext(), bmVar, cnVar, fwVar);
            }
            fqVar = uu;
        }
        return fqVar;
    }

    private static void a(String str, Map<String, List<String>> map, String str2, int i) {
        if (gr.v(2)) {
            gr.V("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    gr.V("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        gr.V("      " + str32);
                    }
                }
            }
            gr.V("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    gr.V(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                gr.V("    null");
            }
            gr.V("  Response Code:\n    " + i + "\n}");
        }
    }

    public fj b(fh fhVar) {
        return a(this.mContext, this.ux, this.uw, this.uv, fhVar);
    }
}
