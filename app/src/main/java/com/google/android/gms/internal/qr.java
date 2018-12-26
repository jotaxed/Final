package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class qr<M extends qq<M>, T> {
    protected final Class<T> ayX;
    protected final boolean ayY;
    public final int tag;
    protected final int type;

    private qr(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.ayX = cls;
        this.tag = i2;
        this.ayY = z;
    }

    public static <M extends qq<M>, T extends qw> qr<M, T> a(int i, Class<T> cls, int i2) {
        return new qr(i, cls, i2, false);
    }

    private T n(List<qy> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            qy qyVar = (qy) list.get(i);
            if (qyVar.azi.length != 0) {
                a(qyVar, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.ayX.cast(Array.newInstance(this.ayX.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T o(List<qy> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.ayX.cast(x(qo.p(((qy) list.get(list.size() - 1)).azi)));
    }

    int B(Object obj) {
        return this.ayY ? C(obj) : D(obj);
    }

    protected int C(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += D(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int D(Object obj) {
        int hl = qz.hl(this.tag);
        switch (this.type) {
            case 10:
                return qp.b(hl, (qw) obj);
            case 11:
                return qp.c(hl, (qw) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void a(qy qyVar, List<Object> list) {
        list.add(x(qo.p(qyVar.azi)));
    }

    void a(Object obj, qp qpVar) throws IOException {
        if (this.ayY) {
            c(obj, qpVar);
        } else {
            b(obj, qpVar);
        }
    }

    protected void b(Object obj, qp qpVar) {
        try {
            qpVar.hd(this.tag);
            switch (this.type) {
                case 10:
                    qw qwVar = (qw) obj;
                    int hl = qz.hl(this.tag);
                    qpVar.b(qwVar);
                    qpVar.x(hl, 4);
                    return;
                case 11:
                    qpVar.c((qw) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected void c(Object obj, qp qpVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                b(obj2, qpVar);
            }
        }
    }

    final T m(List<qy> list) {
        return list == null ? null : this.ayY ? n(list) : o(list);
    }

    protected Object x(qo qoVar) {
        Class componentType = this.ayY ? this.ayX.getComponentType() : this.ayX;
        try {
            qw qwVar;
            switch (this.type) {
                case 10:
                    qwVar = (qw) componentType.newInstance();
                    qoVar.a(qwVar, qz.hl(this.tag));
                    return qwVar;
                case 11:
                    qwVar = (qw) componentType.newInstance();
                    qoVar.a(qwVar);
                    return qwVar;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }
}
