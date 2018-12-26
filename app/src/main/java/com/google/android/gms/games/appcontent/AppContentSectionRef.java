package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int Ya;

    AppContentSectionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow, int numChildren) {
        super(dataHolderCollection, 0, dataRow);
        this.Ya = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return la();
    }

    public /* synthetic */ List getActions() {
        return lb();
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.a(this);
    }

    public String kI() {
        return getString("section_content_description");
    }

    public Bundle kP() {
        return AppContentUtils.d(this.JG, this.XX, "section_data", this.KZ);
    }

    public String kQ() {
        return getString("section_subtitle");
    }

    public Uri kY() {
        return aR("section_background_image_uri");
    }

    public /* synthetic */ List kZ() {
        return lc();
    }

    public AppContentSection la() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> lb() {
        return AppContentUtils.a(this.JG, this.XX, "section_actions", this.KZ);
    }

    public ArrayList<AppContentCard> lc() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new AppContentCardRef(this.XX, this.KZ + i));
        }
        return arrayList;
    }

    public String toString() {
        return AppContentSectionEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentSectionEntity) la()).writeToParcel(dest, flags);
    }
}
