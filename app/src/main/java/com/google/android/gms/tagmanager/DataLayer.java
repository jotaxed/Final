package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] aqQ = "gtm.lifetime".toString().split("\\.");
    private static final Pattern aqR = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<b, Integer> aqS;
    private final Map<String, Object> aqT;
    private final ReentrantLock aqU;
    private final LinkedList<Map<String, Object>> aqV;
    private final c aqW;
    private final CountDownLatch aqX;

    interface c {

        public interface a {
            void h(List<a> list);
        }

        void a(a aVar);

        void a(List<a> list, long j);

        void cz(String str);
    }

    static final class a {
        public final String KP;
        public final Object wF;

        a(String str, Object obj) {
            this.KP = str;
            this.wF = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            return this.KP.equals(aVar.KP) && this.wF.equals(aVar.wF);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.KP.hashCode()), Integer.valueOf(this.wF.hashCode())});
        }

        public String toString() {
            return "Key: " + this.KP + " value: " + this.wF.toString();
        }
    }

    interface b {
        void C(Map<String, Object> map);
    }

    DataLayer() {
        this(new c() {
            public void a(a aVar) {
                aVar.h(new ArrayList());
            }

            public void a(List<a> list, long j) {
            }

            public void cz(String str) {
            }
        });
    }

    DataLayer(c persistentStore) {
        this.aqW = persistentStore;
        this.aqS = new ConcurrentHashMap();
        this.aqT = new HashMap();
        this.aqU = new ReentrantLock();
        this.aqV = new LinkedList();
        this.aqX = new CountDownLatch(1);
        pv();
    }

    private void E(Map<String, Object> map) {
        this.aqU.lock();
        try {
            this.aqV.offer(map);
            if (this.aqU.getHoldCount() == 1) {
                pw();
            }
            F(map);
        } finally {
            this.aqU.unlock();
        }
    }

    private void F(Map<String, Object> map) {
        Long G = G(map);
        if (G != null) {
            List I = I(map);
            I.remove("gtm.lifetime");
            this.aqW.a(I, G.longValue());
        }
    }

    private Long G(Map<String, Object> map) {
        Object H = H(map);
        return H == null ? null : cy(H.toString());
    }

    private Object H(Map<String, Object> map) {
        String[] strArr = aqQ;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<a> I(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        a(map, "", arrayList);
        return arrayList;
    }

    private void J(Map<String, Object> map) {
        synchronized (this.aqT) {
            for (String str : map.keySet()) {
                a(c(str, map.get(str)), this.aqT);
            }
        }
        K(map);
    }

    private void K(Map<String, Object> map) {
        for (b C : this.aqS.keySet()) {
            C.C(map);
        }
    }

    private void a(Map<String, Object> map, String str, Collection<a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new a(str2, entry.getValue()));
            }
        }
    }

    static Long cy(String str) {
        Matcher matcher = aqR.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.W("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.U("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.W("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.U("unknown _lifetime: " + str);
        return null;
    }

    public static List<Object> listOf(Object... objects) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objects.length) {
            if (objects[i] instanceof String) {
                hashMap.put((String) objects[i], objects[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i]);
            }
        }
        return hashMap;
    }

    private void pv() {
        this.aqW.a(new a(this) {
            final /* synthetic */ DataLayer aqY;

            {
                this.aqY = r1;
            }

            public void h(List<a> list) {
                for (a aVar : list) {
                    this.aqY.E(this.aqY.c(aVar.KP, aVar.wF));
                }
                this.aqY.aqX.countDown();
            }
        });
    }

    private void pw() {
        int i = 0;
        while (true) {
            Map map = (Map) this.aqV.poll();
            if (map != null) {
                J(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    this.aqV.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    void a(b bVar) {
        this.aqS.put(bVar, Integer.valueOf(0));
    }

    void a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                b((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void b(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                b((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                a((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    Map<String, Object> c(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    void cx(String str) {
        push(str, null);
        this.aqW.cz(str);
    }

    public Object get(String key) {
        synchronized (this.aqT) {
            Map map = this.aqT;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(c(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.aqX.await();
        } catch (InterruptedException e) {
            bh.W("DataLayer.push: unexpected InterruptedException");
        }
        E(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        Map hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.aqT) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.aqT.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
