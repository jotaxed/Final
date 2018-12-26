package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.jv;

public final class GameInstanceRef extends d implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public int jC() {
        return getInteger("platform_type");
    }

    public boolean ml() {
        return getInteger("real_time_support") > 0;
    }

    public boolean mm() {
        return getInteger("turn_based_support") > 0;
    }

    public boolean mn() {
        return getInteger("piracy_check") > 0;
    }

    public boolean mo() {
        return getInteger("installed") > 0;
    }

    public String toString() {
        return jv.h(this).a("ApplicationId", getApplicationId()).a("DisplayName", getDisplayName()).a("SupportsRealTime", Boolean.valueOf(ml())).a("SupportsTurnBased", Boolean.valueOf(mm())).a("PlatformType", PlatformType.dZ(jC())).a("PackageName", getPackageName()).a("PiracyCheckEnabled", Boolean.valueOf(mn())).a("Installed", Boolean.valueOf(mo())).toString();
    }
}
