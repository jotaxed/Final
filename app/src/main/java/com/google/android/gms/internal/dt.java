package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@ey
public final class dt extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final gu mo;
    private final MediaController so;
    private final a sp = new a(this);
    private final VideoView sq;
    private long sr;
    private String ss;

    private static final class a {
        private final Runnable mv;
        private volatile boolean st = false;

        public a(final dt dtVar) {
            this.mv = new Runnable(this) {
                private final WeakReference<dt> su = new WeakReference(dtVar);
                final /* synthetic */ a sw;

                public void run() {
                    dt dtVar = (dt) this.su.get();
                    if (!this.sw.st && dtVar != null) {
                        dtVar.cr();
                        this.sw.cs();
                    }
                }
            };
        }

        public void cancel() {
            this.st = true;
            gq.wR.removeCallbacks(this.mv);
        }

        public void cs() {
            gq.wR.postDelayed(this.mv, 250);
        }
    }

    public dt(Context context, gu guVar) {
        super(context);
        this.mo = guVar;
        this.sq = new VideoView(context);
        addView(this.sq, new LayoutParams(-1, -1, 17));
        this.so = new MediaController(context);
        this.sp.cs();
        this.sq.setOnCompletionListener(this);
        this.sq.setOnPreparedListener(this);
        this.sq.setOnErrorListener(this);
    }

    private static void a(gu guVar, String str) {
        a(guVar, str, new HashMap(1));
    }

    public static void a(gu guVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        a(guVar, "error", hashMap);
    }

    private static void a(gu guVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        a(guVar, str, hashMap);
    }

    private static void a(gu guVar, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        guVar.a("onVideoEvent", (Map) map);
    }

    public void C(String str) {
        this.ss = str;
    }

    public void b(MotionEvent motionEvent) {
        this.sq.dispatchTouchEvent(motionEvent);
    }

    public void cq() {
        if (TextUtils.isEmpty(this.ss)) {
            a(this.mo, "no_src", null);
        } else {
            this.sq.setVideoPath(this.ss);
        }
    }

    public void cr() {
        long currentPosition = (long) this.sq.getCurrentPosition();
        if (this.sr != currentPosition) {
            a(this.mo, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.sr = currentPosition;
        }
    }

    public void destroy() {
        this.sp.cancel();
        this.sq.stopPlayback();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        a(this.mo, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        a(this.mo, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        a(this.mo, "canplaythrough", "duration", String.valueOf(((float) this.sq.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.sq.pause();
    }

    public void play() {
        this.sq.start();
    }

    public void s(boolean z) {
        if (z) {
            this.sq.setMediaController(this.so);
            return;
        }
        this.so.hide();
        this.sq.setMediaController(null);
    }

    public void seekTo(int timeInMilliseconds) {
        this.sq.seekTo(timeInMilliseconds);
    }
}
