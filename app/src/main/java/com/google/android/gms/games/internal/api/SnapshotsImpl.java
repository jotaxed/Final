package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadSnapshotsResult aq(final Status status) {
            return new LoadSnapshotsResult(this) {
                final /* synthetic */ LoadImpl abQ;

                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.av(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return aq(status);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {
        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public OpenSnapshotResult ar(final Status status) {
            return new OpenSnapshotResult(this) {
                final /* synthetic */ OpenImpl abR;

                public String getConflictId() {
                    return null;
                }

                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                public SnapshotContents getResolutionSnapshotContents() {
                    return null;
                }

                public Snapshot getSnapshot() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ar(status);
        }
    }

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {
        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CommitSnapshotResult ao(final Status status) {
            return new CommitSnapshotResult(this) {
                final /* synthetic */ CommitImpl abO;

                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ao(status);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {
        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DeleteSnapshotResult ap(final Status status) {
            return new DeleteSnapshotResult(this) {
                final /* synthetic */ DeleteImpl abP;

                public String getSnapshotId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ap(status);
        }
    }

    class AnonymousClass6 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ String ZZ;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((b) this, this.ZY, this.ZZ, this.ZW);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, final Snapshot snapshot, final SnapshotMetadataChange metadataChange) {
        return apiClient.b(new CommitImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl abF;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, snapshot, metadataChange);
            }
        });
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient apiClient, final SnapshotMetadata metadata) {
        return apiClient.b(new DeleteImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl abF;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.i(this, metadata.getSnapshotId());
            }
        });
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.d(apiClient).a(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.d(apiClient).lC();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.d(apiClient).lB();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.d(apiClient).a(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        return (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.a(new LoadImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl abF;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.e((b) this, forceReload);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, final String fileName, final boolean createIfNotFound) {
        return apiClient.b(new OpenImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl abF;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.c((b) this, fileName, createIfNotFound);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, SnapshotContents snapshotContents) {
        final String str = conflictId;
        final String str2 = snapshotId;
        final SnapshotMetadataChange snapshotMetadataChange = metadataChange;
        final SnapshotContents snapshotContents2 = snapshotContents;
        return apiClient.b(new OpenImpl(this, apiClient) {
            final /* synthetic */ SnapshotsImpl abF;

            protected void a(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.a((b) this, str, str2, snapshotMetadataChange, snapshotContents2);
            }
        });
    }
}
