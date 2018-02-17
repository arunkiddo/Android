package android.support.v4.p029i;

import android.os.Build.VERSION;
import java.util.Locale;

/* renamed from: android.support.v4.i.a */
public final class C0369a {
    private static final C0365a f702a;

    /* renamed from: android.support.v4.i.a.a */
    interface C0365a {
        String m1370a(Locale locale);
    }

    /* renamed from: android.support.v4.i.a.b */
    static class C0366b implements C0365a {
        C0366b() {
        }

        public String m1371a(Locale locale) {
            return null;
        }
    }

    /* renamed from: android.support.v4.i.a.c */
    static class C0367c implements C0365a {
        C0367c() {
        }

        public String m1372a(Locale locale) {
            return C0371c.m1377a(locale);
        }
    }

    /* renamed from: android.support.v4.i.a.d */
    static class C0368d implements C0365a {
        C0368d() {
        }

        public String m1373a(Locale locale) {
            return C0370b.m1375a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f702a = new C0368d();
        } else if (i >= 14) {
            f702a = new C0367c();
        } else {
            f702a = new C0366b();
        }
    }

    public static String m1374a(Locale locale) {
        return f702a.m1370a(locale);
    }
}
