package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class az {

    static abstract class a<T> extends a {
        private com.google.android.gms.common.api.BaseImplementation.b<T> DA;

        public a(com.google.android.gms.common.api.BaseImplementation.b<T> bVar) {
            this.DA = bVar;
        }

        public void A(T t) {
            com.google.android.gms.common.api.BaseImplementation.b bVar = this.DA;
            if (bVar != null) {
                bVar.b(t);
                this.DA = null;
            }
        }
    }

    static final class b extends a<DeleteDataItemsResult> {
        public b(com.google.android.gms.common.api.BaseImplementation.b<DeleteDataItemsResult> bVar) {
            super(bVar);
        }

        public void a(p pVar) {
            A(new com.google.android.gms.wearable.internal.f.c(av.gN(pVar.statusCode), pVar.axI));
        }
    }

    static final class c extends a<GetConnectedNodesResult> {
        public c(com.google.android.gms.common.api.BaseImplementation.b<GetConnectedNodesResult> bVar) {
            super(bVar);
        }

        public void a(v vVar) {
            List arrayList = new ArrayList();
            arrayList.addAll(vVar.axL);
            A(new com.google.android.gms.wearable.internal.ak.b(av.gN(vVar.statusCode), arrayList));
        }
    }

    static final class d extends a<DataItemResult> {
        public d(com.google.android.gms.common.api.BaseImplementation.b<DataItemResult> bVar) {
            super(bVar);
        }

        public void a(x xVar) {
            A(new com.google.android.gms.wearable.internal.f.b(av.gN(xVar.statusCode), xVar.axM));
        }
    }

    static final class e extends a<DataItemBuffer> {
        public e(com.google.android.gms.common.api.BaseImplementation.b<DataItemBuffer> bVar) {
            super(bVar);
        }

        public void ab(DataHolder dataHolder) {
            A(new DataItemBuffer(dataHolder));
        }
    }

    static final class f extends a<GetFdForAssetResult> {
        public f(com.google.android.gms.common.api.BaseImplementation.b<GetFdForAssetResult> bVar) {
            super(bVar);
        }

        public void a(z zVar) {
            A(new com.google.android.gms.wearable.internal.f.d(av.gN(zVar.statusCode), zVar.axN));
        }
    }

    static final class g extends a<GetLocalNodeResult> {
        public g(com.google.android.gms.common.api.BaseImplementation.b<GetLocalNodeResult> bVar) {
            super(bVar);
        }

        public void a(ab abVar) {
            A(new com.google.android.gms.wearable.internal.ak.c(av.gN(abVar.statusCode), abVar.axO));
        }
    }

    static final class h extends a {
        h() {
        }

        public void a(Status status) {
        }
    }

    static final class i extends a<DataItemResult> {
        private final List<FutureTask<Boolean>> ayf;

        i(com.google.android.gms.common.api.BaseImplementation.b<DataItemResult> bVar, List<FutureTask<Boolean>> list) {
            super(bVar);
            this.ayf = list;
        }

        public void a(ap apVar) {
            A(new com.google.android.gms.wearable.internal.f.b(av.gN(apVar.statusCode), apVar.axM));
            if (apVar.statusCode != 0) {
                for (FutureTask cancel : this.ayf) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class j extends a<SendMessageResult> {
        public j(com.google.android.gms.common.api.BaseImplementation.b<SendMessageResult> bVar) {
            super(bVar);
        }

        public void a(at atVar) {
            A(new com.google.android.gms.wearable.internal.ah.b(av.gN(atVar.statusCode), atVar.ayd));
        }
    }
}
