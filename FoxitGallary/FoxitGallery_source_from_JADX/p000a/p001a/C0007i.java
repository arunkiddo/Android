package p000a.p001a;

import java.util.Collection;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.a.i */
class C0007i extends C0006h {
    public static final <T> int m15a(Iterable<? extends T> iterable, int i) {
        C0036f.m62b(iterable, "$receiver");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
