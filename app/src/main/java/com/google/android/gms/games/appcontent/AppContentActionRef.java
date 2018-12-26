package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 1, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentActionEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kK();
    }

    public Bundle getExtras() {
        return AppContentUtils.d(this.JG, this.XX, "action_data", this.KZ);
    }

    public String getLabel() {
        return getString("action_label");
    }

    public String getType() {
        return getString("action_type");
    }

    public int hashCode() {
        return AppContentActionEntity.a(this);
    }

    public List<AppContentCondition> kH() {
        return AppContentUtils.c(this.JG, this.XX, "action_conditions", this.KZ);
    }

    public String kI() {
        return getString("action_content_description");
    }

    public String kJ() {
        return getString("action_label_style");
    }

    public AppContentAction kK() {
        return new AppContentActionEntity(this);
    }

    public String toString() {
        return AppContentActionEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentActionEntity) kK()).writeToParcel(dest, flags);
    }
}
