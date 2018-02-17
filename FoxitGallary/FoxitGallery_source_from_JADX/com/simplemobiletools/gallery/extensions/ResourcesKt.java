package com.simplemobiletools.gallery.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import p000a.p005e.p007b.C0036f;

public final class ResourcesKt {
    public static final int getActionBarHeight(Resources resources, Context context) {
        C0036f.m62b(resources, "$receiver");
        C0036f.m62b(context, "context");
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, resources.getDisplayMetrics()) : 0;
    }

    public static final int getNavBarHeight(Resources resources) {
        C0036f.m62b(resources, "$receiver");
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    public static final int getStatusBarHeight(Resources resources) {
        C0036f.m62b(resources, "$receiver");
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }
}
