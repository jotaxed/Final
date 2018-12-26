package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final f CREATOR = new f();
    private static final a Ll = new a(new String[0], null) {
    };
    private final int CK;
    private final int Iv;
    private final String[] Ld;
    Bundle Le;
    private final CursorWindow[] Lf;
    private final Bundle Lg;
    int[] Lh;
    int Li;
    private Object Lj;
    private boolean Lk;
    boolean mClosed;

    public static class a {
        private final String[] Ld;
        private final ArrayList<HashMap<String, Object>> Lm;
        private final String Ln;
        private final HashMap<Object, Integer> Lo;
        private boolean Lp;
        private String Lq;

        private a(String[] strArr, String str) {
            this.Ld = (String[]) jx.i(strArr);
            this.Lm = new ArrayList();
            this.Ln = str;
            this.Lo = new HashMap();
            this.Lp = false;
            this.Lq = null;
        }
    }

    public static class b extends RuntimeException {
        public b(String str) {
            super(str);
        }
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.Lk = true;
        this.CK = versionCode;
        this.Ld = columns;
        this.Lf = windows;
        this.Iv = statusCode;
        this.Lg = metadata;
    }

    private DataHolder(a builder, int statusCode, Bundle metadata) {
        this(builder.Ld, a(builder, -1), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.Lk = true;
        this.CK = 1;
        this.Ld = (String[]) jx.i(columns);
        this.Lf = (CursorWindow[]) jx.i(windows);
        this.Iv = statusCode;
        this.Lg = metadata;
        gX();
    }

    public static DataHolder a(int i, Bundle bundle) {
        return new DataHolder(Ll, i, bundle);
    }

    private static CursorWindow[] a(a aVar, int i) {
        int size;
        int i2 = 0;
        if (aVar.Ld.length == 0) {
            return new CursorWindow[0];
        }
        List b = (i < 0 || i >= aVar.Lm.size()) ? aVar.Lm : aVar.Lm.subList(0, i);
        int size2 = b.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(aVar.Ld.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            if (!cursorWindow.allocRow()) {
                Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                cursorWindow = new CursorWindow(false);
                cursorWindow.setStartPosition(i3);
                cursorWindow.setNumColumns(aVar.Ld.length);
                arrayList.add(cursorWindow);
                if (!cursorWindow.allocRow()) {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                Map map = (Map) b.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < aVar.Ld.length && z; i7++) {
                    String str = aVar.Ld[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new b("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(aVar.Ld.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                size = arrayList.size();
                while (i2 < size) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder av(int i) {
        return a(i, null);
    }

    private void g(String str, int i) {
        if (this.Le == null || !this.Le.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.Li) {
            throw new CursorIndexOutOfBoundsException(i, this.Li);
        }
    }

    public long a(String str, int i, int i2) {
        g(str, i);
        return this.Lf[i2].getLong(i, this.Le.getInt(str));
    }

    public void a(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        g(str, i);
        this.Lf[i2].copyStringToBuffer(i, this.Le.getInt(str), charArrayBuffer);
    }

    public boolean aQ(String str) {
        return this.Le.containsKey(str);
    }

    public int au(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.Li;
        jx.K(z);
        while (i2 < this.Lh.length) {
            if (i < this.Lh[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.Lh.length ? i2 - 1 : i2;
    }

    public int b(String str, int i, int i2) {
        g(str, i);
        return this.Lf[i2].getInt(i, this.Le.getInt(str));
    }

    public String c(String str, int i, int i2) {
        g(str, i);
        return this.Lf[i2].getString(i, this.Le.getInt(str));
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.Lf) {
                    close.close();
                }
            }
        }
    }

    public boolean d(String str, int i, int i2) {
        g(str, i);
        return Long.valueOf(this.Lf[i2].getLong(i, this.Le.getInt(str))).longValue() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public float e(String str, int i, int i2) {
        g(str, i);
        return this.Lf[i2].getFloat(i, this.Le.getInt(str));
    }

    public void e(Object obj) {
        this.Lj = obj;
    }

    public byte[] f(String str, int i, int i2) {
        g(str, i);
        return this.Lf[i2].getBlob(i, this.Le.getInt(str));
    }

    protected void finalize() throws Throwable {
        try {
            if (this.Lk && this.Lf.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.Lj == null ? "internal object: " + toString() : this.Lj.toString()) + ")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public Uri g(String str, int i, int i2) {
        String c = c(str, i, i2);
        return c == null ? null : Uri.parse(c);
    }

    public Bundle gV() {
        return this.Lg;
    }

    public void gX() {
        int i;
        int i2 = 0;
        this.Le = new Bundle();
        for (i = 0; i < this.Ld.length; i++) {
            this.Le.putInt(this.Ld[i], i);
        }
        this.Lh = new int[this.Lf.length];
        i = 0;
        while (i2 < this.Lf.length) {
            this.Lh[i2] = i;
            i += this.Lf[i2].getNumRows() - (i - this.Lf[i2].getStartPosition());
            i2++;
        }
        this.Li = i;
    }

    String[] gY() {
        return this.Ld;
    }

    CursorWindow[] gZ() {
        return this.Lf;
    }

    public int getCount() {
        return this.Li;
    }

    public int getStatusCode() {
        return this.Iv;
    }

    int getVersionCode() {
        return this.CK;
    }

    public boolean h(String str, int i, int i2) {
        g(str, i);
        return this.Lf[i2].isNull(i, this.Le.getInt(str));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel dest, int flags) {
        f.a(this, dest, flags);
    }
}
