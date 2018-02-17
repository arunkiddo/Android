package com.p045c.p046a.p064g;

import com.p045c.p046a.p055j.C1294g;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.c.a.g.c */
public class C1252c {
    private static final C1294g f3142a;
    private final Map<C1294g, C1153b<?, ?>> f3143b;

    static {
        f3142a = new C1294g();
    }

    public C1252c() {
        this.f3143b = new HashMap();
    }

    public <T, Z> C1153b<T, Z> m5917a(Class<T> cls, Class<Z> cls2) {
        C1153b<T, Z> c1153b;
        synchronized (f3142a) {
            f3142a.m6105a(cls, cls2);
            c1153b = (C1153b) this.f3143b.get(f3142a);
        }
        return c1153b == null ? C1253d.m5919e() : c1153b;
    }

    public <T, Z> void m5918a(Class<T> cls, Class<Z> cls2, C1153b<T, Z> c1153b) {
        this.f3143b.put(new C1294g(cls, cls2), c1153b);
    }
}
