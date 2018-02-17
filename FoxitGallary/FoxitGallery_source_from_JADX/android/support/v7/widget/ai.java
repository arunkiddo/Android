package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.p016k.C0560t;
import android.support.v7.view.menu.C0763s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public abstract class ai implements OnTouchListener {
    private final float f1425a;
    private final int f1426b;
    private final int f1427c;
    private final View f1428d;
    private Runnable f1429e;
    private Runnable f1430f;
    private boolean f1431g;
    private int f1432h;
    private final int[] f1433i;

    /* renamed from: android.support.v7.widget.ai.a */
    private class C0896a implements Runnable {
        final /* synthetic */ ai f2246a;

        private C0896a(ai aiVar) {
            this.f2246a = aiVar;
        }

        public void run() {
            this.f2246a.f1428d.getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: android.support.v7.widget.ai.b */
    private class C0897b implements Runnable {
        final /* synthetic */ ai f2247a;

        private C0897b(ai aiVar) {
            this.f2247a = aiVar;
        }

        public void run() {
            this.f2247a.m3284e();
        }
    }

    public ai(View view) {
        this.f1433i = new int[2];
        this.f1428d = view;
        this.f1425a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1426b = ViewConfiguration.getTapTimeout();
        this.f1427c = (this.f1426b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean m3277a(MotionEvent motionEvent) {
        View view = this.f1428d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (C0560t.m2392a(motionEvent)) {
            case C1373c.View_android_theme /*0*/:
                this.f1432h = motionEvent.getPointerId(0);
                if (this.f1429e == null) {
                    this.f1429e = new C0896a();
                }
                view.postDelayed(this.f1429e, (long) this.f1426b);
                if (this.f1430f == null) {
                    this.f1430f = new C0897b();
                }
                view.postDelayed(this.f1430f, (long) this.f1427c);
                return false;
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                m3283d();
                return false;
            case C1373c.View_paddingStart /*2*/:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1432h);
                if (findPointerIndex < 0 || m3278a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1425a)) {
                    return false;
                }
                m3283d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private static boolean m3278a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean m3279a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1433i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean m3281b(MotionEvent motionEvent) {
        View view = this.f1428d;
        C0763s a = m3285a();
        if (a == null || !a.m3355d()) {
            return false;
        }
        ag agVar = (ag) a.m3356e();
        if (agVar == null || !agVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m3282b(view, obtainNoHistory);
        m3279a(agVar, obtainNoHistory);
        boolean a2 = agVar.m4641a(obtainNoHistory, this.f1432h);
        obtainNoHistory.recycle();
        int a3 = C0560t.m2392a(motionEvent);
        boolean z = (a3 == 1 || a3 == 3) ? false : true;
        z = a2 && z;
        return z;
    }

    private boolean m3282b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1433i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void m3283d() {
        if (this.f1430f != null) {
            this.f1428d.removeCallbacks(this.f1430f);
        }
        if (this.f1429e != null) {
            this.f1428d.removeCallbacks(this.f1429e);
        }
    }

    private void m3284e() {
        m3283d();
        View view = this.f1428d;
        if (view.isEnabled() && !view.isLongClickable() && m3286b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1431g = true;
        }
    }

    public abstract C0763s m3285a();

    protected boolean m3286b() {
        C0763s a = m3285a();
        if (!(a == null || a.m3355d())) {
            a.m3353a();
        }
        return true;
    }

    protected boolean m3287c() {
        C0763s a = m3285a();
        if (a != null && a.m3355d()) {
            a.m3354c();
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1431g;
        if (z2) {
            z = m3281b(motionEvent) || !m3287c();
        } else {
            boolean z3 = m3277a(motionEvent) && m3286b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1428d.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        }
        this.f1431g = z;
        return z || z2;
    }
}
