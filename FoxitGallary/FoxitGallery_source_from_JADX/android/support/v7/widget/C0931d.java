package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p016k.C0518e;
import android.support.v4.p016k.C0518e.C0516a;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.p039g.C0738a;
import android.support.v7.view.C0739a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0751b;
import android.support.v7.view.menu.C0114p;
import android.support.v7.view.menu.C0114p.C0112a;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.view.menu.C0756b;
import android.support.v7.view.menu.C0763s;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0772j;
import android.support.v7.view.menu.C0781n;
import android.support.v7.view.menu.C0786u;
import android.support.v7.widget.ActionMenuView.C0752a;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.d */
class C0931d extends C0756b implements C0516a {
    private C0924b f2392A;
    final C0930f f2393g;
    int f2394h;
    private C0928d f2395i;
    private Drawable f2396j;
    private boolean f2397k;
    private boolean f2398l;
    private boolean f2399m;
    private int f2400n;
    private int f2401o;
    private int f2402p;
    private boolean f2403q;
    private boolean f2404r;
    private boolean f2405s;
    private boolean f2406t;
    private int f2407u;
    private final SparseBooleanArray f2408v;
    private View f2409w;
    private C0929e f2410x;
    private C0923a f2411y;
    private C0925c f2412z;

    /* renamed from: android.support.v7.widget.d.a */
    private class C0923a extends C0781n {
        final /* synthetic */ C0931d f2380a;

        public C0923a(C0931d c0931d, Context context, C0786u c0786u, View view) {
            this.f2380a = c0931d;
            super(context, c0786u, view, false, C0720a.actionOverflowMenuStyle);
            if (!((C0772j) c0786u.getItem()).m3501j()) {
                m3527a(c0931d.f2395i == null ? (View) c0931d.f : c0931d.f2395i);
            }
            m3526a(c0931d.f2393g);
        }

        protected void m4869e() {
            this.f2380a.f2411y = null;
            this.f2380a.f2394h = 0;
            super.m3534e();
        }
    }

    /* renamed from: android.support.v7.widget.d.b */
    private class C0924b extends C0751b {
        final /* synthetic */ C0931d f2381a;

        private C0924b(C0931d c0931d) {
            this.f2381a = c0931d;
        }

        public C0763s m4870a() {
            return this.f2381a.f2411y != null ? this.f2381a.f2411y.m3531b() : null;
        }
    }

    /* renamed from: android.support.v7.widget.d.c */
    private class C0925c implements Runnable {
        final /* synthetic */ C0931d f2382a;
        private C0929e f2383b;

        public C0925c(C0931d c0931d, C0929e c0929e) {
            this.f2382a = c0931d;
            this.f2383b = c0929e;
        }

