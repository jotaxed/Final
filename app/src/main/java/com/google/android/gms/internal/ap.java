package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.as.a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class ap {
    private final int nT;
    private final int nU;
    private final ao nV = new ar();
    private Base64OutputStream nW;
    private ByteArrayOutputStream nX;

    public ap(int i) {
        this.nU = i;
        this.nT = 6;
    }

    private String m(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.nX = new ByteArrayOutputStream();
        this.nW = new Base64OutputStream(this.nX, 10);
        Arrays.sort(split, new Comparator<String>(this) {
            final /* synthetic */ ap nY;

            {
                this.nY = r1;
            }

            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        int i = 0;
        while (i < split.length && i < this.nU) {
            if (split[i].trim().length() != 0) {
                try {
                    this.nW.write(this.nV.l(split[i]));
                } catch (Throwable e) {
                    gr.b("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        try {
            this.nW.flush();
            this.nW.close();
            return this.nX.toString();
        } catch (Throwable e2) {
            gr.b("HashManager: Unable to convert to base 64", e2);
            return "";
        }
    }

    public String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (null) {
            case null:
                return n(stringBuffer.toString());
            case 1:
                return m(stringBuffer.toString());
            default:
                return "";
        }
    }

    String n(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.nX = new ByteArrayOutputStream();
        this.nW = new Base64OutputStream(this.nX, 10);
        PriorityQueue priorityQueue = new PriorityQueue(this.nU, new Comparator<a>(this) {
            final /* synthetic */ ap nY;

            {
                this.nY = r1;
            }

            public int a(a aVar, a aVar2) {
                return (int) (aVar.value - aVar2.value);
            }

            public /* synthetic */ int compare(Object x0, Object x1) {
                return a((a) x0, (a) x1);
            }
        });
        for (String p : split) {
            String[] p2 = aq.p(p);
            if (p2.length >= this.nT) {
                as.a(p2, this.nU, this.nT, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                this.nW.write(this.nV.l(((a) it.next()).oa));
            } catch (Throwable e) {
                gr.b("Error while writing hash to byteStream", e);
            }
        }
        try {
            this.nW.flush();
            this.nW.close();
            return this.nX.toString();
        } catch (Throwable e2) {
            gr.b("HashManager: unable to convert to base 64", e2);
            return "";
        }
    }
}
