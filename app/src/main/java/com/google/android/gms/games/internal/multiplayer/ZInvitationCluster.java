package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
    private final int CK;
    private final ArrayList<InvitationEntity> acE;

    ZInvitationCluster(int versionCode, ArrayList<InvitationEntity> invitationList) {
        this.CK = versionCode;
        this.acE = invitationList;
        mp();
    }

    private void mp() {
        je.K(!this.acE.isEmpty());
        Invitation invitation = (Invitation) this.acE.get(0);
        int size = this.acE.size();
        for (int i = 1; i < size; i++) {
            je.a(invitation.getInviter().equals(((Invitation) this.acE.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.acE.size() != this.acE.size()) {
            return false;
        }
        int size = this.acE.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.acE.get(i)).equals((Invitation) zInvitationCluster.acE.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId() {
        return ((InvitationEntity) this.acE.get(0)).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return ((InvitationEntity) this.acE.get(0)).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.acE.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    public ArrayList<Invitation> mq() {
        return new ArrayList(this.acE);
    }

    public void writeToParcel(Parcel dest, int flags) {
        InvitationClusterCreator.a(this, dest, flags);
    }
}
