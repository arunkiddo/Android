package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p016k.ah;
import android.support.v7.view.menu.C0114p.C0112a;
import android.support.v7.view.menu.C0755o.C0691a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.b */
public abstract class C0756b implements C0755o {
    protected Context f1481a;
    protected Context f1482b;
    protected C0769h f1483c;
    protected LayoutInflater f1484d;
    protected LayoutInflater f1485e;
    protected C0114p f1486f;
    private C0691a f1487g;
    private int f1488h;
    private int f1489i;
    private int f1490j;

    public C0756b(Context context, int i, int i2) {
        this.f1481a = context;
        this.f1484d = LayoutInflater.from(context);
        this.f1488h = i;
        this.f1489i = i2;
    }

    public C0691a m3326a() {
        return this.f1487g;
    }

    public C0114p m3327a(ViewGroup viewGroup) {
        if (this.f1486f == null) {
            this.f1486f = (C0114p) this.f1484d.inflate(this.f1488h, viewGroup, false);
            this.f1486f.m238a(this.f1483c);
            m3340b(true);
        }
        return this.f1486f;
    }

    public View m3328a(C0772j c0772j, View view, ViewGroup viewGroup) {
        C0112a b = view instanceof C0112a ? (C0112a) view : m3339b(viewGroup);
        m3332a(c0772j, b);
        return (View) b;
    }

    public void m3329a(int i) {
        this.f1490j = i;
    }

    public void m3330a(Context context, C0769h c0769h) {
        this.f1482b = context;
        this.f1485e = LayoutInflater.from(this.f1482b);
        this.f1483c = c0769h;
    }

    public void m3331a(C0769h c0769h, boolean z) {
        if (this.f1487g != null) {
            this.f1487g.m3040a(c0769h, z);
        }
    }

    public abstract void m3332a(C0772j c0772j, C0112a c0112a);

    public void m3333a(C0691a c0691a) {
        this.f1487g = c0691a;
    }

    protected void m3334a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1486f).addView(view, i);
    }

    public boolean m3335a(int i, C0772j c0772j) {
        return true;
    }

    public boolean m3336a(C0769h c0769h, C0772j c0772j) {
        return false;
    }

    public boolean m3337a(C0786u c0786u) {
        return this.f1487g != null ? this.f1487g.m3041a(c0786u) : false;
    }

    protected boolean m3338a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public C0112a m3339b(ViewGroup viewGroup) {
        return (C0112a) this.f1484d.inflate(this.f1489i, viewGroup, false);
    }

    public void m3340b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1486f;
        if (viewGroup != null) {
            int i;
            if (this.f1483c != null) {
                this.f1483c.m3464j();
                ArrayList i2 = this.f1483c.m3463i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0772j c0772j = (C0772j) i2.get(i3);
                    if (m3335a(i, c0772j)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0772j itemData = childAt instanceof C0112a ? ((C0112a) childAt).getItemData() : null;
                        View a = m3328a(c0772j, childAt, viewGroup);
                        if (c0772j != itemData) {
                            a.setPressed(false);
                            ah.m1956w(a);
                        }
                        if (a != childAt) {
                            m3334a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!m3338a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean m3341b() {
        return false;
    }

    public boolean m3342b(C0769h c0769h, C0772j c0772j) {
        return false;
    }
}
