package android.support.v7.widget;

import android.support.v4.p030j.C0380a;
import android.support.v4.p030j.C0384e;
import android.support.v4.p030j.C0394i.C0392a;
import android.support.v4.p030j.C0394i.C0393b;
import android.support.v7.widget.RecyclerView.C0836e.C0835c;
import android.support.v7.widget.RecyclerView.C0853v;

class bi {
    final C0380a<C0853v, C0920a> f2377a;
    final C0384e<C0853v> f2378b;

    /* renamed from: android.support.v7.widget.bi.b */
    interface C0823b {
        void m4041a(C0853v c0853v);

        void m4042a(C0853v c0853v, C0835c c0835c, C0835c c0835c2);

        void m4043b(C0853v c0853v, C0835c c0835c, C0835c c0835c2);

        void m4044c(C0853v c0853v, C0835c c0835c, C0835c c0835c2);
    }

    /* renamed from: android.support.v7.widget.bi.a */
    static class C0920a {
        static C0392a<C0920a> f2373d;
        int f2374a;
        C0835c f2375b;
        C0835c f2376c;

        static {
            f2373d = new C0393b(20);
        }

        private C0920a() {
        }

        static C0920a m4845a() {
            C0920a c0920a = (C0920a) f2373d.m1455a();
            return c0920a == null ? new C0920a() : c0920a;
        }

        static void m4846a(C0920a c0920a) {
            c0920a.f2374a = 0;
            c0920a.f2375b = null;
            c0920a.f2376c = null;
            f2373d.m1456a(c0920a);
        }

        static void m4847b() {
            do {
            } while (f2373d.m1455a() != null);
        }
    }

    bi() {
        this.f2377a = new C0380a();
        this.f2378b = new C0384e();
    }

    private C0835c m4848a(C0853v c0853v, int i) {
        C0835c c0835c = null;
        int a = this.f2377a.m1416a((Object) c0853v);
        if (a >= 0) {
            C0920a c0920a = (C0920a) this.f2377a.m1422c(a);
            if (!(c0920a == null || (c0920a.f2374a & i) == 0)) {
                c0920a.f2374a &= i ^ -1;
                if (i == 4) {
                    c0835c = c0920a.f2375b;
                } else if (i == 8) {
                    c0835c = c0920a.f2376c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((c0920a.f2374a & 12) == 0) {
                    this.f2377a.m1423d(a);
                    C0920a.m4846a(c0920a);
                }
            }
        }
        return c0835c;
    }

    C0853v m4849a(long j) {
        return (C0853v) this.f2378b.m1436a(j);
    }

    void m4850a() {
        this.f2377a.clear();
        this.f2378b.m1444c();
    }

    void m4851a(long j, C0853v c0853v) {
        this.f2378b.m1442b(j, c0853v);
    }

    void m4852a(C0853v c0853v, C0835c c0835c) {
        C0920a c0920a = (C0920a) this.f2377a.get(c0853v);
        if (c0920a == null) {
            c0920a = C0920a.m4845a();
            this.f2377a.put(c0853v, c0920a);
        }
        c0920a.f2375b = c0835c;
        c0920a.f2374a |= 4;
    }

    void m4853a(C0823b c0823b) {
        for (int size = this.f2377a.size() - 1; size >= 0; size--) {
            C0853v c0853v = (C0853v) this.f2377a.m1421b(size);
            C0920a c0920a = (C0920a) this.f2377a.m1423d(size);
            if ((c0920a.f2374a & 3) == 3) {
                c0823b.m4041a(c0853v);
            } else if ((c0920a.f2374a & 1) != 0) {
                if (c0920a.f2375b == null) {
                    c0823b.m4041a(c0853v);
                } else {
                    c0823b.m4042a(c0853v, c0920a.f2375b, c0920a.f2376c);
                }
            } else if ((c0920a.f2374a & 14) == 14) {
                c0823b.m4043b(c0853v, c0920a.f2375b, c0920a.f2376c);
            } else if ((c0920a.f2374a & 12) == 12) {
                c0823b.m4044c(c0853v, c0920a.f2375b, c0920a.f2376c);
            } else if ((c0920a.f2374a & 4) != 0) {
                c0823b.m4042a(c0853v, c0920a.f2375b, null);
            } else if ((c0920a.f2374a & 8) != 0) {
                c0823b.m4043b(c0853v, c0920a.f2375b, c0920a.f2376c);
            } else if ((c0920a.f2374a & 2) != 0) {
            }
            C0920a.m4846a(c0920a);
        }
    }

    boolean m4854a(C0853v c0853v) {
        C0920a c0920a = (C0920a) this.f2377a.get(c0853v);
        return (c0920a == null || (c0920a.f2374a & 1) == 0) ? false : true;
    }

    C0835c m4855b(C0853v c0853v) {
        return m4848a(c0853v, 4);
    }

    void m4856b() {
        C0920a.m4847b();
    }

    void m4857b(C0853v c0853v, C0835c c0835c) {
        C0920a c0920a = (C0920a) this.f2377a.get(c0853v);
        if (c0920a == null) {
            c0920a = C0920a.m4845a();
            this.f2377a.put(c0853v, c0920a);
        }
        c0920a.f2374a |= 2;
        c0920a.f2375b = c0835c;
    }

    C0835c m4858c(C0853v c0853v) {
        return m4848a(c0853v, 8);
    }

    void m4859c(C0853v c0853v, C0835c c0835c) {
        C0920a c0920a = (C0920a) this.f2377a.get(c0853v);
        if (c0920a == null) {
            c0920a = C0920a.m4845a();
            this.f2377a.put(c0853v, c0920a);
        }
        c0920a.f2376c = c0835c;
        c0920a.f2374a |= 8;
    }

    boolean m4860d(C0853v c0853v) {
        C0920a c0920a = (C0920a) this.f2377a.get(c0853v);
        return (c0920a == null || (c0920a.f2374a & 4) == 0) ? false : true;
    }

    void m4861e(C0853v c0853v) {
        C0920a c0920a = (C0920a) this.f2377a.get(c0853v);
        if (c0920a == null) {
            c0920a = C0920a.m4845a();
            this.f2377a.put(c0853v, c0920a);
        }
        r0.f2374a |= 1;
    }

    void m4862f(C0853v c0853v) {
        C0920a c0920a = (C0920a) this.f2377a.get(c0853v);
        if (c0920a != null) {
            c0920a.f2374a &= -2;
        }
    }

    void m4863g(C0853v c0853v) {
        for (int b = this.f2378b.m1439b() - 1; b >= 0; b--) {
            if (c0853v == this.f2378b.m1443c(b)) {
                this.f2378b.m1438a(b);
                break;
            }
        }
        C0920a c0920a = (C0920a) this.f2377a.remove(c0853v);
        if (c0920a != null) {
            C0920a.m4846a(c0920a);
        }
    }

    public void m4864h(C0853v c0853v) {
        m4862f(c0853v);
    }
}
