package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dj extends dg {
    private static final String ID = a.UNIVERSAL_ANALYTICS.toString();
    private static final String aul = b.ACCOUNT.toString();
    private static final String aum = b.ANALYTICS_PASS_THROUGH.toString();
    private static final String aun = b.ENABLE_ECOMMERCE.toString();
    private static final String auo = b.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String aup = b.ECOMMERCE_MACRO_DATA.toString();
    private static final String auq = b.ANALYTICS_FIELDS.toString();
    private static final String aur = b.TRACK_TRANSACTION.toString();
    private static final String aus = b.TRANSACTION_DATALAYER_MAP.toString();
    private static final String aut = b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> auu = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
    private static final Pattern auv = Pattern.compile("dimension(\\d+)");
    private static final Pattern auw = Pattern.compile("metric(\\d+)");
    private static Map<String, String> aux;
    private static Map<String, String> auy;
    private final DataLayer aqn;
    private final df auA;
    private final Set<String> auz;

    public dj(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new df(context));
    }

    dj(Context context, DataLayer dataLayer, df dfVar) {
        super(ID, new String[0]);
        this.aqn = dataLayer;
        this.auA = dfVar;
        this.auz = new HashSet();
        this.auz.add("");
        this.auz.add("0");
        this.auz.add("false");
    }

    private Promotion L(Map<String, String> map) {
        Promotion promotion = new Promotion();
        String str = (String) map.get("id");
        if (str != null) {
            promotion.setId(String.valueOf(str));
        }
        str = (String) map.get("name");
        if (str != null) {
            promotion.setName(String.valueOf(str));
        }
        str = (String) map.get("creative");
        if (str != null) {
            promotion.setCreative(String.valueOf(str));
        }
        str = (String) map.get("position");
        if (str != null) {
            promotion.setPosition(String.valueOf(str));
        }
        return promotion;
    }

    private Product M(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null) {
            product.setName(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null) {
            product.setBrand(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null) {
            product.setCategory(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null) {
            product.setVariant(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            product.setCouponCode(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null) {
            product.setPosition(z(obj).intValue());
        }
        obj = map.get("price");
        if (obj != null) {
            product.setPrice(y(obj).doubleValue());
        }
        obj = map.get("quantity");
        if (obj != null) {
            product.setQuantity(z(obj).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = auv.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException e) {
                    bh.W("illegal number in custom dimension value: " + str);
                }
            } else {
                matcher = auw.matcher(str);
                if (matcher.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher.group(1)), z(map.get(str)).intValue());
                    } catch (NumberFormatException e2) {
                        bh.W("illegal number in custom metric value: " + str);
                    }
                }
            }
        }
        return product;
    }

    private Map<String, String> N(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(aus);
        if (aVar != null) {
            return c(aVar);
        }
        if (aux == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            aux = hashMap;
        }
        return aux;
    }

    private Map<String, String> O(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(aut);
        if (aVar != null) {
            return c(aVar);
        }
        if (auy == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            auy = hashMap;
        }
        return auy;
    }

    private void a(Tracker tracker, Map<String, d.a> map) {
        String de = de("transactionId");
        if (de == null) {
            bh.T("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = p((d.a) map.get(auq));
            p.put("&t", "transaction");
            for (Entry entry : N(map).entrySet()) {
                b(p, (String) entry.getValue(), de((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> df = df("transactionProducts");
            if (df != null) {
                for (Map map2 : df) {
                    if (map2.get("name") == null) {
                        bh.T("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = p((d.a) map.get(auq));
                    p2.put("&t", "item");
                    p2.put("&ti", de);
                    for (Entry entry2 : O(map).entrySet()) {
                        b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bh.b("Unable to send transaction", e);
        }
    }

    private void b(Tracker tracker, Map<String, d.a> map) {
        Object obj;
        Map map2;
        ScreenViewBuilder screenViewBuilder = new ScreenViewBuilder();
        Map p = p((d.a) map.get(auq));
        screenViewBuilder.setAll(p);
        if (f(map, auo)) {
            obj = this.aqn.get("ecommerce");
            map2 = obj instanceof Map ? (Map) obj : null;
        } else {
            obj = di.o((d.a) map.get(aup));
            map2 = obj instanceof Map ? (Map) obj : null;
        }
        if (map2 != null) {
            Map map3;
            List<Map> list;
            String str = (String) p.get("&cu");
            if (str == null) {
                str = (String) map2.get("currencyCode");
            }
            if (str != null) {
                screenViewBuilder.set("&cu", str);
            }
            obj = map2.get("impressions");
            if (obj instanceof List) {
                for (Map map4 : (List) obj) {
                    try {
                        screenViewBuilder.addImpression(M(map4), (String) map4.get("list"));
                    } catch (RuntimeException e) {
                        bh.T("Failed to extract a product from DataLayer. " + e.getMessage());
                    }
                }
            }
            List list2 = map2.containsKey("promoClick") ? (List) ((Map) map2.get("promoClick")).get("promotions") : map2.containsKey("promoView") ? (List) ((Map) map2.get("promoView")).get("promotions") : null;
            if (r0 != null) {
                for (Map map42 : r0) {
                    try {
                        screenViewBuilder.addPromotion(L(map42));
                    } catch (RuntimeException e2) {
                        bh.T("Failed to extract a promotion from DataLayer. " + e2.getMessage());
                    }
                }
                if (map2.containsKey("promoClick")) {
                    screenViewBuilder.set("&promoa", "click");
                    obj = null;
                    if (obj != null) {
                        for (String str2 : auu) {
                            if (map2.containsKey(str2)) {
                                map3 = (Map) map2.get(str2);
                                list = (List) map3.get("products");
                                if (list != null) {
                                    for (Map map22 : list) {
                                        try {
                                            screenViewBuilder.addProduct(M(map22));
                                        } catch (RuntimeException e3) {
                                            bh.T("Failed to extract a product from DataLayer. " + e3.getMessage());
                                        }
                                    }
                                }
                                try {
                                    screenViewBuilder.setProductAction(map3.containsKey("actionField") ? c(str2, (Map) map3.get("actionField")) : new ProductAction(str2));
                                } catch (RuntimeException e22) {
                                    bh.T("Failed to extract a product action from DataLayer. " + e22.getMessage());
                                }
                            }
                        }
                    }
                } else {
                    screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                }
            }
            int i = 1;
            if (obj != null) {
                for (String str22 : auu) {
                    if (map22.containsKey(str22)) {
                        map3 = (Map) map22.get(str22);
                        list = (List) map3.get("products");
                        if (list != null) {
                            while (r4.hasNext()) {
                                screenViewBuilder.addProduct(M(map22));
                            }
                        }
                        if (map3.containsKey("actionField")) {
                        }
                        screenViewBuilder.setProductAction(map3.containsKey("actionField") ? c(str22, (Map) map3.get("actionField")) : new ProductAction(str22));
                    }
                }
            }
        }
        tracker.send(screenViewBuilder.build());
    }

    private void b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private ProductAction c(String str, Map<String, Object> map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get("id");
        if (obj != null) {
            productAction.setTransactionId(String.valueOf(obj));
        }
        obj = map.get("affiliation");
        if (obj != null) {
            productAction.setTransactionAffiliation(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            productAction.setTransactionCouponCode(String.valueOf(obj));
        }
        obj = map.get("list");
        if (obj != null) {
            productAction.setProductActionList(String.valueOf(obj));
        }
        obj = map.get("option");
        if (obj != null) {
            productAction.setCheckoutOptions(String.valueOf(obj));
        }
        obj = map.get("revenue");
        if (obj != null) {
            productAction.setTransactionRevenue(y(obj).doubleValue());
        }
        obj = map.get("tax");
        if (obj != null) {
            productAction.setTransactionTax(y(obj).doubleValue());
        }
        obj = map.get("shipping");
        if (obj != null) {
            productAction.setTransactionShipping(y(obj).doubleValue());
        }
        obj = map.get("step");
        if (obj != null) {
            productAction.setCheckoutStep(z(obj).intValue());
        }
        return productAction;
    }

    private Map<String, String> c(d.a aVar) {
        Object o = di.o(aVar);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private String de(String str) {
        Object obj = this.aqn.get(str);
        return obj == null ? null : obj.toString();
    }

    private List<Map<String, String>> df(String str) {
        Object obj = this.aqn.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private boolean f(Map<String, d.a> map, String str) {
        d.a aVar = (d.a) map.get(str);
        return aVar == null ? false : di.n(aVar).booleanValue();
    }

    private Map<String, String> p(d.a aVar) {
        if (aVar == null) {
            return new HashMap();
        }
        Map<String, String> c = c(aVar);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.auz.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    private Double y(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Double: " + e.getMessage());
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            throw new RuntimeException("Cannot convert the object to Double: " + obj.toString());
        }
    }

    private Integer z(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Integer: " + e.getMessage());
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            throw new RuntimeException("Cannot convert the object to Integer: " + obj.toString());
        }
    }

    public void D(Map<String, d.a> map) {
        Tracker cW = this.auA.cW("_GTM_DEFAULT_TRACKER_");
        cW.enableAdvertisingIdCollection(f(map, "collect_adid"));
        if (f(map, aun)) {
            b(cW, map);
        } else if (f(map, aum)) {
            cW.send(p((d.a) map.get(auq)));
        } else if (f(map, aur)) {
            a(cW, map);
        } else {
            bh.W("Ignoring unknown tag.");
        }
    }
}
