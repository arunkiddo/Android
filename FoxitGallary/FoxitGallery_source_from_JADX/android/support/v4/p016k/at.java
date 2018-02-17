package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.k.at */
public final class at {
    static final C0461e f790a;

    /* renamed from: android.support.v4.k.at.e */
    interface C0461e {
        int m2040a(ViewConfiguration viewConfiguration);

        boolean m2041b(ViewConfiguration viewConfiguration);
    }

    /* renamed from: android.support.v4.k.at.a */
    static class C0462a implements C0461e {
        C0462a() {
        }

        public int m2042a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean m2043b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* renamed from: android.support.v4.k.at.b */
    static class C0463b extends C0462a {
        C0463b() {
        }

        public int m2044a(ViewConfiguration viewConfiguration) {
            return au.m2049a(viewConfiguration);
        }
    }

    /* renamed from: android.support.v4.k.at.c */
    static class C0464c extends C0463b {
        C0464c() {
        }

        public boolean m2045b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* renamed from: android.support.v4.k.at.d */
    static class C0465d extends C0464c {
        C0465d() {
        }

        public boolean m2046b(ViewConfiguration viewConfiguration) {
            return av.m2050a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f790a = new C0465d();
        } else if (VERSION.SDK_INT >= 11) {
            f790a = new C0464c();
        } else if (VERSION.SDK_INT >= 8) {
            f790a = new C0463b();
        } else {
            f790a = new C0462a();
        }
    }

    public static int m2047a(ViewConfiguration viewConfiguration) {
        return f790a.m2040a(viewConfiguration);
    }

    public static boolean m2048b(ViewConfiguration viewConfiguration) {
        return f790a.m2041b(viewConfiguration);
    }
}
