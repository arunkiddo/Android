package android.support.v4.p016k.p031a;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.k.a.k */
public class C0440k {
    private static final C0435c f774a;
    private final Object f775b;

    /* renamed from: android.support.v4.k.a.k.c */
    interface C0435c {
        void m1645a(Object obj, int i);

        void m1646a(Object obj, boolean z);

        void m1647b(Object obj, int i);

        void m1648c(Object obj, int i);

        void m1649d(Object obj, int i);

        void m1650e(Object obj, int i);

        void m1651f(Object obj, int i);

        void m1652g(Object obj, int i);
    }

    /* renamed from: android.support.v4.k.a.k.e */
    static class C0436e implements C0435c {
        C0436e() {
        }

        public void m1653a(Object obj, int i) {
        }

        public void m1654a(Object obj, boolean z) {
        }

        public void m1655b(Object obj, int i) {
        }

        public void m1656c(Object obj, int i) {
        }

        public void m1657d(Object obj, int i) {
        }

        public void m1658e(Object obj, int i) {
        }

        public void m1659f(Object obj, int i) {
        }

        public void m1660g(Object obj, int i) {
        }
    }

    /* renamed from: android.support.v4.k.a.k.a */
    static class C0437a extends C0436e {
        C0437a() {
        }

        public void m1661a(Object obj, int i) {
            C0441l.m1677a(obj, i);
        }

        public void m1662a(Object obj, boolean z) {
            C0441l.m1678a(obj, z);
        }

        public void m1663b(Object obj, int i) {
            C0441l.m1679b(obj, i);
        }

        public void m1664c(Object obj, int i) {
            C0441l.m1680c(obj, i);
        }

        public void m1665d(Object obj, int i) {
            C0441l.m1681d(obj, i);
        }

        public void m1666e(Object obj, int i) {
            C0441l.m1682e(obj, i);
        }
    }

    /* renamed from: android.support.v4.k.a.k.b */
    static class C0438b extends C0437a {
        C0438b() {
        }

        public void m1667f(Object obj, int i) {
            C0442m.m1683a(obj, i);
        }

        public void m1668g(Object obj, int i) {
            C0442m.m1684b(obj, i);
        }
    }

    /* renamed from: android.support.v4.k.a.k.d */
    static class C0439d extends C0438b {
        C0439d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f774a = new C0439d();
        } else if (VERSION.SDK_INT >= 15) {
            f774a = new C0438b();
        } else if (VERSION.SDK_INT >= 14) {
            f774a = new C0437a();
        } else {
            f774a = new C0436e();
        }
    }

    @Deprecated
    public C0440k(Object obj) {
        this.f775b = obj;
    }

    public void m1669a(int i) {
        f774a.m1647b(this.f775b, i);
    }

    public void m1670a(boolean z) {
        f774a.m1646a(this.f775b, z);
    }

    public void m1671b(int i) {
        f774a.m1645a(this.f775b, i);
    }

    public void m1672c(int i) {
        f774a.m1650e(this.f775b, i);
    }

    public void m1673d(int i) {
        f774a.m1648c(this.f775b, i);
    }

    public void m1674e(int i) {
        f774a.m1649d(this.f775b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0440k c0440k = (C0440k) obj;
        return this.f775b == null ? c0440k.f775b == null : this.f775b.equals(c0440k.f775b);
    }

    public void m1675f(int i) {
        f774a.m1651f(this.f775b, i);
    }

    public void m1676g(int i) {
        f774a.m1652g(this.f775b, i);
    }

    public int hashCode() {
        return this.f775b == null ? 0 : this.f775b.hashCode();
    }
}
