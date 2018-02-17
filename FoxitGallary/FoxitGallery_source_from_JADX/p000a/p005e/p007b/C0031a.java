package p000a.p005e.p007b;

import java.util.Iterator;

/* renamed from: a.e.b.a */
final class C0031a<T> implements Iterator<T> {
    private int f7a;
    private final T[] f8b;

    public C0031a(T[] tArr) {
        C0036f.m62b(tArr, "array");
        this.f8b = tArr;
    }

    public boolean hasNext() {
        return this.f7a < this.f8b.length;
    }

    public T next() {
        Object[] objArr = this.f8b;
        int i = this.f7a;
        this.f7a = i + 1;
        return objArr[i];
    }

    public void remove() {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }
}
