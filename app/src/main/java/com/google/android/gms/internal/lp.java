package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

public class lp {
    public static final a RQ = new a("created", 4100000);
    public static final b RR = new b("lastOpenedTime", 4300000);
    public static final d RS = new d("modified", 4100000);
    public static final c RT = new c("modifiedByMe", 4100000);
    public static final e RU = new e("sharedWithMe", 4100000);

    public static class a extends com.google.android.gms.drive.metadata.internal.d implements SortableMetadataField<Date> {
        public a(String str, int i) {
            super(str, i);
        }
    }

    public static class b extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public b(String str, int i) {
            super(str, i);
        }
    }

    public static class c extends com.google.android.gms.drive.metadata.internal.d implements SortableMetadataField<Date> {
        public c(String str, int i) {
            super(str, i);
        }
    }

    public static class d extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public d(String str, int i) {
            super(str, i);
        }
    }

    public static class e extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public e(String str, int i) {
            super(str, i);
        }
    }
}
