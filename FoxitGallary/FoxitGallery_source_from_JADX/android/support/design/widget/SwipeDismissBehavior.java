package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0122b;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.ah;
import android.support.v4.widget.ad;
import android.support.v4.widget.ad.C0128a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public class SwipeDismissBehavior<V extends View> extends C0122b<V> {
    private ad f324a;
    private C0156a f325b;
    private boolean f326c;
    private float f327d;
    private boolean f328e;
    private int f329f;
    private float f330g;
    private float f331h;
    private float f332i;
    private final C0128a f333j;

    /* renamed from: android.support.design.widget.SwipeDismissBehavior.a */
    public interface C0156a {
        void m548a(int i);

        void m549a(View view);
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior.1 */
    class C01671 extends C0128a {
        final /* synthetic */ SwipeDismissBehavior f343a;
        private int f344b;
        private int f345c;

        C01671(SwipeDismissBehavior swipeDismissBehavior) {
            this.f343a = swipeDismissBehavior;
            this.f345c = -1;
        }

        private boolean m614a(View view, float f) {
            if (f != 0.0f) {
                boolean z = ah.m1941h(view) == 1;
                return this.f343a.f329f == 2 ? true : this.f343a.f329f == 0 ? z ? f < 0.0f : f > 0.0f : this.f343a.f329f == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                return Math.abs(view.getLeft() - this.f344b) >= Math.round(((float) view.getWidth()) * this.f343a.f330g);
            }
        }

        public int m615a(View view, int i, int i2) {
            return view.getTop();
        }

        public void m616a(int i) {
            if (this.f343a.f325b != null) {
                this.f343a.f325b.m548a(i);
            }
        }

        public void m617a(View view, float f, float f2) {
            this.f345c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (m614a(view, f)) {
                width = view.getLeft() < this.f344b ? this.f344b - width : this.f344b + width;
                z = true;
            } else {
                width = this.f344b;
            }
            if (this.f343a.f324a.m2562a(width, view.getTop())) {
                ah.m1917a(view, new C0168b(this.f343a, view, z));
            } else if (z && this.f343a.f325b != null) {
                this.f343a.f325b.m549a(view);
            }
        }

        public void m618a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.f344b) + (((float) view.getWidth()) * this.f343a.f331h);
            float width2 = ((float) this.f344b) + (((float) view.getWidth()) * this.f343a.f332i);
            if (((float) i) <= width) {
                ah.m1927c(view, 1.0f);
            } else if (((float) i) >= width2) {
                ah.m1927c(view, 0.0f);
            } else {
                ah.m1927c(view, SwipeDismissBehavior.m571c(0.0f, 1.0f - SwipeDismissBehavior.m564a(width, width2, (float) i), 1.0f));
            }
        }

        public boolean m619a(View view, int i) {
            return this.f345c == -1 && this.f343a.m580a(view);
        }

        public int m620b(View view) {
            return view.getWidth();
        }

        public int m621b(View view, int i, int i2) {
            int width;
            int i3;
            Object obj = ah.m1941h(view) == 1 ? 1 : null;
            if (this.f343a.f329f == 0) {
                if (obj != null) {
                    width = this.f344b - view.getWidth();
                    i3 = this.f344b;
                } else {
                    width = this.f344b;
                    i3 = this.f344b + view.getWidth();
                }
            } else if (this.f343a.f329f != 1) {
                width = this.f344b - view.getWidth();
                i3 = this.f344b + view.getWidth();
            } else if (obj != null) {
                width = this.f344b;
                i3 = this.f344b + view.getWidth();
            } else {
                width = this.f344b - view.getWidth();
                i3 = this.f344b;
            }
            return SwipeDismissBehavior.m569b(width, i, i3);
        }

        public void m622b(View view, int i) {
            this.f345c = i;
            this.f344b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior.b */
    private class C0168b implements Runnable {
        final /* synthetic */ SwipeDismissBehavior f346a;
        private final View f347b;
        private final boolean f348c;

        C0168b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f346a = swipeDismissBehavior;
            this.f347b = view;
            this.f348c = z;
        }

        public void run() {
            if (this.f346a.f324a != null && this.f346a.f324a.m2565a(true)) {
                ah.m1917a(this.f347b, (Runnable) this);
            } else if (this.f348c && this.f346a.f325b != null) {
                this.f346a.f325b.m549a(this.f347b);
            }
        }
    }

    public SwipeDismissBehavior() {
        this.f327d = 0.0f;
        this.f329f = 2;
        this.f330g = 0.5f;
        this.f331h = 0.0f;
        this.f332i = 0.5f;
        this.f333j = new C01671(this);
    }

    static float m564a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void m567a(ViewGroup viewGroup) {
        if (this.f324a == null) {
            this.f324a = this.f328e ? ad.m2542a(viewGroup, this.f327d, this.f333j) : ad.m2543a(viewGroup, this.f333j);
        }
    }

    private static int m569b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private static float m571c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public void m576a(float f) {
        this.f331h = m571c(0.0f, f, 1.0f);
    }

    public void m577a(int i) {
        this.f329f = i;
    }

    public void m578a(C0156a c0156a) {
        this.f325b = c0156a;
    }

    public boolean m579a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (C0560t.m2392a(motionEvent)) {
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                if (this.f326c) {
                    this.f326c = false;
                    return false;
                }
                break;
            default:
                this.f326c = !coordinatorLayout.m482a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f326c) {
            return false;
        }
        m567a((ViewGroup) coordinatorLayout);
        return this.f324a.m2563a(motionEvent);
    }

    public boolean m580a(View view) {
        return true;
    }

    public void m581b(float f) {
        this.f332i = m571c(0.0f, f, 1.0f);
    }

    public boolean m582b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f324a == null) {
            return false;
        }
        this.f324a.m2568b(motionEvent);
        return true;
    }
}
