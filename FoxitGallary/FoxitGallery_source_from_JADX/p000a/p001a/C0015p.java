package p000a.p001a;

import java.util.Iterator;

/* renamed from: a.a.p */
public abstract class C0015p implements Iterator<Integer> {
    public final Integer m38a() {
        return Integer.valueOf(m39b());
    }

    public abstract int m39b();

    public /* synthetic */ Object next() {
        return m38a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }
}
