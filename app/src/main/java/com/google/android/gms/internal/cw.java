package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cw {
    public static List<String> a(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void a(Context context, String str, fy fyVar, String str2, boolean z, List<String> list) {
        String str3 = z ? "1" : "0";
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", fyVar.vE.qz).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", ga.vY).replaceAll("@gw_seqnum@", fyVar.tO);
            if (fyVar.qP != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", fyVar.qP.qo).replaceAll("@gw_allocid@", fyVar.qP.qq);
            }
            new gp(context, str, replaceAll2).start();
        }
    }
}
