package android.support.v4.p030j;

import java.util.Map;

/* renamed from: android.support.v4.j.j */
public class C0379j<K, V> {
    static Object[] f714b;
    static int f715c;
    static Object[] f716d;
    static int f717e;
    int[] f718f;
    Object[] f719g;
    int f720h;

    public C0379j() {
        this.f718f = C0381b.f722a;
        this.f719g = C0381b.f724c;
        this.f720h = 0;
    }

    public C0379j(int i) {
        if (i == 0) {
            this.f718f = C0381b.f722a;
            this.f719g = C0381b.f724c;
        } else {
            m1414e(i);
        }
        this.f720h = 0;
    }

    private static void m1413a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0380a.class) {
                if (f717e < 10) {
                    objArr[0] = f716d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f716d = objArr;
                    f717e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0380a.class) {
                if (f715c < 10) {
                    objArr[0] = f714b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f714b = objArr;
                    f715c++;
                }
            }
        }
    }

    private void m1414e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0380a.class) {
                if (f716d != null) {
                    objArr = f716d;
                    this.f719g = objArr;
                    f716d = (Object[]) objArr[0];
                    this.f718f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f717e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0380a.class) {
                if (f714b != null) {
                    objArr = f714b;
                    this.f719g = objArr;
                    f714b = (Object[]) objArr[0];
                    this.f718f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f715c--;
                    return;
                }
            }
        }
        this.f718f = new int[i];
        this.f719g = new Object[(i << 1)];
    }

    int m1415a() {
        int i = this.f720h;
        if (i == 0) {
            return -1;
        }
        int a = C0381b.m1427a(this.f718f, i, 0);
        if (a < 0 || this.f719g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f718f[i2] == 0) {
            if (this.f719g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f718f[a] == 0) {
            if (this.f719g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    public int m1416a(Object obj) {
        return obj == null ? m1415a() : m1417a(obj, obj.hashCode());
    }

    int m1417a(Object obj, int i) {
        int i2 = this.f720h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0381b.m1427a(this.f718f, i2, i);
        if (a < 0 || obj.equals(this.f719g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f718f[i3] == i) {
            if (obj.equals(this.f719g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f718f[a] == i) {
            if (obj.equals(this.f719g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public V m1418a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f719g[i2];
        this.f719g[i2] = v;
        return v2;
    }

    public void m1419a(int i) {
        if (this.f718f.length < i) {
            Object obj = this.f718f;
            Object obj2 = this.f719g;
            m1414e(i);
            if (this.f720h > 0) {
                System.arraycopy(obj, 0, this.f718f, 0, this.f720h);
                System.arraycopy(obj2, 0, this.f719g, 0, this.f720h << 1);
            }
            C0379j.m1413a(obj, obj2, this.f720h);
        }
    }

    int m1420b(Object obj) {
        int i = 1;
        int i2 = this.f720h * 2;
        Object[] objArr = this.f719g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public K m1421b(int i) {
        return this.f719g[i << 1];
    }

    public V m1422c(int i) {
        return this.f719g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f720h != 0) {
            C0379j.m1413a(this.f718f, this.f719g, this.f720h);
            this.f718f = C0381b.f722a;
            this.f719g = C0381b.f724c;
            this.f720h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return m1416a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m1420b(obj) >= 0;
    }

    public V m1423d(int i) {
        int i2 = 8;
        V v = this.f719g[(i << 1) + 1];
        if (this.f720h <= 1) {
            C0379j.m1413a(this.f718f, this.f719g, this.f720h);
            this.f718f = C0381b.f722a;
            this.f719g = C0381b.f724c;
            this.f720h = 0;
        } else if (this.f718f.length <= 8 || this.f720h >= this.f718f.length / 3) {
            this.f720h--;
            if (i < this.f720h) {
                System.arraycopy(this.f718f, i + 1, this.f718f, i, this.f720h - i);
                System.arraycopy(this.f719g, (i + 1) << 1, this.f719g, i << 1, (this.f720h - i) << 1);
            }
            this.f719g[this.f720h << 1] = null;
            this.f719g[(this.f720h << 1) + 1] = null;
        } else {
            if (this.f720h > 8) {
                i2 = this.f720h + (this.f720h >> 1);
            }
            Object obj = this.f718f;
            Object obj2 = this.f719g;
            m1414e(i2);
            this.f720h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f718f, 0, i);
                System.arraycopy(obj2, 0, this.f719g, 0, i << 1);
            }
            if (i < this.f720h) {
                System.arraycopy(obj, i + 1, this.f718f, i, this.f720h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f719g, i << 1, (this.f720h - i) << 1);
            }
        }
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof C0379j) {
            C0379j c0379j = (C0379j) obj;
            if (size() != c0379j.size()) {
                return false;
            }
            i = 0;
            while (i < this.f720h) {
                try {
                    b = m1421b(i);
                    c = m1422c(i);
                    obj2 = c0379j.get(b);
                    if (c == null) {
                        if (obj2 != null || !c0379j.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.f720h) {
                try {
                    b = m1421b(i);
                    c = m1422c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public V get(Object obj) {
        int a = m1416a(obj);
        return a >= 0 ? this.f719g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f718f;
        Object[] objArr = this.f719g;
        int i = this.f720h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f720h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m1415a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m1417a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f719g[i3];
            this.f719g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f720h >= this.f718f.length) {
            if (this.f720h >= 8) {
                i2 = this.f720h + (this.f720h >> 1);
            } else if (this.f720h < 4) {
                i2 = 4;
            }
            Object obj = this.f718f;
            Object obj2 = this.f719g;
            m1414e(i2);
            if (this.f718f.length > 0) {
                System.arraycopy(obj, 0, this.f718f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f719g, 0, obj2.length);
            }
            C0379j.m1413a(obj, obj2, this.f720h);
        }
        if (a < this.f720h) {
            System.arraycopy(this.f718f, a, this.f718f, a + 1, this.f720h - a);
            System.arraycopy(this.f719g, a << 1, this.f719g, (a + 1) << 1, (this.f720h - a) << 1);
        }
        this.f718f[a] = i;
        this.f719g[a << 1] = k;
        this.f719g[(a << 1) + 1] = v;
        this.f720h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m1416a(obj);
        return a >= 0 ? m1423d(a) : null;
    }

    public int size() {
        return this.f720h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f720h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f720h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0379j b = m1421b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1422c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
