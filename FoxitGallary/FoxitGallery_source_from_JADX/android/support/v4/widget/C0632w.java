package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: android.support.v4.widget.w */
public final class C0632w {
    Object f1068a;
    C0628a f1069b;

    /* renamed from: android.support.v4.widget.w.a */
    interface C0628a {
        Object m2733a(Context context, Interpolator interpolator);

        void m2734a(Object obj, int i, int i2, int i3, int i4);

        void m2735a(Object obj, int i, int i2, int i3, int i4, int i5);

        void m2736a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void m2737a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean m2738a(Object obj);

        boolean m2739a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        int m2740b(Object obj);

        int m2741c(Object obj);

        float m2742d(Object obj);

        boolean m2743e(Object obj);

        void m2744f(Object obj);

        int m2745g(Object obj);

        int m2746h(Object obj);
    }

    /* renamed from: android.support.v4.widget.w.b */
    static class C0629b implements C0628a {
        C0629b() {
        }

        public Object m2747a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public void m2748a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void m2749a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public void m2750a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void m2751a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public boolean m2752a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public boolean m2753a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }

        public int m2754b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int m2755c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public float m2756d(Object obj) {
            return 0.0f;
        }

        public boolean m2757e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public void m2758f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public int m2759g(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int m2760h(Object obj) {
            return ((Scroller) obj).getFinalY();
        }
    }

    /* renamed from: android.support.v4.widget.w.c */
    static class C0630c implements C0628a {
        C0630c() {
        }

        public Object m2761a(Context context, Interpolator interpolator) {
            return C0633x.m2791a(context, interpolator);
        }

        public void m2762a(Object obj, int i, int i2, int i3, int i4) {
            C0633x.m2792a(obj, i, i2, i3, i4);
        }

        public void m2763a(Object obj, int i, int i2, int i3, int i4, int i5) {
            C0633x.m2793a(obj, i, i2, i3, i4, i5);
        }

        public void m2764a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            C0633x.m2794a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void m2765a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            C0633x.m2795a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public boolean m2766a(Object obj) {
            return C0633x.m2796a(obj);
        }

        public boolean m2767a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return C0633x.m2797a(obj, i, i2, i3, i4, i5, i6);
        }

        public int m2768b(Object obj) {
            return C0633x.m2798b(obj);
        }

        public int m2769c(Object obj) {
            return C0633x.m2799c(obj);
        }

        public float m2770d(Object obj) {
            return 0.0f;
        }

        public boolean m2771e(Object obj) {
            return C0633x.m2800d(obj);
        }

        public void m2772f(Object obj) {
            C0633x.m2801e(obj);
        }

        public int m2773g(Object obj) {
            return C0633x.m2802f(obj);
        }

        public int m2774h(Object obj) {
            return C0633x.m2803g(obj);
        }
    }

    /* renamed from: android.support.v4.widget.w.d */
    static class C0631d extends C0630c {
        C0631d() {
        }

        public float m2775d(Object obj) {
            return C0634y.m2804a(obj);
        }
    }

    private C0632w(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1069b = new C0631d();
        } else if (i >= 9) {
            this.f1069b = new C0630c();
        } else {
            this.f1069b = new C0629b();
        }
        this.f1068a = this.f1069b.m2733a(context, interpolator);
    }

    public static C0632w m2776a(Context context) {
        return C0632w.m2777a(context, null);
    }

    public static C0632w m2777a(Context context, Interpolator interpolator) {
        return new C0632w(VERSION.SDK_INT, context, interpolator);
    }

    public void m2778a(int i, int i2, int i3, int i4) {
        this.f1069b.m2734a(this.f1068a, i, i2, i3, i4);
    }

    public void m2779a(int i, int i2, int i3, int i4, int i5) {
        this.f1069b.m2735a(this.f1068a, i, i2, i3, i4, i5);
    }

    public void m2780a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1069b.m2736a(this.f1068a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2781a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1069b.m2737a(this.f1068a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m2782a() {
        return this.f1069b.m2738a(this.f1068a);
    }

    public boolean m2783a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1069b.m2739a(this.f1068a, i, i2, i3, i4, i5, i6);
    }

    public int m2784b() {
        return this.f1069b.m2740b(this.f1068a);
    }

    public int m2785c() {
        return this.f1069b.m2741c(this.f1068a);
    }

    public int m2786d() {
        return this.f1069b.m2745g(this.f1068a);
    }

    public int m2787e() {
        return this.f1069b.m2746h(this.f1068a);
    }

    public float m2788f() {
        return this.f1069b.m2742d(this.f1068a);
    }

    public boolean m2789g() {
        return this.f1069b.m2743e(this.f1068a);
    }

    public void m2790h() {
        this.f1069b.m2744f(this.f1068a);
    }
}
