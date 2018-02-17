package android.support.v4.p016k;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* renamed from: android.support.v4.k.bc */
class bc {

    /* renamed from: android.support.v4.k.bc.1 */
    static class C05111 implements AnimatorUpdateListener {
        final /* synthetic */ bf f839a;
        final /* synthetic */ View f840b;

        C05111(bf bfVar, View view) {
            this.f839a = bfVar;
            this.f840b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f839a.m2245a(this.f840b);
        }
    }

    public static void m2244a(View view, bf bfVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (bfVar != null) {
            animatorUpdateListener = new C05111(bfVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
