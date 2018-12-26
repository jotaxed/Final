package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.ll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object Lu = new Object();
    private static HashSet<Uri> Lv = new HashSet();
    private static ImageManager Lw;
    private static ImageManager Lx;
    private final jc LA;
    private final Map<a, ImageReceiver> LB;
    private final Map<Uri, ImageReceiver> LC;
    private final Map<Uri, Long> LD;
    private final ExecutorService Ly = Executors.newFixedThreadPool(4);
    private final b Lz;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<a> LE = new ArrayList();
        final /* synthetic */ ImageManager LF;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.LF = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void b(a aVar) {
            je.aU("ImageReceiver.addImageRequest() must be called in the main thread");
            this.LE.add(aVar);
        }

        public void c(a aVar) {
            je.aU("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.LE.remove(aVar);
        }

        public void hg() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.LF.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.LF.Ly.execute(new c(this.LF, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class a {
        static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class b extends kj<a, Bitmap> {
        public b(Context context) {
            super(I(context));
        }

        private static int I(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !ll.ig()) ? activityManager.getMemoryClass() : a.a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected int a(a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void a(boolean z, a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            a(x0, (a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return a((a) x0, (Bitmap) x1);
        }
    }

    private final class c implements Runnable {
        final /* synthetic */ ImageManager LF;
        private final ParcelFileDescriptor LG;
        private final Uri mUri;

        public c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.LF = imageManager;
            this.mUri = uri;
            this.LG = parcelFileDescriptor;
        }

        public void run() {
            je.aV("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.LG != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.LG.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.LG.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.LF.mHandler.post(new f(this.LF, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class d implements Runnable {
        final /* synthetic */ ImageManager LF;
        private final a LH;

        public d(ImageManager imageManager, a aVar) {
            this.LF = imageManager;
            this.LH = aVar;
        }

        public void run() {
            je.aU("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.LF.LB.get(this.LH);
            if (imageReceiver != null) {
                this.LF.LB.remove(this.LH);
                imageReceiver.c(this.LH);
            }
            a aVar = this.LH.LJ;
            if (aVar.uri == null) {
                this.LH.a(this.LF.mContext, this.LF.LA, true);
                return;
            }
            Bitmap a = this.LF.a(aVar);
            if (a != null) {
                this.LH.a(this.LF.mContext, a, true);
                return;
            }
            Long l = (Long) this.LF.LD.get(aVar.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.LH.a(this.LF.mContext, this.LF.LA, true);
                    return;
                }
                this.LF.LD.remove(aVar.uri);
            }
            this.LH.a(this.LF.mContext, this.LF.LA);
            imageReceiver = (ImageReceiver) this.LF.LC.get(aVar.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.LF, aVar.uri);
                this.LF.LC.put(aVar.uri, imageReceiver);
            }
            imageReceiver.b(this.LH);
            if (!(this.LH instanceof com.google.android.gms.common.images.a.c)) {
                this.LF.LB.put(this.LH, imageReceiver);
            }
            synchronized (ImageManager.Lu) {
                if (!ImageManager.Lv.contains(aVar.uri)) {
                    ImageManager.Lv.add(aVar.uri);
                    imageReceiver.hg();
                }
            }
        }
    }

    private static final class e implements ComponentCallbacks2 {
        private final b Lz;

        public e(b bVar) {
            this.Lz = bVar;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Lz.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Lz.evictAll();
            } else if (level >= 20) {
                this.Lz.trimToSize(this.Lz.size() / 2);
            }
        }
    }

    private final class f implements Runnable {
        final /* synthetic */ ImageManager LF;
        private boolean LI;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch mr;

        public f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.LF = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.LI = z;
            this.mr = countDownLatch;
        }

        private void a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.LE;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) a.get(i);
                if (z) {
                    aVar.a(this.LF.mContext, this.mBitmap, false);
                } else {
                    this.LF.LD.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    aVar.a(this.LF.mContext, this.LF.LA, false);
                }
                if (!(aVar instanceof com.google.android.gms.common.images.a.c)) {
                    this.LF.LB.remove(aVar);
                }
            }
        }

        public void run() {
            je.aU("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.LF.Lz != null) {
                if (this.LI) {
                    this.LF.Lz.evictAll();
                    System.gc();
                    this.LI = false;
                    this.LF.mHandler.post(this);
                    return;
                } else if (z) {
                    this.LF.Lz.put(new a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.LF.LC.remove(this.mUri);
            if (imageReceiver != null) {
                a(imageReceiver, z);
            }
            this.mr.countDown();
            synchronized (ImageManager.Lu) {
                ImageManager.Lv.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.Lz = new b(this.mContext);
            if (ll.ij()) {
                hd();
            }
        } else {
            this.Lz = null;
        }
        this.LA = new jc();
        this.LB = new HashMap();
        this.LC = new HashMap();
        this.LD = new HashMap();
    }

    private Bitmap a(a aVar) {
        return this.Lz == null ? null : (Bitmap) this.Lz.get(aVar);
    }

    public static ImageManager c(Context context, boolean z) {
        if (z) {
            if (Lx == null) {
                Lx = new ImageManager(context, true);
            }
            return Lx;
        }
        if (Lw == null) {
            Lw = new ImageManager(context, false);
        }
        return Lw;
    }

    public static ImageManager create(Context context) {
        return c(context, false);
    }

    private void hd() {
        this.mContext.registerComponentCallbacks(new e(this.Lz));
    }

    public void a(a aVar) {
        je.aU("ImageManager.loadImage() must be called in the main thread");
        new d(this, aVar).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        a(new com.google.android.gms.common.images.a.b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        a(new com.google.android.gms.common.images.a.b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        a bVar = new com.google.android.gms.common.images.a.b(imageView, uri);
        bVar.az(defaultResId);
        a(bVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        a(new com.google.android.gms.common.images.a.c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        a cVar = new com.google.android.gms.common.images.a.c(listener, uri);
        cVar.az(defaultResId);
        a(cVar);
    }
}
