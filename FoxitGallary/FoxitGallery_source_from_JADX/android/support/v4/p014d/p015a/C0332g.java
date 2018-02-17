package android.support.v4.p014d.p015a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.d.a.g */
class C0332g {
    public static void m1287a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m1288a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m1289b(Drawable drawable) {
        return !(drawable instanceof C0086o) ? new C0343m(drawable) : drawable;
    }

    public static int m1290c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
