package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016k.C0113x;
import android.support.v4.p016k.C0143z;
import android.support.v4.p016k.C0473b;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.C0564y;
import android.support.v4.p016k.aa;
import android.support.v4.p016k.ad;
import android.support.v4.p016k.af;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.p031a.C0402a;
import android.support.v4.p016k.p031a.C0416c;
import android.support.v4.p016k.p031a.C0440k;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.List;

public class NestedScrollView extends FrameLayout implements ad, C0113x, C0143z {
    private static final C0565a f861v;
    private static final int[] f862w;
    private C0566b f863A;
    private long f864a;
    private final Rect f865b;
    private C0632w f866c;
    private C0604i f867d;
    private C0604i f868e;
    private int f869f;
    private boolean f870g;
    private boolean f871h;
    private View f872i;
    private boolean f873j;
    private VelocityTracker f874k;
    private boolean f875l;
    private boolean f876m;
    private int f877n;
    private int f878o;
    private int f879p;
    private int f880q;
    private final int[] f881r;
    private final int[] f882s;
    private int f883t;
    private C0568c f884u;
    private final aa f885x;
    private final C0564y f886y;
    private float f887z;

    /* renamed from: android.support.v4.widget.NestedScrollView.a */
    static class C0565a extends C0473b {
        C0565a() {
        }

        public void m2417a(View view, C0416c c0416c) {
            super.m2056a(view, c0416c);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0416c.m1572a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.getScrollRange();
                if (a > 0) {
                    c0416c.m1574a(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0416c.m1570a(8192);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        c0416c.m1570a(4096);
                    }
                }
            }
        }

        public boolean m2418a(View view, int i, Bundle bundle) {
            if (super.m2058a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2448b(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2448b(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void m2419d(View view, AccessibilityEvent accessibilityEvent) {
            super.m2062d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            C0440k a = C0402a.m1482a(accessibilityEvent);
            a.m1670a(nestedScrollView.getScrollRange() > 0);
            a.m1673d(nestedScrollView.getScrollX());
            a.m1674e(nestedScrollView.getScrollY());
            a.m1675f(nestedScrollView.getScrollX());
            a.m1676g(nestedScrollView.getScrollRange());
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView.b */
    public interface C0566b {
        void m2420a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.v4.widget.NestedScrollView.c */
    static class C0568c extends BaseSavedState {
        public static final Creator<C0568c> CREATOR;
        public int f860a;

        /* renamed from: android.support.v4.widget.NestedScrollView.c.1 */
        static class C05671 implements Creator<C0568c> {
            C05671() {
            }

            public C0568c m2421a(Parcel parcel) {
                return new C0568c(parcel);
            }

            public C0568c[] m2422a(int i) {
                return new C0568c[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2421a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2422a(i);
            }
        }

        static {
            CREATOR = new C05671();
        }

        public C0568c(Parcel parcel) {
            super(parcel);
            this.f860a = parcel.readInt();
        }

        C0568c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f860a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f860a);
        }
    }

    static {
        f861v = new C0565a();
        f862w = new int[]{16843130};
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f865b = new Rect();
        this.f870g = true;
        this.f871h = false;
        this.f872i = null;
        this.f873j = false;
        this.f876m = true;
        this.f880q = -1;
        this.f881r = new int[2];
        this.f882s = new int[2];
        m2425a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f862w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f885x = new aa(this);
        this.f886y = new C0564y(this);
        setNestedScrollingEnabled(true);
        ah.m1916a((View) this, f861v);
    }

    private View m2424a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    private void m2425a() {
        this.f866c = C0632w.m2777a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f877n = viewConfiguration.getScaledTouchSlop();
        this.f878o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f879p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void m2426a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (C0560t.m2395b(motionEvent, action) == this.f880q) {
            action = action == 0 ? 1 : 0;
            this.f869f = (int) C0560t.m2398d(motionEvent, action);
            this.f880q = C0560t.m2395b(motionEvent, action);
            if (this.f874k != null) {
                this.f874k.clear();
            }
        }
    }

    private boolean m2427a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2424a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2439e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m2428a(Rect rect, boolean z) {
        int a = m2443a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2444a(0, a);
            }
        }
        return z2;
    }

    private boolean m2429a(View view) {
        return !m2430a(view, 0, getHeight());
    }

    private boolean m2430a(View view, int i, int i2) {
        view.getDrawingRect(this.f865b);
        offsetDescendantRectToMyCoords(view, this.f865b);
        return this.f865b.bottom + i >= getScrollY() && this.f865b.top - i <= getScrollY() + i2;
    }

    private static boolean m2431a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2431a((View) parent, view2);
        return z;
    }

    private static int m2432b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void m2433b(View view) {
        view.getDrawingRect(this.f865b);
        offsetDescendantRectToMyCoords(view, this.f865b);
        int a = m2443a(this.f865b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2434b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    private void m2435c() {
        if (this.f874k == null) {
            this.f874k = VelocityTracker.obtain();
        } else {
            this.f874k.clear();
        }
    }

    private boolean m2436c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void m2437d() {
        if (this.f874k == null) {
            this.f874k = VelocityTracker.obtain();
        }
    }

    private void m2438e() {
        if (this.f874k != null) {
            this.f874k.recycle();
            this.f874k = null;
        }
    }

    private void m2439e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f876m) {
            m2444a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void m2440f() {
        this.f873j = false;
        m2438e();
        stopNestedScroll();
        if (this.f867d != null) {
            this.f867d.m2644c();
            this.f868e.m2644c();
        }
    }

    private void m2441f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2451d(i);
            }
        }
    }

    private void m2442g() {
        if (ah.m1907a(this) == 2) {
            this.f867d = null;
            this.f868e = null;
        } else if (this.f867d == null) {
            Context context = getContext();
            this.f867d = new C0604i(context);
            this.f868e = new C0604i(context);
        }
    }

    private int getScrollRange() {
        return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f887z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f887z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f887z;
    }

    protected int m2443a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            scrollY = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            scrollY = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return scrollY;
    }

