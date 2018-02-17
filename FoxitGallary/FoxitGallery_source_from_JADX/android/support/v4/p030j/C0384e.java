package android.support.v4.p030j;

/* renamed from: android.support.v4.j.e */
public class C0384e<E> implements Cloneable {
    private static final Object f727a;
    private boolean f728b;
    private long[] f729c;
    private Object[] f730d;
    private int f731e;

    static {
        f727a = new Object();
    }

    public C0384e() {
        this(10);
    }

    public C0384e(int i) {
        this.f728b = false;
        if (i == 0) {
            this.f729c = C0381b.f723b;
            this.f730d = C0381b.f724c;
        } else {
            int b = C0381b.m1430b(i);
            this.f729c = new long[b];
            this.f730d = new Object[b];
        }
        this.f731e = 0;
    }

    private void m1434d() {
        int i = this.f731e;
        long[] jArr = this.f729c;
        Object[] objArr = this.f730d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f727a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f728b = false;
        this.f731e = i2;
    }

    public C0384e<E> m1435a() {
        try {
            C0384e<E> c0384e = (C0384e) super.clone();
            try {
                c0384e.f729c = (long[]) this.f729c.clone();
                c0384e.f730d = (Object[]) this.f730d.clone();
                return c0384e;
            } catch (CloneNotSupportedException e) {
                return c0384e;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1436a(long j) {
        return m1437a(j, null);
    }

    public E m1437a(long j, E e) {
        int a = C0381b.m1428a(this.f729c, this.f731e, j);
        return (a < 0 || this.f730d[a] == f727a) ? e : this.f730d[a];
    }

    public void m1438a(int i) {
        if (this.f730d[i] != f727a) {
            this.f730d[i] = f727a;
            this.f728b = true;
        }
    }

    public int m1439b() {
        if (this.f728b) {
            m1434d();
        }
        return this.f731e;
    }

    public long m1440b(int i) {
        if (this.f728b) {
            m1434d();
        }
        return this.f729c[i];
    }

    public void m1441b(long j) {
        int a = C0381b.m1428a(this.f729c, this.f731e, j);
        if (a >= 0 && this.f730d[a] != f727a) {
            this.f730d[a] = f727a;
            this.f728b = true;
        }
    }

    public void m1442b(long j, E e) {
        int a = C0381b.m1428a(this.f729c, this.f731e, j);
        if (a >= 0) {
            this.f730d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f731e || this.f730d[a] != f727a) {
            if (this.f728b && this.f731e >= this.f729c.length) {
                m1434d();
                a = C0381b.m1428a(this.f729c, this.f731e, j) ^ -1;
            }
            if (this.f731e >= this.f729c.length) {
                int b = C0381b.m1430b(this.f731e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f729c, 0, obj, 0, this.f729c.length);
                System.arraycopy(this.f730d, 0, obj2, 0, this.f730d.length);
                this.f729c = obj;
                this.f730d = obj2;
            }
            if (this.f731e - a != 0) {
                System.arraycopy(this.f729c, a, this.f729c, a + 1, this.f731e - a);
                System.arraycopy(this.f730d, a, this.f730d, a + 1, this.f731e - a);
            }
            this.f729c[a] = j;
            this.f730d[a] = e;
            this.f731e++;
            return;
        }
        this.f729c[a] = j;
        this.f730d[a] = e;
    }

    public E m1443c(int i) {
        if (this.f728b) {
            m1434d();
        }
        return this.f730d[i];
    }

    public void m1444c() {
        int i = this.f731e;
        Object[] objArr = this.f730d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f731e = 0;
        this.f728b = false;
    }

    public /* synthetic */ Object clone() {
        return m1435a();
    }

    public String toString() {
        if (m1439b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f731e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f731e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1440b(i));
            stringBuilder.append('=');
            C0384e c = m1443c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
