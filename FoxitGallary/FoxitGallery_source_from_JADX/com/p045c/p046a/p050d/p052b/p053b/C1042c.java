package com.p045c.p046a.p050d.p052b.p053b;

import com.p045c.p046a.p050d.C1081c;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.c.a.d.b.b.c */
final class C1042c {
    private final Map<C1081c, C1040a> f2783a;
    private final C1041b f2784b;

    /* renamed from: com.c.a.d.b.b.c.a */
    private static class C1040a {
        final Lock f2780a;
        int f2781b;

        private C1040a() {
            this.f2780a = new ReentrantLock();
        }
    }

    /* renamed from: com.c.a.d.b.b.c.b */
    private static class C1041b {
        private final Queue<C1040a> f2782a;

        private C1041b() {
            this.f2782a = new ArrayDeque();
        }

        C1040a m5414a() {
            C1040a c1040a;
            synchronized (this.f2782a) {
                c1040a = (C1040a) this.f2782a.poll();
            }
            return c1040a == null ? new C1040a() : c1040a;
        }

        void m5415a(C1040a c1040a) {
            synchronized (this.f2782a) {
                if (this.f2782a.size() < 10) {
                    this.f2782a.offer(c1040a);
                }
            }
        }
    }

    C1042c() {
        this.f2783a = new HashMap();
        this.f2784b = new C1041b();
    }

    void m5416a(C1081c c1081c) {
        C1040a c1040a;
        synchronized (this) {
            c1040a = (C1040a) this.f2783a.get(c1081c);
            if (c1040a == null) {
                c1040a = this.f2784b.m5414a();
                this.f2783a.put(c1081c, c1040a);
            }
            c1040a.f2781b++;
        }
        c1040a.f2780a.lock();
    }

    void m5417b(C1081c c1081c) {
        C1040a c1040a;
        synchronized (this) {
            c1040a = (C1040a) this.f2783a.get(c1081c);
            if (c1040a == null || c1040a.f2781b <= 0) {
                throw new IllegalArgumentException("Cannot release a lock that is not held, key: " + c1081c + ", interestedThreads: " + (c1040a == null ? 0 : c1040a.f2781b));
            }
            int i = c1040a.f2781b - 1;
            c1040a.f2781b = i;
            if (i == 0) {
                C1040a c1040a2 = (C1040a) this.f2783a.remove(c1081c);
                if (c1040a2.equals(c1040a)) {
                    this.f2784b.m5415a(c1040a2);
                } else {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c1040a + ", but actually removed: " + c1040a2 + ", key: " + c1081c);
                }
            }
        }
        c1040a.f2780a.unlock();
    }
}
