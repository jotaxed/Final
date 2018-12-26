package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class ho {
    private static final String[] Df = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> Dg = new HashMap(Df.length);

    static {
        int i = 0;
        while (i < Df.length) {
            Dg.put(Df[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String P(int i) {
        return (i < 0 || i >= Df.length) ? null : Df[i];
    }

    public static int as(String str) {
        Integer num = (Integer) Dg.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int fF() {
        return Df.length;
    }
}
