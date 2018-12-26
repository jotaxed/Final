package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.lang.ref.WeakReference;

public abstract class a {
    final a LJ;
    protected int LK = 0;
    protected int LL = 0;
    protected boolean LM = false;
    protected OnImageLoadedListener LN;
    private boolean LO = true;
    private boolean LP = false;
    private boolean LQ = true;
    protected int LR;

    static final class a {
        public final Uri uri;

        public a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            return !(obj instanceof a) ? false : this == obj ? true : jv.equal(((a) obj).uri, this.uri);
        }

        public int hashCode() {
            return jv.hashCode(this.uri);
        }
    }

    public static final class b extends a {
        private WeakReference<ImageView> LS;

        public b(ImageView imageView, int i) {
            super(null, i);
            je.f(imageView);
            this.LS = new WeakReference(imageView);
        }

        public b(ImageView imageView, Uri uri) {
            super(uri, 0);
            je.f(imageView);
            this.LS = new WeakReference(imageView);
        }

        private void a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof jb)) {
                int hj = ((jb) imageView).hj();
                if (this.LL != 0 && hj == this.LL) {
                    return;
                }
            }
            boolean b = b(z, z2);
            Drawable newDrawable = (!this.LM || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (b) {
                newDrawable = a(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof jb) {
                jb jbVar = (jb) imageView;
                jbVar.g(z3 ? this.LJ.uri : null);
                jbVar.aB(obj != null ? this.LL : 0);
            }
            if (b) {
                ((iz) newDrawable).startTransition(250);
            }
        }

        protected void a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.LS.get();
            if (imageView != null) {
                a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.LS.get();
            ImageView imageView2 = (ImageView) ((b) obj).LS.get();
            boolean z = (imageView2 == null || imageView == null || !jv.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class c extends a {
        private WeakReference<OnImageLoadedListener> LT;

        public c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            je.f(onImageLoadedListener);
            this.LT = new WeakReference(onImageLoadedListener);
        }

        protected void a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.LT.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.LJ.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            c cVar = (c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.LT.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) cVar.LT.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && jv.equal(onImageLoadedListener2, onImageLoadedListener) && jv.equal(cVar.LJ, this.LJ);
            return z;
        }

        public int hashCode() {
            return jv.hashCode(this.LJ);
        }
    }

    public a(Uri uri, int i) {
        this.LJ = new a(uri);
        this.LL = i;
    }

    private Drawable a(Context context, jc jcVar, int i) {
        Resources resources = context.getResources();
        if (this.LR <= 0) {
            return resources.getDrawable(i);
        }
        com.google.android.gms.internal.jc.a aVar = new com.google.android.gms.internal.jc.a(i, this.LR);
        Drawable drawable = (Drawable) jcVar.get(aVar);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.LR & 1) != 0) {
            drawable = a(resources, drawable);
        }
        jcVar.put(aVar, drawable);
        return drawable;
    }

    protected Drawable a(Resources resources, Drawable drawable) {
        return ja.a(resources, drawable);
    }

    protected iz a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof iz) {
            drawable = ((iz) drawable).hh();
        }
        return new iz(drawable, drawable2);
    }

    void a(Context context, Bitmap bitmap, boolean z) {
        je.f(bitmap);
        if ((this.LR & 1) != 0) {
            bitmap = ja.a(bitmap);
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.LN != null) {
            this.LN.onImageLoaded(this.LJ.uri, bitmapDrawable, true);
        }
        a(bitmapDrawable, z, false, true);
    }

    void a(Context context, jc jcVar) {
        if (this.LQ) {
            Drawable drawable = null;
            if (this.LK != 0) {
                drawable = a(context, jcVar, this.LK);
            }
            a(drawable, false, true, false);
        }
    }

    void a(Context context, jc jcVar, boolean z) {
        Drawable drawable = null;
        if (this.LL != 0) {
            drawable = a(context, jcVar, this.LL);
        }
        if (this.LN != null) {
            this.LN.onImageLoaded(this.LJ.uri, drawable, false);
        }
        a(drawable, z, false, false);
    }

    protected abstract void a(Drawable drawable, boolean z, boolean z2, boolean z3);

    public void az(int i) {
        this.LL = i;
    }

    protected boolean b(boolean z, boolean z2) {
        return this.LO && !z2 && (!z || this.LP);
    }
}
