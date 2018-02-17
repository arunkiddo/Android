package p000a.p005e.p007b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: a.e.b.c */
public class C0033c {
    private static final Object[] f9a;

    static {
        f9a = new Object[0];
    }

    public static Object[] m53a(Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return f9a;
        }
        Object[] objArr = new Object[size];
        Iterator it = collection.iterator();
        for (int i = 0; i < size; i++) {
            if (!it.hasNext()) {
                return Arrays.copyOf(objArr, i);
            }
            objArr[i] = it.next();
        }
        return it.hasNext() ? C0033c.m55a(objArr, it) : objArr;
    }

    public static <T, E> T[] m54a(Collection<E> collection, T[] tArr) {
        int size = collection.size();
        Object[] objArr = tArr.length >= size ? tArr : (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        Iterator it = collection.iterator();
        int i = 0;
        while (i < objArr.length) {
            if (it.hasNext()) {
                objArr[i] = it.next();
                i++;
            } else if (tArr != objArr) {
                return Arrays.copyOf(objArr, i);
            } else {
                objArr[i] = null;
                return objArr;
            }
        }
        return it.hasNext() ? C0033c.m55a(objArr, it) : objArr;
    }

    private static <T> T[] m55a(T[] tArr, Iterator<?> it) {
        int length = tArr.length;
        while (it.hasNext()) {
            int i;
            int length2 = tArr.length;
            if (length == length2) {
                i = ((length2 / 2) + 1) * 3;
                if (i <= length2) {
                    if (length2 == Integer.MAX_VALUE) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    i = Integer.MAX_VALUE;
                }
                tArr = Arrays.copyOf(tArr, i);
            }
            i = length + 1;
            tArr[length] = it.next();
            length = i;
        }
        return length == tArr.length ? tArr : Arrays.copyOf(tArr, length);
    }
}
