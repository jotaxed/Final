package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.fn.a;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fp implements a<bu> {
    public /* synthetic */ bv.a a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return c(fnVar, jSONObject);
    }

    public bu c(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new bu(jSONObject.getString("headline"), (Drawable) fnVar.a(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) fnVar.a(jSONObject, "secondary_image", false).get(), jSONObject.getString("call_to_action"), jSONObject.getString("attribution"));
    }
}
