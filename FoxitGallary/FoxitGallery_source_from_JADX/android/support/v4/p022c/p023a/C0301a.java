package android.support.v4.p022c.p023a;

import android.content.res.Resources;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.c.a.a */
public final class C0301a {
    private static final C0297a f669a;

    /* renamed from: android.support.v4.c.a.a.a */
    private interface C0297a {
        int m1161a(Resources resources);

        int m1162b(Resources resources);

        int m1163c(Resources resources);
    }

    /* renamed from: android.support.v4.c.a.a.b */
    private static class C0298b implements C0297a {
        private C0298b() {
        }

        public int m1164a(Resources resources) {
            return C0302b.m1173a(resources);
        }

        public int m1165b(Resources resources) {
            return C0302b.m1174b(resources);
        }

        public int m1166c(Resources resources) {
            return C0302b.m1175c(resources);
        }
    }

    /* renamed from: android.support.v4.c.a.a.c */
    private static class C0299c extends C0298b {
        private C0299c() {
            super();
        }

        public int m1167a(Resources resources) {
            return C0303c.m1176a(resources);
        }

        public int m1168b(Resources resources) {
            return C0303c.m1177b(resources);
        }

        public int m1169c(Resources resources) {
            return C0303c.m1178c(resources);
        }
    }

    /* renamed from: android.support.v4.c.a.a.d */
    private static class C0300d extends C0299c {
        private C0300d() {
            super();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f669a = new C0300d();
        } else if (i >= 13) {
            f669a = new C0299c();
        } else {
            f669a = new C0298b();
        }
    }

    public static int m1170a(Resources resources) {
        return f669a.m1161a(resources);
    }

    public static int m1171b(Resources resources) {
        return f669a.m1162b(resources);
    }

    public static int m1172c(Resources resources) {
        return f669a.m1163c(resources);
    }
}
