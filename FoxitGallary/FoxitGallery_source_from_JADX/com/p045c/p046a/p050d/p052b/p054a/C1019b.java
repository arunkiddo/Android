package com.p045c.p046a.p050d.p052b.p054a;

import com.p045c.p046a.p055j.C1296h;
import java.util.Queue;

/* renamed from: com.c.a.d.b.a.b */
abstract class C1019b<T extends C1017h> {
    private final Queue<T> f2736a;

    C1019b() {
        this.f2736a = C1296h.m6112a(20);
    }

    public void m5318a(T t) {
        if (this.f2736a.size() < 20) {
            this.f2736a.offer(t);
        }
    }

    protected abstract T m5319b();

    protected T m5320c() {
        C1017h c1017h = (C1017h) this.f2736a.poll();
        return c1017h == null ? m5319b() : c1017h;
    }
}
