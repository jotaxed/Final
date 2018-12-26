package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class i extends h {
    private static Method kA;
    private static Method kB;
    private static Method kC;
    private static Method kD;
    private static Method kE;
    private static Method kF;
    private static Method kG;
    private static Method kH;
    private static Method kI;
    private static String kJ;
    private static String kK;
    private static String kL;
    private static o kM;
    static boolean kN = false;
    private static long startTime = 0;

    static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    protected i(Context context, m mVar, n nVar) {
        super(context, mVar, nVar);
    }

    static String a(Context context, m mVar) throws a {
        if (kK != null) {
            return kK;
        }
        if (kD == null) {
            throw new a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kD.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new a();
            }
            kK = mVar.a(byteBuffer.array(), true);
            return kK;
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static ArrayList<Long> a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws a {
        if (kE == null || motionEvent == null) {
            throw new a();
        }
        try {
            return (ArrayList) kE.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    protected static synchronized void a(String str, Context context, m mVar) {
        synchronized (i.class) {
            if (!kN) {
                try {
                    kM = new o(mVar, null);
                    kJ = str;
                    g(context);
                    startTime = w().longValue();
                    kN = true;
                } catch (a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String b(Context context, m mVar) throws a {
        if (kL != null) {
            return kL;
        }
        if (kG == null) {
            throw new a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kG.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new a();
            }
            kL = mVar.a(byteBuffer.array(), true);
            return kL;
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    private static String b(byte[] bArr, String str) throws a {
        try {
            return new String(kM.c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static String d(Context context) throws a {
        if (kF == null) {
            throw new a();
        }
        try {
            String str = (String) kF.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new a();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static ArrayList<Long> e(Context context) throws a {
        if (kH == null) {
            throw new a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) kH.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new a();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static int[] f(Context context) throws a {
        if (kI == null) {
            throw new a();
        }
        try {
            return (int[]) kI.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    private static void g(Context context) throws a {
        File file;
        File createTempFile;
        try {
            byte[] b = kM.b(q.getKey());
            byte[] c = kM.c(b, q.E());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new a();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(b(b, q.H()));
            Class loadClass2 = dexClassLoader.loadClass(b(b, q.T()));
            Class loadClass3 = dexClassLoader.loadClass(b(b, q.N()));
            Class loadClass4 = dexClassLoader.loadClass(b(b, q.L()));
            Class loadClass5 = dexClassLoader.loadClass(b(b, q.V()));
            Class loadClass6 = dexClassLoader.loadClass(b(b, q.J()));
            Class loadClass7 = dexClassLoader.loadClass(b(b, q.R()));
            Class loadClass8 = dexClassLoader.loadClass(b(b, q.P()));
            Class loadClass9 = dexClassLoader.loadClass(b(b, q.F()));
            kA = loadClass.getMethod(b(b, q.I()), new Class[0]);
            kB = loadClass2.getMethod(b(b, q.U()), new Class[0]);
            kC = loadClass3.getMethod(b(b, q.O()), new Class[0]);
            kD = loadClass4.getMethod(b(b, q.M()), new Class[]{Context.class});
            kE = loadClass5.getMethod(b(b, q.W()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            kF = loadClass6.getMethod(b(b, q.K()), new Class[]{Context.class});
            kG = loadClass7.getMethod(b(b, q.S()), new Class[]{Context.class});
            kH = loadClass8.getMethod(b(b, q.Q()), new Class[]{Context.class});
            kI = loadClass9.getMethod(b(b, q.G()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        } catch (Throwable e22) {
            throw new a(e22);
        } catch (Throwable e222) {
            throw new a(e222);
        } catch (Throwable e2222) {
            throw new a(e2222);
        } catch (Throwable e22222) {
            throw new a(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    static String v() throws a {
        if (kJ != null) {
            return kJ;
        }
        throw new a();
    }

    static Long w() throws a {
        if (kA == null) {
            throw new a();
        }
        try {
            return (Long) kA.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static String x() throws a {
        if (kC == null) {
            throw new a();
        }
        try {
            return (String) kC.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static Long y() throws a {
        if (kB == null) {
            throw new a();
        }
        try {
            return (Long) kB.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void b(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = x();	 Catch:{ a -> 0x00a1, IOException -> 0x0090 }
        r6.a(r0, r1);	 Catch:{ a -> 0x00a1, IOException -> 0x0090 }
    L_0x0008:
        r0 = 2;
        r1 = v();	 Catch:{ a -> 0x009e, IOException -> 0x0090 }
        r6.a(r0, r1);	 Catch:{ a -> 0x009e, IOException -> 0x0090 }
    L_0x0010:
        r0 = w();	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r2 = 25;
        r6.a(r2, r0);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r2 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r4 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = r0 - r4;
        r6.a(r2, r0);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = 23;
        r2 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r6.a(r0, r2);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
    L_0x0034:
        r1 = e(r7);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r2 = 31;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r4 = r0.longValue();	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r6.a(r2, r4);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r2 = 32;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r6.a(r2, r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
    L_0x0058:
        r0 = 33;
        r1 = y();	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
        r2 = r1.longValue();	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
        r6.a(r0, r2);	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
    L_0x0065:
        r0 = 27;
        r1 = r6.ky;	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
        r1 = a(r7, r1);	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
        r6.a(r0, r1);	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
    L_0x0070:
        r0 = 29;
        r1 = r6.ky;	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
        r1 = b(r7, r1);	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
        r6.a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
    L_0x007b:
        r0 = f(r7);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r1 = 5;
        r2 = 0;
        r2 = r0[r2];	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r2;	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r6.a(r1, r2);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r1 = 6;
        r2 = 1;
        r0 = r0[r2];	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r0;	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r6.a(r1, r2);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
    L_0x008f:
        return;
    L_0x0090:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0092:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0094:
        r0 = move-exception;
        goto L_0x007b;
    L_0x0096:
        r0 = move-exception;
        goto L_0x0070;
    L_0x0098:
        r0 = move-exception;
        goto L_0x0065;
    L_0x009a:
        r0 = move-exception;
        goto L_0x0058;
    L_0x009c:
        r0 = move-exception;
        goto L_0x0034;
    L_0x009e:
        r0 = move-exception;
        goto L_0x0010;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.b(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void c(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = v();	 Catch:{ a -> 0x0065, IOException -> 0x005d }
        r6.a(r0, r1);	 Catch:{ a -> 0x0065, IOException -> 0x005d }
    L_0x0008:
        r0 = 1;
        r1 = x();	 Catch:{ a -> 0x0063, IOException -> 0x005d }
        r6.a(r0, r1);	 Catch:{ a -> 0x0063, IOException -> 0x005d }
    L_0x0010:
        r0 = 25;
        r1 = w();	 Catch:{ a -> 0x0061, IOException -> 0x005d }
        r2 = r1.longValue();	 Catch:{ a -> 0x0061, IOException -> 0x005d }
        r6.a(r0, r2);	 Catch:{ a -> 0x0061, IOException -> 0x005d }
    L_0x001d:
        r0 = r6.kw;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r1 = r6.kx;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r1 = a(r0, r1);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r4 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r6.a(r2, r4);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r4 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r6.a(r2, r4);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = r1.size();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 3;
        if (r0 < r2) goto L_0x005c;
    L_0x004c:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r6.a(r2, r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
    L_0x005c:
        return;
    L_0x005d:
        r0 = move-exception;
        goto L_0x005c;
    L_0x005f:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0061:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.c(android.content.Context):void");
    }
}
