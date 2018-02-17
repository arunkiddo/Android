package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.p016k.ac;
import android.support.v4.p016k.ah;
import android.support.v4.widget.C0622q;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.menu.C0763s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.reflect.Method;

public class am implements C0763s {
    private static Method f1763a;
    private static Method f1764d;
    private static Method f1765e;
    private final C0904d f1766A;
    private final C0903c f1767B;
    private final C0901a f1768C;
    private Runnable f1769D;
    private final Handler f1770E;
    private final Rect f1771F;
    private Rect f1772G;
    private boolean f1773H;
    int f1774b;
    PopupWindow f1775c;
    private Context f1776f;
    private ListAdapter f1777g;
    private ag f1778h;
    private int f1779i;
    private int f1780j;
    private int f1781k;
    private int f1782l;
    private int f1783m;
    private boolean f1784n;
    private boolean f1785o;
    private int f1786p;
    private boolean f1787q;
    private boolean f1788r;
    private View f1789s;
    private int f1790t;
    private DataSetObserver f1791u;
    private View f1792v;
    private Drawable f1793w;
    private OnItemClickListener f1794x;
    private OnItemSelectedListener f1795y;
    private final C0905e f1796z;

    /* renamed from: android.support.v7.widget.am.1 */
    class C08981 extends ai {
        final /* synthetic */ am f2257a;

        public /* synthetic */ C0763s m4644a() {
            return m4645d();
        }

        public am m4645d() {
            return this.f2257a;
        }
    }

    /* renamed from: android.support.v7.widget.am.2 */
    class C08992 implements Runnable {
        final /* synthetic */ am f2258a;

        C08992(am amVar) {
            this.f2258a = amVar;
        }

        public void run() {
            View i = this.f2258a.m3704i();
            if (i != null && i.getWindowToken() != null) {
                this.f2258a.m3683a();
            }
        }
    }

    /* renamed from: android.support.v7.widget.am.3 */
    class C09003 implements OnItemSelectedListener {
        final /* synthetic */ am f2259a;

