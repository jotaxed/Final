package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class lh {
    public static long a(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return a(inputStream, outputStream, z, 1024);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, boolean z, int i) throws IOException {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    b(inputStream);
                    b(outputStream);
                }
            }
        }
        return j;
    }

    public static void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] a(InputStream inputStream, boolean z) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        return a(inputStream, true);
    }
}
