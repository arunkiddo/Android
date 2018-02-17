package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p016k.C0143z;
import android.support.v4.p016k.aa;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.az;
import android.support.v4.p016k.bd;
import android.support.v4.p016k.be;
import android.support.v4.widget.C0632w;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.view.menu.C0755o.C0691a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public class ActionBarOverlayLayout extends ViewGroup implements C0143z, ac {
    static final int[] f1680a;
    private final Runnable f1681A;
    private final aa f1682B;
    private int f1683b;
    private int f1684c;
    private ContentFrameLayout f1685d;
    private ActionBarContainer f1686e;
    private ad f1687f;
    private Drawable f1688g;
    private boolean f1689h;
    private boolean f1690i;
    private boolean f1691j;
    private boolean f1692k;
    private boolean f1693l;
    private int f1694m;
    private int f1695n;
    private final Rect f1696o;
    private final Rect f1697p;
    private final Rect f1698q;
    private final Rect f1699r;
    private final Rect f1700s;
    private final Rect f1701t;
    private C0718a f1702u;
    private final int f1703v;
    private C0632w f1704w;
    private az f1705x;
    private final bd f1706y;
    private final Runnable f1707z;

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.a */
    public interface C0718a {
        void m3141a(int i);

        void m3142g(boolean z);

        void m3143n();

        void m3144o();

        void m3145p();

        void m3146q();
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.1 */
    class C07901 extends be {
        final /* synthetic */ ActionBarOverlayLayout f1677a;

        C07901(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1677a = actionBarOverlayLayout;
        }

        public void m3585b(View view) {
            this.f1677a.f1705x = null;
            this.f1677a.f1693l = false;
        }

        public void m3586c(View view) {
            this.f1677a.f1705x = null;
            this.f1677a.f1693l = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.2 */
    class C07912 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1678a;

        C07912(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1678a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1678a.m3605k();
            this.f1678a.f1705x = ah.m1951r(this.f1678a.f1686e).m2165c(0.0f).m2159a(this.f1678a.f1706y);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.3 */
    class C07923 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1679a;

        C07923(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1679a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1679a.m3605k();
            this.f1679a.f1705x = ah.m1951r(this.f1679a.f1686e).m2165c((float) (-this.f1679a.f1686e.getHeight())).m2159a(this.f1679a.f1706y);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.b */
    public static class C0793b extends MarginLayoutParams {
        public C0793b(int i, int i2) {
            super(i, i2);
        }

        public C0793b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0793b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    static {
        f1680a = new int[]{C0720a.actionBarSize, 16842841};
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1684c = 0;
        this.f1696o = new Rect();
        this.f1697p = new Rect();
        this.f1698q = new Rect();
        this.f1699r = new Rect();
        this.f1700s = new Rect();
        this.f1701t = new Rect();
        this.f1703v = 600;
        this.f1706y = new C07901(this);
        this.f1707z = new C07912(this);
        this.f1681A = new C07923(this);
        m3598a(context);
        this.f1682B = new aa(this);
    }

    private ad m3597a(View view) {
        if (view instanceof ad) {
            return (ad) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void m3598a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1680a);
        this.f1683b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1688g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1688g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1689h = z;
        this.f1704w = C0632w.m2776a(context);
    }

    private boolean m3600a(float f, float f2) {
        this.f1704w.m2780a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1704w.m2787e() > this.f1686e.getHeight();
    }

    private boolean m3602a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0793b c0793b = (C0793b) view.getLayoutParams();
        if (z && c0793b.leftMargin != rect.left) {
            c0793b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0793b.topMargin != rect.top) {
            c0793b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0793b.rightMargin != rect.right) {
            c0793b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0793b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0793b.bottomMargin = rect.bottom;
        return true;
    }

    private void m3605k() {
        removeCallbacks(this.f1707z);
        removeCallbacks(this.f1681A);
        if (this.f1705x != null) {
            this.f1705x.m2164b();
        }
    }

    private void m3606l() {
        m3605k();
        postDelayed(this.f1707z, 600);
    }

    private void m3607m() {
        m3605k();
        postDelayed(this.f1681A, 600);
    }

    private void m3608n() {
        m3605k();
        this.f1707z.run();
    }

    private void m3609o() {
        m3605k();
        this.f1681A.run();
    }

    public C0793b m3610a(AttributeSet attributeSet) {
        return new C0793b(getContext(), attributeSet);
    }

    public void m3611a(int i) {
        m3615c();
        switch (i) {
            case C1373c.View_paddingStart /*2*/:
                this.f1687f.m4541f();
            case C1373c.Toolbar_contentInsetStart /*5*/:
                this.f1687f.m4542g();
            case C1373c.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                setOverlayMode(true);
            default:
        }
    }

    public void m3612a(Menu menu, C0691a c0691a) {
        m3615c();
        this.f1687f.m4529a(menu, c0691a);
    }

    public boolean m3613a() {
        return this.f1690i;
    }

    protected C0793b m3614b() {
        return new C0793b(-1, -1);
    }

    void m3615c() {
        if (this.f1685d == null) {
            this.f1685d = (ContentFrameLayout) findViewById(C0725f.action_bar_activity_content);
            this.f1686e = (ActionBarContainer) findViewById(C0725f.action_bar_container);
            this.f1687f = m3597a(findViewById(C0725f.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0793b;
    }

    public boolean m3616d() {
        m3615c();
        return this.f1687f.m4543h();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1688g != null && !this.f1689h) {
            int bottom = this.f1686e.getVisibility() == 0 ? (int) ((((float) this.f1686e.getBottom()) + ah.m1947n(this.f1686e)) + 0.5f) : 0;
            this.f1688g.setBounds(0, bottom, getWidth(), this.f1688g.getIntrinsicHeight() + bottom);
            this.f1688g.draw(canvas);
        }
    }

    public boolean m3617e() {
        m3615c();
        return this.f1687f.m4544i();
    }

    public boolean m3618f() {
        m3615c();
        return this.f1687f.m4545j();
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m3615c();
        if ((ah.m1953t(this) & 256) != 0) {
            a = m3602a(this.f1686e, rect, true, true, false, true);
            this.f1699r.set(rect);
            bj.m4866a(this, this.f1699r, this.f1696o);
        } else {
            a = m3602a(this.f1686e, rect, true, true, false, true);
            this.f1699r.set(rect);
            bj.m4866a(this, this.f1699r, this.f1696o);
        }
        if (!this.f1697p.equals(this.f1696o)) {
            this.f1697p.set(this.f1696o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean m3619g() {
        m3615c();
        return this.f1687f.m4546k();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3614b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3610a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0793b(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.f1686e != null ? -((int) ah.m1947n(this.f1686e)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.f1682B.m1685a();
    }

    public CharSequence getTitle() {
        m3615c();
        return this.f1687f.m4540e();
    }

    public boolean m3620h() {
        m3615c();
        return this.f1687f.m4547l();
    }

    public void m3621i() {
        m3615c();
        this.f1687f.m4548m();
    }

    public void m3622j() {
        m3615c();
        this.f1687f.m4549n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m3598a(getContext());
        ah.m1954u(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3605k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0793b c0793b = (C0793b) childAt.getLayoutParams();
                int i6 = c0793b.leftMargin + paddingLeft;
                paddingRight = c0793b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        m3615c();
        measureChildWithMargins(this.f1686e, i, 0, i2, 0);
        C0793b c0793b = (C0793b) this.f1686e.getLayoutParams();
        int max = Math.max(0, (this.f1686e.getMeasuredWidth() + c0793b.leftMargin) + c0793b.rightMargin);
        int max2 = Math.max(0, c0793b.bottomMargin + (this.f1686e.getMeasuredHeight() + c0793b.topMargin));
        int a = bj.m4865a(0, ah.m1943j(this.f1686e));
        Object obj = (ah.m1953t(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f1683b;
            if (this.f1691j && this.f1686e.getTabContainer() != null) {
                i3 += this.f1683b;
            }
        } else {
            i3 = this.f1686e.getVisibility() != 8 ? this.f1686e.getMeasuredHeight() : 0;
        }
        this.f1698q.set(this.f1696o);
        this.f1700s.set(this.f1699r);
        Rect rect;
        Rect rect2;
        if (this.f1690i || obj != null) {
            rect = this.f1700s;
            rect.top = i3 + rect.top;
            rect2 = this.f1700s;
            rect2.bottom += 0;
        } else {
            rect = this.f1698q;
            rect.top = i3 + rect.top;
            rect2 = this.f1698q;
            rect2.bottom += 0;
        }
        m3602a(this.f1685d, this.f1698q, true, true, true, true);
        if (!this.f1701t.equals(this.f1700s)) {
            this.f1701t.set(this.f1700s);
            this.f1685d.m3046a(this.f1700s);
        }
        measureChildWithMargins(this.f1685d, i, 0, i2, 0);
        c0793b = (C0793b) this.f1685d.getLayoutParams();
        int max3 = Math.max(max, (this.f1685d.getMeasuredWidth() + c0793b.leftMargin) + c0793b.rightMargin);
        i3 = Math.max(max2, c0793b.bottomMargin + (this.f1685d.getMeasuredHeight() + c0793b.topMargin));
        int a2 = bj.m4865a(a, ah.m1943j(this.f1685d));
        setMeasuredDimension(ah.m1906a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ah.m1906a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1692k || !z) {
            return false;
        }
        if (m3600a(f, f2)) {
            m3609o();
        } else {
            m3608n();
        }
        this.f1693l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1694m += i2;
        setActionBarHideOffset(this.f1694m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1682B.m1687a(view, view2, i);
        this.f1694m = getActionBarHideOffset();
        m3605k();
        if (this.f1702u != null) {
            this.f1702u.m3145p();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.f1686e.getVisibility() != 0) ? false : this.f1692k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1692k && !this.f1693l) {
            if (this.f1694m <= this.f1686e.getHeight()) {
                m3606l();
            } else {
                m3607m();
            }
        }
        if (this.f1702u != null) {
            this.f1702u.m3146q();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3615c();
        int i2 = this.f1695n ^ i;
        this.f1695n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.f1702u != null) {
            C0718a c0718a = this.f1702u;
            if (z3) {
                z = false;
            }
            c0718a.m3142g(z);
            if (z2 || !z3) {
                this.f1702u.m3143n();
            } else {
                this.f1702u.m3144o();
            }
        }
        if ((i2 & 256) != 0 && this.f1702u != null) {
            ah.m1954u(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1684c = i;
        if (this.f1702u != null) {
            this.f1702u.m3141a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m3605k();
        ah.m1923b(this.f1686e, (float) (-Math.max(0, Math.min(i, this.f1686e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(C0718a c0718a) {
        this.f1702u = c0718a;
        if (getWindowToken() != null) {
            this.f1702u.m3141a(this.f1684c);
            if (this.f1695n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1695n);
                ah.m1954u(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1691j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1692k) {
            this.f1692k = z;
            if (!z) {
                m3605k();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        m3615c();
        this.f1687f.m4525a(i);
    }

    public void setIcon(Drawable drawable) {
        m3615c();
        this.f1687f.m4526a(drawable);
    }

    public void setLogo(int i) {
        m3615c();
        this.f1687f.m4534b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f1690i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1689h = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        m3615c();
        this.f1687f.m4530a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m3615c();
        this.f1687f.m4531a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
