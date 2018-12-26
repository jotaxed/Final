package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 0, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kS();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.a(this.JG, this.XX, "card_actions", this.KZ);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Uri getIconImageUri() {
        return aR("card_icon_image_uri");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.a(this);
    }

    public List<AppContentCondition> kH() {
        return AppContentUtils.c(this.JG, this.XX, "card_conditions", this.KZ);
    }

    public String kI() {
        return getString("card_content_description");
    }

    public Uri kL() {
        return aR("card_image_uri");
    }

    public List<AppContentAnnotation> kN() {
        return AppContentUtils.b(this.JG, this.XX, "card_annotations", this.KZ);
    }

    public int kO() {
        return getInteger("card_current_steps");
    }

    public Bundle kP() {
        return AppContentUtils.d(this.JG, this.XX, "card_data", this.KZ);
    }

    public String kQ() {
        return getString("card_subtitle");
    }

    public int kR() {
        return getInteger("card_total_steps");
    }

    public AppContentCard kS() {
        return new AppContentCardEntity(this);
    }

    public String toString() {
        return AppContentCardEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentCardEntity) kS()).writeToParcel(dest, flags);
    }
}
