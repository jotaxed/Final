package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE = lp.RQ;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME = lp.RR;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE = lp.RT;
    public static final SortableMetadataField<Date> MODIFIED_DATE = lp.RS;
    public static final SortableMetadataField<Long> QUOTA_USED = ln.RG;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE = lp.RU;
    public static final SortableMetadataField<String> TITLE = ln.RJ;
}
