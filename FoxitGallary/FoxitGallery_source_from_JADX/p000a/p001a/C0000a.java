package p000a.p001a;

import java.util.Collection;
import java.util.Iterator;
import p000a.p005e.p007b.C0032b;
import p000a.p005e.p007b.C0033c;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.a.a */
final class C0000a<T> implements Collection<T> {
    private final T[] f0a;
    private final boolean f1b;

    public C0000a(T[] tArr, boolean z) {
        C0036f.m62b(tArr, "values");
        this.f0a = tArr;
        this.f1b = z;
    }

    public int m0a() {
        return this.f0a.length;
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean contains(Object obj) {
        return C0003e.m5a(this.f0a, obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        C0036f.m62b(collection, "elements");
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f0a.length == 0;
    }

    public Iterator<T> iterator() {
        return C0032b.m52a(this.f0a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public final int size() {
        return m0a();
    }

    public final Object[] toArray() {
        return C0006h.m14b(this.f0a, this.f1b);
    }

    public Object[] toArray(Object[] objArr) {
        return C0033c.m54a((Collection) this, objArr);
    }
}
