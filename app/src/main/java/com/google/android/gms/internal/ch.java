package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@ey
public class ch implements cd {
    static final Map<String, Integer> qb = new HashMap();

    static {
        qb.put("resize", Integer.valueOf(1));
        qb.put("playVideo", Integer.valueOf(2));
        qb.put("storePicture", Integer.valueOf(3));
        qb.put("createCalendarEvent", Integer.valueOf(4));
    }

    public void a(gu guVar, Map<String, String> map) {
        switch (((Integer) qb.get((String) map.get("a"))).intValue()) {
            case 1:
                new di(guVar, map).execute();
                return;
            case 3:
                new dj(guVar, map).execute();
                return;
            case 4:
                new dh(guVar, map).execute();
                return;
            default:
                gr.U("Unknown MRAID command called.");
                return;
        }
    }
}
