package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
    private final int CK;
    private final String YG;
    private final GameEntity acs;
    private final long adS;
    private final int adT;
    private final ParticipantEntity adU;
    private final ArrayList<ParticipantEntity> adV;
    private final int adW;
    private final int adX;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cz(x0);
        }

        public InvitationEntity cz(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.c(ji.ht()) || ji.aW(InvitationEntity.class.getCanonicalName())) {
                return super.cz(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.CK = versionCode;
        this.acs = game;
        this.YG = invitationId;
        this.adS = creationTimestamp;
        this.adT = invitationType;
        this.adU = inviter;
        this.adV = participants;
        this.adW = variant;
        this.adX = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.CK = 2;
        this.acs = new GameEntity(invitation.getGame());
        this.YG = invitation.getInvitationId();
        this.adS = invitation.getCreationTimestamp();
        this.adT = invitation.getInvitationType();
        this.adW = invitation.getVariant();
        this.adX = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.adV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                obj = participant;
            }
            this.adV.add((ParticipantEntity) participant.freeze());
        }
        jx.b(obj, (Object) "Must have a valid inviter!");
        this.adU = (ParticipantEntity) obj.freeze();
    }

    static int a(Invitation invitation) {
        return jv.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return jv.equal(invitation2.getGame(), invitation.getGame()) && jv.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && jv.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && jv.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && jv.equal(invitation2.getInviter(), invitation.getInviter()) && jv.equal(invitation2.getParticipants(), invitation.getParticipants()) && jv.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && jv.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String b(Invitation invitation) {
        return jv.h(invitation).a("Game", invitation.getGame()).a("InvitationId", invitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(invitation.getInvitationType())).a("Inviter", invitation.getInviter()).a("Participants", invitation.getParticipants()).a("Variant", Integer.valueOf(invitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.adX;
    }

    public long getCreationTimestamp() {
        return this.adS;
    }

    public Game getGame() {
        return this.acs;
    }

    public String getInvitationId() {
        return this.YG;
    }

    public int getInvitationType() {
        return this.adT;
    }

    public Participant getInviter() {
        return this.adU;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.adV);
    }

    public int getVariant() {
        return this.adW;
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

    public String toString() {
        return b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (hu()) {
            this.acs.writeToParcel(dest, flags);
            dest.writeString(this.YG);
            dest.writeLong(this.adS);
            dest.writeInt(this.adT);
            this.adU.writeToParcel(dest, flags);
            int size = this.adV.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.adV.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        InvitationEntityCreator.a(this, dest, flags);
    }
}
