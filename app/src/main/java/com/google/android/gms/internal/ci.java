package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@ey
public final class ci implements cd {
    private final ce qc;
    private final v qd;

    public ci(ce ceVar, v vVar) {
        this.qc = ceVar;
        this.qd = vVar;
    }

    private static boolean b(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int c(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return gi.dv();
            }
            if ("l".equalsIgnoreCase(str)) {
                return gi.du();
            }
        }
        return -1;
    }

    public void a(gu guVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            gr.W("Action missing from an open GMSG.");
        } else if (this.qd == null || this.qd.az()) {
            gv dD = guVar.dD();
            if ("expand".equalsIgnoreCase(str)) {
                if (guVar.dH()) {
                    gr.W("Cannot expand WebView that is already expanded.");
                } else {
                    dD.a(b(map), c(map));
                }
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                if (str != null) {
                    dD.a(b(map), c(map), str);
                } else {
                    dD.a(b(map), c(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.qc == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.qc.a(str, new ArrayList());
                    return;
                }
                this.qc.a(str, new ArrayList(Arrays.asList(str2.split(" "))));
            } else {
                dD.a(new do((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.qd.d((String) map.get("u"));
        }
    }
}
