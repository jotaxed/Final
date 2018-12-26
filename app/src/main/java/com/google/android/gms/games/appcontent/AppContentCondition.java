package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface AppContentCondition extends Parcelable, Freezable<AppContentCondition> {
    String kT();

    String kU();

    String kV();

    Bundle kW();
}
