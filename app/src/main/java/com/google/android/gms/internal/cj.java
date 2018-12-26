package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

@ey
public final class cj implements cd {
    private static int a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = gq.a(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                gr.W("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void a(gu guVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            gr.W("Action missing from video GMSG.");
            return;
        }
        dp dC = guVar.dC();
        if (dC == null) {
            gr.W("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = guVar.getContext().getResources().getDisplayMetrics();
            a = a(displayMetrics, map, "x", 0);
            int a2 = a(displayMetrics, map, "y", 0);
            int a3 = a(displayMetrics, map, "w", -1);
            int a4 = a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && dC.ce() == null) {
                dC.c(a, a2, a3, a4);
                return;
            } else {
                dC.b(a, a2, a3, a4);
                return;
            }
        }
        dt ce = dC.ce();
        if (ce == null) {
            dt.a(guVar, "no_video_view", null);
        } else if ("click".equalsIgnoreCase(str)) {
            displayMetrics = guVar.getContext().getResources().getDisplayMetrics();
            int a5 = a(displayMetrics, map, "x", 0);
            a = a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            ce.b(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                gr.W("Enabled parameter missing from controls video GMSG.");
            } else {
                ce.s(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                gr.W("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                ce.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                gr.W("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            ce.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            ce.cq();
        } else if ("pause".equalsIgnoreCase(str)) {
            ce.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            ce.play();
        } else if ("show".equalsIgnoreCase(str)) {
            ce.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            ce.C((String) map.get("src"));
        } else {
            gr.W("Unknown video action: " + str);
        }
    }
}
