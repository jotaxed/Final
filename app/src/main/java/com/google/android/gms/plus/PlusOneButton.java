package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ka;
import com.google.android.gms.plus.internal.g;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int anA;
    private OnPlusOneClickListener anB;
    private View any;
    private int anz;
    private int mSize;
    private String vf;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener anC;
        final /* synthetic */ PlusOneButton anD;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener proxy) {
            this.anD = plusOneButton;
            this.anC = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.anD.any.getTag();
            if (this.anC != null) {
                this.anC.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.anD.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.anD.anA);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.anz = getAnnotation(context, attrs);
        this.anA = -1;
        G(getContext());
        if (!isInEditMode()) {
        }
    }

    private void G(Context context) {
        if (this.any != null) {
            removeView(this.any);
        }
        this.any = g.a(context, this.mSize, this.anz, this.vf, this.anA);
        setOnPlusOneClickListener(this.anB);
        addView(this.any);
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = ka.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        return "INLINE".equalsIgnoreCase(a) ? 2 : !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = ka.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(a) ? 0 : "MEDIUM".equalsIgnoreCase(a) ? 1 : "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    public void initialize(String url, int activityRequestCode) {
        jx.a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.vf = url;
        this.anA = activityRequestCode;
        G(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.vf = url;
        this.anA = 0;
        G(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.any.layout(0, 0, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.any;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.anz = annotation;
        G(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.anB = listener;
        this.any.setOnClickListener(new DefaultOnPlusOneClickListener(this, listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        G(getContext());
    }
}
