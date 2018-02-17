package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0853v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ab {
    final C0825b f2180a;
    final C0883a f2181b;
    final List<View> f2182c;

    /* renamed from: android.support.v7.widget.ab.b */
    interface C0825b {
        int m4049a();

        int m4050a(View view);

        void m4051a(int i);

        void m4052a(View view, int i);

        void m4053a(View view, int i, LayoutParams layoutParams);

        C0853v m4054b(View view);

        View m4055b(int i);

        void m4056b();

        void m4057c(int i);

        void m4058c(View view);

        void m4059d(View view);
    }

    /* renamed from: android.support.v7.widget.ab.a */
    static class C0883a {
        long f2178a;
        C0883a f2179b;

        C0883a() {
            this.f2178a = 0;
        }

        private void m4495b() {
            if (this.f2179b == null) {
                this.f2179b = new C0883a();
            }
        }

        void m4496a() {
            this.f2178a = 0;
            if (this.f2179b != null) {
                this.f2179b.m4496a();
            }
        }

        void m4497a(int i) {
            if (i >= 64) {
                m4495b();
                this.f2179b.m4497a(i - 64);
                return;
            }
            this.f2178a |= 1 << i;
        }

        void m4498a(int i, boolean z) {
            if (i >= 64) {
                m4495b();
                this.f2179b.m4498a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2178a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f2178a = (((j ^ -1) & this.f2178a) << 1) | (this.f2178a & j);
            if (z) {
                m4497a(i);
            } else {
                m4499b(i);
            }
            if (z2 || this.f2179b != null) {
                m4495b();
                this.f2179b.m4498a(0, z2);
            }
        }

        void m4499b(int i) {
            if (i < 64) {
                this.f2178a &= (1 << i) ^ -1;
            } else if (this.f2179b != null) {
                this.f2179b.m4499b(i - 64);
            }
        }

        boolean m4500c(int i) {
            if (i < 64) {
                return (this.f2178a & (1 << i)) != 0;
            } else {
                m4495b();
                return this.f2179b.m4500c(i - 64);
            }
        }

        boolean m4501d(int i) {
            if (i >= 64) {
                m4495b();
                return this.f2179b.m4501d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2178a & j) != 0;
            this.f2178a &= j ^ -1;
            j--;
            this.f2178a = Long.rotateRight((j ^ -1) & this.f2178a, 1) | (this.f2178a & j);
            if (this.f2179b == null) {
                return z;
            }
            if (this.f2179b.m4500c(0)) {
                m4497a(63);
            }
            this.f2179b.m4501d(0);
            return z;
        }

        int m4502e(int i) {
            return this.f2179b == null ? i >= 64 ? Long.bitCount(this.f2178a) : Long.bitCount(this.f2178a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f2178a & ((1 << i) - 1)) : this.f2179b.m4502e(i - 64) + Long.bitCount(this.f2178a);
        }

        public String toString() {
            return this.f2179b == null ? Long.toBinaryString(this.f2178a) : this.f2179b.toString() + "xx" + Long.toBinaryString(this.f2178a);
        }
    }

    ab(C0825b c0825b) {
        this.f2180a = c0825b;
        this.f2181b = new C0883a();
        this.f2182c = new ArrayList();
    }

    private int m4503e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2180a.m4049a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f2181b.m4502e(i2));
            if (e == 0) {
                while (this.f2181b.m4500c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    private void m4504g(View view) {
        this.f2182c.add(view);
        this.f2180a.m4058c(view);
    }

    private boolean m4505h(View view) {
        if (!this.f2182c.remove(view)) {
            return false;
        }
        this.f2180a.m4059d(view);
        return true;
    }

    View m4506a(int i, int i2) {
        int size = this.f2182c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f2182c.get(i3);
            C0853v b = this.f2180a.m4054b(view);
            if (b.getLayoutPosition() == i && !b.isInvalid() && !b.isRemoved() && (i2 == -1 || b.getItemViewType() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m4507a() {
        this.f2181b.m4496a();
        for (int size = this.f2182c.size() - 1; size >= 0; size--) {
            this.f2180a.m4059d((View) this.f2182c.get(size));
            this.f2182c.remove(size);
        }
        this.f2180a.m4056b();
    }

    void m4508a(int i) {
        int e = m4503e(i);
        View b = this.f2180a.m4055b(e);
        if (b != null) {
            if (this.f2181b.m4501d(e)) {
                m4505h(b);
            }
            this.f2180a.m4051a(e);
        }
    }

    void m4509a(View view) {
        int a = this.f2180a.m4050a(view);
        if (a >= 0) {
            if (this.f2181b.m4501d(a)) {
                m4505h(view);
            }
            this.f2180a.m4051a(a);
        }
    }

    void m4510a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.f2180a.m4049a() : m4503e(i);
        this.f2181b.m4498a(a, z);
        if (z) {
            m4504g(view);
        }
        this.f2180a.m4053a(view, a, layoutParams);
    }

    void m4511a(View view, int i, boolean z) {
        int a = i < 0 ? this.f2180a.m4049a() : m4503e(i);
        this.f2181b.m4498a(a, z);
        if (z) {
            m4504g(view);
        }
        this.f2180a.m4052a(view, a);
    }

    void m4512a(View view, boolean z) {
        m4511a(view, -1, z);
    }

    int m4513b() {
        return this.f2180a.m4049a() - this.f2182c.size();
    }

    int m4514b(View view) {
        int a = this.f2180a.m4050a(view);
        return (a == -1 || this.f2181b.m4500c(a)) ? -1 : a - this.f2181b.m4502e(a);
    }

    View m4515b(int i) {
        return this.f2180a.m4055b(m4503e(i));
    }

    int m4516c() {
        return this.f2180a.m4049a();
    }

    View m4517c(int i) {
        return this.f2180a.m4055b(i);
    }

    boolean m4518c(View view) {
        return this.f2182c.contains(view);
    }

    void m4519d(int i) {
        int e = m4503e(i);
        this.f2181b.m4501d(e);
        this.f2180a.m4057c(e);
    }

    void m4520d(View view) {
        int a = this.f2180a.m4050a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2181b.m4497a(a);
        m4504g(view);
    }

    void m4521e(View view) {
        int a = this.f2180a.m4050a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2181b.m4500c(a)) {
            this.f2181b.m4499b(a);
            m4505h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    boolean m4522f(View view) {
        int a = this.f2180a.m4050a(view);
        if (a == -1) {
            return m4505h(view) ? true : true;
        } else {
            if (!this.f2181b.m4500c(a)) {
                return false;
            }
            this.f2181b.m4501d(a);
            if (m4505h(view)) {
                this.f2180a.m4051a(a);
            } else {
                this.f2180a.m4051a(a);
            }
            return true;
        }
    }

    public String toString() {
        return this.f2181b.toString() + ", hidden list:" + this.f2182c.size();
    }
}
