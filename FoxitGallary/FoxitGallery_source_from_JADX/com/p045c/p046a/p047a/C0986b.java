package com.p045c.p046a.p047a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.c.a.a.b */
class C0986b implements Closeable {
    private final InputStream f2567a;
    private final Charset f2568b;
    private byte[] f2569c;
    private int f2570d;
    private int f2571e;

    /* renamed from: com.c.a.a.b.1 */
    class C09851 extends ByteArrayOutputStream {
        final /* synthetic */ C0986b f2566a;

        C09851(C0986b c0986b, int i) {
            this.f2566a = c0986b;
            super(i);
        }

        public String toString() {
            int i = (this.count <= 0 || this.buf[this.count - 1] != 13) ? this.count : this.count - 1;
            try {
                return new String(this.buf, 0, i, this.f2566a.f2568b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public C0986b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C0987c.f2572a)) {
            this.f2567a = inputStream;
            this.f2568b = charset;
            this.f2569c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public C0986b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void m5107c() {
        int read = this.f2567a.read(this.f2569c, 0, this.f2569c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f2570d = 0;
        this.f2571e = read;
    }

    public String m5108a() {
        String str;
        synchronized (this.f2567a) {
            if (this.f2569c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f2570d >= this.f2571e) {
                m5107c();
            }
            int i2 = this.f2570d;
            while (i2 != this.f2571e) {
                if (this.f2569c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f2570d || this.f2569c[i2 - 1] != 13) ? i2 : i2 - 1;
                    str = new String(this.f2569c, this.f2570d, i3 - this.f2570d, this.f2568b.name());
                    this.f2570d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c09851 = new C09851(this, (this.f2571e - this.f2570d) + 80);
            loop1:
            while (true) {
                c09851.write(this.f2569c, this.f2570d, this.f2571e - this.f2570d);
                this.f2571e = -1;
                m5107c();
                i = this.f2570d;
                while (i != this.f2571e) {
                    if (this.f2569c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f2570d) {
                c09851.write(this.f2569c, this.f2570d, i - this.f2570d);
            }
            this.f2570d = i + 1;
            str = c09851.toString();
        }
        return str;
    }

    public boolean m5109b() {
        return this.f2571e == -1;
    }

    public void close() {
        synchronized (this.f2567a) {
            if (this.f2569c != null) {
                this.f2569c = null;
                this.f2567a.close();
            }
        }
    }
}
