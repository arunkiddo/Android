package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.widget.i */
public final class C0604i {
    private static final C0600c f1015b;
    private Object f1016a;

    /* renamed from: android.support.v4.widget.i.c */
    interface C0600c {
        Object m2609a(Context context);

        void m2610a(Object obj, int i, int i2);

        boolean m2611a(Object obj);

        boolean m2612a(Object obj, float f);

        boolean m2613a(Object obj, float f, float f2);

        boolean m2614a(Object obj, int i);

        boolean m2615a(Object obj, Canvas canvas);

        void m2616b(Object obj);

        boolean m2617c(Object obj);
    }

    /* renamed from: android.support.v4.widget.i.a */
    static class C0601a implements C0600c {
        C0601a() {
        }

        public Object m2618a(Context context) {
            return null;
        }

        public void m2619a(Object obj, int i, int i2) {
        }

        public boolean m2620a(Object obj) {
            return true;
        }

        public boolean m2621a(Object obj, float f) {
            return false;
        }

        public boolean m2622a(Object obj, float f, float f2) {
            return false;
        }

        public boolean m2623a(Object obj, int i) {
            return false;
        }

        public boolean m2624a(Object obj, Canvas canvas) {
            return false;
        }

        public void m2625b(Object obj) {
        }

        public boolean m2626c(Object obj) {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.i.b */
    static class C0602b implements C0600c {
        C0602b() {
        }

        public Object m2627a(Context context) {
            return C0605j.m2645a(context);
        }

        public void m2628a(Object obj, int i, int i2) {
            C0605j.m2646a(obj, i, i2);
        }

        public boolean m2629a(Object obj) {
            return C0605j.m2647a(obj);
        }

        public boolean m2630a(Object obj, float f) {
            return C0605j.m2648a(obj, f);
        }

        public boolean m2631a(Object obj, float f, float f2) {
            return C0605j.m2648a(obj, f);
        }

        public boolean m2632a(Object obj, int i) {
            return C0605j.m2649a(obj, i);
        }

        public boolean m2633a(Object obj, Canvas canvas) {
            return C0605j.m2650a(obj, canvas);
        }

        public void m2634b(Object obj) {
            C0605j.m2651b(obj);
        }

        public boolean m2635c(Object obj) {
            return C0605j.m2652c(obj);
        }
    }

    /* renamed from: android.support.v4.widget.i.d */
    static class C0603d extends C0602b {
        C0603d() {
        }

        public boolean m2636a(Object obj, float f, float f2) {
            return C0606k.m2653a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1015b = new C0603d();
        } else if (VERSION.SDK_INT >= 14) {
            f1015b = new C0602b();
        } else {
            f1015b = new C0601a();
        }
    }

    public C0604i(Context context) {
        this.f1016a = f1015b.m2609a(context);
    }

    public void m2637a(int i, int i2) {
        f1015b.m2610a(this.f1016a, i, i2);
    }

    public boolean m2638a() {
        return f1015b.m2611a(this.f1016a);
    }

    @Deprecated
    public boolean m2639a(float f) {
        return f1015b.m2612a(this.f1016a, f);
    }

    public boolean m2640a(float f, float f2) {
        return f1015b.m2613a(this.f1016a, f, f2);
    }

    public boolean m2641a(int i) {
        return f1015b.m2614a(this.f1016a, i);
    }

    public boolean m2642a(Canvas canvas) {
        return f1015b.m2615a(this.f1016a, canvas);
    }

    public void m2643b() {
        f1015b.m2616b(this.f1016a);
    }

    public boolean m2644c() {
        return f1015b.m2617c(this.f1016a);
    }
}
