package com.p045c.p046a.p050d.p052b;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import com.p045c.p046a.C1298k;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p051a.C1000c;
import com.p045c.p046a.p050d.p052b.C1035a.C1013a;
import com.p045c.p046a.p050d.p052b.C1085h.C1072a;
import com.p045c.p046a.p050d.p052b.p053b.C1037a;
import com.p045c.p046a.p050d.p052b.p053b.C1037a.C1036a;
import com.p045c.p046a.p050d.p052b.p053b.C1038b;
import com.p045c.p046a.p050d.p052b.p053b.C1049h;
import com.p045c.p046a.p050d.p052b.p053b.C1049h.C1051a;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p055j.C1292d;
import com.p045c.p046a.p055j.C1296h;
import com.p045c.p046a.p058h.C1078e;
import com.p045c.p046a.p064g.C1153b;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* renamed from: com.c.a.d.b.c */
public class C1073c implements C1051a, C1071e, C1072a {
    private final Map<C1081c, C1080d> f2832a;
    private final C1083g f2833b;
    private final C1049h f2834c;
    private final C1057a f2835d;
    private final Map<C1081c, WeakReference<C1085h<?>>> f2836e;
    private final C1091l f2837f;
    private final C1058b f2838g;
    private ReferenceQueue<C1085h<?>> f2839h;

    /* renamed from: com.c.a.d.b.c.a */
    static class C1057a {
        private final ExecutorService f2812a;
        private final ExecutorService f2813b;
        private final C1071e f2814c;

        public C1057a(ExecutorService executorService, ExecutorService executorService2, C1071e c1071e) {
            this.f2812a = executorService;
            this.f2813b = executorService2;
            this.f2814c = c1071e;
        }

        public C1080d m5461a(C1081c c1081c, boolean z) {
            return new C1080d(c1081c, this.f2812a, this.f2813b, z, this.f2814c);
        }
    }

    /* renamed from: com.c.a.d.b.c.b */
    private static class C1058b implements C1013a {
        private final C1036a f2815a;
        private volatile C1037a f2816b;

        public C1058b(C1036a c1036a) {
            this.f2815a = c1036a;
        }

        public C1037a m5462a() {
            if (this.f2816b == null) {
                synchronized (this) {
                    if (this.f2816b == null) {
                        this.f2816b = this.f2815a.m5407a();
                    }
                    if (this.f2816b == null) {
                        this.f2816b = new C1038b();
                    }
                }
            }
            return this.f2816b;
        }
    }

    /* renamed from: com.c.a.d.b.c.c */
    public static class C1059c {
        private final C1080d f2817a;
        private final C1078e f2818b;

        public C1059c(C1078e c1078e, C1080d c1080d) {
            this.f2818b = c1078e;
            this.f2817a = c1080d;
        }

        public void m5463a() {
            this.f2817a.m5500b(this.f2818b);
        }
    }

    /* renamed from: com.c.a.d.b.c.d */
    private static class C1060d implements IdleHandler {
        private final Map<C1081c, WeakReference<C1085h<?>>> f2819a;
        private final ReferenceQueue<C1085h<?>> f2820b;

        public C1060d(Map<C1081c, WeakReference<C1085h<?>>> map, ReferenceQueue<C1085h<?>> referenceQueue) {
            this.f2819a = map;
            this.f2820b = referenceQueue;
        }

        public boolean queueIdle() {
            C1061e c1061e = (C1061e) this.f2820b.poll();
            if (c1061e != null) {
                this.f2819a.remove(c1061e.f2821a);
            }
            return true;
        }
    }

    /* renamed from: com.c.a.d.b.c.e */
    private static class C1061e extends WeakReference<C1085h<?>> {
        private final C1081c f2821a;

        public C1061e(C1081c c1081c, C1085h<?> c1085h, ReferenceQueue<? super C1085h<?>> referenceQueue) {
            super(c1085h, referenceQueue);
            this.f2821a = c1081c;
        }
    }

    public C1073c(C1049h c1049h, C1036a c1036a, ExecutorService executorService, ExecutorService executorService2) {
        this(c1049h, c1036a, executorService, executorService2, null, null, null, null, null);
    }

    C1073c(C1049h c1049h, C1036a c1036a, ExecutorService executorService, ExecutorService executorService2, Map<C1081c, C1080d> map, C1083g c1083g, Map<C1081c, WeakReference<C1085h<?>>> map2, C1057a c1057a, C1091l c1091l) {
        Map hashMap;
        Map hashMap2;
        this.f2834c = c1049h;
        this.f2838g = new C1058b(c1036a);
        if (map2 == null) {
            hashMap = new HashMap();
        }
        this.f2836e = hashMap;
        if (c1083g == null) {
            c1083g = new C1083g();
        }
        this.f2833b = c1083g;
        if (map == null) {
            hashMap2 = new HashMap();
        }
        this.f2832a = hashMap2;
        if (c1057a == null) {
            c1057a = new C1057a(executorService, executorService2, this);
        }
        this.f2835d = c1057a;
        if (c1091l == null) {
            c1091l = new C1091l();
        }
        this.f2837f = c1091l;
        c1049h.m5438a((C1051a) this);
    }

