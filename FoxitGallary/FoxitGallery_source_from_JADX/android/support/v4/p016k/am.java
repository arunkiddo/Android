package android.support.v4.p016k;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* renamed from: android.support.v4.k.am */
class am {
    public static void m1995a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m1996a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean m1997a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m1998b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
