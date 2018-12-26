package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String FT;
    private int FU;
    private String FV;
    private MediaMetadata FW;
    private long FX;
    private List<MediaTrack> FY;
    private TextTrackStyle FZ;
    private JSONObject Ga;

    public static class Builder {
        private final MediaInfo Gb;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.Gb = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.Gb.fQ();
            return this.Gb;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.Gb.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.Gb.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.Gb.d(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.Gb.a(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.Gb.m(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.Gb.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.Gb.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.FT = contentId;
        this.FU = -1;
    }

    MediaInfo(JSONObject json) throws JSONException {
        int i = 0;
        this.FT = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.FU = 0;
        } else if ("BUFFERED".equals(string)) {
            this.FU = 1;
        } else if ("LIVE".equals(string)) {
            this.FU = 2;
        } else {
            this.FU = -1;
        }
        this.FV = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.FW = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.FW.c(jSONObject);
        }
        this.FX = -1;
        if (json.has("duration") && !json.isNull("duration")) {
            double optDouble = json.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.FX = in.b(optDouble);
            }
        }
        if (json.has("tracks")) {
            this.FY = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.FY.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i++;
            }
        } else {
            this.FY = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.c(jSONObject2);
            this.FZ = textTrackStyle;
        } else {
            this.FZ = null;
        }
        this.Ga = json.optJSONObject("customData");
    }

    void a(MediaMetadata mediaMetadata) {
        this.FW = mediaMetadata;
    }

    void d(List<MediaTrack> list) {
        this.FY = list;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.Ga == null) != (mediaInfo.Ga == null)) {
            return false;
        }
        if (this.Ga != null && mediaInfo.Ga != null && !li.d(this.Ga, mediaInfo.Ga)) {
            return false;
        }
        if (!(in.a(this.FT, mediaInfo.FT) && this.FU == mediaInfo.FU && in.a(this.FV, mediaInfo.FV) && in.a(this.FW, mediaInfo.FW) && this.FX == mediaInfo.FX)) {
            z = false;
        }
        return z;
    }

    void fQ() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.FT)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.FV)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.FU == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    public String getContentId() {
        return this.FT;
    }

    public String getContentType() {
        return this.FV;
    }

    public JSONObject getCustomData() {
        return this.Ga;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.FY;
    }

    public MediaMetadata getMetadata() {
        return this.FW;
    }

    public long getStreamDuration() {
        return this.FX;
    }

    public int getStreamType() {
        return this.FU;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.FZ;
    }

    public int hashCode() {
        return jv.hashCode(this.FT, Integer.valueOf(this.FU), this.FV, this.FW, Long.valueOf(this.FX), String.valueOf(this.Ga));
    }

    void m(long j) throws IllegalArgumentException {
        if (j < 0) {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        }
        this.FX = j;
    }

    void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.FV = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.Ga = customData;
    }

    void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < -1 || streamType > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.FU = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.FZ = textTrackStyle;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.FT);
            switch (this.FU) {
                case 1:
                    obj = "BUFFERED";
                    break;
                case 2:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.FV != null) {
                jSONObject.put("contentType", this.FV);
            }
            if (this.FW != null) {
                jSONObject.put("metadata", this.FW.toJson());
            }
            jSONObject.put("duration", in.o(this.FX));
            if (this.FY != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.FY) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.FZ != null) {
                jSONObject.put("textTrackStyle", this.FZ.toJson());
            }
            if (this.Ga != null) {
                jSONObject.put("customData", this.Ga);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
