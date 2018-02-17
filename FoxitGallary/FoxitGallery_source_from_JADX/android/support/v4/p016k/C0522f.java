package android.support.v4.p016k;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* renamed from: android.support.v4.k.f */
public final class C0522f {
    static final C0519a f847a;

    /* renamed from: android.support.v4.k.f.a */
    interface C0519a {
        int m2284a(int i, int i2);

        void m2285a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);
    }

    /* renamed from: android.support.v4.k.f.b */
    static class C0520b implements C0519a {
        C0520b() {
        }

        public int m2286a(int i, int i2) {
            return -8388609 & i;
        }

        public void m2287a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    /* renamed from: android.support.v4.k.f.c */
    static class C0521c implements C0519a {
        C0521c() {
        }

        public int m2288a(int i, int i2) {
            return C0523g.m2292a(i, i2);
        }

        public void m2289a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            C0523g.m2293a(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f847a = new C0521c();
        } else {
            f847a = new C0520b();
        }
    }

    public static int m2290a(int i, int i2) {
        return f847a.m2284a(i, i2);
    }

    public static void m2291a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f847a.m2285a(i, i2, i3, rect, rect2, i4);
    }
}
