package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID = a.LANGUAGE.toString();

    public bc() {
        super(ID, new String[0]);
    }

    public d.a B(Map<String, d.a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return di.rb();
        }
        String language = locale.getLanguage();
        return language == null ? di.rb() : di.u(language.toLowerCase());
    }

    public boolean pe() {
        return false;
    }
}
