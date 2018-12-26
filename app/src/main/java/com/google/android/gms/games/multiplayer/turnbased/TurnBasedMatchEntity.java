package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
    private final int CK;
    private final int Ef;
    private final String UO;
    private final long XH;
    private final String Zb;
    private final GameEntity acs;
    private final long adS;
    private final ArrayList<ParticipantEntity> adV;
    private final int adW;
    private final byte[] aeA;
    private final String aeB;
    private final byte[] aeC;
    private final int aeD;
    private final int aeE;
    private final boolean aeF;
    private final String aeG;
    private final Bundle aem;
    private final String aep;
    private final String aex;
    private final String aey;
    private final int aez;

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.CK = versionCode;
        this.acs = game;
        this.Zb = matchId;
        this.aep = creatorId;
        this.adS = creationTimestamp;
        this.aex = lastUpdaterId;
        this.XH = lastUpdatedTimestamp;
        this.aey = pendingParticipantId;
        this.aez = matchStatus;
        this.aeE = turnStatus;
        this.adW = variant;
        this.Ef = version;
        this.aeA = data;
        this.adV = participants;
        this.aeB = rematchId;
        this.aeC = previousData;
        this.aeD = matchNumber;
        this.aem = autoMatchCriteria;
        this.aeF = isLocallyModified;
        this.UO = description;
        this.aeG = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.CK = 2;
        this.acs = new GameEntity(match.getGame());
        this.Zb = match.getMatchId();
        this.aep = match.getCreatorId();
        this.adS = match.getCreationTimestamp();
        this.aex = match.getLastUpdaterId();
        this.XH = match.getLastUpdatedTimestamp();
        this.aey = match.getPendingParticipantId();
        this.aez = match.getStatus();
        this.aeE = match.getTurnStatus();
        this.adW = match.getVariant();
        this.Ef = match.getVersion();
        this.aeB = match.getRematchId();
        this.aeD = match.getMatchNumber();
        this.aem = match.getAutoMatchCriteria();
        this.aeF = match.isLocallyModified();
        this.UO = match.getDescription();
        this.aeG = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.aeA = null;
        } else {
            this.aeA = new byte[data.length];
            System.arraycopy(data, 0, this.aeA, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.aeC = null;
        } else {
            this.aeC = new byte[data.length];
            System.arraycopy(data, 0, this.aeC, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.adV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.adV.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int a(TurnBasedMatch turnBasedMatch) {
        return jv.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int a(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean a(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return jv.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && jv.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && jv.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && jv.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && jv.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && jv.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && jv.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && jv.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && jv.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && jv.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && jv.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && jv.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && jv.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && jv.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && jv.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && jv.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && jv.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && jv.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String b(TurnBasedMatch turnBasedMatch) {
        return jv.h(turnBasedMatch).a("Game", turnBasedMatch.getGame()).a("MatchId", turnBasedMatch.getMatchId()).a("CreatorId", turnBasedMatch.getCreatorId()).a("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).a("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).a("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).a("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).a("Description", turnBasedMatch.getDescription()).a("Variant", Integer.valueOf(turnBasedMatch.getVariant())).a("Data", turnBasedMatch.getData()).a("Version", Integer.valueOf(turnBasedMatch.getVersion())).a("Participants", turnBasedMatch.getParticipants()).a("RematchId", turnBasedMatch.getRematchId()).a("PreviousData", turnBasedMatch.getPreviousMatchData()).a("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).a("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).a("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).a("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String b(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant c(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> c(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.aez == 2 && this.aeB == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.aem;
    }

    public int getAvailableAutoMatchSlots() {
        return this.aem == null ? 0 : this.aem.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.adS;
    }

    public String getCreatorId() {
        return this.aep;
    }

    public byte[] getData() {
        return this.aeA;
    }

    public String getDescription() {
        return this.UO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        le.b(this.UO, dataOut);
    }

    public Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public String getDescriptionParticipantId() {
        return this.aeG;
    }

    public Game getGame() {
        return this.acs;
    }

    public long getLastUpdatedTimestamp() {
        return this.XH;
    }

    public String getLastUpdaterId() {
        return this.aex;
    }

    public String getMatchId() {
        return this.Zb;
    }

    public int getMatchNumber() {
        return this.aeD;
    }

    public Participant getParticipant(String participantId) {
        return c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return c(this);
    }

    public int getParticipantStatus(String participantId) {
        return a((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.adV);
    }

    public String getPendingParticipantId() {
        return this.aey;
    }

    public byte[] getPreviousMatchData() {
        return this.aeC;
    }

    public String getRematchId() {
        return this.aeB;
    }

    public int getStatus() {
        return this.aez;
    }

    public int getTurnStatus() {
        return this.aeE;
    }

    public int getVariant() {
        return this.adW;
    }

    public int getVersion() {
        return this.Ef;
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

    public boolean isLocallyModified() {
        return this.aeF;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.a(this, out, flags);
    }
}
