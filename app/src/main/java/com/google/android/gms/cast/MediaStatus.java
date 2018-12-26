package com.google.android.gms.cast;

import com.google.android.gms.internal.in;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    private static final long[] Gs = new long[0];
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    private JSONObject Ga;
    private MediaInfo Gb;
    private long Gj;
    private double Gk;
    private int Gl;
    private int Gm;
    private long Gn;
    private long Go;
    private double Gp;
    private boolean Gq;
    private long[] Gr;

    public MediaStatus(JSONObject json) throws JSONException {
        a(json, 0);
    }

    public int a(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        double d;
        long b;
        long[] jArr;
        int i3 = 2;
        Object obj = null;
        Object obj2 = 1;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.Gj) {
            this.Gj = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i4 != this.Gl) {
                this.Gl = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i3 = string.equals("INTERRUPTED") ? 3 : string.equals("FINISHED") ? 1 : string.equals("ERROR") ? 4 : 0;
                }
                if (i3 != this.Gm) {
                    this.Gm = i3;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            d = jSONObject.getDouble("playbackRate");
            if (this.Gk != d) {
                this.Gk = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            b = in.b(jSONObject.getDouble("currentTime"));
            if (b != this.Gn) {
                this.Gn = b;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            b = jSONObject.getLong("supportedMediaCommands");
            if (b != this.Go) {
                this.Go = b;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            d = jSONObject2.getDouble("level");
            if (d != this.Gp) {
                this.Gp = d;
                i2 |= 2;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.Gq) {
                this.Gq = z;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i3 = 0; i3 < length; i3++) {
                jArr2[i3] = jSONArray.getLong(i3);
            }
            if (this.Gr != null && this.Gr.length == length) {
                for (i3 = 0; i3 < length; i3++) {
                    if (this.Gr[i3] != jArr2[i3]) {
                        break;
                    }
                }
                obj2 = null;
            }
            if (obj2 != null) {
                this.Gr = jArr2;
            }
            obj = obj2;
            jArr = jArr2;
        } else if (this.Gr != null) {
            int i5 = 1;
            jArr = null;
        } else {
            jArr = null;
        }
        if (obj != null) {
            this.Gr = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.Ga = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (!jSONObject.has("media")) {
            return i2;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("media");
        this.Gb = new MediaInfo(jSONObject3);
        i2 |= 2;
        return jSONObject3.has("metadata") ? i2 | 4 : i2;
    }

    public long fR() {
        return this.Gj;
    }

    public long[] getActiveTrackIds() {
        return this.Gr != null ? this.Gr : Gs;
    }

    public JSONObject getCustomData() {
        return this.Ga;
    }

    public int getIdleReason() {
        return this.Gm;
    }

    public MediaInfo getMediaInfo() {
        return this.Gb;
    }

    public double getPlaybackRate() {
        return this.Gk;
    }

    public int getPlayerState() {
        return this.Gl;
    }

    public long getStreamPosition() {
        return this.Gn;
    }

    public double getStreamVolume() {
        return this.Gp;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.Go & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.Gq;
    }
}
