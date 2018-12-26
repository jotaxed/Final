package com.google.android.gms.games.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LibjingleNativeSocket implements RealTimeSocket {
    private static final String TAG = LibjingleNativeSocket.class.getSimpleName();
    private final ParcelFileDescriptor LG;
    private final InputStream ZO;
    private final OutputStream ZP;

    LibjingleNativeSocket(ParcelFileDescriptor parcelFileDescriptor) {
        this.LG = parcelFileDescriptor;
        this.ZO = new AutoCloseInputStream(parcelFileDescriptor);
        this.ZP = new AutoCloseOutputStream(parcelFileDescriptor);
    }

    public void close() throws IOException {
        this.LG.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.ZO;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.ZP;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        return this.LG;
    }

    public boolean isClosed() {
        try {
            this.ZO.available();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
