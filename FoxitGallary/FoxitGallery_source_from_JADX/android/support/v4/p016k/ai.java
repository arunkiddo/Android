package android.support.v4.p016k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.k.ai */
class ai {
    private static Field f783a;
    private static boolean f784b;
    private static Field f785c;
    private static boolean f786d;

    static ColorStateList m1960a(View view) {
        return view instanceof ae ? ((ae) view).getSupportBackgroundTintList() : null;
    }

    static void m1961a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m1962a(View view, ColorStateList colorStateList) {
        if (view instanceof ae) {
            ((ae) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static void m1963a(View view, Mode mode) {
        if (view instanceof ae) {
            ((ae) view).setSupportBackgroundTintMode(mode);
        }
    }

    static Mode m1964b(View view) {
        return view instanceof ae ? ((ae) view).getSupportBackgroundTintMode() : null;
    }

    static void m1965b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    static boolean m1966c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m1967d(View view) {
        if (!f784b) {
            try {
                f783a = View.class.getDeclaredField("mMinWidth");
                f783a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f784b = true;
        }
        if (f783a != null) {
            try {
                return ((Integer) f783a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m1968e(View view) {
        if (!f786d) {
            try {
                f785c = View.class.getDeclaredField("mMinHeight");
                f785c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f786d = true;
        }
        if (f785c != null) {
            try {
                return ((Integer) f785c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m1969f(View view) {
        return view.getWindowToken() != null;
    }
}
