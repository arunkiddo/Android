package p000a.p001a;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: a.a.n */
public final class C0013n implements ListIterator {
    public static final C0013n f2a = null;

    static {
        C0013n c0013n = new C0013n();
    }

    private C0013n() {
        f2a = this;
    }

    public Void m31a() {
        throw new NoSuchElementException();
    }

    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public Void m32b() {
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public /* synthetic */ Object next() {
        return m31a();
    }

    public int nextIndex() {
        return 0;
    }

    public /* synthetic */ Object previous() {
        return m32b();
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }
}
