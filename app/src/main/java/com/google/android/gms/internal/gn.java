package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@ey
public class gn {
    public static final a<Void> wN = new a() {
        public /* synthetic */ Object b(InputStream inputStream) {
            return c(inputStream);
        }

        public Void c(InputStream inputStream) {
            return null;
        }

        public /* synthetic */ Object cQ() {
            return dz();
        }

        public Void dz() {
            return null;
        }
    };

    public interface a<T> {
        T b(InputStream inputStream);

        T cQ();
    }

    public <T> Future<T> a(final String str, final a<T> aVar) {
        return gh.submit(new Callable<T>(this) {
            final /* synthetic */ gn wQ;

            public T call() {
                Throwable th;
                Throwable th2;
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection2.connect();
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode < 200 || responseCode > 299) {
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return aVar.cQ();
                        }
                        T b = aVar.b(httpURLConnection2.getInputStream());
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return b;
                    } catch (Throwable e) {
                        th = e;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        try {
                            gr.d("Error making HTTP request.", th2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return aVar.cQ();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th2;
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        gr.d("Error making HTTP request.", th2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return aVar.cQ();
                    } catch (Throwable e22) {
                        th = e22;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th2;
                    }
                } catch (MalformedURLException e3) {
                    th2 = e3;
                    gr.d("Error making HTTP request.", th2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar.cQ();
                } catch (IOException e4) {
                    th2 = e4;
                    gr.d("Error making HTTP request.", th2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar.cQ();
                }
            }
        });
    }
}
