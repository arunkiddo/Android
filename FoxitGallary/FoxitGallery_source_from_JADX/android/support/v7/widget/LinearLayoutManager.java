package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016k.p031a.C0402a;
import android.support.v4.p016k.p031a.C0440k;
import android.support.v7.widget.RecyclerView.C0810i;
import android.support.v7.widget.RecyclerView.C0812h;
import android.support.v7.widget.RecyclerView.C0812h.C0839a;
import android.support.v7.widget.RecyclerView.C0813r;
import android.support.v7.widget.RecyclerView.C0844n;
import android.support.v7.widget.RecyclerView.C0850s;
import android.support.v7.widget.RecyclerView.C0853v;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.List;

public class LinearLayoutManager extends C0812h {
    private C0817c f1836a;
    private boolean f1837b;
    private boolean f1838c;
    private boolean f1839d;
    private boolean f1840e;
    private boolean f1841f;
    int f1842i;
    ar f1843j;
    boolean f1844k;
    int f1845l;
    int f1846m;
    C0819d f1847n;
    final C0815a f1848o;

    /* renamed from: android.support.v7.widget.LinearLayoutManager.1 */
    class C08141 extends al {
        final /* synthetic */ LinearLayoutManager f1870a;

        C08141(LinearLayoutManager linearLayoutManager, Context context) {
            this.f1870a = linearLayoutManager;
            super(context);
        }

