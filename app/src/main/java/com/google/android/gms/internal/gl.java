package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

@ey
public final class gl {
    private final Context mContext;
    private int mState;
    private final float rz;
    private String wH;
    private float wI;
    private float wJ;
    private float wK;

    public gl(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.rz = context.getResources().getDisplayMetrics().density;
    }

    public gl(Context context, String str) {
        this(context);
        this.wH = str;
    }

    private void a(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.wI = f;
            this.wJ = f2;
            this.wK = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.wJ) {
                    this.wJ = f2;
                } else if (f2 < this.wK) {
                    this.wK = f2;
                }
                if (this.wJ - this.wK > BitmapDescriptorFactory.HUE_ORANGE * this.rz) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.wI >= 50.0f * this.rz) {
                        this.wI = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.wI <= -50.0f * this.rz) {
                    this.wI = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.wI) {
                        this.wI = f;
                    }
                } else if (this.mState == 2 && f < this.wI) {
                    this.wI = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    private void showDialog() {
        Object obj;
        if (TextUtils.isEmpty(this.wH)) {
            obj = "No debug information";
        } else {
            Uri build = new Builder().encodedQuery(this.wH).build();
            StringBuilder stringBuilder = new StringBuilder();
            Map c = gi.c(build);
            for (String str : c.keySet()) {
                stringBuilder.append(str).append(" = ").append((String) c.get(str)).append("\n\n");
            }
            obj = stringBuilder.toString().trim();
            if (TextUtils.isEmpty(obj)) {
                obj = "No debug information";
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(obj);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new OnClickListener(this) {
            final /* synthetic */ gl wM;

            public void onClick(DialogInterface dialog, int which) {
                this.wM.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", obj), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new OnClickListener(this) {
            final /* synthetic */ gl wM;

            {
                this.wM = r1;
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

    public void Q(String str) {
        this.wH = str;
    }

    public void c(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
