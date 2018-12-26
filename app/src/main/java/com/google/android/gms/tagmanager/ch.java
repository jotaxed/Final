package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends aj {
    private static final String ID = a.REGEX_GROUP.toString();
    private static final String asw = b.ARG0.toString();
    private static final String asx = b.ARG1.toString();
    private static final String asy = b.IGNORE_CASE.toString();
    private static final String asz = b.GROUP.toString();

    public ch() {
        super(ID, asw, asx);
    }

    public d.a B(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(asw);
        d.a aVar2 = (d.a) map.get(asx);
        if (aVar == null || aVar == di.rb() || aVar2 == null || aVar2 == di.rb()) {
            return di.rb();
        }
        int i = 64;
        if (di.n((d.a) map.get(asy)).booleanValue()) {
            i = 66;
        }
        d.a aVar3 = (d.a) map.get(asz);
        int intValue;
        if (aVar3 != null) {
            Long l = di.l(aVar3);
            if (l == di.qW()) {
                return di.rb();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return di.rb();
            }
        }
        intValue = 1;
        try {
            CharSequence j = di.j(aVar);
            Object obj = null;
            Matcher matcher = Pattern.compile(di.j(aVar2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? di.rb() : di.u(obj);
        } catch (PatternSyntaxException e) {
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
