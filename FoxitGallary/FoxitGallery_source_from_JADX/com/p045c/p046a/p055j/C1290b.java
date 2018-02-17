package com.p045c.p046a.p055j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.c.a.j.b */
public final class C1290b extends FilterInputStream {
    private final long f3240a;
    private int f3241b;

    C1290b(InputStream inputStream, long j) {
        super(inputStream);
        this.f3240a = j;
    }

    private int m6095a(int i) {
        if (i >= 0) {
            this.f3241b += i;
        } else if (this.f3240a - ((long) this.f3241b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f3240a + ", but read: " + this.f3241b);
        }
        return i;
    }

    public static InputStream m6096a(InputStream inputStream, long j) {
        return new C1290b(inputStream, j);
    }

    public synchronized int available() {
        return (int) Math.max(this.f3240a - ((long) this.f3241b), (long) this.in.available());
    }

    public synchronized int read() {
        return m6095a(super.read());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        return m6095a(super.read(bArr, i, i2));
    }
}
