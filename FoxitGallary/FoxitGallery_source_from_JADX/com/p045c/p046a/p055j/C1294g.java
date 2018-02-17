package com.p045c.p046a.p055j;

/* renamed from: com.c.a.j.g */
public class C1294g {
    private Class<?> f3247a;
    private Class<?> f3248b;

    public C1294g(Class<?> cls, Class<?> cls2) {
        m6105a(cls, cls2);
    }

    public void m6105a(Class<?> cls, Class<?> cls2) {
        this.f3247a = cls;
        this.f3248b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1294g c1294g = (C1294g) obj;
        return !this.f3247a.equals(c1294g.f3247a) ? false : this.f3248b.equals(c1294g.f3248b);
    }

    public int hashCode() {
        return (this.f3247a.hashCode() * 31) + this.f3248b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f3247a + ", second=" + this.f3248b + '}';
    }
}
