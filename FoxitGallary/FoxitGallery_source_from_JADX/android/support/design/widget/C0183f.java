package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.C0179g.C0144a;
import android.support.v4.p016k.ah;

/* renamed from: android.support.design.widget.f */
class C0183f extends C0180e {
    private boolean f400m;

    /* renamed from: android.support.design.widget.f.1 */
    class C01811 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean f393a;
        final /* synthetic */ C0144a f394b;
        final /* synthetic */ C0183f f395c;
        private boolean f396d;

        C01811(C0183f c0183f, boolean z, C0144a c0144a) {
            this.f395c = c0183f;
            this.f393a = z;
            this.f394b = c0144a;
        }

        public void onAnimationCancel(Animator animator) {
            this.f395c.f400m = false;
            this.f396d = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.f395c.f400m = false;
            if (!this.f396d) {
                this.f395c.k.m521a(8, this.f393a);
                if (this.f394b != null) {
                    this.f394b.m495b();
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f395c.f400m = true;
            this.f396d = false;
            this.f395c.k.m521a(0, this.f393a);
        }
    }

    /* renamed from: android.support.design.widget.f.2 */
    class C01822 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean f397a;
        final /* synthetic */ C0144a f398b;
        final /* synthetic */ C0183f f399c;

        C01822(C0183f c0183f, boolean z, C0144a c0144a) {
            this.f399c = c0183f;
            this.f397a = z;
            this.f398b = c0144a;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f398b != null) {
                this.f398b.m494a();
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f399c.k.m521a(0, this.f397a);
        }
    }

    C0183f(C0150z c0150z, C0148m c0148m) {
        super(c0150z, c0148m);
    }

    private void m668c(float f) {
        if (this.a != null) {
            this.a.m693a(-f);
        }
        if (this.d != null) {
            this.d.m626a(-f);
        }
    }

    void m669a(C0144a c0144a, boolean z) {
        if (this.f400m || this.k.getVisibility() != 0) {
            if (c0144a != null) {
                c0144a.m495b();
            }
        } else if (!ah.m1901D(this.k) || this.k.isInEditMode()) {
            this.k.m521a(8, z);
            if (c0144a != null) {
                c0144a.m495b();
            }
        } else {
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0170a.f351c).setListener(new C01811(this, z, c0144a));
        }
    }

    void m670b(C0144a c0144a, boolean z) {
        if (!this.f400m && this.k.getVisibility() == 0) {
            return;
        }
        if (!ah.m1901D(this.k) || this.k.isInEditMode()) {
            this.k.m521a(0, z);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            if (c0144a != null) {
                c0144a.m494a();
                return;
            }
            return;
        }
        this.k.animate().cancel();
        if (this.k.getVisibility() != 0) {
            this.k.setAlpha(0.0f);
            this.k.setScaleY(0.0f);
            this.k.setScaleX(0.0f);
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0170a.f352d).setListener(new C01822(this, z, c0144a));
    }

    boolean m671d() {
        return true;
    }

    void m672e() {
        m668c(this.k.getRotation());
    }
}
