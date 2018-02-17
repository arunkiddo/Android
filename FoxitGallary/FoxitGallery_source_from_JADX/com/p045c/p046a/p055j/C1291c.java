package com.p045c.p046a.p055j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.c.a.j.c */
public class C1291c extends InputStream {
    private static final Queue<C1291c> f3242a;
    private InputStream f3243b;
    private IOException f3244c;

    static {
        f3242a = C1296h.m6112a(0);
    }

    C1291c() {
    }

    public static C1291c m6097a(InputStream inputStream) {
        C1291c c1291c;
        synchronized (f3242a) {
            c1291c = (C1291c) f3242a.poll();
        }
        if (c1291c == null) {
            c1291c = new C1291c();
        }
        c1291c.m6100b(inputStream);
        return c1291c;
    }

    public IOException m6098a() {
        return this.f3244c;
    }

    public int available() {
        return this.f3243b.available();
    }

    public void m6099b() {
        this.f3244c = null;
        this.f3243b = null;
        synchronized (f3242a) {
            f3242a.offer(this);
        }
    }

    void m6100b(InputStream inputStream) {
        this.f3243b = inputStream;
    }

    public void close() {
        this.f3243b.close();
    }

    public void mark(int i) {
        this.f3243b.mark(i);
    }

    public boolean markSupported() {
        return this.f3243b.markSupported();
    }

    public int read() {
        try {
            return this.f3243b.read();
        } catch (IOException e) {
            this.f3244c = e;
            return -1;
        }
    }

    public int read(byte[] bArr) {
        try {
            return this.f3243b.read(bArr);
        } catch (IOException e) {
            this.f3244c = e;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f3243b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f3244c = e;
            return -1;
        }
    }

    public synchronized void reset() {
        this.f3243b.reset();
    }

    public long skip(long j) {
        try {
            return this.f3243b.skip(j);
        } catch (IOException e) {
            this.f3244c = e;
            return 0;
        }
    }
}
