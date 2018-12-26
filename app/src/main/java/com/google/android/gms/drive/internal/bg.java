package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Status;

public class bg extends c {
    private final b<Status> Ea;

    public bg(b<Status> bVar) {
        this.Ea = bVar;
    }

    public void n(Status status) throws RemoteException {
        this.Ea.b(status);
    }

    public void onSuccess() throws RemoteException {
        this.Ea.b(Status.Kw);
    }
}
