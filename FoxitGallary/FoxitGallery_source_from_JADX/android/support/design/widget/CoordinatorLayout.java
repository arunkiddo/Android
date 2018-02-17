package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.C0110a.C0108f;
import android.support.design.C0110a.C0109g;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p016k.C0120a;
import android.support.v4.p016k.C0143z;
import android.support.v4.p016k.C0522f;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.aa;
import android.support.v4.p016k.ab;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.bg;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;
import android.support.v4.p022c.C0225a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C0143z {
    static final String f257a;
    static final Class<?>[] f258b;
    static final ThreadLocal<Map<String, Constructor<C0122b>>> f259c;
    static final Comparator<View> f260e;
    static final C0172c f261f;
    private final aa f262A;
    final Comparator<View> f263d;
    private final List<View> f264g;
    private final List<View> f265h;
    private final List<View> f266i;
    private final Rect f267j;
    private final Rect f268k;
    private final Rect f269l;
    private final int[] f270m;
    private Paint f271n;
    private boolean f272o;
    private boolean f273p;
    private int[] f274q;
    private View f275r;
    private View f276s;
    private View f277t;
    private C0139f f278u;
    private boolean f279v;
    private bg f280w;
    private boolean f281x;
    private Drawable f282y;
    private OnHierarchyChangeListener f283z;

    /* renamed from: android.support.design.widget.CoordinatorLayout.b */
    public static abstract class C0122b<V extends View> {
        public C0122b(Context context, AttributeSet attributeSet) {
        }

        public bg m250a(CoordinatorLayout coordinatorLayout, V v, bg bgVar) {
            return bgVar;
        }

        public void m251a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void m252a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void m253a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void m254a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean m255a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean m256a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean m257a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean m258a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean m259a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean m260a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public Parcelable m261b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        public void m262b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean m263b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean m264b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public int m265c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean m266c(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public float m267d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void m268d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean m269e(CoordinatorLayout coordinatorLayout, V v) {
            return m267d(coordinatorLayout, v) > 0.0f;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.1 */
    class C01341 implements Comparator<View> {
        final /* synthetic */ CoordinatorLayout f239a;

        C01341(CoordinatorLayout coordinatorLayout) {
            this.f239a = coordinatorLayout;
        }

        public int m427a(View view, View view2) {
            return view == view2 ? 0 : ((C0138e) view.getLayoutParams()).m438a(this.f239a, view, view2) ? 1 : ((C0138e) view2.getLayoutParams()).m438a(this.f239a, view2, view) ? -1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m427a((View) obj, (View) obj2);
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.a */
    private class C0135a implements ab {
        final /* synthetic */ CoordinatorLayout f240a;

        private C0135a(CoordinatorLayout coordinatorLayout) {
            this.f240a = coordinatorLayout;
        }

        public bg m429a(View view, bg bgVar) {
            return this.f240a.m458a(bgVar);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.design.widget.CoordinatorLayout.c */
    public @interface C0136c {
        Class<? extends C0122b> m430a();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.d */
    private class C0137d implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout f241a;

        private C0137d(CoordinatorLayout coordinatorLayout) {
            this.f241a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.f241a.f283z != null) {
                this.f241a.f283z.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f241a.m485b(view2);
            if (this.f241a.f283z != null) {
                this.f241a.f283z.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.e */
    public static class C0138e extends MarginLayoutParams {
        C0122b f242a;
        boolean f243b;
        public int f244c;
        public int f245d;
        public int f246e;
        int f247f;
        View f248g;
        View f249h;
        final Rect f250i;
        Object f251j;
        private boolean f252k;
        private boolean f253l;
        private boolean f254m;

        public C0138e(int i, int i2) {
            super(i, i2);
            this.f243b = false;
            this.f244c = 0;
            this.f245d = 0;
            this.f246e = -1;
            this.f247f = -1;
            this.f250i = new Rect();
        }

        C0138e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f243b = false;
            this.f244c = 0;
            this.f245d = 0;
            this.f246e = -1;
            this.f247f = -1;
            this.f250i = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0109g.CoordinatorLayout_Layout);
            this.f244c = obtainStyledAttributes.getInteger(C0109g.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f247f = obtainStyledAttributes.getResourceId(C0109g.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f245d = obtainStyledAttributes.getInteger(C0109g.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f246e = obtainStyledAttributes.getInteger(C0109g.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f243b = obtainStyledAttributes.hasValue(C0109g.CoordinatorLayout_Layout_layout_behavior);
            if (this.f243b) {
                this.f242a = CoordinatorLayout.m456a(context, attributeSet, obtainStyledAttributes.getString(C0109g.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
        }

        public C0138e(C0138e c0138e) {
            super(c0138e);
            this.f243b = false;
            this.f244c = 0;
            this.f245d = 0;
            this.f246e = -1;
            this.f247f = -1;
            this.f250i = new Rect();
        }

        public C0138e(LayoutParams layoutParams) {
            super(layoutParams);
            this.f243b = false;
            this.f244c = 0;
            this.f245d = 0;
            this.f246e = -1;
            this.f247f = -1;
            this.f250i = new Rect();
        }

        public C0138e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f243b = false;
            this.f244c = 0;
            this.f245d = 0;
            this.f246e = -1;
            this.f247f = -1;
            this.f250i = new Rect();
        }

        private void m431a(View view, CoordinatorLayout coordinatorLayout) {
            this.f248g = coordinatorLayout.findViewById(this.f247f);
            if (this.f248g != null) {
                if (this.f248g != coordinatorLayout) {
                    View view2 = this.f248g;
                    View parent = this.f248g.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f249h = null;
                            this.f248g = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f249h = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f249h = null;
                    this.f248g = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f249h = null;
                this.f248g = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f247f) + " to anchor view " + view);
            }
        }

        private boolean m432b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f248g.getId() != this.f247f) {
                return false;
            }
            View view2 = this.f248g;
            View parent = this.f248g.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.f249h = null;
                    this.f248g = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.f249h = view2;
            return true;
        }

        public int m433a() {
            return this.f247f;
        }

        void m434a(Rect rect) {
            this.f250i.set(rect);
        }

        public void m435a(C0122b c0122b) {
            if (this.f242a != c0122b) {
                this.f242a = c0122b;
                this.f251j = null;
                this.f243b = true;
            }
        }

        void m436a(boolean z) {
            this.f253l = z;
        }

        boolean m437a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f252k) {
                return true;
            }
            boolean e = (this.f242a != null ? this.f242a.m269e(coordinatorLayout, view) : 0) | this.f252k;
            this.f252k = e;
            return e;
        }

        boolean m438a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f249h || (this.f242a != null && this.f242a.m264b(coordinatorLayout, view, view2));
        }

        public C0122b m439b() {
            return this.f242a;
        }

        View m440b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f247f == -1) {
                this.f249h = null;
                this.f248g = null;
                return null;
            }
            if (this.f248g == null || !m432b(view, coordinatorLayout)) {
                m431a(view, coordinatorLayout);
            }
            return this.f248g;
        }

        void m441b(boolean z) {
            this.f254m = z;
        }

        Rect m442c() {
            return this.f250i;
        }

        boolean m443d() {
            return this.f248g == null && this.f247f != -1;
        }

        boolean m444e() {
            if (this.f242a == null) {
                this.f252k = false;
            }
            return this.f252k;
        }

        void m445f() {
            this.f252k = false;
        }

        void m446g() {
            this.f253l = false;
        }

        boolean m447h() {
            return this.f253l;
        }

        boolean m448i() {
            return this.f254m;
        }

        void m449j() {
            this.f254m = false;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.f */
    class C0139f implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout f255a;

        C0139f(CoordinatorLayout coordinatorLayout) {
            this.f255a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f255a.m481a(false);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.g */
    protected static class C0141g extends C0120a {
        public static final Creator<C0141g> CREATOR;
        SparseArray<Parcelable> f256a;

        /* renamed from: android.support.design.widget.CoordinatorLayout.g.1 */
        static class C01401 implements C0118e<C0141g> {
            C01401() {
            }

            public C0141g m450a(Parcel parcel, ClassLoader classLoader) {
                return new C0141g(parcel, classLoader);
            }

            public C0141g[] m451a(int i) {
                return new C0141g[i];
            }

            public /* synthetic */ Object m452b(Parcel parcel, ClassLoader classLoader) {
                return m450a(parcel, classLoader);
            }

            public /* synthetic */ Object[] m453b(int i) {
                return m451a(i);
            }
        }

        static {
            CREATOR = C0356d.m1329a(new C01401());
        }

        public C0141g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f256a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f256a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public C0141g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f256a != null ? this.f256a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f256a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f256a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.h */
    static class C0142h implements Comparator<View> {
        C0142h() {
        }

        public int m454a(View view, View view2) {
            float E = ah.m1902E(view);
            float E2 = ah.m1902E(view2);
            return E > E2 ? -1 : E < E2 ? 1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m454a((View) obj, (View) obj2);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f257a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f260e = new C0142h();
            f261f = new C0173d();
        } else {
            f260e = null;
            f261f = null;
        }
        f258b = new Class[]{Context.class, AttributeSet.class};
        f259c = new ThreadLocal();
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f263d = new C01341(this);
        this.f264g = new ArrayList();
        this.f265h = new ArrayList();
        this.f266i = new ArrayList();
        this.f267j = new Rect();
        this.f268k = new Rect();
        this.f269l = new Rect();
        this.f270m = new int[2];
        this.f262A = new aa(this);
        C0196p.m726a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0109g.CoordinatorLayout, i, C0108f.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0109g.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f274q = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f274q.length;
            while (i2 < length) {
                int[] iArr = this.f274q;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f282y = obtainStyledAttributes.getDrawable(C0109g.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (f261f != null) {
            f261f.m628a(this, new C0135a());
        }
        super.setOnHierarchyChangeListener(new C0137d());
    }

    private int m455a(int i) {
        if (this.f274q == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f274q.length) {
            return this.f274q[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static C0122b m456a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f257a)) {
            str = f257a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f259c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f259c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f258b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0122b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private bg m458a(bg bgVar) {
        boolean z = true;
        if (this.f280w == bgVar) {
            return bgVar;
        }
        this.f280w = bgVar;
        boolean z2 = bgVar != null && bgVar.m2248b() > 0;
        this.f281x = z2;
        if (this.f281x || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        bgVar = m465b(bgVar);
        requestLayout();
        return bgVar;
    }

    private void m460a(View view, View view2, int i) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        Rect rect = this.f267j;
        Rect rect2 = this.f268k;
        m479a(view2, rect);
        m478a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void m461a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f260e != null) {
            Collections.sort(list, f260e);
        }
    }

    private static void m462a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }

    private boolean m463a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = C0560t.m2392a(motionEvent);
        List list = this.f265h;
        m461a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            C0138e c0138e = (C0138e) view.getLayoutParams();
            C0122b b = c0138e.m439b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case C1373c.View_android_theme /*0*/:
                            z2 = b.m257a(this, view, motionEvent);
                            break;
                        case C1373c.View_android_focusable /*1*/:
                            z2 = b.m263b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f275r = view;
                    }
                }
                z = z2;
                boolean e = c0138e.m444e();
                boolean a2 = c0138e.m437a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case C1373c.View_android_theme /*0*/:
                        b.m257a(this, view, motionEvent3);
                        break;
                    case C1373c.View_android_focusable /*1*/:
                        b.m263b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private static int m464b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private bg m465b(bg bgVar) {
        if (bgVar.m2251e()) {
            return bgVar;
        }
        bg a;
        int childCount = getChildCount();
        int i = 0;
        bg bgVar2 = bgVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (ah.m1955v(childAt)) {
                C0122b b = ((C0138e) childAt.getLayoutParams()).m439b();
                if (b != null) {
                    a = b.m250a(this, childAt, bgVar2);
                    if (a.m2251e()) {
                        break;
                    }
                    i++;
                    bgVar2 = a;
                }
            }
            a = bgVar2;
            i++;
            bgVar2 = a;
        }
        a = bgVar2;
        return a;
    }

    private void m466b(View view, int i, int i2) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        int a = C0522f.m2290a(m467c(c0138e.f244c), i2);
        int i3 = a & 7;
        int i4 = a & C1373c.AppCompatTheme_spinnerStyle;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a2 = m455a(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case C1373c.View_android_focusable /*1*/:
                a2 += measuredWidth / 2;
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                a2 += measuredWidth;
                break;
        }
        switch (i4) {
            case C1373c.Toolbar_titleMarginEnd /*16*/:
                a = 0 + (measuredHeight / 2);
                break;
            case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                a = 0 + measuredHeight;
                break;
        }
        a2 = Math.max(getPaddingLeft() + c0138e.leftMargin, Math.min(a2, ((width - getPaddingRight()) - measuredWidth) - c0138e.rightMargin));
        int max = Math.max(getPaddingTop() + c0138e.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - c0138e.bottomMargin));
        view.layout(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private static int m467c(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void m468c(View view, int i) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        Rect rect = this.f267j;
        rect.set(getPaddingLeft() + c0138e.leftMargin, getPaddingTop() + c0138e.topMargin, (getWidth() - getPaddingRight()) - c0138e.rightMargin, (getHeight() - getPaddingBottom()) - c0138e.bottomMargin);
        if (!(this.f280w == null || !ah.m1955v(this) || ah.m1955v(view))) {
            rect.left += this.f280w.m2246a();
            rect.top += this.f280w.m2248b();
            rect.right -= this.f280w.m2249c();
            rect.bottom -= this.f280w.m2250d();
        }
        Rect rect2 = this.f268k;
        C0522f.m2291a(m464b(c0138e.f244c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int m469d(int i) {
        return i == 0 ? 17 : i;
    }

    private void m470e() {
        if (this.f275r != null) {
            C0122b b = ((C0138e) this.f275r.getLayoutParams()).m439b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.m263b(this, this.f275r, obtain);
                obtain.recycle();
            }
            this.f275r = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((C0138e) getChildAt(i).getLayoutParams()).m445f();
        }
        this.f272o = false;
    }

    private void m471f() {
        this.f264g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            m473a(childAt).m440b(this, childAt);
            this.f264g.add(childAt);
        }
        m462a(this.f264g, this.f263d);
    }

    public C0138e m472a(AttributeSet attributeSet) {
        return new C0138e(getContext(), attributeSet);
    }

    C0138e m473a(View view) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        if (!c0138e.f243b) {
            C0136c c0136c = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c0136c = (C0136c) cls.getAnnotation(C0136c.class);
                if (c0136c != null) {
                    break;
                }
            }
            C0136c c0136c2 = c0136c;
            if (c0136c2 != null) {
                try {
                    c0138e.m435a((C0122b) c0136c2.m430a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c0136c2.m430a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0138e.f243b = true;
        }
        return c0138e;
    }

    protected C0138e m474a(LayoutParams layoutParams) {
        return layoutParams instanceof C0138e ? new C0138e((C0138e) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0138e((MarginLayoutParams) layoutParams) : new C0138e(layoutParams);
    }

    void m475a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m493e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f279v) {
            return;
        }
        if (z) {
            m484b();
        } else {
            m488c();
        }
    }

    public void m476a(View view, int i) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        if (c0138e.m443d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0138e.f248g != null) {
            m460a(view, c0138e.f248g, i);
        } else if (c0138e.f246e >= 0) {
            m466b(view, c0138e.f246e, i);
        } else {
            m468c(view, i);
        }
    }

    public void m477a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m478a(View view, int i, Rect rect, Rect rect2) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        int a = C0522f.m2290a(m469d(c0138e.f244c), i);
        int a2 = C0522f.m2290a(m464b(c0138e.f245d), i);
        int i2 = a & 7;
        int i3 = a & C1373c.AppCompatTheme_spinnerStyle;
        a = a2 & 7;
        int i4 = a2 & C1373c.AppCompatTheme_spinnerStyle;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (a) {
            case C1373c.View_android_focusable /*1*/:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i4) {
            case C1373c.Toolbar_titleMarginEnd /*16*/:
                a = rect.top + (rect.height() / 2);
                break;
            case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i2) {
            case C1373c.View_android_focusable /*1*/:
                a2 -= measuredWidth / 2;
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                break;
            default:
                a2 -= measuredWidth;
                break;
        }
        switch (i3) {
            case C1373c.Toolbar_titleMarginEnd /*16*/:
                a -= measuredHeight / 2;
                break;
            case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                break;
            default:
                a -= measuredHeight;
                break;
        }
        i2 = getWidth();
        i3 = getHeight();
        a2 = Math.max(getPaddingLeft() + c0138e.leftMargin, Math.min(a2, ((i2 - getPaddingRight()) - measuredWidth) - c0138e.rightMargin));
        int max = Math.max(getPaddingTop() + c0138e.topMargin, Math.min(a, ((i3 - getPaddingBottom()) - measuredHeight) - c0138e.bottomMargin));
        rect2.set(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    void m479a(View view, Rect rect) {
        C0211t.m780b(this, view, rect);
    }

    void m480a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            m479a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    void m481a(boolean z) {
        int h = ah.m1941h(this);
        int size = this.f264g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            View view = (View) this.f264g.get(i);
            C0138e c0138e = (C0138e) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (c0138e.f249h == ((View) this.f264g.get(i2))) {
                    m486b(view, h);
                }
            }
            Rect rect = this.f267j;
            Rect rect2 = this.f268k;
            m490c(view, rect);
            m480a(view, true, rect2);
            if (!rect.equals(rect2)) {
                m487b(view, rect2);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.f264g.get(i2);
                    C0138e c0138e2 = (C0138e) view2.getLayoutParams();
                    C0122b b = c0138e2.m439b();
                    if (b != null && b.m264b(this, view2, view)) {
                        if (z || !c0138e2.m448i()) {
                            boolean c = b.m266c(this, view2, view);
                            if (z) {
                                c0138e2.m441b(c);
                            }
                        } else {
                            c0138e2.m449j();
                        }
                    }
                }
            }
        }
    }

    public boolean m482a(View view, int i, int i2) {
        Rect rect = this.f267j;
        m479a(view, rect);
        return rect.contains(i, i2);
    }

    public boolean m483a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rect = this.f267j;
        m480a(view, view.getParent() != this, rect);
        Rect rect2 = this.f268k;
        m480a(view2, view2.getParent() != this, rect2);
        return rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
    }

    void m484b() {
        if (this.f273p) {
            if (this.f278u == null) {
                this.f278u = new C0139f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f278u);
        }
        this.f279v = true;
    }

    void m485b(View view) {
        int size = this.f264g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f264g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0138e c0138e = (C0138e) view2.getLayoutParams();
                    C0122b b = c0138e.m439b();
                    if (b != null && c0138e.m438a(this, view2, view)) {
                        b.m268d(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m486b(View view, int i) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        if (c0138e.f248g != null) {
            Rect rect = this.f267j;
            Rect rect2 = this.f268k;
            Rect rect3 = this.f269l;
            m479a(c0138e.f248g, rect);
            m480a(view, false, rect2);
            m478a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if (i2 != 0 || i3 != 0) {
                C0122b b = c0138e.m439b();
                if (b != null) {
                    b.m266c(this, view, c0138e.f248g);
                }
            }
        }
    }

    void m487b(View view, Rect rect) {
        ((C0138e) view.getLayoutParams()).m434a(rect);
    }

    void m488c() {
        if (this.f273p && this.f278u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f278u);
        }
        this.f279v = false;
    }

    public void m489c(View view) {
        int size = this.f264g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f264g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0138e c0138e = (C0138e) view2.getLayoutParams();
                    C0122b b = c0138e.m439b();
                    if (b != null && c0138e.m438a(this, view2, view)) {
                        b.m266c(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m490c(View view, Rect rect) {
        rect.set(((C0138e) view.getLayoutParams()).m442c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0138e) && super.checkLayoutParams(layoutParams);
    }

    protected C0138e m491d() {
        return new C0138e(-2, -2);
    }

    public List<View> m492d(View view) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        List<View> list = this.f266i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0138e.m438a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        if (c0138e.f242a != null && c0138e.f242a.m267d(this, view) > 0.0f) {
            if (this.f271n == null) {
                this.f271n = new Paint();
            }
            this.f271n.setColor(c0138e.f242a.m265c(this, view));
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f271n);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f282y;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    boolean m493e(View view) {
        C0138e c0138e = (C0138e) view.getLayoutParams();
        if (c0138e.f248g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0138e.m438a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m491d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m472a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m474a(layoutParams);
    }

    public int getNestedScrollAxes() {
        return this.f262A.m1685a();
    }

    public Drawable getStatusBarBackground() {
        return this.f282y;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m470e();
        if (this.f279v) {
            if (this.f278u == null) {
                this.f278u = new C0139f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f278u);
        }
        if (this.f280w == null && ah.m1955v(this)) {
            ah.m1954u(this);
        }
        this.f273p = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m470e();
        if (this.f279v && this.f278u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f278u);
        }
        if (this.f277t != null) {
            onStopNestedScroll(this.f277t);
        }
        this.f273p = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f281x && this.f282y != null) {
            int b = this.f280w != null ? this.f280w.m2248b() : 0;
            if (b > 0) {
                this.f282y.setBounds(0, 0, getWidth(), b);
                this.f282y.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = C0560t.m2392a(motionEvent);
        if (a == 0) {
            m470e();
        }
        boolean a2 = m463a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            m470e();
        }
        return a2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int h = ah.m1941h(this);
        int size = this.f264g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f264g.get(i5);
            C0122b b = ((C0138e) view.getLayoutParams()).m439b();
            if (b == null || !b.m255a(this, view, h)) {
                m476a(view, h);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m471f();
        m475a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int h = ah.m1941h(this);
        Object obj = h == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        Object obj2 = (this.f280w == null || !ah.m1955v(this)) ? null : 1;
        int size3 = this.f264g.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = paddingBottom;
        int i8 = suggestedMinimumWidth;
        while (i5 < size3) {
            int i9;
            View view = (View) this.f264g.get(i5);
            C0138e c0138e = (C0138e) view.getLayoutParams();
            int i10 = 0;
            if (c0138e.f246e >= 0 && mode != 0) {
                int a = m455a(c0138e.f246e);
                paddingTop = C0522f.m2290a(m467c(c0138e.f244c), h) & 7;
                if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                    i10 = Math.max(0, (size - paddingRight) - a);
                } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                    i10 = Math.max(0, a - paddingLeft);
                }
            }
            if (obj2 == null || ah.m1955v(view)) {
                i9 = i2;
                suggestedMinimumWidth = i;
            } else {
                paddingTop = this.f280w.m2248b() + this.f280w.m2250d();
                suggestedMinimumWidth = MeasureSpec.makeMeasureSpec(size - (this.f280w.m2246a() + this.f280w.m2249c()), mode);
                i9 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            C0122b b = c0138e.m439b();
            if (b == null || !b.m256a(this, view, suggestedMinimumWidth, i10, i9, 0)) {
                m477a(view, suggestedMinimumWidth, i10, i9, 0);
            }
            i10 = Math.max(i8, ((view.getMeasuredWidth() + i3) + c0138e.leftMargin) + c0138e.rightMargin);
            suggestedMinimumWidth = Math.max(i7, ((view.getMeasuredHeight() + i4) + c0138e.topMargin) + c0138e.bottomMargin);
            i5++;
            i6 = ah.m1905a(i6, ah.m1943j(view));
            i7 = suggestedMinimumWidth;
            i8 = i10;
        }
        setMeasuredDimension(ah.m1906a(i8, i, -16777216 & i6), ah.m1906a(i7, i2, i6 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0138e c0138e = (C0138e) childAt.getLayoutParams();
            if (c0138e.m447h()) {
                C0122b b = c0138e.m439b();
                a = b != null ? b.m259a(this, childAt, view, f, f2, z) | z2 : z2;
            } else {
                a = z2;
            }
            i++;
            z2 = a;
        }
        if (z2) {
            m481a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0138e c0138e = (C0138e) childAt.getLayoutParams();
            if (c0138e.m447h()) {
                C0122b b = c0138e.m439b();
                a = b != null ? b.m258a(this, childAt, view, f, f2) | z : z;
            } else {
                a = z;
            }
            i++;
            z = a;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            C0138e c0138e = (C0138e) childAt.getLayoutParams();
            if (c0138e.m447h()) {
                C0122b b = c0138e.m439b();
                if (b != null) {
                    int[] iArr2 = this.f270m;
                    this.f270m[1] = 0;
                    iArr2[0] = 0;
                    b.m254a(this, childAt, view, i, i2, this.f270m);
                    max = i > 0 ? Math.max(i3, this.f270m[0]) : Math.min(i3, this.f270m[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.f270m[1]) : Math.min(i4, this.f270m[1]);
                    int i6 = 1;
                } else {
                    obj2 = obj;
                    max = i3;
                    max2 = i4;
                }
            } else {
                obj2 = obj;
                max = i3;
                max2 = i4;
            }
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m481a(true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            C0138e c0138e = (C0138e) childAt.getLayoutParams();
            if (c0138e.m447h()) {
                C0122b b = c0138e.m439b();
                if (b != null) {
                    b.m253a(this, childAt, view, i, i2, i3, i4);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m481a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f262A.m1687a(view, view2, i);
        this.f276s = view;
        this.f277t = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0138e c0138e = (C0138e) childAt.getLayoutParams();
            if (c0138e.m447h()) {
                C0122b b = c0138e.m439b();
                if (b != null) {
                    b.m262b(this, childAt, view, view2, i);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0141g) {
            C0141g c0141g = (C0141g) parcelable;
            super.onRestoreInstanceState(c0141g.m249a());
            SparseArray sparseArray = c0141g.f256a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                C0122b b = m473a(childAt).m439b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.m251a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0141g = new C0141g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0122b b = ((C0138e) childAt.getLayoutParams()).m439b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.m261b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        c0141g.f256a = sparseArray;
        return c0141g;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            C0138e c0138e = (C0138e) childAt.getLayoutParams();
            C0122b b = c0138e.m439b();
            if (b != null) {
                boolean a = b.m260a(this, childAt, view, view2, i);
                z2 = z | a;
                c0138e.m436a(a);
            } else {
                c0138e.m436a(false);
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f262A.m1686a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0138e c0138e = (C0138e) childAt.getLayoutParams();
            if (c0138e.m447h()) {
                C0122b b = c0138e.m439b();
                if (b != null) {
                    b.m252a(this, childAt, view);
                }
                c0138e.m446g();
                c0138e.m449j();
            }
        }
        this.f276s = null;
        this.f277t = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2 = null;
        int a = C0560t.m2392a(motionEvent);
        MotionEvent obtain;
        if (this.f275r == null) {
            boolean a2 = m463a(motionEvent, 1);
            if (a2) {
                z = a2;
            } else {
                z = a2;
                z2 = false;
                if (this.f275r == null) {
                    z2 |= super.onTouchEvent(motionEvent);
                } else if (z) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z2 || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        m470e();
                    }
                    return z2;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m470e();
                return z2;
            }
        }
        z = false;
        C0122b b = ((C0138e) this.f275r.getLayoutParams()).m439b();
        z2 = b != null ? b.m263b(this, this.f275r, motionEvent) : false;
        if (this.f275r == null) {
            z2 |= super.onTouchEvent(motionEvent);
        } else if (z) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z2) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m470e();
        return z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f272o) {
            m470e();
            this.f272o = true;
        }
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f283z = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f282y != drawable) {
            if (this.f282y != null) {
                this.f282y.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f282y = drawable2;
            if (this.f282y != null) {
                if (this.f282y.isStateful()) {
                    this.f282y.setState(getDrawableState());
                }
                C0326a.m1268b(this.f282y, ah.m1941h(this));
                this.f282y.setVisible(getVisibility() == 0, false);
                this.f282y.setCallback(this);
            }
            ah.m1931d(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0225a.m808a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f282y != null && this.f282y.isVisible() != z) {
            this.f282y.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f282y;
    }
}
