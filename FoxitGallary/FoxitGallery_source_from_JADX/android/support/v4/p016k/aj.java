package android.support.v4.p016k;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.k.aj */
class aj {
    private static Method f787a;

    public static void m1970a(ViewGroup viewGroup, boolean z) {
        if (f787a == null) {
            try {
                f787a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            f787a.setAccessible(true);
        }
        try {
            f787a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
