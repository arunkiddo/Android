package android.support.design.widget;

import android.content.Context;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.af;
import android.support.v4.p016k.ah;
import android.support.v4.widget.C0632w;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: android.support.design.widget.i */
abstract class C0124i<V extends View> extends C0123v<V> {
    private Runnable f182a;
    private C0632w f183b;
    private boolean f184c;
    private int f185d;
    private int f186e;
    private int f187f;
    private VelocityTracker f188g;

    /* renamed from: android.support.design.widget.i.a */
    private class C0186a implements Runnable {
        final /* synthetic */ C0124i f404a;
        private final CoordinatorLayout f405b;
        private final V f406c;

        C0186a(C0124i c0124i, CoordinatorLayout coordinatorLayout, V v) {
            this.f404a = c0124i;
            this.f405b = coordinatorLayout;
            this.f406c = v;
        }

        public void run() {
            if (this.f406c != null && this.f404a.f183b != null) {
                if (this.f404a.f183b.m2789g()) {
                    this.f404a.a_(this.f405b, this.f406c, this.f404a.f183b.m2785c());
                    ah.m1917a(this.f406c, (Runnable) this);
                    return;
                }
                this.f404a.m279a(this.f405b, this.f406c);
            }
        }
    }

    public C0124i() {
        this.f185d = -1;
        this.f187f = -1;
    }

    public C0124i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f185d = -1;
        this.f187f = -1;
    }

    private void m275c() {
        if (this.f188g == null) {
            this.f188g = VelocityTracker.obtain();
        }
    }

    int m276a() {
        return m272b();
    }

    int m277a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = m272b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = C0187k.m683a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        m270a(a);
        return b - a;
    }

    int m278a(V v) {
        return v.getHeight();
    }

    void m279a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean m280a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f182a != null) {
            v.removeCallbacks(this.f182a);
            this.f182a = null;
        }
        if (this.f183b == null) {
            this.f183b = C0632w.m2776a(v.getContext());
        }
        this.f183b.m2780a(0, m272b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f183b.m2789g()) {
            this.f182a = new C0186a(this, coordinatorLayout, v);
            ah.m1917a((View) v, this.f182a);
            return true;
        }
        m279a(coordinatorLayout, v);
        return false;
    }

    public boolean m281a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f187f < 0) {
            this.f187f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f184c) {
            return true;
        }
        int y;
        switch (C0560t.m2392a(motionEvent)) {
            case C1373c.View_android_theme /*0*/:
                this.f184c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (m285c(v) && coordinatorLayout.m482a((View) v, x, y)) {
                    this.f186e = y;
                    this.f185d = C0560t.m2395b(motionEvent, 0);
                    m275c();
                    break;
                }
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                this.f184c = false;
                this.f185d = -1;
                if (this.f188g != null) {
                    this.f188g.recycle();
                    this.f188g = null;
                    break;
                }
                break;
            case C1373c.View_paddingStart /*2*/:
                y = this.f185d;
                if (y != -1) {
                    y = C0560t.m2393a(motionEvent, y);
                    if (y != -1) {
                        y = (int) C0560t.m2398d(motionEvent, y);
                        if (Math.abs(y - this.f186e) > this.f187f) {
                            this.f184c = true;
                            this.f186e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f188g != null) {
            this.f188g.addMovement(motionEvent);
        }
        return this.f184c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return m277a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int m282b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return m277a(coordinatorLayout, (View) v, m276a() - i, i2, i3);
    }

    int m283b(V v) {
        return -v.getHeight();
    }

    public boolean m284b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f187f < 0) {
            this.f187f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (C0560t.m2392a(motionEvent)) {
            case C1373c.View_android_theme /*0*/:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m482a((View) v, (int) motionEvent.getX(), y) && m285c(v)) {
                    this.f186e = y;
                    this.f185d = C0560t.m2395b(motionEvent, 0);
                    m275c();
                    break;
                }
                return false;
                break;
            case C1373c.View_android_focusable /*1*/:
                if (this.f188g != null) {
                    this.f188g.addMovement(motionEvent);
                    this.f188g.computeCurrentVelocity(1000);
                    m280a(coordinatorLayout, (View) v, -m278a((View) v), 0, af.m1695b(this.f188g, this.f185d));
                    break;
                }
                break;
            case C1373c.View_paddingStart /*2*/:
                int a = C0560t.m2393a(motionEvent, this.f185d);
                if (a != -1) {
                    a = (int) C0560t.m2398d(motionEvent, a);
                    int i = this.f186e - a;
                    if (!this.f184c && Math.abs(i) > this.f187f) {
                        this.f184c = true;
                        i = i > 0 ? i - this.f187f : i + this.f187f;
                    }
                    if (this.f184c) {
                        this.f186e = a;
                        m282b(coordinatorLayout, v, i, m283b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case C1373c.View_paddingEnd /*3*/:
                break;
        }
        this.f184c = false;
        this.f185d = -1;
        if (this.f188g != null) {
            this.f188g.recycle();
            this.f188g = null;
        }
        if (this.f188g != null) {
            this.f188g.addMovement(motionEvent);
        }
        return true;
    }

    boolean m285c(V v) {
        return false;
    }
}
