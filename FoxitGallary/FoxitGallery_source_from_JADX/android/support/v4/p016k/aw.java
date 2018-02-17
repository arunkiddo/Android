package android.support.v4.p016k;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p016k.p031a.C0402a;
import android.support.v4.p016k.p031a.C0416c;
import android.support.v4.p016k.p031a.C0440k;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;
import android.support.v4.widget.C0604i;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: android.support.v4.k.aw */
public class aw extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<C0471b> COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final C0481j sPositionComparator;
    private int mActivePointerId;
    private ac mAdapter;
    private List<C0475e> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private C0476f mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<C0471b> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private C0604i mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private C0478h mObserver;
    private int mOffscreenPageLimit;
    private C0476f mOnPageChangeListener;
    private List<C0476f> mOnPageChangeListeners;
    private int mPageMargin;
    private C0477g mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private C0604i mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final C0471b mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v4.k.aw.1 */
    static class C04661 implements Comparator<C0471b> {
        C04661() {
        }

        public int m2051a(C0471b c0471b, C0471b c0471b2) {
            return c0471b.f795b - c0471b2.f795b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2051a((C0471b) obj, (C0471b) obj2);
        }
    }

    /* renamed from: android.support.v4.k.aw.2 */
    static class C04672 implements Interpolator {
        C04672() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.k.aw.3 */
    class C04683 implements Runnable {
        final /* synthetic */ aw f791a;

        C04683(aw awVar) {
            this.f791a = awVar;
        }

        public void run() {
            this.f791a.setScrollState(aw.SCROLL_STATE_IDLE);
            this.f791a.populate();
        }
    }

    /* renamed from: android.support.v4.k.aw.4 */
    class C04694 implements ab {
        final /* synthetic */ aw f792a;
        private final Rect f793b;

        C04694(aw awVar) {
            this.f792a = awVar;
            this.f793b = new Rect();
        }

        public bg m2052a(View view, bg bgVar) {
            bg a = ah.m1908a(view, bgVar);
            if (a.m2251e()) {
                return a;
            }
            Rect rect = this.f793b;
            rect.left = a.m2246a();
            rect.top = a.m2248b();
            rect.right = a.m2249c();
            rect.bottom = a.m2250d();
            int childCount = this.f792a.getChildCount();
            for (int i = aw.SCROLL_STATE_IDLE; i < childCount; i += aw.SCROLL_STATE_DRAGGING) {
                bg b = ah.m1922b(this.f792a.getChildAt(i), a);
                rect.left = Math.min(b.m2246a(), rect.left);
                rect.top = Math.min(b.m2248b(), rect.top);
                rect.right = Math.min(b.m2249c(), rect.right);
                rect.bottom = Math.min(b.m2250d(), rect.bottom);
            }
            return a.m2247a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.v4.k.aw.a */
    public @interface C0470a {
    }

    /* renamed from: android.support.v4.k.aw.b */
    static class C0471b {
        Object f794a;
        int f795b;
        boolean f796c;
        float f797d;
        float f798e;

        C0471b() {
        }
    }

    /* renamed from: android.support.v4.k.aw.c */
    public static class C0472c extends LayoutParams {
        public boolean f799a;
        public int f800b;
        float f801c;
        boolean f802d;
        int f803e;
        int f804f;

        public C0472c() {
            super(aw.INVALID_POINTER, aw.INVALID_POINTER);
            this.f801c = 0.0f;
        }

        public C0472c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f801c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aw.LAYOUT_ATTRS);
            this.f800b = obtainStyledAttributes.getInteger(aw.SCROLL_STATE_IDLE, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v4.k.aw.d */
    class C0474d extends C0473b {
        final /* synthetic */ aw f808b;

        C0474d(aw awVar) {
            this.f808b = awVar;
        }

        private boolean m2063b() {
            return (this.f808b.mAdapter == null || this.f808b.mAdapter.getCount() <= aw.SCROLL_STATE_DRAGGING) ? aw.DEBUG : true;
        }

        public void m2064a(View view, C0416c c0416c) {
            super.m2056a(view, c0416c);
            c0416c.m1572a(aw.class.getName());
            c0416c.m1574a(m2063b());
            if (this.f808b.canScrollHorizontally(aw.SCROLL_STATE_DRAGGING)) {
                c0416c.m1570a(4096);
            }
            if (this.f808b.canScrollHorizontally(aw.INVALID_POINTER)) {
                c0416c.m1570a(8192);
            }
        }

        public boolean m2065a(View view, int i, Bundle bundle) {
            if (super.m2058a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.f808b.canScrollHorizontally(aw.SCROLL_STATE_DRAGGING)) {
                        return aw.DEBUG;
                    }
                    this.f808b.setCurrentItem(this.f808b.mCurItem + aw.SCROLL_STATE_DRAGGING);
                    return true;
                case 8192:
                    if (!this.f808b.canScrollHorizontally(aw.INVALID_POINTER)) {
                        return aw.DEBUG;
                    }
                    this.f808b.setCurrentItem(this.f808b.mCurItem + aw.INVALID_POINTER);
                    return true;
                default:
                    return aw.DEBUG;
            }
        }

        public void m2066d(View view, AccessibilityEvent accessibilityEvent) {
            super.m2062d(view, accessibilityEvent);
            accessibilityEvent.setClassName(aw.class.getName());
            C0440k a = C0402a.m1482a(accessibilityEvent);
            a.m1670a(m2063b());
            if (accessibilityEvent.getEventType() == 4096 && this.f808b.mAdapter != null) {
                a.m1669a(this.f808b.mAdapter.getCount());
                a.m1671b(this.f808b.mCurItem);
                a.m1672c(this.f808b.mCurItem);
            }
        }
    }

    /* renamed from: android.support.v4.k.aw.e */
    public interface C0475e {
        void m2067a(aw awVar, ac acVar, ac acVar2);
    }

    /* renamed from: android.support.v4.k.aw.f */
    public interface C0476f {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: android.support.v4.k.aw.g */
    public interface C0477g {
        void m2068a(View view, float f);
    }

    /* renamed from: android.support.v4.k.aw.h */
    private class C0478h extends DataSetObserver {
        final /* synthetic */ aw f809a;

        private C0478h(aw awVar) {
            this.f809a = awVar;
        }

        public void onChanged() {
            this.f809a.dataSetChanged();
        }

        public void onInvalidated() {
            this.f809a.dataSetChanged();
        }
    }

    /* renamed from: android.support.v4.k.aw.i */
    public static class C0480i extends C0120a {
        public static final Creator<C0480i> CREATOR;
        int f810a;
        Parcelable f811b;
        ClassLoader f812c;

        /* renamed from: android.support.v4.k.aw.i.1 */
        static class C04791 implements C0118e<C0480i> {
            C04791() {
            }

            public C0480i m2069a(Parcel parcel, ClassLoader classLoader) {
                return new C0480i(parcel, classLoader);
            }

            public C0480i[] m2070a(int i) {
                return new C0480i[i];
            }

            public /* synthetic */ Object m2071b(Parcel parcel, ClassLoader classLoader) {
                return m2069a(parcel, classLoader);
            }

            public /* synthetic */ Object[] m2072b(int i) {
                return m2070a(i);
            }
        }

        static {
            CREATOR = C0356d.m1329a(new C04791());
        }

        C0480i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f810a = parcel.readInt();
            this.f811b = parcel.readParcelable(classLoader);
            this.f812c = classLoader;
        }

        public C0480i(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f810a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f810a);
            parcel.writeParcelable(this.f811b, i);
        }
    }

    /* renamed from: android.support.v4.k.aw.j */
    static class C0481j implements Comparator<View> {
        C0481j() {
        }

        public int m2073a(View view, View view2) {
            C0472c c0472c = (C0472c) view.getLayoutParams();
            C0472c c0472c2 = (C0472c) view2.getLayoutParams();
            return c0472c.f799a != c0472c2.f799a ? c0472c.f799a ? aw.SCROLL_STATE_DRAGGING : aw.INVALID_POINTER : c0472c.f803e - c0472c2.f803e;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2073a((View) obj, (View) obj2);
        }
    }

    static {
        int[] iArr = new int[SCROLL_STATE_DRAGGING];
        iArr[SCROLL_STATE_IDLE] = 16842931;
        LAYOUT_ATTRS = iArr;
        COMPARATOR = new C04661();
        sInterpolator = new C04672();
        sPositionComparator = new C0481j();
    }

    public aw(Context context) {
        super(context);
        this.mItems = new ArrayList();
        this.mTempItem = new C0471b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = INVALID_POINTER;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = SCROLL_STATE_DRAGGING;
        this.mActivePointerId = INVALID_POINTER;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = DEBUG;
        this.mEndScrollRunnable = new C04683(this);
        this.mScrollState = SCROLL_STATE_IDLE;
        initViewPager();
    }

    public aw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList();
        this.mTempItem = new C0471b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = INVALID_POINTER;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = SCROLL_STATE_DRAGGING;
        this.mActivePointerId = INVALID_POINTER;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = DEBUG;
        this.mEndScrollRunnable = new C04683(this);
        this.mScrollState = SCROLL_STATE_IDLE;
        initViewPager();
    }

    private void calculatePageOffsets(C0471b c0471b, int i, C0471b c0471b2) {
        float f;
        int i2;
        C0471b c0471b3;
        int i3;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (c0471b2 != null) {
            clientWidth = c0471b2.f795b;
            int i4;
            if (clientWidth < c0471b.f795b) {
                f = (c0471b2.f798e + c0471b2.f797d) + f2;
                i4 = clientWidth + SCROLL_STATE_DRAGGING;
                i2 = SCROLL_STATE_IDLE;
                while (i4 <= c0471b.f795b && i2 < this.mItems.size()) {
                    c0471b3 = (C0471b) this.mItems.get(i2);
                    while (i4 > c0471b3.f795b && i2 < this.mItems.size() + INVALID_POINTER) {
                        i2 += SCROLL_STATE_DRAGGING;
                        c0471b3 = (C0471b) this.mItems.get(i2);
                    }
                    while (i4 < c0471b3.f795b) {
                        f += this.mAdapter.getPageWidth(i4) + f2;
                        i4 += SCROLL_STATE_DRAGGING;
                    }
                    c0471b3.f798e = f;
                    f += c0471b3.f797d + f2;
                    i4 += SCROLL_STATE_DRAGGING;
                }
            } else if (clientWidth > c0471b.f795b) {
                i2 = this.mItems.size() + INVALID_POINTER;
                f = c0471b2.f798e;
                i4 = clientWidth + INVALID_POINTER;
                while (i4 >= c0471b.f795b && i2 >= 0) {
                    c0471b3 = (C0471b) this.mItems.get(i2);
                    while (i4 < c0471b3.f795b && i2 > 0) {
                        i2 += INVALID_POINTER;
                        c0471b3 = (C0471b) this.mItems.get(i2);
                    }
                    while (i4 > c0471b3.f795b) {
                        f -= this.mAdapter.getPageWidth(i4) + f2;
                        i4 += INVALID_POINTER;
                    }
                    f -= c0471b3.f797d + f2;
                    c0471b3.f798e = f;
                    i4 += INVALID_POINTER;
                }
            }
        }
        int size = this.mItems.size();
        float f3 = c0471b.f798e;
        i2 = c0471b.f795b + INVALID_POINTER;
        this.mFirstOffset = c0471b.f795b == 0 ? c0471b.f798e : -3.4028235E38f;
        this.mLastOffset = c0471b.f795b == count + INVALID_POINTER ? (c0471b.f798e + c0471b.f797d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i + INVALID_POINTER; i3 >= 0; i3 += INVALID_POINTER) {
            c0471b3 = (C0471b) this.mItems.get(i3);
            f = f3;
            while (i2 > c0471b3.f795b) {
                f -= this.mAdapter.getPageWidth(i2) + f2;
                i2 += INVALID_POINTER;
            }
            f3 = f - (c0471b3.f797d + f2);
            c0471b3.f798e = f3;
            if (c0471b3.f795b == 0) {
                this.mFirstOffset = f3;
            }
            i2 += INVALID_POINTER;
        }
        f3 = (c0471b.f798e + c0471b.f797d) + f2;
        i2 = c0471b.f795b + SCROLL_STATE_DRAGGING;
        for (i3 = i + SCROLL_STATE_DRAGGING; i3 < size; i3 += SCROLL_STATE_DRAGGING) {
            c0471b3 = (C0471b) this.mItems.get(i3);
            f = f3;
            while (i2 < c0471b3.f795b) {
                f = (this.mAdapter.getPageWidth(i2) + f2) + f;
                i2 += SCROLL_STATE_DRAGGING;
            }
            if (c0471b3.f795b == count + INVALID_POINTER) {
                this.mLastOffset = (c0471b3.f797d + f) - 1.0f;
            }
            c0471b3.f798e = f;
            f3 = f + (c0471b3.f797d + f2);
            i2 += SCROLL_STATE_DRAGGING;
        }
        this.mNeedCalculatePageOffsets = DEBUG;
    }

    private void completeScroll(boolean z) {
        int scrollX;
        boolean z2 = this.mScrollState == SCROLL_STATE_SETTLING ? SCROLL_STATE_DRAGGING : DEBUG;
        if (z2) {
            setScrollingCacheEnabled(DEBUG);
            if (!this.mScroller.isFinished() ? SCROLL_STATE_DRAGGING : DEBUG) {
                this.mScroller.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = DEBUG;
        boolean z3 = z2;
        for (scrollX = SCROLL_STATE_IDLE; scrollX < this.mItems.size(); scrollX += SCROLL_STATE_DRAGGING) {
            C0471b c0471b = (C0471b) this.mItems.get(scrollX);
            if (c0471b.f796c) {
                c0471b.f796c = DEBUG;
                z3 = SCROLL_STATE_DRAGGING;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ah.m1917a((View) this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) ((i >= this.mCurItem ? 0.4f : 0.6f) + f);
        } else if (i2 <= 0) {
            i += SCROLL_STATE_DRAGGING;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        return Math.max(((C0471b) this.mItems.get(SCROLL_STATE_IDLE)).f795b, Math.min(i, ((C0471b) this.mItems.get(this.mItems.size() + INVALID_POINTER)).f795b));
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i3 = SCROLL_STATE_IDLE; i3 < size; i3 += SCROLL_STATE_DRAGGING) {
                C0476f c0476f = (C0476f) this.mOnPageChangeListeners.get(i3);
                if (c0476f != null) {
                    c0476f.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = SCROLL_STATE_IDLE; i2 < size; i2 += SCROLL_STATE_DRAGGING) {
                C0476f c0476f = (C0476f) this.mOnPageChangeListeners.get(i2);
                if (c0476f != null) {
                    c0476f.onPageSelected(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = SCROLL_STATE_IDLE; i2 < size; i2 += SCROLL_STATE_DRAGGING) {
                C0476f c0476f = (C0476f) this.mOnPageChangeListeners.get(i2);
                if (c0476f != null) {
                    c0476f.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = SCROLL_STATE_IDLE; i < childCount; i += SCROLL_STATE_DRAGGING) {
            ah.m1912a(getChildAt(i), z ? SCROLL_STATE_SETTLING : SCROLL_STATE_IDLE, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = DEBUG;
        this.mIsUnableToDrag = DEBUG;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(SCROLL_STATE_IDLE, SCROLL_STATE_IDLE, SCROLL_STATE_IDLE, SCROLL_STATE_IDLE);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        aw parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private C0471b infoForCurrentScrollPosition() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = INVALID_POINTER;
        int i2 = SCROLL_STATE_IDLE;
        Object obj = SCROLL_STATE_DRAGGING;
        C0471b c0471b = null;
        while (i2 < this.mItems.size()) {
            int i3;
            C0471b c0471b2;
            C0471b c0471b3 = (C0471b) this.mItems.get(i2);
            C0471b c0471b4;
            if (obj != null || c0471b3.f795b == i + SCROLL_STATE_DRAGGING) {
                c0471b4 = c0471b3;
                i3 = i2;
                c0471b2 = c0471b4;
            } else {
                c0471b3 = this.mTempItem;
                c0471b3.f798e = (f2 + f3) + f;
                c0471b3.f795b = i + SCROLL_STATE_DRAGGING;
                c0471b3.f797d = this.mAdapter.getPageWidth(c0471b3.f795b);
                c0471b4 = c0471b3;
                i3 = i2 + INVALID_POINTER;
                c0471b2 = c0471b4;
            }
            f2 = c0471b2.f798e;
            f3 = (c0471b2.f797d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0471b;
            }
            if (scrollX < f3 || i3 == this.mItems.size() + INVALID_POINTER) {
                return c0471b2;
            }
            f3 = f2;
            i = c0471b2.f795b;
            obj = SCROLL_STATE_IDLE;
            f2 = c0471b2.f797d;
            c0471b = c0471b2;
            i2 = i3 + SCROLL_STATE_DRAGGING;
        }
        return c0471b;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(C0470a.class) != null ? true : DEBUG;
    }

    private boolean isGutterDrag(float f, float f2) {
        return ((f >= ((float) this.mGutterSize) || f2 <= 0.0f) && (f <= ((float) (getWidth() - this.mGutterSize)) || f2 >= 0.0f)) ? DEBUG : true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int b = C0560t.m2394b(motionEvent);
        if (C0560t.m2395b(motionEvent, b) == this.mActivePointerId) {
            b = b == 0 ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
            this.mLastMotionX = C0560t.m2396c(motionEvent, b);
            this.mActivePointerId = C0560t.m2395b(motionEvent, b);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            C0471b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin + clientWidth;
            float f = ((float) this.mPageMargin) / ((float) clientWidth);
            int i3 = infoForCurrentScrollPosition.f795b;
            float f2 = ((((float) i) / ((float) clientWidth)) - infoForCurrentScrollPosition.f798e) / (infoForCurrentScrollPosition.f797d + f);
            clientWidth = (int) (((float) i2) * f2);
            this.mCalledSuper = DEBUG;
            onPageScrolled(i3, f2, clientWidth);
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return DEBUG;
        } else {
            this.mCalledSuper = DEBUG;
            onPageScrolled(SCROLL_STATE_IDLE, 0.0f, SCROLL_STATE_IDLE);
            if (this.mCalledSuper) {
                return DEBUG;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = DEBUG;
        float f3 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.mFirstOffset;
        float f5 = ((float) clientWidth) * this.mLastOffset;
        C0471b c0471b = (C0471b) this.mItems.get(SCROLL_STATE_IDLE);
        C0471b c0471b2 = (C0471b) this.mItems.get(this.mItems.size() + INVALID_POINTER);
        if (c0471b.f795b != 0) {
            f4 = c0471b.f798e * ((float) clientWidth);
            z = DEBUG;
        } else {
            z = SCROLL_STATE_DRAGGING;
        }
        if (c0471b2.f795b != this.mAdapter.getCount() + INVALID_POINTER) {
            f2 = c0471b2.f798e * ((float) clientWidth);
            z2 = DEBUG;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.mLeftEdge.m2639a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.mRightEdge.m2639a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.mLastMotionX += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        pageScrolled((int) f4);
        return z3;
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            C0471b infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f798e, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(DEBUG);
                scrollTo(min, getScrollY());
            }
        } else if (this.mScroller.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    private void removeNonDecorViews() {
        int i = SCROLL_STATE_IDLE;
        while (i < getChildCount()) {
            if (!((C0472c) getChildAt(i).getLayoutParams()).f799a) {
                removeViewAt(i);
                i += INVALID_POINTER;
            }
            i += SCROLL_STATE_DRAGGING;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = INVALID_POINTER;
        endDrag();
        return this.mLeftEdge.m2644c() | this.mRightEdge.m2644c();
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int max;
        C0471b infoForPosition = infoForPosition(i);
        if (infoForPosition != null) {
            max = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.f798e, this.mLastOffset)) * ((float) getClientWidth()));
        } else {
            max = SCROLL_STATE_IDLE;
        }
        if (z) {
            smoothScrollTo(max, SCROLL_STATE_IDLE, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(DEBUG);
        scrollTo(max, SCROLL_STATE_IDLE);
        pageScrolled(max);
    }

    private void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0 ? true : DEBUG);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = SCROLL_STATE_IDLE; i < childCount; i += SCROLL_STATE_DRAGGING) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = SCROLL_STATE_IDLE; i3 < getChildCount(); i3 += SCROLL_STATE_DRAGGING) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0471b infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.f795b == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & SCROLL_STATE_DRAGGING) != SCROLL_STATE_DRAGGING || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    C0471b addNewItem(int i, int i2) {
        C0471b c0471b = new C0471b();
        c0471b.f795b = i;
        c0471b.f794a = this.mAdapter.instantiateItem((ViewGroup) this, i);
        c0471b.f797d = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(c0471b);
        } else {
            this.mItems.add(i2, c0471b);
        }
        return c0471b;
    }

    public void addOnAdapterChangeListener(C0475e c0475e) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(c0475e);
    }

    public void addOnPageChangeListener(C0476f c0476f) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(c0476f);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = SCROLL_STATE_IDLE; i < getChildCount(); i += SCROLL_STATE_DRAGGING) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0471b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f795b == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        C0472c c0472c = (C0472c) generateLayoutParams;
        c0472c.f799a |= aw.isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i, generateLayoutParams);
        } else if (c0472c == null || !c0472c.f799a) {
            c0472c.f802d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public boolean arrowScroll(int i) {
        View view;
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (aw parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = SCROLL_STATE_DRAGGING;
                        break;
                    }
                }
                obj = SCROLL_STATE_IDLE;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == SCROLL_STATE_DRAGGING) {
                pageLeft = pageLeft();
            } else {
                if (i == 66 || i == SCROLL_STATE_SETTLING) {
                    pageLeft = pageRight();
                }
                pageLeft = DEBUG;
            }
        } else if (i == 17) {
            pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left < getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageLeft();
        } else {
            if (i == 66) {
                pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left > getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageRight();
            }
            pageLeft = DEBUG;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return pageLeft;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return DEBUG;
        }
        this.mFakeDragging = true;
        setScrollState(SCROLL_STATE_DRAGGING);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, SCROLL_STATE_IDLE, 0.0f, 0.0f, SCROLL_STATE_IDLE);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() + INVALID_POINTER; childCount >= 0; childCount += INVALID_POINTER) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return (z && ah.m1921a(view, -i)) ? true : DEBUG;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.mAdapter == null) {
            return DEBUG;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.mFirstOffset))) {
                z = DEBUG;
            }
            return z;
        } else if (i <= 0) {
            return DEBUG;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
                z = DEBUG;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return ((layoutParams instanceof C0472c) && super.checkLayoutParams(layoutParams)) ? true : DEBUG;
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(SCROLL_STATE_IDLE, currY);
            }
        }
        ah.m1931d(this);
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = (this.mItems.size() >= (this.mOffscreenPageLimit * SCROLL_STATE_SETTLING) + SCROLL_STATE_DRAGGING || this.mItems.size() >= count) ? DEBUG : true;
        boolean z2 = DEBUG;
        int i = this.mCurItem;
        boolean z3 = z;
        int i2 = SCROLL_STATE_IDLE;
        while (i2 < this.mItems.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C0471b c0471b = (C0471b) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(c0471b.f794a);
            if (itemPosition == INVALID_POINTER) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (itemPosition == -2) {
                this.mItems.remove(i2);
                i2 += INVALID_POINTER;
                if (!z2) {
                    this.mAdapter.startUpdate((ViewGroup) this);
                    z2 = true;
                }
                this.mAdapter.destroyItem((ViewGroup) this, c0471b.f795b, c0471b.f794a);
                if (this.mCurItem == c0471b.f795b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(SCROLL_STATE_IDLE, Math.min(this.mCurItem, count + INVALID_POINTER));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c0471b.f795b != itemPosition) {
                if (c0471b.f795b == this.mCurItem) {
                    i = itemPosition;
                }
                c0471b.f795b = itemPosition;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + SCROLL_STATE_DRAGGING;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z3) {
            i4 = getChildCount();
            for (i2 = SCROLL_STATE_IDLE; i2 < i4; i2 += SCROLL_STATE_DRAGGING) {
                C0472c c0472c = (C0472c) getChildAt(i2).getLayoutParams();
                if (!c0472c.f799a) {
                    c0472c.f801c = 0.0f;
                }
            }
            setCurrentItemInternal(i, DEBUG, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) ? true : DEBUG;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = SCROLL_STATE_IDLE; i < childCount; i += SCROLL_STATE_DRAGGING) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0471b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f795b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return DEBUG;
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = SCROLL_STATE_IDLE;
        int a = ah.m1907a(this);
        if (a == 0 || (a == SCROLL_STATE_DRAGGING && this.mAdapter != null && this.mAdapter.getCount() > SCROLL_STATE_DRAGGING)) {
            int height;
            int width;
            if (!this.mLeftEdge.m2638a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.m2637a(height, width);
                i = SCROLL_STATE_IDLE | this.mLeftEdge.m2642a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.mRightEdge.m2638a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) height));
                this.mRightEdge.m2637a(width, height);
                i |= this.mRightEdge.m2642a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.mLeftEdge.m2643b();
            this.mRightEdge.m2643b();
        }
        if (i != 0) {
            ah.m1931d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int a = (int) af.m1694a(velocityTracker, this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C0471b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f795b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f798e) / infoForCurrentScrollPosition.f797d, a, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, a);
            }
            endDrag();
            this.mFakeDragging = DEBUG;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return DEBUG;
        }
        switch (keyEvent.getKeyCode()) {
            case C1373c.Toolbar_buttonGravity /*21*/:
                return arrowScroll(17);
            case C1373c.Toolbar_collapseIcon /*22*/:
                return arrowScroll(66);
            case C1373c.AppCompatTheme_popupMenuStyle /*61*/:
                return VERSION.SDK_INT >= 11 ? C0528h.m2306a(keyEvent) ? arrowScroll(SCROLL_STATE_SETTLING) : C0528h.m2307a(keyEvent, SCROLL_STATE_DRAGGING) ? arrowScroll(SCROLL_STATE_DRAGGING) : DEBUG : DEBUG;
            default:
                return DEBUG;
        }
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f2 = ((float) clientWidth) * this.mLastOffset;
            C0471b c0471b = (C0471b) this.mItems.get(SCROLL_STATE_IDLE);
            C0471b c0471b2 = (C0471b) this.mItems.get(this.mItems.size() + INVALID_POINTER);
            float f3 = c0471b.f795b != 0 ? c0471b.f798e * ((float) clientWidth) : ((float) clientWidth) * this.mFirstOffset;
            float f4 = c0471b2.f795b != this.mAdapter.getCount() + INVALID_POINTER ? c0471b2.f798e * ((float) clientWidth) : f2;
            if (scrollX >= f3) {
                f3 = scrollX > f4 ? f4 : scrollX;
            }
            this.mLastMotionX += f3 - ((float) ((int) f3));
            scrollTo((int) f3, getScrollY());
            pageScrolled((int) f3);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), SCROLL_STATE_SETTLING, this.mLastMotionX, 0.0f, SCROLL_STATE_IDLE);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0472c();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0472c(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ac getAdapter() {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == SCROLL_STATE_SETTLING) {
            i2 = (i + INVALID_POINTER) - i2;
        }
        return ((C0472c) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).f804f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.support.v4.p016k.aw.C0471b infoForAnyChild(android.view.View r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r3.getParent();
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r1 = r0 instanceof android.view.View;
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = (android.view.View) r0;
        r3 = r0;
        goto L_0x0000;
    L_0x0012:
        r0 = r2.infoForChild(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.k.aw.infoForAnyChild(android.view.View):android.support.v4.k.aw$b");
    }

    C0471b infoForChild(View view) {
        for (int i = SCROLL_STATE_IDLE; i < this.mItems.size(); i += SCROLL_STATE_DRAGGING) {
            C0471b c0471b = (C0471b) this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, c0471b.f794a)) {
                return c0471b;
            }
        }
        return null;
    }

    C0471b infoForPosition(int i) {
        for (int i2 = SCROLL_STATE_IDLE; i2 < this.mItems.size(); i2 += SCROLL_STATE_DRAGGING) {
            C0471b c0471b = (C0471b) this.mItems.get(i2);
            if (c0471b.f795b == i) {
                return c0471b;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(DEBUG);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = at.m2047a(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new C0604i(context);
        this.mRightEdge = new C0604i(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        ah.m1916a((View) this, new C0474d(this));
        if (ah.m1934e(this) == 0) {
            ah.m1928c((View) this, (int) SCROLL_STATE_DRAGGING);
        }
        ah.m1915a((View) this, new C04694(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        if (!(this.mScroller == null || this.mScroller.isFinished())) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.mPageMargin) / ((float) width);
            C0471b c0471b = (C0471b) this.mItems.get(SCROLL_STATE_IDLE);
            float f2 = c0471b.f798e;
            int size = this.mItems.size();
            int i = c0471b.f795b;
            int i2 = ((C0471b) this.mItems.get(size + INVALID_POINTER)).f795b;
            int i3 = SCROLL_STATE_IDLE;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0471b.f795b && i3 < size) {
                    i3 += SCROLL_STATE_DRAGGING;
                    c0471b = (C0471b) this.mItems.get(i3);
                }
                if (i4 == c0471b.f795b) {
                    f3 = (c0471b.f798e + c0471b.f797d) * ((float) width);
                    f2 = (c0471b.f798e + c0471b.f797d) + f;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i4);
                    f3 = (f2 + pageWidth) * ((float) width);
                    f2 += pageWidth + f;
                }
                if (((float) this.mPageMargin) + f3 > ((float) scrollX)) {
                    this.mMarginDrawable.setBounds(Math.round(f3), this.mTopPageBounds, Math.round(((float) this.mPageMargin) + f3), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4 += SCROLL_STATE_DRAGGING;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == SCROLL_STATE_DRAGGING) {
            resetTouch();
            return DEBUG;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return DEBUG;
            }
        }
        switch (action) {
            case SCROLL_STATE_IDLE /*0*/:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                x = motionEvent.getY();
                this.mInitialMotionY = x;
                this.mLastMotionY = x;
                this.mActivePointerId = C0560t.m2395b(motionEvent, SCROLL_STATE_IDLE);
                this.mIsUnableToDrag = DEBUG;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == SCROLL_STATE_SETTLING && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = DEBUG;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(SCROLL_STATE_DRAGGING);
                    break;
                }
                completeScroll(DEBUG);
                this.mIsBeingDragged = DEBUG;
                break;
            case SCROLL_STATE_SETTLING /*2*/:
                action = this.mActivePointerId;
                if (action != INVALID_POINTER) {
                    action = C0560t.m2393a(motionEvent, action);
                    float c = C0560t.m2396c(motionEvent, action);
                    float f = c - this.mLastMotionX;
                    float abs = Math.abs(f);
                    float d = C0560t.m2398d(motionEvent, action);
                    float abs2 = Math.abs(d - this.mInitialMotionY);
                    if (f == 0.0f || isGutterDrag(this.mLastMotionX, f) || !canScroll(this, DEBUG, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.mTouchSlop) && 0.5f * abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            setScrollState(SCROLL_STATE_DRAGGING);
                            this.mLastMotionX = f > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                            this.mLastMotionY = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.mTouchSlop)) {
                            this.mIsUnableToDrag = true;
                        }
                        if (this.mIsBeingDragged && performDrag(c)) {
                            ah.m1931d(this);
                            break;
                        }
                    }
                    this.mLastMotionX = c;
                    this.mLastMotionY = d;
                    this.mIsUnableToDrag = true;
                    return DEBUG;
                }
                break;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0472c c0472c;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = SCROLL_STATE_IDLE;
        int i8 = SCROLL_STATE_IDLE;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c0472c = (C0472c) childAt.getLayoutParams();
                if (c0472c.f799a) {
                    int i9 = c0472c.f800b & C1373c.AppCompatTheme_spinnerStyle;
                    switch (c0472c.f800b & 7) {
                        case SCROLL_STATE_DRAGGING /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / SCROLL_STATE_SETTLING, paddingLeft);
                            break;
                        case C1373c.View_paddingEnd /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case C1373c.Toolbar_contentInsetStart /*5*/:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case DEFAULT_GUTTER_SIZE /*16*/:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / SCROLL_STATE_SETTLING, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case C1373c.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + SCROLL_STATE_DRAGGING;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8 += SCROLL_STATE_DRAGGING;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8 += SCROLL_STATE_DRAGGING;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = SCROLL_STATE_IDLE; paddingRight < childCount; paddingRight += SCROLL_STATE_DRAGGING) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c0472c = (C0472c) childAt2.getLayoutParams();
                if (!c0472c.f799a) {
                    C0471b infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        i5 = ((int) (infoForChild.f798e * ((float) max))) + paddingLeft;
                        if (c0472c.f802d) {
                            c0472c.f802d = DEBUG;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0472c.f801c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i6 - paddingBottom;
        this.mDecorChildCount = i7;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, DEBUG, SCROLL_STATE_IDLE, DEBUG);
        }
        this.mFirstLayout = DEBUG;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        setMeasuredDimension(aw.getDefaultSize(SCROLL_STATE_IDLE, i), aw.getDefaultSize(SCROLL_STATE_IDLE, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = SCROLL_STATE_IDLE; i5 < childCount; i5 += SCROLL_STATE_DRAGGING) {
            C0472c c0472c;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                c0472c = (C0472c) childAt.getLayoutParams();
                if (c0472c != null && c0472c.f799a) {
                    int i6 = c0472c.f800b & 7;
                    int i7 = c0472c.f800b & C1373c.AppCompatTheme_spinnerStyle;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
                    Object obj2 = (i6 == 3 || i6 == 5) ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (c0472c.width != -2) {
                        i7 = 1073741824;
                        i3 = c0472c.width != INVALID_POINTER ? c0472c.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (c0472c.height != -2) {
                        i4 = 1073741824;
                        if (c0472c.height != INVALID_POINTER) {
                            measuredWidth = c0472c.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = DEBUG;
        i3 = getChildCount();
        for (i4 = SCROLL_STATE_IDLE; i4 < i3; i4 += SCROLL_STATE_DRAGGING) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                c0472c = (C0472c) childAt2.getLayoutParams();
                if (c0472c == null || !c0472c.f799a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0472c.f801c * ((float) paddingLeft)), 1073741824), this.mChildHeightMeasureSpec);
                }
            }
        }
    }

    protected void onPageScrolled(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = SCROLL_STATE_IDLE;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C0472c c0472c = (C0472c) childAt.getLayoutParams();
                if (c0472c.f799a) {
                    int max;
                    switch (c0472c.f800b & 7) {
                        case SCROLL_STATE_DRAGGING /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / SCROLL_STATE_SETTLING, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case C1373c.View_paddingEnd /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case C1373c.Toolbar_contentInsetStart /*5*/:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3 += SCROLL_STATE_DRAGGING;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = SCROLL_STATE_IDLE; paddingLeft < i3; paddingLeft += SCROLL_STATE_DRAGGING) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C0472c) childAt2.getLayoutParams()).f799a) {
                    this.mPageTransformer.m2068a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = INVALID_POINTER;
        int childCount = getChildCount();
        if ((i & SCROLL_STATE_SETTLING) != 0) {
            i3 = SCROLL_STATE_DRAGGING;
            i2 = SCROLL_STATE_IDLE;
        } else {
            i2 = childCount + INVALID_POINTER;
            childCount = INVALID_POINTER;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0471b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f795b == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return DEBUG;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0480i) {
            C0480i c0480i = (C0480i) parcelable;
            super.onRestoreInstanceState(c0480i.m249a());
            if (this.mAdapter != null) {
                this.mAdapter.restoreState(c0480i.f811b, c0480i.f812c);
                setCurrentItemInternal(c0480i.f810a, DEBUG, true);
                return;
            }
            this.mRestoredCurItem = c0480i.f810a;
            this.mRestoredAdapterState = c0480i.f811b;
            this.mRestoredClassLoader = c0480i.f812c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c0480i = new C0480i(super.onSaveInstanceState());
        c0480i.f810a = this.mCurItem;
        if (this.mAdapter != null) {
            c0480i.f811b = this.mAdapter.saveState();
        }
        return c0480i;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = DEBUG;
        if (this.mFakeDragging) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return DEBUG;
        }
        if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            return DEBUG;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case SCROLL_STATE_IDLE /*0*/:
                this.mScroller.abortAnimation();
                this.mPopulatePending = DEBUG;
                populate();
                x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                x = motionEvent.getY();
                this.mInitialMotionY = x;
                this.mLastMotionY = x;
                this.mActivePointerId = C0560t.m2395b(motionEvent, SCROLL_STATE_IDLE);
                break;
            case SCROLL_STATE_DRAGGING /*1*/:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                    a = (int) af.m1694a(velocityTracker, this.mActivePointerId);
                    this.mPopulatePending = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0471b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                    setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f795b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f798e) / (infoForCurrentScrollPosition.f797d + (((float) this.mPageMargin) / ((float) clientWidth))), a, (int) (C0560t.m2396c(motionEvent, C0560t.m2393a(motionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, a);
                    z = resetTouch();
                    break;
                }
                break;
            case SCROLL_STATE_SETTLING /*2*/:
                if (!this.mIsBeingDragged) {
                    a = C0560t.m2393a(motionEvent, this.mActivePointerId);
                    if (a == INVALID_POINTER) {
                        z = resetTouch();
                        break;
                    }
                    float c = C0560t.m2396c(motionEvent, a);
                    float abs = Math.abs(c - this.mLastMotionX);
                    float d = C0560t.m2398d(motionEvent, a);
                    x = Math.abs(d - this.mLastMotionY);
                    if (abs > ((float) this.mTouchSlop) && abs > x) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        this.mLastMotionX = c - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                        this.mLastMotionY = d;
                        setScrollState(SCROLL_STATE_DRAGGING);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = DEBUG | performDrag(C0560t.m2396c(motionEvent, C0560t.m2393a(motionEvent, this.mActivePointerId)));
                    break;
                }
                break;
            case C1373c.View_paddingEnd /*3*/:
                if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, true, SCROLL_STATE_IDLE, DEBUG);
                    z = resetTouch();
                    break;
                }
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                a = C0560t.m2394b(motionEvent);
                this.mLastMotionX = C0560t.m2396c(motionEvent, a);
                this.mActivePointerId = C0560t.m2395b(motionEvent, a);
                break;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionX = C0560t.m2396c(motionEvent, C0560t.m2393a(motionEvent, this.mActivePointerId));
                break;
        }
        if (z) {
            ah.m1931d(this);
        }
        return true;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem + INVALID_POINTER, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() + INVALID_POINTER) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem + SCROLL_STATE_DRAGGING, true);
        return true;
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void populate(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.mCurItem;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.mCurItem;
        r0 = r17;
        r2 = r0.infoForPosition(r2);
        r0 = r18;
        r1 = r17;
        r1.mCurItem = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.mAdapter;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.sortChildDrawingOrder();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.mPopulatePending;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.sortChildDrawingOrder();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.mAdapter;
        r0 = r17;
        r2.startUpdate(r0);
        r0 = r17;
        r2 = r0.mOffscreenPageLimit;
        r4 = 0;
        r0 = r17;
        r5 = r0.mCurItem;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.mAdapter;
        r11 = r4.getCount();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.mCurItem;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.mExpectedAdapterCount;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.mExpectedAdapterCount;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.mAdapter;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
        r6 = r2.f795b;
        r0 = r17;
        r7 = r0.mCurItem;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f795b;
        r0 = r17;
        r7 = r0.mCurItem;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.mCurItem;
        r0 = r17;
        r2 = r0.addNewItem(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r7);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.mCurItem;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f797d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r8);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.mCurItem;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.calculatePageOffsets(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.mAdapter;
        r0 = r17;
        r4 = r0.mCurItem;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f794a;
    L_0x0179:
        r0 = r17;
        r3.setPrimaryItem(r0, r4, r2);
        r0 = r17;
        r2 = r0.mAdapter;
        r0 = r17;
        r2.finishUpdate(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.p016k.aw.C0472c) r2;
        r2.f804f = r3;
        r6 = r2.f799a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f801c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.infoForChild(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f797d;
        r2.f801c = r6;
        r5 = r5.f795b;
        r2.f803e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f797d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f795b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f796c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.mItems;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.mAdapter;
        r2 = r2.f794a;
        r0 = r17;
        r14.destroyItem(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f795b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f797d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.addNewItem(r8, r2);
        r2 = r2.f797d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f795b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f796c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.mItems;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.mAdapter;
        r2 = r2.f794a;
        r0 = r17;
        r10.destroyItem(r0, r8, r2);
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f795b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f797d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.addNewItem(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f797d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.p016k.aw.C0471b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.sortChildDrawingOrder();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.infoForAnyChild(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f795b;
        r0 = r17;
        r3 = r0.mCurItem;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.infoForChild(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f795b;
        r0 = r17;
        r5 = r0.mCurItem;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.k.aw.populate(int):void");
    }

    public void removeOnAdapterChangeListener(C0475e c0475e) {
        if (this.mAdapterChangeListeners != null) {
            this.mAdapterChangeListeners.remove(c0475e);
        }
    }

    public void removeOnPageChangeListener(C0476f c0476f) {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(c0476f);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(ac acVar) {
        int i = SCROLL_STATE_IDLE;
        if (this.mAdapter != null) {
            this.mAdapter.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = SCROLL_STATE_IDLE; i2 < this.mItems.size(); i2 += SCROLL_STATE_DRAGGING) {
                C0471b c0471b = (C0471b) this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, c0471b.f795b, c0471b.f794a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = SCROLL_STATE_IDLE;
            scrollTo(SCROLL_STATE_IDLE, SCROLL_STATE_IDLE);
        }
        ac acVar2 = this.mAdapter;
        this.mAdapter = acVar;
        this.mExpectedAdapterCount = SCROLL_STATE_IDLE;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new C0478h();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = DEBUG;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, DEBUG, true);
                this.mRestoredCurItem = INVALID_POINTER;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            while (i < size) {
                ((C0475e) this.mAdapterChangeListeners.get(i)).m2067a(this, acVar2, acVar);
                i += SCROLL_STATE_DRAGGING;
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    Class[] clsArr = new Class[SCROLL_STATE_DRAGGING];
                    clsArr[SCROLL_STATE_IDLE] = Boolean.TYPE;
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", clsArr);
                } catch (Throwable e) {
                    Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                Method method = this.mSetChildrenDrawingOrderEnabled;
                Object[] objArr = new Object[SCROLL_STATE_DRAGGING];
                objArr[SCROLL_STATE_IDLE] = Boolean.valueOf(z);
                method.invoke(this, objArr);
            } catch (Throwable e2) {
                Log.e(TAG, "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(i, !this.mFirstLayout ? true : DEBUG, DEBUG);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(i, z, DEBUG);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, SCROLL_STATE_IDLE);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        boolean z3 = DEBUG;
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(DEBUG);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            if (i < 0) {
                i = SCROLL_STATE_IDLE;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() + INVALID_POINTER;
            }
            int i3 = this.mOffscreenPageLimit;
            if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                for (int i4 = SCROLL_STATE_IDLE; i4 < this.mItems.size(); i4 += SCROLL_STATE_DRAGGING) {
                    ((C0471b) this.mItems.get(i4)).f796c = true;
                }
            }
            if (this.mCurItem != i) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3) {
                    dispatchOnPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(DEBUG);
        }
    }

    C0476f setInternalPageChangeListener(C0476f c0476f) {
        C0476f c0476f2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = c0476f;
        return c0476f2;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < SCROLL_STATE_DRAGGING) {
            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to " + SCROLL_STATE_DRAGGING);
            i = SCROLL_STATE_DRAGGING;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(C0476f c0476f) {
        this.mOnPageChangeListener = c0476f;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : DEBUG);
        invalidate();
    }

    public void setPageTransformer(boolean z, C0477g c0477g) {
        int i = SCROLL_STATE_DRAGGING;
        if (VERSION.SDK_INT >= 11) {
            boolean z2 = c0477g != null ? true : DEBUG;
            int i2 = z2 != (this.mPageTransformer != null ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE) ? SCROLL_STATE_DRAGGING : SCROLL_STATE_IDLE;
            this.mPageTransformer = c0477g;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = SCROLL_STATE_SETTLING;
                }
                this.mDrawingOrder = i;
            } else {
                this.mDrawingOrder = SCROLL_STATE_IDLE;
            }
            if (i2 != 0) {
                populate();
            }
        }
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, SCROLL_STATE_IDLE);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        int i4;
        boolean z = (this.mScroller == null || this.mScroller.isFinished()) ? DEBUG : true;
        if (z) {
            int currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(DEBUG);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(DEBUG);
            populate();
            setScrollState(SCROLL_STATE_IDLE);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(SCROLL_STATE_SETTLING);
        currX = getClientWidth();
        int i7 = currX / SCROLL_STATE_SETTLING;
        float distanceInfluenceForSnapDuration = (((float) i7) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        i7 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f), MAX_SETTLE_DURATION);
        this.mIsScrollStarted = DEBUG;
        this.mScroller.startScroll(i4, scrollY, i5, i6, i7);
        ah.m1931d(this);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) ? true : DEBUG;
    }
}
