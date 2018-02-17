package com.p045c.p046a.p050d.p059c;

import com.p045c.p046a.p055j.C1048e;
import com.p045c.p046a.p055j.C1296h;
import java.util.Queue;

/* renamed from: com.c.a.d.c.k */
public class C1140k<A, B> {
    private final C1048e<C1139a<A>, B> f2938a;

    /* renamed from: com.c.a.d.c.k.1 */
    class C11381 extends C1048e<C1139a<A>, B> {
        final /* synthetic */ C1140k f2933a;

        C11381(C1140k c1140k, int i) {
            this.f2933a = c1140k;
            super(i);
        }

        protected void m5606a(C1139a<A> c1139a, B b) {
            c1139a.m5610a();
        }
    }

    /* renamed from: com.c.a.d.c.k.a */
    static final class C1139a<A> {
        private static final Queue<C1139a<?>> f2934a;
        private int f2935b;
        private int f2936c;
        private A f2937d;

        static {
            f2934a = C1296h.m6112a(0);
        }

        private C1139a() {
        }

        static <A> C1139a<A> m5608a(A a, int i, int i2) {
            C1139a<A> c1139a = (C1139a) f2934a.poll();
            if (c1139a == null) {
                c1139a = new C1139a();
            }
            c1139a.m5609b(a, i, i2);
            return c1139a;
        }

        private void m5609b(A a, int i, int i2) {
            this.f2937d = a;
            this.f2936c = i;
            this.f2935b = i2;
        }

        public void m5610a() {
            f2934a.offer(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1139a)) {
                return false;
            }
            C1139a c1139a = (C1139a) obj;
            return this.f2936c == c1139a.f2936c && this.f2935b == c1139a.f2935b && this.f2937d.equals(c1139a.f2937d);
        }

        public int hashCode() {
            return (((this.f2935b * 31) + this.f2936c) * 31) + this.f2937d.hashCode();
        }
    }

    public C1140k() {
        this(250);
    }

    public C1140k(int i) {
        this.f2938a = new C11381(this, i);
    }

    public B m5611a(A a, int i, int i2) {
        Object a2 = C1139a.m5608a(a, i, i2);
        B b = this.f2938a.m5431b(a2);
        a2.m5610a();
        return b;
    }

    public void m5612a(A a, int i, int i2, B b) {
        this.f2938a.m5432b(C1139a.m5608a(a, i, i2), b);
    }
}
