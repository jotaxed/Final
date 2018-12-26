package com.google.android.gms.internal;

import java.util.Map;

@ey
public final class ca implements cd {
    private final cb pP;

    public ca(cb cbVar) {
        this.pP = cbVar;
    }

    public void a(gu guVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            gr.W("App event with no name parameter.");
        } else {
            this.pP.onAppEvent(str, (String) map.get("info"));
        }
    }
}
