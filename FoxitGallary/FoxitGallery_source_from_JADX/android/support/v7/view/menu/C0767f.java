package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.view.menu.C0114p.C0112a;
import android.support.v7.view.menu.C0755o.C0691a;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.f */
public class C0767f implements C0755o, OnItemClickListener {
    Context f1532a;
    LayoutInflater f1533b;
    C0769h f1534c;
    ExpandedMenuView f1535d;
    int f1536e;
    int f1537f;
    C0766a f1538g;
    private int f1539h;
    private C0691a f1540i;

    /* renamed from: android.support.v7.view.menu.f.a */
    private class C0766a extends BaseAdapter {
        final /* synthetic */ C0767f f1530a;
        private int f1531b;

        public C0766a(C0767f c0767f) {
            this.f1530a = c0767f;
            this.f1531b = -1;
            m3402a();
        }

        public C0772j m3401a(int i) {
            ArrayList l = this.f1530a.f1534c.m3466l();
            int a = this.f1530a.f1539h + i;
            if (this.f1531b >= 0 && a >= this.f1531b) {
                a++;
            }
            return (C0772j) l.get(a);
        }

        void m3402a() {
            C0772j r = this.f1530a.f1534c.m3472r();
            if (r != null) {
                ArrayList l = this.f1530a.f1534c.m3466l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0772j) l.get(i)) == r) {
                        this.f1531b = i;
                        return;
                    }
                }
            }
            this.f1531b = -1;
        }

        public int getCount() {
            int size = this.f1530a.f1534c.m3466l().size() - this.f1530a.f1539h;
            return this.f1531b < 0 ? size : size - 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return m3401a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.f1530a.f1533b.inflate(this.f1530a.f1537f, viewGroup, false) : view;
            ((C0112a) inflate).m233a(m3401a(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            m3402a();
            super.notifyDataSetChanged();
        }
    }

    public C0767f(int i, int i2) {
        this.f1537f = i;
        this.f1536e = i2;
    }

    public C0767f(Context context, int i) {
        this(i, 0);
        this.f1532a = context;
        this.f1533b = LayoutInflater.from(this.f1532a);
    }

    public C0114p m3404a(ViewGroup viewGroup) {
        if (this.f1535d == null) {
            this.f1535d = (ExpandedMenuView) this.f1533b.inflate(C0726g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1538g == null) {
                this.f1538g = new C0766a(this);
            }
            this.f1535d.setAdapter(this.f1538g);
            this.f1535d.setOnItemClickListener(this);
        }
        return this.f1535d;
    }

    public ListAdapter m3405a() {
        if (this.f1538g == null) {
            this.f1538g = new C0766a(this);
        }
        return this.f1538g;
    }

    public void m3406a(Context context, C0769h c0769h) {
        if (this.f1536e != 0) {
            this.f1532a = new ContextThemeWrapper(context, this.f1536e);
            this.f1533b = LayoutInflater.from(this.f1532a);
        } else if (this.f1532a != null) {
            this.f1532a = context;
            if (this.f1533b == null) {
                this.f1533b = LayoutInflater.from(this.f1532a);
            }
        }
        this.f1534c = c0769h;
        if (this.f1538g != null) {
            this.f1538g.notifyDataSetChanged();
        }
    }

    public void m3407a(C0769h c0769h, boolean z) {
        if (this.f1540i != null) {
            this.f1540i.m3040a(c0769h, z);
        }
    }

    public void m3408a(C0691a c0691a) {
        this.f1540i = c0691a;
    }

    public boolean m3409a(C0769h c0769h, C0772j c0772j) {
        return false;
    }

    public boolean m3410a(C0786u c0786u) {
        if (!c0786u.hasVisibleItems()) {
            return false;
        }
        new C0770i(c0786u).m3474a(null);
        if (this.f1540i != null) {
            this.f1540i.m3041a(c0786u);
        }
        return true;
    }

    public void m3411b(boolean z) {
        if (this.f1538g != null) {
            this.f1538g.notifyDataSetChanged();
        }
    }

    public boolean m3412b() {
        return false;
    }

    public boolean m3413b(C0769h c0769h, C0772j c0772j) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1534c.m3444a(this.f1538g.m3401a(i), (C0755o) this, 0);
    }
}
