package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jd;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.lm;
import com.google.android.gms.internal.pf;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class e extends jl<d> {
    private Person anG;
    private final h anH;

    final class a extends a {
        private final com.google.android.gms.common.api.BaseImplementation.b<Status> anI;
        final /* synthetic */ e anJ;

        public a(e eVar, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            this.anJ = eVar;
            this.anI = bVar;
        }

        public void aA(Status status) {
            this.anJ.a(new d(this.anJ, this.anI, status));
        }
    }

    final class b extends a {
        private final com.google.android.gms.common.api.BaseImplementation.b<LoadMomentsResult> anI;
        final /* synthetic */ e anJ;

        public b(e eVar, com.google.android.gms.common.api.BaseImplementation.b<LoadMomentsResult> bVar) {
            this.anJ = eVar;
            this.anI = bVar;
        }

        public void a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.gV() != null ? (PendingIntent) dataHolder.gV().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.anJ.a(new c(this.anJ, this.anI, status, dataHolder2, str, str2));
        }
    }

    final class c extends com.google.android.gms.internal.jl.d<com.google.android.gms.common.api.BaseImplementation.b<LoadMomentsResult>> implements LoadMomentsResult {
        private final Status Eb;
        private final String OB;
        final /* synthetic */ e anJ;
        private final String anK;
        private MomentBuffer anL;

        public c(e eVar, com.google.android.gms.common.api.BaseImplementation.b<LoadMomentsResult> bVar, Status status, DataHolder dataHolder, String str, String str2) {
            this.anJ = eVar;
            super(eVar, bVar, dataHolder);
            this.Eb = status;
            this.OB = str;
            this.anK = str2;
        }

        protected void a(com.google.android.gms.common.api.BaseImplementation.b<LoadMomentsResult> bVar, DataHolder dataHolder) {
            this.anL = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            bVar.b(this);
        }

        protected /* synthetic */ void b(Object obj, DataHolder dataHolder) {
            a((com.google.android.gms.common.api.BaseImplementation.b) obj, dataHolder);
        }

        public MomentBuffer getMomentBuffer() {
            return this.anL;
        }

        public String getNextPageToken() {
            return this.OB;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public String getUpdated() {
            return this.anK;
        }

        public void release() {
            if (this.anL != null) {
                this.anL.close();
            }
        }
    }

    final class d extends b<com.google.android.gms.common.api.BaseImplementation.b<Status>> {
        private final Status Eb;
        final /* synthetic */ e anJ;

        public d(e eVar, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar, Status status) {
            this.anJ = eVar;
            super(eVar, bVar);
            this.Eb = status;
        }

        protected /* synthetic */ void g(Object obj) {
            m((com.google.android.gms.common.api.BaseImplementation.b) obj);
        }

        protected void hx() {
        }

        protected void m(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            if (bVar != null) {
                bVar.b(this.Eb);
            }
        }
    }

    final class e extends a {
        private final com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> anI;
        final /* synthetic */ e anJ;

        public e(e eVar, com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar) {
            this.anJ = eVar;
            this.anI = bVar;
        }

        public void a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.gV() != null ? (PendingIntent) dataHolder.gV().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.anJ.a(new f(this.anJ, this.anI, status, dataHolder2, str));
        }
    }

    final class f extends com.google.android.gms.internal.jl.d<com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult>> implements LoadPeopleResult {
        private final Status Eb;
        private final String OB;
        final /* synthetic */ e anJ;
        private PersonBuffer anM;

        public f(e eVar, com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar, Status status, DataHolder dataHolder, String str) {
            this.anJ = eVar;
            super(eVar, bVar, dataHolder);
            this.Eb = status;
            this.OB = str;
        }

        protected void a(com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar, DataHolder dataHolder) {
            this.anM = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            bVar.b(this);
        }

        protected /* synthetic */ void b(Object obj, DataHolder dataHolder) {
            a((com.google.android.gms.common.api.BaseImplementation.b) obj, dataHolder);
        }

        public String getNextPageToken() {
            return this.OB;
        }

        public PersonBuffer getPersonBuffer() {
            return this.anM;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            if (this.anM != null) {
                this.anM.close();
            }
        }
    }

    final class g extends a {
        private final com.google.android.gms.common.api.BaseImplementation.b<Status> anI;
        final /* synthetic */ e anJ;

        public g(e eVar, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            this.anJ = eVar;
            this.anI = bVar;
        }

        public void h(int i, Bundle bundle) {
            this.anJ.a(new h(this.anJ, this.anI, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    final class h extends b<com.google.android.gms.common.api.BaseImplementation.b<Status>> {
        private final Status Eb;
        final /* synthetic */ e anJ;

        public h(e eVar, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar, Status status) {
            this.anJ = eVar;
            super(eVar, bVar);
            this.Eb = status;
        }

        protected /* synthetic */ void g(Object obj) {
            m((com.google.android.gms.common.api.BaseImplementation.b) obj);
        }

        protected void hx() {
        }

        protected void m(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            this.anJ.disconnect();
            if (bVar != null) {
                bVar.b(this.Eb);
            }
        }
    }

    public e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, h hVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, hVar.oz());
        this.anH = hVar;
    }

    public jr a(com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar, int i, String str) {
        dS();
        Object eVar = new e(this, bVar);
        try {
            return ((d) hw()).a(eVar, 1, i, -1, str);
        } catch (RemoteException e) {
            eVar.a(DataHolder.av(8), null);
            return null;
        }
    }

    protected void a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.anG = pi.i(bundle.getByteArray("loaded_person"));
        }
        super.a(i, iBinder, bundle);
    }

    public void a(com.google.android.gms.common.api.BaseImplementation.b<LoadMomentsResult> bVar, int i, String str, Uri uri, String str2, String str3) {
        dS();
        Object bVar2 = bVar != null ? new b(this, bVar) : null;
        try {
            ((d) hw()).a(bVar2, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            bVar2.a(DataHolder.av(8), null, null);
        }
    }

    public void a(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar, Moment moment) {
        dS();
        b aVar = bVar != null ? new a(this, bVar) : null;
        try {
            ((d) hw()).a(aVar, ky.a((pf) moment));
        } catch (Throwable e) {
            if (aVar == null) {
                throw new IllegalStateException(e);
            }
            aVar.aA(new Status(8, null, null));
        }
    }

    public void a(com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar, Collection<String> collection) {
        dS();
        b eVar = new e(this, bVar);
        try {
            ((d) hw()).a(eVar, new ArrayList(collection));
        } catch (RemoteException e) {
            eVar.a(DataHolder.av(8), null);
        }
    }

    protected void a(jt jtVar, com.google.android.gms.internal.jl.e eVar) throws RemoteException {
        Bundle oH = this.anH.oH();
        oH.putStringArray("request_visible_actions", this.anH.oA());
        oH.putString("auth_package", this.anH.oC());
        jtVar.a((js) eVar, new jj(2).aX(this.anH.oD()).a(jd.aT(this.anH.getAccountName())).a(lm.d(hv())).e(oH));
    }

    protected String bK() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected d bN(IBinder iBinder) {
        return com.google.android.gms.plus.internal.d.a.bM(iBinder);
    }

    public boolean cj(String str) {
        return Arrays.asList(hv()).contains(str);
    }

    public void clearDefaultAccount() {
        dS();
        try {
            this.anG = null;
            ((d) hw()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void d(com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar, String[] strArr) {
        a((com.google.android.gms.common.api.BaseImplementation.b) bVar, Arrays.asList(strArr));
    }

    public String getAccountName() {
        dS();
        try {
            return ((d) hw()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        dS();
        return this.anG;
    }

    public void j(com.google.android.gms.common.api.BaseImplementation.b<LoadMomentsResult> bVar) {
        a(bVar, 20, null, null, null, "me");
    }

    public void k(com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar) {
        dS();
        Object eVar = new e(this, bVar);
        try {
            ((d) hw()).a(eVar, 2, 1, -1, null);
        } catch (RemoteException e) {
            eVar.a(DataHolder.av(8), null);
        }
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return bN(iBinder);
    }

    public void l(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
        dS();
        clearDefaultAccount();
        Object gVar = new g(this, bVar);
        try {
            ((d) hw()).b(gVar);
        } catch (RemoteException e) {
            gVar.h(8, null);
        }
    }

    public jr q(com.google.android.gms.common.api.BaseImplementation.b<LoadPeopleResult> bVar, String str) {
        return a((com.google.android.gms.common.api.BaseImplementation.b) bVar, 0, str);
    }

    public void removeMoment(String momentId) {
        dS();
        try {
            ((d) hw()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
