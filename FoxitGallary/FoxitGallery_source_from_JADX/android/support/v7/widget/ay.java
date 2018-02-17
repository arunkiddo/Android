package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0836e;
import android.support.v7.widget.RecyclerView.C0836e.C0835c;
import android.support.v7.widget.RecyclerView.C0853v;
import android.view.View;

public abstract class ay extends C0836e {
    boolean f2218a;

    public ay() {
        this.f2218a = true;
    }

    public final void m4569a(C0853v c0853v, boolean z) {
        m4580d(c0853v, z);
        m4121e(c0853v);
    }

    public abstract boolean m4570a(C0853v c0853v);

    public abstract boolean m4571a(C0853v c0853v, int i, int i2, int i3, int i4);

    public boolean m4572a(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
        int i = c0835c.f1900a;
        int i2 = c0835c.f1901b;
        View view = c0853v.itemView;
        int left = c0835c2 == null ? view.getLeft() : c0835c2.f1900a;
        int top = c0835c2 == null ? view.getTop() : c0835c2.f1901b;
        if (c0853v.isRemoved() || (i == left && i2 == top)) {
            return m4570a(c0853v);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return m4571a(c0853v, i, i2, left, top);
    }

    public abstract boolean m4573a(C0853v c0853v, C0853v c0853v2, int i, int i2, int i3, int i4);

    public boolean m4574a(C0853v c0853v, C0853v c0853v2, C0835c c0835c, C0835c c0835c2) {
        int i;
        int i2;
        int i3 = c0835c.f1900a;
        int i4 = c0835c.f1901b;
        if (c0853v2.shouldIgnore()) {
            i = c0835c.f1900a;
            i2 = c0835c.f1901b;
        } else {
            i = c0835c2.f1900a;
            i2 = c0835c2.f1901b;
        }
        return m4573a(c0853v, c0853v2, i3, i4, i, i2);
    }

    public final void m4575b(C0853v c0853v, boolean z) {
        m4578c(c0853v, z);
    }

    public abstract boolean m4576b(C0853v c0853v);

    public boolean m4577b(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
        if (c0835c == null || (c0835c.f1900a == c0835c2.f1900a && c0835c.f1901b == c0835c2.f1901b)) {
            return m4576b(c0853v);
        }
        return m4571a(c0853v, c0835c.f1900a, c0835c.f1901b, c0835c2.f1900a, c0835c2.f1901b);
    }

    public void m4578c(C0853v c0853v, boolean z) {
    }

    public boolean m4579c(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
        if (c0835c.f1900a == c0835c2.f1900a && c0835c.f1901b == c0835c2.f1901b) {
            m4583i(c0853v);
            return false;
        }
        return m4571a(c0853v, c0835c.f1900a, c0835c.f1901b, c0835c2.f1900a, c0835c2.f1901b);
    }

    public void m4580d(C0853v c0853v, boolean z) {
    }

    public boolean m4581g(C0853v c0853v) {
        return !this.f2218a || c0853v.isInvalid();
    }

    public final void m4582h(C0853v c0853v) {
        m4589o(c0853v);
        m4121e(c0853v);
    }

    public final void m4583i(C0853v c0853v) {
        m4593s(c0853v);
        m4121e(c0853v);
    }

    public final void m4584j(C0853v c0853v) {
        m4591q(c0853v);
        m4121e(c0853v);
    }

    public final void m4585k(C0853v c0853v) {
        m4588n(c0853v);
    }

    public final void m4586l(C0853v c0853v) {
        m4592r(c0853v);
    }

    public final void m4587m(C0853v c0853v) {
        m4590p(c0853v);
    }

    public void m4588n(C0853v c0853v) {
    }

    public void m4589o(C0853v c0853v) {
    }

    public void m4590p(C0853v c0853v) {
    }

    public void m4591q(C0853v c0853v) {
    }

    public void m4592r(C0853v c0853v) {
    }

    public void m4593s(C0853v c0853v) {
    }
}
