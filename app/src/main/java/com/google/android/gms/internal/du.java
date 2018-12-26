package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

@ey
public final class du extends FrameLayout implements OnClickListener {
    private final Activity nB;
    private final ImageButton sx;

    public du(Activity activity, int i) {
        super(activity);
        this.nB = activity;
        setOnClickListener(this);
        this.sx = new ImageButton(activity);
        this.sx.setImageResource(17301527);
        this.sx.setBackgroundColor(0);
        this.sx.setOnClickListener(this);
        this.sx.setPadding(0, 0, 0, 0);
        this.sx.setContentDescription("Interstitial close button");
        int a = gq.a((Context) activity, i);
        addView(this.sx, new LayoutParams(a, a, 17));
    }

    public void onClick(View view) {
        this.nB.finish();
    }

    public void q(boolean z) {
        this.sx.setVisibility(z ? 4 : 0);
    }
}
