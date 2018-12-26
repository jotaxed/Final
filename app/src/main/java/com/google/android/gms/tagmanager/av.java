package com.google.android.gms.tagmanager;

import com.google.android.gms.wallet.WalletConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class av implements bm {
    private HttpClient arD;

    av() {
    }

    private InputStream a(HttpClient httpClient, HttpResponse httpResponse) throws IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            bh.V("Success response");
            return httpResponse.getEntity().getContent();
        }
        String str = "Bad response: " + statusCode;
        if (statusCode == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    private void a(HttpClient httpClient) {
        if (httpClient != null && httpClient.getConnectionManager() != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public InputStream cF(String str) throws IOException {
        this.arD = pM();
        return a(this.arD, this.arD.execute(new HttpGet(str)));
    }

    public void close() {
        a(this.arD);
    }

    HttpClient pM() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        return new DefaultHttpClient(basicHttpParams);
    }
}
