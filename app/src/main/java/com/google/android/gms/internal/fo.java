package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.fn.a;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fo implements a<bt> {
    public /* synthetic */ bv.a a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return b(fnVar, jSONObject);
    }

    public bt b(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new bt(jSONObject.getString("headline"), (Drawable) fnVar.a(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) fnVar.a(jSONObject, "app_icon", true).get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"));
    }
}
