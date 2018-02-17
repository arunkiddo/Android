package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p024e.p025a.C0349c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.v */
class C0787v extends C0783r implements SubMenu {
    C0787v(Context context, C0349c c0349c) {
        super(context, c0349c);
    }

    public C0349c m3568b() {
        return (C0349c) this.b;
    }

    public void clearHeader() {
        m3568b().clearHeader();
    }

    public MenuItem getItem() {
        return m3343a(m3568b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        m3568b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m3568b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        m3568b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m3568b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m3568b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        m3568b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m3568b().setIcon(drawable);
        return this;
    }
}
