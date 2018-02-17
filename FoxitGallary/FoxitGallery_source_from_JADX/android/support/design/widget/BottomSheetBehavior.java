package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0110a.C0109g;
import android.support.design.widget.CoordinatorLayout.C0122b;
import android.support.v4.p016k.C0113x;
import android.support.v4.p016k.C0120a;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.af;
import android.support.v4.p016k.ah;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;
import android.support.v4.widget.ad;
import android.support.v4.widget.ad.C0128a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends C0122b<V> {
    private float f219a;
    private int f220b;
    private int f221c;
    private int f222d;
    private boolean f223e;
    private boolean f224f;
    private int f225g;
    private ad f226h;
    private boolean f227i;
    private int f228j;
    private boolean f229k;
    private int f230l;
    private WeakReference<V> f231m;
    private WeakReference<View> f232n;
    private C0130a f233o;
    private VelocityTracker f234p;
    private int f235q;
    private int f236r;
    private boolean f237s;
    private final C0128a f238t;

    /* renamed from: android.support.design.widget.BottomSheetBehavior.1 */
    class C01291 extends C0128a {
        final /* synthetic */ BottomSheetBehavior f214a;

        C01291(BottomSheetBehavior bottomSheetBehavior) {
            this.f214a = bottomSheetBehavior;
        }

        public int m383a(View view) {
            return this.f214a.f223e ? this.f214a.f230l - this.f214a.f221c : this.f214a.f222d - this.f214a.f221c;
        }

        public int m384a(View view, int i, int i2) {
            return C0187k.m683a(i, this.f214a.f221c, this.f214a.f223e ? this.f214a.f230l : this.f214a.f222d);
        }

        public void m385a(int i) {
            if (i == 1) {
                this.f214a.m403b(1);
            }
        }

        public void m386a(View view, float f, float f2) {
            int f3;
            int i = 3;
            if (f2 < 0.0f) {
                f3 = this.f214a.f221c;
            } else if (this.f214a.f223e && this.f214a.m401a(view, f2)) {
                f3 = this.f214a.f230l;
                i = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.f214a.f221c) < Math.abs(top - this.f214a.f222d)) {
                    f3 = this.f214a.f221c;
                } else {
                    f3 = this.f214a.f222d;
                    i = 4;
                }
            } else {
                f3 = this.f214a.f222d;
                i = 4;
            }
            if (this.f214a.f226h.m2562a(view.getLeft(), f3)) {
                this.f214a.m403b(2);
                ah.m1917a(view, new C0133c(this.f214a, view, i));
                return;
            }
            this.f214a.m403b(i);
        }

        public void m387a(View view, int i, int i2, int i3, int i4) {
            this.f214a.m407c(i2);
        }

        public boolean m388a(View view, int i) {
            if (this.f214a.f225g == 1 || this.f214a.f237s) {
                return false;
            }
            if (this.f214a.f225g == 3 && this.f214a.f235q == i) {
                View view2 = (View) this.f214a.f232n.get();
                if (view2 != null && ah.m1926b(view2, -1)) {
                    return false;
                }
            }
            boolean z = this.f214a.f231m != null && this.f214a.f231m.get() == view;
            return z;
        }

        public int m389b(View view, int i, int i2) {
            return view.getLeft();
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior.a */
    public static abstract class C0130a {
        public abstract void m390a(View view, float f);

        public abstract void m391a(View view, int i);
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior.b */
    protected static class C0132b extends C0120a {
        public static final Creator<C0132b> CREATOR;
        final int f215a;

        /* renamed from: android.support.design.widget.BottomSheetBehavior.b.1 */
        static class C01311 implements C0118e<C0132b> {
            C01311() {
            }

            public C0132b m392a(Parcel parcel, ClassLoader classLoader) {
                return new C0132b(parcel, classLoader);
            }

            public C0132b[] m393a(int i) {
                return new C0132b[i];
            }

            public /* synthetic */ Object m394b(Parcel parcel, ClassLoader classLoader) {
                return m392a(parcel, classLoader);
            }

            public /* synthetic */ Object[] m395b(int i) {
                return m393a(i);
            }
        }

        static {
            CREATOR = C0356d.m1329a(new C01311());
        }

        public C0132b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f215a = parcel.readInt();
        }

        public C0132b(Parcelable parcelable, int i) {
            super(parcelable);
            this.f215a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f215a);
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior.c */
    private class C0133c implements Runnable {
        final /* synthetic */ BottomSheetBehavior f216a;
        private final View f217b;
        private final int f218c;

        C0133c(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f216a = bottomSheetBehavior;
            this.f217b = view;
            this.f218c = i;
        }

        public void run() {
            if (this.f216a.f226h == null || !this.f216a.f226h.m2565a(true)) {
                this.f216a.m403b(this.f218c);
            } else {
                ah.m1917a(this.f217b, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f225g = 4;
        this.f238t = new C01291(this);
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f225g = 4;
        this.f238t = new C01291(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0109g.BottomSheetBehavior_Layout);
        m415a(obtainStyledAttributes.getDimensionPixelSize(C0109g.BottomSheetBehavior_Layout_behavior_peekHeight, 0));
        m419a(obtainStyledAttributes.getBoolean(C0109g.BottomSheetBehavior_Layout_behavior_hideable, false));
        m425b(obtainStyledAttributes.getBoolean(C0109g.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f219a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private View m397a(View view) {
        if (view instanceof C0113x) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = m397a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    private void m398a() {
        this.f235q = -1;
        if (this.f234p != null) {
            this.f234p.recycle();
            this.f234p = null;
        }
    }

    private boolean m401a(View view, float f) {
        return this.f224f ? true : view.getTop() < this.f222d ? false : Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f222d)) / ((float) this.f220b) > 0.5f;
    }

    private float m402b() {
        this.f234p.computeCurrentVelocity(1000, this.f219a);
        return af.m1695b(this.f234p, this.f235q);
    }

    private void m403b(int i) {
        if (this.f225g != i) {
            this.f225g = i;
            View view = (View) this.f231m.get();
            if (view != null && this.f233o != null) {
                this.f233o.m391a(view, i);
            }
        }
    }

    private void m407c(int i) {
        View view = (View) this.f231m.get();
        if (view != null && this.f233o != null) {
            if (i > this.f222d) {
                this.f233o.m390a(view, ((float) (this.f222d - i)) / ((float) this.f220b));
            } else {
                this.f233o.m390a(view, ((float) (this.f222d - i)) / ((float) (this.f222d - this.f221c)));
            }
        }
    }

    public final void m415a(int i) {
        this.f220b = Math.max(0, i);
        this.f222d = this.f230l - i;
    }

    public void m416a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        C0132b c0132b = (C0132b) parcelable;
        super.m251a(coordinatorLayout, (View) v, c0132b.m249a());
        if (c0132b.f215a == 1 || c0132b.f215a == 2) {
            this.f225g = 4;
        } else {
            this.f225g = c0132b.f215a;
        }
    }

    public void m417a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.f221c) {
            m403b(3);
        } else if (view == this.f232n.get() && this.f229k) {
            int i2;
            if (this.f228j > 0) {
                i2 = this.f221c;
            } else if (this.f223e && m401a((View) v, m402b())) {
                i2 = this.f230l;
                i = 5;
            } else if (this.f228j == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f221c) < Math.abs(top - this.f222d)) {
                    i2 = this.f221c;
                } else {
                    i2 = this.f222d;
                    i = 4;
                }
            } else {
                i2 = this.f222d;
                i = 4;
            }
            if (this.f226h.m2564a((View) v, v.getLeft(), i2)) {
                m403b(2);
                ah.m1917a((View) v, new C0133c(this, v, i));
            } else {
                m403b(i);
            }
            this.f229k = false;
        }
    }

    public void m418a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.f232n.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f221c) {
                    iArr[1] = top - this.f221c;
                    ah.m1936e((View) v, -iArr[1]);
                    m403b(3);
                } else {
                    iArr[1] = i2;
                    ah.m1936e((View) v, -i2);
                    m403b(1);
                }
            } else if (i2 < 0 && !ah.m1926b(view, -1)) {
                if (i3 <= this.f222d || this.f223e) {
                    iArr[1] = i2;
                    ah.m1936e((View) v, -i2);
                    m403b(1);
                } else {
                    iArr[1] = top - this.f222d;
                    ah.m1936e((View) v, -iArr[1]);
                    m403b(4);
                }
            }
            m407c(v.getTop());
            this.f228j = i2;
            this.f229k = true;
        }
    }

    public void m419a(boolean z) {
        this.f223e = z;
    }

    public boolean m420a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (ah.m1955v(coordinatorLayout) && !ah.m1955v(v)) {
            ah.m1919a((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.m476a((View) v, i);
        this.f230l = coordinatorLayout.getHeight();
        this.f221c = Math.max(0, this.f230l - v.getHeight());
        this.f222d = Math.max(this.f230l - this.f220b, this.f221c);
        if (this.f225g == 3) {
            ah.m1936e((View) v, this.f221c);
        } else if (this.f223e && this.f225g == 5) {
            ah.m1936e((View) v, this.f230l);
        } else if (this.f225g == 4) {
            ah.m1936e((View) v, this.f222d);
        } else if (this.f225g == 1 || this.f225g == 2) {
            ah.m1936e((View) v, top - v.getTop());
        }
        if (this.f226h == null) {
            this.f226h = ad.m2543a((ViewGroup) coordinatorLayout, this.f238t);
        }
        this.f231m = new WeakReference(v);
        this.f232n = new WeakReference(m397a((View) v));
        return true;
    }

    public boolean m421a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (!v.isShown()) {
            return false;
        }
        int a = C0560t.m2392a(motionEvent);
        if (a == 0) {
            m398a();
        }
        if (this.f234p == null) {
            this.f234p = VelocityTracker.obtain();
        }
        this.f234p.addMovement(motionEvent);
        switch (a) {
            case C1373c.View_android_theme /*0*/:
                int x = (int) motionEvent.getX();
                this.f236r = (int) motionEvent.getY();
                View view = (View) this.f232n.get();
                if (view != null && coordinatorLayout.m482a(view, x, this.f236r)) {
                    this.f235q = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f237s = true;
                }
                boolean z2 = this.f235q == -1 && !coordinatorLayout.m482a((View) v, x, this.f236r);
                this.f227i = z2;
                break;
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                this.f237s = false;
                this.f235q = -1;
                if (this.f227i) {
                    this.f227i = false;
                    return false;
                }
                break;
        }
        if (!this.f227i && this.f226h.m2563a(motionEvent)) {
            return true;
        }
        view = (View) this.f232n.get();
        if (a != 2 || view == null || this.f227i || this.f225g == 1 || coordinatorLayout.m482a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f236r) - motionEvent.getY()) <= ((float) this.f226h.m2559a())) {
            z = false;
        }
        return z;
    }

    public boolean m422a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f232n.get() && (this.f225g != 3 || super.m258a(coordinatorLayout, (View) v, view, f, f2));
    }

    public boolean m423a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f228j = 0;
        this.f229k = false;
        return (i & 2) != 0;
    }

    public Parcelable m424b(CoordinatorLayout coordinatorLayout, V v) {
        return new C0132b(super.m261b(coordinatorLayout, v), this.f225g);
    }

    public void m425b(boolean z) {
        this.f224f = z;
    }

    public boolean m426b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int a = C0560t.m2392a(motionEvent);
        if (this.f225g == 1 && a == 0) {
            return true;
        }
        this.f226h.m2568b(motionEvent);
        if (a == 0) {
            m398a();
        }
        if (this.f234p == null) {
            this.f234p = VelocityTracker.obtain();
        }
        this.f234p.addMovement(motionEvent);
        if (a == 2 && !this.f227i && Math.abs(((float) this.f236r) - motionEvent.getY()) > ((float) this.f226h.m2559a())) {
            this.f226h.m2560a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f227i;
    }
}
