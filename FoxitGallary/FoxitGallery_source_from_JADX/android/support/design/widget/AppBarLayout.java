package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0110a.C0104b;
import android.support.design.C0110a.C0109g;
import android.support.design.widget.C0202q.C0115a;
import android.support.design.widget.CoordinatorLayout.C0122b;
import android.support.design.widget.CoordinatorLayout.C0136c;
import android.support.design.widget.CoordinatorLayout.C0138e;
import android.support.v4.p016k.C0120a;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.bg;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

@C0136c(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int f204a;
    private int f205b;
    private int f206c;
    private boolean f207d;
    private int f208e;
    private bg f209f;
    private List<C0127b> f210g;
    private boolean f211h;
    private boolean f212i;
    private final int[] f213j;

    public static class Behavior extends C0124i<AppBarLayout> {
        private int f189a;
        private boolean f190b;
        private boolean f191c;
        private C0202q f192d;
        private int f193e;
        private boolean f194f;
        private float f195g;
        private WeakReference<View> f196h;
        private C0117a f197i;

        /* renamed from: android.support.design.widget.AppBarLayout.Behavior.1 */
        class C01161 implements C0115a {
            final /* synthetic */ CoordinatorLayout f171a;
            final /* synthetic */ AppBarLayout f172b;
            final /* synthetic */ Behavior f173c;

            C01161(Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f173c = behavior;
                this.f171a = coordinatorLayout;
                this.f172b = appBarLayout;
            }

            public void m241a(C0202q c0202q) {
                this.f173c.a_(this.f171a, this.f172b, c0202q.m750c());
            }
        }

        /* renamed from: android.support.design.widget.AppBarLayout.Behavior.a */
        public static abstract class C0117a {
            public abstract boolean m242a(AppBarLayout appBarLayout);
        }

        /* renamed from: android.support.design.widget.AppBarLayout.Behavior.b */
        protected static class C0121b extends C0120a {
            public static final Creator<C0121b> CREATOR;
            int f176a;
            float f177b;
            boolean f178c;

            /* renamed from: android.support.design.widget.AppBarLayout.Behavior.b.1 */
            static class C01191 implements C0118e<C0121b> {
                C01191() {
                }

                public C0121b m245a(Parcel parcel, ClassLoader classLoader) {
                    return new C0121b(parcel, classLoader);
                }

                public C0121b[] m246a(int i) {
                    return new C0121b[i];
                }

                public /* synthetic */ Object m247b(Parcel parcel, ClassLoader classLoader) {
                    return m245a(parcel, classLoader);
                }

                public /* synthetic */ Object[] m248b(int i) {
                    return m246a(i);
                }
            }

            static {
                CREATOR = C0356d.m1329a(new C01191());
            }

            public C0121b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f176a = parcel.readInt();
                this.f177b = parcel.readFloat();
                this.f178c = parcel.readByte() != null;
            }

            public C0121b(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f176a);
                parcel.writeFloat(this.f177b);
                parcel.writeByte((byte) (this.f178c ? 1 : 0));
            }
        }

        public Behavior() {
            this.f193e = -1;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f193e = -1;
        }

        private int m287a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private void m288a(AppBarLayout appBarLayout, int i, int i2) {
            boolean z = true;
            boolean z2 = false;
            View c = m293c(appBarLayout, i);
            if (c != null) {
                int a = ((C0126a) c.getLayoutParams()).m348a();
                if ((a & 1) != 0) {
                    int q = ah.m1950q(c);
                    if (i2 > 0 && (a & 12) != 0) {
                        z2 = (-i) >= (c.getBottom() - q) - appBarLayout.getTopInset();
                    } else if ((a & 2) != 0) {
                        if ((-i) < (c.getBottom() - q) - appBarLayout.getTopInset()) {
                            z = false;
                        }
                        z2 = z;
                    }
                }
                appBarLayout.setCollapsedState(z2);
            }
        }

        private void m289a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int abs = Math.abs(m295a() - i);
            float abs2 = Math.abs(f);
            m290a(coordinatorLayout, appBarLayout, i, abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f));
        }

        private void m290a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            int a = m295a();
            if (a != i) {
                if (this.f192d == null) {
                    this.f192d = C0215x.m789a();
                    this.f192d.m748a(C0170a.f353e);
                    this.f192d.m747a(new C01161(this, coordinatorLayout, appBarLayout));
                } else {
                    this.f192d.m752e();
                }
                this.f192d.m746a((long) Math.min(i2, 600));
                this.f192d.m745a(a, i);
                this.f192d.m743a();
            } else if (this.f192d != null && this.f192d.m749b()) {
                this.f192d.m752e();
            }
        }

        private static boolean m291a(int i, int i2) {
            return (i & i2) == i2;
        }

        private int m292b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                C0126a c0126a = (C0126a) childAt.getLayoutParams();
                Interpolator b = c0126a.m349b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = c0126a.m348a();
                    if ((i2 & 1) != 0) {
                        height = (c0126a.bottomMargin + (childAt.getHeight() + c0126a.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= ah.m1950q(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (ah.m1955v(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private static View m293c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private void m294c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = m295a();
            int a2 = m287a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((C0126a) childAt.getLayoutParams()).m348a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (m291a(a3, 2)) {
                        i2 += ah.m1950q(childAt);
                        a2 = i;
                    } else if (m291a(a3, 5)) {
                        a2 = ah.m1950q(childAt) + i2;
                        if (a >= a2) {
                            i2 = a2;
                            a2 = i;
                        }
                    } else {
                        a2 = i;
                    }
                    if (a >= (i2 + a2) / 2) {
                        i2 = a2;
                    }
                    m289a(coordinatorLayout, appBarLayout, C0187k.m683a(i2, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        int m295a() {
            return m319b() + this.f189a;
        }

        int m296a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = m295a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f189a = 0;
                return 0;
            }
            int a2 = C0187k.m683a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.m360d() ? m292b(appBarLayout, a2) : a2;
            boolean a3 = m309a(b);
            int i4 = a - a2;
            this.f189a = a2 - b;
            if (!a3 && appBarLayout.m360d()) {
                coordinatorLayout.m489c((View) appBarLayout);
            }
            appBarLayout.m351a(m319b());
            m288a(appBarLayout, a2, a2 < a ? -1 : 1);
            return i4;
        }

        /* synthetic */ int m298a(View view) {
            return m324c((AppBarLayout) view);
        }

        void m299a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m294c(coordinatorLayout, appBarLayout);
        }

        public void m300a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof C0121b) {
                C0121b c0121b = (C0121b) parcelable;
                super.m251a(coordinatorLayout, (View) appBarLayout, c0121b.m249a());
                this.f193e = c0121b.f176a;
                this.f195g = c0121b.f177b;
                this.f194f = c0121b.f178c;
                return;
            }
            super.m251a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f193e = -1;
        }

        public void m301a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f191c) {
                m294c(coordinatorLayout, appBarLayout);
            }
            this.f190b = false;
            this.f191c = false;
            this.f196h = new WeakReference(view);
        }

        public void m302a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m282b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f190b = true;
                return;
            }
            this.f190b = false;
        }

        public void m303a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.f190b) {
                int i3;
                int b;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    b = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    b = 0;
                }
                iArr[1] = m282b(coordinatorLayout, appBarLayout, i2, i3, b);
            }
        }

        boolean m310a(AppBarLayout appBarLayout) {
            if (this.f197i != null) {
                return this.f197i.m242a(appBarLayout);
            }
            if (this.f196h == null) {
                return true;
            }
            View view = (View) this.f196h.get();
            return (view == null || !view.isShown() || ah.m1926b(view, -1)) ? false : true;
        }

        public boolean m311a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.m271a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.getPendingAction();
            if (e != 0) {
                int i2 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    e = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        m289a(coordinatorLayout, appBarLayout, e, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, e);
                    }
                } else if ((e & 1) != 0) {
                    if (i2 != 0) {
                        m289a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f193e >= 0) {
                View childAt = appBarLayout.getChildAt(this.f193e);
                e = -childAt.getBottom();
                m309a(this.f194f ? ah.m1950q(childAt) + e : Math.round(((float) childAt.getHeight()) * this.f195g) + e);
            }
            appBarLayout.m363f();
            this.f193e = -1;
            m309a(C0187k.m683a(m319b(), -appBarLayout.getTotalScrollRange(), 0));
            appBarLayout.m351a(m319b());
            return a;
        }

        public boolean m312a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((C0138e) appBarLayout.getLayoutParams()).height != -2) {
                return super.m256a(coordinatorLayout, (View) appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.m477a(appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean m313a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = m280a(coordinatorLayout, (View) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (m295a() < r1) {
                    m289a(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (m295a() > r1) {
                    m289a(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            }
            this.f191c = z2;
            return z2;
        }

        public boolean m314a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.m362e() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f192d != null) {
                this.f192d.m752e();
            }
            this.f196h = null;
            return z;
        }

        public /* bridge */ /* synthetic */ int m319b() {
            return super.m272b();
        }

        int m320b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        public Parcelable m322b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.m261b(coordinatorLayout, appBarLayout);
            int b2 = m319b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    C0121b c0121b = new C0121b(b);
                    c0121b.f176a = i;
                    if (bottom == ah.m1950q(childAt)) {
                        z = true;
                    }
                    c0121b.f178c = z;
                    c0121b.f177b = ((float) bottom) / ((float) childAt.getHeight());
                    return c0121b;
                }
            }
            return b;
        }

        int m324c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* synthetic */ boolean m325c(View view) {
            return m310a((AppBarLayout) view);
        }
    }

    public static class ScrollingViewBehavior extends C0125j {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0109g.ScrollingViewBehavior_Layout);
            m332b(obtainStyledAttributes.getDimensionPixelSize(C0109g.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int m335a(AppBarLayout appBarLayout) {
            C0122b b = ((C0138e) appBarLayout.getLayoutParams()).m439b();
            return b instanceof Behavior ? ((Behavior) b).m295a() : 0;
        }

        private void m336e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            C0122b b = ((C0138e) view2.getLayoutParams()).m439b();
            if (b instanceof Behavior) {
                Behavior behavior = (Behavior) b;
                behavior.m295a();
                ah.m1936e(view, ((behavior.f189a + (view2.getBottom() - view.getTop())) + m328a()) - m334c(view2));
            }
        }

        float m337a(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int b = appBarLayout.getDownNestedPreScrollRange();
            int a = m335a(appBarLayout);
            if (b != 0 && totalScrollRange + a <= b) {
                return 0.0f;
            }
            totalScrollRange -= b;
            return totalScrollRange != 0 ? 1.0f + (((float) a) / ((float) totalScrollRange)) : 0.0f;
        }

        View m338a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        public /* bridge */ /* synthetic */ boolean m340a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.m271a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean m341a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.m330a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ int m342b() {
            return super.m272b();
        }

        int m343b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.m331b(view);
        }

        public boolean m344b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean m345c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m336e(coordinatorLayout, view, view2);
            return false;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout.a */
    public static class C0126a extends LayoutParams {
        int f202a;
        Interpolator f203b;

        public C0126a(int i, int i2) {
            super(i, i2);
            this.f202a = 1;
        }

        public C0126a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f202a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0109g.AppBarLayout_Layout);
            this.f202a = obtainStyledAttributes.getInt(C0109g.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(C0109g.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f203b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0109g.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public C0126a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f202a = 1;
        }

        public C0126a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f202a = 1;
        }

        public C0126a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f202a = 1;
        }

        private boolean m347c() {
            return (this.f202a & 1) == 1 && (this.f202a & 10) != 0;
        }

        public int m348a() {
            return this.f202a;
        }

        public Interpolator m349b() {
            return this.f203b;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout.b */
    public interface C0127b {
        void m350a(AppBarLayout appBarLayout, int i);
    }

    private void m351a(int i) {
        if (this.f210g != null) {
            int size = this.f210g.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0127b c0127b = (C0127b) this.f210g.get(i2);
                if (c0127b != null) {
                    c0127b.m350a(this, i);
                }
            }
        }
    }

    private void m356b() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0126a) getChildAt(i).getLayoutParams()).m347c()) {
                z = true;
                break;
            }
        }
        z = false;
        setCollapsibleState(z);
    }

    private void m358c() {
        this.f204a = -1;
        this.f205b = -1;
        this.f206c = -1;
    }

    private boolean m360d() {
        return this.f207d;
    }

    private boolean m362e() {
        return getTotalScrollRange() != 0;
    }

    private void m363f() {
        this.f208e = 0;
    }

    private int getDownNestedPreScrollRange() {
        if (this.f205b != -1) {
            return this.f205b;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0126a c0126a = (C0126a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0126a.f202a;
            if ((i3 & 5) == 5) {
                i = (c0126a.bottomMargin + c0126a.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + ah.m1950q(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - ah.m1950q(childAt)) : i + measuredHeight;
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        this.f205b = i;
        return i;
    }

    private int getDownNestedScrollRange() {
        if (this.f206c != -1) {
            return this.f206c;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0126a c0126a = (C0126a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0126a.topMargin + c0126a.bottomMargin);
            i = c0126a.f202a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (ah.m1950q(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f206c = i;
        return i;
    }

    private int getPendingAction() {
        return this.f208e;
    }

    private int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    private void setCollapsedState(boolean z) {
        if (this.f212i != z) {
            this.f212i = z;
            refreshDrawableState();
        }
    }

    private void setCollapsibleState(boolean z) {
        if (this.f211h != z) {
            this.f211h = z;
            refreshDrawableState();
        }
    }

    protected C0126a m366a() {
        return new C0126a(-1, -2);
    }

    public C0126a m367a(AttributeSet attributeSet) {
        return new C0126a(getContext(), attributeSet);
    }

    protected C0126a m368a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new C0126a((LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0126a((MarginLayoutParams) layoutParams) : new C0126a(layoutParams);
    }

    public void m369a(boolean z, boolean z2) {
        this.f208e = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0126a;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m366a();
    }

    protected /* synthetic */ LayoutParams m6459generateDefaultLayoutParams() {
        return m366a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m367a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m368a(layoutParams);
    }

    public /* synthetic */ LayoutParams m6460generateLayoutParams(AttributeSet attributeSet) {
        return m367a(attributeSet);
    }

    protected /* synthetic */ LayoutParams m6461generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m368a(layoutParams);
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int q = ah.m1950q(this);
        if (q != 0) {
            return (q * 2) + topInset;
        }
        q = getChildCount();
        q = q >= 1 ? ah.m1950q(getChildAt(q - 1)) : 0;
        return q != 0 ? (q * 2) + topInset : getHeight() / 3;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        return this.f209f != null ? this.f209f.m2248b() : 0;
    }

    public final int getTotalScrollRange() {
        if (this.f204a != -1) {
            return this.f204a;
        }
        int q;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0126a c0126a = (C0126a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0126a.f202a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += c0126a.bottomMargin + (measuredHeight + c0126a.topMargin);
            if ((i3 & 2) != 0) {
                q = i - ah.m1950q(childAt);
                break;
            }
        }
        q = i;
        q = Math.max(0, q - getTopInset());
        this.f204a = q;
        return q;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] iArr = this.f213j;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.f211h ? C0104b.state_collapsible : -C0104b.state_collapsible;
        int i2 = (this.f211h && this.f212i) ? C0104b.state_collapsed : -C0104b.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m358c();
        this.f207d = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0126a) getChildAt(i5).getLayoutParams()).m349b() != null) {
                this.f207d = true;
                break;
            }
        }
        m356b();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m358c();
    }

    public void setExpanded(boolean z) {
        m369a(z, ah.m1901D(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            C0216y.m790a(this, f);
        }
    }
}
