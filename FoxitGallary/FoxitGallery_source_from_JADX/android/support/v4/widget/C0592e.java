package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.e */
class C0592e {
    private static Field f1001a;
    private static boolean f1002b;

    static Drawable m2590a(CompoundButton compoundButton) {
        if (!f1002b) {
            try {
                f1001a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1001a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f1002b = true;
        }
        if (f1001a != null) {
            try {
                return (Drawable) f1001a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f1001a = null;
            }
        }
        return null;
    }

    static void m2591a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof ac) {
            ((ac) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m2592a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof ac) {
            ((ac) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
