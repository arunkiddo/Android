package android.support.v4.p016k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.k.ba */
class ba {

    /* renamed from: android.support.v4.k.ba.1 */
    static class C05091 extends AnimatorListenerAdapter {
        final /* synthetic */ bd f835a;
        final /* synthetic */ View f836b;

        C05091(bd bdVar, View view) {
            this.f835a = bdVar;
            this.f836b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f835a.m538c(this.f836b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f835a.m537b(this.f836b);
        }

        public void onAnimationStart(Animator animator) {
            this.f835a.m536a(this.f836b);
        }
    }

    public static long m2233a(View view) {
        return view.animate().getDuration();
    }

    public static void m2234a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m2235a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m2236a(View view, bd bdVar) {
        if (bdVar != null) {
            view.animate().setListener(new C05091(bdVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public static void m2237a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m2238b(View view) {
        view.animate().cancel();
    }

    public static void m2239b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m2240b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m2241c(View view) {
        view.animate().start();
    }

    public static void m2242c(View view, float f) {
        view.animate().translationY(f);
    }
}
