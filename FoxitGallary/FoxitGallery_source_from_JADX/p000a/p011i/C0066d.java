package p000a.p011i;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p000a.C0019b;
import p000a.C0027d;
import p000a.p005e.p006a.C0030c;
import p000a.p005e.p007b.C0036f;
import p000a.p008f.C0051c;
import p000a.p010h.C0057a;

/* renamed from: a.i.d */
final class C0066d implements C0057a<C0051c> {
    private final CharSequence f35a;
    private final int f36b;
    private final int f37c;
    private final C0030c<CharSequence, Integer, C0019b<Integer, Integer>> f38d;

    /* renamed from: a.i.d.a */
    public static final class C0065a implements Iterator<C0051c> {
        final /* synthetic */ C0066d f29a;
        private int f30b;
        private int f31c;
        private int f32d;
        private C0051c f33e;
        private int f34f;

        C0065a(C0066d c0066d) {
            this.f29a = c0066d;
            this.f30b = -1;
            this.f31c = Math.min(Math.max(c0066d.f36b, 0), c0066d.f35a.length());
            this.f32d = this.f31c;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void m85b() {
            /*
            r7 = this;
            r2 = 1;
            r3 = 0;
            r5 = -1;
            r0 = r7.f32d;
            if (r0 >= 0) goto L_0x000f;
        L_0x0007:
            r7.f30b = r3;
            r0 = 0;
            r0 = (p000a.p008f.C0051c) r0;
            r7.f33e = r0;
        L_0x000e:
            return;
        L_0x000f:
            r0 = r7.f29a;
            r0 = r0.f37c;
            if (r0 <= 0) goto L_0x0027;
        L_0x0017:
            r0 = r7.f34f;
            r0 = r0 + 1;
            r7.f34f = r0;
            r0 = r7.f34f;
            r1 = r7.f29a;
            r1 = r1.f37c;
            if (r0 >= r1) goto L_0x0035;
        L_0x0027:
            r0 = r7.f32d;
            r1 = r7.f29a;
            r1 = r1.f35a;
            r1 = r1.length();
            if (r0 <= r1) goto L_0x004d;
        L_0x0035:
            r0 = r7.f31c;
            r1 = new a.f.c;
            r3 = r7.f29a;
            r3 = r3.f35a;
            r3 = p000a.p011i.C0078o.m136c(r3);
            r1.<init>(r0, r3);
            r7.f33e = r1;
            r7.f32d = r5;
        L_0x004a:
            r7.f30b = r2;
            goto L_0x000e;
        L_0x004d:
            r0 = r7.f29a;
            r0 = r0.f38d;
            r1 = r7.f29a;
            r1 = r1.f35a;
            r4 = r7.f32d;
            r4 = java.lang.Integer.valueOf(r4);
            r0 = r0.invoke(r1, r4);
            r0 = (p000a.C0019b) r0;
            if (r0 != 0) goto L_0x007d;
        L_0x0067:
            r0 = r7.f31c;
            r1 = new a.f.c;
            r3 = r7.f29a;
            r3 = r3.f35a;
            r3 = p000a.p011i.C0078o.m136c(r3);
            r1.<init>(r0, r3);
            r7.f33e = r1;
            r7.f32d = r5;
            goto L_0x004a;
        L_0x007d:
            r1 = r0.m45c();
            r1 = (java.lang.Number) r1;
            r1 = r1.intValue();
            r0 = r0.m46d();
            r0 = (java.lang.Number) r0;
            r0 = r0.intValue();
            r4 = r7.f31c;
            r5 = new a.f.c;
            r6 = r1 + -1;
            r5.<init>(r4, r6);
            r7.f33e = r5;
            r1 = r1 + r0;
            r7.f31c = r1;
            r1 = r7.f31c;
            if (r0 != 0) goto L_0x00a8;
        L_0x00a3:
            r0 = r2;
        L_0x00a4:
            r0 = r0 + r1;
            r7.f32d = r0;
            goto L_0x004a;
        L_0x00a8:
            r0 = r3;
            goto L_0x00a4;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.i.d.a.b():void");
        }

        public C0051c m86a() {
            if (this.f30b == -1) {
                m85b();
            }
            if (this.f30b == 0) {
                throw new NoSuchElementException();
            }
            C0051c c0051c = this.f33e;
            if (c0051c == null) {
                throw new C0027d("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            c0051c = c0051c;
            this.f33e = (C0051c) null;
            this.f30b = -1;
            return c0051c;
        }

        public boolean hasNext() {
            if (this.f30b == -1) {
                m85b();
            }
            return this.f30b == 1;
        }

        public /* synthetic */ Object next() {
            return m86a();
        }

        public void remove() {
            throw new UnsupportedOperationException("Mutating immutable collection");
        }
    }

    public C0066d(CharSequence charSequence, int i, int i2, C0030c<? super CharSequence, ? super Integer, C0019b<Integer, Integer>> c0030c) {
        C0036f.m62b(charSequence, "input");
        C0036f.m62b(c0030c, "getNextMatch");
        this.f35a = charSequence;
        this.f36b = i;
        this.f37c = i2;
        this.f38d = c0030c;
    }

    public Iterator<C0051c> m91a() {
        return new C0065a(this);
    }
}
