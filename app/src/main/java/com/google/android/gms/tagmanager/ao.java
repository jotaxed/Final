package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID = a.HASH.toString();
    private static final String arp = b.ARG0.toString();
    private static final String arr = b.INPUT_FORMAT.toString();
    private static final String arv = b.ALGORITHM.toString();

    public ao() {
        super(ID, arp);
    }

    private byte[] d(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public d.a B(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(arp);
        if (aVar == null || aVar == di.rb()) {
            return di.rb();
        }
        byte[] bytes;
        String j = di.j(aVar);
        aVar = (d.a) map.get(arv);
        String j2 = aVar == null ? "MD5" : di.j(aVar);
        aVar = (d.a) map.get(arr);
        String j3 = aVar == null ? "text" : di.j(aVar);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = j.co(j);
        } else {
            bh.T("Hash: unknown input format: " + j3);
            return di.rb();
        }
        try {
            return di.u(j.d(d(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.T("Hash: unknown algorithm: " + j2);
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
