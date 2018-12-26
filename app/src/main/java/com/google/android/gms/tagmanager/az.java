package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID = com.google.android.gms.internal.a.JOINER.toString();
    private static final String arJ = b.ITEM_SEPARATOR.toString();
    private static final String arK = b.KEY_VALUE_SEPARATOR.toString();
    private static final String arL = b.ESCAPE.toString();
    private static final String arp = b.ARG0.toString();

    private enum a {
        NONE,
        URL,
        BACKSLASH
    }

    public az() {
        super(ID, arp);
    }

    private String a(String str, a aVar, Set<Character> set) {
        switch (aVar) {
            case URL:
                try {
                    return dm.dg(str);
                } catch (Throwable e) {
                    bh.b("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void a(StringBuilder stringBuilder, String str, a aVar, Set<Character> set) {
        stringBuilder.append(a(str, aVar, set));
    }

    private void a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public com.google.android.gms.internal.d.a B(Map<String, com.google.android.gms.internal.d.a> map) {
        com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) map.get(arp);
        if (aVar == null) {
            return di.rb();
        }
        a aVar2;
        com.google.android.gms.internal.d.a aVar3 = (com.google.android.gms.internal.d.a) map.get(arJ);
        String j = aVar3 != null ? di.j(aVar3) : "";
        aVar3 = (com.google.android.gms.internal.d.a) map.get(arK);
        String j2 = aVar3 != null ? di.j(aVar3) : "=";
        a aVar4 = a.NONE;
        aVar3 = (com.google.android.gms.internal.d.a) map.get(arL);
        Set set;
        if (aVar3 != null) {
            String j3 = di.j(aVar3);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                aVar2 = a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                aVar2 = a.BACKSLASH;
                set = new HashSet();
                a(set, j);
                a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.T("Joiner: unsupported escape type: " + j3);
                return di.rb();
            }
        }
        set = null;
        aVar2 = aVar4;
        StringBuilder stringBuilder = new StringBuilder();
        switch (aVar.type) {
            case 2:
                Object obj = 1;
                com.google.android.gms.internal.d.a[] aVarArr = aVar.gw;
                int length = aVarArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.d.a aVar5 = aVarArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    a(stringBuilder, di.j(aVar5), aVar2, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < aVar.gx.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = di.j(aVar.gx[i2]);
                    String j5 = di.j(aVar.gy[i2]);
                    a(stringBuilder, j4, aVar2, set);
                    stringBuilder.append(j2);
                    a(stringBuilder, j5, aVar2, set);
                }
                break;
            default:
                a(stringBuilder, di.j(aVar), aVar2, set);
                break;
        }
        return di.u(stringBuilder.toString());
    }

    public boolean pe() {
        return true;
    }
}
