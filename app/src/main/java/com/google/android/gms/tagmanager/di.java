package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di {
    private static final Object auc = null;
    private static Long aud = new Long(0);
    private static Double aue = new Double(0.0d);
    private static dh auf = dh.z(0);
    private static String aug = new String("");
    private static Boolean auh = new Boolean(false);
    private static List<Object> aui = new ArrayList(0);
    private static Map<Object, Object> auj = new HashMap();
    private static a auk = u(aug);

    public static a cZ(String str) {
        a aVar = new a();
        aVar.type = 5;
        aVar.gA = str;
        return aVar;
    }

    private static dh da(String str) {
        try {
            return dh.cY(str);
        } catch (NumberFormatException e) {
            bh.T("Failed to convert '" + str + "' to a number.");
            return auf;
        }
    }

    private static Long db(String str) {
        dh da = da(str);
        return da == auf ? aud : Long.valueOf(da.longValue());
    }

    private static Double dc(String str) {
        dh da = da(str);
        return da == auf ? aue : Double.valueOf(da.doubleValue());
    }

    private static Boolean dd(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : auh;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.T("getDouble received non-Number");
        return 0.0d;
    }

    public static String j(a aVar) {
        return p(o(aVar));
    }

    public static dh k(a aVar) {
        return q(o(aVar));
    }

    public static Long l(a aVar) {
        return r(o(aVar));
    }

    public static Double m(a aVar) {
        return s(o(aVar));
    }

    public static Boolean n(a aVar) {
        return t(o(aVar));
    }

    public static Object o(a aVar) {
        int i = 0;
        if (aVar == null) {
            return auc;
        }
        a[] aVarArr;
        int length;
        switch (aVar.type) {
            case 1:
                return aVar.gv;
            case 2:
                ArrayList arrayList = new ArrayList(aVar.gw.length);
                aVarArr = aVar.gw;
                length = aVarArr.length;
                while (i < length) {
                    Object o = o(aVarArr[i]);
                    if (o == auc) {
                        return auc;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case 3:
                if (aVar.gx.length != aVar.gy.length) {
                    bh.T("Converting an invalid value to object: " + aVar.toString());
                    return auc;
                }
                Map hashMap = new HashMap(aVar.gy.length);
                while (i < aVar.gx.length) {
                    Object o2 = o(aVar.gx[i]);
                    Object o3 = o(aVar.gy[i]);
                    if (o2 == auc || o3 == auc) {
                        return auc;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case 4:
                bh.T("Trying to convert a macro reference to object");
                return auc;
            case 5:
                bh.T("Trying to convert a function id to object");
                return auc;
            case 6:
                return Long.valueOf(aVar.gB);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                aVarArr = aVar.gD;
                length = aVarArr.length;
                while (i < length) {
                    String j = j(aVarArr[i]);
                    if (j == aug) {
                        return auc;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(aVar.gC);
            default:
                bh.T("Failed to convert a value of type: " + aVar.type);
                return auc;
        }
    }

    public static String p(Object obj) {
        return obj == null ? aug : obj.toString();
    }

    public static dh q(Object obj) {
        return obj instanceof dh ? (dh) obj : w(obj) ? dh.z(x(obj)) : v(obj) ? dh.a(Double.valueOf(getDouble(obj))) : da(p(obj));
    }

    public static Object qV() {
        return auc;
    }

    public static Long qW() {
        return aud;
    }

    public static Double qX() {
        return aue;
    }

    public static Boolean qY() {
        return auh;
    }

    public static dh qZ() {
        return auf;
    }

    public static Long r(Object obj) {
        return w(obj) ? Long.valueOf(x(obj)) : db(p(obj));
    }

    public static String ra() {
        return aug;
    }

    public static a rb() {
        return auk;
    }

    public static Double s(Object obj) {
        return v(obj) ? Double.valueOf(getDouble(obj)) : dc(p(obj));
    }

    public static Boolean t(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : dd(p(obj));
    }

    public static a u(Object obj) {
        boolean z = false;
        a aVar = new a();
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof String) {
            aVar.type = 1;
            aVar.gv = (String) obj;
        } else if (obj instanceof List) {
            aVar.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object u : list) {
                a u2 = u(u);
                if (u2 == auk) {
                    return auk;
                }
                r0 = r1 || u2.gF;
                r5.add(u2);
                r1 = r0;
            }
            aVar.gw = (a[]) r5.toArray(new a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            aVar.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                a u3 = u(entry.getKey());
                a u4 = u(entry.getValue());
                if (u3 == auk || u4 == auk) {
                    return auk;
                }
                r0 = r1 || u3.gF || u4.gF;
                r5.add(u3);
                arrayList.add(u4);
                r1 = r0;
            }
            aVar.gx = (a[]) r5.toArray(new a[0]);
            aVar.gy = (a[]) arrayList.toArray(new a[0]);
            z = r1;
        } else if (v(obj)) {
            aVar.type = 1;
            aVar.gv = obj.toString();
        } else if (w(obj)) {
            aVar.type = 6;
            aVar.gB = x(obj);
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.gC = ((Boolean) obj).booleanValue();
        } else {
            bh.T("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return auk;
        }
        aVar.gF = z;
        return aVar;
    }

    private static boolean v(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dh) && ((dh) obj).qQ());
    }

    private static boolean w(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dh) && ((dh) obj).qR());
    }

    private static long x(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.T("getInt64 received non-Number");
        return 0;
    }
}
