package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = ln.Rv;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = lp.RR;
    public static final SearchableMetadataField<String> MIME_TYPE = ln.RA;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = lp.RS;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = ln.RF;
    public static final SearchableMetadataField<Boolean> STARRED = ln.RH;
    public static final SearchableOrderedMetadataField<Date> Sd = lp.RU;
    public static final SearchableMetadataField<AppVisibleCustomProperties> Se = ln.Rl;
    public static final SearchableMetadataField<String> TITLE = ln.RJ;
    public static final SearchableMetadataField<Boolean> TRASHED = ln.RK;
}
