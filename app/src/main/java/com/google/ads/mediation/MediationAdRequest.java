package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    private final Date d;
    private final Gender e;
    private final Set<String> f;
    private final boolean g;
    private final Location h;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.d = birthday;
        this.e = gender;
        this.f = keywords;
        this.g = isTesting;
        this.h = location;
    }

    public Integer getAgeInYears() {
        if (this.d == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.d);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.d;
    }

    public Gender getGender() {
        return this.e;
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
}
