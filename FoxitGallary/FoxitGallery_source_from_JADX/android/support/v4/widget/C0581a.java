package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.ah;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: android.support.v4.widget.a */
public abstract class C0581a implements OnTouchListener {
    private static final int f952r;
    private final C0579a f953a;
    private final Interpolator f954b;
    private final View f955c;
    private Runnable f956d;
    private float[] f957e;
    private float[] f958f;
    private int f959g;
    private int f960h;
    private float[] f961i;
    private float[] f962j;
    private float[] f963k;
    private boolean f964l;
    private boolean f965m;
    private boolean f966n;
    private boolean f967o;
    private boolean f968p;
    private boolean f969q;

    /* renamed from: android.support.v4.widget.a.a */
    private static class C0579a {
        private int f940a;
        private int f941b;
        private float f942c;
        private float f943d;
        private long f944e;
        private long f945f;
        private int f946g;
        private int f947h;
        private long f948i;
        private float f949j;
        private int f950k;

        public C0579a() {
            this.f944e = Long.MIN_VALUE;
            this.f948i = -1;
            this.f945f = 0;
            this.f946g = 0;
            this.f947h = 0;
        }

        private float m2489a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        private float m2490a(long j) {
            if (j < this.f944e) {
                return 0.0f;
            }
            if (this.f948i < 0 || j < this.f948i) {
                return C0581a.m2509b(((float) (j - this.f944e)) / ((float) this.f940a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f948i;
            return (C0581a.m2509b(((float) j2) / ((float) this.f950k), 0.0f, 1.0f) * this.f949j) + (1.0f - this.f949j);
        }

        public void m2491a() {
            this.f944e = AnimationUtils.currentAnimationTimeMillis();
            this.f948i = -1;
            this.f945f = this.f944e;
            this.f949j = 0.5f;
            this.f946g = 0;
            this.f947h = 0;
        }

        public void m2492a(float f, float f2) {
            this.f942c = f;
            this.f943d = f2;
        }

        public void m2493a(int i) {
            this.f940a = i;
        }

        public void m2494b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f950k = C0581a.m2510b((int) (currentAnimationTimeMillis - this.f944e), 0, this.f941b);
            this.f949j = m2490a(currentAnimationTimeMillis);
            this.f948i = currentAnimationTimeMillis;
        }

        public void m2495b(int i) {
            this.f941b = i;
        }

        public boolean m2496c() {
            return this.f948i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f948i + ((long) this.f950k);
        }

        public void m2497d() {
            if (this.f945f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2489a(m2490a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f945f;
            this.f945f = currentAnimationTimeMillis;
            this.f946g = (int) ((((float) j) * a) * this.f942c);
            this.f947h = (int) ((((float) j) * a) * this.f943d);
        }

        public int m2498e() {
            return (int) (this.f942c / Math.abs(this.f942c));
        }

        public int m2499f() {
            return (int) (this.f943d / Math.abs(this.f943d));
        }

        public int m2500g() {
            return this.f946g;
        }

        public int m2501h() {
            return this.f947h;
        }
    }

    /* renamed from: android.support.v4.widget.a.b */
    private class C0580b implements Runnable {
        final /* synthetic */ C0581a f951a;

        private C0580b(C0581a c0581a) {
            this.f951a = c0581a;
        }

        public void run() {
            if (this.f951a.f967o) {
                if (this.f951a.f965m) {
                    this.f951a.f965m = false;
                    this.f951a.f953a.m2491a();
                }
                C0579a c = this.f951a.f953a;
                if (c.m2496c() || !this.f951a.m2506a()) {
                    this.f951a.f967o = false;
                    return;
                }
                if (this.f951a.f966n) {
                    this.f951a.f966n = false;
                    this.f951a.m2517d();
                }
                c.m2497d();
                this.f951a.m2526a(c.m2500g(), c.m2501h());
                ah.m1917a(this.f951a.f955c, (Runnable) this);
            }
        }
    }

    static {
        f952r = ViewConfiguration.getTapTimeout();
    }

    public C0581a(View view) {
        this.f953a = new C0579a();
        this.f954b = new AccelerateInterpolator();
        this.f957e = new float[]{0.0f, 0.0f};
        this.f958f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f961i = new float[]{0.0f, 0.0f};
        this.f962j = new float[]{0.0f, 0.0f};
        this.f963k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f955c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2523a((float) i, (float) i);
        m2527b((float) i2, (float) i2);
        m2524a(1);
        m2533e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2531d(0.2f, 0.2f);
        m2529c(1.0f, 1.0f);
        m2528b(f952r);
        m2530c(500);
        m2532d(500);
    }

    private float m2503a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0581a.m2509b(f * f2, 0.0f, f3);
        b = m2520f(f2 - f4, b) - m2520f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f954b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f954b.getInterpolation(b);
        }
        return C0581a.m2509b(f5, -1.0f, 1.0f);
    }

    private float m2504a(int i, float f, float f2, float f3) {
        float a = m2503a(this.f957e[i], f2, this.f958f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f961i[i];
        float f5 = this.f962j[i];
        float f6 = this.f963k[i];
        f4 *= f3;
        return a > 0.0f ? C0581a.m2509b(a * f4, f5, f6) : -C0581a.m2509b((-a) * f4, f5, f6);
    }

    private boolean m2506a() {
        C0579a c0579a = this.f953a;
        int f = c0579a.m2499f();
        int e = c0579a.m2498e();
        return (f != 0 && m2535f(f)) || (e != 0 && m2534e(e));
    }

    private static float m2509b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private static int m2510b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void m2511b() {
        if (this.f956d == null) {
            this.f956d = new C0580b();
        }
        this.f967o = true;
        this.f965m = true;
        if (this.f964l || this.f960h <= 0) {
            this.f956d.run();
        } else {
            ah.m1918a(this.f955c, this.f956d, (long) this.f960h);
        }
        this.f964l = true;
    }

    private void m2515c() {
        if (this.f965m) {
            this.f967o = false;
        } else {
            this.f953a.m2494b();
        }
    }

    private void m2517d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f955c.onTouchEvent(obtain);
        obtain.recycle();
    }

    private float m2520f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f959g) {
            case C1373c.View_android_theme /*0*/:
            case C1373c.View_android_focusable /*1*/:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.f967o && this.f959g == 1) ? 1.0f : 0.0f : 0.0f;
            case C1373c.View_paddingStart /*2*/:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public C0581a m2523a(float f, float f2) {
        this.f963k[0] = f / 1000.0f;
        this.f963k[1] = f2 / 1000.0f;
        return this;
    }

