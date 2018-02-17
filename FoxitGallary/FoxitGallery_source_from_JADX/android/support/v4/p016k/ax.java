package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.k.ax */
public final class ax {
    static final C0482b f813a;

    /* renamed from: android.support.v4.k.ax.b */
    interface C0482b {
        void m2074a(ViewParent viewParent, View view);

        void m2075a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void m2076a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean m2077a(ViewParent viewParent, View view, float f, float f2);

        boolean m2078a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean m2079a(ViewParent viewParent, View view, View view2, int i);

        void m2080b(ViewParent viewParent, View view, View view2, int i);
    }

    /* renamed from: android.support.v4.k.ax.e */
    static class C0483e implements C0482b {
        C0483e() {
        }

        public void m2081a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0143z) {
                ((C0143z) viewParent).onStopNestedScroll(view);
            }
        }

        public void m2082a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0143z) {
                ((C0143z) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void m2083a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0143z) {
                ((C0143z) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean m2084a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof C0143z ? ((C0143z) viewParent).onNestedPreFling(view, f, f2) : false;
        }

        public boolean m2085a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof C0143z ? ((C0143z) viewParent).onNestedFling(view, f, f2, z) : false;
        }

        public boolean m2086a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof C0143z ? ((C0143z) viewParent).onStartNestedScroll(view, view2, i) : false;
        }

        public void m2087b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0143z) {
                ((C0143z) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    /* renamed from: android.support.v4.k.ax.a */
    static class C0484a extends C0483e {
        C0484a() {
        }
    }

    /* renamed from: android.support.v4.k.ax.c */
    static class C0485c extends C0484a {
        C0485c() {
        }
    }

    /* renamed from: android.support.v4.k.ax.d */
    static class C0486d extends C0485c {
        C0486d() {
        }

        public void m2088a(ViewParent viewParent, View view) {
            ay.m2102a(viewParent, view);
        }

        public void m2089a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ay.m2103a(viewParent, view, i, i2, i3, i4);
        }

        public void m2090a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ay.m2104a(viewParent, view, i, i2, iArr);
        }

        public boolean m2091a(ViewParent viewParent, View view, float f, float f2) {
            return ay.m2105a(viewParent, view, f, f2);
        }

        public boolean m2092a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ay.m2106a(viewParent, view, f, f2, z);
        }

        public boolean m2093a(ViewParent viewParent, View view, View view2, int i) {
            return ay.m2107a(viewParent, view, view2, i);
        }

        public void m2094b(ViewParent viewParent, View view, View view2, int i) {
            ay.m2108b(viewParent, view, view2, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f813a = new C0486d();
        } else if (i >= 19) {
            f813a = new C0485c();
        } else if (i >= 14) {
            f813a = new C0484a();
        } else {
            f813a = new C0483e();
        }
    }

    public static void m2095a(ViewParent viewParent, View view) {
        f813a.m2074a(viewParent, view);
    }

    public static void m2096a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f813a.m2075a(viewParent, view, i, i2, i3, i4);
    }

    public static void m2097a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f813a.m2076a(viewParent, view, i, i2, iArr);
    }

    public static boolean m2098a(ViewParent viewParent, View view, float f, float f2) {
        return f813a.m2077a(viewParent, view, f, f2);
    }

    public static boolean m2099a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f813a.m2078a(viewParent, view, f, f2, z);
    }

    public static boolean m2100a(ViewParent viewParent, View view, View view2, int i) {
        return f813a.m2079a(viewParent, view, view2, i);
    }

    public static void m2101b(ViewParent viewParent, View view, View view2, int i) {
        f813a.m2080b(viewParent, view, view2, i);
    }
}
