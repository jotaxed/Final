package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class s extends aj {
    private static final String ID = com.google.android.gms.internal.a.FUNCTION_CALL.toString();
    private static final String aqO = b.FUNCTION_CALL_NAME.toString();
    private static final String aqf = b.ADDITIONAL_PARAMS.toString();
    private final a aqP;

    public interface a {
        Object b(String str, Map<String, Object> map);
    }

    public s(a aVar) {
        super(ID, aqO);
        this.aqP = aVar;
    }

    public com.google.android.gms.internal.d.a B(Map<String, com.google.android.gms.internal.d.a> map) {
        String j = di.j((com.google.android.gms.internal.d.a) map.get(aqO));
        Map hashMap = new HashMap();
        com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) map.get(aqf);
        if (aVar != null) {
            Object o = di.o(aVar);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.W("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return di.rb();
            }
        }
        try {
            return di.u(this.aqP.b(j, hashMap));
        } catch (Exception e) {
            bh.W("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return di.rb();
        }
    }

    public boolean pe() {
        return false;
    }
}