    public final void m2444a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f864a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f866c.m2778a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ah.m1931d(this);
            } else {
                if (!this.f866c.m2782a()) {
                    this.f866c.m2790h();
                }
                scrollBy(i, i2);
            }
            this.f864a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean m2445a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f865b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f865b.top + height > childAt.getBottom()) {
                    this.f865b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f865b.top = getScrollY() - height;
            if (this.f865b.top < 0) {
                this.f865b.top = 0;
            }
        }
        this.f865b.bottom = this.f865b.top + height;
        return m2427a(i, this.f865b.top, this.f865b.bottom);
    }

    boolean m2446a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = ah.m1907a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f866c.m2783a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        return z2 || z3;
    }

    public boolean m2447a(KeyEvent keyEvent) {
        int i = 33;
        this.f865b.setEmpty();
        if (m2434b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case C1373c.Toolbar_titleMargins /*19*/:
                    return !keyEvent.isAltPressed() ? m2450c(33) : m2449b(33);
                case C1373c.Toolbar_maxButtonHeight /*20*/:
                    return !keyEvent.isAltPressed() ? m2450c(130) : m2449b(130);
                case C1373c.AppCompatTheme_popupWindowStyle /*62*/:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2445a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            boolean z = (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) ? false : true;
            return z;
        }
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void m2448b(int i, int i2) {
        m2444a(i - getScrollX(), i2 - getScrollY());
    }

    public boolean m2449b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f865b.top = 0;
        this.f865b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f865b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f865b.top = this.f865b.bottom - height;
            }
        }
        return m2427a(i, this.f865b.top, this.f865b.bottom);
    }

    public boolean m2450c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2430a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2439e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f865b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f865b);
            m2439e(m2443a(this.f865b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2429a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.f866c.m2789g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f866c.m2784b();
            int c = this.f866c.m2785c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = ah.m1907a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m2446a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2442g();
                    if (c <= 0 && scrollY > 0) {
                        this.f867d.m2641a((int) this.f866c.m2788f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f868e.m2641a((int) this.f866c.m2788f());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > height ? bottom + (scrollY - height) : bottom;
    }

    public void m2451d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f866c.m2781a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ah.m1931d(this);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2447a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f886y.m2411a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f886y.m2410a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f886y.m2414a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f886y.m2413a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f867d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f867d.m2638a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f867d.m2637a(width, getHeight());
                if (this.f867d.m2642a(canvas)) {
                    ah.m1931d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f868e.m2638a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f868e.m2637a(width, height);
                if (this.f868e.m2642a(canvas)) {
                    ah.m1931d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.f885x.m1685a();
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.f886y.m2415b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f886y.m2409a();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f871h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((C0560t.m2399d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case C1373c.Toolbar_contentInsetRight /*8*/:
                if (this.f873j) {
                    return false;
                }
                float e = C0560t.m2400e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f873j) {
            return true;
        }
        switch (action & 255) {
            case C1373c.View_android_theme /*0*/:
                action = (int) motionEvent.getY();
                if (!m2436c((int) motionEvent.getX(), action)) {
                    this.f873j = false;
                    m2438e();
                    break;
                }
                this.f869f = action;
                this.f880q = C0560t.m2395b(motionEvent, 0);
                m2435c();
                this.f874k.addMovement(motionEvent);
                this.f866c.m2789g();
                if (!this.f866c.m2782a()) {
                    z = true;
                }
                this.f873j = z;
                startNestedScroll(2);
                break;
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                this.f873j = false;
                this.f880q = -1;
                m2438e();
                if (this.f866c.m2783a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ah.m1931d(this);
                }
                stopNestedScroll();
                break;
            case C1373c.View_paddingStart /*2*/:
                action = this.f880q;
                if (action != -1) {
                    int a = C0560t.m2393a(motionEvent, action);
                    if (a != -1) {
                        action = (int) C0560t.m2398d(motionEvent, a);
                        if (Math.abs(action - this.f869f) > this.f877n && (getNestedScrollAxes() & 2) == 0) {
                            this.f873j = true;
                            this.f869f = action;
                            m2437d();
                            this.f874k.addMovement(motionEvent);
                            this.f883t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                m2426a(motionEvent);
                break;
        }
        return this.f873j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f870g = false;
        if (this.f872i != null && m2431a(this.f872i, (View) this)) {
            m2433b(this.f872i);
        }
        this.f872i = null;
        if (!this.f871h) {
            if (this.f884u != null) {
                scrollTo(getScrollX(), this.f884u.f860a);
                this.f884u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f871h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f875l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2441f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f885x.m1687a(view, view2, i);
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || m2429a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0568c) {
            C0568c c0568c = (C0568c) parcelable;
            super.onRestoreInstanceState(c0568c.getSuperState());
            this.f884u = c0568c;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0568c = new C0568c(super.onSaveInstanceState());
        c0568c.f860a = getScrollY();
        return c0568c;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f863A != null) {
            this.f863A.m2420a(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2430a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f865b);
            offsetDescendantRectToMyCoords(findFocus, this.f865b);
            m2439e(m2443a(this.f865b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f885x.m1686a(view);
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2437d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0560t.m2392a(motionEvent);
        if (a == 0) {
            this.f883t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f883t);
        switch (a) {
            case C1373c.View_android_theme /*0*/:
                if (getChildCount() != 0) {
                    boolean z = !this.f866c.m2782a();
                    this.f873j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f866c.m2782a()) {
                        this.f866c.m2790h();
                    }
                    this.f869f = (int) motionEvent.getY();
                    this.f880q = C0560t.m2395b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case C1373c.View_android_focusable /*1*/:
                if (this.f873j) {
                    VelocityTracker velocityTracker = this.f874k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f879p);
                    a = (int) af.m1695b(velocityTracker, this.f880q);
                    if (Math.abs(a) > this.f878o) {
                        m2441f(-a);
                    } else if (this.f866c.m2783a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ah.m1931d(this);
                    }
                }
                this.f880q = -1;
                m2440f();
                break;
            case C1373c.View_paddingStart /*2*/:
                int a2 = C0560t.m2393a(motionEvent, this.f880q);
                if (a2 != -1) {
                    int i;
                    int d = (int) C0560t.m2398d(motionEvent, a2);
                    a = this.f869f - d;
                    if (dispatchNestedPreScroll(0, a, this.f882s, this.f881r)) {
                        a -= this.f882s[1];
                        obtain.offsetLocation(0.0f, (float) this.f881r[1]);
                        this.f883t += this.f881r[1];
                    }
                    if (this.f873j || Math.abs(a) <= this.f877n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f873j = true;
                        i = a > 0 ? a - this.f877n : a + this.f877n;
                    }
                    if (this.f873j) {
                        this.f869f = d - this.f881r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = ah.m1907a(this);
                        Object obj = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : null;
                        if (m2446a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f874k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f881r)) {
                            if (obj != null) {
                                m2442g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f867d.m2640a(((float) i) / ((float) getHeight()), C0560t.m2396c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f868e.m2638a()) {
                                        this.f868e.m2644c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f868e.m2640a(((float) i) / ((float) getHeight()), 1.0f - (C0560t.m2396c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f867d.m2638a()) {
                                        this.f867d.m2644c();
                                    }
                                }
                                if (!(this.f867d == null || (this.f867d.m2638a() && this.f868e.m2638a()))) {
                                    ah.m1931d(this);
                                    break;
                                }
                            }
                        }
                        this.f869f -= this.f881r[1];
                        obtain.offsetLocation(0.0f, (float) this.f881r[1]);
                        this.f883t += this.f881r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f880q + " in onTouchEvent");
                break;
                break;
            case C1373c.View_paddingEnd /*3*/:
                if (this.f873j && getChildCount() > 0 && this.f866c.m2783a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ah.m1931d(this);
                }
                this.f880q = -1;
                m2440f();
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                a = C0560t.m2394b(motionEvent);
                this.f869f = (int) C0560t.m2398d(motionEvent, a);
                this.f880q = C0560t.m2395b(motionEvent, a);
                break;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                m2426a(motionEvent);
                this.f869f = (int) C0560t.m2398d(motionEvent, C0560t.m2393a(motionEvent, this.f880q));
                break;
        }
        if (this.f874k != null) {
            this.f874k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f870g) {
            this.f872i = view2;
        } else {
            m2433b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2428a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2438e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f870g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2432b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2432b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f875l) {
            this.f875l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f886y.m2408a(z);
    }

    public void setOnScrollChangeListener(C0566b c0566b) {
        this.f863A = c0566b;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f876m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.f886y.m2412a(i);
    }

    public void stopNestedScroll() {
        this.f886y.m2416c();
    }
}
