package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] adl = new String[]{"requestId", "outcome"};
    private final int Iv;
    private final HashMap<String, Integer> adm;

    public static final class Builder {
        private int Iv = 0;
        private HashMap<String, Integer> adm = new HashMap();

        public Builder ek(int i) {
            this.Iv = i;
            return this;
        }

        public RequestUpdateOutcomes mF() {
            return new RequestUpdateOutcomes(this.Iv, this.adm);
        }

        public Builder z(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.adm.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.Iv = statusCode;
        this.adm = outcomeMap;
    }

    public static RequestUpdateOutcomes W(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.ek(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int au = dataHolder.au(i);
            builder.z(dataHolder.c("requestId", i, au), dataHolder.b("outcome", i, au));
        }
        return builder.mF();
    }

    public Set<String> getRequestIds() {
        return this.adm.keySet();
    }

    public int getRequestOutcome(String requestId) {
        jx.b(this.adm.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.adm.get(requestId)).intValue();
    }
}
