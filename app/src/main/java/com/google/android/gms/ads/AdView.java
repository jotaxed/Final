package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.bh;

public final class AdView extends ViewGroup {
    private final bh ll;

    public AdView(Context context) {
        super(context);
        this.ll = new bh(this);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ll = new bh(this, attrs, false);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.ll = new bh(this, attrs, false);
    }

    public void destroy() {
        this.ll.destroy();
    }

    public AdListener getAdListener() {
        return this.ll.getAdListener();
    }

    public AdSize getAdSize() {
        return this.ll.getAdSize();
    }

    public String getAdUnitId() {
        return this.ll.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.ll.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.ll.getMediationAdapterClassName();
    }

    public void loadAd(AdRequest adRequest) {
        this.ll.a(adRequest.Y());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int i = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            measuredWidth = childAt.getMeasuredWidth();
            i = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            measuredWidth = adSize.getWidthInPixels(context);
            i = adSize.getHeightInPixels(context);
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(i, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        this.ll.pause();
    }

    public void resume() {
        this.ll.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.ll.setAdListener(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.ll.setAdSizes(adSize);
    }

    public void setAdUnitId(String adUnitId) {
        this.ll.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.ll.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.ll.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }
}
