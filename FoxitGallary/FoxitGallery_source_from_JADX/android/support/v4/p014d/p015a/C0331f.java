package android.support.v4.p014d.p015a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.d.a.f */
class C0331f {
    private static Method f680a;
    private static boolean f681b;
    private static Method f682c;
    private static boolean f683d;

    public static int m1285a(Drawable drawable) {
        if (!f683d) {
            try {
                f682c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f682c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f683d = true;
        }
        if (f682c != null) {
            try {
                return ((Integer) f682c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f682c = null;
            }
        }
        return -1;
    }

    public static boolean m1286a(Drawable drawable, int i) {
        if (!f681b) {
            try {
                f680a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f680a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f681b = true;
        }
        if (f680a != null) {
            try {
                f680a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f680a = null;
            }
        }
        return false;
    }
}
