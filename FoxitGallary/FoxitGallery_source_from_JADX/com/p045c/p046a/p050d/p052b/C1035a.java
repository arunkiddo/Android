package com.p045c.p046a.p050d.p052b;

import android.util.Log;
import com.p045c.p046a.C1298k;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p051a.C1000c;
import com.p045c.p046a.p050d.p052b.p053b.C1037a;
import com.p045c.p046a.p050d.p052b.p053b.C1037a.C1015b;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p055j.C1292d;
import com.p045c.p046a.p064g.C1153b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.c.a.d.b.a */
class C1035a<A, T, Z> {
    private static final C1014b f2767a;
    private final C1082f f2768b;
    private final int f2769c;
    private final int f2770d;
    private final C1000c<A> f2771e;
    private final C1153b<A, T> f2772f;
    private final C1146g<T> f2773g;
    private final C1220c<T, Z> f2774h;
    private final C1013a f2775i;
    private final C1056b f2776j;
    private final C1298k f2777k;
    private final C1014b f2778l;
    private volatile boolean f2779m;

    /* renamed from: com.c.a.d.b.a.a */
    interface C1013a {
        C1037a m5311a();
    }

    /* renamed from: com.c.a.d.b.a.b */
    static class C1014b {
        C1014b() {
        }

        public OutputStream m5312a(File file) {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    /* renamed from: com.c.a.d.b.a.c */
    class C1016c<DataType> implements C1015b {
        final /* synthetic */ C1035a f2729a;
        private final C1092b<DataType> f2730b;
        private final DataType f2731c;

        public C1016c(C1035a c1035a, C1092b<DataType> c1092b, DataType dataType) {
            this.f2729a = c1035a;
            this.f2730b = c1092b;
            this.f2731c = dataType;
        }

        public boolean m5314a(File file) {
            boolean z = false;
            OutputStream outputStream = null;
            try {
                outputStream = this.f2729a.f2778l.m5312a(file);
                z = this.f2730b.m5526a(this.f2731c, outputStream);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
            return z;
        }
    }

    static {
        f2767a = new C1014b();
    }

    public C1035a(C1082f c1082f, int i, int i2, C1000c<A> c1000c, C1153b<A, T> c1153b, C1146g<T> c1146g, C1220c<T, Z> c1220c, C1013a c1013a, C1056b c1056b, C1298k c1298k) {
        this(c1082f, i, i2, c1000c, c1153b, c1146g, c1220c, c1013a, c1056b, c1298k, f2767a);
    }

    C1035a(C1082f c1082f, int i, int i2, C1000c<A> c1000c, C1153b<A, T> c1153b, C1146g<T> c1146g, C1220c<T, Z> c1220c, C1013a c1013a, C1056b c1056b, C1298k c1298k, C1014b c1014b) {
        this.f2768b = c1082f;
        this.f2769c = i;
        this.f2770d = i2;
        this.f2771e = c1000c;
        this.f2772f = c1153b;
        this.f2773g = c1146g;
        this.f2774h = c1220c;
        this.f2775i = c1013a;
        this.f2776j = c1056b;
        this.f2777k = c1298k;
        this.f2778l = c1014b;
    }

    private C1084k<Z> m5394a(C1084k<T> c1084k) {
        long a = C1292d.m6102a();
        C1084k c = m5400c(c1084k);
        if (Log.isLoggable("DecodeJob", 2)) {
            m5397a("Transformed resource from source", a);
        }
        m5399b(c);
        a = C1292d.m6102a();
        C1084k<Z> d = m5401d(c);
        if (Log.isLoggable("DecodeJob", 2)) {
            m5397a("Transcoded transformed from source", a);
        }
        return d;
    }

    private C1084k<T> m5395a(C1081c c1081c) {
        C1084k<T> c1084k = null;
        File a = this.f2775i.m5311a().m5408a(c1081c);
        if (a != null) {
            try {
                c1084k = this.f2772f.m5650a().m5658a(a, this.f2769c, this.f2770d);
                if (c1084k == null) {
                    this.f2775i.m5311a().m5410b(c1081c);
                }
            } catch (Throwable th) {
                if (c1084k == null) {
                    this.f2775i.m5311a().m5410b(c1081c);
                }
            }
        }
        return c1084k;
    }

    private C1084k<T> m5396a(A a) {
        if (this.f2776j.m5459a()) {
            return m5398b((Object) a);
        }
        long a2 = C1292d.m6102a();
        C1084k<T> a3 = this.f2772f.m5651b().m5658a(a, this.f2769c, this.f2770d);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return a3;
        }
        m5397a("Decoded from source", a2);
        return a3;
    }

    private void m5397a(String str, long j) {
        Log.v("DecodeJob", str + " in " + C1292d.m6101a(j) + ", key: " + this.f2768b);
    }

    private C1084k<T> m5398b(A a) {
        long a2 = C1292d.m6102a();
        this.f2775i.m5311a().m5409a(this.f2768b.m5502a(), new C1016c(this, this.f2772f.m5652c(), a));
        if (Log.isLoggable("DecodeJob", 2)) {
            m5397a("Wrote source to cache", a2);
        }
        a2 = C1292d.m6102a();
        C1084k<T> a3 = m5395a(this.f2768b.m5502a());
        if (Log.isLoggable("DecodeJob", 2) && a3 != null) {
            m5397a("Decoded source from cache", a2);
        }
        return a3;
    }

    private void m5399b(C1084k<T> c1084k) {
        if (c1084k != null && this.f2776j.m5460b()) {
            long a = C1292d.m6102a();
            this.f2775i.m5311a().m5409a(this.f2768b, new C1016c(this, this.f2772f.m5653d(), c1084k));
            if (Log.isLoggable("DecodeJob", 2)) {
                m5397a("Wrote transformed from source to cache", a);
            }
        }
    }

    private C1084k<T> m5400c(C1084k<T> c1084k) {
        if (c1084k == null) {
            return null;
        }
        C1084k<T> a = this.f2773g.m5626a(c1084k, this.f2769c, this.f2770d);
        if (c1084k.equals(a)) {
            return a;
        }
        c1084k.m5507d();
        return a;
    }

    private C1084k<Z> m5401d(C1084k<T> c1084k) {
        return c1084k == null ? null : this.f2774h.m5841a(c1084k);
    }

    private C1084k<T> m5402e() {
        try {
            long a = C1292d.m6102a();
            Object a2 = this.f2771e.m5265a(this.f2777k);
            if (Log.isLoggable("DecodeJob", 2)) {
                m5397a("Fetched data", a);
            }
            if (this.f2779m) {
                return null;
            }
            C1084k<T> a3 = m5396a(a2);
            this.f2771e.m5266a();
            return a3;
        } finally {
            this.f2771e.m5266a();
        }
    }

    public C1084k<Z> m5403a() {
        if (!this.f2776j.m5460b()) {
            return null;
        }
        long a = C1292d.m6102a();
        C1084k a2 = m5395a(this.f2768b);
        if (Log.isLoggable("DecodeJob", 2)) {
            m5397a("Decoded transformed from cache", a);
        }
        long a3 = C1292d.m6102a();
        C1084k<Z> d = m5401d(a2);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return d;
        }
        m5397a("Transcoded transformed from cache", a3);
        return d;
    }

    public C1084k<Z> m5404b() {
        if (!this.f2776j.m5459a()) {
            return null;
        }
        long a = C1292d.m6102a();
        C1084k a2 = m5395a(this.f2768b.m5502a());
        if (Log.isLoggable("DecodeJob", 2)) {
            m5397a("Decoded source from cache", a);
        }
        return m5394a(a2);
    }

    public C1084k<Z> m5405c() {
        return m5394a(m5402e());
    }

    public void m5406d() {
        this.f2779m = true;
        this.f2771e.m5268c();
    }
}
