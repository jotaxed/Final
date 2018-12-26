package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final int CK;
    private final String UO;
    private final Uri WD;
    private final String WO;
    private final PlayerEntity XE;
    private final String Ye;
    private final long Yf;
    private final String Yg;
    private final boolean Yh;
    private final String mName;

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.CK = versionCode;
        this.Ye = eventId;
        this.mName = name;
        this.UO = description;
        this.WD = iconImageUri;
        this.WO = iconImageUrl;
        this.XE = new PlayerEntity(player);
        this.Yf = value;
        this.Yg = formattedValue;
        this.Yh = isVisible;
    }

    public EventEntity(Event event) {
        this.CK = 1;
        this.Ye = event.getEventId();
        this.mName = event.getName();
        this.UO = event.getDescription();
        this.WD = event.getIconImageUri();
        this.WO = event.getIconImageUrl();
        this.XE = (PlayerEntity) event.getPlayer().freeze();
        this.Yf = event.getValue();
        this.Yg = event.getFormattedValue();
        this.Yh = event.isVisible();
    }

    static int a(Event event) {
        return jv.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean a(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return jv.equal(event2.getEventId(), event.getEventId()) && jv.equal(event2.getName(), event.getName()) && jv.equal(event2.getDescription(), event.getDescription()) && jv.equal(event2.getIconImageUri(), event.getIconImageUri()) && jv.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && jv.equal(event2.getPlayer(), event.getPlayer()) && jv.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && jv.equal(event2.getFormattedValue(), event.getFormattedValue()) && jv.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String b(Event event) {
        return jv.h(event).a("Id", event.getEventId()).a("Name", event.getName()).a("Description", event.getDescription()).a("IconImageUri", event.getIconImageUri()).a("IconImageUrl", event.getIconImageUrl()).a("Player", event.getPlayer()).a("Value", Long.valueOf(event.getValue())).a("FormattedValue", event.getFormattedValue()).a("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.UO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        le.b(this.UO, dataOut);
    }

    public String getEventId() {
        return this.Ye;
    }

    public String getFormattedValue() {
        return this.Yg;
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        le.b(this.Yg, dataOut);
    }

    public Uri getIconImageUri() {
        return this.WD;
    }

    public String getIconImageUrl() {
        return this.WO;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        le.b(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.XE;
    }

    public long getValue() {
        return this.Yf;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.Yh;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.a(this, out, flags);
    }
}
