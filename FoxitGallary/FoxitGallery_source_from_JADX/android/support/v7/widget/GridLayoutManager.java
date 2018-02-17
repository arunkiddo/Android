package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.p016k.p031a.C0416c;
import android.support.v4.p016k.p031a.C0416c.C0415l;
import android.support.v7.widget.LinearLayoutManager.C0815a;
import android.support.v7.widget.LinearLayoutManager.C0816b;
import android.support.v7.widget.LinearLayoutManager.C0817c;
import android.support.v7.widget.RecyclerView.C0810i;
import android.support.v7.widget.RecyclerView.C0812h;
import android.support.v7.widget.RecyclerView.C0844n;
import android.support.v7.widget.RecyclerView.C0850s;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f1849a;
    int f1850b;
    int[] f1851c;
    View[] f1852d;
    final SparseIntArray f1853e;
    final SparseIntArray f1854f;
    C0808c f1855g;
    final Rect f1856h;

    /* renamed from: android.support.v7.widget.GridLayoutManager.c */
    public static abstract class C0808c {
        final SparseIntArray f1817a;
        private boolean f1818b;

        public C0808c() {
            this.f1817a = new SparseIntArray();
            this.f1818b = false;
        }

        public abstract int m3727a(int i);

        public int m3728a(int i, int i2) {
            int a = m3727a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.f1818b && this.f1817a.size() > 0) {
                b = m3730b(i);
                if (b >= 0) {
                    a2 = this.f1817a.get(b) + m3727a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = m3727a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    return a2 + a > i2 ? a2 : 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = m3727a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
            }
        }

        public void m3729a() {
            this.f1817a.clear();
        }

        int m3730b(int i) {
            int i2 = 0;
            int size = this.f1817a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1817a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            return (size < 0 || size >= this.f1817a.size()) ? -1 : this.f1817a.keyAt(size);
        }

        int m3731b(int i, int i2) {
            if (!this.f1818b) {
                return m3728a(i, i2);
            }
            int i3 = this.f1817a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = m3728a(i, i2);
            this.f1817a.put(i, i3);
            return i3;
        }

        public int m3732c(int i, int i2) {
            int a = m3727a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = m3727a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            return i5 + a > i2 ? i4 + 1 : i4;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager.a */
    public static final class C0809a extends C0808c {
        public int m3733a(int i) {
            return 1;
        }

        public int m3734a(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager.b */
    public static class C0811b extends C0810i {
        private int f1823e;
        private int f1824f;

        public C0811b(int i, int i2) {
            super(i, i2);
            this.f1823e = -1;
            this.f1824f = 0;
        }

        public C0811b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1823e = -1;
            this.f1824f = 0;
        }

        public C0811b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1823e = -1;
            this.f1824f = 0;
        }

        public C0811b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1823e = -1;
            this.f1824f = 0;
        }

        public int m3742a() {
            return this.f1823e;
        }

        public int m3743b() {
            return this.f1824f;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f1849a = false;
        this.f1850b = -1;
        this.f1853e = new SparseIntArray();
        this.f1854f = new SparseIntArray();
        this.f1855g = new C0809a();
        this.f1856h = new Rect();
        m3972a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f1849a = false;
        this.f1850b = -1;
        this.f1853e = new SparseIntArray();
        this.f1854f = new SparseIntArray();
        this.f1855g = new C0809a();
        this.f1856h = new Rect();
        m3972a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1849a = false;
        this.f1850b = -1;
        this.f1853e = new SparseIntArray();
        this.f1854f = new SparseIntArray();
        this.f1855g = new C0809a();
        this.f1856h = new Rect();
        m3972a(C0812h.m3746a(context, attributeSet, i, i2).f1912b);
    }

    private void m3951J() {
        this.f1853e.clear();
        this.f1854f.clear();
    }

    private void m3952K() {
        int u = m3875u();
        for (int i = 0; i < u; i++) {
            C0811b c0811b = (C0811b) m3858i(i).getLayoutParams();
            int e = c0811b.m3737e();
            this.f1853e.put(e, c0811b.m3743b());
            this.f1854f.put(e, c0811b.m3742a());
        }
    }

    private void m3953L() {
        m3964m(m3941g() == 1 ? (m3878x() - m3757B()) - m3880z() : (m3879y() - m3758C()) - m3756A());
    }

    private void m3954M() {
        if (this.f1852d == null || this.f1852d.length != this.f1850b) {
            this.f1852d = new View[this.f1850b];
        }
    }

    private int m3955a(C0844n c0844n, C0850s c0850s, int i) {
        if (!c0850s.m4218a()) {
            return this.f1855g.m3732c(i, this.f1850b);
        }
        int b = c0844n.m4158b(i);
        if (b != -1) {
            return this.f1855g.m3732c(b, this.f1850b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void m3956a(float f, int i) {
        m3964m(Math.max(Math.round(((float) this.f1850b) * f), i));
    }

    private void m3957a(C0844n c0844n, C0850s c0850s, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && m3944h()) {
            i5 = this.f1850b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f1852d[i5];
            C0811b c0811b = (C0811b) view.getLayoutParams();
            c0811b.f1824f = m3963c(c0844n, c0850s, m3836d(view));
            if (i6 != -1 || c0811b.f1824f <= 1) {
                c0811b.f1823e = i7;
            } else {
                c0811b.f1823e = i7 - (c0811b.f1824f - 1);
            }
            i7 += c0811b.f1824f * i6;
        }
    }

    private void m3958a(View view, int i, int i2, boolean z, boolean z2) {
        m3821b(view, this.f1856h);
        C0810i c0810i = (C0810i) view.getLayoutParams();
        if (z || this.i == 1) {
            i = m3960b(i, c0810i.leftMargin + this.f1856h.left, c0810i.rightMargin + this.f1856h.right);
        }
        if (z || this.i == 0) {
            i2 = m3960b(i2, c0810i.topMargin + this.f1856h.top, c0810i.bottomMargin + this.f1856h.bottom);
        }
        if (z2 ? m3809a(view, i, i2, c0810i) : m3822b(view, i, i2, c0810i)) {
            view.measure(i, i2);
        }
    }

    static int[] m3959a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    private int m3960b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int m3961b(C0844n c0844n, C0850s c0850s, int i) {
        if (!c0850s.m4218a()) {
            return this.f1855g.m3731b(i, this.f1850b);
        }
        int i2 = this.f1854f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0844n.m4158b(i);
        if (i2 != -1) {
            return this.f1855g.m3731b(i2, this.f1850b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void m3962b(C0844n c0844n, C0850s c0850s, C0815a c0815a, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m3961b(c0844n, c0850s, c0815a.f1871a);
        if (obj != null) {
            while (b > 0 && c0815a.f1871a > 0) {
                c0815a.f1871a--;
                b = m3961b(c0844n, c0850s, c0815a.f1871a);
            }
            return;
        }
        int e = c0850s.m4222e() - 1;
        int i2 = c0815a.f1871a;
        int i3 = b;
        while (i2 < e) {
            b = m3961b(c0844n, c0850s, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        c0815a.f1871a = i2;
    }

    private int m3963c(C0844n c0844n, C0850s c0850s, int i) {
        if (!c0850s.m4218a()) {
            return this.f1855g.m3727a(i);
        }
        int i2 = this.f1853e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0844n.m4158b(i);
        if (i2 != -1) {
            return this.f1855g.m3727a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void m3964m(int i) {
        this.f1851c = m3959a(this.f1851c, this.f1850b, i);
    }

    public int m3965a(int i, C0844n c0844n, C0850s c0850s) {
        m3953L();
        m3954M();
        return super.m3908a(i, c0844n, c0850s);
    }

    public int m3966a(C0844n c0844n, C0850s c0850s) {
        return this.i == 0 ? this.f1850b : c0850s.m4222e() < 1 ? 0 : m3955a(c0844n, c0850s, c0850s.m4222e() - 1) + 1;
    }

    public C0810i m3967a() {
        return this.i == 0 ? new C0811b(-2, -1) : new C0811b(-1, -2);
    }

    public C0810i m3968a(Context context, AttributeSet attributeSet) {
        return new C0811b(context, attributeSet);
    }

    public C0810i m3969a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0811b((MarginLayoutParams) layoutParams) : new C0811b(layoutParams);
    }

    View m3970a(C0844n c0844n, C0850s c0850s, int i, int i2, int i3) {
        View view = null;
        m3945i();
        int c = this.j.m4671c();
        int d = this.j.m4673d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View i5 = m3858i(i);
            int d2 = m3836d(i5);
            if (d2 >= 0 && d2 < i3) {
                if (m3961b(c0844n, c0850s, d2) != 0) {
                    view3 = view;
                    i5 = view2;
                } else if (((C0810i) i5.getLayoutParams()).m3735c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.m4666a(i5) < d && this.j.m4670b(i5) >= c) {
                    return i5;
                } else {
                    if (view == null) {
                        view3 = i5;
                        i5 = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = i5;
            }
            view3 = view;
            i5 = view2;
            i += i4;
            view = view3;
            view2 = i5;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public View m3971a(View view, int i, C0844n c0844n, C0850s c0850s) {
        View e = m3842e(view);
        if (e == null) {
            return null;
        }
        C0811b c0811b = (C0811b) e.getLayoutParams();
        int a = c0811b.f1823e;
        int a2 = c0811b.f1823e + c0811b.f1824f;
        if (super.m3913a(view, i, c0844n, c0850s) == null) {
            return null;
        }
        int u;
        int i2;
        int i3;
        if (((m3938f(i) == 1) != this.k ? 1 : null) != null) {
            u = m3875u() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            u = 0;
            i2 = 1;
            i3 = m3875u();
        }
        Object obj = (this.i == 1 && m3944h()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = u;
        while (i6 != i3) {
            View i7 = m3858i(i6);
            if (i7 == e) {
                break;
            }
            View view3;
            if (i7.isFocusable()) {
                c0811b = (C0811b) i7.getLayoutParams();
                int a3 = c0811b.f1823e;
                int a4 = c0811b.f1823e + c0811b.f1824f;
                if (a3 == a && a4 == a2) {
                    return i7;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = c0811b.f1823e;
                    u = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = i7;
                } else {
                    u = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                u = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = u;
        }
        return view2;
    }

    public void m3972a(int i) {
        if (i != this.f1850b) {
            this.f1849a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f1850b = i;
            this.f1855g.m3729a();
            m3869o();
        }
    }

    public void m3973a(Rect rect, int i, int i2) {
        if (this.f1851c == null) {
            super.m3773a(rect, i, i2);
        }
        int B = m3757B() + m3880z();
        int A = m3756A() + m3758C();
        if (this.i == 1) {
            A = C0812h.m3744a(i2, A + rect.height(), m3761F());
            B = C0812h.m3744a(i, B + this.f1851c[this.f1851c.length - 1], m3760E());
        } else {
            B = C0812h.m3744a(i, B + rect.width(), m3760E());
            A = C0812h.m3744a(i2, A + this.f1851c[this.f1851c.length - 1], m3761F());
        }
        m3839d(B, A);
    }

    void m3974a(C0844n c0844n, C0850s c0850s, C0815a c0815a, int i) {
        super.m3915a(c0844n, c0850s, c0815a, i);
        m3953L();
        if (c0850s.m4222e() > 0 && !c0850s.m4218a()) {
            m3962b(c0844n, c0850s, c0815a, i);
        }
        m3954M();
    }

    void m3975a(C0844n c0844n, C0850s c0850s, C0817c c0817c, C0816b c0816b) {
        int i = this.j.m4681i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = m3875u() > 0 ? this.f1851c[this.f1850b] : 0;
        if (obj != null) {
            m3953L();
        }
        boolean z = c0817c.f1884e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1850b;
        if (!z) {
            i5 = m3961b(c0844n, c0850s, c0817c.f1883d) + m3963c(c0844n, c0850s, c0817c.f1883d);
        }
        while (i3 < this.f1850b && c0817c.m4035a(c0850s) && i5 > 0) {
            int i6 = c0817c.f1883d;
            int c = m3963c(c0844n, c0850s, i6);
            if (c <= this.f1850b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = c0817c.m4032a(c0844n);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f1852d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f1850b + " spans.");
        }
        if (i3 == 0) {
            c0816b.f1877b = true;
            return;
        }
        int a2;
        int a3;
        View view;
        int a4;
        int a5;
        m3957a(c0844n, c0850s, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.f1852d[i7];
            if (c0817c.f1890k == null) {
                if (z) {
                    m3819b(view2);
                } else {
                    m3820b(view2, 0);
                }
            } else if (z) {
                m3790a(view2);
            } else {
                m3791a(view2, 0);
            }
            C0811b c0811b = (C0811b) view2.getLayoutParams();
            a2 = C0812h.m3745a(this.f1851c[c0811b.f1823e + c0811b.f1824f] - this.f1851c[c0811b.f1823e], i, 0, this.i == 0 ? c0811b.height : c0811b.width, false);
            a3 = C0812h.m3745a(this.j.m4677f(), this.j.m4680h(), 0, this.i == 1 ? c0811b.height : c0811b.width, true);
            if (this.i == 1) {
                m3958a(view2, a2, a3, c0811b.height == -1, false);
            } else {
                m3958a(view2, a3, a2, c0811b.width == -1, false);
            }
            i6 = this.j.m4676e(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float f2 = (1.0f * ((float) this.j.m4678f(view2))) / ((float) c0811b.f1824f);
            if (f2 <= f) {
                f2 = f;
            }
            i7++;
            f = f2;
            c = i6;
        }
        if (obj != null) {
            m3956a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.f1852d[i8];
                c0811b = (C0811b) view.getLayoutParams();
                a4 = C0812h.m3745a(this.f1851c[c0811b.f1823e + c0811b.f1824f] - this.f1851c[c0811b.f1823e], 1073741824, 0, this.i == 0 ? c0811b.height : c0811b.width, false);
                a5 = C0812h.m3745a(this.j.m4677f(), this.j.m4680h(), 0, this.i == 1 ? c0811b.height : c0811b.width, true);
                if (this.i == 1) {
                    m3958a(view, a4, a5, false, true);
                } else {
                    m3958a(view, a5, a4, false, true);
                }
                i5 = this.j.m4676e(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        a5 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f1852d[i6];
            if (this.j.m4676e(view) != c) {
                c0811b = (C0811b) view.getLayoutParams();
                a4 = C0812h.m3745a(this.f1851c[c0811b.f1823e + c0811b.f1824f] - this.f1851c[c0811b.f1823e], 1073741824, 0, this.i == 0 ? c0811b.height : c0811b.width, false);
                if (this.i == 1) {
                    m3958a(view, a4, a5, true, true);
                } else {
                    m3958a(view, a5, a4, true, true);
                }
            }
        }
        c0816b.f1876a = c;
        i6 = 0;
        i5 = 0;
        if (this.i == 1) {
            if (c0817c.f1885f == -1) {
                i5 = c0817c.f1881b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = c0817c.f1881b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (c0817c.f1885f == -1) {
            i4 = c0817c.f1881b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = c0817c.f1881b;
            c += i4;
        }
        a3 = i5;
        a5 = i6;
        a2 = c;
        a4 = i4;
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f1852d[i6];
            c0811b = (C0811b) view.getLayoutParams();
            if (this.i != 1) {
                a5 = m3756A() + this.f1851c[c0811b.f1823e];
                a3 = a5 + this.j.m4678f(view);
            } else if (m3944h()) {
                a2 = m3880z() + this.f1851c[c0811b.f1823e + c0811b.f1824f];
                a4 = a2 - this.j.m4678f(view);
            } else {
                a4 = m3880z() + this.f1851c[c0811b.f1823e];
                a2 = a4 + this.j.m4678f(view);
            }
            m3793a(view, a4, a5, a2, a3);
            if (c0811b.m3735c() || c0811b.m3736d()) {
                c0816b.f1878c = true;
            }
            c0816b.f1879d |= view.isFocusable();
        }
        Arrays.fill(this.f1852d, null);
    }

    public void m3976a(C0844n c0844n, C0850s c0850s, View view, C0416c c0416c) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0811b) {
            C0811b c0811b = (C0811b) layoutParams;
            int a = m3955a(c0844n, c0850s, c0811b.m3737e());
            if (this.i == 0) {
                int a2 = c0811b.m3742a();
                int b = c0811b.m3743b();
                boolean z = this.f1850b > 1 && c0811b.m3743b() == this.f1850b;
                c0416c.m1577b(C0415l.m1565a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = c0811b.m3742a();
            int b2 = c0811b.m3743b();
            boolean z2 = this.f1850b > 1 && c0811b.m3743b() == this.f1850b;
            c0416c.m1577b(C0415l.m1565a(a, 1, a3, b2, z2, false));
            return;
        }
        super.m3796a(view, c0416c);
    }

    public void m3977a(C0850s c0850s) {
        super.m3917a(c0850s);
        this.f1849a = false;
    }

    public void m3978a(RecyclerView recyclerView) {
        this.f1855g.m3729a();
    }

    public void m3979a(RecyclerView recyclerView, int i, int i2) {
        this.f1855g.m3729a();
    }

    public void m3980a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f1855g.m3729a();
    }

    public void m3981a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f1855g.m3729a();
    }

    public void m3982a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.m3922a(false);
    }

    public boolean m3983a(C0810i c0810i) {
        return c0810i instanceof C0811b;
    }

    public int m3984b() {
        return this.f1850b;
    }

    public int m3985b(int i, C0844n c0844n, C0850s c0850s) {
        m3953L();
        m3954M();
        return super.m3923b(i, c0844n, c0850s);
    }

    public int m3986b(C0844n c0844n, C0850s c0850s) {
        return this.i == 1 ? this.f1850b : c0850s.m4222e() < 1 ? 0 : m3955a(c0844n, c0850s, c0850s.m4222e() - 1) + 1;
    }

    public void m3987b(RecyclerView recyclerView, int i, int i2) {
        this.f1855g.m3729a();
    }

    public void m3988c(C0844n c0844n, C0850s c0850s) {
        if (c0850s.m4218a()) {
            m3952K();
        }
        super.m3930c(c0844n, c0850s);
        m3951J();
    }

    public boolean m3989c() {
        return this.n == null && !this.f1849a;
    }
}
