package p000a.p001a;

import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.a.e */
class C0003e extends C0002d {
    public static final char m1a(char[] cArr) {
        C0036f.m62b(cArr, "$receiver");
        switch (cArr.length) {
            case C1373c.View_android_theme /*0*/:
                throw new NoSuchElementException("Array is empty.");
            case C1373c.View_android_focusable /*1*/:
                return cArr[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final <T> List<T> m2a(T[] tArr) {
        C0036f.m62b(tArr, "$receiver");
        Object a = C0005f.m8a(tArr);
        C0036f.m59a(a, "ArraysUtilJVM.asList(this)");
        return a;
    }

    public static final <T> void m3a(T[] tArr, Comparator<? super T> comparator) {
        C0036f.m62b(tArr, "$receiver");
        C0036f.m62b(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final boolean m4a(char[] cArr, char c) {
        C0036f.m62b(cArr, "$receiver");
        return C0003e.m6b(cArr, c) >= 0;
    }

    public static final <T> boolean m5a(T[] tArr, T t) {
        C0036f.m62b(tArr, "$receiver");
        return C0003e.m7b((Object[]) tArr, (Object) t) >= 0;
    }

    public static final int m6b(char[] cArr, char c) {
        C0036f.m62b(cArr, "$receiver");
        int i = 0;
        int length = cArr.length - 1;
        if (0 <= length) {
            while (c != cArr[i]) {
                if (i != length) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public static final <T> int m7b(T[] tArr, T t) {
        int i = 0;
        C0036f.m62b(tArr, "$receiver");
        int length;
        if (t == null) {
            length = tArr.length - 1;
            if (0 <= length) {
                while (tArr[i] != null) {
                    if (i != length) {
                        i++;
                    }
                }
                return i;
            }
        }
        length = tArr.length - 1;
        if (0 <= length) {
            while (!C0036f.m61a((Object) t, tArr[i])) {
                if (i != length) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }
}
