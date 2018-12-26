package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

@ey
public final class dg {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] rb = new int[Gender.values().length];

        static {
            rc = new int[ErrorCode.values().length];
            try {
                rc[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rc[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rc[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rc[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                rb[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                rb[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                rb[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int a(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize b(ay ayVar) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == ayVar.width && adSizeArr[i].getHeight() == ayVar.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(a.a(ayVar.width, ayVar.height, ayVar.op));
    }

    public static MediationAdRequest d(av avVar) {
        return new MediationAdRequest(new Date(avVar.od), l(avVar.oe), avVar.of != null ? new HashSet(avVar.of) : null, avVar.og, avVar.ol);
    }

    public static Gender l(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
