package com.p045c.p046a.p050d.p052b;

import android.util.Log;
import com.p045c.p046a.C1298k;
import com.p045c.p046a.p050d.p052b.p056c.C1070b;
import com.p045c.p046a.p058h.C1078e;

/* renamed from: com.c.a.d.b.i */
class C1087i implements C1070b, Runnable {
    private final C1298k f2884a;
    private final C1079a f2885b;
    private final C1035a<?, ?, ?> f2886c;
    private C1086b f2887d;
    private volatile boolean f2888e;

    /* renamed from: com.c.a.d.b.i.a */
    interface C1079a extends C1078e {
        void m5487b(C1087i c1087i);
    }

    /* renamed from: com.c.a.d.b.i.b */
    private enum C1086b {
        CACHE,
        SOURCE
    }

    public C1087i(C1079a c1079a, C1035a<?, ?, ?> c1035a, C1298k c1298k) {
        this.f2885b = c1079a;
        this.f2886c = c1035a;
        this.f2887d = C1086b.CACHE;
        this.f2884a = c1298k;
    }

    private void m5515a(C1084k c1084k) {
        this.f2885b.m5485a(c1084k);
    }

    private void m5516a(Exception exception) {
        if (m5517c()) {
            this.f2887d = C1086b.SOURCE;
            this.f2885b.m5487b(this);
            return;
        }
        this.f2885b.m5486a(exception);
    }

    private boolean m5517c() {
        return this.f2887d == C1086b.CACHE;
    }

    private C1084k<?> m5518d() {
        return m5517c() ? m5519e() : m5520f();
    }

    private C1084k<?> m5519e() {
        C1084k<?> a;
        try {
            a = this.f2886c.m5403a();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            a = null;
        }
        return a == null ? this.f2886c.m5404b() : a;
    }

    private C1084k<?> m5520f() {
        return this.f2886c.m5405c();
    }

    public void m5521a() {
        this.f2888e = true;
        this.f2886c.m5406d();
    }

    public int m5522b() {
        return this.f2884a.ordinal();
    }

    public void run() {
        Exception exception = null;
        if (!this.f2888e) {
            C1084k d;
            try {
                d = m5518d();
            } catch (Throwable e) {
                if (Log.isLoggable("EngineRunnable", 2)) {
                    Log.v("EngineRunnable", "Exception decoding", e);
                }
                Throwable th = e;
                Object obj = null;
            }
            if (this.f2888e) {
                if (d != null) {
                    d.m5507d();
                }
            } else if (d == null) {
                m5516a(exception);
            } else {
                m5515a(d);
            }
        }
    }
}
