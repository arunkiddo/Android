package android.support.v4.p016k;

import android.view.View;

/* renamed from: android.support.v4.k.ao */
class ao {
    public static void m2000a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void m2001a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m2002a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static boolean m2003a(View view) {
        return view.hasTransientState();
    }

    public static void m2004b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int m2005c(View view) {
        return view.getImportantForAccessibility();
    }

    public static int m2006d(View view) {
        return view.getMinimumWidth();
    }

    public static int m2007e(View view) {
        return view.getMinimumHeight();
    }

    public static void m2008f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m2009g(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m2010h(View view) {
        return view.hasOverlappingRendering();
    }
}
