package android.support.v7.widget;

import android.support.v4.p030j.C0394i.C0392a;
import android.support.v4.p030j.C0394i.C0393b;
import android.support.v7.widget.RecyclerView.C0853v;
import android.support.v7.widget.aq.C0908a;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.f */
class C0940f implements C0908a {
    final ArrayList<C0939b> f2440a;
    final ArrayList<C0939b> f2441b;
    final C0827a f2442c;
    Runnable f2443d;
    final boolean f2444e;
    final aq f2445f;
    private C0392a<C0939b> f2446g;
    private int f2447h;

    /* renamed from: android.support.v7.widget.f.a */
    interface C0827a {
        C0853v m4071a(int i);

        void m4072a(int i, int i2);

        void m4073a(int i, int i2, Object obj);

        void m4074a(C0939b c0939b);

        void m4075b(int i, int i2);

        void m4076b(C0939b c0939b);

        void m4077c(int i, int i2);

        void m4078d(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.f.b */
    static class C0939b {
        int f2436a;
        int f2437b;
        Object f2438c;
        int f2439d;

        C0939b(int i, int i2, int i3, Object obj) {
            this.f2436a = i;
            this.f2437b = i2;
            this.f2439d = i3;
            this.f2438c = obj;
        }

        String m4938a() {
            switch (this.f2436a) {
                case C1373c.View_android_focusable /*1*/:
                    return "add";
                case C1373c.View_paddingStart /*2*/:
                    return "rm";
                case C1373c.View_theme /*4*/:
                    return "up";
                case C1373c.Toolbar_contentInsetRight /*8*/:
                    return "mv";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0939b c0939b = (C0939b) obj;
            return this.f2436a != c0939b.f2436a ? false : (this.f2436a == 8 && Math.abs(this.f2439d - this.f2437b) == 1 && this.f2439d == c0939b.f2437b && this.f2437b == c0939b.f2439d) ? true : this.f2439d != c0939b.f2439d ? false : this.f2437b != c0939b.f2437b ? false : this.f2438c != null ? this.f2438c.equals(c0939b.f2438c) : c0939b.f2438c == null;
        }

        public int hashCode() {
            return (((this.f2436a * 31) + this.f2437b) * 31) + this.f2439d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m4938a() + ",s:" + this.f2437b + "c:" + this.f2439d + ",p:" + this.f2438c + "]";
        }
    }

    C0940f(C0827a c0827a) {
        this(c0827a, false);
    }

    C0940f(C0827a c0827a, boolean z) {
        this.f2446g = new C0393b(30);
        this.f2440a = new ArrayList();
        this.f2441b = new ArrayList();
        this.f2447h = 0;
        this.f2442c = c0827a;
        this.f2444e = z;
        this.f2445f = new aq(this);
    }

    private void m4939b(C0939b c0939b) {
        m4946g(c0939b);
    }

    private void m4940c(C0939b c0939b) {
        int i = c0939b.f2437b;
        int i2 = c0939b.f2437b + c0939b.f2439d;
        Object obj = -1;
        int i3 = c0939b.f2437b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f2442c.m4071a(i3) != null || m4943d(i3)) {
                if (obj == null) {
                    m4944e(m4948a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m4946g(m4948a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != c0939b.f2439d) {
            m4950a(c0939b);
            c0939b = m4948a(2, i, i4, null);
        }
        if (obj == null) {
            m4944e(c0939b);
        } else {
            m4946g(c0939b);
        }
    }

    private int m4941d(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f2441b.size() - 1; size >= 0; size--) {
            C0939b c0939b = (C0939b) this.f2441b.get(size);
            if (c0939b.f2436a == 8) {
                int i5;
                int i6;
                if (c0939b.f2437b < c0939b.f2439d) {
                    i5 = c0939b.f2437b;
                    i3 = c0939b.f2439d;
                } else {
                    i5 = c0939b.f2439d;
                    i3 = c0939b.f2437b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c0939b.f2437b) {
                        if (i2 == 1) {
                            c0939b.f2437b++;
                            c0939b.f2439d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            c0939b.f2437b--;
                            c0939b.f2439d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c0939b.f2437b) {
                    if (i2 == 1) {
                        c0939b.f2439d++;
                    } else if (i2 == 2) {
                        c0939b.f2439d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c0939b.f2437b++;
                    } else if (i2 == 2) {
                        c0939b.f2437b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c0939b.f2437b <= i4) {
                if (c0939b.f2436a == 1) {
                    i4 -= c0939b.f2439d;
                } else if (c0939b.f2436a == 2) {
                    i4 += c0939b.f2439d;
                }
            } else if (i2 == 1) {
                c0939b.f2437b++;
            } else if (i2 == 2) {
                c0939b.f2437b--;
            }
        }
        for (i3 = this.f2441b.size() - 1; i3 >= 0; i3--) {
            c0939b = (C0939b) this.f2441b.get(i3);
            if (c0939b.f2436a == 8) {
                if (c0939b.f2439d == c0939b.f2437b || c0939b.f2439d < 0) {
                    this.f2441b.remove(i3);
                    m4950a(c0939b);
                }
            } else if (c0939b.f2439d <= 0) {
                this.f2441b.remove(i3);
                m4950a(c0939b);
            }
        }
        return i4;
    }

    private void m4942d(C0939b c0939b) {
        int i = c0939b.f2437b;
        int i2 = c0939b.f2437b + c0939b.f2439d;
        int i3 = c0939b.f2437b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f2442c.m4071a(i3) != null || m4943d(i3)) {
                if (obj == null) {
                    m4944e(m4948a(4, i, i4, c0939b.f2438c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m4946g(m4948a(4, i, i4, c0939b.f2438c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c0939b.f2439d) {
            Object obj4 = c0939b.f2438c;
            m4950a(c0939b);
            c0939b = m4948a(4, i, i4, obj4);
        }
        if (obj == null) {
            m4944e(c0939b);
        } else {
            m4946g(c0939b);
        }
    }

    private boolean m4943d(int i) {
        int size = this.f2441b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0939b c0939b = (C0939b) this.f2441b.get(i2);
            if (c0939b.f2436a == 8) {
                if (m4947a(c0939b.f2439d, i2 + 1) == i) {
                    return true;
                }
            } else if (c0939b.f2436a == 1) {
                int i3 = c0939b.f2437b + c0939b.f2439d;
                for (int i4 = c0939b.f2437b; i4 < i3; i4++) {
                    if (m4947a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m4944e(C0939b c0939b) {
        if (c0939b.f2436a == 1 || c0939b.f2436a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int d = m4941d(c0939b.f2437b, c0939b.f2436a);
        int i2 = c0939b.f2437b;
        switch (c0939b.f2436a) {
            case C1373c.View_paddingStart /*2*/:
                i = 0;
                break;
            case C1373c.View_theme /*4*/:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c0939b);
        }
        int i3 = 1;
        int i4 = d;
        d = i2;
        for (i2 = 1; i2 < c0939b.f2439d; i2++) {
            Object obj;
            int d2 = m4941d(c0939b.f2437b + (i * i2), c0939b.f2436a);
            int i5;
            switch (c0939b.f2436a) {
                case C1373c.View_paddingStart /*2*/:
                    if (d2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case C1373c.View_theme /*4*/:
                    if (d2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C0939b a = m4948a(c0939b.f2436a, i4, i3, c0939b.f2438c);
                m4951a(a, d);
                m4950a(a);
                if (c0939b.f2436a == 4) {
                    d += i3;
                }
                i3 = 1;
                i4 = d2;
            }
        }
        Object obj2 = c0939b.f2438c;
        m4950a(c0939b);
        if (i3 > 0) {
            C0939b a2 = m4948a(c0939b.f2436a, i4, i3, obj2);
            m4951a(a2, d);
            m4950a(a2);
        }
    }

    private void m4945f(C0939b c0939b) {
        m4946g(c0939b);
    }

    private void m4946g(C0939b c0939b) {
        this.f2441b.add(c0939b);
        switch (c0939b.f2436a) {
            case C1373c.View_android_focusable /*1*/:
                this.f2442c.m4077c(c0939b.f2437b, c0939b.f2439d);
            case C1373c.View_paddingStart /*2*/:
                this.f2442c.m4075b(c0939b.f2437b, c0939b.f2439d);
            case C1373c.View_theme /*4*/:
                this.f2442c.m4073a(c0939b.f2437b, c0939b.f2439d, c0939b.f2438c);
            case C1373c.Toolbar_contentInsetRight /*8*/:
                this.f2442c.m4078d(c0939b.f2437b, c0939b.f2439d);
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c0939b);
        }
    }

    int m4947a(int i, int i2) {
        int size = this.f2441b.size();
        int i3 = i;
        while (i2 < size) {
            C0939b c0939b = (C0939b) this.f2441b.get(i2);
            if (c0939b.f2436a == 8) {
                if (c0939b.f2437b == i3) {
                    i3 = c0939b.f2439d;
                } else {
                    if (c0939b.f2437b < i3) {
                        i3--;
                    }
                    if (c0939b.f2439d <= i3) {
                        i3++;
                    }
                }
            } else if (c0939b.f2437b > i3) {
                continue;
            } else if (c0939b.f2436a == 2) {
                if (i3 < c0939b.f2437b + c0939b.f2439d) {
                    return -1;
                }
                i3 -= c0939b.f2439d;
            } else if (c0939b.f2436a == 1) {
                i3 += c0939b.f2439d;
            }
            i2++;
        }
        return i3;
    }

    public C0939b m4948a(int i, int i2, int i3, Object obj) {
        C0939b c0939b = (C0939b) this.f2446g.m1455a();
        if (c0939b == null) {
            return new C0939b(i, i2, i3, obj);
        }
        c0939b.f2436a = i;
        c0939b.f2437b = i2;
        c0939b.f2439d = i3;
        c0939b.f2438c = obj;
        return c0939b;
    }

    void m4949a() {
        m4952a(this.f2440a);
        m4952a(this.f2441b);
        this.f2447h = 0;
    }

    public void m4950a(C0939b c0939b) {
        if (!this.f2444e) {
            c0939b.f2438c = null;
            this.f2446g.m1456a(c0939b);
        }
    }

    void m4951a(C0939b c0939b, int i) {
        this.f2442c.m4074a(c0939b);
        switch (c0939b.f2436a) {
            case C1373c.View_paddingStart /*2*/:
                this.f2442c.m4072a(i, c0939b.f2439d);
            case C1373c.View_theme /*4*/:
                this.f2442c.m4073a(i, c0939b.f2439d, c0939b.f2438c);
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void m4952a(List<C0939b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m4950a((C0939b) list.get(i));
        }
        list.clear();
    }

    boolean m4953a(int i) {
        return (this.f2447h & i) != 0;
    }

    boolean m4954a(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f2440a.add(m4948a(8, i, i2, null));
        this.f2447h |= 8;
        if (this.f2440a.size() != 1) {
            z = false;
        }
        return z;
    }

    boolean m4955a(int i, int i2, Object obj) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.f2440a.add(m4948a(4, i, i2, obj));
        this.f2447h |= 4;
        if (this.f2440a.size() != 1) {
            z = false;
        }
        return z;
    }

    int m4956b(int i) {
        return m4947a(i, 0);
    }

    void m4957b() {
        this.f2445f.m4660a(this.f2440a);
        int size = this.f2440a.size();
        for (int i = 0; i < size; i++) {
            C0939b c0939b = (C0939b) this.f2440a.get(i);
            switch (c0939b.f2436a) {
                case C1373c.View_android_focusable /*1*/:
                    m4945f(c0939b);
                    break;
                case C1373c.View_paddingStart /*2*/:
                    m4940c(c0939b);
                    break;
                case C1373c.View_theme /*4*/:
                    m4942d(c0939b);
                    break;
                case C1373c.Toolbar_contentInsetRight /*8*/:
                    m4939b(c0939b);
                    break;
            }
            if (this.f2443d != null) {
                this.f2443d.run();
            }
        }
        this.f2440a.clear();
    }

    boolean m4958b(int i, int i2) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.f2440a.add(m4948a(1, i, i2, null));
        this.f2447h |= 1;
        if (this.f2440a.size() != 1) {
            z = false;
        }
        return z;
    }

    public int m4959c(int i) {
        int size = this.f2440a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C0939b c0939b = (C0939b) this.f2440a.get(i3);
            switch (c0939b.f2436a) {
                case C1373c.View_android_focusable /*1*/:
                    if (c0939b.f2437b > i2) {
                        break;
                    }
                    i2 += c0939b.f2439d;
                    break;
                case C1373c.View_paddingStart /*2*/:
                    if (c0939b.f2437b <= i2) {
                        if (c0939b.f2437b + c0939b.f2439d <= i2) {
                            i2 -= c0939b.f2439d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case C1373c.Toolbar_contentInsetRight /*8*/:
                    if (c0939b.f2437b != i2) {
                        if (c0939b.f2437b < i2) {
                            i2--;
                        }
                        if (c0939b.f2439d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c0939b.f2439d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    void m4960c() {
        int size = this.f2441b.size();
        for (int i = 0; i < size; i++) {
            this.f2442c.m4076b((C0939b) this.f2441b.get(i));
        }
        m4952a(this.f2441b);
        this.f2447h = 0;
    }

    boolean m4961c(int i, int i2) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.f2440a.add(m4948a(2, i, i2, null));
        this.f2447h |= 2;
        if (this.f2440a.size() != 1) {
            z = false;
        }
        return z;
    }

    boolean m4962d() {
        return this.f2440a.size() > 0;
    }

    void m4963e() {
        m4960c();
        int size = this.f2440a.size();
        for (int i = 0; i < size; i++) {
            C0939b c0939b = (C0939b) this.f2440a.get(i);
            switch (c0939b.f2436a) {
                case C1373c.View_android_focusable /*1*/:
                    this.f2442c.m4076b(c0939b);
                    this.f2442c.m4077c(c0939b.f2437b, c0939b.f2439d);
                    break;
                case C1373c.View_paddingStart /*2*/:
                    this.f2442c.m4076b(c0939b);
                    this.f2442c.m4072a(c0939b.f2437b, c0939b.f2439d);
                    break;
                case C1373c.View_theme /*4*/:
                    this.f2442c.m4076b(c0939b);
                    this.f2442c.m4073a(c0939b.f2437b, c0939b.f2439d, c0939b.f2438c);
                    break;
                case C1373c.Toolbar_contentInsetRight /*8*/:
                    this.f2442c.m4076b(c0939b);
                    this.f2442c.m4078d(c0939b.f2437b, c0939b.f2439d);
                    break;
            }
            if (this.f2443d != null) {
                this.f2443d.run();
            }
        }
        m4952a(this.f2440a);
        this.f2447h = 0;
    }

    boolean m4964f() {
        return (this.f2441b.isEmpty() || this.f2440a.isEmpty()) ? false : true;
    }
}
