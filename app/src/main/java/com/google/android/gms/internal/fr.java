package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class fr {
    private static final SimpleDateFormat uD = new SimpleDateFormat("yyyyMMdd");

    public static fj a(Context context, fh fhVar, String str) {
        try {
            fj fjVar;
            int i;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            String optString5 = jSONObject.optString("debug_dialog", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString6 = jSONObject.optString("orientation", null);
            int i2 = -1;
            if ("portrait".equals(optString6)) {
                i2 = gi.dv();
            } else if ("landscape".equals(optString6)) {
                i2 = gi.du();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    gr.W("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new fj(0);
                }
                fj a = fq.a(context, fhVar.lO.wS, optString2, null, null);
                optString = a.sg;
                optString4 = a.tU;
                j = a.ua;
                fjVar = a;
            } else if (TextUtils.isEmpty(optString)) {
                gr.W("Could not parse the mediation config: Missing required ad_base_url field");
                return new fj(0);
            } else {
                fjVar = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = fjVar == null ? null : fjVar.qw;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = fjVar == null ? null : fjVar.qx;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = fjVar == null ? null : fjVar.tY;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (fjVar != null) {
                if (fjVar.orientation != -1) {
                    i2 = fjVar.orientation;
                }
                if (fjVar.tV > 0) {
                    j2 = fjVar.tV;
                }
            }
            String optString7 = jSONObject.optString("active_view");
            String str2 = null;
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str2 = jSONObject.optString("ad_passback_url", null);
            }
            return new fj(optString, optString4, list, list2, j2, false, -1, list3, -1, i2, optString3, j, optString5, optBoolean, str2, optString7, false, false, fhVar.tT, false);
        } catch (JSONException e) {
            gr.W("Could not parse the mediation config: " + e.getMessage());
            return new fj(0);
        }
    }

    public static String a(fh fhVar, fv fvVar, Location location, String str, String str2, String str3) {
        try {
            Map hashMap = new HashMap();
            Iterable arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(str3);
            }
            if (arrayList.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", arrayList));
            }
            if (fhVar.tK != null) {
                hashMap.put("ad_pos", fhVar.tK);
            }
            a((HashMap) hashMap, fhVar.tL);
            hashMap.put("format", fhVar.lS.op);
            if (fhVar.lS.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (fhVar.lS.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (fhVar.lS.or != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (ay ayVar : fhVar.lS.or) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(ayVar.width == -1 ? (int) (((float) ayVar.widthPixels) / fvVar.vw) : ayVar.width);
                    stringBuilder.append("x");
                    stringBuilder.append(ayVar.height == -2 ? (int) (((float) ayVar.heightPixels) / fvVar.vw) : ayVar.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            if (fhVar.tR != 0) {
                hashMap.put("native_version", Integer.valueOf(fhVar.tR));
                hashMap.put("native_templates", fhVar.mc);
            }
            hashMap.put("slotname", fhVar.lL);
            hashMap.put("pn", fhVar.applicationInfo.packageName);
            if (fhVar.tM != null) {
                hashMap.put("vc", Integer.valueOf(fhVar.tM.versionCode));
            }
            hashMap.put("ms", fhVar.tN);
            hashMap.put("seq_num", fhVar.tO);
            hashMap.put("session_id", fhVar.tP);
            hashMap.put("js", fhVar.lO.wS);
            a((HashMap) hashMap, fvVar);
            if (fhVar.tL.versionCode >= 2 && fhVar.tL.ol != null) {
                a((HashMap) hashMap, fhVar.tL.ol);
            }
            if (fhVar.versionCode >= 2) {
                hashMap.put("quality_signals", fhVar.tQ);
            }
            if (fhVar.versionCode >= 4 && fhVar.tT) {
                hashMap.put("forceHttps", Boolean.valueOf(fhVar.tT));
            }
            if (fhVar.versionCode >= 3 && fhVar.tS != null) {
                hashMap.put("content_info", fhVar.tS);
            }
            if (gr.v(2)) {
                gr.V("Ad Request JSON: " + gi.t(hashMap).toString(2));
            }
            return gi.t(hashMap).toString();
        } catch (JSONException e) {
            gr.W("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    private static void a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void a(HashMap<String, Object> hashMap, av avVar) {
        String dr = ge.dr();
        if (dr != null) {
            hashMap.put("abf", dr);
        }
        if (avVar.od != -1) {
            hashMap.put("cust_age", uD.format(new Date(avVar.od)));
        }
        if (avVar.extras != null) {
            hashMap.put("extras", avVar.extras);
        }
        if (avVar.oe != -1) {
            hashMap.put("cust_gender", Integer.valueOf(avVar.oe));
        }
        if (avVar.of != null) {
            hashMap.put("kw", avVar.of);
        }
        if (avVar.oh != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(avVar.oh));
        }
        if (avVar.og) {
            hashMap.put("adtest", "on");
        }
        if (avVar.versionCode >= 2) {
            if (avVar.oi) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(avVar.oj)) {
                hashMap.put("ppid", avVar.oj);
            }
            if (avVar.ok != null) {
                a((HashMap) hashMap, avVar.ok);
            }
        }
        if (avVar.versionCode >= 3 && avVar.om != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, avVar.om);
        }
    }

    private static void a(HashMap<String, Object> hashMap, bj bjVar) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(bjVar.oQ) != 0) {
            hashMap.put("acolor", u(bjVar.oQ));
        }
        if (Color.alpha(bjVar.backgroundColor) != 0) {
            hashMap.put("bgcolor", u(bjVar.backgroundColor));
        }
        if (!(Color.alpha(bjVar.oR) == 0 || Color.alpha(bjVar.oS) == 0)) {
            hashMap.put("gradientto", u(bjVar.oR));
            hashMap.put("gradientfrom", u(bjVar.oS));
        }
        if (Color.alpha(bjVar.oT) != 0) {
            hashMap.put("bcolor", u(bjVar.oT));
        }
        hashMap.put("bthick", Integer.toString(bjVar.oU));
        switch (bjVar.oV) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (bjVar.oW) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (bjVar.oX != null) {
            hashMap.put("channel", bjVar.oX);
        }
        if (Color.alpha(bjVar.oY) != 0) {
            hashMap.put("dcolor", u(bjVar.oY));
        }
        if (bjVar.oZ != null) {
            hashMap.put("font", bjVar.oZ);
        }
        if (Color.alpha(bjVar.pa) != 0) {
            hashMap.put("hcolor", u(bjVar.pa));
        }
        hashMap.put("headersize", Integer.toString(bjVar.pb));
        if (bjVar.pc != null) {
            hashMap.put("q", bjVar.pc);
        }
    }

    private static void a(HashMap<String, Object> hashMap, fv fvVar) {
        hashMap.put("am", Integer.valueOf(fvVar.vg));
        hashMap.put("cog", u(fvVar.vh));
        hashMap.put("coh", u(fvVar.vi));
        if (!TextUtils.isEmpty(fvVar.vj)) {
            hashMap.put("carrier", fvVar.vj);
        }
        hashMap.put("gl", fvVar.vk);
        if (fvVar.vl) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", u(fvVar.vm));
        hashMap.put("sp", u(fvVar.vn));
        hashMap.put("hl", fvVar.vo);
        if (!TextUtils.isEmpty(fvVar.vp)) {
            hashMap.put("mv", fvVar.vp);
        }
        hashMap.put("muv", Integer.valueOf(fvVar.vq));
        if (fvVar.vr != -2) {
            hashMap.put("cnt", Integer.valueOf(fvVar.vr));
        }
        hashMap.put("gnt", Integer.valueOf(fvVar.vs));
        hashMap.put("pt", Integer.valueOf(fvVar.vt));
        hashMap.put("rm", Integer.valueOf(fvVar.vu));
        hashMap.put("riv", Integer.valueOf(fvVar.vv));
        hashMap.put("u_sd", Float.valueOf(fvVar.vw));
        hashMap.put("sh", Integer.valueOf(fvVar.vy));
        hashMap.put("sw", Integer.valueOf(fvVar.vx));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", fvVar.vC);
        bundle.putBoolean("active_network_metered", fvVar.vB);
        hashMap.put("connectivity", bundle);
        bundle = new Bundle();
        bundle.putBoolean("is_charging", fvVar.vA);
        bundle.putDouble("battery_level", fvVar.vz);
        hashMap.put("battery", bundle);
    }

    private static Integer u(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String u(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
