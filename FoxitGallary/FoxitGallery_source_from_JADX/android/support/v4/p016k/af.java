package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.k.af */
public final class af {
    static final C0443c f778a;

    /* renamed from: android.support.v4.k.af.c */
    interface C0443c {
        float m1688a(VelocityTracker velocityTracker, int i);

        float m1689b(VelocityTracker velocityTracker, int i);
    }

    /* renamed from: android.support.v4.k.af.a */
    static class C0444a implements C0443c {
        C0444a() {
        }

        public float m1690a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float m1691b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* renamed from: android.support.v4.k.af.b */
    static class C0445b implements C0443c {
        C0445b() {
        }

        public float m1692a(VelocityTracker velocityTracker, int i) {
            return ag.m1696a(velocityTracker, i);
        }

        public float m1693b(VelocityTracker velocityTracker, int i) {
            return ag.m1697b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f778a = new C0445b();
        } else {
            f778a = new C0444a();
        }
    }

    public static float m1694a(VelocityTracker velocityTracker, int i) {
        return f778a.m1688a(velocityTracker, i);
    }

    public static float m1695b(VelocityTracker velocityTracker, int i) {
        return f778a.m1689b(velocityTracker, i);
    }
}
