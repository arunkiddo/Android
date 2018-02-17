package com.p045c.p046a.p050d.p052b.p054a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.c.a.d.b.a.e */
class C1026e<K extends C1017h, V> {
    private final C1025a<K, V> f2743a;
    private final Map<K, C1025a<K, V>> f2744b;

    /* renamed from: com.c.a.d.b.a.e.a */
    private static class C1025a<K, V> {
        C1025a<K, V> f2739a;
        C1025a<K, V> f2740b;
        private final K f2741c;
        private List<V> f2742d;

        public C1025a() {
            this(null);
        }

        public C1025a(K k) {
            this.f2740b = this;
            this.f2739a = this;
            this.f2741c = k;
        }

        public V m5350a() {
            int b = m5352b();
            return b > 0 ? this.f2742d.remove(b - 1) : null;
        }

        public void m5351a(V v) {
            if (this.f2742d == null) {
                this.f2742d = new ArrayList();
            }
            this.f2742d.add(v);
        }

        public int m5352b() {
            return this.f2742d != null ? this.f2742d.size() : 0;
        }
    }

    C1026e() {
        this.f2743a = new C1025a();
        this.f2744b = new HashMap();
    }

    private void m5353a(C1025a<K, V> c1025a) {
        C1026e.m5356d(c1025a);
        c1025a.f2740b = this.f2743a;
        c1025a.f2739a = this.f2743a.f2739a;
        C1026e.m5355c(c1025a);
    }

    private void m5354b(C1025a<K, V> c1025a) {
        C1026e.m5356d(c1025a);
        c1025a.f2740b = this.f2743a.f2740b;
        c1025a.f2739a = this.f2743a;
        C1026e.m5355c(c1025a);
    }

    private static <K, V> void m5355c(C1025a<K, V> c1025a) {
        c1025a.f2739a.f2740b = c1025a;
        c1025a.f2740b.f2739a = c1025a;
    }

    private static <K, V> void m5356d(C1025a<K, V> c1025a) {
        c1025a.f2740b.f2739a = c1025a.f2739a;
        c1025a.f2739a.f2740b = c1025a.f2740b;
    }

    public V m5357a() {
        for (C1025a c1025a = this.f2743a.f2740b; !c1025a.equals(this.f2743a); c1025a = c1025a.f2740b) {
            V a = c1025a.m5350a();
            if (a != null) {
                return a;
            }
            C1026e.m5356d(c1025a);
            this.f2744b.remove(c1025a.f2741c);
            ((C1017h) c1025a.f2741c).m5315a();
        }
        return null;
    }

    public V m5358a(K k) {
        C1025a c1025a = (C1025a) this.f2744b.get(k);
        if (c1025a == null) {
            c1025a = new C1025a(k);
            this.f2744b.put(k, c1025a);
        } else {
            k.m5315a();
        }
        m5353a(c1025a);
        return c1025a.m5350a();
    }

    public void m5359a(K k, V v) {
        C1025a c1025a = (C1025a) this.f2744b.get(k);
        if (c1025a == null) {
            c1025a = new C1025a(k);
            m5354b(c1025a);
            this.f2744b.put(k, c1025a);
        } else {
            k.m5315a();
        }
        c1025a.m5351a((Object) v);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (C1025a c1025a = this.f2743a.f2739a; !c1025a.equals(this.f2743a); c1025a = c1025a.f2739a) {
            obj = 1;
            stringBuilder.append('{').append(c1025a.f2741c).append(':').append(c1025a.m5352b()).append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.append(" )").toString();
    }
}
