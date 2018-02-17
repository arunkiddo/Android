package android.support.v4.p016k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.v4.k.bb */
class bb {

    /* renamed from: android.support.v4.k.bb.1 */
    static class C05101 extends AnimatorListenerAdapter {
        final /* synthetic */ bd f837a;
        final /* synthetic */ View f838b;

        C05101(bd bdVar, View view) {
            this.f837a = bdVar;
            this.f838b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f837a.m538c(this.f838b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f837a.m537b(this.f838b);
        }

        public void onAnimationStart(Animator animator) {
            this.f837a.m536a(this.f838b);
        }
    }

    public static void m2243a(View view, bd bdVar) {
        if (bdVar != null) {
            view.animate().setListener(new C05101(bdVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
