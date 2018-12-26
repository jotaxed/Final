package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import com.google.android.gms.tagmanager.cr.c;
import com.google.android.gms.tagmanager.cr.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static c cI(String str) throws JSONException {
        a n = n(new JSONObject(str));
        d qo = c.qo();
        for (int i = 0; i < n.gx.length; i++) {
            qo.a(cr.a.qk().b(b.INSTANCE_NAME.toString(), n.gx[i]).b(b.FUNCTION.toString(), di.cZ(m.ph())).b(m.pi(), n.gy[i]).qn());
        }
        return qo.qr();
    }

    private static a n(Object obj) throws JSONException {
        return di.u(o(obj));
    }

    static Object o(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, o(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
