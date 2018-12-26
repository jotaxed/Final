package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fn implements Callable<fy> {
    private final Context mContext;
    private final Object mH = new Object();
    private final u pM;
    private final com.google.android.gms.internal.fy.a tB;
    private int tq;
    private final gn ul;
    private final ai um;
    private boolean un;
    private List<String> uo;

    public interface a<T extends com.google.android.gms.internal.bv.a> {
        T a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    public fn(Context context, u uVar, ai aiVar, gn gnVar, com.google.android.gms.internal.fy.a aVar) {
        this.mContext = context;
        this.pM = uVar;
        this.ul = gnVar;
        this.um = aiVar;
        this.tB = aVar;
        this.un = false;
        this.tq = -2;
        this.uo = null;
    }

    private com.google.android.gms.internal.bv.a a(ah ahVar, a aVar, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (cO()) {
            return null;
        }
        String[] b = b(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.uo = b == null ? null : Arrays.asList(b);
        com.google.android.gms.internal.bv.a a = aVar.a(this, jSONObject);
        if (a == null) {
            gr.T("Failed to retrieve ad assets.");
            return null;
        }
        a.a(new bv(this.pM, ahVar, jSONObject));
        return a;
    }

    private fy a(com.google.android.gms.internal.bv.a aVar) {
        int i;
        synchronized (this.mH) {
            i = this.tq;
            if (aVar == null && this.tq == -2) {
                i = 0;
            }
        }
        return new fy(this.tB.vJ.tL, null, this.tB.vK.qw, i, this.tB.vK.qx, this.uo, this.tB.vK.orientation, this.tB.vK.qA, this.tB.vJ.tO, false, null, null, null, null, null, 0, this.tB.lS, this.tB.vK.tV, this.tB.vG, this.tB.vH, this.tB.vK.ub, this.tB.vD, i != -2 ? null : aVar);
    }

    private String[] b(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private JSONObject c(final ah ahVar) throws TimeoutException, JSONException {
        if (cO()) {
            return null;
        }
        final gj gjVar = new gj();
        ahVar.a("/nativeAdPreProcess", new cd(this) {
            final /* synthetic */ fn ur;

            public void a(gu guVar, Map<String, String> map) {
                ahVar.g("/nativeAdPreProcess");
                try {
                    String str = (String) map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        gjVar.a(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (Throwable e) {
                    gr.b("Malformed native JSON response.", e);
                }
                this.ur.t(0);
                jx.a(this.ur.cO(), "Unable to set the ad state error!");
                gjVar.a(null);
            }
        });
        ahVar.a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.tB.vK.tU));
        return (JSONObject) gjVar.get();
    }

    private ah cN() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (cO()) {
            return null;
        }
        ah ahVar = (ah) this.um.a(this.mContext, this.tB.vJ.lO, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
        ahVar.a(this.pM, this.pM, this.pM, this.pM, false, this.pM);
        return ahVar;
    }

    public Future<Drawable> a(JSONObject jSONObject, String str, final boolean z) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        Object string = z ? jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject2.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!TextUtils.isEmpty(string)) {
            return this.ul.a(string, new com.google.android.gms.internal.gn.a<Drawable>(this) {
                final /* synthetic */ fn ur;

                public Drawable a(InputStream inputStream) {
                    byte[] d;
                    try {
                        d = lh.d(inputStream);
                    } catch (IOException e) {
                        d = null;
                    }
                    if (d == null) {
                        this.ur.a(2, z);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length);
                    if (decodeByteArray != null) {
                        return new BitmapDrawable(Resources.getSystem(), decodeByteArray);
                    }
                    this.ur.a(2, z);
                    return null;
                }

                public /* synthetic */ Object b(InputStream inputStream) {
                    return a(inputStream);
                }

                public Drawable cP() {
                    this.ur.a(2, z);
                    return null;
                }

                public /* synthetic */ Object cQ() {
                    return cP();
                }
            });
        }
        a(0, z);
        return new gk(null);
    }

    public void a(int i, boolean z) {
        if (z) {
            t(i);
        }
    }

    protected a b(JSONObject jSONObject) throws JSONException {
        if (cO()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        if ("2".equals(string)) {
            return new fo();
        }
        if ("1".equals(string)) {
            return new fp();
        }
        t(0);
        return null;
    }

    public fy cM() {
        try {
            ah cN = cN();
            JSONObject c = c(cN);
            return a(a(cN, b(c), c));
        } catch (CancellationException e) {
            if (!this.un) {
                t(0);
            }
            return a(null);
        } catch (ExecutionException e2) {
            if (this.un) {
                t(0);
            }
            return a(null);
        } catch (InterruptedException e3) {
            if (this.un) {
                t(0);
            }
            return a(null);
        } catch (Throwable e4) {
            gr.d("Malformed native JSON response.", e4);
            if (this.un) {
                t(0);
            }
            return a(null);
        } catch (Throwable e42) {
            gr.d("Timeout when loading native ad.", e42);
            if (this.un) {
                t(0);
            }
            return a(null);
        }
    }

    public boolean cO() {
        boolean z;
        synchronized (this.mH) {
            z = this.un;
        }
        return z;
    }

    public /* synthetic */ Object call() throws Exception {
        return cM();
    }

    public void t(int i) {
        synchronized (this.mH) {
            this.un = true;
            this.tq = i;
        }
    }
}