        C09003(am amVar) {
            this.f2259a = amVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                ag a = this.f2259a.f1778h;
                if (a != null) {
                    a.setListSelectionHidden(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: android.support.v7.widget.am.a */
    private class C0901a implements Runnable {
        final /* synthetic */ am f2260a;

        private C0901a(am amVar) {
            this.f2260a = amVar;
        }

        public void run() {
            this.f2260a.m3709m();
        }
    }

    /* renamed from: android.support.v7.widget.am.b */
    private class C0902b extends DataSetObserver {
        final /* synthetic */ am f2261a;

        private C0902b(am amVar) {
            this.f2261a = amVar;
        }

        public void onChanged() {
            if (this.f2261a.m3696d()) {
                this.f2261a.m3683a();
            }
        }

        public void onInvalidated() {
            this.f2261a.m3693c();
        }
    }

    /* renamed from: android.support.v7.widget.am.c */
    private class C0903c implements OnScrollListener {
        final /* synthetic */ am f2262a;

        private C0903c(am amVar) {
            this.f2262a = amVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f2262a.m3710n() && this.f2262a.f1775c.getContentView() != null) {
                this.f2262a.f1770E.removeCallbacks(this.f2262a.f1796z);
                this.f2262a.f1796z.run();
            }
        }
    }

    /* renamed from: android.support.v7.widget.am.d */
    private class C0904d implements OnTouchListener {
        final /* synthetic */ am f2263a;

        private C0904d(am amVar) {
            this.f2263a = amVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f2263a.f1775c != null && this.f2263a.f1775c.isShowing() && x >= 0 && x < this.f2263a.f1775c.getWidth() && y >= 0 && y < this.f2263a.f1775c.getHeight()) {
                this.f2263a.f1770E.postDelayed(this.f2263a.f1796z, 250);
            } else if (action == 1) {
                this.f2263a.f1770E.removeCallbacks(this.f2263a.f1796z);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.am.e */
    private class C0905e implements Runnable {
        final /* synthetic */ am f2264a;

        private C0905e(am amVar) {
            this.f2264a = amVar;
        }

        public void run() {
            if (this.f2264a.f1778h != null && ah.m1903F(this.f2264a.f1778h) && this.f2264a.f1778h.getCount() > this.f2264a.f1778h.getChildCount() && this.f2264a.f1778h.getChildCount() <= this.f2264a.f1774b) {
                this.f2264a.f1775c.setInputMethodMode(2);
                this.f2264a.m3683a();
            }
        }
    }

    static {
        try {
            f1763a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f1764d = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f1765e = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public am(Context context) {
        this(context, null, C0720a.listPopupWindowStyle);
    }

    public am(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public am(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1779i = -2;
        this.f1780j = -2;
        this.f1783m = 1002;
        this.f1785o = true;
        this.f1786p = 0;
        this.f1787q = false;
        this.f1788r = false;
        this.f1774b = Integer.MAX_VALUE;
        this.f1790t = 0;
        this.f1796z = new C0905e();
        this.f1766A = new C0904d();
        this.f1767B = new C0903c();
        this.f1768C = new C0901a();
        this.f1771F = new Rect();
        this.f1776f = context;
        this.f1770E = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.ListPopupWindow, i, i2);
        this.f1781k = obtainStyledAttributes.getDimensionPixelOffset(C0729j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1782l = obtainStyledAttributes.getDimensionPixelOffset(C0729j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1782l != 0) {
            this.f1784n = true;
        }
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 11) {
            this.f1775c = new C0957s(context, attributeSet, i, i2);
        } else {
            this.f1775c = new C0957s(context, attributeSet, i);
        }
        this.f1775c.setInputMethodMode(1);
    }

    private int m3675a(View view, int i, boolean z) {
        if (f1764d != null) {
            try {
                return ((Integer) f1764d.invoke(this.f1775c, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1775c.getMaxAvailableHeight(view, i);
    }

    private void m3678b() {
        if (this.f1789s != null) {
            ViewParent parent = this.f1789s.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1789s);
            }
        }
    }

    private void m3679b(boolean z) {
        if (f1763a != null) {
            try {
                f1763a.invoke(this.f1775c, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int m3681f() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f1778h == null) {
            Context context = this.f1776f;
            this.f1769D = new C08992(this);
            this.f1778h = m3682a(context, !this.f1773H);
            if (this.f1793w != null) {
                this.f1778h.setSelector(this.f1793w);
            }
            this.f1778h.setAdapter(this.f1777g);
            this.f1778h.setOnItemClickListener(this.f1794x);
            this.f1778h.setFocusable(true);
            this.f1778h.setFocusableInTouchMode(true);
            this.f1778h.setOnItemSelectedListener(new C09003(this));
            this.f1778h.setOnScrollListener(this.f1767B);
            if (this.f1795y != null) {
                this.f1778h.setOnItemSelectedListener(this.f1795y);
            }
            View view2 = this.f1778h;
            View view3 = this.f1789s;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1790t) {
                    case C1373c.View_android_theme /*0*/:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case C1373c.View_android_focusable /*1*/:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1790t);
                        break;
                }
                if (this.f1780j >= 0) {
                    i = this.f1780j;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f1775c.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f1775c.getContentView();
            view = this.f1789s;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f1775c.getBackground();
        if (background != null) {
            background.getPadding(this.f1771F);
            i2 = this.f1771F.top + this.f1771F.bottom;
            if (this.f1784n) {
                i4 = i2;
            } else {
                this.f1782l = -this.f1771F.top;
                i4 = i2;
            }
        } else {
            this.f1771F.setEmpty();
            i4 = 0;
        }
        if (this.f1775c.getInputMethodMode() != 2) {
            z = false;
        }
        i = m3675a(m3704i(), this.f1782l, z);
        if (this.f1787q || this.f1779i == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f1780j) {
            case ac.POSITION_NONE /*-2*/:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1776f.getResources().getDisplayMetrics().widthPixels - (this.f1771F.left + this.f1771F.right), Integer.MIN_VALUE);
                break;
            case ac.POSITION_UNCHANGED /*-1*/:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1776f.getResources().getDisplayMetrics().widthPixels - (this.f1771F.left + this.f1771F.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1780j, 1073741824);
                break;
        }
        i2 = this.f1778h.m4629a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += (this.f1778h.getPaddingTop() + this.f1778h.getPaddingBottom()) + i4;
        }
        return i2 + i3;
    }

    ag m3682a(Context context, boolean z) {
        return new ag(context, z);
    }

    public void m3683a() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int f = m3681f();
        boolean n = m3710n();
        C0622q.m2723a(this.f1775c, this.f1783m);
        if (this.f1775c.isShowing()) {
            int i2;
            int width = this.f1780j == -1 ? -1 : this.f1780j == -2 ? m3704i().getWidth() : this.f1780j;
            if (this.f1779i == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.f1775c.setWidth(this.f1780j == -1 ? -1 : 0);
                    this.f1775c.setHeight(0);
                    i2 = f;
                } else {
                    this.f1775c.setWidth(this.f1780j == -1 ? -1 : 0);
                    this.f1775c.setHeight(-1);
                    i2 = f;
                }
            } else {
                i2 = this.f1779i == -2 ? f : this.f1779i;
            }
            PopupWindow popupWindow = this.f1775c;
            if (!(this.f1788r || this.f1787q)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.f1775c;
            View i3 = m3704i();
            f = this.f1781k;
            int i4 = this.f1782l;
            if (width < 0) {
                width = -1;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(i3, f, i4, width, i);
            return;
        }
        int width2 = this.f1780j == -1 ? -1 : this.f1780j == -2 ? m3704i().getWidth() : this.f1780j;
        if (this.f1779i == -1) {
            f = -1;
        } else if (this.f1779i != -2) {
            f = this.f1779i;
        }
        this.f1775c.setWidth(width2);
        this.f1775c.setHeight(f);
        m3679b(true);
        popupWindow = this.f1775c;
        if (this.f1788r || this.f1787q) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f1775c.setTouchInterceptor(this.f1766A);
        if (f1765e != null) {
            try {
                f1765e.invoke(this.f1775c, new Object[]{this.f1772G});
            } catch (Throwable e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        C0622q.m2724a(this.f1775c, m3704i(), this.f1781k, this.f1782l, this.f1786p);
        this.f1778h.setSelection(-1);
        if (!this.f1773H || this.f1778h.isInTouchMode()) {
            m3709m();
        }
        if (!this.f1773H) {
            this.f1770E.post(this.f1768C);
        }
    }

    public void m3684a(int i) {
        this.f1790t = i;
    }

    public void m3685a(Rect rect) {
        this.f1772G = rect;
    }

    public void m3686a(Drawable drawable) {
        this.f1775c.setBackgroundDrawable(drawable);
    }

    public void m3687a(View view) {
        this.f1792v = view;
    }

    public void m3688a(OnItemClickListener onItemClickListener) {
        this.f1794x = onItemClickListener;
    }

    public void m3689a(ListAdapter listAdapter) {
        if (this.f1791u == null) {
            this.f1791u = new C0902b();
        } else if (this.f1777g != null) {
            this.f1777g.unregisterDataSetObserver(this.f1791u);
        }
        this.f1777g = listAdapter;
        if (this.f1777g != null) {
            listAdapter.registerDataSetObserver(this.f1791u);
        }
        if (this.f1778h != null) {
            this.f1778h.setAdapter(this.f1777g);
        }
    }

    public void m3690a(OnDismissListener onDismissListener) {
        this.f1775c.setOnDismissListener(onDismissListener);
    }

    public void m3691a(boolean z) {
        this.f1773H = z;
        this.f1775c.setFocusable(z);
    }

    public void m3692b(int i) {
        this.f1775c.setAnimationStyle(i);
    }

    public void m3693c() {
        this.f1775c.dismiss();
        m3678b();
        this.f1775c.setContentView(null);
        this.f1778h = null;
        this.f1770E.removeCallbacks(this.f1796z);
    }

    public void m3694c(int i) {
        this.f1781k = i;
    }

    public void m3695d(int i) {
        this.f1782l = i;
        this.f1784n = true;
    }

    public boolean m3696d() {
        return this.f1775c.isShowing();
    }

    public ListView m3697e() {
        return this.f1778h;
    }

    public void m3698e(int i) {
        this.f1786p = i;
    }

    public void m3699f(int i) {
        this.f1780j = i;
    }

    public void m3700g(int i) {
        Drawable background = this.f1775c.getBackground();
        if (background != null) {
            background.getPadding(this.f1771F);
            this.f1780j = (this.f1771F.left + this.f1771F.right) + i;
            return;
        }
        m3699f(i);
    }

    public boolean m3701g() {
        return this.f1773H;
    }

    public Drawable m3702h() {
        return this.f1775c.getBackground();
    }

    public void m3703h(int i) {
        this.f1775c.setInputMethodMode(i);
    }

    public View m3704i() {
        return this.f1792v;
    }

    public void m3705i(int i) {
        ag agVar = this.f1778h;
        if (m3696d() && agVar != null) {
            agVar.setListSelectionHidden(false);
            agVar.setSelection(i);
            if (VERSION.SDK_INT >= 11 && agVar.getChoiceMode() != 0) {
                agVar.setItemChecked(i, true);
            }
        }
    }

    public int m3706j() {
        return this.f1781k;
    }

    public int m3707k() {
        return !this.f1784n ? 0 : this.f1782l;
    }

    public int m3708l() {
        return this.f1780j;
    }

    public void m3709m() {
        ag agVar = this.f1778h;
        if (agVar != null) {
            agVar.setListSelectionHidden(true);
            agVar.requestLayout();
        }
    }

    public boolean m3710n() {
        return this.f1775c.getInputMethodMode() == 2;
    }
}
