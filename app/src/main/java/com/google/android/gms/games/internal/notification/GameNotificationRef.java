package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.internal.jv;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends d implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String mr() {
        return getString("notification_id");
    }

    public String ms() {
        return getString("ticker");
    }

    public String mt() {
        return getString("coalesced_text");
    }

    public boolean mu() {
        return getInteger("acknowledged") > 0;
    }

    public boolean mv() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return jv.h(this).a("Id", Long.valueOf(getId())).a("NotificationId", mr()).a("Type", Integer.valueOf(getType())).a("Title", getTitle()).a("Ticker", ms()).a("Text", getText()).a("CoalescedText", mt()).a("isAcknowledged", Boolean.valueOf(mu())).a("isSilent", Boolean.valueOf(mv())).toString();
    }
}
