package android.support.v4.p016k;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.k.al */
class al {
    public static float m1972a(View view) {
        return view.getAlpha();
    }

    public static int m1973a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int m1974a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    static long m1975a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m1976a(View view, float f) {
        view.setTranslationX(f);
    }

    static void m1977a(View view, int i) {
        view.offsetTopAndBottom(i);
        al.m1994j(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            al.m1994j((View) parent);
        }
    }

    public static void m1978a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void m1979a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static int m1980b(View view) {
        return view.getLayerType();
    }

    public static void m1981b(View view, float f) {
        view.setTranslationY(f);
    }

    static void m1982b(View view, int i) {
        view.offsetLeftAndRight(i);
        al.m1994j(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            al.m1994j((View) parent);
        }
    }

    public static void m1983b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int m1984c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void m1985c(View view, float f) {
        view.setAlpha(f);
    }

    public static int m1986d(View view) {
        return view.getMeasuredState();
    }

    public static void m1987d(View view, float f) {
        view.setScaleX(f);
    }

    public static float m1988e(View view) {
        return view.getTranslationX();
    }

    public static void m1989e(View view, float f) {
        view.setScaleY(f);
    }

    public static float m1990f(View view) {
        return view.getTranslationY();
    }

    public static float m1991g(View view) {
        return view.getScaleX();
    }

    public static Matrix m1992h(View view) {
        return view.getMatrix();
    }

    public static void m1993i(View view) {
        view.jumpDrawablesToCurrentState();
    }

    private static void m1994j(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
