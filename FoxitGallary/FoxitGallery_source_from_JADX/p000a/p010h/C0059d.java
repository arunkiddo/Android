package p000a.p010h;

import java.util.Iterator;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.h.d */
class C0059d extends C0058c {

    /* renamed from: a.h.d.a */
    public static final class C0061a implements Iterable<T> {
        final /* synthetic */ C0057a f28a;

        C0061a(C0057a c0057a) {
            this.f28a = c0057a;
        }

        public Iterator<T> iterator() {
            return this.f28a.m81a();
        }
    }

    public static final <T> Iterable<T> m82a(C0057a<? extends T> c0057a) {
        C0036f.m62b(c0057a, "$receiver");
        return new C0061a(c0057a);
    }
}
