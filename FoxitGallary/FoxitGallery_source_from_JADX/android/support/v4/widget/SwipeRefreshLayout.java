package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p016k.C0113x;
import android.support.v4.p016k.C0143z;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.C0564y;
import android.support.v4.p016k.aa;
import android.support.v4.p016k.ah;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public class SwipeRefreshLayout extends ViewGroup implements C0113x, C0143z {
    private static final String f898c;
    private static final int[] f899y;
    private int f900A;
    private float f901B;
    private C0615p f902C;
    private Animation f903D;
    private Animation f904E;
    private Animation f905F;
    private Animation f906G;
    private Animation f907H;
    private float f908I;
    private boolean f909J;
    private int f910K;
    private int f911L;
    private boolean f912M;
    private AnimationListener f913N;
    private final Animation f914O;
    private final Animation f915P;
    protected int f916a;
    protected int f917b;
    private View f918d;
    private C0577a f919e;
    private boolean f920f;
    private int f921g;
    private float f922h;
    private float f923i;
    private final aa f924j;
    private final C0564y f925k;
    private final int[] f926l;
    private final int[] f927m;
    private boolean f928n;
    private int f929o;
    private int f930p;
    private boolean f931q;
    private float f932r;
    private float f933s;
    private boolean f934t;
    private int f935u;
    private boolean f936v;
    private boolean f937w;
    private final DecelerateInterpolator f938x;
    private C0585b f939z;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.1 */
    class C05691 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f888a;

        C05691(SwipeRefreshLayout swipeRefreshLayout) {
            this.f888a = swipeRefreshLayout;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f888a.f920f) {
                this.f888a.f902C.setAlpha(255);
                this.f888a.f902C.start();
                if (this.f888a.f909J && this.f888a.f919e != null) {
                    this.f888a.f919e.onRefresh();
                }
                this.f888a.f930p = this.f888a.f939z.getTop();
                return;
            }
            this.f888a.m2468b();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.2 */
    class C05702 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f889a;

        C05702(SwipeRefreshLayout swipeRefreshLayout) {
            this.f889a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f889a.setAnimationProgress(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.3 */
    class C05713 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f890a;

        C05713(SwipeRefreshLayout swipeRefreshLayout) {
            this.f890a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f890a.setAnimationProgress(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.4 */
    class C05724 extends Animation {
        final /* synthetic */ int f891a;
        final /* synthetic */ int f892b;
        final /* synthetic */ SwipeRefreshLayout f893c;

        C05724(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
            this.f893c = swipeRefreshLayout;
            this.f891a = i;
            this.f892b = i2;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f893c.f902C.setAlpha((int) (((float) this.f891a) + (((float) (this.f892b - this.f891a)) * f)));
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.5 */
    class C05735 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f894a;

        C05735(SwipeRefreshLayout swipeRefreshLayout) {
            this.f894a = swipeRefreshLayout;
        }

        public void onAnimationEnd(Animation animation) {
            if (!this.f894a.f936v) {
                this.f894a.m2472b(null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.6 */
    class C05746 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f895a;

        C05746(SwipeRefreshLayout swipeRefreshLayout) {
            this.f895a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f895a.m2458a((((int) (((float) ((!this.f895a.f912M ? (int) (this.f895a.f908I - ((float) Math.abs(this.f895a.f917b))) : (int) this.f895a.f908I) - this.f895a.f916a)) * f)) + this.f895a.f916a) - this.f895a.f939z.getTop(), false);
            this.f895a.f902C.m2704a(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.7 */
    class C05757 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f896a;

        C05757(SwipeRefreshLayout swipeRefreshLayout) {
            this.f896a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f896a.m2474c(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.8 */
    class C05768 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f897a;

        C05768(SwipeRefreshLayout swipeRefreshLayout) {
            this.f897a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f897a.setAnimationProgress(this.f897a.f901B + ((-this.f897a.f901B) * f));
            this.f897a.m2474c(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout.a */
    public interface C0577a {
        void onRefresh();
    }

    static {
        f898c = SwipeRefreshLayout.class.getSimpleName();
        f899y = new int[]{16842766};
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f920f = false;
        this.f922h = -1.0f;
        this.f926l = new int[2];
        this.f927m = new int[2];
        this.f931q = false;
        this.f935u = -1;
        this.f900A = -1;
        this.f913N = new C05691(this);
        this.f914O = new C05746(this);
        this.f915P = new C05757(this);
        this.f921g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f929o = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f938x = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f899y);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f910K = (int) (displayMetrics.density * 40.0f);
        this.f911L = (int) (displayMetrics.density * 40.0f);
        m2473c();
        ah.m1920a((ViewGroup) this, true);
        this.f908I = displayMetrics.density * 64.0f;
        this.f922h = this.f908I;
        this.f924j = new aa(this);
        this.f925k = new C0564y(this);
        setNestedScrollingEnabled(true);
    }

    private float m2453a(MotionEvent motionEvent, int i) {
        int a = C0560t.m2393a(motionEvent, i);
        return a < 0 ? -1.0f : C0560t.m2398d(motionEvent, a);
    }

    private Animation m2455a(int i, int i2) {
        if (this.f936v && m2478d()) {
            return null;
        }
        Animation c05724 = new C05724(this, i, i2);
        c05724.setDuration(300);
        this.f939z.m2576a(null);
        this.f939z.clearAnimation();
        this.f939z.startAnimation(c05724);
        return c05724;
    }

    private void m2456a(float f) {
        this.f902C.m2707a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f922h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f922h;
        float f2 = this.f912M ? this.f908I - ((float) this.f917b) : this.f908I;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.f917b;
        if (this.f939z.getVisibility() != 0) {
            this.f939z.setVisibility(0);
        }
        if (!this.f936v) {
            ah.m1932d(this.f939z, 1.0f);
            ah.m1935e(this.f939z, 1.0f);
        }
        if (this.f936v) {
            setAnimationProgress(Math.min(1.0f, f / this.f922h));
        }
        if (f < this.f922h) {
            if (this.f902C.getAlpha() > 76 && !m2466a(this.f905F)) {
                m2480e();
            }
        } else if (this.f902C.getAlpha() < 255 && !m2466a(this.f906G)) {
            m2481f();
        }
        this.f902C.m2705a(0.0f, Math.min(0.8f, max * 0.8f));
        this.f902C.m2704a(Math.min(1.0f, max));
        this.f902C.m2709b(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        m2458a(i - this.f930p, true);
    }

    private void m2457a(int i, AnimationListener animationListener) {
        this.f916a = i;
        this.f914O.reset();
        this.f914O.setDuration(200);
        this.f914O.setInterpolator(this.f938x);
        if (animationListener != null) {
            this.f939z.m2576a(animationListener);
        }
        this.f939z.clearAnimation();
        this.f939z.startAnimation(this.f914O);
    }

    private void m2458a(int i, boolean z) {
        this.f939z.bringToFront();
        this.f939z.offsetTopAndBottom(i);
        this.f930p = this.f939z.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m2462a(MotionEvent motionEvent) {
        int b = C0560t.m2394b(motionEvent);
        if (C0560t.m2395b(motionEvent, b) == this.f935u) {
            this.f935u = C0560t.m2395b(motionEvent, b == 0 ? 1 : 0);
        }
    }

    private void m2463a(AnimationListener animationListener) {
        this.f939z.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f902C.setAlpha(255);
        }
        this.f903D = new C05702(this);
        this.f903D.setDuration((long) this.f929o);
        if (animationListener != null) {
            this.f939z.m2576a(animationListener);
        }
        this.f939z.clearAnimation();
        this.f939z.startAnimation(this.f903D);
    }

    private void m2464a(boolean z, boolean z2) {
        if (this.f920f != z) {
            this.f909J = z2;
            m2483g();
            this.f920f = z;
            if (this.f920f) {
                m2457a(this.f930p, this.f913N);
            } else {
                m2472b(this.f913N);
            }
        }
    }

    private boolean m2466a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void m2468b() {
        this.f939z.clearAnimation();
        this.f902C.stop();
        this.f939z.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f936v) {
            setAnimationProgress(0.0f);
        } else {
            m2458a(this.f917b - this.f930p, true);
        }
        this.f930p = this.f939z.getTop();
    }

    private void m2469b(float f) {
        if (f > this.f922h) {
            m2464a(true, true);
            return;
        }
        this.f920f = false;
        this.f902C.m2705a(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.f936v) {
            animationListener = new C05735(this);
        }
        m2470b(this.f930p, animationListener);
        this.f902C.m2707a(false);
    }

    private void m2470b(int i, AnimationListener animationListener) {
        if (this.f936v) {
            m2475c(i, animationListener);
            return;
        }
        this.f916a = i;
        this.f915P.reset();
        this.f915P.setDuration(200);
        this.f915P.setInterpolator(this.f938x);
        if (animationListener != null) {
            this.f939z.m2576a(animationListener);
        }
        this.f939z.clearAnimation();
        this.f939z.startAnimation(this.f915P);
    }

    private void m2472b(AnimationListener animationListener) {
        this.f904E = new C05713(this);
        this.f904E.setDuration(150);
        this.f939z.m2576a(animationListener);
        this.f939z.clearAnimation();
        this.f939z.startAnimation(this.f904E);
    }

    private void m2473c() {
        this.f939z = new C0585b(getContext(), -328966, 20.0f);
        this.f902C = new C0615p(getContext(), this);
        this.f902C.m2710b(-328966);
        this.f939z.setImageDrawable(this.f902C);
        this.f939z.setVisibility(8);
        addView(this.f939z);
    }

    private void m2474c(float f) {
        m2458a((this.f916a + ((int) (((float) (this.f917b - this.f916a)) * f))) - this.f939z.getTop(), false);
    }

    private void m2475c(int i, AnimationListener animationListener) {
        this.f916a = i;
        if (m2478d()) {
            this.f901B = (float) this.f902C.getAlpha();
        } else {
            this.f901B = ah.m1952s(this.f939z);
        }
        this.f907H = new C05768(this);
        this.f907H.setDuration(150);
        if (animationListener != null) {
            this.f939z.m2576a(animationListener);
        }
        this.f939z.clearAnimation();
        this.f939z.startAnimation(this.f907H);
    }

    private boolean m2478d() {
        return VERSION.SDK_INT < 11;
    }

    private void m2480e() {
        this.f905F = m2455a(this.f902C.getAlpha(), 76);
    }

    private void m2481f() {
        this.f906G = m2455a(this.f902C.getAlpha(), 255);
    }

    private void m2483g() {
        if (this.f918d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f939z)) {
                    i++;
                } else {
                    this.f918d = childAt;
                    return;
                }
            }
        }
    }

    private void setAnimationProgress(float f) {
        if (m2478d()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ah.m1932d(this.f939z, f);
        ah.m1935e(this.f939z, f);
    }

    private void setColorViewAlpha(int i) {
        this.f939z.getBackground().setAlpha(i);
        this.f902C.setAlpha(i);
    }

    public boolean m2488a() {
        boolean z = false;
        if (VERSION.SDK_INT >= 14) {
            return ah.m1926b(this.f918d, -1);
        }
        if (this.f918d instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f918d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (ah.m1926b(this.f918d, -1) || this.f918d.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f925k.m2411a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f925k.m2410a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f925k.m2414a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f925k.m2413a(i, i2, i3, i4, iArr);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.f900A < 0 ? i2 : i2 == i + -1 ? this.f900A : i2 >= this.f900A ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.f924j.m1685a();
    }

    public int getProgressCircleDiameter() {
        return this.f939z != null ? this.f939z.getMeasuredHeight() : 0;
    }

    public boolean hasNestedScrollingParent() {
        return this.f925k.m2415b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f925k.m2409a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2468b();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m2483g();
        int a = C0560t.m2392a(motionEvent);
        if (this.f937w && a == 0) {
            this.f937w = false;
        }
        if (!isEnabled() || this.f937w || m2488a() || this.f920f || this.f928n) {
            return false;
        }
        float a2;
        switch (a) {
            case C1373c.View_android_theme /*0*/:
                m2458a(this.f917b - this.f939z.getTop(), true);
                this.f935u = C0560t.m2395b(motionEvent, 0);
                this.f934t = false;
                a2 = m2453a(motionEvent, this.f935u);
                if (a2 != -1.0f) {
                    this.f933s = a2;
                    break;
                }
                return false;
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                this.f934t = false;
                this.f935u = -1;
                break;
            case C1373c.View_paddingStart /*2*/:
                if (this.f935u == -1) {
                    Log.e(f898c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = m2453a(motionEvent, this.f935u);
                if (a2 != -1.0f) {
                    if (a2 - this.f933s > ((float) this.f921g) && !this.f934t) {
                        this.f932r = this.f933s + ((float) this.f921g);
                        this.f934t = true;
                        this.f902C.setAlpha(76);
                        break;
                    }
                }
                return false;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                m2462a(motionEvent);
                break;
        }
        return this.f934t;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f918d == null) {
                m2483g();
            }
            if (this.f918d != null) {
                View view = this.f918d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f939z.getMeasuredWidth();
                this.f939z.layout((measuredWidth / 2) - (measuredHeight / 2), this.f930p, (measuredWidth / 2) + (measuredHeight / 2), this.f930p + this.f939z.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f918d == null) {
            m2483g();
        }
        if (this.f918d != null) {
            int i3;
            this.f918d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f939z.measure(MeasureSpec.makeMeasureSpec(this.f910K, 1073741824), MeasureSpec.makeMeasureSpec(this.f911L, 1073741824));
            if (!(this.f912M || this.f931q)) {
                this.f931q = true;
                i3 = -this.f939z.getMeasuredHeight();
                this.f917b = i3;
                this.f930p = i3;
            }
            this.f900A = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f939z) {
                    this.f900A = i3;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f923i > 0.0f) {
            if (((float) i2) > this.f923i) {
                iArr[1] = i2 - ((int) this.f923i);
                this.f923i = 0.0f;
            } else {
                this.f923i -= (float) i2;
                iArr[1] = i2;
            }
            m2456a(this.f923i);
        }
        if (this.f912M && i2 > 0 && this.f923i == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f939z.setVisibility(8);
        }
        int[] iArr2 = this.f926l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f927m);
        int i5 = this.f927m[1] + i4;
        if (i5 < 0 && !m2488a()) {
            this.f923i = ((float) Math.abs(i5)) + this.f923i;
            m2456a(this.f923i);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f924j.m1687a(view, view2, i);
        startNestedScroll(i & 2);
        this.f923i = 0.0f;
        this.f928n = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f937w || this.f920f || (i & 2) == 0) ? false : true;
    }

    public void onStopNestedScroll(View view) {
        this.f924j.m1686a(view);
        this.f928n = false;
        if (this.f923i > 0.0f) {
            m2469b(this.f923i);
            this.f923i = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0560t.m2392a(motionEvent);
        if (this.f937w && a == 0) {
            this.f937w = false;
        }
        if (!isEnabled() || this.f937w || m2488a() || this.f928n) {
            return false;
        }
        float d;
        switch (a) {
            case C1373c.View_android_theme /*0*/:
                this.f935u = C0560t.m2395b(motionEvent, 0);
                this.f934t = false;
                break;
            case C1373c.View_android_focusable /*1*/:
                a = C0560t.m2393a(motionEvent, this.f935u);
                if (a < 0) {
                    Log.e(f898c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                d = (C0560t.m2398d(motionEvent, a) - this.f932r) * 0.5f;
                this.f934t = false;
                m2469b(d);
                this.f935u = -1;
                return false;
            case C1373c.View_paddingStart /*2*/:
                a = C0560t.m2393a(motionEvent, this.f935u);
                if (a < 0) {
                    Log.e(f898c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                d = (C0560t.m2398d(motionEvent, a) - this.f932r) * 0.5f;
                if (this.f934t) {
                    if (d > 0.0f) {
                        m2456a(d);
                        break;
                    }
                    return false;
                }
                break;
            case C1373c.View_paddingEnd /*3*/:
                return false;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                a = C0560t.m2394b(motionEvent);
                if (a >= 0) {
                    this.f935u = C0560t.m2395b(motionEvent, a);
                    break;
                }
                Log.e(f898c, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                m2462a(motionEvent);
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.f918d instanceof AbsListView)) {
            return;
        }
        if (this.f918d == null || ah.m1899B(this.f918d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        m2483g();
        this.f902C.m2708a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f922h = (float) i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f925k.m2408a(z);
    }

    public void setOnRefreshListener(C0577a c0577a) {
        this.f919e = c0577a;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f939z.setBackgroundColor(i);
        this.f902C.m2710b(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f920f == z) {
            m2464a(z, false);
            return;
        }
        this.f920f = z;
        m2458a((!this.f912M ? (int) (this.f908I + ((float) this.f917b)) : (int) this.f908I) - this.f930p, true);
        this.f909J = false;
        m2463a(this.f913N);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.f910K = i2;
                this.f911L = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.f910K = i2;
                this.f911L = i2;
            }
            this.f939z.setImageDrawable(null);
            this.f902C.m2706a(i);
            this.f939z.setImageDrawable(this.f902C);
        }
    }

    public boolean startNestedScroll(int i) {
        return this.f925k.m2412a(i);
    }

    public void stopNestedScroll() {
        this.f925k.m2416c();
    }
}
