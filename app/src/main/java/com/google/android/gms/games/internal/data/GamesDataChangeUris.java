package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

public final class GamesDataChangeUris {
    private static final Uri ach = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
    public static final Uri aci = ach.buildUpon().appendPath("invitations").build();
    public static final Uri acj = ach.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
}
