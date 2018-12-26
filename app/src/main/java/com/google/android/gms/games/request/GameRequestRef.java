package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends d implements GameRequest {
    private final int Ya;

    public GameRequestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.Ya = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.a(this, obj);
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new GameRef(this.JG, this.KZ);
    }

    public int getRecipientStatus(String playerId) {
        for (int i = this.KZ; i < this.KZ + this.Ya; i++) {
            int au = this.JG.au(i);
            if (this.JG.c("recipient_external_player_id", i, au).equals(playerId)) {
                return this.JG.b("recipient_status", i, au);
            }
        }
        return -1;
    }

    public List<Player> getRecipients() {
        List arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new PlayerRef(this.JG, this.KZ + i, "recipient_"));
        }
        return arrayList;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new PlayerRef(this.JG, gW(), "sender_");
    }

    public int getStatus() {
        return getInteger("status");
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.a(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public String toString() {
        return GameRequestEntity.c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
