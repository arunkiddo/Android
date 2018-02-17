package com.p045c.p046a.p050d.p052b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.p052b.C1087i.C1079a;
import com.p045c.p046a.p055j.C1296h;
import com.p045c.p046a.p058h.C1078e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* renamed from: com.c.a.d.b.d */
class C1080d implements C1079a {
    private static final C1075a f2844a;
    private static final Handler f2845b;
    private final List<C1078e> f2846c;
    private final C1075a f2847d;
    private final C1071e f2848e;
    private final C1081c f2849f;
    private final ExecutorService f2850g;
    private final ExecutorService f2851h;
    private final boolean f2852i;
    private boolean f2853j;
    private C1084k<?> f2854k;
    private boolean f2855l;
    private Exception f2856m;
    private boolean f2857n;
    private Set<C1078e> f2858o;
    private C1087i f2859p;
    private C1085h<?> f2860q;
    private volatile Future<?> f2861r;

    /* renamed from: com.c.a.d.b.d.a */
    static class C1075a {
        C1075a() {
        }

        public <R> C1085h<R> m5484a(C1084k<R> c1084k, boolean z) {
            return new C1085h(c1084k, z);
        }
    }

    /* renamed from: com.c.a.d.b.d.b */
    private static class C1076b implements Callback {
        private C1076b() {
        }

        public boolean handleMessage(Message message) {
            if (1 != message.what && 2 != message.what) {
                return false;
            }
            C1080d c1080d = (C1080d) message.obj;
            if (1 == message.what) {
                c1080d.m5489b();
            } else {
                c1080d.m5491c();
            }
            return true;
        }
    }

    static {
        f2844a = new C1075a();
        f2845b = new Handler(Looper.getMainLooper(), new C1076b());
    }

    public C1080d(C1081c c1081c, ExecutorService executorService, ExecutorService executorService2, boolean z, C1071e c1071e) {
        this(c1081c, executorService, executorService2, z, c1071e, f2844a);
    }

    public C1080d(C1081c c1081c, ExecutorService executorService, ExecutorService executorService2, boolean z, C1071e c1071e, C1075a c1075a) {
        this.f2846c = new ArrayList();
        this.f2849f = c1081c;
        this.f2850g = executorService;
        this.f2851h = executorService2;
        this.f2852i = z;
        this.f2848e = c1071e;
        this.f2847d = c1075a;
    }

    private void m5489b() {
        if (this.f2853j) {
            this.f2854k.m5507d();
        } else if (this.f2846c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            this.f2860q = this.f2847d.m5484a(this.f2854k, this.f2852i);
            this.f2855l = true;
            this.f2860q.m5513e();
            this.f2848e.m5471a(this.f2849f, this.f2860q);
            for (C1078e c1078e : this.f2846c) {
                if (!m5493d(c1078e)) {
                    this.f2860q.m5513e();
                    c1078e.m5485a(this.f2860q);
                }
            }
            this.f2860q.m5514f();
        }
    }

    private void m5491c() {
        if (!this.f2853j) {
            if (this.f2846c.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.f2857n = true;
            this.f2848e.m5471a(this.f2849f, null);
            for (C1078e c1078e : this.f2846c) {
                if (!m5493d(c1078e)) {
                    c1078e.m5486a(this.f2856m);
                }
            }
        }
    }

    private void m5492c(C1078e c1078e) {
        if (this.f2858o == null) {
            this.f2858o = new HashSet();
        }
        this.f2858o.add(c1078e);
    }

    private boolean m5493d(C1078e c1078e) {
        return this.f2858o != null && this.f2858o.contains(c1078e);
    }

    void m5494a() {
        if (!this.f2857n && !this.f2855l && !this.f2853j) {
            this.f2859p.m5521a();
            Future future = this.f2861r;
            if (future != null) {
                future.cancel(true);
            }
            this.f2853j = true;
            this.f2848e.m5470a(this, this.f2849f);
        }
    }

    public void m5495a(C1087i c1087i) {
        this.f2859p = c1087i;
        this.f2861r = this.f2850g.submit(c1087i);
    }

    public void m5496a(C1084k<?> c1084k) {
        this.f2854k = c1084k;
        f2845b.obtainMessage(1, this).sendToTarget();
    }

    public void m5497a(C1078e c1078e) {
        C1296h.m6113a();
        if (this.f2855l) {
            c1078e.m5485a(this.f2860q);
        } else if (this.f2857n) {
            c1078e.m5486a(this.f2856m);
        } else {
            this.f2846c.add(c1078e);
        }
    }

    public void m5498a(Exception exception) {
        this.f2856m = exception;
        f2845b.obtainMessage(2, this).sendToTarget();
    }

    public void m5499b(C1087i c1087i) {
        this.f2861r = this.f2851h.submit(c1087i);
    }

    public void m5500b(C1078e c1078e) {
        C1296h.m6113a();
        if (this.f2855l || this.f2857n) {
            m5492c(c1078e);
            return;
        }
        this.f2846c.remove(c1078e);
        if (this.f2846c.isEmpty()) {
            m5494a();
        }
    }
}
