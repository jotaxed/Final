package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ey
public class ax {
    public static final ax oo = new ax();

    private ax() {
    }

    public static ax bg() {
        return oo;
    }

    public av a(Context context, bg bgVar) {
        Date birthday = bgVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = bgVar.getContentUrl();
        int gender = bgVar.getGender();
        Collection keywords = bgVar.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = bgVar.isTestDevice(context);
        int bl = bgVar.bl();
        Location location = bgVar.getLocation();
        Bundle networkExtrasBundle = bgVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = bgVar.getManualImpressionsEnabled();
        String publisherProvidedId = bgVar.getPublisherProvidedId();
        SearchAdRequest bi = bgVar.bi();
        return new av(4, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, bl, manualImpressionsEnabled, publisherProvidedId, bi != null ? new bj(bi) : null, location, contentUrl, bgVar.bk());
    }
}
