package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.C0202q.C0201c;
import android.support.design.widget.C0202q.C0201c.C0197b;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.s */
class C0206s extends C0201c {
    final ValueAnimator f459a;

    /* renamed from: android.support.design.widget.s.1 */
    class C02051 implements AnimatorUpdateListener {
        final /* synthetic */ C0197b f457a;
        final /* synthetic */ C0206s f458b;

        C02051(C0206s c0206s, C0197b c0197b) {
            this.f458b = c0206s;
            this.f457a = c0197b;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f457a.m727a();
        }
    }

    C0206s() {
        this.f459a = new ValueAnimator();
    }

    public void m766a() {
        this.f459a.start();
    }

    public void m767a(float f, float f2) {
        this.f459a.setFloatValues(new float[]{f, f2});
    }

    public void m768a(int i, int i2) {
        this.f459a.setIntValues(new int[]{i, i2});
    }

    public void m769a(long j) {
        this.f459a.setDuration(j);
    }

    public void m770a(C0197b c0197b) {
        this.f459a.addUpdateListener(new C02051(this, c0197b));
    }

    public void m771a(Interpolator interpolator) {
        this.f459a.setInterpolator(interpolator);
    }

    public boolean m772b() {
        return this.f459a.isRunning();
    }

    public int m773c() {
        return ((Integer) this.f459a.getAnimatedValue()).intValue();
    }

    public float m774d() {
        return ((Float) this.f459a.getAnimatedValue()).floatValue();
    }

    public void m775e() {
        this.f459a.cancel();
    }
}
