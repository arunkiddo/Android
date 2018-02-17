package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.support.design.C0110a.C0103a;
import android.support.design.widget.C0170a.C0169a;
import android.support.design.widget.C0179g.C0144a;
import android.support.v4.p014d.p015a.C0326a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* renamed from: android.support.design.widget.e */
class C0180e extends C0179g {
    C0189l f389a;
    private int f390m;
    private C0195o f391n;
    private boolean f392o;

    /* renamed from: android.support.design.widget.e.1 */
    class C01741 extends C0169a {
        final /* synthetic */ boolean f366a;
        final /* synthetic */ C0144a f367b;
        final /* synthetic */ C0180e f368c;

        C01741(C0180e c0180e, boolean z, C0144a c0144a) {
            this.f368c = c0180e;
            this.f366a = z;
            this.f367b = c0144a;
        }

        public void onAnimationEnd(Animation animation) {
            this.f368c.f392o = false;
            this.f368c.k.m521a(8, this.f366a);
            if (this.f367b != null) {
                this.f367b.m495b();
            }
        }

        public void onAnimationStart(Animation animation) {
            this.f368c.f392o = true;
        }
    }

    /* renamed from: android.support.design.widget.e.2 */
    class C01752 extends C0169a {
        final /* synthetic */ C0144a f369a;
        final /* synthetic */ C0180e f370b;

        C01752(C0180e c0180e, C0144a c0144a) {
            this.f370b = c0180e;
            this.f369a = c0144a;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f369a != null) {
                this.f369a.m494a();
            }
        }
    }

    /* renamed from: android.support.design.widget.e.a */
    private abstract class C0176a extends Animation {
        final /* synthetic */ C0180e f371a;
        private float f372b;
        private float f373c;

        private C0176a(C0180e c0180e) {
            this.f371a = c0180e;
        }

        protected abstract float m630a();

        protected void applyTransformation(float f, Transformation transformation) {
            this.f371a.f389a.m695b(this.f372b + (this.f373c * f));
        }

        public void reset() {
            super.reset();
            this.f372b = this.f371a.f389a.m692a();
            this.f373c = m630a() - this.f372b;
        }
    }

    /* renamed from: android.support.design.widget.e.b */
    private class C0177b extends C0176a {
        final /* synthetic */ C0180e f374b;

        private C0177b(C0180e c0180e) {
            this.f374b = c0180e;
            super(null);
        }

        protected float m631a() {
            return this.f374b.f + this.f374b.g;
        }
    }

    /* renamed from: android.support.design.widget.e.c */
    private class C0178c extends C0176a {
        final /* synthetic */ C0180e f375b;

        private C0178c(C0180e c0180e) {
            this.f375b = c0180e;
            super(null);
        }

        protected float m632a() {
            return this.f375b.f;
        }
    }

    C0180e(C0150z c0150z, C0148m c0148m) {
        super(c0150z, c0148m);
        this.f390m = c0150z.getResources().getInteger(17694720);
        this.f391n = new C0195o();
        this.f391n.m722a((View) c0150z);
        this.f391n.m724a(h, m653a(new C0177b()));
        this.f391n.m724a(i, m653a(new C0177b()));
        this.f391n.m724a(j, m653a(new C0178c()));
    }

    private Animation m653a(Animation animation) {
        animation.setInterpolator(C0170a.f350b);
        animation.setDuration((long) this.f390m);
        return animation;
    }

    private static ColorStateList m655b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{i, i, h};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    float m656a() {
        return this.f;
    }

    void m657a(float f) {
        if (this.f389a != null) {
            this.f389a.m694a(f, this.g + f);
            m650g();
        }
    }

    void m658a(int i) {
        if (this.c != null) {
            C0326a.m1262a(this.c, C0180e.m655b(i));
        }
    }

    void m659a(ColorStateList colorStateList) {
        if (this.b != null) {
            C0326a.m1262a(this.b, colorStateList);
        }
        if (this.d != null) {
            this.d.m627a(colorStateList);
        }
    }

    void m660a(Mode mode) {
        if (this.b != null) {
            C0326a.m1265a(this.b, mode);
        }
    }

    void m661a(Rect rect) {
        this.f389a.getPadding(rect);
    }

    void m662a(C0144a c0144a, boolean z) {
        if (!this.f392o && this.k.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0103a.design_fab_out);
            loadAnimation.setInterpolator(C0170a.f351c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new C01741(this, z, c0144a));
            this.k.startAnimation(loadAnimation);
        } else if (c0144a != null) {
            c0144a.m495b();
        }
    }

    void m663a(int[] iArr) {
        this.f391n.m723a(iArr);
    }

    void m664b() {
        this.f391n.m725b();
    }

    void m665b(C0144a c0144a, boolean z) {
        if (this.k.getVisibility() != 0 || this.f392o) {
            this.k.clearAnimation();
            this.k.m521a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0103a.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0170a.f352d);
            loadAnimation.setAnimationListener(new C01752(this, c0144a));
            this.k.startAnimation(loadAnimation);
        } else if (c0144a != null) {
            c0144a.m494a();
        }
    }

    void m666c() {
    }
}
