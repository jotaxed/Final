package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
    public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
    private static final Object aeY = new Object();
    private final int CK;
    private Contents PW;

    SnapshotContentsEntity(int versionCode, Contents contents) {
        this.CK = versionCode;
        this.PW = contents;
    }

    public SnapshotContentsEntity(Contents contents) {
        this(1, contents);
    }

    private boolean a(int i, byte[] bArr, int i2, int i3, boolean z) {
        jx.a(!isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized (aeY) {
            OutputStream fileOutputStream = new FileOutputStream(this.PW.getParcelFileDescriptor().getFileDescriptor());
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (Throwable e) {
                GamesLog.a("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    public void close() {
        this.PW = null;
    }

    public int describeContents() {
        return 0;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        jx.a(!isClosed(), "Cannot mutate closed contents!");
        return this.PW.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.CK;
    }

    public Contents ir() {
        return this.PW;
    }

    public boolean isClosed() {
        return this.PW == null;
    }

    public boolean modifyBytes(int dstOffset, byte[] content, int srcOffset, int count) {
        return a(dstOffset, content, srcOffset, content.length, false);
    }

    public byte[] readFully() throws IOException {
        byte[] a;
        boolean z = false;
        if (!isClosed()) {
            z = true;
        }
        jx.a(z, "Must provide a previously opened Snapshot");
        synchronized (aeY) {
            InputStream fileInputStream = new FileInputStream(this.PW.getParcelFileDescriptor().getFileDescriptor());
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                a = lh.a(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (Throwable e) {
                GamesLog.b("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return a;
    }

    public boolean writeBytes(byte[] content) {
        return a(0, content, 0, content.length, true);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotContentsEntityCreator.a(this, out, flags);
    }
}
