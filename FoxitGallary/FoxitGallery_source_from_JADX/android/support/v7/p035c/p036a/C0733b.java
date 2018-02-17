package android.support.v7.p035c.p036a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.p022c.C0225a;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.c.a.b */
public final class C0733b {
    private static final ThreadLocal<TypedValue> f1359a;
    private static final WeakHashMap<Context, SparseArray<C0732a>> f1360b;
    private static final Object f1361c;

    /* renamed from: android.support.v7.c.a.b.a */
    private static class C0732a {
        final ColorStateList f1357a;
        final Configuration f1358b;

        C0732a(ColorStateList colorStateList, Configuration configuration) {
            this.f1357a = colorStateList;
            this.f1358b = configuration;
        }
    }

    static {
        f1359a = new ThreadLocal();
        f1360b = new WeakHashMap(0);
        f1361c = new Object();
    }

    public static ColorStateList m3202a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList c = C0733b.m3206c(context, i);
        if (c != null) {
            return c;
        }
        c = C0733b.m3205b(context, i);
        if (c == null) {
            return C0225a.m810b(context, i);
        }
        C0733b.m3204a(context, i, c);
        return c;
    }

    private static TypedValue m3203a() {
        TypedValue typedValue = (TypedValue) f1359a.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f1359a.set(typedValue);
        return typedValue;
    }

    private static void m3204a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f1361c) {
            SparseArray sparseArray = (SparseArray) f1360b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f1360b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0732a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList m3205b(Context context, int i) {
        ColorStateList colorStateList = null;
        if (!C0733b.m3207d(context, i)) {
            Resources resources = context.getResources();
            try {
                colorStateList = C0731a.m3198a(resources, resources.getXml(i), context.getTheme());
            } catch (Throwable e) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        return colorStateList;
    }

    private static ColorStateList m3206c(Context context, int i) {
        synchronized (f1361c) {
            SparseArray sparseArray = (SparseArray) f1360b.get(context);
            if (sparseArray != null && sparseArray.size() > 0) {
                C0732a c0732a = (C0732a) sparseArray.get(i);
                if (c0732a != null) {
                    if (c0732a.f1358b.equals(context.getResources().getConfiguration())) {
                        ColorStateList colorStateList = c0732a.f1357a;
                        return colorStateList;
                    }
                    sparseArray.remove(i);
                }
            }
            return null;
        }
    }

    private static boolean m3207d(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = C0733b.m3203a();
        resources.getValue(i, a, true);
        return a.type >= 28 && a.type <= 31;
    }
}
