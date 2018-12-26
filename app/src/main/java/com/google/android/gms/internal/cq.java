package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cq {
    public final String qn;
    public final String qo;
    public final List<String> qp;
    public final String qq;
    public final String qr;
    public final List<String> qs;
    public final String qt;

    public cq(JSONObject jSONObject) throws JSONException {
        String str = null;
        this.qo = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.qp = Collections.unmodifiableList(arrayList);
        this.qq = jSONObject.optString("allocation_id", null);
        this.qs = cw.a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.qn = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.qt = optJSONObject2 != null ? optJSONObject2.toString() : null;
        if (optJSONObject2 != null) {
            str = optJSONObject2.optString("class_name");
        }
        this.qr = str;
    }
}