    public C0581a m2524a(int i) {
        this.f959g = i;
        return this;
    }

    public C0581a m2525a(boolean z) {
        if (this.f968p && !z) {
            m2515c();
        }
        this.f968p = z;
        return this;
    }

    public abstract void m2526a(int i, int i2);

    public C0581a m2527b(float f, float f2) {
        this.f962j[0] = f / 1000.0f;
        this.f962j[1] = f2 / 1000.0f;
        return this;
    }

    public C0581a m2528b(int i) {
        this.f960h = i;
        return this;
    }

    public C0581a m2529c(float f, float f2) {
        this.f961i[0] = f / 1000.0f;
        this.f961i[1] = f2 / 1000.0f;
        return this;
    }

    public C0581a m2530c(int i) {
        this.f953a.m2493a(i);
        return this;
    }

    public C0581a m2531d(float f, float f2) {
        this.f957e[0] = f;
        this.f957e[1] = f2;
        return this;
    }

    public C0581a m2532d(int i) {
        this.f953a.m2495b(i);
        return this;
    }

    public C0581a m2533e(float f, float f2) {
        this.f958f[0] = f;
        this.f958f[1] = f2;
        return this;
    }

    public abstract boolean m2534e(int i);

    public abstract boolean m2535f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f968p) {
            return false;
        }
        switch (C0560t.m2392a(motionEvent)) {
            case C1373c.View_android_theme /*0*/:
                this.f966n = true;
                this.f964l = false;
                break;
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                m2515c();
                break;
            case C1373c.View_paddingStart /*2*/:
                break;
        }
        this.f953a.m2492a(m2504a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f955c.getWidth()), m2504a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f955c.getHeight()));
        if (!this.f967o && m2506a()) {
            m2511b();
        }
        if (!(this.f969q && this.f967o)) {
            z = false;
        }
        return z;
    }
}
