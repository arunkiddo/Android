package android.support.v4.p029i;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.i.c */
class C0371c {
    private static Method f704a;
    private static Method f705b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f704a = cls.getMethod("getScript", new Class[]{String.class});
                f705b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f704a = null;
            f705b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    private static String m1376a(String str) {
        try {
            if (f704a != null) {
                return (String) f704a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String m1377a(Locale locale) {
        String b = C0371c.m1378b(locale);
        return b != null ? C0371c.m1376a(b) : null;
    }

    private static String m1378b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f705b != null) {
                return (String) f705b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