        public PointF m4023a(int i) {
            return this.f1870a.m3933d(i);
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager.a */
    class C0815a {
        int f1871a;
        int f1872b;
        boolean f1873c;
        boolean f1874d;
        final /* synthetic */ LinearLayoutManager f1875e;

        C0815a(LinearLayoutManager linearLayoutManager) {
            this.f1875e = linearLayoutManager;
            m4026a();
        }

        private boolean m4025a(View view, C0850s c0850s) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            return !c0810i.m3735c() && c0810i.m3737e() >= 0 && c0810i.m3737e() < c0850s.m4222e();
        }

        void m4026a() {
            this.f1871a = -1;
            this.f1872b = Integer.MIN_VALUE;
            this.f1873c = false;
            this.f1874d = false;
        }

        public void m4027a(View view) {
            int b = this.f1875e.f1843j.m4669b();
            if (b >= 0) {
                m4029b(view);
                return;
            }
            this.f1871a = this.f1875e.m3836d(view);
            int e;
            if (this.f1873c) {
                b = (this.f1875e.f1843j.m4673d() - b) - this.f1875e.f1843j.m4670b(view);
                this.f1872b = this.f1875e.f1843j.m4673d() - b;
                if (b > 0) {
                    e = this.f1872b - this.f1875e.f1843j.m4676e(view);
                    int c = this.f1875e.f1843j.m4671c();
                    e -= c + Math.min(this.f1875e.f1843j.m4666a(view) - c, 0);
                    if (e < 0) {
                        this.f1872b = Math.min(b, -e) + this.f1872b;
                        return;
                    }
                    return;
                }
                return;
            }
            e = this.f1875e.f1843j.m4666a(view);
            c = e - this.f1875e.f1843j.m4671c();
            this.f1872b = e;
            if (c > 0) {
                b = (this.f1875e.f1843j.m4673d() - Math.min(0, (this.f1875e.f1843j.m4673d() - b) - this.f1875e.f1843j.m4670b(view))) - (e + this.f1875e.f1843j.m4676e(view));
                if (b < 0) {
                    this.f1872b -= Math.min(c, -b);
                }
            }
        }

        void m4028b() {
            this.f1872b = this.f1873c ? this.f1875e.f1843j.m4673d() : this.f1875e.f1843j.m4671c();
        }

        public void m4029b(View view) {
            if (this.f1873c) {
                this.f1872b = this.f1875e.f1843j.m4670b(view) + this.f1875e.f1843j.m4669b();
            } else {
                this.f1872b = this.f1875e.f1843j.m4666a(view);
            }
            this.f1871a = this.f1875e.m3836d(view);
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1871a + ", mCoordinate=" + this.f1872b + ", mLayoutFromEnd=" + this.f1873c + ", mValid=" + this.f1874d + '}';
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager.b */
    protected static class C0816b {
        public int f1876a;
        public boolean f1877b;
        public boolean f1878c;
        public boolean f1879d;

        protected C0816b() {
        }

        void m4030a() {
            this.f1876a = 0;
            this.f1877b = false;
            this.f1878c = false;
            this.f1879d = false;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager.c */
    static class C0817c {
        boolean f1880a;
        int f1881b;
        int f1882c;
        int f1883d;
        int f1884e;
        int f1885f;
        int f1886g;
        int f1887h;
        boolean f1888i;
        int f1889j;
        List<C0853v> f1890k;
        boolean f1891l;

        C0817c() {
            this.f1880a = true;
            this.f1887h = 0;
            this.f1888i = false;
            this.f1890k = null;
        }

        private View m4031b() {
            int size = this.f1890k.size();
            for (int i = 0; i < size; i++) {
                View view = ((C0853v) this.f1890k.get(i)).itemView;
                C0810i c0810i = (C0810i) view.getLayoutParams();
                if (!c0810i.m3735c() && this.f1883d == c0810i.m3737e()) {
                    m4034a(view);
                    return view;
                }
            }
            return null;
        }

        View m4032a(C0844n c0844n) {
            if (this.f1890k != null) {
                return m4031b();
            }
            View c = c0844n.m4164c(this.f1883d);
            this.f1883d += this.f1884e;
            return c;
        }

        public void m4033a() {
            m4034a(null);
        }

        public void m4034a(View view) {
            View b = m4036b(view);
            if (b == null) {
                this.f1883d = -1;
            } else {
                this.f1883d = ((C0810i) b.getLayoutParams()).m3737e();
            }
        }

        boolean m4035a(C0850s c0850s) {
            return this.f1883d >= 0 && this.f1883d < c0850s.m4222e();
        }

        public View m4036b(View view) {
            int size = this.f1890k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((C0853v) this.f1890k.get(i2)).itemView;
                C0810i c0810i = (C0810i) view4.getLayoutParams();
                if (view4 != view) {
                    if (c0810i.m3735c()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (c0810i.m3737e() - this.f1883d) * this.f1884e;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2++;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2++;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager.d */
    public static class C0819d implements Parcelable {
        public static final Creator<C0819d> CREATOR;
        int f1892a;
        int f1893b;
        boolean f1894c;

        /* renamed from: android.support.v7.widget.LinearLayoutManager.d.1 */
        static class C08181 implements Creator<C0819d> {
            C08181() {
            }

            public C0819d m4037a(Parcel parcel) {
                return new C0819d(parcel);
            }

            public C0819d[] m4038a(int i) {
                return new C0819d[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4037a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4038a(i);
            }
        }

        static {
            CREATOR = new C08181();
        }

        C0819d(Parcel parcel) {
            boolean z = true;
            this.f1892a = parcel.readInt();
            this.f1893b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f1894c = z;
        }

        public C0819d(C0819d c0819d) {
            this.f1892a = c0819d.f1892a;
            this.f1893b = c0819d.f1893b;
            this.f1894c = c0819d.f1894c;
        }

        boolean m4039a() {
            return this.f1892a >= 0;
        }

        void m4040b() {
            this.f1892a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1892a);
            parcel.writeInt(this.f1893b);
            parcel.writeInt(this.f1894c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f1838c = false;
        this.f1844k = false;
        this.f1839d = false;
        this.f1840e = true;
        this.f1845l = -1;
        this.f1846m = Integer.MIN_VALUE;
        this.f1847n = null;
        this.f1848o = new C0815a(this);
        m3925b(i);
        m3926b(z);
        m3832c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1838c = false;
        this.f1844k = false;
        this.f1839d = false;
        this.f1840e = true;
        this.f1845l = -1;
        this.f1846m = Integer.MIN_VALUE;
        this.f1847n = null;
        this.f1848o = new C0815a(this);
        C0839a a = C0812h.m3746a(context, attributeSet, i, i2);
        m3925b(a.f1911a);
        m3926b(a.f1913c);
        m3922a(a.f1914d);
        m3832c(true);
    }

    private View m3881J() {
        return m3858i(this.f1844k ? m3875u() - 1 : 0);
    }

    private View m3882K() {
        return m3858i(this.f1844k ? 0 : m3875u() - 1);
    }

    private int m3883a(int i, C0844n c0844n, C0850s c0850s, boolean z) {
        int d = this.f1843j.m4673d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m3927c(-d, c0844n, c0850s);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f1843j.m4673d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f1843j.m4668a(i2);
        return d + i2;
    }

    private View m3884a(boolean z, boolean z2) {
        return this.f1844k ? m3911a(m3875u() - 1, -1, z, z2) : m3911a(0, m3875u(), z, z2);
    }

    private void m3885a(int i, int i2, boolean z, C0850s c0850s) {
        int i3 = -1;
        int i4 = 1;
        this.f1836a.f1891l = m3947k();
        this.f1836a.f1887h = m3924b(c0850s);
        this.f1836a.f1885f = i;
        View K;
        C0817c c0817c;
        if (i == 1) {
            C0817c c0817c2 = this.f1836a;
            c0817c2.f1887h += this.f1843j.m4679g();
            K = m3882K();
            c0817c = this.f1836a;
            if (!this.f1844k) {
                i3 = 1;
            }
            c0817c.f1884e = i3;
            this.f1836a.f1883d = m3836d(K) + this.f1836a.f1884e;
            this.f1836a.f1881b = this.f1843j.m4670b(K);
            i3 = this.f1843j.m4670b(K) - this.f1843j.m4673d();
        } else {
            K = m3881J();
            c0817c = this.f1836a;
            c0817c.f1887h += this.f1843j.m4671c();
            c0817c = this.f1836a;
            if (!this.f1844k) {
                i4 = -1;
            }
            c0817c.f1884e = i4;
            this.f1836a.f1883d = m3836d(K) + this.f1836a.f1884e;
            this.f1836a.f1881b = this.f1843j.m4666a(K);
            i3 = (-this.f1843j.m4666a(K)) + this.f1843j.m4671c();
        }
        this.f1836a.f1882c = i2;
        if (z) {
            C0817c c0817c3 = this.f1836a;
            c0817c3.f1882c -= i3;
        }
        this.f1836a.f1886g = i3;
    }

    private void m3886a(C0815a c0815a) {
        m3899e(c0815a.f1871a, c0815a.f1872b);
    }

    private void m3887a(C0844n c0844n, int i) {
        if (i >= 0) {
            int u = m3875u();
            int i2;
            if (this.f1844k) {
                for (i2 = u - 1; i2 >= 0; i2--) {
                    View i3 = m3858i(i2);
                    if (this.f1843j.m4670b(i3) > i || this.f1843j.m4672c(i3) > i) {
                        m3888a(c0844n, u - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < u; i2++) {
                View i4 = m3858i(i2);
                if (this.f1843j.m4670b(i4) > i || this.f1843j.m4672c(i4) > i) {
                    m3888a(c0844n, 0, i2);
                    return;
                }
            }
        }
    }

    private void m3888a(C0844n c0844n, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m3772a(i3, c0844n);
                }
                return;
            }
            while (i > i2) {
                m3772a(i, c0844n);
                i--;
            }
        }
    }

    private void m3889a(C0844n c0844n, C0817c c0817c) {
        if (c0817c.f1880a && !c0817c.f1891l) {
            if (c0817c.f1885f == -1) {
                m3896b(c0844n, c0817c.f1886g);
            } else {
                m3887a(c0844n, c0817c.f1886g);
            }
        }
    }

    private void m3890a(C0844n c0844n, C0850s c0850s, C0815a c0815a) {
        if (!m3891a(c0850s, c0815a) && !m3898b(c0844n, c0850s, c0815a)) {
            c0815a.m4028b();
            c0815a.f1871a = this.f1839d ? c0850s.m4222e() - 1 : 0;
        }
    }

    private boolean m3891a(C0850s c0850s, C0815a c0815a) {
        boolean z = false;
        if (c0850s.m4218a() || this.f1845l == -1) {
            return false;
        }
        if (this.f1845l < 0 || this.f1845l >= c0850s.m4222e()) {
            this.f1845l = -1;
            this.f1846m = Integer.MIN_VALUE;
            return false;
        }
        c0815a.f1871a = this.f1845l;
        if (this.f1847n != null && this.f1847n.m4039a()) {
            c0815a.f1873c = this.f1847n.f1894c;
            if (c0815a.f1873c) {
                c0815a.f1872b = this.f1843j.m4673d() - this.f1847n.f1893b;
                return true;
            }
            c0815a.f1872b = this.f1843j.m4671c() + this.f1847n.f1893b;
            return true;
        } else if (this.f1846m == Integer.MIN_VALUE) {
            View c = m3929c(this.f1845l);
            if (c == null) {
                if (m3875u() > 0) {
                    if ((this.f1845l < m3836d(m3858i(0))) == this.f1844k) {
                        z = true;
                    }
                    c0815a.f1873c = z;
                }
                c0815a.m4028b();
                return true;
            } else if (this.f1843j.m4676e(c) > this.f1843j.m4677f()) {
                c0815a.m4028b();
                return true;
            } else if (this.f1843j.m4666a(c) - this.f1843j.m4671c() < 0) {
                c0815a.f1872b = this.f1843j.m4671c();
                c0815a.f1873c = false;
                return true;
            } else if (this.f1843j.m4673d() - this.f1843j.m4670b(c) < 0) {
                c0815a.f1872b = this.f1843j.m4673d();
                c0815a.f1873c = true;
                return true;
            } else {
                c0815a.f1872b = c0815a.f1873c ? this.f1843j.m4670b(c) + this.f1843j.m4669b() : this.f1843j.m4666a(c);
                return true;
            }
        } else {
            c0815a.f1873c = this.f1844k;
            if (this.f1844k) {
                c0815a.f1872b = this.f1843j.m4673d() - this.f1846m;
                return true;
            }
            c0815a.f1872b = this.f1843j.m4671c() + this.f1846m;
            return true;
        }
    }

    private int m3892b(int i, C0844n c0844n, C0850s c0850s, boolean z) {
        int c = i - this.f1843j.m4671c();
        if (c <= 0) {
            return 0;
        }
        c = -m3927c(c, c0844n, c0850s);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f1843j.m4671c();
        if (i2 <= 0) {
            return c;
        }
        this.f1843j.m4668a(-i2);
        return c - i2;
    }

    private View m3893b(boolean z, boolean z2) {
        return this.f1844k ? m3911a(0, m3875u(), z, z2) : m3911a(m3875u() - 1, -1, z, z2);
    }

    private void m3894b() {
        boolean z = true;
        if (this.f1842i == 1 || !m3944h()) {
            this.f1844k = this.f1838c;
            return;
        }
        if (this.f1838c) {
            z = false;
        }
        this.f1844k = z;
    }

    private void m3895b(C0815a c0815a) {
        m3901f(c0815a.f1871a, c0815a.f1872b);
    }

    private void m3896b(C0844n c0844n, int i) {
        int u = m3875u();
        if (i >= 0) {
            int e = this.f1843j.m4675e() - i;
            int i2;
            if (this.f1844k) {
                for (i2 = 0; i2 < u; i2++) {
                    View i3 = m3858i(i2);
                    if (this.f1843j.m4666a(i3) < e || this.f1843j.m4674d(i3) < e) {
                        m3888a(c0844n, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = u - 1; i2 >= 0; i2--) {
                View i4 = m3858i(i2);
                if (this.f1843j.m4666a(i4) < e || this.f1843j.m4674d(i4) < e) {
                    m3888a(c0844n, u - 1, i2);
                    return;
                }
            }
        }
    }

    private void m3897b(C0844n c0844n, C0850s c0850s, int i, int i2) {
        if (c0850s.m4219b() && m3875u() != 0 && !c0850s.m4218a() && m3931c()) {
            int i3 = 0;
            int i4 = 0;
            List b = c0844n.m4159b();
            int size = b.size();
            int d = m3836d(m3858i(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                C0853v c0853v = (C0853v) b.get(i5);
                if (c0853v.isRemoved()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((c0853v.getLayoutPosition() < d) != this.f1844k ? -1 : 1) == -1) {
                        i7 = this.f1843j.m4676e(c0853v.itemView) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.f1843j.m4676e(c0853v.itemView) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.f1836a.f1890k = b;
            if (i3 > 0) {
                m3901f(m3836d(m3881J()), i);
                this.f1836a.f1887h = i3;
                this.f1836a.f1882c = 0;
                this.f1836a.m4033a();
                m3909a(c0844n, this.f1836a, c0850s, false);
            }
            if (i4 > 0) {
                m3899e(m3836d(m3882K()), i2);
                this.f1836a.f1887h = i4;
                this.f1836a.f1882c = 0;
                this.f1836a.m4033a();
                m3909a(c0844n, this.f1836a, c0850s, false);
            }
            this.f1836a.f1890k = null;
        }
    }

    private boolean m3898b(C0844n c0844n, C0850s c0850s, C0815a c0815a) {
        boolean z = false;
        if (m3875u() == 0) {
            return false;
        }
        View D = m3759D();
        if (D != null && c0815a.m4025a(D, c0850s)) {
            c0815a.m4027a(D);
            return true;
        } else if (this.f1837b != this.f1839d) {
            return false;
        } else {
            D = c0815a.f1873c ? m3900f(c0844n, c0850s) : m3902g(c0844n, c0850s);
            if (D == null) {
                return false;
            }
            c0815a.m4029b(D);
            if (!c0850s.m4218a() && m3931c()) {
                if (this.f1843j.m4666a(D) >= this.f1843j.m4673d() || this.f1843j.m4670b(D) < this.f1843j.m4671c()) {
                    z = true;
                }
                if (z) {
                    c0815a.f1872b = c0815a.f1873c ? this.f1843j.m4673d() : this.f1843j.m4671c();
                }
            }
            return true;
        }
    }

    private void m3899e(int i, int i2) {
        this.f1836a.f1882c = this.f1843j.m4673d() - i2;
        this.f1836a.f1884e = this.f1844k ? -1 : 1;
        this.f1836a.f1883d = i;
        this.f1836a.f1885f = 1;
        this.f1836a.f1881b = i2;
        this.f1836a.f1886g = Integer.MIN_VALUE;
    }

    private View m3900f(C0844n c0844n, C0850s c0850s) {
        return this.f1844k ? m3903h(c0844n, c0850s) : m3905i(c0844n, c0850s);
    }

    private void m3901f(int i, int i2) {
        this.f1836a.f1882c = i2 - this.f1843j.m4671c();
        this.f1836a.f1883d = i;
        this.f1836a.f1884e = this.f1844k ? 1 : -1;
        this.f1836a.f1885f = -1;
        this.f1836a.f1881b = i2;
        this.f1836a.f1886g = Integer.MIN_VALUE;
    }

    private View m3902g(C0844n c0844n, C0850s c0850s) {
        return this.f1844k ? m3905i(c0844n, c0850s) : m3903h(c0844n, c0850s);
    }

    private View m3903h(C0844n c0844n, C0850s c0850s) {
        return m3912a(c0844n, c0850s, 0, m3875u(), c0850s.m4222e());
    }

    private int m3904i(C0850s c0850s) {
        boolean z = false;
        if (m3875u() == 0) {
            return 0;
        }
        m3945i();
        ar arVar = this.f1843j;
        View a = m3884a(!this.f1840e, true);
        if (!this.f1840e) {
            z = true;
        }
        return aw.m4726a(c0850s, arVar, a, m3893b(z, true), this, this.f1840e, this.f1844k);
    }

    private View m3905i(C0844n c0844n, C0850s c0850s) {
        return m3912a(c0844n, c0850s, m3875u() - 1, -1, c0850s.m4222e());
    }

    private int m3906j(C0850s c0850s) {
        boolean z = false;
        if (m3875u() == 0) {
            return 0;
        }
        m3945i();
        ar arVar = this.f1843j;
        View a = m3884a(!this.f1840e, true);
        if (!this.f1840e) {
            z = true;
        }
        return aw.m4725a(c0850s, arVar, a, m3893b(z, true), this, this.f1840e);
    }

    private int m3907k(C0850s c0850s) {
        boolean z = false;
        if (m3875u() == 0) {
            return 0;
        }
        m3945i();
        ar arVar = this.f1843j;
        View a = m3884a(!this.f1840e, true);
        if (!this.f1840e) {
            z = true;
        }
        return aw.m4727b(c0850s, arVar, a, m3893b(z, true), this, this.f1840e);
    }

    public int m3908a(int i, C0844n c0844n, C0850s c0850s) {
        return this.f1842i == 1 ? 0 : m3927c(i, c0844n, c0850s);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int m3909a(android.support.v7.widget.RecyclerView.C0844n r8, android.support.v7.widget.LinearLayoutManager.C0817c r9, android.support.v7.widget.RecyclerView.C0850s r10, boolean r11) {
        /*
        r7 = this;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r1 = r9.f1882c;
        r0 = r9.f1886g;
        if (r0 == r6) goto L_0x0016;
    L_0x0008:
        r0 = r9.f1882c;
        if (r0 >= 0) goto L_0x0013;
    L_0x000c:
        r0 = r9.f1886g;
        r2 = r9.f1882c;
        r0 = r0 + r2;
        r9.f1886g = r0;
    L_0x0013:
        r7.m3889a(r8, r9);
    L_0x0016:
        r0 = r9.f1882c;
        r2 = r9.f1887h;
        r0 = r0 + r2;
        r2 = new android.support.v7.widget.LinearLayoutManager$b;
        r2.<init>();
    L_0x0020:
        r3 = r9.f1891l;
        if (r3 != 0) goto L_0x0026;
    L_0x0024:
        if (r0 <= 0) goto L_0x0036;
    L_0x0026:
        r3 = r9.m4035a(r10);
        if (r3 == 0) goto L_0x0036;
    L_0x002c:
        r2.m4030a();
        r7.m3916a(r8, r10, r9, r2);
        r3 = r2.f1877b;
        if (r3 == 0) goto L_0x003b;
    L_0x0036:
        r0 = r9.f1882c;
        r0 = r1 - r0;
        return r0;
    L_0x003b:
        r3 = r9.f1881b;
        r4 = r2.f1876a;
        r5 = r9.f1885f;
        r4 = r4 * r5;
        r3 = r3 + r4;
        r9.f1881b = r3;
        r3 = r2.f1878c;
        if (r3 == 0) goto L_0x0055;
    L_0x0049:
        r3 = r7.f1836a;
        r3 = r3.f1890k;
        if (r3 != 0) goto L_0x0055;
    L_0x004f:
        r3 = r10.m4218a();
        if (r3 != 0) goto L_0x005f;
    L_0x0055:
        r3 = r9.f1882c;
        r4 = r2.f1876a;
        r3 = r3 - r4;
        r9.f1882c = r3;
        r3 = r2.f1876a;
        r0 = r0 - r3;
    L_0x005f:
        r3 = r9.f1886g;
        if (r3 == r6) goto L_0x0078;
    L_0x0063:
        r3 = r9.f1886g;
        r4 = r2.f1876a;
        r3 = r3 + r4;
        r9.f1886g = r3;
        r3 = r9.f1882c;
        if (r3 >= 0) goto L_0x0075;
    L_0x006e:
        r3 = r9.f1886g;
        r4 = r9.f1882c;
        r3 = r3 + r4;
        r9.f1886g = r3;
    L_0x0075:
        r7.m3889a(r8, r9);
    L_0x0078:
        if (r11 == 0) goto L_0x0020;
    L_0x007a:
        r3 = r2.f1879d;
        if (r3 == 0) goto L_0x0020;
    L_0x007e:
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.a(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.LinearLayoutManager$c, android.support.v7.widget.RecyclerView$s, boolean):int");
    }

    public C0810i m3910a() {
        return new C0810i(-2, -2);
    }

    View m3911a(int i, int i2, boolean z, boolean z2) {
        m3945i();
        int c = this.f1843j.m4671c();
        int d = this.f1843j.m4673d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View i4 = m3858i(i);
            int a = this.f1843j.m4666a(i4);
            int b = this.f1843j.m4670b(i4);
            if (a < d && b > c) {
                if (!z) {
                    return i4;
                }
                if (a >= c && b <= d) {
                    return i4;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = i4;
                }
            }
            i4 = view;
            i += i3;
            view = i4;
        }
        return view;
    }

    View m3912a(C0844n c0844n, C0850s c0850s, int i, int i2, int i3) {
        View view = null;
        m3945i();
        int c = this.f1843j.m4671c();
        int d = this.f1843j.m4673d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View i5 = m3858i(i);
            int d2 = m3836d(i5);
            if (d2 >= 0 && d2 < i3) {
                if (((C0810i) i5.getLayoutParams()).m3735c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = i5;
                    }
                } else if (this.f1843j.m4666a(i5) < d && this.f1843j.m4670b(i5) >= c) {
                    return i5;
                } else {
                    if (view == null) {
                        view3 = i5;
                        i5 = view2;
                        i += i4;
                        view = view3;
                        view2 = i5;
                    }
                }
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

    public View m3913a(View view, int i, C0844n c0844n, C0850s c0850s) {
        m3894b();
        if (m3875u() == 0) {
            return null;
        }
        int f = m3938f(i);
        if (f == Integer.MIN_VALUE) {
            return null;
        }
        m3945i();
        View g = f == -1 ? m3902g(c0844n, c0850s) : m3900f(c0844n, c0850s);
        if (g == null) {
            return null;
        }
        m3945i();
        m3885a(f, (int) (0.33333334f * ((float) this.f1843j.m4677f())), false, c0850s);
        this.f1836a.f1886g = Integer.MIN_VALUE;
        this.f1836a.f1880a = false;
        m3909a(c0844n, this.f1836a, c0850s, true);
        View J = f == -1 ? m3881J() : m3882K();
        return (J == g || !J.isFocusable()) ? null : J;
    }

    public void m3914a(Parcelable parcelable) {
        if (parcelable instanceof C0819d) {
            this.f1847n = (C0819d) parcelable;
            m3869o();
        }
    }

    void m3915a(C0844n c0844n, C0850s c0850s, C0815a c0815a, int i) {
    }

    void m3916a(C0844n c0844n, C0850s c0850s, C0817c c0817c, C0816b c0816b) {
        View a = c0817c.m4032a(c0844n);
        if (a == null) {
            c0816b.f1877b = true;
            return;
        }
        int f;
        int i;
        int i2;
        int i3;
        C0810i c0810i = (C0810i) a.getLayoutParams();
        if (c0817c.f1890k == null) {
            if (this.f1844k == (c0817c.f1885f == -1)) {
                m3819b(a);
            } else {
                m3820b(a, 0);
            }
        } else {
            if (this.f1844k == (c0817c.f1885f == -1)) {
                m3790a(a);
            } else {
                m3791a(a, 0);
            }
        }
        m3792a(a, 0, 0);
        c0816b.f1876a = this.f1843j.m4676e(a);
        if (this.f1842i == 1) {
            int x;
            if (m3944h()) {
                x = m3878x() - m3757B();
                f = x - this.f1843j.m4678f(a);
            } else {
                f = m3880z();
                x = this.f1843j.m4678f(a) + f;
            }
            if (c0817c.f1885f == -1) {
                i = c0817c.f1881b;
                i2 = c0817c.f1881b - c0816b.f1876a;
                i3 = x;
            } else {
                i2 = c0817c.f1881b;
                i = c0816b.f1876a + c0817c.f1881b;
                i3 = x;
            }
        } else {
            i2 = m3756A();
            i = i2 + this.f1843j.m4678f(a);
            if (c0817c.f1885f == -1) {
                f = c0817c.f1881b - c0816b.f1876a;
                i3 = c0817c.f1881b;
            } else {
                f = c0817c.f1881b;
                i3 = c0817c.f1881b + c0816b.f1876a;
            }
        }
        m3793a(a, f, i2, i3, i);
        if (c0810i.m3735c() || c0810i.m3736d()) {
            c0816b.f1878c = true;
        }
        c0816b.f1879d = a.isFocusable();
    }

    public void m3917a(C0850s c0850s) {
        super.m3783a(c0850s);
        this.f1847n = null;
        this.f1845l = -1;
        this.f1846m = Integer.MIN_VALUE;
        this.f1848o.m4026a();
    }

    public void m3918a(RecyclerView recyclerView, C0844n c0844n) {
        super.m3788a(recyclerView, c0844n);
        if (this.f1841f) {
            m3826c(c0844n);
            c0844n.m4150a();
        }
    }

    public void m3919a(RecyclerView recyclerView, C0850s c0850s, int i) {
        C0813r c08141 = new C08141(this, recyclerView.getContext());
        c08141.m4000d(i);
        m3782a(c08141);
    }

    public void m3920a(AccessibilityEvent accessibilityEvent) {
        super.m3799a(accessibilityEvent);
        if (m3875u() > 0) {
            C0440k a = C0402a.m1482a(accessibilityEvent);
            a.m1671b(m3949m());
            a.m1672c(m3950n());
        }
    }

    public void m3921a(String str) {
        if (this.f1847n == null) {
            super.m3800a(str);
        }
    }

    public void m3922a(boolean z) {
        m3921a(null);
        if (this.f1839d != z) {
            this.f1839d = z;
            m3869o();
        }
    }

    public int m3923b(int i, C0844n c0844n, C0850s c0850s) {
        return this.f1842i == 0 ? 0 : m3927c(i, c0844n, c0850s);
    }

    protected int m3924b(C0850s c0850s) {
        return c0850s.m4221d() ? this.f1843j.m4677f() : 0;
    }

    public void m3925b(int i) {
        if (i == 0 || i == 1) {
            m3921a(null);
            if (i != this.f1842i) {
                this.f1842i = i;
                this.f1843j = null;
                m3869o();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void m3926b(boolean z) {
        m3921a(null);
        if (z != this.f1838c) {
            this.f1838c = z;
            m3869o();
        }
    }

    int m3927c(int i, C0844n c0844n, C0850s c0850s) {
        if (m3875u() == 0 || i == 0) {
            return 0;
        }
        this.f1836a.f1880a = true;
        m3945i();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m3885a(i2, abs, true, c0850s);
        int a = this.f1836a.f1886g + m3909a(c0844n, this.f1836a, c0850s, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f1843j.m4668a(-i);
        this.f1836a.f1889j = i;
        return i;
    }

    public int m3928c(C0850s c0850s) {
        return m3904i(c0850s);
    }

    public View m3929c(int i) {
        int u = m3875u();
        if (u == 0) {
            return null;
        }
        int d = i - m3836d(m3858i(0));
        if (d >= 0 && d < u) {
            View i2 = m3858i(d);
            if (m3836d(i2) == i) {
                return i2;
            }
        }
        return super.m3824c(i);
    }

    public void m3930c(C0844n c0844n, C0850s c0850s) {
        int i = -1;
        if (!(this.f1847n == null && this.f1845l == -1) && c0850s.m4222e() == 0) {
            m3826c(c0844n);
            return;
        }
        int i2;
        int d;
        if (this.f1847n != null && this.f1847n.m4039a()) {
            this.f1845l = this.f1847n.f1892a;
        }
        m3945i();
        this.f1836a.f1880a = false;
        m3894b();
        if (!(this.f1848o.f1874d && this.f1845l == -1 && this.f1847n == null)) {
            this.f1848o.m4026a();
            this.f1848o.f1873c = this.f1844k ^ this.f1839d;
            m3890a(c0844n, c0850s, this.f1848o);
            this.f1848o.f1874d = true;
        }
        int b = m3924b(c0850s);
        if (this.f1836a.f1889j >= 0) {
            i2 = 0;
        } else {
            i2 = b;
            b = 0;
        }
        i2 += this.f1843j.m4671c();
        b += this.f1843j.m4679g();
        if (!(!c0850s.m4218a() || this.f1845l == -1 || this.f1846m == Integer.MIN_VALUE)) {
            View c = m3929c(this.f1845l);
            if (c != null) {
                if (this.f1844k) {
                    d = (this.f1843j.m4673d() - this.f1843j.m4670b(c)) - this.f1846m;
                } else {
                    d = this.f1846m - (this.f1843j.m4666a(c) - this.f1843j.m4671c());
                }
                if (d > 0) {
                    i2 += d;
                } else {
                    b -= d;
                }
            }
        }
        if (this.f1848o.f1873c) {
            if (this.f1844k) {
                i = 1;
            }
        } else if (!this.f1844k) {
            i = 1;
        }
        m3915a(c0844n, c0850s, this.f1848o, i);
        m3777a(c0844n);
        this.f1836a.f1891l = m3947k();
        this.f1836a.f1888i = c0850s.m4218a();
        if (this.f1848o.f1873c) {
            m3895b(this.f1848o);
            this.f1836a.f1887h = i2;
            m3909a(c0844n, this.f1836a, c0850s, false);
            i2 = this.f1836a.f1881b;
            d = this.f1836a.f1883d;
            if (this.f1836a.f1882c > 0) {
                b += this.f1836a.f1882c;
            }
            m3886a(this.f1848o);
            this.f1836a.f1887h = b;
            C0817c c0817c = this.f1836a;
            c0817c.f1883d += this.f1836a.f1884e;
            m3909a(c0844n, this.f1836a, c0850s, false);
            i = this.f1836a.f1881b;
            if (this.f1836a.f1882c > 0) {
                b = this.f1836a.f1882c;
                m3901f(d, i2);
                this.f1836a.f1887h = b;
                m3909a(c0844n, this.f1836a, c0850s, false);
                b = this.f1836a.f1881b;
            } else {
                b = i2;
            }
            i2 = b;
            b = i;
        } else {
            m3886a(this.f1848o);
            this.f1836a.f1887h = b;
            m3909a(c0844n, this.f1836a, c0850s, false);
            b = this.f1836a.f1881b;
            i = this.f1836a.f1883d;
            if (this.f1836a.f1882c > 0) {
                i2 += this.f1836a.f1882c;
            }
            m3895b(this.f1848o);
            this.f1836a.f1887h = i2;
            C0817c c0817c2 = this.f1836a;
            c0817c2.f1883d += this.f1836a.f1884e;
            m3909a(c0844n, this.f1836a, c0850s, false);
            i2 = this.f1836a.f1881b;
            if (this.f1836a.f1882c > 0) {
                d = this.f1836a.f1882c;
                m3899e(i, b);
                this.f1836a.f1887h = d;
                m3909a(c0844n, this.f1836a, c0850s, false);
                b = this.f1836a.f1881b;
            }
        }
        if (m3875u() > 0) {
            int b2;
            if ((this.f1844k ^ this.f1839d) != 0) {
                i = m3883a(b, c0844n, c0850s, true);
                i2 += i;
                b += i;
                b2 = m3892b(i2, c0844n, c0850s, false);
                i2 += b2;
                b += b2;
            } else {
                i = m3892b(i2, c0844n, c0850s, true);
                i2 += i;
                b += i;
                b2 = m3883a(b, c0844n, c0850s, false);
                i2 += b2;
                b += b2;
            }
        }
        m3897b(c0844n, c0850s, i2, b);
        if (c0850s.m4218a()) {
            this.f1848o.m4026a();
        } else {
            this.f1843j.m4667a();
        }
        this.f1837b = this.f1839d;
    }

    public boolean m3931c() {
        return this.f1847n == null && this.f1837b == this.f1839d;
    }

    public int m3932d(C0850s c0850s) {
        return m3904i(c0850s);
    }

    public PointF m3933d(int i) {
        int i2 = 1;
        boolean z = false;
        if (m3875u() == 0) {
            return null;
        }
        if (i < m3836d(m3858i(0))) {
            z = true;
        }
        if (z != this.f1844k) {
            i2 = -1;
        }
        return this.f1842i == 0 ? new PointF((float) i2, 0.0f) : new PointF(0.0f, (float) i2);
    }

    public Parcelable m3934d() {
        if (this.f1847n != null) {
            return new C0819d(this.f1847n);
        }
        Parcelable c0819d = new C0819d();
        if (m3875u() > 0) {
            m3945i();
            boolean z = this.f1837b ^ this.f1844k;
            c0819d.f1894c = z;
            View K;
            if (z) {
                K = m3882K();
                c0819d.f1893b = this.f1843j.m4673d() - this.f1843j.m4670b(K);
                c0819d.f1892a = m3836d(K);
                return c0819d;
            }
            K = m3881J();
            c0819d.f1892a = m3836d(K);
            c0819d.f1893b = this.f1843j.m4666a(K) - this.f1843j.m4671c();
            return c0819d;
        }
        c0819d.m4040b();
        return c0819d;
    }

    public int m3935e(C0850s c0850s) {
        return m3906j(c0850s);
    }

    public void m3936e(int i) {
        this.f1845l = i;
        this.f1846m = Integer.MIN_VALUE;
        if (this.f1847n != null) {
            this.f1847n.m4040b();
        }
        m3869o();
    }

    public boolean m3937e() {
        return this.f1842i == 0;
    }

    int m3938f(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case C1373c.View_android_focusable /*1*/:
                return (this.f1842i == 1 || !m3944h()) ? -1 : 1;
            case C1373c.View_paddingStart /*2*/:
                return this.f1842i == 1 ? 1 : !m3944h() ? 1 : -1;
            case C1373c.Toolbar_titleMarginTop /*17*/:
                return this.f1842i != 0 ? Integer.MIN_VALUE : -1;
            case C1373c.AppCompatTheme_actionModeCopyDrawable /*33*/:
                return this.f1842i != 1 ? Integer.MIN_VALUE : -1;
            case C1373c.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                if (this.f1842i != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.f1842i == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int m3939f(C0850s c0850s) {
        return m3906j(c0850s);
    }

    public boolean m3940f() {
        return this.f1842i == 1;
    }

    public int m3941g() {
        return this.f1842i;
    }

    public int m3942g(C0850s c0850s) {
        return m3907k(c0850s);
    }

    public int m3943h(C0850s c0850s) {
        return m3907k(c0850s);
    }

    protected boolean m3944h() {
        return m3873s() == 1;
    }

    void m3945i() {
        if (this.f1836a == null) {
            this.f1836a = m3946j();
        }
        if (this.f1843j == null) {
            this.f1843j = ar.m4664a(this, this.f1842i);
        }
    }

    C0817c m3946j() {
        return new C0817c();
    }

    boolean m3947k() {
        return this.f1843j.m4680h() == 0 && this.f1843j.m4675e() == 0;
    }

    boolean m3948l() {
        return (m3877w() == 1073741824 || m3876v() == 1073741824 || !m3764I()) ? false : true;
    }

    public int m3949m() {
        View a = m3911a(0, m3875u(), false, true);
        return a == null ? -1 : m3836d(a);
    }

    public int m3950n() {
        View a = m3911a(m3875u() - 1, -1, false, true);
        return a == null ? -1 : m3836d(a);
    }
}
