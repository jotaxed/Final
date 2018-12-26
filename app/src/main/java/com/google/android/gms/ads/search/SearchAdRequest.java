package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bg.a;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final bg lg;
    private final int xA;
    private final int xB;
    private final int xC;
    private final int xD;
    private final int xE;
    private final int xF;
    private final int xG;
    private final int xH;
    private final String xI;
    private final int xJ;
    private final String xK;
    private final int xL;
    private final int xM;
    private final String xN;

    public static final class Builder {
        private final a lh = new a();
        private int xA;
        private int xB;
        private int xC;
        private int xD;
        private int xE;
        private int xF;
        private int xG = 0;
        private int xH;
        private String xI;
        private int xJ;
        private String xK;
        private int xL;
        private int xM;
        private String xN;

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.lh.b(adapterClass, customEventExtras);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.lh.a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.lh.a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.lh.s(deviceId);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int anchorTextColor) {
            this.xA = anchorTextColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.xB = backgroundColor;
            this.xC = Color.argb(0, 0, 0, 0);
            this.xD = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int top, int bottom) {
            this.xB = Color.argb(0, 0, 0, 0);
            this.xC = bottom;
            this.xD = top;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.xE = borderColor;
            return this;
        }

        public Builder setBorderThickness(int borderThickness) {
            this.xF = borderThickness;
            return this;
        }

        public Builder setBorderType(int borderType) {
            this.xG = borderType;
            return this;
        }

        public Builder setCallButtonColor(int callButtonColor) {
            this.xH = callButtonColor;
            return this;
        }

        public Builder setCustomChannels(String channelIds) {
            this.xI = channelIds;
            return this;
        }

        public Builder setDescriptionTextColor(int descriptionTextColor) {
            this.xJ = descriptionTextColor;
            return this;
        }

        public Builder setFontFace(String fontFace) {
            this.xK = fontFace;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.xL = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(int headerTextSize) {
            this.xM = headerTextSize;
            return this;
        }

        public Builder setLocation(Location location) {
            this.lh.a(location);
            return this;
        }

        public Builder setQuery(String query) {
            this.xN = query;
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.lh.j(tagForChildDirectedTreatment);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.xA = builder.xA;
        this.xB = builder.xB;
        this.xC = builder.xC;
        this.xD = builder.xD;
        this.xE = builder.xE;
        this.xF = builder.xF;
        this.xG = builder.xG;
        this.xH = builder.xH;
        this.xI = builder.xI;
        this.xJ = builder.xJ;
        this.xK = builder.xK;
        this.xL = builder.xL;
        this.xM = builder.xM;
        this.xN = builder.xN;
        this.lg = new bg(builder.lh, this);
    }

    bg Y() {
        return this.lg;
    }

    public int getAnchorTextColor() {
        return this.xA;
    }

    public int getBackgroundColor() {
        return this.xB;
    }

    public int getBackgroundGradientBottom() {
        return this.xC;
    }

    public int getBackgroundGradientTop() {
        return this.xD;
    }

    public int getBorderColor() {
        return this.xE;
    }

    public int getBorderThickness() {
        return this.xF;
    }

    public int getBorderType() {
        return this.xG;
    }

    public int getCallButtonColor() {
        return this.xH;
    }

    public String getCustomChannels() {
        return this.xI;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.lg.getCustomEventExtrasBundle(adapterClass);
    }

    public int getDescriptionTextColor() {
        return this.xJ;
    }

    public String getFontFace() {
        return this.xK;
    }

    public int getHeaderTextColor() {
        return this.xL;
    }

    public int getHeaderTextSize() {
        return this.xM;
    }

    public Location getLocation() {
        return this.lg.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.lg.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.lg.getNetworkExtrasBundle(adapterClass);
    }

    public String getQuery() {
        return this.xN;
    }

    public boolean isTestDevice(Context context) {
        return this.lg.isTestDevice(context);
    }
}
