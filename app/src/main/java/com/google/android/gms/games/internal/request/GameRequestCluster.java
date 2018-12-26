package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
    private final int CK;
    private final ArrayList<GameRequestEntity> adk;

    GameRequestCluster(int versionCode, ArrayList<GameRequestEntity> requestList) {
        this.CK = versionCode;
        this.adk = requestList;
        mp();
    }

    private void mp() {
        je.K(!this.adk.isEmpty());
        GameRequest gameRequest = (GameRequest) this.adk.get(0);
        int size = this.adk.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.adk.get(i);
            je.a(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            je.a(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.adk.size() != this.adk.size()) {
            return false;
        }
        int size = this.adk.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.adk.get(i)).equals((GameRequest) gameRequestCluster.adk.get(i))) {
                return false;
            }
        }
        return true;
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public /* synthetic */ List getRecipients() {
        return mE();
    }

    public String getRequestId() {
        return ((GameRequestEntity) this.adk.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity) this.adk.get(0)).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return ((GameRequestEntity) this.adk.get(0)).getType();
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.adk.toArray());
    }

    public boolean isConsumed(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    public ArrayList<GameRequest> mD() {
        return new ArrayList(this.adk);
    }

    public ArrayList<Player> mE() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestClusterCreator.a(this, dest, flags);
    }
}
