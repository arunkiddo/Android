package android.support.v4.p016k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

/* renamed from: android.support.v4.k.ar */
class ar {
    private static ThreadLocal<Rect> f789a;

    /* renamed from: android.support.v4.k.ar.1 */
    static class C04601 implements OnApplyWindowInsetsListener {
        final /* synthetic */ ab f788a;

        C04601(ab abVar) {
            this.f788a = abVar;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ((bh) this.f788a.m428a(view, new bh(windowInsets))).m2258f();
        }
    }

    private static Rect m2020a() {
        if (f789a == null) {
            f789a = new ThreadLocal();
        }
        Rect rect = (Rect) f789a.get();
        if (rect == null) {
            rect = new Rect();
            f789a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static bg m2021a(View view, bg bgVar) {
        if (!(bgVar instanceof bh)) {
            return bgVar;
        }
        WindowInsets f = ((bh) bgVar).m2258f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        return onApplyWindowInsets != f ? new bh(onApplyWindowInsets) : bgVar;
    }

    public static void m2022a(View view) {
        view.requestApplyInsets();
    }

    public static void m2023a(View view, float f) {
        view.setElevation(f);
    }

    static void m2024a(View view, int i) {
        Object obj;
        Rect a = ar.m2020a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        al.m1977a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    static void m2025a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static void m2026a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static void m2027a(View view, ab abVar) {
        if (abVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new C04601(abVar));
        }
    }

    public static float m2028b(View view) {
        return view.getElevation();
    }

    public static bg m2029b(View view, bg bgVar) {
        if (!(bgVar instanceof bh)) {
            return bgVar;
        }
        WindowInsets f = ((bh) bgVar).m2258f();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(f);
        return dispatchApplyWindowInsets != f ? new bh(dispatchApplyWindowInsets) : bgVar;
    }

    static void m2030b(View view, int i) {
        Object obj;
        Rect a = ar.m2020a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        al.m1982b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    public static float m2031c(View view) {
        return view.getTranslationZ();
    }

    static ColorStateList m2032d(View view) {
        return view.getBackgroundTintList();
    }

    static Mode m2033e(View view) {
        return view.getBackgroundTintMode();
    }

    public static boolean m2034f(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void m2035g(View view) {
        view.stopNestedScroll();
    }

    public static float m2036h(View view) {
        return view.getZ();
    }
}
