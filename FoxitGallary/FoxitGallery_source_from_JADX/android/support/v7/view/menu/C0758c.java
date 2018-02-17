package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p024e.p025a.C0348b;
import android.support.v4.p024e.p025a.C0349c;
import android.support.v4.p030j.C0380a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.view.menu.c */
abstract class C0758c<T> extends C0757d<T> {
    final Context f1492a;
    private Map<C0348b, MenuItem> f1493c;
    private Map<C0349c, SubMenu> f1494d;

    C0758c(Context context, T t) {
        super(t);
        this.f1492a = context;
    }

    final MenuItem m3343a(MenuItem menuItem) {
        if (!(menuItem instanceof C0348b)) {
            return menuItem;
        }
        C0348b c0348b = (C0348b) menuItem;
        if (this.f1493c == null) {
            this.f1493c = new C0380a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1493c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0782q.m3537a(this.f1492a, c0348b);
        this.f1493c.put(c0348b, menuItem2);
        return menuItem2;
    }

    final SubMenu m3344a(SubMenu subMenu) {
        if (!(subMenu instanceof C0349c)) {
            return subMenu;
        }
        C0349c c0349c = (C0349c) subMenu;
        if (this.f1494d == null) {
            this.f1494d = new C0380a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1494d.get(c0349c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0782q.m3538a(this.f1492a, c0349c);
        this.f1494d.put(c0349c, subMenu2);
        return subMenu2;
    }

    final void m3345a() {
        if (this.f1493c != null) {
            this.f1493c.clear();
        }
        if (this.f1494d != null) {
            this.f1494d.clear();
        }
    }

    final void m3346a(int i) {
        if (this.f1493c != null) {
            Iterator it = this.f1493c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m3347b(int i) {
        if (this.f1493c != null) {
            Iterator it = this.f1493c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
