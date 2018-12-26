package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.ll;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl ZQ;
    protected PopupLocationInfo ZR;

    public static final class PopupLocationInfo {
        public IBinder ZS;
        public int ZT;
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;

        private PopupLocationInfo(int gravity, IBinder windowToken) {
            this.ZT = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity;
            this.ZS = windowToken;
        }

        public Bundle lW() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.ZT);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean Yq = false;
        private WeakReference<View> ZU;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gamesClientImpl, gravity);
        }

        private void m(View view) {
            int i = -1;
            if (ll.il()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.ZR.ZT = i;
            this.ZR.ZS = windowToken;
            this.ZR.left = iArr[0];
            this.ZR.top = iArr[1];
            this.ZR.right = iArr[0] + width;
            this.ZR.bottom = iArr[1] + height;
            if (this.Yq) {
                lT();
                this.Yq = false;
            }
        }

        protected void dY(int i) {
            this.ZR = new PopupLocationInfo(i, null);
        }

        public void l(View view) {
            View view2;
            Context context;
            this.ZQ.lE();
            if (this.ZU != null) {
                view2 = (View) this.ZU.get();
                context = this.ZQ.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (ll.ik()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.ZU = null;
            context = this.ZQ.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.o("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                view = view2;
            }
            if (view != null) {
                m(view);
                this.ZU = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.p("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void lT() {
            if (this.ZR.ZS != null) {
                super.lT();
            } else {
                this.Yq = this.ZU != null;
            }
        }

        public void onGlobalLayout() {
            if (this.ZU != null) {
                View view = (View) this.ZU.get();
                if (view != null) {
                    m(view);
                }
            }
        }

        public void onViewAttachedToWindow(View v) {
            m(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.ZQ.lE();
            v.removeOnAttachStateChangeListener(this);
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.ZQ = gamesClientImpl;
        dY(gravity);
    }

    public static PopupManager a(GamesClientImpl gamesClientImpl, int i) {
        return ll.ih() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    protected void dY(int i) {
        this.ZR = new PopupLocationInfo(i, new Binder());
    }

    public void l(View view) {
    }

    public void lT() {
        this.ZQ.a(this.ZR.ZS, this.ZR.lW());
    }

    public Bundle lU() {
        return this.ZR.lW();
    }

    public IBinder lV() {
        return this.ZR.ZS;
    }

    public void setGravity(int gravity) {
        this.ZR.gravity = gravity;
    }
}
