package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.o */
final class C0195o {
    private final ArrayList<C0194a> f436a;
    private C0194a f437b;
    private Animation f438c;
    private WeakReference<View> f439d;
    private AnimationListener f440e;

    /* renamed from: android.support.design.widget.o.1 */
    class C01931 implements AnimationListener {
        final /* synthetic */ C0195o f433a;

        C01931(C0195o c0195o) {
            this.f433a = c0195o;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f433a.f438c == animation) {
                this.f433a.f438c = null;
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.o.a */
    static class C0194a {
        final int[] f434a;
        final Animation f435b;

        private C0194a(int[] iArr, Animation animation) {
            this.f434a = iArr;
            this.f435b = animation;
        }
    }

    C0195o() {
        this.f436a = new ArrayList();
        this.f437b = null;
        this.f438c = null;
        this.f440e = new C01931(this);
    }

    private void m718a(C0194a c0194a) {
        this.f438c = c0194a.f435b;
        View a = m721a();
        if (a != null) {
            a.startAnimation(this.f438c);
        }
    }

    private void m719c() {
        View a = m721a();
        int size = this.f436a.size();
        for (int i = 0; i < size; i++) {
            if (a.getAnimation() == ((C0194a) this.f436a.get(i)).f435b) {
                a.clearAnimation();
            }
        }
        this.f439d = null;
        this.f437b = null;
        this.f438c = null;
    }

    private void m720d() {
        if (this.f438c != null) {
            View a = m721a();
            if (a != null && a.getAnimation() == this.f438c) {
                a.clearAnimation();
            }
            this.f438c = null;
        }
    }

    View m721a() {
        return this.f439d == null ? null : (View) this.f439d.get();
    }

    void m722a(View view) {
        View a = m721a();
        if (a != view) {
            if (a != null) {
                m719c();
            }
            if (view != null) {
                this.f439d = new WeakReference(view);
            }
        }
    }

    void m723a(int[] iArr) {
        C0194a c0194a = null;
        int size = this.f436a.size();
        for (int i = 0; i < size; i++) {
            C0194a c0194a2 = (C0194a) this.f436a.get(i);
            if (StateSet.stateSetMatches(c0194a2.f434a, iArr)) {
                c0194a = c0194a2;
                break;
            }
        }
        if (c0194a != this.f437b) {
            if (this.f437b != null) {
                m720d();
            }
            this.f437b = c0194a;
            View view = (View) this.f439d.get();
            if (c0194a != null && view != null && view.getVisibility() == 0) {
                m718a(c0194a);
            }
        }
    }

    public void m724a(int[] iArr, Animation animation) {
        C0194a c0194a = new C0194a(animation, null);
        animation.setAnimationListener(this.f440e);
        this.f436a.add(c0194a);
    }

    public void m725b() {
        if (this.f438c != null) {
            View a = m721a();
            if (a != null && a.getAnimation() == this.f438c) {
                a.clearAnimation();
            }
        }
    }
}
