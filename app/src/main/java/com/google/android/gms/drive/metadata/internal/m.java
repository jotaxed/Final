package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class m extends j<UserMetadata> {
    public m(String str, int i) {
        super(str, bp(str), Collections.emptyList(), i);
    }

    private String bo(String str) {
        return q(getName(), str);
    }

    private static Collection<String> bp(String str) {
        return Arrays.asList(new String[]{q(str, "permissionId"), q(str, "displayName"), q(str, "picture"), q(str, "isAuthenticatedUser"), q(str, "emailAddress")});
    }

    private static String q(String str, String str2) {
        return "." + str2;
    }

    protected boolean b(DataHolder dataHolder, int i, int i2) {
        return !dataHolder.h(bo("permissionId"), i, i2);
    }

    protected /* synthetic */ Object c(DataHolder dataHolder, int i, int i2) {
        return j(dataHolder, i, i2);
    }

    protected UserMetadata j(DataHolder dataHolder, int i, int i2) {
        String c = dataHolder.c(bo("permissionId"), i, i2);
        if (c == null) {
            return null;
        }
        String c2 = dataHolder.c(bo("displayName"), i, i2);
        String c3 = dataHolder.c(bo("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.d(bo("isAuthenticatedUser"), i, i2));
        return new UserMetadata(c, c2, c3, valueOf.booleanValue(), dataHolder.c(bo("emailAddress"), i, i2));
    }
}
