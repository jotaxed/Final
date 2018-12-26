package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private long Eg;
    private String FR;
    private String FT;
    private String FV;
    private JSONObject Ga;
    private int Gt;
    private int Gu;
    private String mName;

    public static class Builder {
        private final MediaTrack Gv;

        public Builder(long trackId, int trackType) throws IllegalArgumentException {
            this.Gv = new MediaTrack(trackId, trackType);
        }

        public MediaTrack build() {
            return this.Gv;
        }

        public Builder setContentId(String contentId) {
            this.Gv.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType) {
            this.Gv.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.Gv.setCustomData(customData);
            return this;
        }

        public Builder setLanguage(String language) {
            this.Gv.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.Gv.setLanguage(in.b(locale));
            return this;
        }

        public Builder setName(String trackName) {
            this.Gv.setName(trackName);
            return this;
        }

        public Builder setSubtype(int subtype) throws IllegalArgumentException {
            this.Gv.ab(subtype);
            return this;
        }
    }

    MediaTrack(long id, int type) throws IllegalArgumentException {
        clear();
        this.Eg = id;
        if (type <= 0 || type > 3) {
            throw new IllegalArgumentException("invalid type " + type);
        }
        this.Gt = type;
    }

    MediaTrack(JSONObject json) throws JSONException {
        c(json);
    }

    private void c(JSONObject jSONObject) throws JSONException {
        clear();
        this.Eg = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.Gt = 1;
        } else if ("AUDIO".equals(string)) {
            this.Gt = 2;
        } else if ("VIDEO".equals(string)) {
            this.Gt = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.FT = jSONObject.optString("trackContentId", null);
        this.FV = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.FR = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.Gu = 1;
            } else if ("CAPTIONS".equals(string)) {
                this.Gu = 2;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.Gu = 3;
            } else if ("CHAPTERS".equals(string)) {
                this.Gu = 4;
            } else if ("METADATA".equals(string)) {
                this.Gu = 5;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.Gu = 0;
        this.Ga = jSONObject.optJSONObject("customData");
    }

    private void clear() {
        this.Eg = 0;
        this.Gt = 0;
        this.FT = null;
        this.mName = null;
        this.FR = null;
        this.Gu = -1;
        this.Ga = null;
    }

    void ab(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.Gt == 1) {
            this.Gu = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) other;
        if ((this.Ga == null) != (mediaTrack.Ga == null)) {
            return false;
        }
        if (this.Ga != null && mediaTrack.Ga != null && !li.d(this.Ga, mediaTrack.Ga)) {
            return false;
        }
        if (!(this.Eg == mediaTrack.Eg && this.Gt == mediaTrack.Gt && in.a(this.FT, mediaTrack.FT) && in.a(this.FV, mediaTrack.FV) && in.a(this.mName, mediaTrack.mName) && in.a(this.FR, mediaTrack.FR) && this.Gu == mediaTrack.Gu)) {
            z = false;
        }
        return z;
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

    public long getId() {
        return this.Eg;
    }

    public String getLanguage() {
        return this.FR;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.Gu;
    }

    public int getType() {
        return this.Gt;
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.Eg), Integer.valueOf(this.Gt), this.FT, this.FV, this.mName, this.FR, Integer.valueOf(this.Gu), this.Ga);
    }

    public void setContentId(String contentId) {
        this.FT = contentId;
    }

    public void setContentType(String contentType) {
        this.FV = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.Ga = customData;
    }

    void setLanguage(String language) {
        this.FR = language;
    }

    void setName(String name) {
        this.mName = name;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.Eg);
            switch (this.Gt) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.FT != null) {
                jSONObject.put("trackContentId", this.FT);
            }
            if (this.FV != null) {
                jSONObject.put("trackContentType", this.FV);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.FR)) {
                jSONObject.put("language", this.FR);
            }
            switch (this.Gu) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.Ga != null) {
                jSONObject.put("customData", this.Ga);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
