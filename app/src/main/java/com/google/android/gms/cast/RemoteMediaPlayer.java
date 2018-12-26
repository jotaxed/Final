package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iu;
import com.google.android.gms.internal.iv;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final it Gw = new it(this) {
        final /* synthetic */ RemoteMediaPlayer GA;

        {
            this.GA = r1;
        }

        protected void onMetadataUpdated() {
            this.GA.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.GA.onStatusUpdated();
        }
    };
    private final a Gx = new a(this);
    private OnMetadataUpdatedListener Gy;
    private OnStatusUpdatedListener Gz;
    private final Object mH = new Object();

    private static abstract class b extends a<MediaChannelResult> {
        iv GR = new iv(this) {
            final /* synthetic */ b GS;

            {
                this.GS = r1;
            }

            public void a(long j, int i, JSONObject jSONObject) {
                this.GS.b(new c(new Status(i), jSONObject));
            }

            public void n(long j) {
                this.GS.b(this.GS.k(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        };

        b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result c(Status status) {
            return k(status);
        }

        public MediaChannelResult k(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ b GS;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    private class a implements iu {
        final /* synthetic */ RemoteMediaPlayer GA;
        private GoogleApiClient GN;
        private long GO = 0;

        private final class a implements ResultCallback<Status> {
            private final long GP;
            final /* synthetic */ a GQ;

            a(a aVar, long j) {
                this.GQ = aVar;
                this.GP = j;
            }

            public void j(Status status) {
                if (!status.isSuccess()) {
                    this.GQ.GA.Gw.b(this.GP, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                j((Status) x0);
            }
        }

        public a(RemoteMediaPlayer remoteMediaPlayer) {
            this.GA = remoteMediaPlayer;
        }

        public void a(String str, String str2, long j, String str3) throws IOException {
            if (this.GN == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.GN, str, str2).setResultCallback(new a(this, j));
        }

        public void b(GoogleApiClient googleApiClient) {
            this.GN = googleApiClient;
        }

        public long fS() {
            long j = this.GO + 1;
            this.GO = j;
            return j;
        }
    }

    private static final class c implements MediaChannelResult {
        private final Status Eb;
        private final JSONObject Ga;

        c(Status status, JSONObject jSONObject) {
            this.Eb = status;
            this.Ga = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.Ga;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public RemoteMediaPlayer() {
        this.Gw.a(this.Gx);
    }

    private void onMetadataUpdated() {
        if (this.Gy != null) {
            this.Gy.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.Gz != null) {
            this.Gz.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.mH) {
            approximateStreamPosition = this.Gw.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.mH) {
            mediaInfo = this.Gw.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.mH) {
            mediaStatus = this.Gw.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.Gw.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.mH) {
            streamDuration = this.Gw.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(googleApiClient);
                    try {
                        this.GA.Gw.a(this.GR, mediaInfo2, z, j, jArr, jSONObject);
                    } catch (IOException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.Gw.aD(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(apiClient);
                    try {
                        this.GA.Gw.a(this.GR, customData);
                    } catch (IOException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(apiClient);
                    try {
                        this.GA.Gw.c(this.GR, customData);
                    } catch (IOException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(apiClient);
                    try {
                        this.GA.Gw.a(this.GR);
                    } catch (IOException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(googleApiClient);
                    try {
                        this.GA.Gw.a(this.GR, j, i, jSONObject);
                    } catch (IOException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null && trackIds.length != 0) {
            return apiClient.b(new b(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer GA;

                protected void a(im imVar) {
                    synchronized (this.GA.mH) {
                        this.GA.Gx.b(apiClient);
                        try {
                            this.GA.Gw.a(this.GR, trackIds);
                        } catch (IOException e) {
                            b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        } finally {
                            this.GA.Gx.b(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null or empty");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.Gy = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.Gz = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final boolean z = muteState;
        final JSONObject jSONObject = customData;
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(googleApiClient);
                    try {
                        this.GA.Gw.a(this.GR, z, jSONObject);
                    } catch (IllegalStateException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } catch (IOException e2) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(googleApiClient);
                    try {
                        this.GA.Gw.a(this.GR, d, jSONObject);
                    } catch (IllegalStateException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } catch (IllegalArgumentException e2) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } catch (IOException e3) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.b(new b(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer GA;

                protected void a(im imVar) {
                    synchronized (this.GA.mH) {
                        this.GA.Gx.b(apiClient);
                        try {
                            this.GA.Gw.a(this.GR, trackStyle);
                        } catch (IOException e) {
                            b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        } finally {
                            this.GA.Gx.b(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.b(new b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            protected void a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.b(apiClient);
                    try {
                        this.GA.Gw.b(this.GR, customData);
                    } catch (IOException e) {
                        b(k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.GA.Gx.b(null);
                    }
                }
            }
        });
    }
}
