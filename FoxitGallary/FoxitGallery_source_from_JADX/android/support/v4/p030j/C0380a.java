package android.support.v4.p030j;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.j.a */
public class C0380a<K, V> extends C0379j<K, V> implements Map<K, V> {
    C0377g<K, V> f721a;

    /* renamed from: android.support.v4.j.a.1 */
    class C03781 extends C0377g<K, V> {
        final /* synthetic */ C0380a f713a;

        C03781(C0380a c0380a) {
            this.f713a = c0380a;
        }

        protected int m1404a() {
            return this.f713a.h;
        }

        protected int m1405a(Object obj) {
            return this.f713a.m1416a(obj);
        }

        protected Object m1406a(int i, int i2) {
            return this.f713a.g[(i << 1) + i2];
        }

        protected V m1407a(int i, V v) {
            return this.f713a.m1418a(i, (Object) v);
        }

        protected void m1408a(int i) {
            this.f713a.m1423d(i);
        }

        protected void m1409a(K k, V v) {
            this.f713a.put(k, v);
        }

        protected int m1410b(Object obj) {
            return this.f713a.m1420b(obj);
        }

        protected Map<K, V> m1411b() {
            return this.f713a;
        }

        protected void m1412c() {
            this.f713a.clear();
        }
    }

    public C0380a(int i) {
        super(i);
    }

    private C0377g<K, V> m1424b() {
        if (this.f721a == null) {
            this.f721a = new C03781(this);
        }
        return this.f721a;
    }

    public boolean m1425a(Collection<?> collection) {
        return C0377g.m1389c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1424b().m1401d();
    }

    public Set<K> keySet() {
        return m1424b().m1402e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1419a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return m1424b().m1403f();
    }
}
