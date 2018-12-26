package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int adF;
    private final int adG;
    private final boolean adH;
    private final long adI;
    private final String adJ;
    private final long adK;
    private final String adL;
    private final String adM;
    private final long adN;
    private final String adO;
    private final String adP;
    private final String adQ;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.adF = variant.getTimeSpan();
        this.adG = variant.getCollection();
        this.adH = variant.hasPlayerInfo();
        this.adI = variant.getRawPlayerScore();
        this.adJ = variant.getDisplayPlayerScore();
        this.adK = variant.getPlayerRank();
        this.adL = variant.getDisplayPlayerRank();
        this.adM = variant.getPlayerScoreTag();
        this.adN = variant.getNumScores();
        this.adO = variant.mK();
        this.adP = variant.mL();
        this.adQ = variant.mM();
    }

    static int a(LeaderboardVariant leaderboardVariant) {
        return jv.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.mK(), leaderboardVariant.mM(), leaderboardVariant.mL());
    }

    static boolean a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return jv.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && jv.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && jv.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && jv.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && jv.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && jv.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && jv.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && jv.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && jv.equal(leaderboardVariant2.mK(), leaderboardVariant.mK()) && jv.equal(leaderboardVariant2.mM(), leaderboardVariant.mM()) && jv.equal(leaderboardVariant2.mL(), leaderboardVariant.mL());
    }

    static String b(LeaderboardVariant leaderboardVariant) {
        return jv.h(leaderboardVariant).a("TimeSpan", TimeSpan.dZ(leaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.dZ(leaderboardVariant.getCollection())).a("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").a("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").a("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").a("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").a("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).a("TopPageNextToken", leaderboardVariant.mK()).a("WindowPageNextToken", leaderboardVariant.mM()).a("WindowPagePrevToken", leaderboardVariant.mL()).toString();
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mN();
    }

    public int getCollection() {
        return this.adG;
    }

    public String getDisplayPlayerRank() {
        return this.adL;
    }

    public String getDisplayPlayerScore() {
        return this.adJ;
    }

    public long getNumScores() {
        return this.adN;
    }

    public long getPlayerRank() {
        return this.adK;
    }

    public String getPlayerScoreTag() {
        return this.adM;
    }

    public long getRawPlayerScore() {
        return this.adI;
    }

    public int getTimeSpan() {
        return this.adF;
    }

    public boolean hasPlayerInfo() {
        return this.adH;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String mK() {
        return this.adO;
    }

    public String mL() {
        return this.adP;
    }

    public String mM() {
        return this.adQ;
    }

    public LeaderboardVariant mN() {
        return this;
    }

    public String toString() {
        return b(this);
    }
}
