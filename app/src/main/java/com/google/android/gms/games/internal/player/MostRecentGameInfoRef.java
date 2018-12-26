package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MostRecentGameInfoRef extends d implements MostRecentGameInfo {
    private final PlayerColumnNames Xv;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.Xv = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mC();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.a(this);
    }

    public Uri mA() {
        return aR(this.Xv.adi);
    }

    public Uri mB() {
        return aR(this.Xv.adj);
    }

    public MostRecentGameInfo mC() {
        return new MostRecentGameInfoEntity(this);
    }

    public String mw() {
        return getString(this.Xv.ade);
    }

    public String mx() {
        return getString(this.Xv.adf);
    }

    public long my() {
        return getLong(this.Xv.adg);
    }

    public Uri mz() {
        return aR(this.Xv.adh);
    }

    public String toString() {
        return MostRecentGameInfoEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) mC()).writeToParcel(dest, flags);
    }
}
