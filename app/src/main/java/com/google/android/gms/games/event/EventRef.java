package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.plus.PlusShare;

public final class EventRef extends d implements Event {
    EventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return EventEntity.a(this, obj);
    }

    public Event freeze() {
        return new EventEntity(this);
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public String getEventId() {
        return getString("external_event_id");
    }

    public String getFormattedValue() {
        return getString("formatted_value");
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        a("formatted_value", dataOut);
    }

    public Uri getIconImageUri() {
        return aR("icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("icon_image_url");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer dataOut) {
        a("name", dataOut);
    }

    public Player getPlayer() {
        return new PlayerRef(this.JG, this.KZ);
    }

    public long getValue() {
        return getLong("value");
    }

    public int hashCode() {
        return EventEntity.a(this);
    }

    public boolean isVisible() {
        return getBoolean("visibility");
    }

    public String toString() {
        return EventEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((EventEntity) freeze()).writeToParcel(dest, flags);
    }
}
