package com.p045c.p046a.p050d.p052b;

import android.os.Looper;
import com.p045c.p046a.p050d.C1081c;

/* renamed from: com.c.a.d.b.h */
class C1085h<Z> implements C1084k<Z> {
    private final C1084k<Z> f2875a;
    private final boolean f2876b;
    private C1072a f2877c;
    private C1081c f2878d;
    private int f2879e;
    private boolean f2880f;

    /* renamed from: com.c.a.d.b.h.a */
    interface C1072a {
        void m5472b(C1081c c1081c, C1085h<?> c1085h);
    }

    C1085h(C1084k<Z> c1084k, boolean z) {
        if (c1084k == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.f2875a = c1084k;
        this.f2876b = z;
    }

    void m5508a(C1081c c1081c, C1072a c1072a) {
        this.f2878d = c1081c;
        this.f2877c = c1072a;
    }

    boolean m5509a() {
        return this.f2876b;
    }

    public Z m5510b() {
        return this.f2875a.m5505b();
    }

    public int m5511c() {
        return this.f2875a.m5506c();
    }

    public void m5512d() {
        if (this.f2879e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.f2880f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.f2880f = true;
            this.f2875a.m5507d();
        }
    }

    void m5513e() {
        if (this.f2880f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f2879e++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    void m5514f() {
        if (this.f2879e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.f2879e - 1;
            this.f2879e = i;
            if (i == 0) {
                this.f2877c.m5472b(this.f2878d, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }
}
