package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p034b.C0730a.C0720a;

/* renamed from: android.support.design.widget.p */
class C0196p {
    private static final int[] f441a;

    static {
        f441a = new int[]{C0720a.colorPrimary};
    }

    static void m726a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f441a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
