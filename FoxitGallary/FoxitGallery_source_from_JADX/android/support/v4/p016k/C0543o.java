package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v4.k.o */
public final class C0543o {
    static final C0540a f853a;

    /* renamed from: android.support.v4.k.o.a */
    interface C0540a {
        int m2326a(MarginLayoutParams marginLayoutParams);

        int m2327b(MarginLayoutParams marginLayoutParams);
    }

    /* renamed from: android.support.v4.k.o.b */
    static class C0541b implements C0540a {
        C0541b() {
        }

        public int m2328a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int m2329b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    /* renamed from: android.support.v4.k.o.c */
    static class C0542c implements C0540a {
        C0542c() {
        }

        public int m2330a(MarginLayoutParams marginLayoutParams) {
            return C0544p.m2334a(marginLayoutParams);
        }

        public int m2331b(MarginLayoutParams marginLayoutParams) {
            return C0544p.m2335b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f853a = new C0542c();
        } else {
            f853a = new C0541b();
        }
    }

    public static int m2332a(MarginLayoutParams marginLayoutParams) {
        return f853a.m2326a(marginLayoutParams);
    }

    public static int m2333b(MarginLayoutParams marginLayoutParams) {
        return f853a.m2327b(marginLayoutParams);
    }
}
