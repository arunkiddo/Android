package android.support.v7.view.menu;

import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.view.menu.C0114p.C0112a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.g */
public class C0768g extends BaseAdapter {
    static final int f1541a;
    C0769h f1542b;
    private int f1543c;
    private boolean f1544d;
    private final boolean f1545e;
    private final LayoutInflater f1546f;

    static {
        f1541a = C0726g.abc_popup_menu_item_layout;
    }

    public C0768g(C0769h c0769h, LayoutInflater layoutInflater, boolean z) {
        this.f1543c = -1;
        this.f1545e = z;
        this.f1546f = layoutInflater;
        this.f1542b = c0769h;
        m3417b();
    }

    public C0769h m3414a() {
        return this.f1542b;
    }

    public C0772j m3415a(int i) {
        ArrayList l = this.f1545e ? this.f1542b.m3466l() : this.f1542b.m3463i();
        if (this.f1543c >= 0 && i >= this.f1543c) {
            i++;
        }
        return (C0772j) l.get(i);
    }

    public void m3416a(boolean z) {
        this.f1544d = z;
    }

    void m3417b() {
        C0772j r = this.f1542b.m3472r();
        if (r != null) {
            ArrayList l = this.f1542b.m3466l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0772j) l.get(i)) == r) {
                    this.f1543c = i;
                    return;
                }
            }
        }
        this.f1543c = -1;
    }

    public int getCount() {
        ArrayList l = this.f1545e ? this.f1542b.m3466l() : this.f1542b.m3463i();
        return this.f1543c < 0 ? l.size() : l.size() - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m3415a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f1546f.inflate(f1541a, viewGroup, false) : view;
        C0112a c0112a = (C0112a) inflate;
        if (this.f1544d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        c0112a.m233a(m3415a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m3417b();
        super.notifyDataSetChanged();
    }
}
