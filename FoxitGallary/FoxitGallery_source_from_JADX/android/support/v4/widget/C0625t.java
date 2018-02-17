package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.t */
class C0625t {
    private static Method f1063a;
    private static boolean f1064b;

    static void m2729a(PopupWindow popupWindow, int i) {
        if (!f1064b) {
            try {
                f1063a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1063a.setAccessible(true);
            } catch (Exception e) {
            }
            f1064b = true;
        }
        if (f1063a != null) {
            try {
                f1063a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
