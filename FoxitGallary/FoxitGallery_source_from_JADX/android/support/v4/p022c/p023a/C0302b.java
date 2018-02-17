package android.support.v4.p022c.p023a;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/* renamed from: android.support.v4.c.a.b */
class C0302b {
    static int m1173a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    static int m1174b(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    static int m1175c(Resources resources) {
        return Math.min(C0302b.m1174b(resources), C0302b.m1173a(resources));
    }
}
