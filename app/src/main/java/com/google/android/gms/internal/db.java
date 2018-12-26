package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@ey
public final class db implements MediationAdRequest {
    private final Date d;
    private final Set<String> f;
    private final boolean g;
    private final Location h;
    private final int ow;
    private final int qU;

    public db(Date date, int i, Set<String> set, Location location, boolean z, int i2) {
        this.d = date;
        this.ow = i;
        this.f = set;
        this.h = location;
        this.g = z;
        this.qU = i2;
    }

    public Date getBirthday() {
        return this.d;
    }

    public int getGender() {
        return this.ow;
    }

    public Set<String> getKeywords() {
        return this.f;
    }

    public Location getLocation() {
        return this.h;
    }

    public boolean isTesting() {
        return this.g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.qU;
    }
}
