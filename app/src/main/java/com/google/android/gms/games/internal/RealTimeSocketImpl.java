package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl implements RealTimeSocket {
    private ParcelFileDescriptor LG;
    private final LocalSocket ZV;
    private final String Zk;

    RealTimeSocketImpl(LocalSocket localSocket, String participantId) {
        this.ZV = localSocket;
        this.Zk = participantId;
    }

    public void close() throws IOException {
        this.ZV.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.ZV.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.ZV.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if (this.LG == null && !isClosed()) {
            Parcel obtain = Parcel.obtain();
            obtain.writeFileDescriptor(this.ZV.getFileDescriptor());
            obtain.setDataPosition(0);
            this.LG = obtain.readFileDescriptor();
        }
        return this.LG;
    }

    public boolean isClosed() {
        return (this.ZV.isConnected() || this.ZV.isBound()) ? false : true;
    }
}
