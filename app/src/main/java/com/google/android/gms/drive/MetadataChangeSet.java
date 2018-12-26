package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet OE = new MetadataChangeSet(MetadataBundle.iZ());
    private final MetadataBundle OF;

    public static class Builder {
        private final MetadataBundle OF = MetadataBundle.iZ();
        private a OG;

        private int bk(String str) {
            return str == null ? 0 : str.getBytes().length;
        }

        private String i(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private a iA() {
            if (this.OG == null) {
                this.OG = new a();
            }
            return this.OG;
        }

        private void j(String str, int i, int i2) {
            jx.b(i2 <= i, i(str, i, i2));
        }

        public MetadataChangeSet build() {
            if (this.OG != null) {
                this.OF.b(ln.Rl, this.OG.iW());
            }
            return new MetadataChangeSet(this.OF);
        }

        public Builder deleteCustomProperty(CustomPropertyKey key) {
            jx.b((Object) key, (Object) "key");
            iA().a(key, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey key, String value) {
            jx.b((Object) key, (Object) "key");
            jx.b((Object) value, (Object) "value");
            j("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, bk(key.getKey()) + bk(value));
            iA().a(key, value);
            return this;
        }

        public Builder setDescription(String description) {
            this.OF.b(ln.Rm, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            j("Indexable text size", 131072, bk(text));
            this.OF.b(ln.Rr, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.OF.b(lp.RR, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.OF.b(ln.RA, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.OF.b(ln.Rv, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.OF.b(ln.RH, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.OF.b(ln.RJ, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.OF.b(ln.Rz, Boolean.valueOf(viewed));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.OF = MetadataBundle.a(bag);
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.OF.a(ln.Rl);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.iV();
    }

    public String getDescription() {
        return (String) this.OF.a(ln.Rm);
    }

    public String getIndexableText() {
        return (String) this.OF.a(ln.Rr);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.OF.a(lp.RR);
    }

    public String getMimeType() {
        return (String) this.OF.a(ln.RA);
    }

    public String getTitle() {
        return (String) this.OF.a(ln.RJ);
    }

    public Boolean isPinned() {
        return (Boolean) this.OF.a(ln.Rv);
    }

    public Boolean isStarred() {
        return (Boolean) this.OF.a(ln.RH);
    }

    public Boolean isViewed() {
        return (Boolean) this.OF.a(ln.Rz);
    }

    public MetadataBundle iz() {
        return this.OF;
    }
}
