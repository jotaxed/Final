package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class cb implements at {
    private static final String BS = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private final String BV;
    private long BX;
    private final int BY;
    private final b asf;
    private volatile ab asg;
    private final au ash;
    private final Context mContext;
    private ld wb;

    class a implements com.google.android.gms.tagmanager.db.a {
        final /* synthetic */ cb asi;

        a(cb cbVar) {
            this.asi = cbVar;
        }

        public void a(ap apVar) {
            this.asi.y(apVar.fb());
        }

        public void b(ap apVar) {
            this.asi.y(apVar.fb());
            bh.V("Permanent failure dispatching hitId: " + apVar.fb());
        }

        public void c(ap apVar) {
            long pK = apVar.pK();
            if (pK == 0) {
                this.asi.c(apVar.fb(), this.asi.wb.currentTimeMillis());
            } else if (pK + 14400000 < this.asi.wb.currentTimeMillis()) {
                this.asi.y(apVar.fb());
                bh.V("Giving up on failed hitId: " + apVar.fb());
            }
        }
    }

    class b extends SQLiteOpenHelper {
        private boolean BZ;
        private long Ca = 0;
        final /* synthetic */ cb asi;

        b(cb cbVar, Context context, String str) {
            this.asi = cbVar;
            super(context, str, null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        bh.W("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                bh.W("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.BZ || this.Ca + 3600000 <= this.asi.wb.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.BZ = true;
                this.Ca = this.asi.wb.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.asi.mContext.getDatabasePath(this.asi.BV).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.BZ = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            ak.ag(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (a("gtm_hits", db)) {
                a(db);
            } else {
                db.execSQL(cb.BS);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    cb(au auVar, Context context) {
        this(auVar, context, "gtm_urls.db", 2000);
    }

    cb(au auVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.BV = str;
        this.ash = auVar;
        this.wb = lf.if();
        this.asf = new b(this, this.mContext, this.BV);
        this.asg = new db(new DefaultHttpClient(), this.mContext, new a(this));
        this.BX = 0;
        this.BY = i;
    }

    private SQLiteDatabase al(String str) {
        try {
            return this.asf.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.W(str);
            return null;
        }
    }

    private void c(long j, long j2) {
        SQLiteDatabase al = al("Error opening database for getNumStoredHits.");
        if (al != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                al.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                bh.W("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                y(j);
            }
        }
    }

    private void fh() {
        int fj = (fj() - this.BY) + 1;
        if (fj > 0) {
            List G = G(fj);
            bh.V("Store full, deleting " + G.size() + " hits to make room.");
            b((String[]) G.toArray(new String[0]));
        }
    }

    private void g(long j, String str) {
        SQLiteDatabase al = al("Error opening database for putHit");
        if (al != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                al.insert("gtm_hits", null, contentValues);
                this.ash.B(false);
            } catch (SQLiteException e) {
                bh.W("Error storing hit");
            }
        }
    }

    private void y(long j) {
        b(new String[]{String.valueOf(j)});
    }

    List<String> G(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.W("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase al = al("Error opening database for peekHitIds.");
        if (al == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = al.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    bh.W("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            bh.W("Error in peekHits fetching hitIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.ap> H(int r17) {
        /*
        r16 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.al(r2);
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r2 = r11;
    L_0x0010:
        return r2;
    L_0x0011:
        r12 = 0;
        r3 = "gtm_hits";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 2;
        r6 = "hit_first_send_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0171, all -> 0x016b }
        r12.<init>();	 Catch:{ SQLiteException -> 0x0171, all -> 0x016b }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        if (r3 == 0) goto L_0x0068;
    L_0x004b:
        r3 = new com.google.android.gms.tagmanager.ap;	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r4 = 0;
        r4 = r13.getLong(r4);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r6 = 1;
        r6 = r13.getLong(r6);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r8 = 2;
        r8 = r13.getLong(r8);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r3.<init>(r4, r6, r8);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r12.add(r3);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        if (r3 != 0) goto L_0x004b;
    L_0x0068:
        if (r13 == 0) goto L_0x006d;
    L_0x006a:
        r13.close();
    L_0x006d:
        r11 = 0;
        r3 = "gtm_hits";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 1;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0169 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x0169 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0169 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x0169 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0169 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r2 == 0) goto L_0x00c2;
    L_0x009d:
        r4 = r11;
    L_0x009e:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r2 <= 0) goto L_0x00f6;
    L_0x00ac:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = (com.google.android.gms.tagmanager.ap) r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2.ak(r5);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
    L_0x00ba:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r4 != 0) goto L_0x017d;
    L_0x00c2:
        if (r3 == 0) goto L_0x00c7;
    L_0x00c4:
        r3.close();
    L_0x00c7:
        r2 = r12;
        goto L_0x0010;
    L_0x00ca:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00ce:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016e }
        r5.<init>();	 Catch:{ all -> 0x016e }
        r6 = "Error in peekHits fetching hitIds: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x016e }
        r3 = r3.getMessage();	 Catch:{ all -> 0x016e }
        r3 = r5.append(r3);	 Catch:{ all -> 0x016e }
        r3 = r3.toString();	 Catch:{ all -> 0x016e }
        com.google.android.gms.tagmanager.bh.W(r3);	 Catch:{ all -> 0x016e }
        if (r4 == 0) goto L_0x0010;
    L_0x00ea:
        r4.close();
        goto L_0x0010;
    L_0x00ef:
        r2 = move-exception;
    L_0x00f0:
        if (r12 == 0) goto L_0x00f5;
    L_0x00f2:
        r12.close();
    L_0x00f5:
        throw r2;
    L_0x00f6:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = (com.google.android.gms.tagmanager.ap) r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r8 = r2.fb();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        com.google.android.gms.tagmanager.bh.W(r2);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        goto L_0x00ba;
    L_0x0114:
        r2 = move-exception;
        r13 = r3;
    L_0x0116:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015f }
        r3.<init>();	 Catch:{ all -> 0x015f }
        r4 = "Error in peekHits fetching hit url: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x015f }
        r2 = r2.getMessage();	 Catch:{ all -> 0x015f }
        r2 = r3.append(r2);	 Catch:{ all -> 0x015f }
        r2 = r2.toString();	 Catch:{ all -> 0x015f }
        com.google.android.gms.tagmanager.bh.W(r2);	 Catch:{ all -> 0x015f }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x015f }
        r3.<init>();	 Catch:{ all -> 0x015f }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x015f }
    L_0x013a:
        r2 = r5.hasNext();	 Catch:{ all -> 0x015f }
        if (r2 == 0) goto L_0x0152;
    L_0x0140:
        r2 = r5.next();	 Catch:{ all -> 0x015f }
        r2 = (com.google.android.gms.tagmanager.ap) r2;	 Catch:{ all -> 0x015f }
        r6 = r2.pL();	 Catch:{ all -> 0x015f }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x015f }
        if (r6 == 0) goto L_0x015b;
    L_0x0150:
        if (r4 == 0) goto L_0x015a;
    L_0x0152:
        if (r13 == 0) goto L_0x0157;
    L_0x0154:
        r13.close();
    L_0x0157:
        r2 = r3;
        goto L_0x0010;
    L_0x015a:
        r4 = 1;
    L_0x015b:
        r3.add(r2);	 Catch:{ all -> 0x015f }
        goto L_0x013a;
    L_0x015f:
        r2 = move-exception;
    L_0x0160:
        if (r13 == 0) goto L_0x0165;
    L_0x0162:
        r13.close();
    L_0x0165:
        throw r2;
    L_0x0166:
        r2 = move-exception;
        r13 = r3;
        goto L_0x0160;
    L_0x0169:
        r2 = move-exception;
        goto L_0x0116;
    L_0x016b:
        r2 = move-exception;
        r12 = r13;
        goto L_0x00f0;
    L_0x016e:
        r2 = move-exception;
        r12 = r4;
        goto L_0x00f0;
    L_0x0171:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00ce;
    L_0x0177:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00ce;
    L_0x017d:
        r4 = r2;
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cb.H(int):java.util.List<com.google.android.gms.tagmanager.ap>");
    }

    void b(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase al = al("Error opening database for deleteHits.");
            if (al != null) {
                try {
                    al.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    au auVar = this.ash;
                    if (fj() != 0) {
                        z = false;
                    }
                    auVar.B(z);
                } catch (SQLiteException e) {
                    bh.W("Error deleting hits");
                }
            }
        }
    }

    public void dispatch() {
        bh.V("GTM Dispatch running...");
        if (this.asg.ea()) {
            List H = H(40);
            if (H.isEmpty()) {
                bh.V("...nothing to dispatch");
                this.ash.B(true);
                return;
            }
            this.asg.k(H);
            if (pY() > 0) {
                cy.qN().dispatch();
            }
        }
    }

    public void f(long j, String str) {
        fi();
        fh();
        g(j, str);
    }

    int fi() {
        boolean z = true;
        long currentTimeMillis = this.wb.currentTimeMillis();
        if (currentTimeMillis <= this.BX + 86400000) {
            return 0;
        }
        this.BX = currentTimeMillis;
        SQLiteDatabase al = al("Error opening database for deleteStaleHits.");
        if (al == null) {
            return 0;
        }
        int delete = al.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.wb.currentTimeMillis() - 2592000000L)});
        au auVar = this.ash;
        if (fj() != 0) {
            z = false;
        }
        auVar.B(z);
        return delete;
    }

    int fj() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = al("Error opening database for getNumStoredHits.");
        if (al != null) {
            try {
                cursor = al.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.W("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    int pY() {
        int count;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        SQLiteDatabase al = al("Error opening database for getNumStoredHits.");
        if (al == null) {
            return 0;
        }
        try {
            Cursor query = al.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = query.getCount();
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    bh.W("Error getting num untried hits");
                    if (cursor == null) {
                        count = 0;
                    } else {
                        cursor.close();
                        count = 0;
                    }
                    return count;
                } catch (Throwable th2) {
                    cursor2 = cursor;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            cursor = null;
            bh.W("Error getting num untried hits");
            if (cursor == null) {
                cursor.close();
                count = 0;
            } else {
                count = 0;
            }
            return count;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return count;
    }
}
