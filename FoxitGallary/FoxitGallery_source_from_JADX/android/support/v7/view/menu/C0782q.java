package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p024e.p025a.C0347a;
import android.support.v4.p024e.p025a.C0348b;
import android.support.v4.p024e.p025a.C0349c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.view.menu.q */
public final class C0782q {
    public static Menu m3536a(Context context, C0347a c0347a) {
        if (VERSION.SDK_INT >= 14) {
            return new C0783r(context, c0347a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m3537a(Context context, C0348b c0348b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0779l(context, c0348b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0777k(context, c0348b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m3538a(Context context, C0349c c0349c) {
        if (VERSION.SDK_INT >= 14) {
            return new C0787v(context, c0349c);
        }
        throw new UnsupportedOperationException();
    }
}
