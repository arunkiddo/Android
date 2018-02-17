package android.support.design.widget;

import android.support.v4.p016k.p032b.C0506a;
import android.support.v4.p016k.p032b.C0507b;
import android.support.v4.p016k.p032b.C0508c;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: android.support.design.widget.a */
class C0170a {
    static final Interpolator f349a;
    static final Interpolator f350b;
    static final Interpolator f351c;
    static final Interpolator f352d;
    static final Interpolator f353e;

    /* renamed from: android.support.design.widget.a.a */
    static class C0169a implements AnimationListener {
        C0169a() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static {
        f349a = new LinearInterpolator();
        f350b = new C0507b();
        f351c = new C0506a();
        f352d = new C0508c();
        f353e = new DecelerateInterpolator();
    }

    static float m623a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int m624a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
