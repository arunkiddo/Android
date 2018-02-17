package com.p045c.p046a.p055j;

import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.c.a.j.f */
public class C1293f extends FilterInputStream {
    private int f3246a;

    public C1293f(InputStream inputStream) {
        super(inputStream);
        this.f3246a = Integer.MIN_VALUE;
    }

    private long m6103a(long j) {
        return this.f3246a == 0 ? -1 : (this.f3246a == Integer.MIN_VALUE || j <= ((long) this.f3246a)) ? j : (long) this.f3246a;
    }

    private void m6104b(long j) {
        if (this.f3246a != Integer.MIN_VALUE && j != -1) {
            this.f3246a = (int) (((long) this.f3246a) - j);
        }
    }

    public int available() {
        return this.f3246a == Integer.MIN_VALUE ? super.available() : Math.min(this.f3246a, super.available());
    }

    public void mark(int i) {
        super.mark(i);
        this.f3246a = i;
    }

    public int read() {
        if (m6103a(1) == -1) {
            return -1;
        }
        int read = super.read();
        m6104b(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int a = (int) m6103a((long) i2);
        if (a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a);
        m6104b((long) read);
        return read;
    }

    public void reset() {
        super.reset();
        this.f3246a = Integer.MIN_VALUE;
    }

    public long skip(long j) {
        long a = m6103a(j);
        if (a == -1) {
            return -1;
        }
        long skip = super.skip(a);
        m6104b(skip);
        return skip;
    }
}
