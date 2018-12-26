package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class db implements ab {
    private final String atQ = a("GoogleTagManager", "4.00", VERSION.RELEASE, c(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient atR;
    private a atS;
    private final Context atz;

    public interface a {
        void a(ap apVar);

        void b(ap apVar);

        void c(ap apVar);
    }

    db(HttpClient httpClient, Context context, a aVar) {
        this.atz = context.getApplicationContext();
        this.atR = httpClient;
        this.atS = aVar;
    }

    private HttpEntityEnclosingRequest a(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.atQ);
            } catch (URISyntaxException e2) {
                e = e2;
                bh.W("Exception sending hit: " + e.getClass().getSimpleName());
                bh.W(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            bh.W("Exception sending hit: " + e.getClass().getSimpleName());
            bh.W(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    private void a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                bh.V("Error Writing hit to log...");
            }
        }
        bh.V(stringBuffer.toString());
    }

    static String c(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL d(ap apVar) {
        try {
            return new URL(apVar.pL());
        } catch (MalformedURLException e) {
            bh.T("Error trying to parse the GTM url.");
            return null;
        }
    }

    public boolean ea() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.atz.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.V("...no network connectivity");
        return false;
    }

    public void k(List<ap> list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            ap apVar = (ap) list.get(i);
            URL d = d(apVar);
            if (d == null) {
                bh.W("No destination: discarding hit.");
                this.atS.b(apVar);
                obj2 = obj;
            } else {
                HttpEntityEnclosingRequest a = a(d);
                if (a == null) {
                    this.atS.b(apVar);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader("Host", httpHost.toHostString());
                    a(a);
                    if (obj != null) {
                        try {
                            bo.aa(this.atz);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            bh.W("ClientProtocolException sending hit; discarding hit...");
                            this.atS.b(apVar);
                            obj2 = obj;
                        } catch (IOException e2) {
                            bh.W("Exception sending hit: " + e2.getClass().getSimpleName());
                            bh.W(e2.getMessage());
                            this.atS.c(apVar);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.atR.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        bh.W("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.atS.c(apVar);
                    } else {
                        this.atS.a(apVar);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }
}
