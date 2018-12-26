package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.gr;

public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private dx lf;

    private void X() {
        if (this.lf != null) {
            try {
                this.lf.X();
            } catch (Throwable e) {
                gr.d("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.lf = dw.b(this);
        if (this.lf == null) {
            gr.W("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.lf.onCreate(savedInstanceState);
        } catch (Throwable e) {
            gr.d("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.lf != null) {
                this.lf.onDestroy();
            }
        } catch (Throwable e) {
            gr.d("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.lf != null) {
                this.lf.onPause();
            }
        } catch (Throwable e) {
            gr.d("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.lf != null) {
                this.lf.onRestart();
            }
        } catch (Throwable e) {
            gr.d("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.lf != null) {
                this.lf.onResume();
            }
        } catch (Throwable e) {
            gr.d("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        try {
            if (this.lf != null) {
                this.lf.onSaveInstanceState(outState);
            }
        } catch (Throwable e) {
            gr.d("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.lf != null) {
                this.lf.onStart();
            }
        } catch (Throwable e) {
            gr.d("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.lf != null) {
                this.lf.onStop();
            }
        } catch (Throwable e) {
            gr.d("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        X();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        X();
    }

    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        X();
    }
}
