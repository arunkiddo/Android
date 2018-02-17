package p000a.p001a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p000a.p005e.p007b.C0033c;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.a.o */
public final class C0014o implements Serializable, List, RandomAccess {
    public static final C0014o f3a = null;

    static {
        C0014o c0014o = new C0014o();
    }

    private C0014o() {
        f3a = this;
    }

    public int m33a() {
        return 0;
    }

    public Void m34a(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + ".");
    }

    public boolean m35a(Void voidR) {
        C0036f.m62b(voidR, "element");
        return false;
    }

    public /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public int m36b(Void voidR) {
        C0036f.m62b(voidR, "element");
        return -1;
    }

    public int m37c(Void voidR) {
        C0036f.m62b(voidR, "element");
        return -1;
    }

    public void clear() {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public final boolean contains(Object obj) {
        return !(obj instanceof Void) ? false : m35a((Void) obj);
    }

    public boolean containsAll(Collection collection) {
        C0036f.m62b(collection, "elements");
        return collection.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public /* synthetic */ Object get(int i) {
        return m34a(i);
    }

    public int hashCode() {
        return 1;
    }

    public final int indexOf(Object obj) {
        return !(obj instanceof Void) ? -1 : m36b((Void) obj);
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return C0013n.f2a;
    }

    public final int lastIndexOf(Object obj) {
        return !(obj instanceof Void) ? -1 : m37c((Void) obj);
    }

    public ListIterator listIterator() {
        return C0013n.f2a;
    }

    public ListIterator listIterator(int i) {
        if (i == 0) {
            return C0013n.f2a;
        }
        throw new IndexOutOfBoundsException("Index: " + i);
    }

    public /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }

    public final int size() {
        return m33a();
    }

    public List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2);
    }

    public Object[] toArray() {
        return C0033c.m53a(this);
    }

    public Object[] toArray(Object[] objArr) {
        return C0033c.m54a((Collection) this, objArr);
    }

    public String toString() {
        return "[]";
    }
}
