package com.google.android.gms.internal;

import org.json.JSONObject;

@ey
public class dk {
    private final boolean rs;
    private final boolean rt;
    private final boolean ru;
    private final boolean rv;
    private final boolean rw;

    public static final class a {
        private boolean rs;
        private boolean rt;
        private boolean ru;
        private boolean rv;
        private boolean rw;

        public dk bU() {
            return new dk();
        }

        public a k(boolean z) {
            this.rs = z;
            return this;
        }

        public a l(boolean z) {
            this.rt = z;
            return this;
        }

        public a m(boolean z) {
            this.ru = z;
            return this;
        }

        public a n(boolean z) {
            this.rv = z;
            return this;
        }

        public a o(boolean z) {
            this.rw = z;
            return this;
        }
    }

    private dk(a aVar) {
        this.rs = aVar.rs;
        this.rt = aVar.rt;
        this.ru = aVar.ru;
        this.rv = aVar.rv;
        this.rw = aVar.rw;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.rs).put("tel", this.rt).put("calendar", this.ru).put("storePicture", this.rv).put("inlineVideo", this.rw);
        } catch (Throwable e) {
            gr.b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
