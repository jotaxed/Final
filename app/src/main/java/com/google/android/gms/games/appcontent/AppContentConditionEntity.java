package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int CK;
    private final String XT;
    private final String XU;
    private final String XV;
    private final Bundle XW;

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.CK = versionCode;
        this.XT = defaultValue;
        this.XU = expectedValue;
        this.XV = predicate;
        this.XW = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.CK = 1;
        this.XT = condition.kT();
        this.XU = condition.kT();
        this.XV = condition.kV();
        this.XW = condition.kW();
    }

    static int a(AppContentCondition appContentCondition) {
        return jv.hashCode(appContentCondition.kT(), appContentCondition.kU(), appContentCondition.kV(), appContentCondition.kW());
    }

    static boolean a(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return jv.equal(appContentCondition2.kT(), appContentCondition.kT()) && jv.equal(appContentCondition2.kU(), appContentCondition.kU()) && jv.equal(appContentCondition2.kV(), appContentCondition.kV()) && jv.equal(appContentCondition2.kW(), appContentCondition.kW());
    }

    static String b(AppContentCondition appContentCondition) {
        return jv.h(appContentCondition).a("DefaultValue", appContentCondition.kT()).a("ExpectedValue", appContentCondition.kU()).a("Predicate", appContentCondition.kV()).a("PredicateParameters", appContentCondition.kW()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kX();
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String kT() {
        return this.XT;
    }

    public String kU() {
        return this.XU;
    }

    public String kV() {
        return this.XV;
    }

    public Bundle kW() {
        return this.XW;
    }

    public AppContentCondition kX() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentConditionEntityCreator.a(this, out, flags);
    }
}
