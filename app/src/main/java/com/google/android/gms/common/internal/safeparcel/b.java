package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.request.GameRequest;
import java.util.List;

public class b {
    private static int F(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void G(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static int H(Parcel parcel) {
        return F(parcel, 20293);
    }

    public static void H(Parcel parcel, int i) {
        G(parcel, i);
    }

    public static void a(Parcel parcel, int i, byte b) {
        b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void a(Parcel parcel, int i, double d) {
        b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void a(Parcel parcel, int i, float f) {
        b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void a(Parcel parcel, int i, long j) {
        b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int F = F(parcel, i);
            parcel.writeBundle(bundle);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int F = F(parcel, i);
            parcel.writeStrongBinder(iBinder);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int F = F(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int F = F(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int F = F(parcel, i);
            parcel.writeString(str);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int F = F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, short s) {
        b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void a(Parcel parcel, int i, boolean z) {
        b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int F = F(parcel, i);
            parcel.writeByteArray(bArr);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int F = F(parcel, i);
            parcel.writeIntArray(iArr);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int F = F(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, parcelable, i2);
                }
            }
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int F = F(parcel, i);
            parcel.writeStringArray(strArr);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int F = F(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void b(Parcel parcel, int i, int i2) {
        if (i2 >= GameRequest.TYPE_ALL) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int F = F(parcel, i);
            parcel.writeStringList(list);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void c(Parcel parcel, int i, int i2) {
        b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static <T extends Parcelable> void c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int F = F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, parcelable, 0);
                }
            }
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int F = F(parcel, i);
            parcel.writeList(list);
            G(parcel, F);
        } else if (z) {
            b(parcel, i, 0);
        }
    }
}
