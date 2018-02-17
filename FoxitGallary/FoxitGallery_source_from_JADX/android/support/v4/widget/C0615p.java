package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p016k.p032b.C0507b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.p */
class C0615p extends Drawable implements Animatable {
    private static final Interpolator f1047b;
    private static final Interpolator f1048c;
    boolean f1049a;
    private final int[] f1050d;
    private final ArrayList<Animation> f1051e;
    private final C0614a f1052f;
    private float f1053g;
    private Resources f1054h;
    private View f1055i;
    private Animation f1056j;
    private float f1057k;
    private double f1058l;
    private double f1059m;
    private final Callback f1060n;

    /* renamed from: android.support.v4.widget.p.1 */
    class C06111 extends Animation {
        final /* synthetic */ C0614a f1018a;
        final /* synthetic */ C0615p f1019b;

        C06111(C0615p c0615p, C0614a c0614a) {
            this.f1019b = c0615p;
            this.f1018a = c0614a;
        }

        public void applyTransformation(float f, Transformation transformation) {
            if (this.f1019b.f1049a) {
                this.f1019b.m2702b(f, this.f1018a);
                return;
            }
            float a = this.f1019b.m2692a(this.f1018a);
            float g = this.f1018a.m2685g();
            float f2 = this.f1018a.m2684f();
            float k = this.f1018a.m2689k();
            this.f1019b.m2699a(f, this.f1018a);
            if (f <= 0.5f) {
                float f3 = 0.8f - a;
                this.f1018a.m2674b(f2 + (C0615p.f1048c.getInterpolation(f / 0.5f) * f3));
            }
            if (f > 0.5f) {
                this.f1018a.m2677c(((0.8f - a) * C0615p.f1048c.getInterpolation((f - 0.5f) / 0.5f)) + g);
            }
            this.f1018a.m2680d((0.25f * f) + k);
            this.f1019b.m2711c((216.0f * f) + (1080.0f * (this.f1019b.f1057k / 5.0f)));
        }
    }

    /* renamed from: android.support.v4.widget.p.2 */
    class C06122 implements AnimationListener {
        final /* synthetic */ C0614a f1020a;
        final /* synthetic */ C0615p f1021b;

        C06122(C0615p c0615p, C0614a c0614a) {
            this.f1021b = c0615p;
            this.f1020a = c0614a;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
            this.f1020a.m2690l();
            this.f1020a.m2673b();
            this.f1020a.m2674b(this.f1020a.m2687i());
            if (this.f1021b.f1049a) {
                this.f1021b.f1049a = false;
                animation.setDuration(1332);
                this.f1020a.m2671a(false);
                return;
            }
            this.f1021b.f1057k = (this.f1021b.f1057k + 1.0f) % 5.0f;
        }

        public void onAnimationStart(Animation animation) {
            this.f1021b.f1057k = 0.0f;
        }
    }

    /* renamed from: android.support.v4.widget.p.3 */
    class C06133 implements Callback {
        final /* synthetic */ C0615p f1022a;

        C06133(C0615p c0615p) {
            this.f1022a = c0615p;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f1022a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f1022a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f1022a.unscheduleSelf(runnable);
        }
    }

    /* renamed from: android.support.v4.widget.p.a */
    private static class C0614a {
        private final RectF f1023a;
        private final Paint f1024b;
        private final Paint f1025c;
        private final Callback f1026d;
        private float f1027e;
        private float f1028f;
        private float f1029g;
        private float f1030h;
        private float f1031i;
        private int[] f1032j;
        private int f1033k;
        private float f1034l;
        private float f1035m;
        private float f1036n;
        private boolean f1037o;
        private Path f1038p;
        private float f1039q;
        private double f1040r;
        private int f1041s;
        private int f1042t;
        private int f1043u;
        private final Paint f1044v;
        private int f1045w;
        private int f1046x;

        public C0614a(Callback callback) {
            this.f1023a = new RectF();
            this.f1024b = new Paint();
            this.f1025c = new Paint();
            this.f1027e = 0.0f;
            this.f1028f = 0.0f;
            this.f1029g = 0.0f;
            this.f1030h = 5.0f;
            this.f1031i = 2.5f;
            this.f1044v = new Paint(1);
            this.f1026d = callback;
            this.f1024b.setStrokeCap(Cap.SQUARE);
            this.f1024b.setAntiAlias(true);
            this.f1024b.setStyle(Style.STROKE);
            this.f1025c.setStyle(Style.FILL);
            this.f1025c.setAntiAlias(true);
        }

