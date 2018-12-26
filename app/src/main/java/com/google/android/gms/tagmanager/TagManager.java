package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager atW;
    private final DataLayer aqn;
    private final r asD;
    private final a atT;
    private final cx atU;
    private final ConcurrentMap<n, Boolean> atV;
    private final Context mContext;

    interface a {
        o a(Context context, TagManager tagManager, Looper looper, String str, int i, r rVar);
    }

    TagManager(Context context, a containerHolderLoaderProvider, DataLayer dataLayer, cx serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.atU = serviceManager;
        this.atT = containerHolderLoaderProvider;
        this.atV = new ConcurrentHashMap();
        this.aqn = dataLayer;
        this.aqn.a(new b(this) {
            final /* synthetic */ TagManager atX;

            {
                this.atX = r1;
            }

            public void C(Map<String, Object> map) {
                Object obj = map.get(DataLayer.EVENT_KEY);
                if (obj != null) {
                    this.atX.cV(obj.toString());
                }
            }
        });
        this.aqn.a(new d(this.mContext));
        this.asD = new r();
        qP();
    }

    private void cV(String str) {
        for (n cr : this.atV.keySet()) {
            cr.cr(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (atW == null) {
                if (context == null) {
                    bh.T("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                atW = new TagManager(context, new a() {
                    public o a(Context context, TagManager tagManager, Looper looper, String str, int i, r rVar) {
                        return new o(context, tagManager, looper, str, i, rVar);
                    }
                }, new DataLayer(new v(context)), cy.qN());
            }
            tagManager = atW;
        }
        return tagManager;
    }

    private void qP() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2(this) {
                final /* synthetic */ TagManager atX;

                {
                    this.atX = r1;
                }

                public void onConfigurationChanged(Configuration configuration) {
                }

                public void onLowMemory() {
                }

                public void onTrimMemory(int i) {
                    if (i == 20) {
                        this.atX.dispatch();
                    }
                }
            });
        }
    }

    void a(n nVar) {
        this.atV.put(nVar, Boolean.valueOf(true));
    }

    boolean b(n nVar) {
        return this.atV.remove(nVar) != null;
    }

    public void dispatch() {
        this.atU.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.aqn;
    }

    synchronized boolean i(Uri uri) {
        boolean z;
        ce qa = ce.qa();
        if (qa.i(uri)) {
            String containerId = qa.getContainerId();
            switch (qa.qb()) {
                case NONE:
                    for (n nVar : this.atV.keySet()) {
                        if (nVar.getContainerId().equals(containerId)) {
                            nVar.ct(null);
                            nVar.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (n nVar2 : this.atV.keySet()) {
                        if (nVar2.getContainerId().equals(containerId)) {
                            nVar2.ct(qa.qc());
                            nVar2.refresh();
                        } else if (nVar2.pl() != null) {
                            nVar2.ct(null);
                            nVar2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.atT.a(this.mContext, this, null, containerId, defaultContainerResourceId, this.asD);
        a.po();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.atT.a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.asD);
        a.po();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.atT.a(this.mContext, this, null, containerId, defaultContainerResourceId, this.asD);
        a.pq();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.atT.a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.asD);
        a.pq();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.atT.a(this.mContext, this, null, containerId, defaultContainerResourceId, this.asD);
        a.pp();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.atT.a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.asD);
        a.pp();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
