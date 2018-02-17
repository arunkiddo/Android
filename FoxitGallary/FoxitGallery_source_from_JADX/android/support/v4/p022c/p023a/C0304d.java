package android.support.v4.p022c.p023a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.c.a.d */
public final class C0304d {
    public static Drawable m1179a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? C0305e.m1180a(resources, i, theme) : resources.getDrawable(i);
    }
}
