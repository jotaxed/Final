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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class v implements c {
    private static final String ara = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Executor arb;
    private a arc;
    private int ard;
    private final Context mContext;
    private ld wb;

    class a extends SQLiteOpenHelper {
        final /* synthetic */ v arg;

        a(v vVar, Context context, String str) {
            this.arg = vVar;
            super(context, str, null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.arg.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
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
            if (a("datalayer", db)) {
                a(db);
            } else {
                db.execSQL(v.ara);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private static class b {
        final String KP;
        final byte[] arj;

        b(String str, byte[] bArr) {
            this.KP = str;
            this.arj = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.KP + " serialized hash = " + Arrays.hashCode(this.arj);
        }
    }

    public v(Context context) {
        this(context, lf.if(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    v(Context context, ld ldVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.wb = ldVar;
        this.ard = i;
        this.arb = executor;
        this.arc = new a(this, this.mContext, str);
    }

    private SQLiteDatabase al(String str) {
        try {
            return this.arc.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.W(str);
            return null;
        }
    }

    private synchronized void b(List<b> list, long j) {
        try {
            long currentTimeMillis = this.wb.currentTimeMillis();
            x(currentTimeMillis);
            fI(list.size());
            c(list, currentTimeMillis + j);
            pC();
        } catch (Throwable th) {
            pC();
        }
    }

    private void c(List<b> list, long j) {
        SQLiteDatabase al = al("Error opening database for writeEntryToDatabase.");
        if (al != null) {
            for (b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.KP);
                contentValues.put("value", bVar.arj);
                al.insert("datalayer", null, contentValues);
            }
        }
    }

    private void cA(String str) {
        SQLiteDatabase al = al("Error opening database for clearKeysWithPrefix.");
        if (al != null) {
            try {
                bh.V("Cleared " + al.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.W("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                pC();
            }
        }
    }

    private void fI(int i) {
        int pB = (pB() - this.ard) + i;
        if (pB > 0) {
            List fJ = fJ(pB);
            bh.U("DataLayer store full, deleting " + fJ.size() + " entries to make room.");
            h((String[]) fJ.toArray(new String[0]));
        }
    }

    private List<String> fJ(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.W("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase al = al("Error opening database for peekEntryIds.");
        if (al == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = al.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
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
                    bh.W("Error in peekEntries fetching entryIds: " + e.getMessage());
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
            bh.W("Error in peekEntries fetching entryIds: " + e.getMessage());
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

    private void h(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase al = al("Error opening database for deleteEntries.");
            if (al != null) {
                try {
                    al.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.W("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private List<a> i(List<b> list) {
        List<a> arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(new a(bVar.KP, j(bVar.arj)));
        }
        return arrayList;
    }

    private Object j(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<b> j(List<a> list) {
        List<b> arrayList = new ArrayList();
        for (a aVar : list) {
            arrayList.add(new b(aVar.KP, m(aVar.wF)));
        }
        return arrayList;
    }

    private byte[] m(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<b> pA() {
        SQLiteDatabase al = al("Error opening database for loadSerialized.");
        List<b> arrayList = new ArrayList();
        if (al == null) {
            return arrayList;
        }
        Cursor query = al.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int pB() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = al("Error opening database for getNumStoredEntries.");
        if (al != null) {
            try {
                cursor = al.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.W("Error getting numStoredEntries");
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

    private void pC() {
        try {
            this.arc.close();
        } catch (SQLiteException e) {
        }
    }

    private List<a> pz() {
        try {
            x(this.wb.currentTimeMillis());
            List<a> i = i(pA());
            return i;
        } finally {
            pC();
        }
    }

    private void x(long j) {
        SQLiteDatabase al = al("Error opening database for deleteOlderThan.");
        if (al != null) {
            try {
                bh.V("Deleted " + al.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.W("Error deleting old entries.");
            }
        }
    }

    public void a(final com.google.android.gms.tagmanager.DataLayer.c.a aVar) {
        this.arb.execute(new Runnable(this) {
            final /* synthetic */ v arg;

            public void run() {
                aVar.h(this.arg.pz());
            }
        });
    }

    public void a(List<a> list, final long j) {
        final List j2 = j((List) list);
        this.arb.execute(new Runnable(this) {
            final /* synthetic */ v arg;

            public void run() {
                this.arg.b(j2, j);
            }
        });
    }

    public void cz(final String str) {
        this.arb.execute(new Runnable(this) {
            final /* synthetic */ v arg;

            public void run() {
                this.arg.cA(str);
            }
        });
    }
}
