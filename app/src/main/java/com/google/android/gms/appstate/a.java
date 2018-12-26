package com.google.android.gms.appstate;

import com.google.android.gms.internal.jv;

public final class a implements AppState {
    private final int DK;
    private final String DL;
    private final byte[] DM;
    private final boolean DN;
    private final String DO;
    private final byte[] DP;

    public a(AppState appState) {
        this.DK = appState.getKey();
        this.DL = appState.getLocalVersion();
        this.DM = appState.getLocalData();
        this.DN = appState.hasConflict();
        this.DO = appState.getConflictVersion();
        this.DP = appState.getConflictData();
    }

    static int a(AppState appState) {
        return jv.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return jv.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && jv.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && jv.equal(appState2.getLocalData(), appState.getLocalData()) && jv.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && jv.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && jv.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String b(AppState appState) {
        return jv.h(appState).a("Key", Integer.valueOf(appState.getKey())).a("LocalVersion", appState.getLocalVersion()).a("LocalData", appState.getLocalData()).a("HasConflict", Boolean.valueOf(appState.hasConflict())).a("ConflictVersion", appState.getConflictVersion()).a("ConflictData", appState.getConflictData()).toString();
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public AppState fJ() {
        return this;
    }

    public /* synthetic */ Object freeze() {
        return fJ();
    }

    public byte[] getConflictData() {
        return this.DP;
    }

    public String getConflictVersion() {
        return this.DO;
    }

    public int getKey() {
        return this.DK;
    }

    public byte[] getLocalData() {
        return this.DM;
    }

    public String getLocalVersion() {
        return this.DL;
    }

    public boolean hasConflict() {
        return this.DN;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }
}