        public void run() {
            if (this.f2382a.c != null) {
                this.f2382a.c.m3460f();
            }
            View view = (View) this.f2382a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f2383b.m3532c())) {
                this.f2382a.f2410x = this.f2383b;
            }
            this.f2382a.f2412z = null;
        }
    }

    /* renamed from: android.support.v7.widget.d.d */
    private class C0928d extends C0927q implements C0752a {
        final /* synthetic */ C0931d f2388a;
        private final float[] f2389b;

        /* renamed from: android.support.v7.widget.d.d.1 */
        class C09261 extends ai {
            final /* synthetic */ C0931d f2384a;
            final /* synthetic */ C0928d f2385b;

            C09261(C0928d c0928d, View view, C0931d c0931d) {
                this.f2385b = c0928d;
                this.f2384a = c0931d;
                super(view);
            }

            public C0763s m4871a() {
                return this.f2385b.f2388a.f2410x == null ? null : this.f2385b.f2388a.f2410x.m3531b();
            }

            public boolean m4872b() {
                this.f2385b.f2388a.m4910d();
                return true;
            }

            public boolean m4873c() {
                if (this.f2385b.f2388a.f2412z != null) {
                    return false;
                }
                this.f2385b.f2388a.m4911e();
                return true;
            }
        }

        public C0928d(C0931d c0931d, Context context) {
            this.f2388a = c0931d;
            super(context, null, C0720a.actionOverflowButtonStyle);
            this.f2389b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C09261(this, this, c0931d));
        }

        public boolean m4874c() {
            return false;
        }

        public boolean m4875d() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f2388a.m4910d();
            }
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0326a.m1261a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    /* renamed from: android.support.v7.widget.d.e */
    private class C0929e extends C0781n {
        final /* synthetic */ C0931d f2390a;

        public C0929e(C0931d c0931d, Context context, C0769h c0769h, View view, boolean z) {
            this.f2390a = c0931d;
            super(context, c0769h, view, z, C0720a.actionOverflowMenuStyle);
            m3525a(8388613);
            m3526a(c0931d.f2393g);
        }

        protected void m4876e() {
            if (this.f2390a.c != null) {
                this.f2390a.c.close();
            }
            this.f2390a.f2410x = null;
            super.m3534e();
        }
    }

    /* renamed from: android.support.v7.widget.d.f */
    private class C0930f implements C0691a {
        final /* synthetic */ C0931d f2391a;

        private C0930f(C0931d c0931d) {
            this.f2391a = c0931d;
        }

        public void m4877a(C0769h c0769h, boolean z) {
            if (c0769h instanceof C0786u) {
                c0769h.m3470p().m3441a(false);
            }
            C0691a a = this.f2391a.m3326a();
            if (a != null) {
                a.m3040a(c0769h, z);
            }
        }

        public boolean m4878a(C0769h c0769h) {
            if (c0769h == null) {
                return false;
            }
            this.f2391a.f2394h = ((C0786u) c0769h).getItem().getItemId();
            C0691a a = this.f2391a.m3326a();
            return a != null ? a.m3041a(c0769h) : false;
        }
    }

    public C0931d(Context context) {
        super(context, C0726g.abc_action_menu_layout, C0726g.abc_action_menu_item_layout);
        this.f2408v = new SparseBooleanArray();
        this.f2393g = new C0930f();
    }

    private View m4883a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0112a) && ((C0112a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public C0114p m4893a(ViewGroup viewGroup) {
        C0114p c0114p = this.f;
        C0114p a = super.m3327a(viewGroup);
        if (c0114p != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    public View m4894a(C0772j c0772j, View view, ViewGroup viewGroup) {
        View actionView = c0772j.getActionView();
        if (actionView == null || c0772j.m3505n()) {
            actionView = super.m3328a(c0772j, view, viewGroup);
        }
        actionView.setVisibility(c0772j.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m3633a(layoutParams));
        }
        return actionView;
    }

    public void m4895a(Context context, C0769h c0769h) {
        super.m3330a(context, c0769h);
        Resources resources = context.getResources();
        C0739a a = C0739a.m3212a(context);
        if (!this.f2399m) {
            this.f2398l = a.m3214b();
        }
        if (!this.f2405s) {
            this.f2400n = a.m3215c();
        }
        if (!this.f2403q) {
            this.f2402p = a.m3213a();
        }
        int i = this.f2400n;
        if (this.f2398l) {
            if (this.f2395i == null) {
                this.f2395i = new C0928d(this, this.a);
                if (this.f2397k) {
                    this.f2395i.setImageDrawable(this.f2396j);
                    this.f2396j = null;
                    this.f2397k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2395i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2395i.getMeasuredWidth();
        } else {
            this.f2395i = null;
        }
        this.f2401o = i;
        this.f2407u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2409w = null;
    }

    public void m4896a(Configuration configuration) {
        if (!this.f2403q) {
            this.f2402p = C0739a.m3212a(this.b).m3213a();
        }
        if (this.c != null) {
            this.c.m3449b(true);
        }
    }

    public void m4897a(Drawable drawable) {
        if (this.f2395i != null) {
            this.f2395i.setImageDrawable(drawable);
            return;
        }
        this.f2397k = true;
        this.f2396j = drawable;
    }

    public void m4898a(C0769h c0769h, boolean z) {
        m4912f();
        super.m3331a(c0769h, z);
    }

    public void m4899a(C0772j c0772j, C0112a c0112a) {
        c0112a.m233a(c0772j, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0112a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f2392A == null) {
            this.f2392A = new C0924b();
        }
        actionMenuItemView.setPopupCallback(this.f2392A);
    }

    public void m4900a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.m3634a(this.c);
    }

    public void m4901a(boolean z) {
        if (z) {
            super.m3337a(null);
        } else if (this.c != null) {
            this.c.m3441a(false);
        }
    }

    public boolean m4902a(int i, C0772j c0772j) {
        return c0772j.m3501j();
    }

    public boolean m4903a(C0786u c0786u) {
        if (!c0786u.hasVisibleItems()) {
            return false;
        }
        C0786u c0786u2 = c0786u;
        while (c0786u2.m3567s() != this.c) {
            c0786u2 = (C0786u) c0786u2.m3567s();
        }
        View a = m4883a(c0786u2.getItem());
        if (a == null) {
            return false;
        }
        boolean z;
        this.f2394h = c0786u.getItem().getItemId();
        int size = c0786u.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0786u.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.f2411y = new C0923a(this, this.b, c0786u, a);
        this.f2411y.m3529a(z);
        this.f2411y.m3524a();
        super.m3337a(c0786u);
        return true;
    }

    public boolean m4904a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.f2395i ? false : super.m3338a(viewGroup, i);
    }

    public void m4905b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0738a.m3211a(viewGroup);
        }
        super.m3340b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m3465k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0518e a = ((C0772j) k.get(i)).m3483a();
                if (a != null) {
                    a.m2275a((C0516a) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m3466l() : null;
        if (this.f2398l && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((C0772j) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f2395i == null) {
                this.f2395i = new C0928d(this, this.a);
            }
            viewGroup = (ViewGroup) this.f2395i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2395i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f2395i, actionMenuView.m3642c());
            }
        } else if (this.f2395i != null && this.f2395i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f2395i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f2398l);
    }

    public boolean m4906b() {
        int size;
        ArrayList arrayList;
        int i;
        if (this.c != null) {
            ArrayList i2 = this.c.m3463i();
            size = i2.size();
            arrayList = i2;
        } else {
            size = 0;
            arrayList = null;
        }
        int i3 = this.f2402p;
        int i4 = this.f2401o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0772j c0772j = (C0772j) arrayList.get(i7);
            if (c0772j.m3503l()) {
                i5++;
            } else if (c0772j.m3502k()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.f2406t && c0772j.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.f2398l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f2408v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f2404r) {
            i = i4 / this.f2407u;
            i6 = ((i4 % this.f2407u) / i) + this.f2407u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0772j = (C0772j) arrayList.get(i8);
            int i10;
            if (c0772j.m3503l()) {
                View a = m4894a(c0772j, this.f2409w, viewGroup);
                if (this.f2409w == null) {
                    this.f2409w = a;
                }
                if (this.f2404r) {
                    i9 -= ActionMenuView.m3628a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0772j.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0772j.m3494d(true);
                i = i10;
                i3 = i7;
            } else if (c0772j.m3502k()) {
                boolean z;
                int groupId = c0772j.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f2404r || i9 > 0);
                if (z3) {
                    View a2 = m4894a(c0772j, this.f2409w, viewGroup);
                    if (this.f2409w == null) {
                        this.f2409w = a2;
                    }
                    boolean z4;
                    if (this.f2404r) {
                        int a3 = ActionMenuView.m3628a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f2404r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0772j c0772j2 = (C0772j) arrayList.get(i7);
                        if (c0772j2.getGroupId() == groupId) {
                            if (c0772j2.m3501j()) {
                                i5++;
                            }
                            c0772j2.m3494d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0772j.m3494d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0772j.m3494d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public Drawable m4907c() {
        return this.f2395i != null ? this.f2395i.getDrawable() : this.f2397k ? this.f2396j : null;
    }

    public void m4908c(boolean z) {
        this.f2398l = z;
        this.f2399m = true;
    }

    public void m4909d(boolean z) {
        this.f2406t = z;
    }

    public boolean m4910d() {
        if (!this.f2398l || m4914h() || this.c == null || this.f == null || this.f2412z != null || this.c.m3466l().isEmpty()) {
            return false;
        }
        this.f2412z = new C0925c(this, new C0929e(this, this.b, this.c, this.f2395i, true));
        ((View) this.f).post(this.f2412z);
        super.m3337a(null);
        return true;
    }

    public boolean m4911e() {
        if (this.f2412z == null || this.f == null) {
            C0781n c0781n = this.f2410x;
            if (c0781n == null) {
                return false;
            }
            c0781n.m3533d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f2412z);
        this.f2412z = null;
        return true;
    }

    public boolean m4912f() {
        return m4911e() | m4913g();
    }

    public boolean m4913g() {
        if (this.f2411y == null) {
            return false;
        }
        this.f2411y.m3533d();
        return true;
    }

    public boolean m4914h() {
        return this.f2410x != null && this.f2410x.m3535f();
    }

    public boolean m4915i() {
        return this.f2412z != null || m4914h();
    }
}
