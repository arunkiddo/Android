package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.r */
class C0623r {
    private static Field f1062a;

    static {
        try {
            f1062a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1062a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m2726a(PopupWindow popupWindow, boolean z) {
        if (f1062a != null) {
            try {
                f1062a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
