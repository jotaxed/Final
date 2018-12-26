package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.b;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class i extends dg {
    private static final String ID = com.google.android.gms.internal.a.ARBITRARY_PIXEL.toString();
    private static final String URL = b.URL.toString();
    private static final String aqf = b.ADDITIONAL_PARAMS.toString();
    private static final String aqg = b.UNREPEATABLE.toString();
    static final String aqh = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> aqi = new HashSet();
    private final a aqj;
    private final Context mContext;

    public interface a {
        aq pf();
    }

    class AnonymousClass1 implements a {
        final /* synthetic */ Context nf;

        AnonymousClass1(Context context) {
            this.nf = context;
        }

        public aq pf() {
            return y.X(this.nf);
        }
    }

    public i(Context context) {
        this(context, new AnonymousClass1(context));
    }

    i(Context context, a aVar) {
        super(ID, URL);
        this.aqj = aVar;
        this.mContext = context;
    }

    private synchronized boolean cl(String str) {
        boolean z = true;
        synchronized (this) {
            if (!cn(str)) {
                if (cm(str)) {
                    aqi.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public void D(Map<String, com.google.android.gms.internal.d.a> map) {
        String j = map.get(aqg) != null ? di.j((com.google.android.gms.internal.d.a) map.get(aqg)) : null;
        if (j == null || !cl(j)) {
            Builder buildUpon = Uri.parse(di.j((com.google.android.gms.internal.d.a) map.get(URL))).buildUpon();
            com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) map.get(aqf);
            if (aVar != null) {
                Object o = di.o(aVar);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.T("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.T("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.aqj.pf().cB(uri);
            bh.V("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (i.class) {
                    aqi.add(j);
                    cz.a(this.mContext, aqh, j, "true");
                }
            }
        }
    }

    boolean cm(String str) {
        return this.mContext.getSharedPreferences(aqh, 0).contains(str);
    }

    boolean cn(String str) {
        return aqi.contains(str);
    }
}
