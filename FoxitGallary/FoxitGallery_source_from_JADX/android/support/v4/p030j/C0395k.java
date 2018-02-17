package android.support.v4.p030j;

/* renamed from: android.support.v4.j.k */
public class C0395k<E> implements Cloneable {
    private static final Object f756a;
    private boolean f757b;
    private int[] f758c;
    private Object[] f759d;
    private int f760e;

    static {
        f756a = new Object();
    }

    public C0395k() {
        this(10);
    }

    public C0395k(int i) {
        this.f757b = false;
        if (i == 0) {
            this.f758c = C0381b.f722a;
            this.f759d = C0381b.f724c;
        } else {
            int a = C0381b.m1426a(i);
            this.f758c = new int[a];
            this.f759d = new Object[a];
        }
        this.f760e = 0;
    }

    private void m1460d() {
        int i = this.f760e;
        int[] iArr = this.f758c;
        Object[] objArr = this.f759d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f756a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f757b = false;
        this.f760e = i2;
    }

    public C0395k<E> m1461a() {
        try {
            C0395k<E> c0395k = (C0395k) super.clone();
            try {
                c0395k.f758c = (int[]) this.f758c.clone();
                c0395k.f759d = (Object[]) this.f759d.clone();
                return c0395k;
            } catch (CloneNotSupportedException e) {
                return c0395k;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1462a(int i) {
        return m1463a(i, null);
    }

    public E m1463a(int i, E e) {
        int a = C0381b.m1427a(this.f758c, this.f760e, i);
        return (a < 0 || this.f759d[a] == f756a) ? e : this.f759d[a];
    }

    public int m1464b() {
        if (this.f757b) {
            m1460d();
        }
        return this.f760e;
    }

    public void m1465b(int i) {
        int a = C0381b.m1427a(this.f758c, this.f760e, i);
        if (a >= 0 && this.f759d[a] != f756a) {
            this.f759d[a] = f756a;
            this.f757b = true;
        }
    }

    public void m1466b(int i, E e) {
        int a = C0381b.m1427a(this.f758c, this.f760e, i);
        if (a >= 0) {
            this.f759d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f760e || this.f759d[a] != f756a) {
            if (this.f757b && this.f760e >= this.f758c.length) {
                m1460d();
                a = C0381b.m1427a(this.f758c, this.f760e, i) ^ -1;
            }
            if (this.f760e >= this.f758c.length) {
                int a2 = C0381b.m1426a(this.f760e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f758c, 0, obj, 0, this.f758c.length);
                System.arraycopy(this.f759d, 0, obj2, 0, this.f759d.length);
                this.f758c = obj;
                this.f759d = obj2;
            }
            if (this.f760e - a != 0) {
                System.arraycopy(this.f758c, a, this.f758c, a + 1, this.f760e - a);
                System.arraycopy(this.f759d, a, this.f759d, a + 1, this.f760e - a);
            }
            this.f758c[a] = i;
            this.f759d[a] = e;
            this.f760e++;
            return;
        }
        this.f758c[a] = i;
        this.f759d[a] = e;
    }

    public void m1467c() {
        int i = this.f760e;
        Object[] objArr = this.f759d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f760e = 0;
        this.f757b = false;
    }

    public void m1468c(int i) {
        m1465b(i);
    }

    public /* synthetic */ Object clone() {
        return m1461a();
    }

    public int m1469d(int i) {
        if (this.f757b) {
            m1460d();
        }
        return this.f758c[i];
    }

    public E m1470e(int i) {
        if (this.f757b) {
            m1460d();
        }
        return this.f759d[i];
    }

    public int m1471f(int i) {
        if (this.f757b) {
            m1460d();
        }
        return C0381b.m1427a(this.f758c, this.f760e, i);
    }

    public String toString() {
        if (m1464b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f760e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f760e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1469d(i));
            stringBuilder.append('=');
            C0395k e = m1470e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
