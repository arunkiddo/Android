package android.support.v4.p014d.p015a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.d.a.h */
class C0333h {
    public static Drawable m1291a(Drawable drawable) {
        return !(drawable instanceof C0086o) ? new C0345n(drawable) : drawable;
    }

    public static void m1292a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m1293a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m1294a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m1295a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m1296a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static void m1297a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void m1298a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static boolean m1299b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m1300c(Drawable drawable) {
        return drawable.getColorFilter();
    }
}
