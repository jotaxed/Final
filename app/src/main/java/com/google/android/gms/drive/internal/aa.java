package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.List;

public class aa extends com.google.android.gms.drive.internal.ag.a {
    private final int Pm;
    private final c Qw;
    private final a Qx;
    private final List<Integer> Qy = new ArrayList();

    private static class a extends Handler {
        private final Context mContext;

        private a(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        public void a(c cVar, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(cVar, driveEvent)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    c cVar = (c) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) cVar).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) cVar).onCompletion((CompletionEvent) driveEvent);
                            return;
                        default:
                            w.o("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    w.e(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }
    }

    public aa(Looper looper, Context context, int i, c cVar) {
        this.Pm = i;
        this.Qw = cVar;
        this.Qx = new a(looper, context);
    }

    public void bw(int i) {
        this.Qy.add(Integer.valueOf(i));
    }

    public boolean bx(int i) {
        return this.Qy.contains(Integer.valueOf(i));
    }

    public void c(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent iQ = onEventResponse.iQ();
        jx.K(this.Pm == iQ.getType());
        jx.K(this.Qy.contains(Integer.valueOf(iQ.getType())));
        this.Qx.a(this.Qw, iQ);
    }
}
