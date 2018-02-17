package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.p014d.C0346a;
import android.util.TypedValue;

class ba {
    static final int[] f2329a;
    static final int[] f2330b;
    static final int[] f2331c;
    static final int[] f2332d;
    static final int[] f2333e;
    static final int[] f2334f;
    static final int[] f2335g;
    static final int[] f2336h;
    private static final ThreadLocal<TypedValue> f2337i;
    private static final int[] f2338j;

    static {
        f2337i = new ThreadLocal();
        f2329a = new int[]{-16842910};
        f2330b = new int[]{16842908};
        f2331c = new int[]{16843518};
        f2332d = new int[]{16842919};
        f2333e = new int[]{16842912};
        f2334f = new int[]{16842913};
        f2335g = new int[]{-16842919, -16842908};
        f2336h = new int[0];
        f2338j = new int[1];
    }

    public static int m4762a(Context context, int i) {
        f2338j[0] = i;
        bf a = bf.m4773a(context, null, f2338j);
        try {
            int b = a.m4780b(0, 0);
            return b;
        } finally {
            a.m4778a();
        }
    }

    static int m4763a(Context context, int i, float f) {
        int a = m4762a(context, i);
        return C0346a.m1319b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    private static TypedValue m4764a() {
        TypedValue typedValue = (TypedValue) f2337i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2337i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList m4765b(Context context, int i) {
        f2338j[0] = i;
        bf a = bf.m4773a(context, null, f2338j);
        try {
            ColorStateList e = a.m4787e(0);
            return e;
        } finally {
            a.m4778a();
        }
    }

    public static int m4766c(Context context, int i) {
        ColorStateList b = m4765b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2329a, b.getDefaultColor());
        }
        TypedValue a = m4764a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m4763a(context, i, a.getFloat());
    }
}
