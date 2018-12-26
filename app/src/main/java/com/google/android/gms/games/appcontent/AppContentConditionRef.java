package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 4, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentConditionEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kX();
    }

    public int hashCode() {
        return AppContentConditionEntity.a(this);
    }

    public String kT() {
        return getString("condition_default_value");
    }

    public String kU() {
        return getString("condition_expected_value");
    }

    public String kV() {
        return getString("condition_predicate");
    }

    public Bundle kW() {
        return AppContentUtils.d(this.JG, this.XX, "condition_predicate_parameters", this.KZ);
    }

    public AppContentCondition kX() {
        return new AppContentConditionEntity(this);
    }

    public String toString() {
        return AppContentConditionEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentConditionEntity) kX()).writeToParcel(dest, flags);
    }
}
