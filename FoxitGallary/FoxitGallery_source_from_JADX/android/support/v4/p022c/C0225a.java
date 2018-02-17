package android.support.v4.p022c;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;

/* renamed from: android.support.v4.c.a */
public class C0225a {
    private static final Object f477a;
    private static TypedValue f478b;

    static {
        f477a = new Object();
    }

    public static int m807a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static final Drawable m808a(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return C0306b.m1181a(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f477a) {
            if (f478b == null) {
                f478b = new TypedValue();
            }
            context.getResources().getValue(i, f478b, true);
            i2 = f478b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static boolean m809a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0309e.m1184a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0308d.m1183a(context, intentArr);
            return true;
        }
    }

    public static final ColorStateList m810b(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? C0307c.m1182a(context, i) : context.getResources().getColorStateList(i);
    }
}
