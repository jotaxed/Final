package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cr {
    public final long qA;
    public int qB;
    public int qC;
    public final List<cq> qu;
    public final long qv;
    public final List<String> qw;
    public final List<String> qx;
    public final List<String> qy;
    public final String qz;

    public cr(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (gr.v(2)) {
            gr.V("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            cq cqVar = new cq(jSONArray.getJSONObject(i2));
            arrayList.add(cqVar);
            if (i < 0 && a(cqVar)) {
                i = i2;
            }
        }
        this.qB = i;
        this.qC = jSONArray.length();
        this.qu = Collections.unmodifiableList(arrayList);
        this.qz = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.qv = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.qw = cw.a(optJSONObject, "click_urls");
            this.qx = cw.a(optJSONObject, "imp_urls");
            this.qy = cw.a(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.qA = optLong > 0 ? optLong * 1000 : -1;
            return;
        }
        this.qv = -1;
        this.qw = null;
        this.qx = null;
        this.qy = null;
        this.qA = -1;
    }

    private boolean a(cq cqVar) {
        for (String equals : cqVar.qp) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
