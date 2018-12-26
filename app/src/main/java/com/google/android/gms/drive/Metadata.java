package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import com.google.android.gms.internal.lr;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    protected abstract <T> T a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) a(ln.Rk);
    }

    public int getContentAvailability() {
        Integer num = (Integer) a(lr.RW);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) a(lp.RQ);
    }

    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) a(ln.Rl);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.iV();
    }

    public String getDescription() {
        return (String) a(ln.Rm);
    }

    public DriveId getDriveId() {
        return (DriveId) a(ln.Rj);
    }

    public String getEmbedLink() {
        return (String) a(ln.Rn);
    }

    public String getFileExtension() {
        return (String) a(ln.Ro);
    }

    public long getFileSize() {
        return ((Long) a(ln.Rp)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) a(lp.RR);
    }

    public String getMimeType() {
        return (String) a(ln.RA);
    }

    public Date getModifiedByMeDate() {
        return (Date) a(lp.RT);
    }

    public Date getModifiedDate() {
        return (Date) a(lp.RS);
    }

    public String getOriginalFilename() {
        return (String) a(ln.RB);
    }

    public long getQuotaBytesUsed() {
        return ((Long) a(ln.RG)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) a(lp.RU);
    }

    public String getTitle() {
        return (String) a(ln.RJ);
    }

    public String getWebContentLink() {
        return (String) a(ln.RL);
    }

    public String getWebViewLink() {
        return (String) a(ln.RM);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) a(ln.Ru);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) a(ln.Rs);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) a(lr.RX);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) a(ln.Rv);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) a(ln.Rw);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) a(ln.Rx);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) a(ln.RH);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) a(ln.RK);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) a(ln.Rz);
        return bool == null ? false : bool.booleanValue();
    }
}
