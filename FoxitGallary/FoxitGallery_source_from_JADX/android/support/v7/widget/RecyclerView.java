package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p016k.C0113x;
import android.support.v4.p016k.C0120a;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.C0564y;
import android.support.v4.p016k.ad;
import android.support.v4.p016k.af;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.at;
import android.support.v4.p016k.p031a.C0402a;
import android.support.v4.p016k.p031a.C0416c;
import android.support.v4.p016k.p031a.C0416c.C0414k;
import android.support.v4.p016k.p031a.C0416c.C0415l;
import android.support.v4.p016k.p031a.C0440k;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;
import android.support.v4.p017g.C0359h;
import android.support.v4.widget.C0604i;
import android.support.v4.widget.C0632w;
import android.support.v7.p037e.C0736a.C0735a;
import android.support.v7.widget.C0940f.C0827a;
import android.support.v7.widget.C0940f.C0939b;
import android.support.v7.widget.ab.C0825b;
import android.support.v7.widget.bi.C0823b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements ad, C0113x {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    private static final int[] CLIP_TO_PADDING_ATTR;
    private static final boolean DEBUG = false;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    private static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    private static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator;
    private at mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private C0841k mActiveOnItemTouchListener;
    private C0829a mAdapter;
    C0940f mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private C0604i mBottomGlow;
    private C0832d mChildDrawingOrderCallback;
    ab mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    private int mEatRequestLayout;
    private int mEatenAccessibilityChangeFlags;
    boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    C0836e mItemAnimator;
    private C0834b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private final ArrayList<C0838g> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    C0812h mLayout;
    private boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    private boolean mLayoutRequestEaten;
    private C0604i mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C0846p mObserver;
    private List<C0840j> mOnChildAttachStateListeners;
    private final ArrayList<C0841k> mOnItemTouchListeners;
    private C0848q mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    private boolean mPreserveFocusAfterLayout;
    final C0844n mRecycler;
    private C0845o mRecyclerListener;
    private C0604i mRightGlow;
    private final int[] mScrollConsumed;
    private float mScrollFactor;
    private C0842l mScrollListener;
    private List<C0842l> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private C0564y mScrollingChildHelper;
    final C0850s mState;
    private final Rect mTempRect;
    private final Rect mTempRect2;
    private final RectF mTempRectF;
    private C0604i mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final C0852u mViewFlinger;
    private final C0823b mViewInfoProcessCallback;
    final bi mViewInfoStore;

    /* renamed from: android.support.v7.widget.RecyclerView.i */
    public static class C0810i extends MarginLayoutParams {
        C0853v f1819a;
        final Rect f1820b;
        boolean f1821c;
        boolean f1822d;

        public C0810i(int i, int i2) {
            super(i, i2);
            this.f1820b = new Rect();
            this.f1821c = true;
            this.f1822d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0810i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1820b = new Rect();
            this.f1821c = true;
            this.f1822d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0810i(C0810i c0810i) {
            super(c0810i);
            this.f1820b = new Rect();
            this.f1821c = true;
            this.f1822d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0810i(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1820b = new Rect();
            this.f1821c = true;
            this.f1822d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public C0810i(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1820b = new Rect();
            this.f1821c = true;
            this.f1822d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean m3735c() {
            return this.f1819a.isRemoved();
        }

        public boolean m3736d() {
            return this.f1819a.isUpdated();
        }

        public int m3737e() {
            return this.f1819a.getLayoutPosition();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.h */
    public static abstract class C0812h {
        private boolean f1825a;
        private boolean f1826b;
        private boolean f1827c;
        private int f1828d;
        private int f1829e;
        private int f1830f;
        private int f1831g;
        ab f1832p;
        RecyclerView f1833q;
        C0813r f1834r;
        boolean f1835s;

        /* renamed from: android.support.v7.widget.RecyclerView.h.a */
        public static class C0839a {
            public int f1911a;
            public int f1912b;
            public boolean f1913c;
            public boolean f1914d;
        }

        public C0812h() {
            this.f1825a = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1835s = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1826b = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1827c = true;
        }

        public static int m3744a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public static int m3745a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int max = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == RecyclerView.NO_POSITION) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case RecyclerView.TOUCH_SLOP_DEFAULT /*0*/:
                            i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                            break;
                        default:
                            i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = RecyclerView.TOUCH_SLOP_DEFAULT;
                    }
                    max = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == RecyclerView.NO_POSITION) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static C0839a m3746a(Context context, AttributeSet attributeSet, int i, int i2) {
            C0839a c0839a = new C0839a();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0735a.RecyclerView, i, i2);
            c0839a.f1911a = obtainStyledAttributes.getInt(C0735a.RecyclerView_android_orientation, RecyclerView.VERTICAL);
            c0839a.f1912b = obtainStyledAttributes.getInt(C0735a.RecyclerView_spanCount, RecyclerView.VERTICAL);
            c0839a.f1913c = obtainStyledAttributes.getBoolean(C0735a.RecyclerView_reverseLayout, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            c0839a.f1914d = obtainStyledAttributes.getBoolean(C0735a.RecyclerView_stackFromEnd, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            obtainStyledAttributes.recycle();
            return c0839a;
        }

        private void m3747a(int i, View view) {
            this.f1832p.m4519d(i);
        }

        private void m3749a(C0844n c0844n, int i, View view) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.f1833q.mAdapter.hasStableIds()) {
                    m3856h(i);
                    c0844n.m4168c(view);
                    this.f1833q.mViewInfoStore.m4864h(childViewHolderInt);
                    return;
                }
                m3853g(i);
                c0844n.m4162b(childViewHolderInt);
            }
        }

        private void m3750a(View view, int i, boolean z) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.f1833q.mViewInfoStore.m4861e(childViewHolderInt);
            } else {
                this.f1833q.mViewInfoStore.m4862f(childViewHolderInt);
            }
            C0810i c0810i = (C0810i) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.f1832p.m4510a(view, i, view.getLayoutParams(), RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            } else if (view.getParent() == this.f1833q) {
                int b = this.f1832p.m4514b(view);
                if (i == RecyclerView.NO_POSITION) {
                    i = this.f1832p.m4513b();
                }
                if (b == RecyclerView.NO_POSITION) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1833q.indexOfChild(view));
                } else if (b != i) {
                    this.f1833q.mLayout.m3825c(b, i);
                }
            } else {
                this.f1832p.m4511a(view, i, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                c0810i.f1821c = true;
                if (this.f1834r != null && this.f1834r.m4005h()) {
                    this.f1834r.m3999b(view);
                }
            }
            if (c0810i.f1822d) {
                childViewHolderInt.itemView.invalidate();
                c0810i.f1822d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        private void m3753b(C0813r c0813r) {
            if (this.f1834r == c0813r) {
                this.f1834r = null;
            }
        }

        private static boolean m3754b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size < i ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
                case RecyclerView.TOUCH_SLOP_DEFAULT /*0*/:
                    return true;
                case 1073741824:
                    return size != i ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
                default:
                    return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        public int m3756A() {
            return this.f1833q != null ? this.f1833q.getPaddingTop() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3757B() {
            return this.f1833q != null ? this.f1833q.getPaddingRight() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3758C() {
            return this.f1833q != null ? this.f1833q.getPaddingBottom() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public View m3759D() {
            if (this.f1833q == null) {
                return null;
            }
            View focusedChild = this.f1833q.getFocusedChild();
            return (focusedChild == null || this.f1832p.m4518c(focusedChild)) ? null : focusedChild;
        }

        public int m3760E() {
            return ah.m1949p(this.f1833q);
        }

        public int m3761F() {
            return ah.m1950q(this.f1833q);
        }

        void m3762G() {
            if (this.f1834r != null) {
                this.f1834r.m4003f();
            }
        }

        public void m3763H() {
            this.f1825a = true;
        }

        boolean m3764I() {
            int u = m3875u();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < u; i += RecyclerView.VERTICAL) {
                LayoutParams layoutParams = m3858i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m3765a(int i, C0844n c0844n, C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3766a(C0844n c0844n, C0850s c0850s) {
            return (this.f1833q == null || this.f1833q.mAdapter == null || !m3850f()) ? RecyclerView.VERTICAL : this.f1833q.mAdapter.getItemCount();
        }

        public abstract C0810i m3767a();

        public C0810i m3768a(Context context, AttributeSet attributeSet) {
            return new C0810i(context, attributeSet);
        }

        public C0810i m3769a(LayoutParams layoutParams) {
            return layoutParams instanceof C0810i ? new C0810i((C0810i) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0810i((MarginLayoutParams) layoutParams) : new C0810i(layoutParams);
        }

        public View m3770a(View view, int i, C0844n c0844n, C0850s c0850s) {
            return null;
        }

        void m3771a(int i, int i2) {
            this.f1830f = MeasureSpec.getSize(i);
            this.f1828d = MeasureSpec.getMode(i);
            if (this.f1828d == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f1830f = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
            this.f1831g = MeasureSpec.getSize(i2);
            this.f1829e = MeasureSpec.getMode(i2);
            if (this.f1829e == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f1831g = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
        }

        public void m3772a(int i, C0844n c0844n) {
            View i2 = m3858i(i);
            m3853g(i);
            c0844n.m4156a(i2);
        }

        public void m3773a(Rect rect, int i, int i2) {
            m3839d(C0812h.m3744a(i, (rect.width() + m3880z()) + m3757B(), m3760E()), C0812h.m3744a(i2, (rect.height() + m3756A()) + m3758C(), m3761F()));
        }

        public void m3774a(Parcelable parcelable) {
        }

        void m3775a(C0416c c0416c) {
            m3779a(this.f1833q.mRecycler, this.f1833q.mState, c0416c);
        }

        public void m3776a(C0829a c0829a, C0829a c0829a2) {
        }

        public void m3777a(C0844n c0844n) {
            for (int u = m3875u() + RecyclerView.NO_POSITION; u >= 0; u += RecyclerView.NO_POSITION) {
                m3749a(c0844n, u, m3858i(u));
            }
        }

        public void m3778a(C0844n c0844n, C0850s c0850s, int i, int i2) {
            this.f1833q.defaultOnMeasure(i, i2);
        }

        public void m3779a(C0844n c0844n, C0850s c0850s, C0416c c0416c) {
            if (ah.m1926b(this.f1833q, (int) RecyclerView.NO_POSITION) || ah.m1921a(this.f1833q, (int) RecyclerView.NO_POSITION)) {
                c0416c.m1570a(8192);
                c0416c.m1574a(true);
            }
            if (ah.m1926b(this.f1833q, (int) RecyclerView.VERTICAL) || ah.m1921a(this.f1833q, (int) RecyclerView.VERTICAL)) {
                c0416c.m1570a(4096);
                c0416c.m1574a(true);
            }
            c0416c.m1573a(C0414k.m1564a(m3766a(c0844n, c0850s), m3813b(c0844n, c0850s), m3846e(c0844n, c0850s), m3834d(c0844n, c0850s)));
        }

        public void m3780a(C0844n c0844n, C0850s c0850s, View view, C0416c c0416c) {
            c0416c.m1577b(C0415l.m1565a(m3850f() ? m3836d(view) : RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.VERTICAL, m3845e() ? m3836d(view) : RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.VERTICAL, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST));
        }

        public void m3781a(C0844n c0844n, C0850s c0850s, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            C0440k a = C0402a.m1482a(accessibilityEvent);
            if (this.f1833q != null && a != null) {
                if (!(ah.m1926b(this.f1833q, (int) RecyclerView.VERTICAL) || ah.m1926b(this.f1833q, (int) RecyclerView.NO_POSITION) || ah.m1921a(this.f1833q, (int) RecyclerView.NO_POSITION) || ah.m1921a(this.f1833q, (int) RecyclerView.VERTICAL))) {
                    z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                }
                a.m1670a(z);
                if (this.f1833q.mAdapter != null) {
                    a.m1669a(this.f1833q.mAdapter.getItemCount());
                }
            }
        }

        public void m3782a(C0813r c0813r) {
            if (!(this.f1834r == null || c0813r == this.f1834r || !this.f1834r.m4005h())) {
                this.f1834r.m4003f();
            }
            this.f1834r = c0813r;
            this.f1834r.m3996a(this.f1833q, this);
        }

        public void m3783a(C0850s c0850s) {
        }

        public void m3784a(RecyclerView recyclerView) {
        }

        public void m3785a(RecyclerView recyclerView, int i, int i2) {
        }

        public void m3786a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void m3787a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m3829c(recyclerView, i, i2);
        }

        public void m3788a(RecyclerView recyclerView, C0844n c0844n) {
            m3844e(recyclerView);
        }

        public void m3789a(RecyclerView recyclerView, C0850s c0850s, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void m3790a(View view) {
            m3791a(view, (int) RecyclerView.NO_POSITION);
        }

        public void m3791a(View view, int i) {
            m3750a(view, i, true);
        }

        public void m3792a(View view, int i, int i2) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.f1833q.getItemDecorInsetsForChild(view);
            int i3 = (itemDecorInsetsForChild.left + itemDecorInsetsForChild.right) + i;
            int i4 = (itemDecorInsetsForChild.bottom + itemDecorInsetsForChild.top) + i2;
            i3 = C0812h.m3745a(m3878x(), m3876v(), i3 + (((m3880z() + m3757B()) + c0810i.leftMargin) + c0810i.rightMargin), c0810i.width, m3845e());
            i4 = C0812h.m3745a(m3879y(), m3877w(), i4 + (((m3756A() + m3758C()) + c0810i.topMargin) + c0810i.bottomMargin), c0810i.height, m3850f());
            if (m3822b(view, i3, i4, c0810i)) {
                view.measure(i3, i4);
            }
        }

        public void m3793a(View view, int i, int i2, int i3, int i4) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            Rect rect = c0810i.f1820b;
            view.layout((rect.left + i) + c0810i.leftMargin, (rect.top + i2) + c0810i.topMargin, (i3 - rect.right) - c0810i.rightMargin, (i4 - rect.bottom) - c0810i.bottomMargin);
        }

        public void m3794a(View view, int i, C0810i c0810i) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.f1833q.mViewInfoStore.m4861e(childViewHolderInt);
            } else {
                this.f1833q.mViewInfoStore.m4862f(childViewHolderInt);
            }
            this.f1832p.m4510a(view, i, c0810i, childViewHolderInt.isRemoved());
        }

        public void m3795a(View view, Rect rect) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            Rect rect2 = c0810i.f1820b;
            rect.set((view.getLeft() - rect2.left) - c0810i.leftMargin, (view.getTop() - rect2.top) - c0810i.topMargin, (view.getRight() + rect2.right) + c0810i.rightMargin, c0810i.bottomMargin + (rect2.bottom + view.getBottom()));
        }

        void m3796a(View view, C0416c c0416c) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.f1832p.m4518c(childViewHolderInt.itemView)) {
                m3780a(this.f1833q.mRecycler, this.f1833q.mState, view, c0416c);
            }
        }

        public void m3797a(View view, C0844n c0844n) {
            m3830c(view);
            c0844n.m4156a(view);
        }

        public void m3798a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((C0810i) view.getLayoutParams()).f1820b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, view.getWidth(), view.getHeight());
            }
            if (this.f1833q != null) {
                Matrix o = ah.m1948o(view);
                if (!(o == null || o.isIdentity())) {
                    RectF access$5500 = this.f1833q.mTempRectF;
                    access$5500.set(rect);
                    o.mapRect(access$5500);
                    rect.set((int) Math.floor((double) access$5500.left), (int) Math.floor((double) access$5500.top), (int) Math.ceil((double) access$5500.right), (int) Math.ceil((double) access$5500.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void m3799a(AccessibilityEvent accessibilityEvent) {
            m3781a(this.f1833q.mRecycler, this.f1833q.mState, accessibilityEvent);
        }

        public void m3800a(String str) {
            if (this.f1833q != null) {
                this.f1833q.assertNotInLayoutOrScroll(str);
            }
        }

        boolean m3801a(int i, Bundle bundle) {
            return m3803a(this.f1833q.mRecycler, this.f1833q.mState, i, bundle);
        }

        public boolean m3802a(C0810i c0810i) {
            return c0810i != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean m3803a(android.support.v7.widget.RecyclerView.C0844n r7, android.support.v7.widget.RecyclerView.C0850s r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.f1833q;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.f1833q;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.f1833q;
            r0 = android.support.v4.p016k.ah.m1926b(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.m3879y();
            r3 = r6.m3756A();
            r0 = r0 - r3;
            r3 = r6.m3758C();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.f1833q;
            r3 = android.support.v4.p016k.ah.m1921a(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.m3878x();
            r4 = r6.m3880z();
            r3 = r3 - r4;
            r4 = r6.m3757B();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.f1833q;
            r0 = android.support.v4.p016k.ah.m1926b(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.m3879y();
            r3 = r6.m3756A();
            r0 = r0 - r3;
            r3 = r6.m3758C();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.f1833q;
            r3 = android.support.v4.p016k.ah.m1921a(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.m3878x();
            r4 = r6.m3880z();
            r3 = r3 - r4;
            r4 = r6.m3757B();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.a(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$s, int, android.os.Bundle):boolean");
        }

        public boolean m3804a(C0844n c0844n, C0850s c0850s, View view, int i, Bundle bundle) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean m3805a(RecyclerView recyclerView, C0850s c0850s, View view, View view2) {
            return m3807a(recyclerView, view, view2);
        }

        public boolean m3806a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int z2 = m3880z();
            int A = m3756A();
            int x = m3878x() - m3757B();
            int y = m3879y() - m3758C();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(RecyclerView.TOUCH_SLOP_DEFAULT, left - z2);
            int min2 = Math.min(RecyclerView.TOUCH_SLOP_DEFAULT, top - A);
            int max = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, width - x);
            y = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, height - y);
            if (m3873s() == RecyclerView.VERTICAL) {
                if (max == 0) {
                    max = Math.max(min, width - x);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - z2, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - A, y);
            if (min == 0 && max == 0) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            if (z) {
                recyclerView.scrollBy(min, max);
            } else {
                recyclerView.smoothScrollBy(min, max);
            }
            return true;
        }

        @Deprecated
        public boolean m3807a(RecyclerView recyclerView, View view, View view2) {
            return (m3872r() || recyclerView.isComputingLayout()) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean m3808a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean m3809a(View view, int i, int i2, C0810i c0810i) {
            return (this.f1827c && C0812h.m3754b(view.getMeasuredWidth(), i, c0810i.width) && C0812h.m3754b(view.getMeasuredHeight(), i2, c0810i.height)) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        boolean m3810a(View view, int i, Bundle bundle) {
            return m3804a(this.f1833q.mRecycler, this.f1833q.mState, view, i, bundle);
        }

        public boolean m3811a(Runnable runnable) {
            return this.f1833q != null ? this.f1833q.removeCallbacks(runnable) : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m3812b(int i, C0844n c0844n, C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3813b(C0844n c0844n, C0850s c0850s) {
            return (this.f1833q == null || this.f1833q.mAdapter == null || !m3845e()) ? RecyclerView.VERTICAL : this.f1833q.mAdapter.getItemCount();
        }

        void m3814b(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int u = m3875u();
            if (u == 0) {
                this.f1833q.defaultOnMeasure(i, i2);
                return;
            }
            int i5 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < u) {
                View i8 = m3858i(i5);
                C0810i c0810i = (C0810i) i8.getLayoutParams();
                Rect access$5300 = this.f1833q.mTempRect;
                m3795a(i8, access$5300);
                i5 += RecyclerView.VERTICAL;
                i4 = access$5300.bottom > i4 ? access$5300.bottom : i4;
                i3 = access$5300.top < i3 ? access$5300.top : i3;
                i6 = access$5300.right > i6 ? access$5300.right : i6;
                i7 = access$5300.left < i7 ? access$5300.left : i7;
            }
            this.f1833q.mTempRect.set(i7, i3, i6, i4);
            m3773a(this.f1833q.mTempRect, i, i2);
        }

        void m3815b(C0844n c0844n) {
            int d = c0844n.m4169d();
            for (int i = d + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                View e = c0844n.m4172e(i);
                C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.f1833q.removeDetachedView(e, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    }
                    if (this.f1833q.mItemAnimator != null) {
                        this.f1833q.mItemAnimator.m4117c(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    c0844n.m4163b(e);
                }
            }
            c0844n.m4173e();
            if (d > 0) {
                this.f1833q.invalidate();
            }
        }

        void m3816b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1833q = null;
                this.f1832p = null;
                this.f1830f = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.f1831g = RecyclerView.TOUCH_SLOP_DEFAULT;
            } else {
                this.f1833q = recyclerView;
                this.f1832p = recyclerView.mChildHelper;
                this.f1830f = recyclerView.getWidth();
                this.f1831g = recyclerView.getHeight();
            }
            this.f1828d = 1073741824;
            this.f1829e = 1073741824;
        }

        public void m3817b(RecyclerView recyclerView, int i, int i2) {
        }

        void m3818b(RecyclerView recyclerView, C0844n c0844n) {
            this.f1835s = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            m3788a(recyclerView, c0844n);
        }

        public void m3819b(View view) {
            m3820b(view, (int) RecyclerView.NO_POSITION);
        }

        public void m3820b(View view, int i) {
            m3750a(view, i, (boolean) RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        public void m3821b(View view, Rect rect) {
            if (this.f1833q == null) {
                rect.set(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
            } else {
                rect.set(this.f1833q.getItemDecorInsetsForChild(view));
            }
        }

        boolean m3822b(View view, int i, int i2, C0810i c0810i) {
            return (!view.isLayoutRequested() && this.f1827c && C0812h.m3754b(view.getWidth(), i, c0810i.width) && C0812h.m3754b(view.getHeight(), i2, c0810i.height)) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public int m3823c(C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public View m3824c(int i) {
            int u = m3875u();
            for (int i2 = RecyclerView.TOUCH_SLOP_DEFAULT; i2 < u; i2 += RecyclerView.VERTICAL) {
                View i3 = m3858i(i2);
                C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(i3);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.f1833q.mState.m4218a() || !childViewHolderInt.isRemoved())) {
                    return i3;
                }
            }
            return null;
        }

        public void m3825c(int i, int i2) {
            View i3 = m3858i(i);
            if (i3 == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            m3856h(i);
            m3831c(i3, i2);
        }

        public void m3826c(C0844n c0844n) {
            for (int u = m3875u() + RecyclerView.NO_POSITION; u >= 0; u += RecyclerView.NO_POSITION) {
                if (!RecyclerView.getChildViewHolderInt(m3858i(u)).shouldIgnore()) {
                    m3772a(u, c0844n);
                }
            }
        }

        public void m3827c(C0844n c0844n, C0850s c0850s) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void m3828c(RecyclerView recyclerView) {
            this.f1835s = true;
            m3840d(recyclerView);
        }

        public void m3829c(RecyclerView recyclerView, int i, int i2) {
        }

        public void m3830c(View view) {
            this.f1832p.m4509a(view);
        }

        public void m3831c(View view, int i) {
            m3794a(view, i, (C0810i) view.getLayoutParams());
        }

        public void m3832c(boolean z) {
            this.f1826b = z;
        }

        public boolean m3833c() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m3834d(C0844n c0844n, C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3835d(C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3836d(View view) {
            return ((C0810i) view.getLayoutParams()).m3737e();
        }

        public Parcelable m3837d() {
            return null;
        }

        public View m3838d(View view, int i) {
            return null;
        }

        public void m3839d(int i, int i2) {
            this.f1833q.setMeasuredDimension(i, i2);
        }

        public void m3840d(RecyclerView recyclerView) {
        }

        public int m3841e(C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public View m3842e(View view) {
            if (this.f1833q == null) {
                return null;
            }
            View findContainingItemView = this.f1833q.findContainingItemView(view);
            return (findContainingItemView == null || this.f1832p.m4518c(findContainingItemView)) ? null : findContainingItemView;
        }

        public void m3843e(int i) {
        }

        @Deprecated
        public void m3844e(RecyclerView recyclerView) {
        }

        public boolean m3845e() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean m3846e(C0844n c0844n, C0850s c0850s) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m3847f(C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3848f(View view) {
            Rect rect = ((C0810i) view.getLayoutParams()).f1820b;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        void m3849f(RecyclerView recyclerView) {
            m3771a(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public boolean m3850f() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m3851g(C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3852g(View view) {
            Rect rect = ((C0810i) view.getLayoutParams()).f1820b;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void m3853g(int i) {
            if (m3858i(i) != null) {
                this.f1832p.m4508a(i);
            }
        }

        public int m3854h(C0850s c0850s) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3855h(View view) {
            return view.getLeft() - m3867n(view);
        }

        public void m3856h(int i) {
            m3747a(i, m3858i(i));
        }

        public int m3857i(View view) {
            return view.getTop() - m3863l(view);
        }

        public View m3858i(int i) {
            return this.f1832p != null ? this.f1832p.m4515b(i) : null;
        }

        public int m3859j(View view) {
            return view.getRight() + m3868o(view);
        }

        public void m3860j(int i) {
            if (this.f1833q != null) {
                this.f1833q.offsetChildrenHorizontal(i);
            }
        }

        public int m3861k(View view) {
            return view.getBottom() + m3866m(view);
        }

        public void m3862k(int i) {
            if (this.f1833q != null) {
                this.f1833q.offsetChildrenVertical(i);
            }
        }

        public int m3863l(View view) {
            return ((C0810i) view.getLayoutParams()).f1820b.top;
        }

        public void m3864l(int i) {
        }

        boolean m3865l() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m3866m(View view) {
            return ((C0810i) view.getLayoutParams()).f1820b.bottom;
        }

        public int m3867n(View view) {
            return ((C0810i) view.getLayoutParams()).f1820b.left;
        }

        public int m3868o(View view) {
            return ((C0810i) view.getLayoutParams()).f1820b.right;
        }

        public void m3869o() {
            if (this.f1833q != null) {
                this.f1833q.requestLayout();
            }
        }

        public boolean m3870p() {
            return this.f1835s;
        }

        public boolean m3871q() {
            return (this.f1833q == null || !this.f1833q.mClipToPadding) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public boolean m3872r() {
            return (this.f1834r == null || !this.f1834r.m4005h()) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public int m3873s() {
            return ah.m1941h(this.f1833q);
        }

        public int m3874t() {
            return RecyclerView.NO_POSITION;
        }

        public int m3875u() {
            return this.f1832p != null ? this.f1832p.m4513b() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int m3876v() {
            return this.f1828d;
        }

        public int m3877w() {
            return this.f1829e;
        }

        public int m3878x() {
            return this.f1830f;
        }

        public int m3879y() {
            return this.f1831g;
        }

        public int m3880z() {
            return this.f1833q != null ? this.f1833q.getPaddingLeft() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.r */
    public static abstract class C0813r {
        private int f1857a;
        private RecyclerView f1858b;
        private C0812h f1859c;
        private boolean f1860d;
        private boolean f1861e;
        private View f1862f;
        private final C0849a f1863g;

        /* renamed from: android.support.v7.widget.RecyclerView.r.a */
        public static class C0849a {
            private int f1928a;
            private int f1929b;
            private int f1930c;
            private int f1931d;
            private Interpolator f1932e;
            private boolean f1933f;
            private int f1934g;

            public C0849a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public C0849a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1931d = RecyclerView.NO_POSITION;
                this.f1933f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.f1934g = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.f1928a = i;
                this.f1929b = i2;
                this.f1930c = i3;
                this.f1932e = interpolator;
            }

            private void m4195a(RecyclerView recyclerView) {
                if (this.f1931d >= 0) {
                    int i = this.f1931d;
                    this.f1931d = RecyclerView.NO_POSITION;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f1933f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                } else if (this.f1933f) {
                    m4196b();
                    if (this.f1932e != null) {
                        recyclerView.mViewFlinger.m4232a(this.f1928a, this.f1929b, this.f1930c, this.f1932e);
                    } else if (this.f1930c == Integer.MIN_VALUE) {
                        recyclerView.mViewFlinger.m4234b(this.f1928a, this.f1929b);
                    } else {
                        recyclerView.mViewFlinger.m4230a(this.f1928a, this.f1929b, this.f1930c);
                    }
                    this.f1934g += RecyclerView.VERTICAL;
                    if (this.f1934g > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1933f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                } else {
                    this.f1934g = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
            }

            private void m4196b() {
                if (this.f1932e != null && this.f1930c < RecyclerView.VERTICAL) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f1930c < RecyclerView.VERTICAL) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void m4197a(int i) {
                this.f1931d = i;
            }

            public void m4198a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1928a = i;
                this.f1929b = i2;
                this.f1930c = i3;
                this.f1932e = interpolator;
                this.f1933f = true;
            }

            boolean m4199a() {
                return this.f1931d >= 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        public C0813r() {
            this.f1857a = RecyclerView.NO_POSITION;
            this.f1863g = new C0849a(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        private void m3990a(int i, int i2) {
            RecyclerView recyclerView = this.f1858b;
            if (!this.f1861e || this.f1857a == RecyclerView.NO_POSITION || recyclerView == null) {
                m4003f();
            }
            this.f1860d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.f1862f != null) {
                if (m3992a(this.f1862f) == this.f1857a) {
                    m3997a(this.f1862f, recyclerView.mState, this.f1863g);
                    this.f1863g.m4195a(recyclerView);
                    m4003f();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f1862f = null;
                }
            }
            if (this.f1861e) {
                m3994a(i, i2, recyclerView.mState, this.f1863g);
                boolean a = this.f1863g.m4199a();
                this.f1863g.m4195a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f1861e) {
                    this.f1860d = true;
                    recyclerView.mViewFlinger.m4228a();
                    return;
                }
                m4003f();
            }
        }

        public int m3992a(View view) {
            return this.f1858b.getChildLayoutPosition(view);
        }

        protected abstract void m3993a();

        protected abstract void m3994a(int i, int i2, C0850s c0850s, C0849a c0849a);

        protected void m3995a(PointF pointF) {
            double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x = (float) (((double) pointF.x) / sqrt);
            pointF.y = (float) (((double) pointF.y) / sqrt);
        }

        void m3996a(RecyclerView recyclerView, C0812h c0812h) {
            this.f1858b = recyclerView;
            this.f1859c = c0812h;
            if (this.f1857a == RecyclerView.NO_POSITION) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.f1858b.mState.f1939e = this.f1857a;
            this.f1861e = true;
            this.f1860d = true;
            this.f1862f = m4002e(m4006i());
            m3993a();
            this.f1858b.mViewFlinger.m4228a();
        }

        protected abstract void m3997a(View view, C0850s c0850s, C0849a c0849a);

        protected abstract void m3998b();

        protected void m3999b(View view) {
            if (m3992a(view) == m4006i()) {
                this.f1862f = view;
            }
        }

        public void m4000d(int i) {
            this.f1857a = i;
        }

        public C0812h m4001e() {
            return this.f1859c;
        }

        public View m4002e(int i) {
            return this.f1858b.mLayout.m3824c(i);
        }

        protected final void m4003f() {
            if (this.f1861e) {
                m3998b();
                this.f1858b.mState.f1939e = RecyclerView.NO_POSITION;
                this.f1862f = null;
                this.f1857a = RecyclerView.NO_POSITION;
                this.f1860d = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.f1861e = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.f1859c.m3753b(this);
                this.f1859c = null;
                this.f1858b = null;
            }
        }

        public boolean m4004g() {
            return this.f1860d;
        }

        public boolean m4005h() {
            return this.f1861e;
        }

        public int m4006i() {
            return this.f1857a;
        }

        public int m4007j() {
            return this.f1858b.mLayout.m3875u();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.1 */
    class C08201 implements Runnable {
        final /* synthetic */ RecyclerView f1895a;

        C08201(RecyclerView recyclerView) {
            this.f1895a = recyclerView;
        }

        public void run() {
            if (this.f1895a.mFirstLayoutComplete && !this.f1895a.isLayoutRequested()) {
                if (!this.f1895a.mIsAttached) {
                    this.f1895a.requestLayout();
                } else if (this.f1895a.mLayoutFrozen) {
                    this.f1895a.mLayoutRequestEaten = true;
                } else {
                    this.f1895a.consumePendingUpdateOperations();
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.2 */
    class C08212 implements Runnable {
        final /* synthetic */ RecyclerView f1896a;

        C08212(RecyclerView recyclerView) {
            this.f1896a = recyclerView;
        }

        public void run() {
            if (this.f1896a.mItemAnimator != null) {
                this.f1896a.mItemAnimator.m4109a();
            }
            this.f1896a.mPostedAnimatorRunner = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.3 */
    static class C08223 implements Interpolator {
        C08223() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.4 */
    class C08244 implements C0823b {
        final /* synthetic */ RecyclerView f1897a;

        C08244(RecyclerView recyclerView) {
            this.f1897a = recyclerView;
        }

        public void m4045a(C0853v c0853v) {
            this.f1897a.mLayout.m3797a(c0853v.itemView, this.f1897a.mRecycler);
        }

        public void m4046a(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
            this.f1897a.mRecycler.m4171d(c0853v);
            this.f1897a.animateDisappearance(c0853v, c0835c, c0835c2);
        }

        public void m4047b(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
            this.f1897a.animateAppearance(c0853v, c0835c, c0835c2);
        }

        public void m4048c(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
            c0853v.setIsRecyclable(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            if (this.f1897a.mDataSetHasChangedAfterLayout) {
                if (this.f1897a.mItemAnimator.m4112a(c0853v, c0853v, c0835c, c0835c2)) {
                    this.f1897a.postAnimationRunner();
                }
            } else if (this.f1897a.mItemAnimator.m4118c(c0853v, c0835c, c0835c2)) {
                this.f1897a.postAnimationRunner();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.5 */
    class C08265 implements C0825b {
        final /* synthetic */ RecyclerView f1898a;

        C08265(RecyclerView recyclerView) {
            this.f1898a = recyclerView;
        }

        public int m4060a() {
            return this.f1898a.getChildCount();
        }

        public int m4061a(View view) {
            return this.f1898a.indexOfChild(view);
        }

        public void m4062a(int i) {
            View childAt = this.f1898a.getChildAt(i);
            if (childAt != null) {
                this.f1898a.dispatchChildDetached(childAt);
            }
            this.f1898a.removeViewAt(i);
        }

        public void m4063a(View view, int i) {
            this.f1898a.addView(view, i);
            this.f1898a.dispatchChildAttached(view);
        }

        public void m4064a(View view, int i, LayoutParams layoutParams) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.clearTmpDetachFlag();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt);
                }
            }
            this.f1898a.attachViewToParent(view, i, layoutParams);
        }

        public C0853v m4065b(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        public View m4066b(int i) {
            return this.f1898a.getChildAt(i);
        }

        public void m4067b() {
            int a = m4060a();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < a; i += RecyclerView.VERTICAL) {
                this.f1898a.dispatchChildDetached(m4066b(i));
            }
            this.f1898a.removeAllViews();
        }

        public void m4068c(int i) {
            View b = m4066b(i);
            if (b != null) {
                C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(b);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt);
                    }
                }
            }
            this.f1898a.detachViewFromParent(i);
        }

        public void m4069c(View view) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState();
            }
        }

        public void m4070d(View view) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.6 */
    class C08286 implements C0827a {
        final /* synthetic */ RecyclerView f1899a;

        C08286(RecyclerView recyclerView) {
            this.f1899a = recyclerView;
        }

        public C0853v m4079a(int i) {
            C0853v findViewHolderForPosition = this.f1899a.findViewHolderForPosition(i, true);
            return (findViewHolderForPosition == null || this.f1899a.mChildHelper.m4518c(findViewHolderForPosition.itemView)) ? null : findViewHolderForPosition;
        }

        public void m4080a(int i, int i2) {
            this.f1899a.offsetPositionRecordsForRemove(i, i2, true);
            this.f1899a.mItemsAddedOrRemoved = true;
            C0850s c0850s = this.f1899a.mState;
            c0850s.f1943i = c0850s.f1943i + i2;
        }

        public void m4081a(int i, int i2, Object obj) {
            this.f1899a.viewRangeUpdate(i, i2, obj);
            this.f1899a.mItemsChanged = true;
        }

        public void m4082a(C0939b c0939b) {
            m4086c(c0939b);
        }

        public void m4083b(int i, int i2) {
            this.f1899a.offsetPositionRecordsForRemove(i, i2, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            this.f1899a.mItemsAddedOrRemoved = true;
        }

        public void m4084b(C0939b c0939b) {
            m4086c(c0939b);
        }

        public void m4085c(int i, int i2) {
            this.f1899a.offsetPositionRecordsForInsert(i, i2);
            this.f1899a.mItemsAddedOrRemoved = true;
        }

        void m4086c(C0939b c0939b) {
            switch (c0939b.f2436a) {
                case RecyclerView.VERTICAL /*1*/:
                    this.f1899a.mLayout.m3785a(this.f1899a, c0939b.f2437b, c0939b.f2439d);
                case RecyclerView.SCROLL_STATE_SETTLING /*2*/:
                    this.f1899a.mLayout.m3817b(this.f1899a, c0939b.f2437b, c0939b.f2439d);
                case C1373c.View_theme /*4*/:
                    this.f1899a.mLayout.m3787a(this.f1899a, c0939b.f2437b, c0939b.f2439d, c0939b.f2438c);
                case C1373c.Toolbar_contentInsetRight /*8*/:
                    this.f1899a.mLayout.m3786a(this.f1899a, c0939b.f2437b, c0939b.f2439d, (int) RecyclerView.VERTICAL);
                default:
            }
        }

        public void m4087d(int i, int i2) {
            this.f1899a.offsetPositionRecordsForMove(i, i2);
            this.f1899a.mItemsAddedOrRemoved = true;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.a */
    public static abstract class C0829a<VH extends C0853v> {
        private boolean mHasStableIds;
        private final C0830b mObservable;

        public C0829a() {
            this.mObservable = new C0830b();
            this.mHasStableIds = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(RecyclerView.VERTICAL, 519);
            C0359h.m1332a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            C0359h.m1331a();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            C0359h.m1332a(RecyclerView.TRACE_CREATE_VIEW_TAG);
            VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
            onCreateViewHolder.mItemViewType = i;
            C0359h.m1331a();
            return onCreateViewHolder;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return RecyclerView.NO_ID;
        }

        public int getItemViewType(int i) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public final boolean hasObservers() {
            return this.mObservable.m4090a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.m4091b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.m4088a(i, RecyclerView.VERTICAL);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.m4089a(i, RecyclerView.VERTICAL, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.m4092b(i, RecyclerView.VERTICAL);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.m4094d(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.m4088a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.m4089a(i, i2, obj);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.m4092b(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.m4093c(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.m4093c(i, RecyclerView.VERTICAL);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(C0831c c0831c) {
            this.mObservable.registerObserver(c0831c);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void unregisterAdapterDataObserver(C0831c c0831c) {
            this.mObservable.unregisterObserver(c0831c);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.b */
    static class C0830b extends Observable<C0831c> {
        C0830b() {
        }

        public void m4088a(int i, int i2) {
            m4089a(i, i2, null);
        }

        public void m4089a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0831c) this.mObservers.get(size)).m4098a(i, i2, obj);
            }
        }

        public boolean m4090a() {
            return !this.mObservers.isEmpty() ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void m4091b() {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0831c) this.mObservers.get(size)).m4095a();
            }
        }

        public void m4092b(int i, int i2) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0831c) this.mObservers.get(size)).m4099b(i, i2);
            }
        }

        public void m4093c(int i, int i2) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0831c) this.mObservers.get(size)).m4100c(i, i2);
            }
        }

        public void m4094d(int i, int i2) {
            for (int size = this.mObservers.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                ((C0831c) this.mObservers.get(size)).m4097a(i, i2, (int) RecyclerView.VERTICAL);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.c */
    public static abstract class C0831c {
        public void m4095a() {
        }

        public void m4096a(int i, int i2) {
        }

        public void m4097a(int i, int i2, int i3) {
        }

        public void m4098a(int i, int i2, Object obj) {
            m4096a(i, i2);
        }

        public void m4099b(int i, int i2) {
        }

        public void m4100c(int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.d */
    public interface C0832d {
        int m4101a(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.e */
    public static abstract class C0836e {
        private C0834b f1904a;
        private ArrayList<C0833a> f1905b;
        private long f1906c;
        private long f1907d;
        private long f1908e;
        private long f1909f;

        /* renamed from: android.support.v7.widget.RecyclerView.e.a */
        public interface C0833a {
            void m4102a();
        }

        /* renamed from: android.support.v7.widget.RecyclerView.e.b */
        interface C0834b {
            void m4103a(C0853v c0853v);
        }

        /* renamed from: android.support.v7.widget.RecyclerView.e.c */
        public static class C0835c {
            public int f1900a;
            public int f1901b;
            public int f1902c;
            public int f1903d;

            public C0835c m4104a(C0853v c0853v) {
                return m4105a(c0853v, RecyclerView.TOUCH_SLOP_DEFAULT);
            }

            public C0835c m4105a(C0853v c0853v, int i) {
                View view = c0853v.itemView;
                this.f1900a = view.getLeft();
                this.f1901b = view.getTop();
                this.f1902c = view.getRight();
                this.f1903d = view.getBottom();
                return this;
            }
        }

        public C0836e() {
            this.f1904a = null;
            this.f1905b = new ArrayList();
            this.f1906c = 120;
            this.f1907d = 120;
            this.f1908e = 250;
            this.f1909f = 250;
        }

        static int m4106d(C0853v c0853v) {
            int access$6500 = c0853v.mFlags & 14;
            if (c0853v.isInvalid()) {
                return 4;
            }
            if ((access$6500 & 4) != 0) {
                return access$6500;
            }
            int oldPosition = c0853v.getOldPosition();
            int adapterPosition = c0853v.getAdapterPosition();
            return (oldPosition == RecyclerView.NO_POSITION || adapterPosition == RecyclerView.NO_POSITION || oldPosition == adapterPosition) ? access$6500 : access$6500 | 2048;
        }

        public C0835c m4107a(C0850s c0850s, C0853v c0853v) {
            return m4127i().m4104a(c0853v);
        }

        public C0835c m4108a(C0850s c0850s, C0853v c0853v, int i, List<Object> list) {
            return m4127i().m4104a(c0853v);
        }

        public abstract void m4109a();

        void m4110a(C0834b c0834b) {
            this.f1904a = c0834b;
        }

        public abstract boolean m4111a(C0853v c0853v, C0835c c0835c, C0835c c0835c2);

        public abstract boolean m4112a(C0853v c0853v, C0853v c0853v2, C0835c c0835c, C0835c c0835c2);

        public boolean m4113a(C0853v c0853v, List<Object> list) {
            return m4125g(c0853v);
        }

        public abstract boolean m4114b();

        public abstract boolean m4115b(C0853v c0853v, C0835c c0835c, C0835c c0835c2);

        public abstract void m4116c();

        public abstract void m4117c(C0853v c0853v);

        public abstract boolean m4118c(C0853v c0853v, C0835c c0835c, C0835c c0835c2);

        public long m4119d() {
            return this.f1908e;
        }

        public long m4120e() {
            return this.f1906c;
        }

        public final void m4121e(C0853v c0853v) {
            m4123f(c0853v);
            if (this.f1904a != null) {
                this.f1904a.m4103a(c0853v);
            }
        }

        public long m4122f() {
            return this.f1907d;
        }

        public void m4123f(C0853v c0853v) {
        }

        public long m4124g() {
            return this.f1909f;
        }

        public boolean m4125g(C0853v c0853v) {
            return true;
        }

        public final void m4126h() {
            int size = this.f1905b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                ((C0833a) this.f1905b.get(i)).m4102a();
            }
            this.f1905b.clear();
        }

        public C0835c m4127i() {
            return new C0835c();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.f */
    private class C0837f implements C0834b {
        final /* synthetic */ RecyclerView f1910a;

        private C0837f(RecyclerView recyclerView) {
            this.f1910a = recyclerView;
        }

        public void m4128a(C0853v c0853v) {
            c0853v.setIsRecyclable(true);
            if (c0853v.mShadowedHolder != null && c0853v.mShadowingHolder == null) {
                c0853v.mShadowedHolder = null;
            }
            c0853v.mShadowingHolder = null;
            if (!c0853v.shouldBeKeptAsChild() && !this.f1910a.removeAnimatingView(c0853v.itemView) && c0853v.isTmpDetached()) {
                this.f1910a.removeDetachedView(c0853v.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.g */
    public static abstract class C0838g {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C0850s c0850s) {
            getItemOffsets(rect, ((C0810i) view.getLayoutParams()).m3737e(), recyclerView);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, C0850s c0850s) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C0850s c0850s) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.j */
    public interface C0840j {
        void m4129a(View view);

        void m4130b(View view);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.k */
    public interface C0841k {
        void m4131a(boolean z);

        boolean m4132a(RecyclerView recyclerView, MotionEvent motionEvent);

        void m4133b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.l */
    public static abstract class C0842l {
        public void m4134a(RecyclerView recyclerView, int i) {
        }

        public void m4135a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.m */
    public static class C0843m {
        private SparseArray<ArrayList<C0853v>> f1915a;
        private SparseIntArray f1916b;
        private int f1917c;

        public C0843m() {
            this.f1915a = new SparseArray();
            this.f1916b = new SparseIntArray();
            this.f1917c = RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        private ArrayList<C0853v> m4136b(int i) {
            ArrayList<C0853v> arrayList = (ArrayList) this.f1915a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f1915a.put(i, arrayList);
                if (this.f1916b.indexOfKey(i) < 0) {
                    this.f1916b.put(i, 5);
                }
            }
            return arrayList;
        }

        public C0853v m4137a(int i) {
            ArrayList arrayList = (ArrayList) this.f1915a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() + RecyclerView.NO_POSITION;
            C0853v c0853v = (C0853v) arrayList.get(size);
            arrayList.remove(size);
            return c0853v;
        }

        public void m4138a() {
            this.f1915a.clear();
        }

        void m4139a(C0829a c0829a) {
            this.f1917c += RecyclerView.VERTICAL;
        }

        void m4140a(C0829a c0829a, C0829a c0829a2, boolean z) {
            if (c0829a != null) {
                m4142b();
            }
            if (!z && this.f1917c == 0) {
                m4138a();
            }
            if (c0829a2 != null) {
                m4139a(c0829a2);
            }
        }

        public void m4141a(C0853v c0853v) {
            int itemViewType = c0853v.getItemViewType();
            ArrayList b = m4136b(itemViewType);
            if (this.f1916b.get(itemViewType) > b.size()) {
                c0853v.resetInternal();
                b.add(c0853v);
            }
        }

        void m4142b() {
            this.f1917c += RecyclerView.NO_POSITION;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.n */
    public final class C0844n {
        final ArrayList<C0853v> f1918a;
        final ArrayList<C0853v> f1919b;
        final /* synthetic */ RecyclerView f1920c;
        private ArrayList<C0853v> f1921d;
        private final List<C0853v> f1922e;
        private int f1923f;
        private C0843m f1924g;
        private C0851t f1925h;

        public C0844n(RecyclerView recyclerView) {
            this.f1920c = recyclerView;
            this.f1918a = new ArrayList();
            this.f1921d = null;
            this.f1919b = new ArrayList();
            this.f1922e = Collections.unmodifiableList(this.f1918a);
            this.f1923f = RecyclerView.SCROLL_STATE_SETTLING;
        }

        private void m4144a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() + RecyclerView.NO_POSITION; childCount >= 0; childCount += RecyclerView.NO_POSITION) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m4144a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(RecyclerView.TOUCH_SLOP_DEFAULT);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        private void m4145d(View view) {
            if (this.f1920c.isAccessibilityEnabled()) {
                if (ah.m1934e(view) == 0) {
                    ah.m1928c(view, (int) RecyclerView.VERTICAL);
                }
                if (!ah.m1925b(view)) {
                    ah.m1916a(view, this.f1920c.mAccessibilityDelegate.m4716b());
                }
            }
        }

        private void m4146f(C0853v c0853v) {
            if (c0853v.itemView instanceof ViewGroup) {
                m4144a((ViewGroup) c0853v.itemView, (boolean) RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
        }

        C0853v m4147a(int i, int i2, boolean z) {
            int i3 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int size = this.f1918a.size();
            int i4 = RecyclerView.TOUCH_SLOP_DEFAULT;
            while (i4 < size) {
                View a;
                C0853v c0853v = (C0853v) this.f1918a.get(i4);
                if (c0853v.wasReturnedFromScrap() || c0853v.getLayoutPosition() != i || c0853v.isInvalid() || (!this.f1920c.mState.f1945k && c0853v.isRemoved())) {
                    i4 += RecyclerView.VERTICAL;
                } else if (i2 == RecyclerView.NO_POSITION || c0853v.getItemViewType() == i2) {
                    c0853v.addFlags(32);
                    return c0853v;
                } else {
                    Log.e(RecyclerView.TAG, "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + c0853v.getItemViewType() + " but expected " + i2 + ")");
                    if (!z) {
                        a = this.f1920c.mChildHelper.m4506a(i, i2);
                        if (a != null) {
                            c0853v = RecyclerView.getChildViewHolderInt(a);
                            this.f1920c.mChildHelper.m4521e(a);
                            i3 = this.f1920c.mChildHelper.m4514b(a);
                            if (i3 != RecyclerView.NO_POSITION) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0853v);
                            }
                            this.f1920c.mChildHelper.m4519d(i3);
                            m4168c(a);
                            c0853v.addFlags(8224);
                            return c0853v;
                        }
                    }
                    i4 = this.f1919b.size();
                    while (i3 < i4) {
                        c0853v = (C0853v) this.f1919b.get(i3);
                        if (c0853v.isInvalid() || c0853v.getLayoutPosition() != i) {
                            i3 += RecyclerView.VERTICAL;
                        } else if (z) {
                            return c0853v;
                        } else {
                            this.f1919b.remove(i3);
                            return c0853v;
                        }
                    }
                    return null;
                }
            }
            if (z) {
                a = this.f1920c.mChildHelper.m4506a(i, i2);
                if (a != null) {
                    c0853v = RecyclerView.getChildViewHolderInt(a);
                    this.f1920c.mChildHelper.m4521e(a);
                    i3 = this.f1920c.mChildHelper.m4514b(a);
                    if (i3 != RecyclerView.NO_POSITION) {
                        this.f1920c.mChildHelper.m4519d(i3);
                        m4168c(a);
                        c0853v.addFlags(8224);
                        return c0853v;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0853v);
                }
            }
            i4 = this.f1919b.size();
            while (i3 < i4) {
                c0853v = (C0853v) this.f1919b.get(i3);
                if (c0853v.isInvalid()) {
                }
                i3 += RecyclerView.VERTICAL;
            }
            return null;
        }

        C0853v m4148a(long j, int i, boolean z) {
            int size;
            for (size = this.f1918a.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                C0853v c0853v = (C0853v) this.f1918a.get(size);
                if (c0853v.getItemId() == j && !c0853v.wasReturnedFromScrap()) {
                    if (i == c0853v.getItemViewType()) {
                        c0853v.addFlags(32);
                        if (!c0853v.isRemoved() || this.f1920c.mState.m4218a()) {
                            return c0853v;
                        }
                        c0853v.setFlags(RecyclerView.SCROLL_STATE_SETTLING, 14);
                        return c0853v;
                    } else if (!z) {
                        this.f1918a.remove(size);
                        this.f1920c.removeDetachedView(c0853v.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                        m4163b(c0853v.itemView);
                    }
                }
            }
            for (size = this.f1919b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                c0853v = (C0853v) this.f1919b.get(size);
                if (c0853v.getItemId() == j) {
                    if (i == c0853v.getItemViewType()) {
                        if (z) {
                            return c0853v;
                        }
                        this.f1919b.remove(size);
                        return c0853v;
                    } else if (!z) {
                        m4170d(size);
                    }
                }
            }
            return null;
        }

        View m4149a(int i, boolean z) {
            boolean z2 = true;
            if (i < 0 || i >= this.f1920c.mState.m4222e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f1920c.mState.m4222e());
            }
            C0853v f;
            boolean z3;
            C0853v c0853v;
            boolean z4;
            int b;
            boolean z5;
            int b2;
            LayoutParams layoutParams;
            C0810i c0810i;
            if (this.f1920c.mState.m4218a()) {
                f = m4176f(i);
                C0853v c0853v2 = f;
                z3 = f != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                c0853v = c0853v2;
            } else {
                c0853v = null;
                z3 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            if (c0853v == null) {
                c0853v = m4147a(i, (int) RecyclerView.NO_POSITION, z);
                if (c0853v != null) {
                    if (m4157a(c0853v)) {
                        z4 = true;
                    } else {
                        if (!z) {
                            c0853v.addFlags(4);
                            if (c0853v.isScrap()) {
                                this.f1920c.removeDetachedView(c0853v.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                                c0853v.unScrap();
                            } else if (c0853v.wasReturnedFromScrap()) {
                                c0853v.clearReturnedFromScrapFlag();
                            }
                            m4162b(c0853v);
                        }
                        c0853v = null;
                        z4 = z3;
                    }
                    if (c0853v == null) {
                        b = this.f1920c.mAdapterHelper.m4956b(i);
                        if (b >= 0 || b >= this.f1920c.mAdapter.getItemCount()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f1920c.mState.m4222e());
                        }
                        int itemViewType = this.f1920c.mAdapter.getItemViewType(b);
                        if (this.f1920c.mAdapter.hasStableIds()) {
                            c0853v = m4148a(this.f1920c.mAdapter.getItemId(b), itemViewType, z);
                            if (c0853v != null) {
                                c0853v.mPosition = b;
                                z4 = true;
                            }
                        }
                        if (c0853v == null && this.f1925h != null) {
                            View a = this.f1925h.m4223a(this, i, itemViewType);
                            if (a != null) {
                                c0853v = this.f1920c.getChildViewHolder(a);
                                if (c0853v == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (c0853v.shouldIgnore()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (c0853v == null) {
                            c0853v = m4175f().m4137a(itemViewType);
                            if (c0853v != null) {
                                c0853v.resetInternal();
                                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                    m4146f(c0853v);
                                }
                            }
                        }
                        if (c0853v == null) {
                            f = this.f1920c.mAdapter.createViewHolder(this.f1920c, itemViewType);
                            z5 = z4;
                            if (z5 && !this.f1920c.mState.m4218a() && f.hasAnyOfTheFlags(8192)) {
                                f.setFlags(RecyclerView.TOUCH_SLOP_DEFAULT, 8192);
                                if (this.f1920c.mState.f1946l) {
                                    this.f1920c.recordAnimationInfoIfBouncedHiddenView(f, this.f1920c.mItemAnimator.m4108a(this.f1920c.mState, f, C0836e.m4106d(f) | 4096, f.getUnmodifiedPayloads()));
                                }
                            }
                            if (!this.f1920c.mState.m4218a() && f.isBound()) {
                                f.mPreLayoutPosition = i;
                                z4 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                            } else if (f.isBound() || f.needsUpdate() || f.isInvalid()) {
                                b2 = this.f1920c.mAdapterHelper.m4956b(i);
                                f.mOwnerRecyclerView = this.f1920c;
                                this.f1920c.mAdapter.bindViewHolder(f, b2);
                                m4145d(f.itemView);
                                if (this.f1920c.mState.m4218a()) {
                                    f.mPreLayoutPosition = i;
                                }
                                z4 = true;
                            } else {
                                z4 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                            }
                            layoutParams = f.itemView.getLayoutParams();
                            if (layoutParams != null) {
                                c0810i = (C0810i) this.f1920c.generateDefaultLayoutParams();
                                f.itemView.setLayoutParams(c0810i);
                            } else if (this.f1920c.checkLayoutParams(layoutParams)) {
                                c0810i = (C0810i) layoutParams;
                            } else {
                                c0810i = (C0810i) this.f1920c.generateLayoutParams(layoutParams);
                                f.itemView.setLayoutParams(c0810i);
                            }
                            c0810i.f1819a = f;
                            if (!(z5 && r3)) {
                                z2 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                            }
                            c0810i.f1822d = z2;
                            return f.itemView;
                        }
                    }
                    f = c0853v;
                    z5 = z4;
                    f.setFlags(RecyclerView.TOUCH_SLOP_DEFAULT, 8192);
                    if (this.f1920c.mState.f1946l) {
                        this.f1920c.recordAnimationInfoIfBouncedHiddenView(f, this.f1920c.mItemAnimator.m4108a(this.f1920c.mState, f, C0836e.m4106d(f) | 4096, f.getUnmodifiedPayloads()));
                    }
                    if (!this.f1920c.mState.m4218a()) {
                    }
                    if (f.isBound()) {
                    }
                    b2 = this.f1920c.mAdapterHelper.m4956b(i);
                    f.mOwnerRecyclerView = this.f1920c;
                    this.f1920c.mAdapter.bindViewHolder(f, b2);
                    m4145d(f.itemView);
                    if (this.f1920c.mState.m4218a()) {
                        f.mPreLayoutPosition = i;
                    }
                    z4 = true;
                    layoutParams = f.itemView.getLayoutParams();
                    if (layoutParams != null) {
                        c0810i = (C0810i) this.f1920c.generateDefaultLayoutParams();
                        f.itemView.setLayoutParams(c0810i);
                    } else if (this.f1920c.checkLayoutParams(layoutParams)) {
                        c0810i = (C0810i) layoutParams;
                    } else {
                        c0810i = (C0810i) this.f1920c.generateLayoutParams(layoutParams);
                        f.itemView.setLayoutParams(c0810i);
                    }
                    c0810i.f1819a = f;
                    z2 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                    c0810i.f1822d = z2;
                    return f.itemView;
                }
            }
            z4 = z3;
            if (c0853v == null) {
                b = this.f1920c.mAdapterHelper.m4956b(i);
                if (b >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f1920c.mState.m4222e());
            }
            f = c0853v;
            z5 = z4;
            f.setFlags(RecyclerView.TOUCH_SLOP_DEFAULT, 8192);
            if (this.f1920c.mState.f1946l) {
                this.f1920c.recordAnimationInfoIfBouncedHiddenView(f, this.f1920c.mItemAnimator.m4108a(this.f1920c.mState, f, C0836e.m4106d(f) | 4096, f.getUnmodifiedPayloads()));
            }
            if (!this.f1920c.mState.m4218a()) {
            }
            if (f.isBound()) {
            }
            b2 = this.f1920c.mAdapterHelper.m4956b(i);
            f.mOwnerRecyclerView = this.f1920c;
            this.f1920c.mAdapter.bindViewHolder(f, b2);
            m4145d(f.itemView);
            if (this.f1920c.mState.m4218a()) {
                f.mPreLayoutPosition = i;
            }
            z4 = true;
            layoutParams = f.itemView.getLayoutParams();
            if (layoutParams != null) {
                c0810i = (C0810i) this.f1920c.generateDefaultLayoutParams();
                f.itemView.setLayoutParams(c0810i);
            } else if (this.f1920c.checkLayoutParams(layoutParams)) {
                c0810i = (C0810i) this.f1920c.generateLayoutParams(layoutParams);
                f.itemView.setLayoutParams(c0810i);
            } else {
                c0810i = (C0810i) layoutParams;
            }
            c0810i.f1819a = f;
            z2 = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            c0810i.f1822d = z2;
            return f.itemView;
        }

        public void m4150a() {
            this.f1918a.clear();
            m4165c();
        }

        public void m4151a(int i) {
            this.f1923f = i;
            for (int size = this.f1919b.size() + RecyclerView.NO_POSITION; size >= 0 && this.f1919b.size() > i; size += RecyclerView.NO_POSITION) {
                m4170d(size);
            }
        }

        void m4152a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = RecyclerView.NO_POSITION;
                i4 = i2;
                i5 = i;
            } else {
                i3 = RecyclerView.VERTICAL;
                i4 = i;
                i5 = i2;
            }
            int size = this.f1919b.size();
            for (int i6 = RecyclerView.TOUCH_SLOP_DEFAULT; i6 < size; i6 += RecyclerView.VERTICAL) {
                C0853v c0853v = (C0853v) this.f1919b.get(i6);
                if (c0853v != null && c0853v.mPosition >= r3 && c0853v.mPosition <= r2) {
                    if (c0853v.mPosition == i) {
                        c0853v.offsetPosition(i2 - i, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    } else {
                        c0853v.offsetPosition(i3, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    }
                }
            }
        }

        void m4153a(C0829a c0829a, C0829a c0829a2, boolean z) {
            m4150a();
            m4175f().m4140a(c0829a, c0829a2, z);
        }

        void m4154a(C0843m c0843m) {
            if (this.f1924g != null) {
                this.f1924g.m4142b();
            }
            this.f1924g = c0843m;
            if (c0843m != null) {
                this.f1924g.m4139a(this.f1920c.getAdapter());
            }
        }

        void m4155a(C0851t c0851t) {
            this.f1925h = c0851t;
        }

        public void m4156a(View view) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                this.f1920c.removeDetachedView(view, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            m4162b(childViewHolderInt);
        }

        boolean m4157a(C0853v c0853v) {
            if (c0853v.isRemoved()) {
                return this.f1920c.mState.m4218a();
            }
            if (c0853v.mPosition >= 0 && c0853v.mPosition < this.f1920c.mAdapter.getItemCount()) {
                return (this.f1920c.mState.m4218a() || this.f1920c.mAdapter.getItemViewType(c0853v.mPosition) == c0853v.getItemViewType()) ? (!this.f1920c.mAdapter.hasStableIds() || c0853v.getItemId() == this.f1920c.mAdapter.getItemId(c0853v.mPosition)) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            } else {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0853v);
            }
        }

        public int m4158b(int i) {
            if (i >= 0 && i < this.f1920c.mState.m4222e()) {
                return !this.f1920c.mState.m4218a() ? i : this.f1920c.mAdapterHelper.m4956b(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f1920c.mState.m4222e());
            }
        }

        public List<C0853v> m4159b() {
            return this.f1922e;
        }

        void m4160b(int i, int i2) {
            int size = this.f1919b.size();
            for (int i3 = RecyclerView.TOUCH_SLOP_DEFAULT; i3 < size; i3 += RecyclerView.VERTICAL) {
                C0853v c0853v = (C0853v) this.f1919b.get(i3);
                if (c0853v != null && c0853v.mPosition >= i) {
                    c0853v.offsetPosition(i2, true);
                }
            }
        }

        void m4161b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1919b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                C0853v c0853v = (C0853v) this.f1919b.get(size);
                if (c0853v != null) {
                    if (c0853v.mPosition >= i3) {
                        c0853v.offsetPosition(-i2, z);
                    } else if (c0853v.mPosition >= i) {
                        c0853v.addFlags(8);
                        m4170d(size);
                    }
                }
            }
        }

        void m4162b(C0853v c0853v) {
            boolean z = true;
            int i = RecyclerView.TOUCH_SLOP_DEFAULT;
            if (c0853v.isScrap() || c0853v.itemView.getParent() != null) {
                StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(c0853v.isScrap()).append(" isAttached:");
                if (c0853v.itemView.getParent() == null) {
                    z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (c0853v.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0853v);
            } else if (c0853v.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int i2;
                boolean access$4800 = c0853v.doesTransientStatePreventRecycling();
                boolean z2 = (this.f1920c.mAdapter != null && access$4800 && this.f1920c.mAdapter.onFailedToRecycleView(c0853v)) ? true : RecyclerView.TOUCH_SLOP_DEFAULT;
                if (z2 || c0853v.isRecyclable()) {
                    if (!c0853v.hasAnyOfTheFlags(14)) {
                        int size = this.f1919b.size();
                        if (size >= this.f1923f && size > 0) {
                            m4170d((int) RecyclerView.TOUCH_SLOP_DEFAULT);
                            size += RecyclerView.NO_POSITION;
                        }
                        if (size < this.f1923f) {
                            this.f1919b.add(c0853v);
                            z2 = true;
                            if (z2) {
                                m4167c(c0853v);
                                i = RecyclerView.VERTICAL;
                                i2 = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                    if (z2) {
                        z = z2;
                    } else {
                        m4167c(c0853v);
                        i = RecyclerView.VERTICAL;
                        i2 = z2;
                    }
                } else {
                    i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
                this.f1920c.mViewInfoStore.m4863g(c0853v);
                if (i2 == 0 && r1 == 0 && access$4800) {
                    c0853v.mOwnerRecyclerView = null;
                }
            }
        }

        void m4163b(View view) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            childViewHolderInt.clearReturnedFromScrapFlag();
            m4162b(childViewHolderInt);
        }

        public View m4164c(int i) {
            return m4149a(i, (boolean) RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        void m4165c() {
            for (int size = this.f1919b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                m4170d(size);
            }
            this.f1919b.clear();
        }

        void m4166c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.f1919b.size() + RecyclerView.NO_POSITION; size >= 0; size += RecyclerView.NO_POSITION) {
                C0853v c0853v = (C0853v) this.f1919b.get(size);
                if (c0853v != null) {
                    int layoutPosition = c0853v.getLayoutPosition();
                    if (layoutPosition >= i && layoutPosition < i3) {
                        c0853v.addFlags(RecyclerView.SCROLL_STATE_SETTLING);
                        m4170d(size);
                    }
                }
            }
        }

        void m4167c(C0853v c0853v) {
            ah.m1916a(c0853v.itemView, null);
            m4174e(c0853v);
            c0853v.mOwnerRecyclerView = null;
            m4175f().m4141a(c0853v);
        }

        void m4168c(View view) {
            C0853v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !this.f1920c.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f1921d == null) {
                    this.f1921d = new ArrayList();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f1921d.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.f1920c.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                this.f1918a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        int m4169d() {
            return this.f1918a.size();
        }

        void m4170d(int i) {
            m4167c((C0853v) this.f1919b.get(i));
            this.f1919b.remove(i);
        }

        void m4171d(C0853v c0853v) {
            if (c0853v.mInChangeScrap) {
                this.f1921d.remove(c0853v);
            } else {
                this.f1918a.remove(c0853v);
            }
            c0853v.mScrapContainer = null;
            c0853v.mInChangeScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            c0853v.clearReturnedFromScrapFlag();
        }

        View m4172e(int i) {
            return ((C0853v) this.f1918a.get(i)).itemView;
        }

        void m4173e() {
            this.f1918a.clear();
            if (this.f1921d != null) {
                this.f1921d.clear();
            }
        }

        void m4174e(C0853v c0853v) {
            if (this.f1920c.mRecyclerListener != null) {
                this.f1920c.mRecyclerListener.m4181a(c0853v);
            }
            if (this.f1920c.mAdapter != null) {
                this.f1920c.mAdapter.onViewRecycled(c0853v);
            }
            if (this.f1920c.mState != null) {
                this.f1920c.mViewInfoStore.m4863g(c0853v);
            }
        }

        C0843m m4175f() {
            if (this.f1924g == null) {
                this.f1924g = new C0843m();
            }
            return this.f1924g;
        }

        C0853v m4176f(int i) {
            int i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
            if (this.f1921d != null) {
                int size = this.f1921d.size();
                if (size != 0) {
                    C0853v c0853v;
                    int i3 = RecyclerView.TOUCH_SLOP_DEFAULT;
                    while (i3 < size) {
                        c0853v = (C0853v) this.f1921d.get(i3);
                        if (c0853v.wasReturnedFromScrap() || c0853v.getLayoutPosition() != i) {
                            i3 += RecyclerView.VERTICAL;
                        } else {
                            c0853v.addFlags(32);
                            return c0853v;
                        }
                    }
                    if (this.f1920c.mAdapter.hasStableIds()) {
                        int b = this.f1920c.mAdapterHelper.m4956b(i);
                        if (b > 0 && b < this.f1920c.mAdapter.getItemCount()) {
                            long itemId = this.f1920c.mAdapter.getItemId(b);
                            while (i2 < size) {
                                c0853v = (C0853v) this.f1921d.get(i2);
                                if (c0853v.wasReturnedFromScrap() || c0853v.getItemId() != itemId) {
                                    i2 += RecyclerView.VERTICAL;
                                } else {
                                    c0853v.addFlags(32);
                                    return c0853v;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        void m4177g() {
            int size = this.f1919b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                C0853v c0853v = (C0853v) this.f1919b.get(i);
                if (c0853v != null) {
                    c0853v.addFlags(512);
                }
            }
        }

        void m4178h() {
            if (this.f1920c.mAdapter == null || !this.f1920c.mAdapter.hasStableIds()) {
                m4165c();
                return;
            }
            int size = this.f1919b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                C0853v c0853v = (C0853v) this.f1919b.get(i);
                if (c0853v != null) {
                    c0853v.addFlags(6);
                    c0853v.addChangePayload(null);
                }
            }
        }

        void m4179i() {
            int i;
            int i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
            int size = this.f1919b.size();
            for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                ((C0853v) this.f1919b.get(i)).clearOldPosition();
            }
            size = this.f1918a.size();
            for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                ((C0853v) this.f1918a.get(i)).clearOldPosition();
            }
            if (this.f1921d != null) {
                i = this.f1921d.size();
                while (i2 < i) {
                    ((C0853v) this.f1921d.get(i2)).clearOldPosition();
                    i2 += RecyclerView.VERTICAL;
                }
            }
        }

        void m4180j() {
            int size = this.f1919b.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < size; i += RecyclerView.VERTICAL) {
                C0810i c0810i = (C0810i) ((C0853v) this.f1919b.get(i)).itemView.getLayoutParams();
                if (c0810i != null) {
                    c0810i.f1821c = true;
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.o */
    public interface C0845o {
        void m4181a(C0853v c0853v);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.p */
    private class C0846p extends C0831c {
        final /* synthetic */ RecyclerView f1926a;

        private C0846p(RecyclerView recyclerView) {
            this.f1926a = recyclerView;
        }

        public void m4182a() {
            this.f1926a.assertNotInLayoutOrScroll(null);
            if (this.f1926a.mAdapter.hasStableIds()) {
                this.f1926a.mState.f1944j = true;
                this.f1926a.setDataSetChangedAfterLayout();
            } else {
                this.f1926a.mState.f1944j = true;
                this.f1926a.setDataSetChangedAfterLayout();
            }
            if (!this.f1926a.mAdapterHelper.m4962d()) {
                this.f1926a.requestLayout();
            }
        }

        public void m4183a(int i, int i2, int i3) {
            this.f1926a.assertNotInLayoutOrScroll(null);
            if (this.f1926a.mAdapterHelper.m4954a(i, i2, i3)) {
                m4185b();
            }
        }

        public void m4184a(int i, int i2, Object obj) {
            this.f1926a.assertNotInLayoutOrScroll(null);
            if (this.f1926a.mAdapterHelper.m4955a(i, i2, obj)) {
                m4185b();
            }
        }

        void m4185b() {
            if (this.f1926a.mPostUpdatesOnAnimation && this.f1926a.mHasFixedSize && this.f1926a.mIsAttached) {
                ah.m1917a(this.f1926a, this.f1926a.mUpdateChildViewsRunnable);
                return;
            }
            this.f1926a.mAdapterUpdateDuringMeasure = true;
            this.f1926a.requestLayout();
        }

        public void m4186b(int i, int i2) {
            this.f1926a.assertNotInLayoutOrScroll(null);
            if (this.f1926a.mAdapterHelper.m4958b(i, i2)) {
                m4185b();
            }
        }

        public void m4187c(int i, int i2) {
            this.f1926a.assertNotInLayoutOrScroll(null);
            if (this.f1926a.mAdapterHelper.m4961c(i, i2)) {
                m4185b();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.q */
    public static class C0848q extends C0120a {
        public static final Creator<C0848q> CREATOR;
        Parcelable f1927a;

        /* renamed from: android.support.v7.widget.RecyclerView.q.1 */
        static class C08471 implements C0118e<C0848q> {
            C08471() {
            }

            public C0848q m4188a(Parcel parcel, ClassLoader classLoader) {
                return new C0848q(parcel, classLoader);
            }

            public C0848q[] m4189a(int i) {
                return new C0848q[i];
            }

            public /* synthetic */ Object m4190b(Parcel parcel, ClassLoader classLoader) {
                return m4188a(parcel, classLoader);
            }

            public /* synthetic */ Object[] m4191b(int i) {
                return m4189a(i);
            }
        }

        static {
            CREATOR = C0356d.m1329a(new C08471());
        }

        C0848q(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = C0812h.class.getClassLoader();
            }
            this.f1927a = parcel.readParcelable(classLoader);
        }

        C0848q(Parcelable parcelable) {
            super(parcelable);
        }

        private void m4192a(C0848q c0848q) {
            this.f1927a = c0848q.f1927a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1927a, RecyclerView.TOUCH_SLOP_DEFAULT);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.s */
    public static class C0850s {
        int f1935a;
        int f1936b;
        long f1937c;
        int f1938d;
        private int f1939e;
        private int f1940f;
        private SparseArray<Object> f1941g;
        private int f1942h;
        private int f1943i;
        private boolean f1944j;
        private boolean f1945k;
        private boolean f1946l;
        private boolean f1947m;
        private boolean f1948n;
        private boolean f1949o;

        public C0850s() {
            this.f1939e = RecyclerView.NO_POSITION;
            this.f1940f = RecyclerView.VERTICAL;
            this.f1935a = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1942h = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1943i = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1944j = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1945k = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1946l = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1947m = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1948n = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1949o = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void m4217a(int i) {
            if ((this.f1940f & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f1940f));
            }
        }

        public boolean m4218a() {
            return this.f1945k;
        }

        public boolean m4219b() {
            return this.f1947m;
        }

        public int m4220c() {
            return this.f1939e;
        }

        public boolean m4221d() {
            return this.f1939e != RecyclerView.NO_POSITION ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public int m4222e() {
            return this.f1945k ? this.f1942h - this.f1943i : this.f1935a;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1939e + ", mData=" + this.f1941g + ", mItemCount=" + this.f1935a + ", mPreviousLayoutItemCount=" + this.f1942h + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1943i + ", mStructureChanged=" + this.f1944j + ", mInPreLayout=" + this.f1945k + ", mRunSimpleAnimations=" + this.f1946l + ", mRunPredictiveAnimations=" + this.f1947m + '}';
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.t */
    public static abstract class C0851t {
        public abstract View m4223a(C0844n c0844n, int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView.u */
    private class C0852u implements Runnable {
        final /* synthetic */ RecyclerView f1950a;
        private int f1951b;
        private int f1952c;
        private C0632w f1953d;
        private Interpolator f1954e;
        private boolean f1955f;
        private boolean f1956g;

        public C0852u(RecyclerView recyclerView) {
            this.f1950a = recyclerView;
            this.f1954e = RecyclerView.sQuinticInterpolator;
            this.f1955f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1956g = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1953d = C0632w.m2777a(recyclerView.getContext(), RecyclerView.sQuinticInterpolator);
        }

        private float m4224a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int m4225b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? RecyclerView.VERTICAL : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.f1950a.getWidth() : this.f1950a.getHeight();
            int i5 = width / RecyclerView.SCROLL_STATE_SETTLING;
            float a = (m4224a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, RecyclerView.MAX_SCROLL_DURATION);
        }

        private void m4226c() {
            this.f1956g = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.f1955f = true;
        }

        private void m4227d() {
            this.f1955f = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.f1956g) {
                m4228a();
            }
        }

        void m4228a() {
            if (this.f1955f) {
                this.f1956g = true;
                return;
            }
            this.f1950a.removeCallbacks(this);
            ah.m1917a(this.f1950a, (Runnable) this);
        }

        public void m4229a(int i, int i2) {
            this.f1950a.setScrollState(RecyclerView.SCROLL_STATE_SETTLING);
            this.f1952c = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1951b = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1953d.m2780a(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m4228a();
        }

        public void m4230a(int i, int i2, int i3) {
            m4232a(i, i2, i3, RecyclerView.sQuinticInterpolator);
        }

        public void m4231a(int i, int i2, int i3, int i4) {
            m4230a(i, i2, m4225b(i, i2, i3, i4));
        }

        public void m4232a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f1954e != interpolator) {
                this.f1954e = interpolator;
                this.f1953d = C0632w.m2777a(this.f1950a.getContext(), interpolator);
            }
            this.f1950a.setScrollState(RecyclerView.SCROLL_STATE_SETTLING);
            this.f1952c = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1951b = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.f1953d.m2779a(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, i, i2, i3);
            m4228a();
        }

        public void m4233b() {
            this.f1950a.removeCallbacks(this);
            this.f1953d.m2790h();
        }

        public void m4234b(int i, int i2) {
            m4231a(i, i2, (int) RecyclerView.TOUCH_SLOP_DEFAULT, (int) RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        public void run() {
            if (this.f1950a.mLayout == null) {
                m4233b();
                return;
            }
            m4226c();
            this.f1950a.consumePendingUpdateOperations();
            C0632w c0632w = this.f1953d;
            C0813r c0813r = this.f1950a.mLayout.f1834r;
            if (c0632w.m2789g()) {
                int e;
                int i;
                int f;
                int i2;
                Object obj;
                Object obj2;
                int b = c0632w.m2784b();
                int c = c0632w.m2785c();
                int i3 = b - this.f1951b;
                int i4 = c - this.f1952c;
                int i5 = RecyclerView.TOUCH_SLOP_DEFAULT;
                int i6 = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.f1951b = b;
                this.f1952c = c;
                int i7 = RecyclerView.TOUCH_SLOP_DEFAULT;
                int i8 = RecyclerView.TOUCH_SLOP_DEFAULT;
                if (this.f1950a.mAdapter != null) {
                    this.f1950a.eatRequestLayout();
                    this.f1950a.onEnterLayoutOrScroll();
                    C0359h.m1332a(RecyclerView.TRACE_SCROLL_TAG);
                    if (i3 != 0) {
                        i5 = this.f1950a.mLayout.m3765a(i3, this.f1950a.mRecycler, this.f1950a.mState);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.f1950a.mLayout.m3812b(i4, this.f1950a.mRecycler, this.f1950a.mState);
                        i8 = i4 - i6;
                    }
                    C0359h.m1331a();
                    this.f1950a.repositionShadowingViews();
                    this.f1950a.onExitLayoutOrScroll();
                    this.f1950a.resumeRequestLayout(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    if (!(c0813r == null || c0813r.m4004g() || !c0813r.m4005h())) {
                        e = this.f1950a.mState.m4222e();
                        if (e == 0) {
                            c0813r.m4003f();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else if (c0813r.m4006i() >= e) {
                            c0813r.m4000d(e + RecyclerView.NO_POSITION);
                            c0813r.m3990a(i3 - i7, i4 - i8);
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else {
                            c0813r.m3990a(i3 - i7, i4 - i8);
                        }
                        if (!this.f1950a.mItemDecorations.isEmpty()) {
                            this.f1950a.invalidate();
                        }
                        if (ah.m1907a(this.f1950a) != RecyclerView.SCROLL_STATE_SETTLING) {
                            this.f1950a.considerReleasingGlowsOnScroll(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            f = (int) c0632w.m2788f();
                            if (i6 == b) {
                                e = i6 >= 0 ? -f : i6 <= 0 ? f : RecyclerView.TOUCH_SLOP_DEFAULT;
                                i2 = e;
                            } else {
                                i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                            }
                            if (i8 != c) {
                                f = RecyclerView.TOUCH_SLOP_DEFAULT;
                            } else if (i8 < 0) {
                                f = -f;
                            } else if (i8 <= 0) {
                                f = RecyclerView.TOUCH_SLOP_DEFAULT;
                            }
                            if (ah.m1907a(this.f1950a) != RecyclerView.SCROLL_STATE_SETTLING) {
                                this.f1950a.absorbGlows(i2, f);
                            }
                            if ((i2 != 0 || i6 == b || c0632w.m2786d() == 0) && (f != 0 || i8 == c || c0632w.m2787e() == 0)) {
                                c0632w.m2790h();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.f1950a.dispatchOnScrolled(i5, i7);
                        }
                        if (!this.f1950a.awakenScrollBars()) {
                            this.f1950a.invalidate();
                        }
                        obj = (i4 == 0 && this.f1950a.mLayout.m3850f() && i7 == i4) ? RecyclerView.VERTICAL : RecyclerView.TOUCH_SLOP_DEFAULT;
                        obj2 = (i3 == 0 && this.f1950a.mLayout.m3845e() && i5 == i3) ? RecyclerView.VERTICAL : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : RecyclerView.VERTICAL;
                        if (!c0632w.m2782a() || obj2 == null) {
                            this.f1950a.setScrollState(RecyclerView.TOUCH_SLOP_DEFAULT);
                        } else {
                            m4228a();
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.f1950a.mItemDecorations.isEmpty()) {
                    this.f1950a.invalidate();
                }
                if (ah.m1907a(this.f1950a) != RecyclerView.SCROLL_STATE_SETTLING) {
                    this.f1950a.considerReleasingGlowsOnScroll(i3, i4);
                }
                f = (int) c0632w.m2788f();
                if (i6 == b) {
                    i2 = RecyclerView.TOUCH_SLOP_DEFAULT;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = e;
                }
                if (i8 != c) {
                    f = RecyclerView.TOUCH_SLOP_DEFAULT;
                } else if (i8 < 0) {
                    f = -f;
                } else if (i8 <= 0) {
                    f = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
                if (ah.m1907a(this.f1950a) != RecyclerView.SCROLL_STATE_SETTLING) {
                    this.f1950a.absorbGlows(i2, f);
                }
                c0632w.m2790h();
                this.f1950a.dispatchOnScrolled(i5, i7);
                if (this.f1950a.awakenScrollBars()) {
                    this.f1950a.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (c0632w.m2782a()) {
                }
                this.f1950a.setScrollState(RecyclerView.TOUCH_SLOP_DEFAULT);
            }
            if (c0813r != null) {
                if (c0813r.m4004g()) {
                    c0813r.m3990a((int) RecyclerView.TOUCH_SLOP_DEFAULT, (int) RecyclerView.TOUCH_SLOP_DEFAULT);
                }
                if (!this.f1956g) {
                    c0813r.m4003f();
                }
            }
            m4227d();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.v */
    public static abstract class C0853v {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS;
        public final View itemView;
        private int mFlags;
        private boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;
        int mPosition;
        int mPreLayoutPosition;
        private C0844n mScrapContainer;
        C0853v mShadowedHolder;
        C0853v mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        static {
            FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        }

        public C0853v(View view) {
            this.mPosition = RecyclerView.NO_POSITION;
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mItemId = RecyclerView.NO_ID;
            this.mItemViewType = RecyclerView.NO_POSITION;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mScrapContainer = null;
            this.mInChangeScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mWasImportantForAccessibilityBeforeHidden = RecyclerView.TOUCH_SLOP_DEFAULT;
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        private boolean doesTransientStatePreventRecycling() {
            return ((this.mFlags & FLAG_NOT_RECYCLABLE) == 0 && ah.m1930c(this.itemView)) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        private void onEnteredHiddenState() {
            this.mWasImportantForAccessibilityBeforeHidden = ah.m1934e(this.itemView);
            ah.m1928c(this.itemView, (int) FLAG_INVALID);
        }

        private void onLeftHiddenState() {
            ah.m1928c(this.itemView, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        private boolean shouldBeKeptAsChild() {
            return (this.mFlags & FLAG_NOT_RECYCLABLE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i) {
            this.mFlags |= i;
        }

        void clearOldPosition() {
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
        }

        void clearPayload() {
            if (this.mPayloads != null) {
                this.mPayloads.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(FLAG_REMOVED);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            return this.mOwnerRecyclerView == null ? RecyclerView.NO_POSITION : this.mOwnerRecyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            return this.mPreLayoutPosition == RecyclerView.NO_POSITION ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            return this.mPreLayoutPosition == RecyclerView.NO_POSITION ? this.mPosition : this.mPreLayoutPosition;
        }

        List<Object> getUnmodifiedPayloads() {
            return (this.mFlags & FLAG_ADAPTER_FULLUPDATE) == 0 ? (this.mPayloads == null || this.mPayloads.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads : FULLUPDATE_PAYLOADS;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (this.mFlags & i) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isAdapterPositionUnknown() {
            return ((this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid()) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isBound() {
            return (this.mFlags & FLAG_BOUND) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isInvalid() {
            return (this.mFlags & FLAG_INVALID) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public final boolean isRecyclable() {
            return ((this.mFlags & FLAG_NOT_RECYCLABLE) != 0 || ah.m1930c(this.itemView)) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        boolean isRemoved() {
            return (this.mFlags & FLAG_REMOVED) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isScrap() {
            return this.mScrapContainer != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isUpdated() {
            return (this.mFlags & FLAG_UPDATE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean needsUpdate() {
            return (this.mFlags & FLAG_UPDATE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == RecyclerView.NO_POSITION) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == RecyclerView.NO_POSITION) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((C0810i) this.itemView.getLayoutParams()).f1821c = true;
            }
        }

        void resetInternal() {
            this.mFlags = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mPosition = RecyclerView.NO_POSITION;
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mItemId = RecyclerView.NO_ID;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
            this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        void saveOldPosition() {
            if (this.mOldPosition == RecyclerView.NO_POSITION) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i, int i2) {
            this.mFlags = (this.mFlags & (i2 ^ RecyclerView.NO_POSITION)) | (i & i2);
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount + RecyclerView.NO_POSITION : this.mIsRecyclableCount + FLAG_BOUND;
            if (this.mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.mIsRecyclableCount == FLAG_BOUND) {
                this.mFlags |= FLAG_NOT_RECYCLABLE;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(C0844n c0844n, boolean z) {
            this.mScrapContainer = c0844n;
            this.mInChangeScrap = z;
        }

        boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                stringBuilder.append(" scrap ").append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (needsUpdate()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (shouldIgnore()) {
                stringBuilder.append(" ignored");
            }
            if (isTmpDetached()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                stringBuilder.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        void unScrap() {
            this.mScrapContainer.m4171d(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & FLAG_RETURNED_FROM_SCRAP) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    static {
        int[] iArr = new int[VERTICAL];
        iArr[TOUCH_SLOP_DEFAULT] = 16843830;
        NESTED_SCROLLING_ATTRS = iArr;
        iArr = new int[VERTICAL];
        iArr[TOUCH_SLOP_DEFAULT] = 16842987;
        CLIP_TO_PADDING_ATTR = iArr;
        boolean z = (VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        FORCE_INVALIDATE_DISPLAY_LIST = z;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = VERSION.SDK_INT >= 23 ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new C08223();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TOUCH_SLOP_DEFAULT);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.mObserver = new C0846p();
        this.mRecycler = new C0844n(this);
        this.mViewInfoStore = new bi();
        this.mUpdateChildViewsRunnable = new C08201(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mEatRequestLayout = TOUCH_SLOP_DEFAULT;
        this.mDataSetHasChangedAfterLayout = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayoutOrScrollCounter = TOUCH_SLOP_DEFAULT;
        this.mItemAnimator = new ae();
        this.mScrollState = TOUCH_SLOP_DEFAULT;
        this.mScrollPointerId = NO_POSITION;
        this.mScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new C0852u(this);
        this.mState = new C0850s();
        this.mItemsAddedOrRemoved = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemsChanged = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemAnimatorListener = new C0837f();
        this.mPostedAnimatorRunner = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mMinMaxLayoutPositions = new int[SCROLL_STATE_SETTLING];
        this.mScrollOffset = new int[SCROLL_STATE_SETTLING];
        this.mScrollConsumed = new int[SCROLL_STATE_SETTLING];
        this.mNestedOffsets = new int[SCROLL_STATE_SETTLING];
        this.mItemAnimatorRunner = new C08212(this);
        this.mViewInfoProcessCallback = new C08244(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CLIP_TO_PADDING_ATTR, i, TOUCH_SLOP_DEFAULT);
            this.mClipToPadding = obtainStyledAttributes.getBoolean(TOUCH_SLOP_DEFAULT, true);
            obtainStyledAttributes.recycle();
        } else {
            this.mClipToPadding = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.mPostUpdatesOnAnimation = VERSION.SDK_INT >= 16 ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(ah.m1907a(this) == SCROLL_STATE_SETTLING ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        this.mItemAnimator.m4110a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (ah.m1934e(this) == 0) {
            ah.m1928c((View) this, (int) VERTICAL);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new at(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0735a.RecyclerView, i, TOUCH_SLOP_DEFAULT);
            String string = obtainStyledAttributes.getString(C0735a.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(C0735a.RecyclerView_android_descendantFocusability, NO_POSITION) == NO_POSITION) {
                setDescendantFocusability(262144);
            }
            obtainStyledAttributes.recycle();
            createLayoutManager(context, string, attributeSet, i, TOUCH_SLOP_DEFAULT);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, TOUCH_SLOP_DEFAULT);
                z = obtainStyledAttributes.getBoolean(TOUCH_SLOP_DEFAULT, true);
                obtainStyledAttributes.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    private void addAnimatingView(C0853v c0853v) {
        View view = c0853v.itemView;
        boolean z = view.getParent() == this ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        this.mRecycler.m4171d(getChildViewHolder(view));
        if (c0853v.isTmpDetached()) {
            this.mChildHelper.m4510a(view, NO_POSITION, view.getLayoutParams(), true);
        } else if (z) {
            this.mChildHelper.m4520d(view);
        } else {
            this.mChildHelper.m4512a(view, true);
        }
    }

    private void animateAppearance(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
        c0853v.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        if (this.mItemAnimator.m4115b(c0853v, c0835c, c0835c2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(C0853v c0853v, C0853v c0853v2, C0835c c0835c, C0835c c0835c2, boolean z, boolean z2) {
        c0853v.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        if (z) {
            addAnimatingView(c0853v);
        }
        if (c0853v != c0853v2) {
            if (z2) {
                addAnimatingView(c0853v2);
            }
            c0853v.mShadowedHolder = c0853v2;
            addAnimatingView(c0853v);
            this.mRecycler.m4171d(c0853v);
            c0853v2.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
            c0853v2.mShadowingHolder = c0853v;
        }
        if (this.mItemAnimator.m4112a(c0853v, c0853v2, c0835c, c0835c2)) {
            postAnimationRunner();
        }
    }

    private void animateDisappearance(C0853v c0853v, C0835c c0835c, C0835c c0835c2) {
        addAnimatingView(c0853v);
        c0853v.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        if (this.mItemAnimator.m4111a(c0853v, c0835c, c0835c2)) {
            postAnimationRunner();
        }
    }

    private boolean canReuseUpdatedViewHolder(C0853v c0853v) {
        return (this.mItemAnimator == null || this.mItemAnimator.m4113a(c0853v, c0853v.getUnmodifiedPayloads())) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(TOUCH_SLOP_DEFAULT);
    }

    private void considerReleasingGlowsOnScroll(int i, int i2) {
        int i3 = TOUCH_SLOP_DEFAULT;
        if (!(this.mLeftGlow == null || this.mLeftGlow.m2638a() || i <= 0)) {
            i3 = this.mLeftGlow.m2644c();
        }
        if (!(this.mRightGlow == null || this.mRightGlow.m2638a() || i >= 0)) {
            i3 |= this.mRightGlow.m2644c();
        }
        if (!(this.mTopGlow == null || this.mTopGlow.m2638a() || i2 <= 0)) {
            i3 |= this.mTopGlow.m2644c();
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.m2638a() || i2 >= 0)) {
            i3 |= this.mBottomGlow.m2644c();
        }
        if (i3 != 0) {
            ah.m1931d(this);
        }
    }

    private void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            C0359h.m1332a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            C0359h.m1331a();
        } else if (!this.mAdapterHelper.m4962d()) {
        } else {
            if (this.mAdapterHelper.m4953a(4) && !this.mAdapterHelper.m4953a(11)) {
                C0359h.m1332a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                eatRequestLayout();
                this.mAdapterHelper.m4957b();
                if (!this.mLayoutRequestEaten) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.m4960c();
                    }
                }
                resumeRequestLayout(true);
                C0359h.m1331a();
            } else if (this.mAdapterHelper.m4962d()) {
                C0359h.m1332a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                C0359h.m1331a();
            }
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    Object[] objArr;
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(fullClassName).asSubclass(C0812h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[TOUCH_SLOP_DEFAULT]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C0812h) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e32222);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        if (this.mChildHelper.m4513b() == 0) {
            return (i == 0 && i2 == 0) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        } else {
            findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
            return (this.mMinMaxLayoutPositions[TOUCH_SLOP_DEFAULT] == i && this.mMinMaxLayoutPositions[VERTICAL] == i2) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        }
    }

    private void dispatchChildAttached(View view) {
        C0853v childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewAttachedToWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() + NO_POSITION; size >= 0; size += NO_POSITION) {
                ((C0840j) this.mOnChildAttachStateListeners.get(size)).m4129a(view);
            }
        }
    }

    private void dispatchChildDetached(View view) {
        C0853v childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() + NO_POSITION; size >= 0; size += NO_POSITION) {
                ((C0840j) this.mOnChildAttachStateListeners.get(size)).m4130b(view);
            }
        }
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = TOUCH_SLOP_DEFAULT;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0402a.m1483a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        int b;
        int i;
        C0853v childViewHolderInt;
        boolean z = true;
        this.mState.m4217a((int) VERTICAL);
        this.mState.f1949o = FORCE_INVALIDATE_DISPLAY_LIST;
        eatRequestLayout();
        this.mViewInfoStore.m4850a();
        onEnterLayoutOrScroll();
        saveFocusInfo();
        processAdapterUpdatesAndSetAnimationFlags();
        C0850s c0850s = this.mState;
        if (!(this.mState.f1946l && this.mItemsChanged)) {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        c0850s.f1948n = z;
        this.mItemsChanged = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemsAddedOrRemoved = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.f1945k = this.mState.f1947m;
        this.mState.f1935a = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f1946l) {
            b = this.mChildHelper.m4513b();
            for (i = TOUCH_SLOP_DEFAULT; i < b; i += VERTICAL) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4515b(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.m4852a(childViewHolderInt, this.mItemAnimator.m4108a(this.mState, childViewHolderInt, C0836e.m4106d(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (!(!this.mState.f1948n || !childViewHolderInt.isUpdated() || childViewHolderInt.isRemoved() || childViewHolderInt.shouldIgnore() || childViewHolderInt.isInvalid())) {
                        this.mViewInfoStore.m4851a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f1947m) {
            saveOldPositions();
            z = this.mState.f1944j;
            this.mState.f1944j = FORCE_INVALIDATE_DISPLAY_LIST;
            this.mLayout.m3827c(this.mRecycler, this.mState);
            this.mState.f1944j = z;
            for (i = TOUCH_SLOP_DEFAULT; i < this.mChildHelper.m4513b(); i += VERTICAL) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4515b(i));
                if (!(childViewHolderInt.shouldIgnore() || this.mViewInfoStore.m4860d(childViewHolderInt))) {
                    b = C0836e.m4106d(childViewHolderInt);
                    boolean hasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        b |= 4096;
                    }
                    C0835c a = this.mItemAnimator.m4108a(this.mState, childViewHolderInt, b, childViewHolderInt.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt, a);
                    } else {
                        this.mViewInfoStore.m4857b(childViewHolderInt, a);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        this.mState.f1940f = SCROLL_STATE_SETTLING;
    }

    private void dispatchLayoutStep2() {
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m4217a(6);
        this.mAdapterHelper.m4963e();
        this.mState.f1935a = this.mAdapter.getItemCount();
        this.mState.f1943i = TOUCH_SLOP_DEFAULT;
        this.mState.f1945k = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayout.m3827c(this.mRecycler, this.mState);
        this.mState.f1944j = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mPendingSavedState = null;
        C0850s c0850s = this.mState;
        boolean z = (!this.mState.f1946l || this.mItemAnimator == null) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        c0850s.f1946l = z;
        this.mState.f1940f = 4;
        onExitLayoutOrScroll();
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
    }

    private void dispatchLayoutStep3() {
        this.mState.m4217a(4);
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.f1940f = VERTICAL;
        if (this.mState.f1946l) {
            for (int b = this.mChildHelper.m4513b() + NO_POSITION; b >= 0; b += NO_POSITION) {
                C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4515b(b));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    C0835c a = this.mItemAnimator.m4107a(this.mState, childViewHolderInt);
                    C0853v a2 = this.mViewInfoStore.m4849a(changedHolderKey);
                    if (a2 == null || a2.shouldIgnore()) {
                        this.mViewInfoStore.m4859c(childViewHolderInt, a);
                    } else {
                        boolean a3 = this.mViewInfoStore.m4854a(a2);
                        boolean a4 = this.mViewInfoStore.m4854a(childViewHolderInt);
                        if (a3 && a2 == childViewHolderInt) {
                            this.mViewInfoStore.m4859c(childViewHolderInt, a);
                        } else {
                            C0835c b2 = this.mViewInfoStore.m4855b(a2);
                            this.mViewInfoStore.m4859c(childViewHolderInt, a);
                            C0835c c = this.mViewInfoStore.m4858c(childViewHolderInt);
                            if (b2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a2);
                            } else {
                                animateChange(a2, childViewHolderInt, b2, c, a3, a4);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.m4853a(this.mViewInfoProcessCallback);
        }
        this.mLayout.m3815b(this.mRecycler);
        this.mState.f1942h = this.mState.f1935a;
        this.mDataSetHasChangedAfterLayout = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.f1946l = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.f1947m = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayout.f1825a = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mRecycler.f1921d != null) {
            this.mRecycler.f1921d.clear();
        }
        this.mLayout.m3783a(this.mState);
        onExitLayoutOrScroll();
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        this.mViewInfoStore.m4850a();
        if (didChildRangeChange(this.mMinMaxLayoutPositions[TOUCH_SLOP_DEFAULT], this.mMinMaxLayoutPositions[VERTICAL])) {
            dispatchOnScrolled(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.m4133b(this, motionEvent);
                if (action == 3 || action == VERTICAL) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
                C0841k c0841k = (C0841k) this.mOnItemTouchListeners.get(i);
                if (c0841k.m4132a(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = c0841k;
                    return true;
                }
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        int i = TOUCH_SLOP_DEFAULT;
        while (i < size) {
            C0841k c0841k = (C0841k) this.mOnItemTouchListeners.get(i);
            if (!c0841k.m4132a(this, motionEvent) || action == 3) {
                i += VERTICAL;
            } else {
                this.mActiveOnItemTouchListener = c0841k;
                return true;
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int b = this.mChildHelper.m4513b();
        if (b == 0) {
            iArr[TOUCH_SLOP_DEFAULT] = TOUCH_SLOP_DEFAULT;
            iArr[VERTICAL] = TOUCH_SLOP_DEFAULT;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = TOUCH_SLOP_DEFAULT;
        while (i3 < b) {
            int i4;
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4515b(i3));
            if (childViewHolderInt.shouldIgnore()) {
                i4 = i;
            } else {
                i4 = childViewHolderInt.getLayoutPosition();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3 += VERTICAL;
            i = i4;
        }
        iArr[TOUCH_SLOP_DEFAULT] = i;
        iArr[VERTICAL] = i2;
    }

    private int getAdapterPositionFor(C0853v c0853v) {
        return (c0853v.hasAnyOfTheFlags(524) || !c0853v.isBound()) ? NO_POSITION : this.mAdapterHelper.m4959c(c0853v.mPosition);
    }

    static C0853v getChildViewHolderInt(View view) {
        return view == null ? null : ((C0810i) view.getLayoutParams()).f1819a;
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        View view2 = view;
        while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
            view = ((ViewGroup) view2).getFocusedChild();
            id = view.getId() != NO_POSITION ? view.getId() : id;
            view2 = view;
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        return str.charAt(TOUCH_SLOP_DEFAULT) == '.' ? context.getPackageName() + str : !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private float getScrollFactor() {
        if (this.mScrollFactor == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.mScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.mScrollFactor;
    }

    private C0564y getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new C0564y(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, C0853v c0853v, C0853v c0853v2) {
        int b = this.mChildHelper.m4513b();
        int i = TOUCH_SLOP_DEFAULT;
        while (i < b) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4515b(i));
            if (childViewHolderInt == c0853v || getChangedHolderKey(childViewHolderInt) != j) {
                i += VERTICAL;
            } else if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + c0853v);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + c0853v);
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0853v2 + " cannot be found but it is necessary for " + c0853v);
    }

    private boolean hasUpdatedView() {
        int b = this.mChildHelper.m4513b();
        for (int i = TOUCH_SLOP_DEFAULT; i < b; i += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4515b(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ab(new C08265(this));
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2 = TOUCH_SLOP_DEFAULT;
        if (view2 == null || view2 == this) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        if (view == null) {
            return true;
        }
        if (i != SCROLL_STATE_SETTLING && i != VERTICAL) {
            return isPreferredNextFocusAbsolute(view, view2, i);
        }
        int i3 = this.mLayout.m3873s() == VERTICAL ? VERTICAL : TOUCH_SLOP_DEFAULT;
        if (i == SCROLL_STATE_SETTLING) {
            i2 = VERTICAL;
        }
        return isPreferredNextFocusAbsolute(view, view2, (i2 ^ i3) != 0 ? 66 : 17) ? true : i == SCROLL_STATE_SETTLING ? isPreferredNextFocusAbsolute(view, view2, 130) : isPreferredNextFocusAbsolute(view, view2, 33);
    }

    private boolean isPreferredNextFocusAbsolute(View view, View view2, int i) {
        this.mTempRect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, view.getWidth(), view.getHeight());
        this.mTempRect2.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        switch (i) {
            case C1373c.Toolbar_titleMarginTop /*17*/:
                return ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
            case C1373c.AppCompatTheme_actionModeCopyDrawable /*33*/:
                return ((this.mTempRect.bottom > this.mTempRect2.bottom || this.mTempRect.top >= this.mTempRect2.bottom) && this.mTempRect.top > this.mTempRect2.top) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
            case C1373c.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                return ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
            case 130:
                return ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
            default:
                throw new IllegalArgumentException("direction must be absolute. received:" + i);
        }
    }

    private void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            this.mLayout.m3843e(i);
            awakenScrollBars();
        }
    }

    private void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter += VERTICAL;
    }

    private void onExitLayoutOrScroll() {
        this.mLayoutOrScrollCounter += NO_POSITION;
        if (this.mLayoutOrScrollCounter < VERTICAL) {
            this.mLayoutOrScrollCounter = TOUCH_SLOP_DEFAULT;
            dispatchContentChangedIfNecessary();
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int b = C0560t.m2394b(motionEvent);
        if (C0560t.m2395b(motionEvent, b) == this.mScrollPointerId) {
            b = b == 0 ? VERTICAL : TOUCH_SLOP_DEFAULT;
            this.mScrollPointerId = C0560t.m2395b(motionEvent, b);
            int c = (int) (C0560t.m2396c(motionEvent, b) + 0.5f);
            this.mLastTouchX = c;
            this.mInitialTouchX = c;
            b = (int) (C0560t.m2398d(motionEvent, b) + 0.5f);
            this.mLastTouchY = b;
            this.mInitialTouchY = b;
        }
    }

    private void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ah.m1917a((View) this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return (this.mItemAnimator == null || !this.mLayout.m3833c()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z = true;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m4949a();
            markKnownViewsInvalid();
            this.mLayout.m3784a(this);
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m4957b();
        } else {
            this.mAdapterHelper.m4963e();
        }
        boolean z2 = (this.mItemsAddedOrRemoved || this.mItemsChanged) ? true : TOUCH_SLOP_DEFAULT;
        C0850s c0850s = this.mState;
        boolean z3 = (!this.mFirstLayoutComplete || this.mItemAnimator == null || (!(this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.f1825a) || (this.mDataSetHasChangedAfterLayout && !this.mAdapter.hasStableIds()))) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        c0850s.f1946l = z3;
        C0850s c0850s2 = this.mState;
        if (!(this.mState.f1946l && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled())) {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        c0850s2.f1947m = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.ensureLeftGlow();
        r2 = r7.mLeftGlow;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m2640a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.ensureTopGlow();
        r2 = r7.mTopGlow;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m2640a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.p016k.ah.m1931d(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.ensureRightGlow();
        r2 = r7.mRightGlow;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m2640a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.ensureBottomGlow();
        r2 = r7.mBottomGlow;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m2640a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recordAnimationInfoIfBouncedHiddenView(C0853v c0853v, C0835c c0835c) {
        c0853v.setFlags(TOUCH_SLOP_DEFAULT, 8192);
        if (this.mState.f1948n && c0853v.isUpdated() && !c0853v.isRemoved() && !c0853v.shouldIgnore()) {
            this.mViewInfoStore.m4851a(getChangedHolderKey(c0853v), c0853v);
        }
        this.mViewInfoStore.m4852a(c0853v, c0835c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void recoverFocusFromState() {
        /*
        r6 = this;
        r4 = -1;
        r0 = r6.mPreserveFocusAfterLayout;
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = r6.mAdapter;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = r6.hasFocus();
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r0 = r6.isFocused();
        if (r0 != 0) goto L_0x0025;
    L_0x0017:
        r0 = r6.getFocusedChild();
        if (r0 == 0) goto L_0x0010;
    L_0x001d:
        r1 = r6.mChildHelper;
        r0 = r1.m4518c(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x0025:
        r0 = 0;
        r1 = r6.mState;
        r1 = r1.f1936b;
        r2 = -1;
        if (r1 == r2) goto L_0x0035;
    L_0x002d:
        r0 = r6.mState;
        r0 = r0.f1936b;
        r0 = r6.findViewHolderForAdapterPosition(r0);
    L_0x0035:
        if (r0 != 0) goto L_0x004f;
    L_0x0037:
        r1 = r6.mState;
        r2 = r1.f1937c;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x004f;
    L_0x003f:
        r1 = r6.mAdapter;
        r1 = r1.hasStableIds();
        if (r1 == 0) goto L_0x004f;
    L_0x0047:
        r0 = r6.mState;
        r0 = r0.f1937c;
        r0 = r6.findViewHolderForItemId(r0);
    L_0x004f:
        if (r0 == 0) goto L_0x0010;
    L_0x0051:
        r1 = r0.itemView;
        r1 = r1.hasFocus();
        if (r1 != 0) goto L_0x0010;
    L_0x0059:
        r1 = r0.itemView;
        r1 = r1.hasFocusable();
        if (r1 == 0) goto L_0x0010;
    L_0x0061:
        r1 = r0.itemView;
        r2 = r6.mState;
        r2 = r2.f1938d;
        r2 = (long) r2;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0082;
    L_0x006c:
        r0 = r0.itemView;
        r2 = r6.mState;
        r2 = r2.f1938d;
        r0 = r0.findViewById(r2);
        if (r0 == 0) goto L_0x0082;
    L_0x0078:
        r2 = r0.isFocusable();
        if (r2 == 0) goto L_0x0082;
    L_0x007e:
        r0.requestFocus();
        goto L_0x0010;
    L_0x0082:
        r0 = r1;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.recoverFocusFromState():void");
    }

    private void releaseGlows() {
        int i = TOUCH_SLOP_DEFAULT;
        if (this.mLeftGlow != null) {
            i = this.mLeftGlow.m2644c();
        }
        if (this.mTopGlow != null) {
            i |= this.mTopGlow.m2644c();
        }
        if (this.mRightGlow != null) {
            i |= this.mRightGlow.m2644c();
        }
        if (this.mBottomGlow != null) {
            i |= this.mBottomGlow.m2644c();
        }
        if (i != 0) {
            ah.m1931d(this);
        }
    }

    private boolean removeAnimatingView(View view) {
        eatRequestLayout();
        boolean f = this.mChildHelper.m4522f(view);
        if (f) {
            C0853v childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m4171d(childViewHolderInt);
            this.mRecycler.m4162b(childViewHolderInt);
        }
        resumeRequestLayout(!f ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        return f;
    }

    private void repositionShadowingViews() {
        int b = this.mChildHelper.m4513b();
        for (int i = TOUCH_SLOP_DEFAULT; i < b; i += VERTICAL) {
            View b2 = this.mChildHelper.m4515b(i);
            C0853v childViewHolder = getChildViewHolder(b2);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void resetFocusInfo() {
        this.mState.f1937c = NO_ID;
        this.mState.f1936b = NO_POSITION;
        this.mState.f1938d = NO_POSITION;
    }

    private void resetTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll();
        releaseGlows();
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        C0853v findContainingViewHolder = focusedChild == null ? null : findContainingViewHolder(focusedChild);
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f1937c = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : NO_ID;
        this.mState.f1936b = this.mDataSetHasChangedAfterLayout ? NO_POSITION : findContainingViewHolder.getAdapterPosition();
        this.mState.f1938d = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void setAdapterInternal(C0829a c0829a, boolean z, boolean z2) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            if (this.mItemAnimator != null) {
                this.mItemAnimator.m4116c();
            }
            if (this.mLayout != null) {
                this.mLayout.m3826c(this.mRecycler);
                this.mLayout.m3815b(this.mRecycler);
            }
            this.mRecycler.m4150a();
        }
        this.mAdapterHelper.m4949a();
        C0829a c0829a2 = this.mAdapter;
        this.mAdapter = c0829a;
        if (c0829a != null) {
            c0829a.registerAdapterDataObserver(this.mObserver);
            c0829a.onAttachedToRecyclerView(this);
        }
        if (this.mLayout != null) {
            this.mLayout.m3776a(c0829a2, this.mAdapter);
        }
        this.mRecycler.m4153a(c0829a2, this.mAdapter, z);
        this.mState.f1944j = true;
        markKnownViewsInvalid();
    }

    private void setDataSetChangedAfterLayout() {
        if (!this.mDataSetHasChangedAfterLayout) {
            this.mDataSetHasChangedAfterLayout = true;
            int c = this.mChildHelper.m4516c();
            for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
                C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i));
                if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                    childViewHolderInt.addFlags(512);
                }
            }
            this.mRecycler.m4177g();
        }
    }

    private void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != SCROLL_STATE_SETTLING) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m4233b();
        if (this.mLayout != null) {
            this.mLayout.m3762G();
        }
    }

    void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.m2641a(-i);
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.m2641a(i);
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.m2641a(-i2);
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.m2641a(i2);
        }
        if (i != 0 || i2 != 0) {
            ah.m1931d(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.mLayout == null || !this.mLayout.m3808a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(C0838g c0838g) {
        addItemDecoration(c0838g, NO_POSITION);
    }

    public void addItemDecoration(C0838g c0838g, int i) {
        if (this.mLayout != null) {
            this.mLayout.m3800a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(FORCE_INVALIDATE_DISPLAY_LIST);
        }
        if (i < 0) {
            this.mItemDecorations.add(c0838g);
        } else {
            this.mItemDecorations.add(i, c0838g);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(C0840j c0840j) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(c0840j);
    }

    public void addOnItemTouchListener(C0841k c0841k) {
        this.mOnItemTouchListeners.add(c0841k);
    }

    public void addOnScrollListener(C0842l c0842l) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(c0842l);
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return ((layoutParams instanceof C0810i) && this.mLayout.m3802a((C0810i) layoutParams)) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    void clearOldPositions() {
        int c = this.mChildHelper.m4516c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.m4179i();
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.clear();
        }
    }

    public void clearOnScrollListeners() {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        return (this.mLayout != null && this.mLayout.m3845e()) ? this.mLayout.m3841e(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeHorizontalScrollOffset() {
        return (this.mLayout != null && this.mLayout.m3845e()) ? this.mLayout.m3823c(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeHorizontalScrollRange() {
        return (this.mLayout != null && this.mLayout.m3845e()) ? this.mLayout.m3851g(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeVerticalScrollExtent() {
        return (this.mLayout != null && this.mLayout.m3850f()) ? this.mLayout.m3847f(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeVerticalScrollOffset() {
        return (this.mLayout != null && this.mLayout.m3850f()) ? this.mLayout.m3835d(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    public int computeVerticalScrollRange() {
        return (this.mLayout != null && this.mLayout.m3850f()) ? this.mLayout.m3854h(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(C0812h.m3744a(i, getPaddingLeft() + getPaddingRight(), ah.m1949p(this)), C0812h.m3744a(i2, getPaddingTop() + getPaddingBottom(), ah.m1950q(this)));
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.f1949o = FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.mState.f1940f == VERTICAL) {
                dispatchLayoutStep1();
                this.mLayout.m3849f(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.m4964f() && this.mLayout.m3878x() == getWidth() && this.mLayout.m3879y() == getHeight()) {
                this.mLayout.m3849f(this);
            } else {
                this.mLayout.m3849f(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m2411a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m2410a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m2414a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m2413a(i, i2, i3, i4, iArr);
    }

    void dispatchOnScrollStateChanged(int i) {
        if (this.mLayout != null) {
            this.mLayout.m3864l(i);
        }
        onScrollStateChanged(i);
        if (this.mScrollListener != null) {
            this.mScrollListener.m4134a(this, i);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() + NO_POSITION; size >= 0; size += NO_POSITION) {
                ((C0842l) this.mScrollListeners.get(size)).m4134a(this, i);
            }
        }
    }

    void dispatchOnScrolled(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.mScrollListener != null) {
            this.mScrollListener.m4135a(this, i, i2);
        }
        if (this.mScrollListeners != null) {
            for (scrollY = this.mScrollListeners.size() + NO_POSITION; scrollY >= 0; scrollY += NO_POSITION) {
                ((C0842l) this.mScrollListeners.get(scrollY)).m4135a(this, i, i2);
            }
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = VERTICAL;
        int i4 = TOUCH_SLOP_DEFAULT;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        for (i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            ((C0838g) this.mItemDecorations.get(i)).onDrawOver(canvas, this, this.mState);
        }
        if (this.mLeftGlow == null || this.mLeftGlow.m2638a()) {
            i2 = TOUCH_SLOP_DEFAULT;
        } else {
            i = canvas.save();
            i2 = this.mClipToPadding ? getPaddingBottom() : TOUCH_SLOP_DEFAULT;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.mLeftGlow == null || !this.mLeftGlow.m2642a(canvas)) ? TOUCH_SLOP_DEFAULT : VERTICAL;
            canvas.restoreToCount(i);
        }
        if (!(this.mTopGlow == null || this.mTopGlow.m2638a())) {
            size = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.mTopGlow == null || !this.mTopGlow.m2642a(canvas)) ? TOUCH_SLOP_DEFAULT : VERTICAL;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.mRightGlow == null || this.mRightGlow.m2638a())) {
            size = canvas.save();
            int width = getWidth();
            i = this.mClipToPadding ? getPaddingTop() : TOUCH_SLOP_DEFAULT;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.mRightGlow == null || !this.mRightGlow.m2642a(canvas)) ? TOUCH_SLOP_DEFAULT : VERTICAL;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.m2638a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.mBottomGlow != null && this.mBottomGlow.m2642a(canvas)) {
                i4 = VERTICAL;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.m4114b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ah.m1931d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    void eatRequestLayout() {
        this.mEatRequestLayout += VERTICAL;
        if (this.mEatRequestLayout == VERTICAL && !this.mLayoutFrozen) {
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = new C0604i(getContext());
            if (this.mClipToPadding) {
                this.mBottomGlow.m2637a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.m2637a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = new C0604i(getContext());
            if (this.mClipToPadding) {
                this.mLeftGlow.m2637a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.m2637a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = new C0604i(getContext());
            if (this.mClipToPadding) {
                this.mRightGlow.m2637a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.m2637a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = new C0604i(getContext());
            if (this.mClipToPadding) {
                this.mTopGlow.m2637a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.m2637a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public View findChildViewUnder(float f, float f2) {
        for (int b = this.mChildHelper.m4513b() + NO_POSITION; b >= 0; b += NO_POSITION) {
            View b2 = this.mChildHelper.m4515b(b);
            float m = ah.m1946m(b2);
            float n = ah.m1947n(b2);
            if (f >= ((float) b2.getLeft()) + m && f <= m + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + n && f2 <= ((float) b2.getBottom()) + n) {
                return b2;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    public C0853v findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        return findContainingItemView == null ? null : getChildViewHolder(findContainingItemView);
    }

    public C0853v findViewHolderForAdapterPosition(int i) {
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int c = this.mChildHelper.m4516c();
        int i2 = TOUCH_SLOP_DEFAULT;
        C0853v c0853v = null;
        while (i2 < c) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i2));
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || getAdapterPositionFor(childViewHolderInt) != i) {
                childViewHolderInt = c0853v;
            } else if (!this.mChildHelper.m4518c(childViewHolderInt.itemView)) {
                return childViewHolderInt;
            }
            i2 += VERTICAL;
            c0853v = childViewHolderInt;
        }
        return c0853v;
    }

    public C0853v findViewHolderForItemId(long j) {
        if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
            return null;
        }
        int c = this.mChildHelper.m4516c();
        int i = TOUCH_SLOP_DEFAULT;
        C0853v c0853v = null;
        while (i < c) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i));
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || childViewHolderInt.getItemId() != j) {
                childViewHolderInt = c0853v;
            } else if (!this.mChildHelper.m4518c(childViewHolderInt.itemView)) {
                return childViewHolderInt;
            }
            i += VERTICAL;
            c0853v = childViewHolderInt;
        }
        return c0853v;
    }

    public C0853v findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, FORCE_INVALIDATE_DISPLAY_LIST);
    }

    @Deprecated
    public C0853v findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, FORCE_INVALIDATE_DISPLAY_LIST);
    }

    C0853v findViewHolderForPosition(int i, boolean z) {
        int c = this.mChildHelper.m4516c();
        C0853v c0853v = null;
        for (int i2 = TOUCH_SLOP_DEFAULT; i2 < c; i2 += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.isRemoved())) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.mChildHelper.m4518c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                c0853v = childViewHolderInt;
            }
        }
        return c0853v;
    }

    public boolean fling(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else if (this.mLayoutFrozen) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else {
            boolean e = this.mLayout.m3845e();
            boolean f = this.mLayout.m3850f();
            if (!e || Math.abs(i) < this.mMinFlingVelocity) {
                i = TOUCH_SLOP_DEFAULT;
            }
            if (!f || Math.abs(i2) < this.mMinFlingVelocity) {
                i2 = TOUCH_SLOP_DEFAULT;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return FORCE_INVALIDATE_DISPLAY_LIST;
            }
            e = (e || f) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
            dispatchNestedFling((float) i, (float) i2, e);
            if (!e) {
                return FORCE_INVALIDATE_DISPLAY_LIST;
            }
            this.mViewFlinger.m4229a(Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity)), Math.max(-this.mMaxFlingVelocity, Math.min(i2, this.mMaxFlingVelocity)));
            return true;
        }
    }

    public View focusSearch(View view, int i) {
        boolean z = true;
        View d = this.mLayout.m3838d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutFrozen) ? FORCE_INVALIDATE_DISPLAY_LIST : VERTICAL;
        FocusFinder instance = FocusFinder.getInstance();
        if (z2 && (i == SCROLL_STATE_SETTLING || i == VERTICAL)) {
            if (this.mLayout.m3850f()) {
                z2 = instance.findNextFocus(this, view, i == SCROLL_STATE_SETTLING ? 130 : 33) == null ? VERTICAL : FORCE_INVALIDATE_DISPLAY_LIST;
            } else {
                z2 = FORCE_INVALIDATE_DISPLAY_LIST;
            }
            if (z2 || !this.mLayout.m3845e()) {
                z = z2;
            } else {
                if (instance.findNextFocus(this, view, ((i == SCROLL_STATE_SETTLING ? VERTICAL : TOUCH_SLOP_DEFAULT) ^ (this.mLayout.m3873s() == VERTICAL ? VERTICAL : TOUCH_SLOP_DEFAULT)) != 0 ? 66 : 17) != null) {
                    z = FORCE_INVALIDATE_DISPLAY_LIST;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                eatRequestLayout();
                this.mLayout.m3770a(view, i, this.mRecycler, this.mState);
                resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            }
            d = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                eatRequestLayout();
                d = this.mLayout.m3770a(view, i, this.mRecycler, this.mState);
                resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            } else {
                d = findNextFocus;
            }
        }
        return !isPreferredNextFocus(view, d, i) ? super.focusSearch(view, i) : d;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout != null) {
            return this.mLayout.m3767a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mLayout != null) {
            return this.mLayout.m3768a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.mLayout != null) {
            return this.mLayout.m3769a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public C0829a getAdapter() {
        return this.mAdapter;
    }

    public int getBaseline() {
        return this.mLayout != null ? this.mLayout.m3874t() : super.getBaseline();
    }

    long getChangedHolderKey(C0853v c0853v) {
        return this.mAdapter.hasStableIds() ? c0853v.getItemId() : (long) c0853v.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        C0853v childViewHolderInt = getChildViewHolderInt(view);
        return childViewHolderInt != null ? childViewHolderInt.getAdapterPosition() : NO_POSITION;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.mChildDrawingOrderCallback == null ? super.getChildDrawingOrder(i, i2) : this.mChildDrawingOrderCallback.m4101a(i, i2);
    }

    public long getChildItemId(View view) {
        if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
            return NO_ID;
        }
        C0853v childViewHolderInt = getChildViewHolderInt(view);
        return childViewHolderInt != null ? childViewHolderInt.getItemId() : NO_ID;
    }

    public int getChildLayoutPosition(View view) {
        C0853v childViewHolderInt = getChildViewHolderInt(view);
        return childViewHolderInt != null ? childViewHolderInt.getLayoutPosition() : NO_POSITION;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public C0853v getChildViewHolder(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public at getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public C0836e getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        C0810i c0810i = (C0810i) view.getLayoutParams();
        if (!c0810i.f1821c) {
            return c0810i.f1820b;
        }
        Rect rect = c0810i.f1820b;
        rect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
        int size = this.mItemDecorations.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            this.mTempRect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
            ((C0838g) this.mItemDecorations.get(i)).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        c0810i.f1821c = FORCE_INVALIDATE_DISPLAY_LIST;
        return rect;
    }

    public C0812h getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public C0843m getRecycledViewPool() {
        return this.mRecycler.m4175f();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m2415b();
    }

    public boolean hasPendingAdapterUpdates() {
        return (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.m4962d()) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new C0940f(new C08286(this));
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.m3800a("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    boolean isAccessibilityEnabled() {
        return (this.mAccessibilityManager == null || !this.mAccessibilityManager.isEnabled()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    public boolean isAnimating() {
        return (this.mItemAnimator == null || !this.mItemAnimator.m4114b()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0 ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m2409a();
    }

    void markItemDecorInsetsDirty() {
        int c = this.mChildHelper.m4516c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            ((C0810i) this.mChildHelper.m4517c(i).getLayoutParams()).f1821c = true;
        }
        this.mRecycler.m4180j();
    }

    void markKnownViewsInvalid() {
        int c = this.mChildHelper.m4516c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.m4178h();
    }

    public void offsetChildrenHorizontal(int i) {
        int b = this.mChildHelper.m4513b();
        for (int i2 = TOUCH_SLOP_DEFAULT; i2 < b; i2 += VERTICAL) {
            this.mChildHelper.m4515b(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int b = this.mChildHelper.m4513b();
        for (int i2 = TOUCH_SLOP_DEFAULT; i2 < b; i2 += VERTICAL) {
            this.mChildHelper.m4515b(i2).offsetTopAndBottom(i);
        }
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int c = this.mChildHelper.m4516c();
        for (int i3 = TOUCH_SLOP_DEFAULT; i3 < c; i3 += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i3));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore() || childViewHolderInt.mPosition < i)) {
                childViewHolderInt.offsetPosition(i2, FORCE_INVALIDATE_DISPLAY_LIST);
                this.mState.f1944j = true;
            }
        }
        this.mRecycler.m4160b(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int c = this.mChildHelper.m4516c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = NO_POSITION;
            i4 = i2;
            i5 = i;
        } else {
            i3 = VERTICAL;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = TOUCH_SLOP_DEFAULT; i6 < c; i6 += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= r3 && childViewHolderInt.mPosition <= r2) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, FORCE_INVALIDATE_DISPLAY_LIST);
                } else {
                    childViewHolderInt.offsetPosition(i3, FORCE_INVALIDATE_DISPLAY_LIST);
                }
                this.mState.f1944j = true;
            }
        }
        this.mRecycler.m4152a(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.mChildHelper.m4516c();
        for (int i4 = TOUCH_SLOP_DEFAULT; i4 < c; i4 += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i4));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f1944j = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i + NO_POSITION, -i2, z);
                    this.mState.f1944j = true;
                }
            }
        }
        this.mRecycler.m4161b(i, i2, z);
        requestLayout();
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = TOUCH_SLOP_DEFAULT;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        this.mFirstLayoutComplete = z;
        if (this.mLayout != null) {
            this.mLayout.m3828c(this);
        }
        this.mPostedAnimatorRunner = FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m4116c();
        }
        stopScroll();
        this.mIsAttached = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayout != null) {
            this.mLayout.m3818b(this, this.mRecycler);
        }
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.m4856b();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            ((C0838g) this.mItemDecorations.get(i)).onDraw(canvas, this, this.mState);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.mLayout == null || this.mLayoutFrozen || (C0560t.m2399d(motionEvent) & SCROLL_STATE_SETTLING) == 0 || motionEvent.getAction() != 8)) {
            float f = this.mLayout.m3850f() ? -C0560t.m2400e(motionEvent, 9) : 0.0f;
            float e = this.mLayout.m3845e() ? C0560t.m2400e(motionEvent, 10) : 0.0f;
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                scrollByInternal((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = NO_POSITION;
        boolean z = true;
        if (this.mLayoutFrozen) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else {
            boolean e = this.mLayout.m3845e();
            boolean f = this.mLayout.m3850f();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int a = C0560t.m2392a(motionEvent);
            int b = C0560t.m2394b(motionEvent);
            int i2;
            switch (a) {
                case TOUCH_SLOP_DEFAULT /*0*/:
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = FORCE_INVALIDATE_DISPLAY_LIST;
                    }
                    this.mScrollPointerId = C0560t.m2395b(motionEvent, TOUCH_SLOP_DEFAULT);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = i;
                    this.mInitialTouchX = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = i;
                    this.mInitialTouchY = i;
                    if (this.mScrollState == SCROLL_STATE_SETTLING) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(VERTICAL);
                    }
                    int[] iArr = this.mNestedOffsets;
                    this.mNestedOffsets[VERTICAL] = TOUCH_SLOP_DEFAULT;
                    iArr[TOUCH_SLOP_DEFAULT] = TOUCH_SLOP_DEFAULT;
                    i2 = e ? VERTICAL : TOUCH_SLOP_DEFAULT;
                    if (f) {
                        i2 |= SCROLL_STATE_SETTLING;
                    }
                    startNestedScroll(i2);
                    break;
                case VERTICAL /*1*/:
                    this.mVelocityTracker.clear();
                    stopNestedScroll();
                    break;
                case SCROLL_STATE_SETTLING /*2*/:
                    a = C0560t.m2393a(motionEvent, this.mScrollPointerId);
                    if (a >= 0) {
                        b = (int) (C0560t.m2396c(motionEvent, a) + 0.5f);
                        a = (int) (C0560t.m2398d(motionEvent, a) + 0.5f);
                        if (this.mScrollState != VERTICAL) {
                            b -= this.mInitialTouchX;
                            a -= this.mInitialTouchY;
                            if (!e || Math.abs(b) <= this.mTouchSlop) {
                                e = FORCE_INVALIDATE_DISPLAY_LIST;
                            } else {
                                this.mLastTouchX = ((b < 0 ? NO_POSITION : VERTICAL) * this.mTouchSlop) + this.mInitialTouchX;
                                e = true;
                            }
                            if (f && Math.abs(a) > this.mTouchSlop) {
                                i2 = this.mInitialTouchY;
                                int i3 = this.mTouchSlop;
                                if (a >= 0) {
                                    i = VERTICAL;
                                }
                                this.mLastTouchY = i2 + (i * i3);
                                e = true;
                            }
                            if (e) {
                                setScrollState(VERTICAL);
                                break;
                            }
                        }
                    }
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return FORCE_INVALIDATE_DISPLAY_LIST;
                    break;
                case C1373c.View_paddingEnd /*3*/:
                    cancelTouch();
                    break;
                case C1373c.Toolbar_contentInsetStart /*5*/:
                    this.mScrollPointerId = C0560t.m2395b(motionEvent, b);
                    i2 = (int) (C0560t.m2396c(motionEvent, b) + 0.5f);
                    this.mLastTouchX = i2;
                    this.mInitialTouchX = i2;
                    i2 = (int) (C0560t.m2398d(motionEvent, b) + 0.5f);
                    this.mLastTouchY = i2;
                    this.mInitialTouchY = i2;
                    break;
                case C1373c.Toolbar_contentInsetEnd /*6*/:
                    onPointerUp(motionEvent);
                    break;
            }
            if (this.mScrollState != VERTICAL) {
                z = FORCE_INVALIDATE_DISPLAY_LIST;
            }
            return z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0359h.m1332a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        C0359h.m1331a();
        this.mFirstLayoutComplete = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayout == null) {
            defaultOnMeasure(i, i2);
        } else if (this.mLayout.f1826b) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLayout.m3778a(this.mRecycler, this.mState, i, i2);
            if (!z && this.mAdapter != null) {
                if (this.mState.f1940f == VERTICAL) {
                    dispatchLayoutStep1();
                }
                this.mLayout.m3771a(i, i2);
                this.mState.f1949o = true;
                dispatchLayoutStep2();
                this.mLayout.m3814b(i, i2);
                if (this.mLayout.m3865l()) {
                    this.mLayout.m3771a(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f1949o = true;
                    dispatchLayoutStep2();
                    this.mLayout.m3814b(i, i2);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.m3778a(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                eatRequestLayout();
                processAdapterUpdatesAndSetAnimationFlags();
                if (this.mState.f1947m) {
                    this.mState.f1945k = true;
                } else {
                    this.mAdapterHelper.m4963e();
                    this.mState.f1945k = FORCE_INVALIDATE_DISPLAY_LIST;
                }
                this.mAdapterUpdateDuringMeasure = FORCE_INVALIDATE_DISPLAY_LIST;
                resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            }
            if (this.mAdapter != null) {
                this.mState.f1935a = this.mAdapter.getItemCount();
            } else {
                this.mState.f1935a = TOUCH_SLOP_DEFAULT;
            }
            eatRequestLayout();
            this.mLayout.m3778a(this.mRecycler, this.mState, i, i2);
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            this.mState.f1945k = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        return isComputingLayout() ? FORCE_INVALIDATE_DISPLAY_LIST : super.onRequestFocusInDescendants(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0848q) {
            this.mPendingSavedState = (C0848q) parcelable;
            super.onRestoreInstanceState(this.mPendingSavedState.m249a());
            if (this.mLayout != null && this.mPendingSavedState.f1927a != null) {
                this.mLayout.m3774a(this.mPendingSavedState.f1927a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        C0848q c0848q = new C0848q(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            c0848q.m4192a(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            c0848q.f1927a = this.mLayout.m3837d();
        } else {
            c0848q.f1927a = null;
        }
        return c0848q;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayoutFrozen || this.mIgnoreMotionEventTillDown) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        if (dispatchOnItemTouch(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        } else {
            boolean e = this.mLayout.m3845e();
            boolean f = this.mLayout.m3850f();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = C0560t.m2392a(motionEvent);
            int b = C0560t.m2394b(motionEvent);
            if (a == 0) {
                int[] iArr = this.mNestedOffsets;
                this.mNestedOffsets[VERTICAL] = TOUCH_SLOP_DEFAULT;
                iArr[TOUCH_SLOP_DEFAULT] = TOUCH_SLOP_DEFAULT;
            }
            obtain.offsetLocation((float) this.mNestedOffsets[TOUCH_SLOP_DEFAULT], (float) this.mNestedOffsets[VERTICAL]);
            switch (a) {
                case TOUCH_SLOP_DEFAULT /*0*/:
                    this.mScrollPointerId = C0560t.m2395b(motionEvent, TOUCH_SLOP_DEFAULT);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = a;
                    this.mInitialTouchX = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = a;
                    this.mInitialTouchY = a;
                    a = e ? VERTICAL : TOUCH_SLOP_DEFAULT;
                    if (f) {
                        a |= SCROLL_STATE_SETTLING;
                    }
                    startNestedScroll(a);
                    break;
                case VERTICAL /*1*/:
                    this.mVelocityTracker.addMovement(obtain);
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
                    float f2 = e ? -af.m1694a(this.mVelocityTracker, this.mScrollPointerId) : 0.0f;
                    float f3 = f ? -af.m1695b(this.mVelocityTracker, this.mScrollPointerId) : 0.0f;
                    if ((f2 == 0.0f && f3 == 0.0f) || !fling((int) f2, (int) f3)) {
                        setScrollState(TOUCH_SLOP_DEFAULT);
                    }
                    resetTouch();
                    z = true;
                    break;
                case SCROLL_STATE_SETTLING /*2*/:
                    a = C0560t.m2393a(motionEvent, this.mScrollPointerId);
                    if (a >= 0) {
                        int c = (int) (C0560t.m2396c(motionEvent, a) + 0.5f);
                        int d = (int) (C0560t.m2398d(motionEvent, a) + 0.5f);
                        int i = this.mLastTouchX - c;
                        a = this.mLastTouchY - d;
                        if (dispatchNestedPreScroll(i, a, this.mScrollConsumed, this.mScrollOffset)) {
                            i -= this.mScrollConsumed[TOUCH_SLOP_DEFAULT];
                            a -= this.mScrollConsumed[VERTICAL];
                            obtain.offsetLocation((float) this.mScrollOffset[TOUCH_SLOP_DEFAULT], (float) this.mScrollOffset[VERTICAL]);
                            int[] iArr2 = this.mNestedOffsets;
                            iArr2[TOUCH_SLOP_DEFAULT] = iArr2[TOUCH_SLOP_DEFAULT] + this.mScrollOffset[TOUCH_SLOP_DEFAULT];
                            iArr2 = this.mNestedOffsets;
                            iArr2[VERTICAL] = iArr2[VERTICAL] + this.mScrollOffset[VERTICAL];
                        }
                        if (this.mScrollState != VERTICAL) {
                            boolean z2;
                            if (!e || Math.abs(i) <= this.mTouchSlop) {
                                z2 = FORCE_INVALIDATE_DISPLAY_LIST;
                            } else {
                                i = i > 0 ? i - this.mTouchSlop : i + this.mTouchSlop;
                                z2 = true;
                            }
                            if (f && Math.abs(a) > this.mTouchSlop) {
                                a = a > 0 ? a - this.mTouchSlop : a + this.mTouchSlop;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(VERTICAL);
                            }
                        }
                        if (this.mScrollState == VERTICAL) {
                            this.mLastTouchX = c - this.mScrollOffset[TOUCH_SLOP_DEFAULT];
                            this.mLastTouchY = d - this.mScrollOffset[VERTICAL];
                            if (!e) {
                                i = TOUCH_SLOP_DEFAULT;
                            }
                            if (!f) {
                                a = TOUCH_SLOP_DEFAULT;
                            }
                            if (scrollByInternal(i, a, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return FORCE_INVALIDATE_DISPLAY_LIST;
                    break;
                case C1373c.View_paddingEnd /*3*/:
                    cancelTouch();
                    break;
                case C1373c.Toolbar_contentInsetStart /*5*/:
                    this.mScrollPointerId = C0560t.m2395b(motionEvent, b);
                    a = (int) (C0560t.m2396c(motionEvent, b) + 0.5f);
                    this.mLastTouchX = a;
                    this.mInitialTouchX = a;
                    a = (int) (C0560t.m2398d(motionEvent, b) + 0.5f);
                    this.mLastTouchY = a;
                    this.mInitialTouchY = a;
                    break;
                case C1373c.Toolbar_contentInsetEnd /*6*/:
                    onPointerUp(motionEvent);
                    break;
            }
            if (!z) {
                this.mVelocityTracker.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        C0853v childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt);
            }
        }
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(C0838g c0838g) {
        if (this.mLayout != null) {
            this.mLayout.m3800a("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(c0838g);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(ah.m1907a(this) == SCROLL_STATE_SETTLING ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeOnChildAttachStateChangeListener(C0840j c0840j) {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.remove(c0840j);
        }
    }

    public void removeOnItemTouchListener(C0841k c0841k) {
        this.mOnItemTouchListeners.remove(c0841k);
        if (this.mActiveOnItemTouchListener == c0841k) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(C0842l c0842l) {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.remove(c0842l);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.mLayout.m3805a(this, this.mState, view, view2) || view2 == null)) {
            this.mTempRect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof C0810i) {
                C0810i c0810i = (C0810i) layoutParams;
                if (!c0810i.f1821c) {
                    Rect rect = c0810i.f1820b;
                    Rect rect2 = this.mTempRect;
                    rect2.left -= rect.left;
                    rect2 = this.mTempRect;
                    rect2.right += rect.right;
                    rect2 = this.mTempRect;
                    rect2.top -= rect.top;
                    rect2 = this.mTempRect;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
            requestChildRectangleOnScreen(view, this.mTempRect, !this.mFirstLayoutComplete ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.m3806a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < size; i += VERTICAL) {
            ((C0841k) this.mOnItemTouchListeners.get(i)).m4131a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.mEatRequestLayout != 0 || this.mLayoutFrozen) {
            this.mLayoutRequestEaten = true;
        } else {
            super.requestLayout();
        }
    }

    void resumeRequestLayout(boolean z) {
        if (this.mEatRequestLayout < VERTICAL) {
            this.mEatRequestLayout = VERTICAL;
        }
        if (!z) {
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        if (this.mEatRequestLayout == VERTICAL) {
            if (!(!z || !this.mLayoutRequestEaten || this.mLayoutFrozen || this.mLayout == null || this.mAdapter == null)) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }
        this.mEatRequestLayout += NO_POSITION;
    }

    void saveOldPositions() {
        int c = this.mChildHelper.m4516c();
        for (int i = TOUCH_SLOP_DEFAULT; i < c; i += VERTICAL) {
            C0853v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4517c(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            boolean e = this.mLayout.m3845e();
            boolean f = this.mLayout.m3850f();
            if (e || f) {
                if (!e) {
                    i = TOUCH_SLOP_DEFAULT;
                }
                if (!f) {
                    i2 = TOUCH_SLOP_DEFAULT;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int b;
            eatRequestLayout();
            onEnterLayoutOrScroll();
            C0359h.m1332a(TRACE_SCROLL_TAG);
            if (i != 0) {
                a = this.mLayout.m3765a(i, this.mRecycler, this.mState);
                i3 = i - a;
            } else {
                a = TOUCH_SLOP_DEFAULT;
                i3 = TOUCH_SLOP_DEFAULT;
            }
            if (i2 != 0) {
                b = this.mLayout.m3812b(i2, this.mRecycler, this.mState);
                i4 = i2 - b;
            } else {
                b = TOUCH_SLOP_DEFAULT;
                i4 = TOUCH_SLOP_DEFAULT;
            }
            C0359h.m1331a();
            repositionShadowingViews();
            onExitLayoutOrScroll();
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = TOUCH_SLOP_DEFAULT;
            i4 = TOUCH_SLOP_DEFAULT;
            i5 = TOUCH_SLOP_DEFAULT;
            i3 = TOUCH_SLOP_DEFAULT;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.mScrollOffset)) {
            this.mLastTouchX -= this.mScrollOffset[TOUCH_SLOP_DEFAULT];
            this.mLastTouchY -= this.mScrollOffset[VERTICAL];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.mScrollOffset[TOUCH_SLOP_DEFAULT], (float) this.mScrollOffset[VERTICAL]);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[TOUCH_SLOP_DEFAULT] = iArr[TOUCH_SLOP_DEFAULT] + this.mScrollOffset[TOUCH_SLOP_DEFAULT];
            iArr = this.mNestedOffsets;
            iArr[VERTICAL] = iArr[VERTICAL] + this.mScrollOffset[VERTICAL];
        } else if (ah.m1907a(this) != SCROLL_STATE_SETTLING) {
            if (motionEvent != null) {
                pullGlows(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            dispatchOnScrolled(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && a == 0) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            stopScroll();
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.mLayout.m3843e(i);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(at atVar) {
        this.mAccessibilityDelegate = atVar;
        ah.m1916a((View) this, this.mAccessibilityDelegate);
    }

    public void setAdapter(C0829a c0829a) {
        setLayoutFrozen(FORCE_INVALIDATE_DISPLAY_LIST);
        setAdapterInternal(c0829a, FORCE_INVALIDATE_DISPLAY_LIST, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C0832d c0832d) {
        if (c0832d != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = c0832d;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(C0836e c0836e) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m4116c();
            this.mItemAnimator.m4110a(null);
        }
        this.mItemAnimator = c0836e;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m4110a(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.m4151a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, TOUCH_SLOP_DEFAULT));
                this.mLayoutFrozen = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutFrozen = FORCE_INVALIDATE_DISPLAY_LIST;
            if (!(!this.mLayoutRequestEaten || this.mLayout == null || this.mAdapter == null)) {
                requestLayout();
            }
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    public void setLayoutManager(C0812h c0812h) {
        if (c0812h != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                if (this.mIsAttached) {
                    this.mLayout.m3818b(this, this.mRecycler);
                }
                this.mLayout.m3816b(null);
            }
            this.mRecycler.m4150a();
            this.mChildHelper.m4507a();
            this.mLayout = c0812h;
            if (c0812h != null) {
                if (c0812h.f1833q != null) {
                    throw new IllegalArgumentException("LayoutManager " + c0812h + " is already attached to a RecyclerView: " + c0812h.f1833q);
                }
                this.mLayout.m3816b(this);
                if (this.mIsAttached) {
                    this.mLayout.m3828c(this);
                }
            }
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m2408a(z);
    }

    @Deprecated
    public void setOnScrollListener(C0842l c0842l) {
        this.mScrollListener = c0842l;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(C0843m c0843m) {
        this.mRecycler.m4154a(c0843m);
    }

    public void setRecyclerListener(C0845o c0845o) {
        this.mRecyclerListener = c0845o;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case TOUCH_SLOP_DEFAULT /*0*/:
                break;
            case VERTICAL /*1*/:
                this.mTouchSlop = at.m2047a(viewConfiguration);
                return;
            default:
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(C0851t c0851t) {
        this.mRecycler.m4155a(c0851t);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i = TOUCH_SLOP_DEFAULT;
        if (!isComputingLayout()) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        int b = accessibilityEvent != null ? C0402a.m1484b(accessibilityEvent) : TOUCH_SLOP_DEFAULT;
        if (b != 0) {
            i = b;
        }
        this.mEatenAccessibilityChangeFlags = i | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void smoothScrollBy(int i, int i2) {
        int i3 = TOUCH_SLOP_DEFAULT;
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            if (!this.mLayout.m3845e()) {
                i = TOUCH_SLOP_DEFAULT;
            }
            if (this.mLayout.m3850f()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.mViewFlinger.m4234b(i, i3);
            }
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.mLayout.m3789a(this, this.mState, i);
            }
        }
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m2412a(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().m2416c();
    }

    public void stopScroll() {
        setScrollState(TOUCH_SLOP_DEFAULT);
        stopScrollersInternal();
    }

    public void swapAdapter(C0829a c0829a, boolean z) {
        setLayoutFrozen(FORCE_INVALIDATE_DISPLAY_LIST);
        setAdapterInternal(c0829a, true, z);
        setDataSetChangedAfterLayout();
        requestLayout();
    }

    void viewRangeUpdate(int i, int i2, Object obj) {
        int c = this.mChildHelper.m4516c();
        int i3 = i + i2;
        for (int i4 = TOUCH_SLOP_DEFAULT; i4 < c; i4 += VERTICAL) {
            View c2 = this.mChildHelper.m4517c(i4);
            C0853v childViewHolderInt = getChildViewHolderInt(c2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i3) {
                childViewHolderInt.addFlags(SCROLL_STATE_SETTLING);
                childViewHolderInt.addChangePayload(obj);
                ((C0810i) c2.getLayoutParams()).f1821c = true;
            }
        }
        this.mRecycler.m4166c(i, i2);
    }
}
