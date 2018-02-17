package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.C0769h.C0676a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.u */
public class C0786u extends C0769h implements SubMenu {
    private C0769h f1644d;
    private C0772j f1645e;

    public C0786u(Context context, C0769h c0769h, C0772j c0772j) {
        super(context);
        this.f1644d = c0769h;
        this.f1645e = c0772j;
    }

    public String m3559a() {
        int itemId = this.f1645e != null ? this.f1645e.getItemId() : 0;
        return itemId == 0 ? null : super.m3433a() + ":" + itemId;
    }

    public void m3560a(C0676a c0676a) {
        this.f1644d.m3435a(c0676a);
    }

    boolean m3561a(C0769h c0769h, MenuItem menuItem) {
        return super.m3442a(c0769h, menuItem) || this.f1644d.m3442a(c0769h, menuItem);
    }

    public boolean m3562b() {
        return this.f1644d.m3450b();
    }

    public boolean m3563c() {
        return this.f1644d.m3453c();
    }

    public boolean m3564c(C0772j c0772j) {
        return this.f1644d.m3454c(c0772j);
    }

    public boolean m3565d(C0772j c0772j) {
        return this.f1644d.m3457d(c0772j);
    }

    public MenuItem getItem() {
        return this.f1645e;
    }

    public C0769h m3566p() {
        return this.f1644d.m3470p();
    }

    public Menu m3567s() {
        return this.f1644d;
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m3459e(i);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m3428a(drawable);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m3456d(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m3430a(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m3429a(view);
    }

    public SubMenu setIcon(int i) {
        this.f1645e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1645e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f1644d.setQwertyMode(z);
    }
}
