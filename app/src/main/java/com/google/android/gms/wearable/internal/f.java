package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class f implements DataApi {

    private static final class a extends d<Status> {
        private DataListener axC;
        private IntentFilter[] axD;

        private a(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.axC = dataListener;
            this.axD = intentFilterArr;
        }

        protected void a(ba baVar) throws RemoteException {
            baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, this.axC, this.axD);
            this.axC = null;
            this.axD = null;
        }

        public Status b(Status status) {
            this.axC = null;
            this.axD = null;
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public static class b implements DataItemResult {
        private final Status Eb;
        private final DataItem axE;

        public b(Status status, DataItem dataItem) {
            this.Eb = status;
            this.axE = dataItem;
        }

        public DataItem getDataItem() {
            return this.axE;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public static class c implements DeleteDataItemsResult {
        private final Status Eb;
        private final int axF;

        public c(Status status, int i) {
            this.Eb = status;
            this.axF = i;
        }

        public int getNumDeleted() {
            return this.axF;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public static class d implements GetFdForAssetResult {
        private final Status Eb;
        private volatile InputStream ZO;
        private volatile ParcelFileDescriptor axG;
        private volatile boolean mClosed = false;

        public d(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.Eb = status;
            this.axG = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.axG;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.axG == null) {
                return null;
            } else {
                if (this.ZO == null) {
                    this.ZO = new AutoCloseInputStream(this.axG);
                }
                return this.ZO;
            }
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            if (this.axG != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.ZO != null) {
                        this.ZO.close();
                    } else {
                        this.axG.close();
                    }
                    this.mClosed = true;
                    this.axG = null;
                    this.ZO = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> a(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.a(new a(googleApiClient, dataListener, intentFilterArr));
    }

    private void a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return a(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri) {
        return client.a(new d<DeleteDataItemsResult>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.c(this, uri);
            }

            protected DeleteDataItemsResult aG(Status status) {
                return new c(status, 0);
            }

            protected /* synthetic */ Result c(Status status) {
                return aG(status);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.a(new d<DataItemResult>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, uri);
            }

            protected DataItemResult aE(Status status) {
                return new b(status, null);
            }

            protected /* synthetic */ Result c(Status status) {
                return aE(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.a(new d<DataItemBuffer>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.n(this);
            }

            protected DataItemBuffer aF(Status status) {
                return new DataItemBuffer(DataHolder.av(status.getStatusCode()));
            }

            protected /* synthetic */ Result c(Status status) {
                return aF(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri) {
        return client.a(new d<DataItemBuffer>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.b((com.google.android.gms.common.api.BaseImplementation.b) this, uri);
            }

            protected DataItemBuffer aF(Status status) {
                return new DataItemBuffer(DataHolder.av(status.getStatusCode()));
            }

            protected /* synthetic */ Result c(Status status) {
                return aF(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        a(asset);
        return client.a(new d<GetFdForAssetResult>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, asset);
            }

            protected GetFdForAssetResult aH(Status status) {
                return new d(status, null);
            }

            protected /* synthetic */ Result c(Status status) {
                return aH(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.a(new d<GetFdForAssetResult>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, asset);
            }

            protected GetFdForAssetResult aH(Status status) {
                return new d(status, null);
            }

            protected /* synthetic */ Result c(Status status) {
                return aH(status);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.a(new d<DataItemResult>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, request);
            }

            public DataItemResult aE(Status status) {
                return new b(status, null);
            }

            public /* synthetic */ Result c(Status status) {
                return aE(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.a(new d<Status>(this, client) {
            final /* synthetic */ f axy;

            protected void a(ba baVar) throws RemoteException {
                baVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, listener);
            }

            public Status b(Status status) {
                return status;
            }

            public /* synthetic */ Result c(Status status) {
                return b(status);
            }
        });
    }
}
