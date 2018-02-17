package p000a.p008f;

/* renamed from: a.f.c */
public final class C0051c extends C0048a {
    public static final C0050a f25b;
    private static final C0051c f26c;

    /* renamed from: a.f.c.a */
    public static final class C0050a {
        private C0050a() {
        }
    }

    static {
        f25b = new C0050a();
        f26c = new C0051c(1, 0);
    }

    public C0051c(int i, int i2) {
        super(i, i2, 1);
    }

    public boolean m74e() {
        return m68a() > m69b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0051c) && ((m74e() && ((C0051c) obj).m74e()) || (m68a() == ((C0051c) obj).m68a() && m69b() == ((C0051c) obj).m69b()));
    }

    public Integer m75f() {
        return Integer.valueOf(m68a());
    }

    public Integer m76g() {
        return Integer.valueOf(m69b());
    }

    public int hashCode() {
        return m74e() ? -1 : (m68a() * 31) + m69b();
    }

    public String toString() {
        return m68a() + ".." + m69b();
    }
}
