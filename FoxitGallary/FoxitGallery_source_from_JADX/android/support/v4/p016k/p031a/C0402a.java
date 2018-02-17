package android.support.v4.p016k.p031a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.k.a.a */
public final class C0402a {
    private static final C0398d f761a;

    /* renamed from: android.support.v4.k.a.a.d */
    interface C0398d {
        int m1476a(AccessibilityEvent accessibilityEvent);

        void m1477a(AccessibilityEvent accessibilityEvent, int i);
    }

    /* renamed from: android.support.v4.k.a.a.c */
    static class C0399c implements C0398d {
        C0399c() {
        }

        public int m1478a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void m1479a(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    /* renamed from: android.support.v4.k.a.a.a */
    static class C0400a extends C0399c {
        C0400a() {
        }
    }

    /* renamed from: android.support.v4.k.a.a.b */
    static class C0401b extends C0400a {
        C0401b() {
        }

        public int m1480a(AccessibilityEvent accessibilityEvent) {
            return C0403b.m1485a(accessibilityEvent);
        }

        public void m1481a(AccessibilityEvent accessibilityEvent, int i) {
            C0403b.m1486a(accessibilityEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f761a = new C0401b();
        } else if (VERSION.SDK_INT >= 14) {
            f761a = new C0400a();
        } else {
            f761a = new C0399c();
        }
    }

    public static C0440k m1482a(AccessibilityEvent accessibilityEvent) {
        return new C0440k(accessibilityEvent);
    }

    public static void m1483a(AccessibilityEvent accessibilityEvent, int i) {
        f761a.m1477a(accessibilityEvent, i);
    }

    public static int m1484b(AccessibilityEvent accessibilityEvent) {
        return f761a.m1476a(accessibilityEvent);
    }
}
