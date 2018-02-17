package com.p045c.p046a.p050d.p062d.p071f;

import com.p045c.p046a.p055j.C1294g;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.c.a.d.d.f.d */
public class C1223d {
    private static final C1294g f3093a;
    private final Map<C1294g, C1220c<?, ?>> f3094b;

    static {
        f3093a = new C1294g();
    }

    public C1223d() {
        this.f3094b = new HashMap();
    }

    public <Z, R> C1220c<Z, R> m5847a(Class<Z> cls, Class<R> cls2) {
        if (cls.equals(cls2)) {
            return C1224e.m5849b();
        }
        synchronized (f3093a) {
            f3093a.m6105a(cls, cls2);
            C1220c<Z, R> c1220c = (C1220c) this.f3094b.get(f3093a);
        }
        if (c1220c != null) {
            return c1220c;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }

    public <Z, R> void m5848a(Class<Z> cls, Class<R> cls2, C1220c<Z, R> c1220c) {
        this.f3094b.put(new C1294g(cls, cls2), c1220c);
    }
}
