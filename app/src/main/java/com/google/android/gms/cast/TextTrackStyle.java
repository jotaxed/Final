package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import com.google.android.gms.internal.ll;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private float GT;
    private int GU;
    private int GV;
    private int GW;
    private int GX;
    private int GY;
    private int GZ;
    private JSONObject Ga;
    private String Ha;
    private int Hb;
    private int Hc;
    private int xB;

    public TextTrackStyle() {
        clear();
    }

    private int aC(String str) {
        int i = 0;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private void clear() {
        this.GT = DEFAULT_FONT_SCALE;
        this.GU = 0;
        this.xB = 0;
        this.GV = -1;
        this.GW = 0;
        this.GX = -1;
        this.GY = 0;
        this.GZ = 0;
        this.Ha = null;
        this.Hb = -1;
        this.Hc = -1;
        this.Ga = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!ll.im()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private String u(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    public void c(JSONObject jSONObject) throws JSONException {
        String string;
        clear();
        this.GT = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.GU = aC(jSONObject.optString("foregroundColor"));
        this.xB = aC(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.GV = 0;
            } else if ("OUTLINE".equals(string)) {
                this.GV = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.GV = 2;
            } else if ("RAISED".equals(string)) {
                this.GV = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.GV = 4;
            }
        }
        this.GW = aC(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.GX = 0;
            } else if ("NORMAL".equals(string)) {
                this.GX = 1;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.GX = 2;
            }
        }
        this.GY = aC(jSONObject.optString("windowColor"));
        if (this.GX == 2) {
            this.GZ = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.Ha = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.Hb = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.Hb = 1;
            } else if ("SERIF".equals(string)) {
                this.Hb = 2;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.Hb = 3;
            } else if ("CASUAL".equals(string)) {
                this.Hb = 4;
            } else if ("CURSIVE".equals(string)) {
                this.Hb = 5;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.Hb = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.Hc = 0;
            } else if ("BOLD".equals(string)) {
                this.Hc = 1;
            } else if ("ITALIC".equals(string)) {
                this.Hc = 2;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.Hc = 3;
            }
        }
        this.Ga = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.Ga == null) != (textTrackStyle.Ga == null)) {
            return false;
        }
        if (this.Ga != null && textTrackStyle.Ga != null && !li.d(this.Ga, textTrackStyle.Ga)) {
            return false;
        }
        if (!(this.GT == textTrackStyle.GT && this.GU == textTrackStyle.GU && this.xB == textTrackStyle.xB && this.GV == textTrackStyle.GV && this.GW == textTrackStyle.GW && this.GX == textTrackStyle.GX && this.GZ == textTrackStyle.GZ && in.a(this.Ha, textTrackStyle.Ha) && this.Hb == textTrackStyle.Hb && this.Hc == textTrackStyle.Hc)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.xB;
    }

    public JSONObject getCustomData() {
        return this.Ga;
    }

    public int getEdgeColor() {
        return this.GW;
    }

    public int getEdgeType() {
        return this.GV;
    }

    public String getFontFamily() {
        return this.Ha;
    }

    public int getFontGenericFamily() {
        return this.Hb;
    }

    public float getFontScale() {
        return this.GT;
    }

    public int getFontStyle() {
        return this.Hc;
    }

    public int getForegroundColor() {
        return this.GU;
    }

    public int getWindowColor() {
        return this.GY;
    }

    public int getWindowCornerRadius() {
        return this.GZ;
    }

    public int getWindowType() {
        return this.GX;
    }

    public int hashCode() {
        return jv.hashCode(Float.valueOf(this.GT), Integer.valueOf(this.GU), Integer.valueOf(this.xB), Integer.valueOf(this.GV), Integer.valueOf(this.GW), Integer.valueOf(this.GX), Integer.valueOf(this.GY), Integer.valueOf(this.GZ), this.Ha, Integer.valueOf(this.Hb), Integer.valueOf(this.Hc), this.Ga);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.xB = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.Ga = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.GW = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.GV = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.Ha = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.Hb = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.GT = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.Hc = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.GU = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.GY = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.GZ = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.GX = windowType;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.GT);
            if (this.GU != 0) {
                jSONObject.put("foregroundColor", u(this.GU));
            }
            if (this.xB != 0) {
                jSONObject.put("backgroundColor", u(this.xB));
            }
            switch (this.GV) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.GW != 0) {
                jSONObject.put("edgeColor", u(this.GW));
            }
            switch (this.GX) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.GY != 0) {
                jSONObject.put("windowColor", u(this.GY));
            }
            if (this.GX == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.GZ);
            }
            if (this.Ha != null) {
                jSONObject.put("fontFamily", this.Ha);
            }
            switch (this.Hb) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.Hc) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
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
