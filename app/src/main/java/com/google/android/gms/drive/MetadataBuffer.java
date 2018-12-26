package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.m;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.internal.ln;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private final String OB;
    private a OC;

    private static class a extends Metadata {
        private final DataHolder JG;
        private final int La;
        private final int OD;

        public a(DataHolder dataHolder, int i) {
            this.JG = dataHolder;
            this.OD = i;
            this.La = dataHolder.au(i);
        }

        protected <T> T a(MetadataField<T> metadataField) {
            return metadataField.a(this.JG, this.OD, this.La);
        }

        public /* synthetic */ Object freeze() {
            return iy();
        }

        public boolean isDataValid() {
            return !this.JG.isClosed();
        }

        public Metadata iy() {
            MetadataBundle iZ = MetadataBundle.iZ();
            for (MetadataField metadataField : e.iY()) {
                if (!((metadataField instanceof b) || metadataField == ln.RI)) {
                    metadataField.a(this.JG, iZ, this.OD, this.La);
                }
            }
            return new m(iZ);
        }
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.OB = nextPageToken;
        dataHolder.gV().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        a aVar = this.OC;
        if (aVar != null && aVar.OD == row) {
            return aVar;
        }
        Metadata aVar2 = new a(this.JG, row);
        this.OC = aVar2;
        return aVar2;
    }

    public String getNextPageToken() {
        return this.OB;
    }
}
