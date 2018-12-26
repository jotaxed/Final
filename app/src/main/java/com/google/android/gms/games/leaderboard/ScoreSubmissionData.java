package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] adl = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int Iv;
    private String Xh;
    private HashMap<Integer, Result> adR = new HashMap();
    private String adn;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return jv.h(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.Iv = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        jx.L(count == 3);
        for (int i = 0; i < count; i++) {
            int au = dataHolder.au(i);
            if (i == 0) {
                this.adn = dataHolder.c("leaderboardId", i, au);
                this.Xh = dataHolder.c("playerId", i, au);
            }
            if (dataHolder.d("hasResult", i, au)) {
                a(new Result(dataHolder.a("rawScore", i, au), dataHolder.c("formattedScore", i, au), dataHolder.c("scoreTag", i, au), dataHolder.d("newBest", i, au)), dataHolder.b("timeSpan", i, au));
            }
        }
    }

    private void a(Result result, int i) {
        this.adR.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.adn;
    }

    public String getPlayerId() {
        return this.Xh;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.adR.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        a a = jv.h(this).a("PlayerId", this.Xh).a("StatusCode", Integer.valueOf(this.Iv));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.adR.get(Integer.valueOf(i));
            a.a("TimesSpan", TimeSpan.dZ(i));
            a.a("Result", result == null ? "null" : result.toString());
        }
        return a.toString();
    }
}
