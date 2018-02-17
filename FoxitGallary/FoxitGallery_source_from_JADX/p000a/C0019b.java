package p000a;

import java.io.Serializable;

/* renamed from: a.b */
public final class C0019b<A, B> implements Serializable {
    private final A f5a;
    private final B f6b;

    public C0019b(A a, B b) {
        this.f5a = a;
        this.f6b = b;
    }

    public final A m43a() {
        return this.f5a;
    }

    public final B m44b() {
        return this.f6b;
    }

    public final A m45c() {
        return this.f5a;
    }

    public final B m46d() {
        return this.f6b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001c;
    L_0x0002:
        r0 = r3 instanceof p000a.C0019b;
        if (r0 == 0) goto L_0x001e;
    L_0x0006:
        r3 = (p000a.C0019b) r3;
        r0 = r2.f5a;
        r1 = r3.f5a;
        r0 = p000a.p005e.p007b.C0036f.m61a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x0012:
        r0 = r2.f6b;
        r1 = r3.f6b;
        r0 = p000a.p005e.p007b.C0036f.m61a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x001c:
        r0 = 1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = 0;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        Object obj = this.f5a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f6b;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "(" + this.f5a + ", " + this.f6b + ")";
    }
}
