package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0114p;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0769h.C0676a;
import android.support.v7.view.menu.C0769h.C0753b;
import android.support.v7.view.menu.C0772j;
import android.support.v7.widget.ak.C0796a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends ak implements C0753b, C0114p {
    private C0769h f1718a;
    private Context f1719b;
    private int f1720c;
    private boolean f1721d;
    private C0931d f1722e;
    private C0691a f1723f;
    private C0676a f1724g;
    private boolean f1725h;
    private int f1726i;
    private int f1727j;
    private int f1728k;
    private C0799e f1729l;

    /* renamed from: android.support.v7.widget.ActionMenuView.a */
    public interface C0752a {
        boolean m3291c();

        boolean m3292d();
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.b */
    private class C0795b implements C0691a {
        final /* synthetic */ ActionMenuView f1708a;

        private C0795b(ActionMenuView actionMenuView) {
            this.f1708a = actionMenuView;
        }

        public void m3623a(C0769h c0769h, boolean z) {
        }

        public boolean m3624a(C0769h c0769h) {
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.c */
    public static class C0797c extends C0796a {
        @ExportedProperty
        public boolean f1711a;
        @ExportedProperty
        public int f1712b;
        @ExportedProperty
        public int f1713c;
        @ExportedProperty
        public boolean f1714d;
        @ExportedProperty
        public boolean f1715e;
        boolean f1716f;

        public C0797c(int i, int i2) {
            super(i, i2);
            this.f1711a = false;
        }

        public C0797c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0797c(C0797c c0797c) {
            super(c0797c);
            this.f1711a = c0797c.f1711a;
        }

        public C0797c(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.d */
    private class C0798d implements C0676a {
        final /* synthetic */ ActionMenuView f1717a;

        private C0798d(ActionMenuView actionMenuView) {
            this.f1717a = actionMenuView;
        }

        public void m3625a(C0769h c0769h) {
            if (this.f1717a.f1724g != null) {
                this.f1717a.f1724g.m2944a(c0769h);
            }
        }

        public boolean m3626a(C0769h c0769h, MenuItem menuItem) {
            return this.f1717a.f1729l != null && this.f1717a.f1729l.m3627a(menuItem);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.e */
    public interface C0799e {
        boolean m3627a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1727j = (int) (56.0f * f);
        this.f1728k = (int) (f * 4.0f);
        this.f1719b = context;
        this.f1720c = 0;
    }

    static int m3628a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0797c c0797c = (C0797c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m3300b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0797c.f1711a && z2) {
            z = true;
        }
        c0797c.f1714d = z;
        c0797c.f1712b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void m3631c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1727j;
        size = i3 % this.f1727j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        Object obj;
        int i5 = this.f1727j + (size / i4);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        paddingLeft = 0;
        Object obj2 = null;
        long j = 0;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            int i10;
            long j2;
            int i11;
            int i12;
            int i13;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                i10 = paddingLeft;
                j2 = j;
                i11 = i6;
                i12 = i4;
                i4 = i7;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i13 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1728k, 0, this.f1728k, 0);
                }
                C0797c c0797c = (C0797c) childAt.getLayoutParams();
                c0797c.f1716f = false;
                c0797c.f1713c = 0;
                c0797c.f1712b = 0;
                c0797c.f1714d = false;
                c0797c.leftMargin = 0;
                c0797c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m3300b();
                c0797c.f1715e = z2;
                int a = m3628a(childAt, i5, c0797c.f1711a ? 1 : i4, childMeasureSpec, paddingTop);
                i7 = Math.max(i7, a);
                paddingLeft = c0797c.f1714d ? i8 + 1 : i8;
                obj = c0797c.f1711a ? 1 : obj2;
                int i14 = i4 - a;
                i8 = Math.max(i6, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i9)) | j;
                    i11 = i8;
                    i12 = i14;
                    i8 = paddingLeft;
                    obj2 = obj;
                    j2 = j3;
                    i4 = i7;
                    i10 = i13;
                } else {
                    i10 = i13;
                    i4 = i7;
                    long j4 = j;
                    i11 = i8;
                    i12 = i14;
                    obj2 = obj;
                    i8 = paddingLeft;
                    j2 = j4;
                }
            }
            i9++;
            i7 = i4;
            i6 = i11;
            i4 = i12;
            j = j2;
            paddingLeft = i10;
        }
        Object obj3 = (obj2 == null || paddingLeft != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i8 > 0 && paddingTop > 0) {
            i13 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0797c = (C0797c) getChildAt(i15).getLayoutParams();
                if (c0797c.f1714d) {
                    int i16 = c0797c.f1712b;
                    if (r0 < i13) {
                        i4 = c0797c.f1712b;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (c0797c.f1712b == i13) {
                        j |= (long) (1 << i15);
                        size = i4 + 1;
                        i4 = i13;
                    } else {
                        size = i4;
                        i4 = i13;
                    }
                } else {
                    size = i4;
                    i4 = i13;
                }
                i15++;
                i13 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i13 + 1;
            i13 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i13 < childCount) {
                View childAt2 = getChildAt(i13);
                c0797c = (C0797c) childAt2.getLayoutParams();
                if ((((long) (1 << i13)) & j) != 0) {
                    if (obj3 != null && c0797c.f1715e && i4 == 1) {
                        childAt2.setPadding(this.f1728k + i5, 0, this.f1728k, 0);
                    }
                    c0797c.f1712b++;
                    c0797c.f1716f = true;
                    size = i4 - 1;
                } else if (c0797c.f1712b == i15) {
                    j6 |= (long) (1 << i13);
                    size = i4;
                } else {
                    size = i4;
                }
                i13++;
                i4 = size;
            }
            j5 = j6;
            i9 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj2 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i7 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0797c) getChildAt(0).getLayoutParams()).f1715e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0797c) getChildAt(childCount - 1).getLayoutParams()).f1715e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i5)) / f) : 0;
                    i4 = 0;
                    obj3 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj3;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0797c = (C0797c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0797c.f1713c = paddingLeft;
                                c0797c.f1716f = true;
                                if (i4 == 0 && !c0797c.f1715e) {
                                    c0797c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0797c.f1711a) {
                                if (i4 != 0) {
                                    c0797c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0797c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj3;
                            } else {
                                c0797c.f1713c = paddingLeft;
                                c0797c.f1716f = true;
                                c0797c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj3 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0797c = (C0797c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0797c.f1713c = paddingLeft;
                        c0797c.f1716f = true;
                        c0797c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0797c.f1711a) {
                        if (i4 != 0) {
                            c0797c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0797c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj3;
                    } else {
                        c0797c.f1713c = paddingLeft;
                        c0797c.f1716f = true;
                        c0797c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj3;
                }
                i4++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0797c = (C0797c) childAt.getLayoutParams();
                if (c0797c.f1716f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0797c.f1713c + (c0797c.f1712b * i5), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i6 = size2;
        }
        setMeasuredDimension(i3, i6);
    }

    public C0797c m3632a(AttributeSet attributeSet) {
        return new C0797c(getContext(), attributeSet);
    }

    protected C0797c m3633a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m3639b();
        }
        C0797c c0797c = layoutParams instanceof C0797c ? new C0797c((C0797c) layoutParams) : new C0797c(layoutParams);
        if (c0797c.h > 0) {
            return c0797c;
        }
        c0797c.h = 16;
        return c0797c;
    }

    public void m3634a(C0769h c0769h) {
        this.f1718a = c0769h;
    }

    public void m3635a(C0691a c0691a, C0676a c0676a) {
        this.f1723f = c0691a;
        this.f1724g = c0676a;
    }

    public boolean m3636a() {
        return this.f1721d;
    }

    protected boolean m3637a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0752a)) {
            z = 0 | ((C0752a) childAt).m3292d();
        }
        return (i <= 0 || !(childAt2 instanceof C0752a)) ? z : ((C0752a) childAt2).m3291c() | z;
    }

    public boolean m3638a(C0772j c0772j) {
        return this.f1718a.m3443a((MenuItem) c0772j, 0);
    }

    protected C0797c m3639b() {
        C0797c c0797c = new C0797c(-2, -2);
        c0797c.h = 16;
        return c0797c;
    }

    public /* synthetic */ C0796a m3640b(AttributeSet attributeSet) {
        return m3632a(attributeSet);
    }

    protected /* synthetic */ C0796a m3641b(LayoutParams layoutParams) {
        return m3633a(layoutParams);
    }

    public C0797c m3642c() {
        C0797c b = m3639b();
        b.f1711a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0797c);
    }

    public C0769h m3643d() {
        return this.f1718a;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean m3644e() {
        return this.f1722e != null && this.f1722e.m4910d();
    }

    public boolean m3645f() {
        return this.f1722e != null && this.f1722e.m4911e();
    }

    public boolean m3646g() {
        return this.f1722e != null && this.f1722e.m4914h();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3639b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3632a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3633a(layoutParams);
    }

    public Menu getMenu() {
        if (this.f1718a == null) {
            Context context = getContext();
            this.f1718a = new C0769h(context);
            this.f1718a.m3435a(new C0798d());
            this.f1722e = new C0931d(context);
            this.f1722e.m4908c(true);
            this.f1722e.m3333a(this.f1723f != null ? this.f1723f : new C0795b());
            this.f1718a.m3438a(this.f1722e, this.f1719b);
            this.f1722e.m4900a(this);
        }
        return this.f1718a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1722e.m4907c();
    }

    public int getPopupTheme() {
        return this.f1720c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean m3647h() {
        return this.f1722e != null && this.f1722e.m4915i();
    }

    public void m3648i() {
        if (this.f1722e != null) {
            this.f1722e.m4912f();
        }
    }

    protected /* synthetic */ C0796a m3649j() {
        return m3639b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1722e != null) {
            this.f1722e.m4905b(false);
            if (this.f1722e.m4914h()) {
                this.f1722e.m4911e();
                this.f1722e.m4910d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3648i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1725h) {
            int i5;
            int i6;
            C0797c c0797c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bj.m4867a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0797c = (C0797c) childAt.getLayoutParams();
                    if (c0797c.f1711a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m3637a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0797c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0797c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0797c.leftMargin) + c0797c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m3637a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0797c = (C0797c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0797c.f1711a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0797c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0797c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0797c = (C0797c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0797c.f1711a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0797c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0797c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1725h;
        this.f1725h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1725h) {
            this.f1726i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1725h || this.f1718a == null || size == this.f1726i)) {
            this.f1726i = size;
            this.f1718a.m3449b(true);
        }
        int childCount = getChildCount();
        if (!this.f1725h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0797c c0797c = (C0797c) getChildAt(i3).getLayoutParams();
                c0797c.rightMargin = 0;
                c0797c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m3631c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1722e.m4909d(z);
    }

    public void setOnMenuItemClickListener(C0799e c0799e) {
        this.f1729l = c0799e;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1722e.m4897a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f1721d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1720c != i) {
            this.f1720c = i;
            if (i == 0) {
                this.f1719b = getContext();
            } else {
                this.f1719b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0931d c0931d) {
        this.f1722e = c0931d;
        this.f1722e.m4900a(this);
    }
}
