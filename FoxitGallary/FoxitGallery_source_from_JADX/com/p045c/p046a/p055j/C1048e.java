package com.p045c.p046a.p055j;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.c.a.j.e */
public class C1048e<T, Y> {
    private final LinkedHashMap<T, Y> f2795a;
    private int f2796b;
    private final int f2797c;
    private int f2798d;

    public C1048e(int i) {
        this.f2795a = new LinkedHashMap(100, 0.75f, true);
        this.f2798d = 0;
        this.f2797c = i;
        this.f2796b = i;
    }

    private void m5426c() {
        m5433b(this.f2796b);
    }

    protected int m5427a(Y y) {
        return 1;
    }

    public void m5428a() {
        m5433b(0);
    }

    protected void m5429a(T t, Y y) {
    }

    public int m5430b() {
        return this.f2798d;
    }

    public Y m5431b(T t) {
        return this.f2795a.get(t);
    }

    public Y m5432b(T t, Y y) {
        if (m5427a(y) >= this.f2796b) {
            m5429a(t, y);
            return null;
        }
        Y put = this.f2795a.put(t, y);
        if (y != null) {
            this.f2798d += m5427a(y);
        }
        if (put != null) {
            this.f2798d -= m5427a(put);
        }
        m5426c();
        return put;
    }

    protected void m5433b(int i) {
        while (this.f2798d > i) {
            Entry entry = (Entry) this.f2795a.entrySet().iterator().next();
            Object value = entry.getValue();
            this.f2798d -= m5427a(value);
            Object key = entry.getKey();
            this.f2795a.remove(key);
            m5429a(key, value);
        }
    }

    public Y m5434c(T t) {
        Y remove = this.f2795a.remove(t);
        if (remove != null) {
            this.f2798d -= m5427a(remove);
        }
        return remove;
    }
}
