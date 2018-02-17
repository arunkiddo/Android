package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p016k.at;
import android.support.v4.p022c.p023a.C0301a;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0721b;
import android.support.v7.p034b.C0730a.C0723d;
import android.support.v7.p034b.C0730a.C0729j;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.view.a */
public class C0739a {
    private Context f1364a;

    private C0739a(Context context) {
        this.f1364a = context;
    }

    public static C0739a m3212a(Context context) {
        return new C0739a(context);
    }

    public int m3213a() {
        Resources resources = this.f1364a.getResources();
        int b = C0301a.m1171b(resources);
        int a = C0301a.m1170a(resources);
        return (C0301a.m1172c(resources) > 600 || b > 600 || ((b > 960 && a > 720) || (b > 720 && a > 960))) ? 5 : (b >= 500 || ((b > 640 && a > 480) || (b > 480 && a > 640))) ? 4 : b >= 360 ? 3 : 2;
    }

    public boolean m3214b() {
        return VERSION.SDK_INT >= 19 || !at.m2048b(ViewConfiguration.get(this.f1364a));
    }

    public int m3215c() {
        return this.f1364a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m3216d() {
        return this.f1364a.getResources().getBoolean(C0721b.abc_action_bar_embed_tabs);
    }

    public int m3217e() {
        TypedArray obtainStyledAttributes = this.f1364a.obtainStyledAttributes(null, C0729j.ActionBar, C0720a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0729j.ActionBar_height, 0);
        Resources resources = this.f1364a.getResources();
        if (!m3216d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0723d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m3218f() {
        return this.f1364a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m3219g() {
        return this.f1364a.getResources().getDimensionPixelSize(C0723d.abc_action_bar_stacked_tab_max_width);
    }
}