    private C1085h<?> m5473a(C1081c c1081c) {
        C1084k a = this.f2834c.m5435a(c1081c);
        return a == null ? null : a instanceof C1085h ? (C1085h) a : new C1085h(a, true);
    }

    private C1085h<?> m5474a(C1081c c1081c, boolean z) {
        if (!z) {
            return null;
        }
        C1085h<?> c1085h;
        WeakReference weakReference = (WeakReference) this.f2836e.get(c1081c);
        if (weakReference != null) {
            c1085h = (C1085h) weakReference.get();
            if (c1085h != null) {
                c1085h.m5513e();
            } else {
                this.f2836e.remove(c1081c);
            }
        } else {
            c1085h = null;
        }
        return c1085h;
    }

    private ReferenceQueue<C1085h<?>> m5475a() {
        if (this.f2839h == null) {
            this.f2839h = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new C1060d(this.f2836e, this.f2839h));
        }
        return this.f2839h;
    }

    private static void m5476a(String str, long j, C1081c c1081c) {
        Log.v("Engine", str + " in " + C1292d.m6101a(j) + "ms, key: " + c1081c);
    }

    private C1085h<?> m5477b(C1081c c1081c, boolean z) {
        if (!z) {
            return null;
        }
        C1085h<?> a = m5473a(c1081c);
        if (a == null) {
            return a;
        }
        a.m5513e();
        this.f2836e.put(c1081c, new C1061e(c1081c, a, m5475a()));
        return a;
    }

    public <T, Z, R> C1059c m5478a(C1081c c1081c, int i, int i2, C1000c<T> c1000c, C1153b<T, Z> c1153b, C1146g<Z> c1146g, C1220c<Z, R> c1220c, C1298k c1298k, boolean z, C1056b c1056b, C1078e c1078e) {
        C1296h.m6113a();
        long a = C1292d.m6102a();
        C1081c a2 = this.f2833b.m5504a(c1000c.m5267b(), c1081c, i, i2, c1153b.m5650a(), c1153b.m5651b(), c1146g, c1153b.m5653d(), c1220c, c1153b.m5652c());
        C1084k b = m5477b(a2, z);
        if (b != null) {
            c1078e.m5485a(b);
            if (Log.isLoggable("Engine", 2)) {
                C1073c.m5476a("Loaded resource from cache", a, a2);
            }
            return null;
        }
        b = m5474a(a2, z);
        if (b != null) {
            c1078e.m5485a(b);
            if (Log.isLoggable("Engine", 2)) {
                C1073c.m5476a("Loaded resource from active resources", a, a2);
            }
            return null;
        }
        C1080d c1080d = (C1080d) this.f2832a.get(a2);
        if (c1080d != null) {
            c1080d.m5497a(c1078e);
            if (Log.isLoggable("Engine", 2)) {
                C1073c.m5476a("Added to existing load", a, a2);
            }
            return new C1059c(c1078e, c1080d);
        }
        C1080d a3 = this.f2835d.m5461a(a2, z);
        C1087i c1087i = new C1087i(a3, new C1035a(a2, i, i2, c1000c, c1153b, c1146g, c1220c, this.f2838g, c1056b, c1298k), c1298k);
        this.f2832a.put(a2, a3);
        a3.m5497a(c1078e);
        a3.m5495a(c1087i);
        if (Log.isLoggable("Engine", 2)) {
            C1073c.m5476a("Started new load", a, a2);
        }
        return new C1059c(c1078e, a3);
    }

    public void m5479a(C1080d c1080d, C1081c c1081c) {
        C1296h.m6113a();
        if (c1080d.equals((C1080d) this.f2832a.get(c1081c))) {
            this.f2832a.remove(c1081c);
        }
    }

    public void m5480a(C1084k c1084k) {
        C1296h.m6113a();
        if (c1084k instanceof C1085h) {
            ((C1085h) c1084k).m5514f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void m5481a(C1081c c1081c, C1085h<?> c1085h) {
        C1296h.m6113a();
        if (c1085h != null) {
            c1085h.m5508a(c1081c, this);
            if (c1085h.m5509a()) {
                this.f2836e.put(c1081c, new C1061e(c1081c, c1085h, m5475a()));
            }
        }
        this.f2832a.remove(c1081c);
    }

    public void m5482b(C1084k<?> c1084k) {
        C1296h.m6113a();
        this.f2837f.m5524a(c1084k);
    }

    public void m5483b(C1081c c1081c, C1085h c1085h) {
        C1296h.m6113a();
        this.f2836e.remove(c1081c);
        if (c1085h.m5509a()) {
            this.f2834c.m5439b(c1081c, c1085h);
        } else {
            this.f2837f.m5524a(c1085h);
        }
    }
}
