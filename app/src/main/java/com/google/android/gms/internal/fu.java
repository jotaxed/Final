package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ey
class fu {
    private int tq;
    private final List<String> uX;
    private final List<String> uY;
    private final String uZ;
    private final String va;
    private final String vb;
    private final String vc;
    private final boolean vd;
    private final int ve;
    private String vf;

    public fu(int i, Map<String, String> map) {
        this.vf = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        this.va = (String) map.get("base_uri");
        this.vb = (String) map.get("post_parameters");
        this.vd = parseBoolean((String) map.get("drt_include"));
        this.uZ = (String) map.get("activation_overlay_url");
        this.uY = J((String) map.get("check_packages"));
        this.ve = parseInt((String) map.get("request_id"));
        this.vc = (String) map.get("type");
        this.uX = J((String) map.get("errors"));
        this.tq = i;
    }

    private List<String> J(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    private static boolean parseBoolean(String bool) {
        return bool != null && (bool.equals("1") || bool.equals("true"));
    }

    private int parseInt(String i) {
        return i == null ? 0 : Integer.parseInt(i);
    }

    public List<String> cT() {
        return this.uX;
    }

    public String cU() {
        return this.vb;
    }

    public boolean cV() {
        return this.vd;
    }

    public int getErrorCode() {
        return this.tq;
    }

    public String getType() {
        return this.vc;
    }

    public String getUrl() {
        return this.vf;
    }

    public void setUrl(String url) {
        this.vf = url;
    }
}
