package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;
import java.util.List;

@ey
public class eh {
    private static final Object mH = new Object();
    private static final String sZ = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
    private static eh tb;
    private final a ta;

    public class a extends SQLiteOpenHelper {
        final /* synthetic */ eh tc;

        public a(eh ehVar, Context context, String str) {
            this.tc = ehVar;
            super(context, str, null, 4);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(eh.sZ);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            gr.U("Database updated from version " + oldVersion + " to version " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(db);
        }
    }

    private eh(Context context) {
        this.ta = new a(this, context, "google_inapp_purchase.db");
    }

    public static eh j(Context context) {
        eh ehVar;
        synchronized (mH) {
            if (tb == null) {
                tb = new eh(context);
            }
            ehVar = tb;
        }
        return ehVar;
    }

    public ef a(Cursor cursor) {
        return cursor == null ? null : new ef(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void a(ef efVar) {
        if (efVar != null) {
            synchronized (mH) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                writableDatabase.delete("InAppPurchase", String.format("%s = %d", new Object[]{"purchase_id", Long.valueOf(efVar.sT)}), null);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.google.android.gms.internal.ef r7) {
        /*
        r6 = this;
        if (r7 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = mH;
        monitor-enter(r1);
        r0 = r6.getWritableDatabase();	 Catch:{ all -> 0x000e }
        if (r0 != 0) goto L_0x0011;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0002;
    L_0x000e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        throw r0;
    L_0x0011:
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x000e }
        r2.<init>();	 Catch:{ all -> 0x000e }
        r3 = "product_id";
        r4 = r7.sV;	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "developer_payload";
        r4 = r7.sU;	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "record_time";
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x000e }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "InAppPurchase";
        r4 = 0;
        r2 = r0.insert(r3, r4, r2);	 Catch:{ all -> 0x000e }
        r7.sT = r2;	 Catch:{ all -> 0x000e }
        r0 = r6.getRecordCount();	 Catch:{ all -> 0x000e }
        r2 = (long) r0;	 Catch:{ all -> 0x000e }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0048;
    L_0x0045:
        r6.cA();	 Catch:{ all -> 0x000e }
    L_0x0048:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0002;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.eh.b(com.google.android.gms.internal.ef):void");
    }

    public void cA() {
        Cursor query;
        SQLiteException e;
        Throwable th;
        synchronized (mH) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                query = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            a(a(query));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            gr.W("Error remove oldest record" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                gr.W("Error remove oldest record" + e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    public List<ef> d(long j) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        synchronized (mH) {
            List<ef> linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return linkedList;
            }
            try {
                query = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                try {
                    if (query.moveToFirst()) {
                        do {
                            linkedList.add(a(query));
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        gr.W("Error extracing purchase info: " + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
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
                gr.W("Error extracing purchase info: " + e.getMessage());
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    public int getRecordCount() {
        Cursor cursor = null;
        int i = 0;
        synchronized (mH) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
            } else {
                try {
                    cursor = writableDatabase.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    gr.W("Error getting record count" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.ta.getWritableDatabase();
        } catch (SQLiteException e) {
            gr.W("Error opening writable conversion tracking database");
            return null;
        }
    }
}
