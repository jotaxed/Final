package com.google.android.gms.internal;

import org.json.JSONObject;

@ey
public class bv {
    private u pM;
    private ah pN;
    private JSONObject pO;

    public interface a {
        void a(bv bvVar);
    }

    public bv(u uVar, ah ahVar, JSONObject jSONObject) {
        this.pM = uVar;
        this.pN = ahVar;
        this.pO = jSONObject;
    }

    public void aw() {
        this.pM.an();
    }

    public void b(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", i);
            jSONObject.put("template", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.pO);
            jSONObject2.put("click", jSONObject);
            this.pN.a("google.afma.nativeAds.handleClick", jSONObject2);
        } catch (Throwable e) {
            gr.b("Unable to create click JSON.", e);
        }
    }
}