        private void m2660a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f1037o) {
                if (this.f1038p == null) {
                    this.f1038p = new Path();
                    this.f1038p.setFillType(FillType.EVEN_ODD);
                } else {
                    this.f1038p.reset();
                }
                float f3 = ((float) (((int) this.f1031i) / 2)) * this.f1039q;
                float cos = (float) ((this.f1040r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.f1040r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.f1038p.moveTo(0.0f, 0.0f);
                this.f1038p.lineTo(((float) this.f1041s) * this.f1039q, 0.0f);
                this.f1038p.lineTo((((float) this.f1041s) * this.f1039q) / 2.0f, ((float) this.f1042t) * this.f1039q);
                this.f1038p.offset(cos - f3, sin);
                this.f1038p.close();
                this.f1025c.setColor(this.f1046x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f1038p, this.f1025c);
            }
        }

        private int m2661n() {
            return (this.f1033k + 1) % this.f1032j.length;
        }

        private void m2662o() {
            this.f1026d.invalidateDrawable(null);
        }

        public int m2663a() {
            return this.f1032j[m2661n()];
        }

        public void m2664a(double d) {
            this.f1040r = d;
        }

        public void m2665a(float f) {
            this.f1030h = f;
            this.f1024b.setStrokeWidth(f);
            m2662o();
        }

        public void m2666a(float f, float f2) {
            this.f1041s = (int) f;
            this.f1042t = (int) f2;
        }

        public void m2667a(int i) {
            this.f1045w = i;
        }

        public void m2668a(int i, int i2) {
            float min = (float) Math.min(i, i2);
            min = (this.f1040r <= 0.0d || min < 0.0f) ? (float) Math.ceil((double) (this.f1030h / 2.0f)) : (float) (((double) (min / 2.0f)) - this.f1040r);
            this.f1031i = min;
        }

        public void m2669a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1023a;
            rectF.set(rect);
            rectF.inset(this.f1031i, this.f1031i);
            float f = (this.f1027e + this.f1029g) * 360.0f;
            float f2 = ((this.f1028f + this.f1029g) * 360.0f) - f;
            this.f1024b.setColor(this.f1046x);
            canvas.drawArc(rectF, f, f2, false, this.f1024b);
            m2660a(canvas, f, f2, rect);
            if (this.f1043u < 255) {
                this.f1044v.setColor(this.f1045w);
                this.f1044v.setAlpha(255 - this.f1043u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f1044v);
            }
        }

        public void m2670a(ColorFilter colorFilter) {
            this.f1024b.setColorFilter(colorFilter);
            m2662o();
        }

        public void m2671a(boolean z) {
            if (this.f1037o != z) {
                this.f1037o = z;
                m2662o();
            }
        }

        public void m2672a(int[] iArr) {
            this.f1032j = iArr;
            m2678c(0);
        }

        public void m2673b() {
            m2678c(m2661n());
        }

        public void m2674b(float f) {
            this.f1027e = f;
            m2662o();
        }

        public void m2675b(int i) {
            this.f1046x = i;
        }

        public int m2676c() {
            return this.f1043u;
        }

        public void m2677c(float f) {
            this.f1028f = f;
            m2662o();
        }

        public void m2678c(int i) {
            this.f1033k = i;
            this.f1046x = this.f1032j[this.f1033k];
        }

        public float m2679d() {
            return this.f1030h;
        }

        public void m2680d(float f) {
            this.f1029g = f;
            m2662o();
        }

        public void m2681d(int i) {
            this.f1043u = i;
        }

        public float m2682e() {
            return this.f1027e;
        }

        public void m2683e(float f) {
            if (f != this.f1039q) {
                this.f1039q = f;
                m2662o();
            }
        }

        public float m2684f() {
            return this.f1034l;
        }

        public float m2685g() {
            return this.f1035m;
        }

        public int m2686h() {
            return this.f1032j[this.f1033k];
        }

        public float m2687i() {
            return this.f1028f;
        }

        public double m2688j() {
            return this.f1040r;
        }

        public float m2689k() {
            return this.f1036n;
        }

        public void m2690l() {
            this.f1034l = this.f1027e;
            this.f1035m = this.f1028f;
            this.f1036n = this.f1029g;
        }

