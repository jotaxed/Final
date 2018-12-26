package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends d implements Participant {
    private final PlayerRef aeb;

    public ParticipantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.aeb = new PlayerRef(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return aS("external_player_id") ? getString("default_display_name") : this.aeb.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (aS("external_player_id")) {
            a("default_display_name", dataOut);
        } else {
            this.aeb.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return aS("external_player_id") ? aR("default_display_hi_res_image_uri") : this.aeb.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return aS("external_player_id") ? getString("default_display_hi_res_image_url") : this.aeb.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return aS("external_player_id") ? aR("default_display_image_uri") : this.aeb.getIconImageUri();
    }

    public String getIconImageUrl() {
        return aS("external_player_id") ? getString("default_display_image_url") : this.aeb.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        return aS("external_player_id") ? null : this.aeb;
    }

    public ParticipantResult getResult() {
        if (aS("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String le() {
        return getString("client_address");
    }

    public String toString() {
        return ParticipantEntity.b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
