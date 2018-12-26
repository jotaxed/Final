package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bg.a;
import com.google.android.gms.internal.jx;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final bg lg;

    public static final class Builder {
        private final a lh = new a();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.lh.b(adapterClass, customEventExtras);
            return this;
        }

        public Builder addKeyword(String keyword) {
            this.lh.r(keyword);
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

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.lh.a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            jx.b((Object) contentUrl, (Object) "Content URL must be non-null.");
            jx.b(contentUrl, (Object) "Content URL must be non-empty.");
            jx.b(contentUrl.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(contentUrl.length()));
            this.lh.t(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.lh.h(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.lh.a(location);
            return this;
        }

        public Builder setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.lh.i(manualImpressionsEnabled);
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.lh.u(publisherProvidedId);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.lh.j(tagForChildDirectedTreatment);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.lg = new bg(builder.lh);
    }

    public bg Y() {
        return this.lg;
    }

    public Date getBirthday() {
        return this.lg.getBirthday();
    }

    public String getContentUrl() {
        return this.lg.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.lg.getCustomEventExtrasBundle(adapterClass);
    }

    public int getGender() {
        return this.lg.getGender();
    }

    public Set<String> getKeywords() {
        return this.lg.getKeywords();
    }

    public Location getLocation() {
        return this.lg.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.lg.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.lg.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.lg.getNetworkExtrasBundle(adapterClass);
    }

    public String getPublisherProvidedId() {
        return this.lg.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.lg.isTestDevice(context);
    }
}
