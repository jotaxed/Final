package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.af.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ba extends jl<af> {
    private final ExecutorService asJ = Executors.newCachedThreadPool();
    private final ag<DataListener> ayg = new b();
    private final ag<MessageListener> ayh = new c();
    private final ag<NodeListener> ayi = new d();

    public ba(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
    }

    private FutureTask<Boolean> a(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask(new Callable<Boolean>(this) {
            final /* synthetic */ ba ayk;

            public /* synthetic */ Object call() throws Exception {
                return rr();
            }

            public java.lang.Boolean rr() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00bf in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r1 = 3;
                r0 = "WearableClient";
                r0 = android.util.Log.isLoggable(r0, r1);
                if (r0 == 0) goto L_0x0023;
            L_0x0009:
                r0 = "WearableClient";
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r2 = "processAssets: writing data to FD : ";
                r1 = r1.append(r2);
                r2 = r3;
                r1 = r1.append(r2);
                r1 = r1.toString();
                android.util.Log.d(r0, r1);
            L_0x0023:
                r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
                r0 = r3;
                r1.<init>(r0);
                r0 = r4;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r1.write(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r1.flush();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = 3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                if (r0 == 0) goto L_0x0055;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            L_0x003b:
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = r3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                android.util.Log.d(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            L_0x0055:
                r0 = 1;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
                r3 = 3;	 Catch:{ IOException -> 0x00f4 }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f4 }
                if (r2 == 0) goto L_0x007d;	 Catch:{ IOException -> 0x00f4 }
            L_0x0063:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4 }
                r3.<init>();	 Catch:{ IOException -> 0x00f4 }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
                r4 = r3;	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00f4 }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f4 }
            L_0x007d:
                r1.close();	 Catch:{ IOException -> 0x00f4 }
            L_0x0080:
                return r0;
            L_0x0081:
                r0 = move-exception;
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = r3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                android.util.Log.w(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = "WearableClient";
                r2 = 3;
                r0 = android.util.Log.isLoggable(r0, r2);
                if (r0 == 0) goto L_0x00bf;
            L_0x00a5:
                r0 = "WearableClient";
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = "processAssets: closing: ";
                r2 = r2.append(r3);
                r3 = r3;
                r2 = r2.append(r3);
                r2 = r2.toString();
                android.util.Log.d(r0, r2);
            L_0x00bf:
                r1.close();
            L_0x00c2:
                r0 = 0;
                r0 = java.lang.Boolean.valueOf(r0);
                goto L_0x0080;
            L_0x00c8:
                r0 = move-exception;
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
                r3 = 3;	 Catch:{ IOException -> 0x00f0 }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f0 }
                if (r2 == 0) goto L_0x00ec;	 Catch:{ IOException -> 0x00f0 }
            L_0x00d2:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f0 }
                r3.<init>();	 Catch:{ IOException -> 0x00f0 }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
                r4 = r3;	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00f0 }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f0 }
            L_0x00ec:
                r1.close();	 Catch:{ IOException -> 0x00f0 }
            L_0x00ef:
                throw r0;
            L_0x00f0:
                r1 = move-exception;
                goto L_0x00ef;
            L_0x00f2:
                r0 = move-exception;
                goto L_0x00c2;
            L_0x00f4:
                r1 = move-exception;
                goto L_0x0080;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ba.1.rr():java.lang.Boolean");
            }
        });
    }

    protected void a(int i, IBinder iBinder, Bundle bundle) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.ayg.ca(iBinder);
            this.ayh.ca(iBinder);
            this.ayi.ca(iBinder);
        }
        super.a(i, iBinder, bundle);
    }

    public void a(b<DataItemResult> bVar, Uri uri) throws RemoteException {
        ((af) hw()).a(new d(bVar), uri);
    }

    public void a(b<GetFdForAssetResult> bVar, Asset asset) throws RemoteException {
        ((af) hw()).a(new f(bVar), asset);
    }

    public void a(b<Status> bVar, DataListener dataListener) throws RemoteException {
        this.ayg.a(this, bVar, dataListener);
    }

    public void a(b<Status> bVar, DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.ayg.a(this, bVar, dataListener, intentFilterArr);
    }

    public void a(b<GetFdForAssetResult> bVar, DataItemAsset dataItemAsset) throws RemoteException {
        a((b) bVar, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void a(b<Status> bVar, MessageListener messageListener) throws RemoteException {
        this.ayh.a(this, bVar, messageListener);
    }

    public void a(b<Status> bVar, MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.ayh.a(this, bVar, messageListener, intentFilterArr);
    }

    public void a(b<Status> bVar, NodeListener nodeListener) throws RemoteException, RemoteException {
        this.ayi.a(this, bVar, nodeListener, null);
    }

    public void a(b<DataItemResult> bVar, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest k = PutDataRequest.k(putDataRequest.getUri());
        k.setData(putDataRequest.getData());
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() == null) {
                k.putAsset((String) value2.getKey(), (Asset) value2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    k.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable a = a(createPipe[1], asset2.getData());
                    arrayList.add(a);
                    this.asJ.submit(a);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        try {
            ((af) hw()).a(new i(bVar, arrayList), k);
        } catch (Throwable e2) {
            throw new IllegalStateException("Unable to putDataItem: " + putDataRequest, e2);
        }
    }

    public void a(b<SendMessageResult> bVar, String str, String str2, byte[] bArr) throws RemoteException {
        ((af) hw()).a(new j(bVar), str, str2, bArr);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        jtVar.e(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public void b(b<DataItemBuffer> bVar, Uri uri) throws RemoteException {
        ((af) hw()).b(new e(bVar), uri);
    }

    public void b(b<Status> bVar, NodeListener nodeListener) throws RemoteException {
        this.ayi.a(this, bVar, nodeListener);
    }

    protected String bK() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String bL() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public void c(b<DeleteDataItemsResult> bVar, Uri uri) throws RemoteException {
        ((af) hw()).c(new b(bVar), uri);
    }

    protected af cb(IBinder iBinder) {
        return a.bZ(iBinder);
    }

    public void disconnect() {
        this.ayg.b(this);
        this.ayh.b(this);
        this.ayi.b(this);
        super.disconnect();
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return cb(iBinder);
    }

    public void n(b<DataItemBuffer> bVar) throws RemoteException {
        ((af) hw()).b(new e(bVar));
    }

    public void o(b<GetLocalNodeResult> bVar) throws RemoteException {
        ((af) hw()).c(new g(bVar));
    }

    public void p(b<GetConnectedNodesResult> bVar) throws RemoteException {
        ((af) hw()).d(new c(bVar));
    }
}
