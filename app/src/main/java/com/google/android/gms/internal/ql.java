package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class ql {

    public static class a {
        public final qm ayo;
        public final List<Asset> ayp;

        public a(qm qmVar, List<Asset> list) {
            this.ayo = qmVar;
            this.ayp = list;
        }
    }

    private static int a(String str, com.google.android.gms.internal.qm.a.a[] aVarArr) {
        int i = 14;
        for (com.google.android.gms.internal.qm.a.a aVar : aVarArr) {
            if (i == 14) {
                if (aVar.type == 9 || aVar.type == 2 || aVar.type == 6) {
                    i = aVar.type;
                } else if (aVar.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + aVar.type + " for key " + str);
                }
            } else if (aVar.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + aVar.type);
            }
        }
        return i;
    }

    static int a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static a a(DataMap dataMap) {
        qm qmVar = new qm();
        List arrayList = new ArrayList();
        qmVar.ayq = a(dataMap, arrayList);
        return new a(qmVar, arrayList);
    }

    private static com.google.android.gms.internal.qm.a.a a(List<Asset> list, Object obj) {
        com.google.android.gms.internal.qm.a.a aVar = new com.google.android.gms.internal.qm.a.a();
        if (obj == null) {
            aVar.type = 14;
            return aVar;
        }
        aVar.ayu = new com.google.android.gms.internal.qm.a.a.a();
        if (obj instanceof String) {
            aVar.type = 2;
            aVar.ayu.ayw = (String) obj;
        } else if (obj instanceof Integer) {
            aVar.type = 6;
            aVar.ayu.ayA = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            aVar.type = 5;
            aVar.ayu.ayz = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            aVar.type = 3;
            aVar.ayu.ayx = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            aVar.type = 4;
            aVar.ayu.ayy = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.ayu.ayC = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            aVar.type = 7;
            aVar.ayu.ayB = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            aVar.type = 1;
            aVar.ayu.ayv = (byte[]) obj;
        } else if (obj instanceof String[]) {
            aVar.type = 11;
            aVar.ayu.ayF = (String[]) obj;
        } else if (obj instanceof long[]) {
            aVar.type = 12;
            aVar.ayu.ayG = (long[]) obj;
        } else if (obj instanceof float[]) {
            aVar.type = 15;
            aVar.ayu.ayH = (float[]) obj;
        } else if (obj instanceof Asset) {
            aVar.type = 13;
            aVar.ayu.ayI = (long) a((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            aVar.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            com.google.android.gms.internal.qm.a[] aVarArr = new com.google.android.gms.internal.qm.a[keySet.size()];
            r1 = 0;
            for (String str : keySet) {
                aVarArr[r1] = new com.google.android.gms.internal.qm.a();
                aVarArr[r1].name = str;
                aVarArr[r1].ays = a((List) list, dataMap.get(str));
                r1++;
            }
            aVar.ayu.ayD = aVarArr;
        } else if (obj instanceof ArrayList) {
            aVar.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.internal.qm.a.a[] aVarArr2 = new com.google.android.gms.internal.qm.a.a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                com.google.android.gms.internal.qm.a.a a = a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    aVarArr2[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            aVar.ayu.ayE = aVarArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return aVar;
    }

    public static DataMap a(a aVar) {
        DataMap dataMap = new DataMap();
        for (com.google.android.gms.internal.qm.a aVar2 : aVar.ayo.ayq) {
            a(aVar.ayp, dataMap, aVar2.name, aVar2.ays);
        }
        return dataMap;
    }

    private static ArrayList a(List<Asset> list, com.google.android.gms.internal.qm.a.a.a aVar, int i) {
        ArrayList arrayList = new ArrayList(aVar.ayE.length);
        for (com.google.android.gms.internal.qm.a.a aVar2 : aVar.ayE) {
            if (aVar2.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (com.google.android.gms.internal.qm.a aVar3 : aVar2.ayu.ayD) {
                    a(list, dataMap, aVar3.name, aVar3.ays);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(aVar2.ayu.ayw);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(aVar2.ayu.ayA));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void a(List<Asset> list, DataMap dataMap, String str, com.google.android.gms.internal.qm.a.a aVar) {
        int i = aVar.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        com.google.android.gms.internal.qm.a.a.a aVar2 = aVar.ayu;
        if (i == 1) {
            dataMap.putByteArray(str, aVar2.ayv);
        } else if (i == 11) {
            dataMap.putStringArray(str, aVar2.ayF);
        } else if (i == 12) {
            dataMap.putLongArray(str, aVar2.ayG);
        } else if (i == 15) {
            dataMap.putFloatArray(str, aVar2.ayH);
        } else if (i == 2) {
            dataMap.putString(str, aVar2.ayw);
        } else if (i == 3) {
            dataMap.putDouble(str, aVar2.ayx);
        } else if (i == 4) {
            dataMap.putFloat(str, aVar2.ayy);
        } else if (i == 5) {
            dataMap.putLong(str, aVar2.ayz);
        } else if (i == 6) {
            dataMap.putInt(str, aVar2.ayA);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) aVar2.ayB);
        } else if (i == 8) {
            dataMap.putBoolean(str, aVar2.ayC);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) aVar2.ayI));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (com.google.android.gms.internal.qm.a aVar3 : aVar2.ayD) {
                a(list, dataMap2, aVar3.name, aVar3.ays);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = a(str, aVar2.ayE);
            ArrayList a = a(list, aVar2, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, a);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static com.google.android.gms.internal.qm.a[] a(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        com.google.android.gms.internal.qm.a[] aVarArr = new com.google.android.gms.internal.qm.a[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            aVarArr[i] = new com.google.android.gms.internal.qm.a();
            aVarArr[i].name = str;
            aVarArr[i].ays = a((List) list, obj);
            i++;
        }
        return aVarArr;
    }
}
