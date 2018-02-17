package android.support.v4.p014d.p015a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.d.a.c */
class C0328c {
    public static Drawable m1277a(Drawable drawable) {
        return !(drawable instanceof C0086o) ? new C0337j(drawable) : drawable;
    }

    public static void m1278a(Drawable drawable, int i) {
        if (drawable instanceof C0086o) {
            ((C0086o) drawable).setTint(i);
        }
    }

    public static void m1279a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0086o) {
            ((C0086o) drawable).setTintList(colorStateList);
        }
    }

    public static void m1280a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void m1281a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0086o) {
            ((C0086o) drawable).setTintMode(mode);
        }
    }
}
