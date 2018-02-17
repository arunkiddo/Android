package com.p045c.p046a.p058h.p073a;

import com.p045c.p046a.p058h.p073a.C1266f.C1257a;

/* renamed from: com.c.a.h.a.g */
public class C1267g<R> implements C1259d<R> {
    private final C1257a f3167a;
    private C1261c<R> f3168b;

    C1267g(C1257a c1257a) {
        this.f3167a = c1257a;
    }

    public C1261c<R> m5979a(boolean z, boolean z2) {
        if (z || !z2) {
            return C1265e.m5975b();
        }
        if (this.f3168b == null) {
            this.f3168b = new C1266f(this.f3167a);
        }
        return this.f3168b;
    }
}
