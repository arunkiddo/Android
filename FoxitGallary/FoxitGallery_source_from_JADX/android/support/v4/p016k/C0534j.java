package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.k.j */
public final class C0534j {
    static final C0530a f849a;

    /* renamed from: android.support.v4.k.j.a */
    interface C0530a {
        C0288n m2313a(LayoutInflater layoutInflater);

        void m2314a(LayoutInflater layoutInflater, C0288n c0288n);
    }

    /* renamed from: android.support.v4.k.j.b */
    static class C0531b implements C0530a {
        C0531b() {
        }

        public C0288n m2315a(LayoutInflater layoutInflater) {
            return C0536k.m2321a(layoutInflater);
        }

        public void m2316a(LayoutInflater layoutInflater, C0288n c0288n) {
            C0536k.m2322a(layoutInflater, c0288n);
        }
    }

    /* renamed from: android.support.v4.k.j.c */
    static class C0532c extends C0531b {
        C0532c() {
        }

        public void m2317a(LayoutInflater layoutInflater, C0288n c0288n) {
            C0538l.m2323a(layoutInflater, c0288n);
        }
    }

    /* renamed from: android.support.v4.k.j.d */
    static class C0533d extends C0532c {
        C0533d() {
        }

        public void m2318a(LayoutInflater layoutInflater, C0288n c0288n) {
            C0539m.m2325a(layoutInflater, c0288n);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f849a = new C0533d();
        } else if (i >= 11) {
            f849a = new C0532c();
        } else {
            f849a = new C0531b();
        }
    }

    public static C0288n m2319a(LayoutInflater layoutInflater) {
        return f849a.m2313a(layoutInflater);
    }

    public static void m2320a(LayoutInflater layoutInflater, C0288n c0288n) {
        f849a.m2314a(layoutInflater, c0288n);
    }
}
