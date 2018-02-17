package android.support.v4.p030j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.j.g */
abstract class C0377g<K, V> {
    C0387b f710b;
    C0388c f711c;
    C0390e f712d;

    /* renamed from: android.support.v4.j.g.a */
    final class C0386a<T> implements Iterator<T> {
        final int f740a;
        int f741b;
        int f742c;
        boolean f743d;
        final /* synthetic */ C0377g f744e;

        C0386a(C0377g c0377g, int i) {
            this.f744e = c0377g;
            this.f743d = false;
            this.f740a = i;
            this.f741b = c0377g.m1390a();
        }

        public boolean hasNext() {
            return this.f742c < this.f741b;
        }

        public T next() {
            T a = this.f744e.m1392a(this.f742c, this.f740a);
            this.f742c++;
            this.f743d = true;
            return a;
        }

        public void remove() {
            if (this.f743d) {
                this.f742c--;
                this.f741b--;
                this.f743d = false;
                this.f744e.m1394a(this.f742c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: android.support.v4.j.g.b */
    final class C0387b implements Set<Entry<K, V>> {
        final /* synthetic */ C0377g f745a;

        C0387b(C0377g c0377g) {
            this.f745a = c0377g;
        }

        public boolean m1452a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1452a((Entry) obj);
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f745a.m1390a();
            for (Entry entry : collection) {
                this.f745a.m1395a(entry.getKey(), entry.getValue());
            }
            return a != this.f745a.m1390a();
        }

        public void clear() {
            this.f745a.m1400c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f745a.m1391a(entry.getKey());
            return a >= 0 ? C0381b.m1429a(this.f745a.m1392a(a, 1), entry.getValue()) : false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return C0377g.m1387a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f745a.m1390a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f745a.m1392a(a, 0);
                Object a3 = this.f745a.m1392a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f745a.m1390a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0389d(this.f745a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f745a.m1390a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: android.support.v4.j.g.c */
    final class C0388c implements Set<K> {
        final /* synthetic */ C0377g f746a;

        C0388c(C0377g c0377g) {
            this.f746a = c0377g;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f746a.m1400c();
        }

        public boolean contains(Object obj) {
            return this.f746a.m1391a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0377g.m1386a(this.f746a.m1398b(), (Collection) collection);
        }

        public boolean equals(Object obj) {
            return C0377g.m1387a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f746a.m1390a() - 1; a >= 0; a--) {
                Object a2 = this.f746a.m1392a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f746a.m1390a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0386a(this.f746a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f746a.m1391a(obj);
            if (a < 0) {
                return false;
            }
            this.f746a.m1394a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0377g.m1388b(this.f746a.m1398b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0377g.m1389c(this.f746a.m1398b(), collection);
        }

        public int size() {
            return this.f746a.m1390a();
        }

        public Object[] toArray() {
            return this.f746a.m1399b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f746a.m1396a((Object[]) tArr, 0);
        }
    }

    /* renamed from: android.support.v4.j.g.d */
    final class C0389d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f747a;
        int f748b;
        boolean f749c;
        final /* synthetic */ C0377g f750d;

        C0389d(C0377g c0377g) {
            this.f750d = c0377g;
            this.f749c = false;
            this.f747a = c0377g.m1390a() - 1;
            this.f748b = -1;
        }

        public Entry<K, V> m1453a() {
            this.f748b++;
            this.f749c = true;
            return this;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f749c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0381b.m1429a(entry.getKey(), this.f750d.m1392a(this.f748b, 0)) && C0381b.m1429a(entry.getValue(), this.f750d.m1392a(this.f748b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.f749c) {
                return this.f750d.m1392a(this.f748b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f749c) {
                return this.f750d.m1392a(this.f748b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f748b < this.f747a;
        }

        public final int hashCode() {
            int i = 0;
            if (this.f749c) {
                Object a = this.f750d.m1392a(this.f748b, 0);
                Object a2 = this.f750d.m1392a(this.f748b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public /* synthetic */ Object next() {
            return m1453a();
        }

        public void remove() {
            if (this.f749c) {
                this.f750d.m1394a(this.f748b);
                this.f748b--;
                this.f747a--;
                this.f749c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f749c) {
                return this.f750d.m1393a(this.f748b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: android.support.v4.j.g.e */
    final class C0390e implements Collection<V> {
        final /* synthetic */ C0377g f751a;

        C0390e(C0377g c0377g) {
            this.f751a = c0377g;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f751a.m1400c();
        }

        public boolean contains(Object obj) {
            return this.f751a.m1397b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f751a.m1390a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0386a(this.f751a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f751a.m1397b(obj);
            if (b < 0) {
                return false;
            }
            this.f751a.m1394a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f751a.m1390a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f751a.m1392a(i, 1))) {
                    this.f751a.m1394a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f751a.m1390a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f751a.m1392a(i, 1))) {
                    this.f751a.m1394a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f751a.m1390a();
        }

        public Object[] toArray() {
            return this.f751a.m1399b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f751a.m1396a((Object[]) tArr, 1);
        }
    }

    C0377g() {
    }

    public static <K, V> boolean m1386a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean m1387a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean m1388b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m1389c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int m1390a();

    protected abstract int m1391a(Object obj);

    protected abstract Object m1392a(int i, int i2);

    protected abstract V m1393a(int i, V v);

    protected abstract void m1394a(int i);

    protected abstract void m1395a(K k, V v);

    public <T> T[] m1396a(T[] tArr, int i) {
        int a = m1390a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = m1392a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int m1397b(Object obj);

    protected abstract Map<K, V> m1398b();

    public Object[] m1399b(int i) {
        int a = m1390a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m1392a(i2, i);
        }
        return objArr;
    }

    protected abstract void m1400c();

    public Set<Entry<K, V>> m1401d() {
        if (this.f710b == null) {
            this.f710b = new C0387b(this);
        }
        return this.f710b;
    }

    public Set<K> m1402e() {
        if (this.f711c == null) {
            this.f711c = new C0388c(this);
        }
        return this.f711c;
    }

    public Collection<V> m1403f() {
        if (this.f712d == null) {
            this.f712d = new C0390e(this);
        }
        return this.f712d;
    }
}