        public void m2691m() {
            this.f1034l = 0.0f;
            this.f1035m = 0.0f;
            this.f1036n = 0.0f;
            m2674b(0.0f);
            m2677c(0.0f);
            m2680d(0.0f);
        }
    }

    static {
        f1047b = new LinearInterpolator();
        f1048c = new C0507b();
    }

    public C0615p(Context context, View view) {
        this.f1050d = new int[]{-16777216};
        this.f1051e = new ArrayList();
        this.f1060n = new C06133(this);
        this.f1055i = view;
        this.f1054h = context.getResources();
        this.f1052f = new C0614a(this.f1060n);
        this.f1052f.m2672a(this.f1050d);
        m2706a(1);
        m2701b();
    }

    private float m2692a(C0614a c0614a) {
        return (float) Math.toRadians(((double) c0614a.m2679d()) / (6.283185307179586d * c0614a.m2688j()));
    }

    private int m2696a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    private void m2698a(double d, double d2, double d3, double d4, float f, float f2) {
        C0614a c0614a = this.f1052f;
        float f3 = this.f1054h.getDisplayMetrics().density;
        this.f1058l = ((double) f3) * d;
        this.f1059m = ((double) f3) * d2;
        c0614a.m2665a(((float) d4) * f3);
        c0614a.m2664a(((double) f3) * d3);
        c0614a.m2678c(0);
        c0614a.m2666a(f * f3, f3 * f2);
        c0614a.m2668a((int) this.f1058l, (int) this.f1059m);
    }

    private void m2699a(float f, C0614a c0614a) {
        if (f > 0.75f) {
            c0614a.m2675b(m2696a((f - 0.75f) / 0.25f, c0614a.m2686h(), c0614a.m2663a()));
        }
    }

    private void m2701b() {
        C0614a c0614a = this.f1052f;
        Animation c06111 = new C06111(this, c0614a);
        c06111.setRepeatCount(-1);
        c06111.setRepeatMode(1);
        c06111.setInterpolator(f1047b);
        c06111.setAnimationListener(new C06122(this, c0614a));
        this.f1056j = c06111;
    }

    private void m2702b(float f, C0614a c0614a) {
        m2699a(f, c0614a);
        float floor = (float) (Math.floor((double) (c0614a.m2689k() / 0.8f)) + 1.0d);
        float a = m2692a(c0614a);
        c0614a.m2674b((((c0614a.m2685g() - a) - c0614a.m2684f()) * f) + c0614a.m2684f());
        c0614a.m2677c(c0614a.m2685g());
        c0614a.m2680d(((floor - c0614a.m2689k()) * f) + c0614a.m2689k());
    }

    public void m2704a(float f) {
        this.f1052f.m2683e(f);
    }

    public void m2705a(float f, float f2) {
        this.f1052f.m2674b(f);
        this.f1052f.m2677c(f2);
    }

    public void m2706a(int i) {
        if (i == 0) {
            m2698a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m2698a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m2707a(boolean z) {
        this.f1052f.m2671a(z);
    }

    public void m2708a(int... iArr) {
        this.f1052f.m2672a(iArr);
        this.f1052f.m2678c(0);
    }

    public void m2709b(float f) {
        this.f1052f.m2680d(f);
    }

    public void m2710b(int i) {
        this.f1052f.m2667a(i);
    }

    void m2711c(float f) {
        this.f1053g = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f1053g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1052f.m2669a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public int getAlpha() {
        return this.f1052f.m2676c();
    }

    public int getIntrinsicHeight() {
        return (int) this.f1059m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f1058l;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f1051e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha(int i) {
        this.f1052f.m2681d(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1052f.m2670a(colorFilter);
    }

    public void start() {
        this.f1056j.reset();
        this.f1052f.m2690l();
        if (this.f1052f.m2687i() != this.f1052f.m2682e()) {
            this.f1049a = true;
            this.f1056j.setDuration(666);
            this.f1055i.startAnimation(this.f1056j);
            return;
        }
        this.f1052f.m2678c(0);
        this.f1052f.m2691m();
        this.f1056j.setDuration(1332);
        this.f1055i.startAnimation(this.f1056j);
    }

    public void stop() {
        this.f1055i.clearAnimation();
        m2711c(0.0f);
        this.f1052f.m2671a(false);
        this.f1052f.m2678c(0);
        this.f1052f.m2691m();
    }
}
