package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class im extends jl<iq> {
    private static final Object HB = new Object();
    private static final Object HC = new Object();
    private static final is Hh = new is("CastClientImpl");
    private final Listener FD;
    private double Gp;
    private boolean Gq;
    private com.google.android.gms.common.api.BaseImplementation.b<Status> HA;
    private ApplicationMetadata Hi;
    private final CastDevice Hj;
    private final Map<String, MessageReceivedCallback> Hk = new HashMap();
    private final long Hl;
    private c Hm;
    private String Hn;
    private boolean Ho;
    private boolean Hp;
    private boolean Hq;
    private int Hr;
    private int Hs;
    private final AtomicLong Ht = new AtomicLong(0);
    private String Hu;
    private String Hv;
    private Bundle Hw;
    private final Map<Long, com.google.android.gms.common.api.BaseImplementation.b<Status>> Hx = new HashMap();
    private final b Hy;
    private com.google.android.gms.common.api.BaseImplementation.b<ApplicationConnectionResult> Hz;
    private final Handler mHandler;

    private static final class a implements ApplicationConnectionResult {
        private final Status Eb;
        private final ApplicationMetadata HD;
        private final String HE;
        private final boolean HF;
        private final String vZ;

        public a(Status status) {
            this(status, null, null, null, false);
        }

        public a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.Eb = status;
            this.HD = applicationMetadata;
            this.HE = str;
            this.vZ = str2;
            this.HF = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.HD;
        }

        public String getApplicationStatus() {
            return this.HE;
        }

        public String getSessionId() {
            return this.vZ;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public boolean getWasLaunched() {
            return this.HF;
        }
    }

    private class b implements OnConnectionFailedListener {
        final /* synthetic */ im HG;

        private b(im imVar) {
            this.HG = imVar;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.HG.ga();
        }
    }

    private class c extends com.google.android.gms.internal.ir.a {
        final /* synthetic */ im HG;
        private final AtomicBoolean HH;

        private c(im imVar) {
            this.HG = imVar;
            this.HH = new AtomicBoolean(false);
        }

        private boolean ah(int i) {
            synchronized (im.HC) {
                if (this.HG.HA != null) {
                    this.HG.HA.b(new Status(i));
                    this.HG.HA = null;
                    return true;
                }
                return false;
            }
        }

        private void c(long j, int i) {
            synchronized (this.HG.Hx) {
                com.google.android.gms.common.api.BaseImplementation.b bVar = (com.google.android.gms.common.api.BaseImplementation.b) this.HG.Hx.remove(Long.valueOf(j));
            }
            if (bVar != null) {
                bVar.b(new Status(i));
            }
        }

        public void a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            if (!this.HH.get()) {
                this.HG.Hi = applicationMetadata;
                this.HG.Hu = applicationMetadata.getApplicationId();
                this.HG.Hv = str2;
                synchronized (im.HB) {
                    if (this.HG.Hz != null) {
                        this.HG.Hz.b(new a(new Status(0), applicationMetadata, str, str2, z));
                        this.HG.Hz = null;
                    }
                }
            }
        }

        public void a(String str, double d, boolean z) {
            im.Hh.b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void a(String str, long j) {
            if (!this.HH.get()) {
                c(j, 0);
            }
        }

        public void a(String str, long j, int i) {
            if (!this.HH.get()) {
                c(j, i);
            }
        }

        public void ad(int i) {
            if (gg()) {
                im.Hh.b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    this.HG.aD(2);
                }
            }
        }

        public void ae(int i) {
            if (!this.HH.get()) {
                synchronized (im.HB) {
                    if (this.HG.Hz != null) {
                        this.HG.Hz.b(new a(new Status(i)));
                        this.HG.Hz = null;
                    }
                }
            }
        }

        public void af(int i) {
            if (!this.HH.get()) {
                ah(i);
            }
        }

        public void ag(int i) {
            if (!this.HH.get()) {
                ah(i);
            }
        }

        public void b(final ij ijVar) {
            if (!this.HH.get()) {
                im.Hh.b("onApplicationStatusChanged", new Object[0]);
                this.HG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ c HJ;

                    public void run() {
                        this.HJ.HG.a(ijVar);
                    }
                });
            }
        }

        public void b(final io ioVar) {
            if (!this.HH.get()) {
                im.Hh.b("onDeviceStatusChanged", new Object[0]);
                this.HG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ c HJ;

                    public void run() {
                        this.HJ.HG.a(ioVar);
                    }
                });
            }
        }

        public void b(String str, byte[] bArr) {
            if (!this.HH.get()) {
                im.Hh.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public boolean gg() {
            if (this.HH.getAndSet(true)) {
                return false;
            }
            this.HG.fW();
            return true;
        }

        public boolean gh() {
            return this.HH.get();
        }

        public void j(final String str, final String str2) {
            if (!this.HH.get()) {
                im.Hh.b("Receive (type=text, ns=%s) %s", str, str2);
                this.HG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ c HJ;

                    public void run() {
                        synchronized (this.HJ.HG.Hk) {
                            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.HJ.HG.Hk.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(this.HJ.HG.Hj, str, str2);
                            return;
                        }
                        im.Hh.b("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }

        public void onApplicationDisconnected(final int statusCode) {
            if (!this.HH.get()) {
                this.HG.Hu = null;
                this.HG.Hv = null;
                ah(statusCode);
                if (this.HG.FD != null) {
                    this.HG.mHandler.post(new Runnable(this) {
                        final /* synthetic */ c HJ;

                        public void run() {
                            if (this.HJ.HG.FD != null) {
                                this.HJ.HG.FD.onApplicationDisconnected(statusCode);
                            }
                        }
                    });
                }
            }
        }
    }

    public im(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.Hj = castDevice;
        this.FD = listener;
        this.Hl = j;
        this.mHandler = new Handler(looper);
        fW();
        this.Hy = new b();
        registerConnectionFailedListener(this.Hy);
    }

    private void a(ij ijVar) {
        boolean z;
        String fT = ijVar.fT();
        if (in.a(fT, this.Hn)) {
            z = false;
        } else {
            this.Hn = fT;
            z = true;
        }
        Hh.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Ho));
        if (this.FD != null && (z || this.Ho)) {
            this.FD.onApplicationStatusChanged();
        }
        this.Ho = false;
    }

    private void a(io ioVar) {
        boolean z;
        ApplicationMetadata applicationMetadata = ioVar.getApplicationMetadata();
        if (!in.a(applicationMetadata, this.Hi)) {
            this.Hi = applicationMetadata;
            this.FD.onApplicationMetadataChanged(this.Hi);
        }
        double fZ = ioVar.fZ();
        if (fZ == Double.NaN || fZ == this.Gp) {
            z = false;
        } else {
            this.Gp = fZ;
            z = true;
        }
        boolean gi = ioVar.gi();
        if (gi != this.Gq) {
            this.Gq = gi;
            z = true;
        }
        Hh.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.onVolumeChanged();
        }
        int gj = ioVar.gj();
        if (gj != this.Hr) {
            this.Hr = gj;
            z = true;
        } else {
            z = false;
        }
        Hh.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.X(this.Hr);
        }
        gj = ioVar.gk();
        if (gj != this.Hs) {
            this.Hs = gj;
            z = true;
        } else {
            z = false;
        }
        Hh.b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.Y(this.Hs);
        }
        this.Hp = false;
    }

    private void c(com.google.android.gms.common.api.BaseImplementation.b<ApplicationConnectionResult> bVar) {
        synchronized (HB) {
            if (this.Hz != null) {
                this.Hz.b(new a(new Status(2002)));
            }
            this.Hz = bVar;
        }
    }

    private void e(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
        synchronized (HC) {
            if (this.HA != null) {
                bVar.b(new Status(2001));
                return;
            }
            this.HA = bVar;
        }
    }

    private void fW() {
        this.Hq = false;
        this.Hr = -1;
        this.Hs = -1;
        this.Hi = null;
        this.Hn = null;
        this.Gp = 0.0d;
        this.Gq = false;
    }

    private void ga() {
        Hh.b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.Hk) {
            this.Hk.clear();
        }
    }

    private void gb() throws IllegalStateException {
        if (!this.Hq || this.Hm == null || this.Hm.gh()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    public void I(boolean z) throws IllegalStateException, RemoteException {
        ((iq) hw()).a(z, this.Gp, this.Gq);
    }

    protected iq L(IBinder iBinder) {
        return com.google.android.gms.internal.iq.a.M(iBinder);
    }

    public void a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((iq) hw()).a(d, this.Gp, this.Gq);
    }

    protected void a(int i, IBinder iBinder, Bundle bundle) {
        Hh.b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.Hq = true;
            this.Ho = true;
            this.Hp = true;
        } else {
            this.Hq = false;
        }
        if (i == 1001) {
            this.Hw = new Bundle();
            this.Hw.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.a(i, iBinder, bundle);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        Bundle bundle = new Bundle();
        Hh.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.Hu, this.Hv);
        this.Hj.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.Hl);
        if (this.Hu != null) {
            bundle.putString("last_application_id", this.Hu);
            if (this.Hv != null) {
                bundle.putString("last_session_id", this.Hv);
            }
        }
        this.Hm = new c();
        jtVar.a((js) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.Hm.asBinder(), bundle);
    }

    public void a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        in.aF(str);
        aE(str);
        if (messageReceivedCallback != null) {
            synchronized (this.Hk) {
                this.Hk.put(str, messageReceivedCallback);
            }
            ((iq) hw()).aI(str);
        }
    }

    public void a(String str, LaunchOptions launchOptions, com.google.android.gms.common.api.BaseImplementation.b<ApplicationConnectionResult> bVar) throws IllegalStateException, RemoteException {
        c((com.google.android.gms.common.api.BaseImplementation.b) bVar);
        ((iq) hw()).a(str, launchOptions);
    }

    public void a(String str, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) throws IllegalStateException, RemoteException {
        e((com.google.android.gms.common.api.BaseImplementation.b) bVar);
        ((iq) hw()).aH(str);
    }

    public void a(String str, String str2, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            in.aF(str);
            gb();
            long incrementAndGet = this.Ht.incrementAndGet();
            try {
                this.Hx.put(Long.valueOf(incrementAndGet), bVar);
                ((iq) hw()).a(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.Hx.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    public void a(String str, boolean z, com.google.android.gms.common.api.BaseImplementation.b<ApplicationConnectionResult> bVar) throws IllegalStateException, RemoteException {
        c((com.google.android.gms.common.api.BaseImplementation.b) bVar);
        ((iq) hw()).g(str, z);
    }

    public void aE(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.Hk) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.Hk.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((iq) hw()).aJ(str);
            } catch (Throwable e) {
                Hh.a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void b(String str, String str2, com.google.android.gms.common.api.BaseImplementation.b<ApplicationConnectionResult> bVar) throws IllegalStateException, RemoteException {
        c((com.google.android.gms.common.api.BaseImplementation.b) bVar);
        ((iq) hw()).k(str, str2);
    }

    protected String bK() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String bL() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public void d(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) throws IllegalStateException, RemoteException {
        e((com.google.android.gms.common.api.BaseImplementation.b) bVar);
        ((iq) hw()).gl();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = Hh;
        r1 = "disconnect(); ServiceListener=%s, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.Hm;
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.b(r1, r2);
        r0 = r6.Hm;
        r1 = 0;
        r6.Hm = r1;
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r0 = r0.gg();
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = Hh;
        r1 = "already disposed, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.b(r1, r2);
    L_0x0030:
        return;
    L_0x0031:
        r6.ga();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x004d }
        if (r0 != 0) goto L_0x0040;
    L_0x003a:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x004d }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r6.hw();	 Catch:{ RemoteException -> 0x004d }
        r0 = (com.google.android.gms.internal.iq) r0;	 Catch:{ RemoteException -> 0x004d }
        r0.disconnect();	 Catch:{ RemoteException -> 0x004d }
    L_0x0049:
        super.disconnect();
        goto L_0x0030;
    L_0x004d:
        r0 = move-exception;
        r1 = Hh;	 Catch:{ all -> 0x0063 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0063 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        r3[r4] = r5;	 Catch:{ all -> 0x0063 }
        r1.a(r0, r2, r3);	 Catch:{ all -> 0x0063 }
        super.disconnect();
        goto L_0x0030;
    L_0x0063:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.im.disconnect():void");
    }

    public Bundle fX() {
        if (this.Hw == null) {
            return super.fX();
        }
        Bundle bundle = this.Hw;
        this.Hw = null;
        return bundle;
    }

    public void fY() throws IllegalStateException, RemoteException {
        ((iq) hw()).fY();
    }

    public double fZ() throws IllegalStateException {
        gb();
        return this.Gp;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        gb();
        return this.Hi;
    }

    public String getApplicationStatus() throws IllegalStateException {
        gb();
        return this.Hn;
    }

    public boolean isMute() throws IllegalStateException {
        gb();
        return this.Gq;
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return L(iBinder);
    }
}
