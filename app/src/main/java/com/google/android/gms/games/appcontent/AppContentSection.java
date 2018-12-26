package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public interface AppContentSection extends Parcelable, Freezable<AppContentSection> {
    List<AppContentAction> getActions();

    String getTitle();

    String getType();

    String kI();

    Bundle kP();

    String kQ();

    Uri kY();

    List<AppContentCard> kZ();
}
