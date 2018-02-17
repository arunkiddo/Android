package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016k.C0120a;
import android.support.v4.p016k.C0522f;
import android.support.v4.p016k.C0543o;
import android.support.v4.p016k.C0550q;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.ah;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;
import android.support.v7.p033a.C0645a.C0642a;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.C0740c;
import android.support.v7.view.C0747g;
import android.support.v7.view.menu.C0755o;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0769h.C0676a;
import android.support.v7.view.menu.C0772j;
import android.support.v7.view.menu.C0786u;
import android.support.v7.widget.ActionMenuView.C0799e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int f2128A;
    private boolean f2129B;
    private boolean f2130C;
    private final ArrayList<View> f2131D;
    private final ArrayList<View> f2132E;
    private final int[] f2133F;
    private C0702c f2134G;
    private final C0799e f2135H;
    private bg f2136I;
    private C0931d f2137J;
    private C0877a f2138K;
    private C0691a f2139L;
    private C0676a f2140M;
    private boolean f2141N;
    private final Runnable f2142O;
    private final C0951m f2143P;
    View f2144a;
    private ActionMenuView f2145b;
    private TextView f2146c;
    private TextView f2147d;
    private ImageButton f2148e;
    private ImageView f2149f;
    private Drawable f2150g;
    private CharSequence f2151h;
    private ImageButton f2152i;
    private Context f2153j;
    private int f2154k;
    private int f2155l;
    private int f2156m;
    private int f2157n;
    private int f2158o;
    private int f2159p;
    private int f2160q;
    private int f2161r;
    private int f2162s;
    private final av f2163t;
    private int f2164u;
    private int f2165v;
    private int f2166w;
    private CharSequence f2167x;
    private CharSequence f2168y;
    private int f2169z;

    /* renamed from: android.support.v7.widget.Toolbar.c */
    public interface C0702c {
        boolean m3060a(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.Toolbar.1 */
    class C08741 implements C0799e {
        final /* synthetic */ Toolbar f2119a;

        C08741(Toolbar toolbar) {
            this.f2119a = toolbar;
        }

        public boolean m4432a(MenuItem menuItem) {
            return this.f2119a.f2134G != null ? this.f2119a.f2134G.m3060a(menuItem) : false;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.2 */
    class C08752 implements Runnable {
        final /* synthetic */ Toolbar f2120a;

        C08752(Toolbar toolbar) {
            this.f2120a = toolbar;
        }

        public void run() {
            this.f2120a.m4481d();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.3 */
    class C08763 implements OnClickListener {
        final /* synthetic */ Toolbar f2121a;

        C08763(Toolbar toolbar) {
            this.f2121a = toolbar;
        }

        public void onClick(View view) {
            this.f2121a.m4485h();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.a */
    private class C0877a implements C0755o {
        C0769h f2122a;
        C0772j f2123b;
        final /* synthetic */ Toolbar f2124c;

        private C0877a(Toolbar toolbar) {
            this.f2124c = toolbar;
        }

        public void m4433a(Context context, C0769h c0769h) {
            if (!(this.f2122a == null || this.f2123b == null)) {
                this.f2122a.m3457d(this.f2123b);
            }
            this.f2122a = c0769h;
        }

        public void m4434a(C0769h c0769h, boolean z) {
        }

        public void m4435a(C0691a c0691a) {
        }

        public boolean m4436a(C0769h c0769h, C0772j c0772j) {
            this.f2124c.m4468p();
            if (this.f2124c.f2152i.getParent() != this.f2124c) {
                this.f2124c.addView(this.f2124c.f2152i);
            }
            this.f2124c.f2144a = c0772j.getActionView();
            this.f2123b = c0772j;
            if (this.f2124c.f2144a.getParent() != this.f2124c) {
                LayoutParams i = this.f2124c.m4486i();
                i.a = 8388611 | (this.f2124c.f2157n & C1373c.AppCompatTheme_spinnerStyle);
                i.f2125b = 2;
                this.f2124c.f2144a.setLayoutParams(i);
                this.f2124c.addView(this.f2124c.f2144a);
            }
            this.f2124c.m4487j();
            this.f2124c.requestLayout();
            c0772j.m3496e(true);
            if (this.f2124c.f2144a instanceof C0740c) {
                ((C0740c) this.f2124c.f2144a).m3220a();
            }
            return true;
        }

        public boolean m4437a(C0786u c0786u) {
            return false;
        }

        public void m4438b(boolean z) {
            Object obj = null;
            if (this.f2123b != null) {
                if (this.f2122a != null) {
                    int size = this.f2122a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f2122a.getItem(i) == this.f2123b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    m4440b(this.f2122a, this.f2123b);
                }
            }
        }

        public boolean m4439b() {
            return false;
        }

        public boolean m4440b(C0769h c0769h, C0772j c0772j) {
            if (this.f2124c.f2144a instanceof C0740c) {
                ((C0740c) this.f2124c.f2144a).m3221b();
            }
            this.f2124c.removeView(this.f2124c.f2144a);
            this.f2124c.removeView(this.f2124c.f2152i);
            this.f2124c.f2144a = null;
            this.f2124c.m4488k();
            this.f2123b = null;
            this.f2124c.requestLayout();
            c0772j.m3496e(false);
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.b */
    public static class C0878b extends C0642a {
        int f2125b;

        public C0878b(int i, int i2) {
            super(i, i2);
            this.f2125b = 0;
            this.a = 8388627;
        }

        public C0878b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2125b = 0;
        }

        public C0878b(C0642a c0642a) {
            super(c0642a);
            this.f2125b = 0;
        }

        public C0878b(C0878b c0878b) {
            super((C0642a) c0878b);
            this.f2125b = 0;
            this.f2125b = c0878b.f2125b;
        }

        public C0878b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2125b = 0;
        }

        public C0878b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f2125b = 0;
            m4441a(marginLayoutParams);
        }

        void m4441a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.d */
    public static class C0880d extends C0120a {
        public static final Creator<C0880d> CREATOR;
        int f2126a;
        boolean f2127b;

        /* renamed from: android.support.v7.widget.Toolbar.d.1 */
        static class C08791 implements C0118e<C0880d> {
            C08791() {
            }

            public C0880d m4442a(Parcel parcel, ClassLoader classLoader) {
                return new C0880d(parcel, classLoader);
            }

            public C0880d[] m4443a(int i) {
                return new C0880d[i];
            }

            public /* synthetic */ Object m4444b(Parcel parcel, ClassLoader classLoader) {
                return m4442a(parcel, classLoader);
            }

            public /* synthetic */ Object[] m4445b(int i) {
                return m4443a(i);
            }
        }

        static {
            CREATOR = C0356d.m1329a(new C08791());
        }

        public C0880d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2126a = parcel.readInt();
            this.f2127b = parcel.readInt() != 0;
        }

        public C0880d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2126a);
            parcel.writeInt(this.f2127b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2163t = new av();
        this.f2166w = 8388627;
        this.f2131D = new ArrayList();
        this.f2132E = new ArrayList();
        this.f2133F = new int[2];
        this.f2135H = new C08741(this);
        this.f2142O = new C08752(this);
        bf a = bf.m4774a(getContext(), attributeSet, C0729j.Toolbar, i, 0);
        this.f2155l = a.m4790g(C0729j.Toolbar_titleTextAppearance, 0);
        this.f2156m = a.m4790g(C0729j.Toolbar_subtitleTextAppearance, 0);
        this.f2166w = a.m4782c(C0729j.Toolbar_android_gravity, this.f2166w);
        this.f2157n = a.m4782c(C0729j.Toolbar_buttonGravity, 48);
        int d = a.m4784d(C0729j.Toolbar_titleMargin, 0);
        if (a.m4791g(C0729j.Toolbar_titleMargins)) {
            d = a.m4784d(C0729j.Toolbar_titleMargins, d);
        }
        this.f2162s = d;
        this.f2161r = d;
        this.f2160q = d;
        this.f2159p = d;
        d = a.m4784d(C0729j.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f2159p = d;
        }
        d = a.m4784d(C0729j.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f2160q = d;
        }
        d = a.m4784d(C0729j.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f2161r = d;
        }
        d = a.m4784d(C0729j.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f2162s = d;
        }
        this.f2158o = a.m4786e(C0729j.Toolbar_maxButtonHeight, -1);
        d = a.m4784d(C0729j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m4784d(C0729j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f2163t.m4722b(a.m4786e(C0729j.Toolbar_contentInsetLeft, 0), a.m4786e(C0729j.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f2163t.m4719a(d, d2);
        }
        this.f2164u = a.m4784d(C0729j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f2165v = a.m4784d(C0729j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2150g = a.m4777a(C0729j.Toolbar_collapseIcon);
        this.f2151h = a.m4783c(C0729j.Toolbar_collapseContentDescription);
        CharSequence c = a.m4783c(C0729j.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m4783c(C0729j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f2153j = getContext();
        setPopupTheme(a.m4790g(C0729j.Toolbar_popupTheme, 0));
        Drawable a2 = a.m4777a(C0729j.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m4783c(C0729j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m4777a(C0729j.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m4783c(C0729j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m4791g(C0729j.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m4780b(C0729j.Toolbar_titleTextColor, -1));
        }
        if (a.m4791g(C0729j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m4780b(C0729j.Toolbar_subtitleTextColor, -1));
        }
        a.m4778a();
        this.f2143P = C0951m.m4995a();
    }

    private int m4446a(int i) {
        int i2 = i & C1373c.AppCompatTheme_spinnerStyle;
        switch (i2) {
            case C1373c.Toolbar_titleMarginEnd /*16*/:
            case C1373c.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
            case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                return i2;
            default:
                return this.f2166w & C1373c.AppCompatTheme_spinnerStyle;
        }
    }

    private int m4447a(View view, int i) {
        C0878b c0878b = (C0878b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m4446a(c0878b.a)) {
            case C1373c.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                return getPaddingTop() - i2;
            case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0878b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0878b.topMargin) {
                    i3 = c0878b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0878b.bottomMargin ? Math.max(0, i2 - (c0878b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m4448a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int m4449a(View view, int i, int[] iArr, int i2) {
        C0878b c0878b = (C0878b) view.getLayoutParams();
        int i3 = c0878b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m4447a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0878b.rightMargin + measuredWidth) + max;
    }

    private int m4450a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0878b c0878b = (C0878b) view.getLayoutParams();
            i6 = c0878b.leftMargin - i6;
            i = c0878b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void m4452a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void m4453a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m4486i();
        } else if (checkLayoutParams(layoutParams)) {
            C0878b c0878b = (C0878b) layoutParams;
        } else {
            layoutParams = m4472a(layoutParams);
        }
        layoutParams.f2125b = 1;
        if (!z || this.f2144a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f2132E.add(view);
    }

    private void m4454a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ah.m1941h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0522f.m2290a(i, ah.m1941h(this));
        list.clear();
        C0878b c0878b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0878b = (C0878b) childAt.getLayoutParams();
                if (c0878b.f2125b == 0 && m4455a(childAt) && m4456b(c0878b.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0878b = (C0878b) childAt2.getLayoutParams();
            if (c0878b.f2125b == 0 && m4455a(childAt2) && m4456b(c0878b.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean m4455a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m4456b(int i) {
        int h = ah.m1941h(this);
        int a = C0522f.m2290a(i, h) & 7;
        switch (a) {
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
            case C1373c.Toolbar_contentInsetStart /*5*/:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private int m4457b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0543o.m2333b(marginLayoutParams) + C0543o.m2332a(marginLayoutParams);
    }

    private int m4458b(View view, int i, int[] iArr, int i2) {
        C0878b c0878b = (C0878b) view.getLayoutParams();
        int i3 = c0878b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m4447a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0878b.leftMargin + measuredWidth);
    }

    private int m4460c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean m4463d(View view) {
        return view.getParent() == this || this.f2132E.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new C0747g(getContext());
    }

    private void m4464l() {
        if (this.f2149f == null) {
            this.f2149f = new ImageView(getContext());
        }
    }

    private void m4465m() {
        m4466n();
        if (this.f2145b.m3643d() == null) {
            C0769h c0769h = (C0769h) this.f2145b.getMenu();
            if (this.f2138K == null) {
                this.f2138K = new C0877a();
            }
            this.f2145b.setExpandedActionViewsExclusive(true);
            c0769h.m3438a(this.f2138K, this.f2153j);
        }
    }

    private void m4466n() {
        if (this.f2145b == null) {
            this.f2145b = new ActionMenuView(getContext());
            this.f2145b.setPopupTheme(this.f2154k);
            this.f2145b.setOnMenuItemClickListener(this.f2135H);
            this.f2145b.m3635a(this.f2139L, this.f2140M);
            LayoutParams i = m4486i();
            i.a = 8388613 | (this.f2157n & C1373c.AppCompatTheme_spinnerStyle);
            this.f2145b.setLayoutParams(i);
            m4453a(this.f2145b, false);
        }
    }

    private void m4467o() {
        if (this.f2148e == null) {
            this.f2148e = new ImageButton(getContext(), null, C0720a.toolbarNavigationButtonStyle);
            LayoutParams i = m4486i();
            i.a = 8388611 | (this.f2157n & C1373c.AppCompatTheme_spinnerStyle);
            this.f2148e.setLayoutParams(i);
        }
    }

    private void m4468p() {
        if (this.f2152i == null) {
            this.f2152i = new ImageButton(getContext(), null, C0720a.toolbarNavigationButtonStyle);
            this.f2152i.setImageDrawable(this.f2150g);
            this.f2152i.setContentDescription(this.f2151h);
            LayoutParams i = m4486i();
            i.a = 8388611 | (this.f2157n & C1373c.AppCompatTheme_spinnerStyle);
            i.f2125b = 2;
            this.f2152i.setLayoutParams(i);
            this.f2152i.setOnClickListener(new C08763(this));
        }
    }

    private void m4469q() {
        removeCallbacks(this.f2142O);
        post(this.f2142O);
    }

    private boolean m4470r() {
        if (!this.f2141N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m4455a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public C0878b m4471a(AttributeSet attributeSet) {
        return new C0878b(getContext(), attributeSet);
    }

    protected C0878b m4472a(LayoutParams layoutParams) {
        return layoutParams instanceof C0878b ? new C0878b((C0878b) layoutParams) : layoutParams instanceof C0642a ? new C0878b((C0642a) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0878b((MarginLayoutParams) layoutParams) : new C0878b(layoutParams);
    }

    public void m4473a(int i, int i2) {
        this.f2163t.m4719a(i, i2);
    }

    public void m4474a(Context context, int i) {
        this.f2155l = i;
        if (this.f2146c != null) {
            this.f2146c.setTextAppearance(context, i);
        }
    }

    public void m4475a(C0769h c0769h, C0931d c0931d) {
        if (c0769h != null || this.f2145b != null) {
            m4466n();
            C0769h d = this.f2145b.m3643d();
            if (d != c0769h) {
                if (d != null) {
                    d.m3448b(this.f2137J);
                    d.m3448b(this.f2138K);
                }
                if (this.f2138K == null) {
                    this.f2138K = new C0877a();
                }
                c0931d.m4909d(true);
                if (c0769h != null) {
                    c0769h.m3438a((C0755o) c0931d, this.f2153j);
                    c0769h.m3438a(this.f2138K, this.f2153j);
                } else {
                    c0931d.m4895a(this.f2153j, null);
                    this.f2138K.m4433a(this.f2153j, null);
                    c0931d.m4905b(true);
                    this.f2138K.m4438b(true);
                }
                this.f2145b.setPopupTheme(this.f2154k);
                this.f2145b.setPresenter(c0931d);
                this.f2137J = c0931d;
            }
        }
    }

    public void m4476a(C0691a c0691a, C0676a c0676a) {
        this.f2139L = c0691a;
        this.f2140M = c0676a;
        if (this.f2145b != null) {
            this.f2145b.m3635a(c0691a, c0676a);
        }
    }

    public boolean m4477a() {
        return getVisibility() == 0 && this.f2145b != null && this.f2145b.m3636a();
    }

    public void m4478b(Context context, int i) {
        this.f2156m = i;
        if (this.f2147d != null) {
            this.f2147d.setTextAppearance(context, i);
        }
    }

    public boolean m4479b() {
        return this.f2145b != null && this.f2145b.m3646g();
    }

    public boolean m4480c() {
        return this.f2145b != null && this.f2145b.m3647h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0878b);
    }

    public boolean m4481d() {
        return this.f2145b != null && this.f2145b.m3644e();
    }

    public boolean m4482e() {
        return this.f2145b != null && this.f2145b.m3645f();
    }

    public void m4483f() {
        if (this.f2145b != null) {
            this.f2145b.m3648i();
        }
    }

    public boolean m4484g() {
        return (this.f2138K == null || this.f2138K.f2123b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m4486i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m4471a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m4472a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.f2163t.m4724d();
    }

    public int getContentInsetEndWithActions() {
        return this.f2165v != Integer.MIN_VALUE ? this.f2165v : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        return this.f2163t.m4718a();
    }

    public int getContentInsetRight() {
        return this.f2163t.m4721b();
    }

    public int getContentInsetStart() {
        return this.f2163t.m4723c();
    }

    public int getContentInsetStartWithNavigation() {
        return this.f2164u != Integer.MIN_VALUE ? this.f2164u : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.f2145b != null) {
            C0769h d = this.f2145b.m3643d();
            i = (d == null || !d.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        return i != 0 ? Math.max(getContentInsetEnd(), Math.max(this.f2165v, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return ah.m1941h(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return ah.m1941h(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2164u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        return this.f2149f != null ? this.f2149f.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.f2149f != null ? this.f2149f.getContentDescription() : null;
    }

    public Menu getMenu() {
        m4465m();
        return this.f2145b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.f2148e != null ? this.f2148e.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.f2148e != null ? this.f2148e.getDrawable() : null;
    }

    public Drawable getOverflowIcon() {
        m4465m();
        return this.f2145b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f2154k;
    }

    public CharSequence getSubtitle() {
        return this.f2168y;
    }

    public CharSequence getTitle() {
        return this.f2167x;
    }

    public int getTitleMarginBottom() {
        return this.f2162s;
    }

    public int getTitleMarginEnd() {
        return this.f2160q;
    }

    public int getTitleMarginStart() {
        return this.f2159p;
    }

    public int getTitleMarginTop() {
        return this.f2161r;
    }

    public ad getWrapper() {
        if (this.f2136I == null) {
            this.f2136I = new bg(this, true);
        }
        return this.f2136I;
    }

    public void m4485h() {
        C0772j c0772j = this.f2138K == null ? null : this.f2138K.f2123b;
        if (c0772j != null) {
            c0772j.collapseActionView();
        }
    }

    protected C0878b m4486i() {
        return new C0878b(-2, -2);
    }

    void m4487j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0878b) childAt.getLayoutParams()).f2125b == 2 || childAt == this.f2145b)) {
                removeViewAt(childCount);
                this.f2132E.add(childAt);
            }
        }
    }

    void m4488k() {
        for (int size = this.f2132E.size() - 1; size >= 0; size--) {
            addView((View) this.f2132E.get(size));
        }
        this.f2132E.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2142O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0560t.m2392a(motionEvent);
        if (a == 9) {
            this.f2130C = false;
        }
        if (!this.f2130C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f2130C = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f2130C = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int measuredHeight;
        int measuredWidth;
        Object obj = ah.m1941h(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = width - paddingRight;
        int[] iArr = this.f2133F;
        iArr[1] = 0;
        iArr[0] = 0;
        int q = ah.m1950q(this);
        if (!m4455a(this.f2148e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i6 = m4458b(this.f2148e, i6, iArr, q);
            i5 = paddingLeft;
        } else {
            i5 = m4449a(this.f2148e, paddingLeft, iArr, q);
        }
        if (m4455a(this.f2152i)) {
            if (obj != null) {
                i6 = m4458b(this.f2152i, i6, iArr, q);
            } else {
                i5 = m4449a(this.f2152i, i5, iArr, q);
            }
        }
        if (m4455a(this.f2145b)) {
            if (obj != null) {
                i5 = m4449a(this.f2145b, i5, iArr, q);
            } else {
                i6 = m4458b(this.f2145b, i6, iArr, q);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - i6));
        i5 = Math.max(i5, currentContentInsetLeft);
        i6 = Math.min(i6, (width - paddingRight) - currentContentInsetRight);
        if (m4455a(this.f2144a)) {
            if (obj != null) {
                i6 = m4458b(this.f2144a, i6, iArr, q);
            } else {
                i5 = m4449a(this.f2144a, i5, iArr, q);
            }
        }
        if (!m4455a(this.f2149f)) {
            currentContentInsetLeft = i6;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = m4458b(this.f2149f, i6, iArr, q);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = i6;
            currentContentInsetRight = m4449a(this.f2149f, i5, iArr, q);
        }
        boolean a = m4455a(this.f2146c);
        boolean a2 = m4455a(this.f2147d);
        i5 = 0;
        if (a) {
            C0878b c0878b = (C0878b) this.f2146c.getLayoutParams();
            i5 = 0 + (c0878b.bottomMargin + (c0878b.topMargin + this.f2146c.getMeasuredHeight()));
        }
        if (a2) {
            c0878b = (C0878b) this.f2147d.getLayoutParams();
            measuredHeight = (c0878b.bottomMargin + (c0878b.topMargin + this.f2147d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0878b = (C0878b) (a ? this.f2146c : this.f2147d).getLayoutParams();
            C0878b c0878b2 = (C0878b) (a2 ? this.f2147d : this.f2146c).getLayoutParams();
            Object obj2 = ((!a || this.f2146c.getMeasuredWidth() <= 0) && (!a2 || this.f2147d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f2166w & C1373c.AppCompatTheme_spinnerStyle) {
                case C1373c.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                    paddingTop2 = (c0878b.topMargin + getPaddingTop()) + this.f2161r;
                    break;
                case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                    paddingTop2 = (((height - paddingBottom) - c0878b2.bottomMargin) - this.f2162s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0878b.topMargin + this.f2161r) {
                        i6 = c0878b.topMargin + this.f2161r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        i6 = measuredHeight < c0878b.bottomMargin + this.f2162s ? Math.max(0, paddingTop2 - ((c0878b2.bottomMargin + this.f2162s) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + i6;
                    break;
            }
            if (obj != null) {
                i6 = (obj2 != null ? this.f2159p : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, i6);
                iArr[1] = Math.max(0, -i6);
                if (a) {
                    c0878b = (C0878b) this.f2146c.getLayoutParams();
                    measuredWidth = i5 - this.f2146c.getMeasuredWidth();
                    currentContentInsetLeft = this.f2146c.getMeasuredHeight() + paddingTop2;
                    this.f2146c.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + c0878b.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.f2160q;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    c0878b = (C0878b) this.f2147d.getLayoutParams();
                    measuredWidth = c0878b.topMargin + paddingTop2;
                    measuredHeight = this.f2147d.getMeasuredHeight() + measuredWidth;
                    this.f2147d.layout(i5 - this.f2147d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i6 = c0878b.bottomMargin + measuredHeight;
                    i6 = i5 - this.f2160q;
                } else {
                    i6 = i5;
                }
                currentContentInsetLeft = obj2 != null ? Math.min(currentContentInsetLeft, i6) : i5;
            } else {
                i6 = (obj2 != null ? this.f2159p : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, i6);
                iArr[0] = Math.max(0, -i6);
                if (a) {
                    c0878b = (C0878b) this.f2146c.getLayoutParams();
                    i5 = this.f2146c.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.f2146c.getMeasuredHeight() + paddingTop2;
                    this.f2146c.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    i6 = c0878b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f2160q;
                    i5 = i6;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0878b = (C0878b) this.f2147d.getLayoutParams();
                    i5 += c0878b.topMargin;
                    paddingTop2 = this.f2147d.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.f2147d.getMeasuredHeight() + i5;
                    this.f2147d.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    i6 = c0878b.bottomMargin + measuredHeight;
                    i6 = this.f2160q + paddingTop2;
                } else {
                    i6 = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, i6);
                }
            }
        }
        m4454a(this.f2131D, 3);
        int size = this.f2131D.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m4449a((View) this.f2131D.get(measuredWidth), i5, iArr, q);
        }
        m4454a(this.f2131D, 5);
        currentContentInsetRight = this.f2131D.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = m4458b((View) this.f2131D.get(measuredWidth), currentContentInsetLeft, iArr, q);
        }
        m4454a(this.f2131D, 1);
        measuredWidth = m4450a(this.f2131D, iArr);
        i6 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i6;
        if (i6 < i5) {
            i6 = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            i6 -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.f2131D.size();
        measuredWidth = i6;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m4449a((View) this.f2131D.get(i5), measuredWidth, iArr, q);
        }
        this.f2131D.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f2133F;
        if (bj.m4867a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m4455a(this.f2148e)) {
            m4452a(this.f2148e, i, 0, i2, 0, this.f2158o);
            i7 = this.f2148e.getMeasuredWidth() + m4457b(this.f2148e);
            max = Math.max(0, this.f2148e.getMeasuredHeight() + m4460c(this.f2148e));
            i6 = bj.m4865a(0, ah.m1943j(this.f2148e));
            i5 = max;
        }
        if (m4455a(this.f2152i)) {
            m4452a(this.f2152i, i, 0, i2, 0, this.f2158o);
            i7 = this.f2152i.getMeasuredWidth() + m4457b(this.f2152i);
            i5 = Math.max(i5, this.f2152i.getMeasuredHeight() + m4460c(this.f2152i));
            i6 = bj.m4865a(i6, ah.m1943j(this.f2152i));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (m4455a(this.f2145b)) {
            m4452a(this.f2145b, i, max2, i2, 0, this.f2158o);
            i7 = this.f2145b.getMeasuredWidth() + m4457b(this.f2145b);
            i5 = Math.max(i5, this.f2145b.getMeasuredHeight() + m4460c(this.f2145b));
            i6 = bj.m4865a(i6, ah.m1943j(this.f2145b));
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (m4455a(this.f2144a)) {
            max2 += m4448a(this.f2144a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2144a.getMeasuredHeight() + m4460c(this.f2144a));
            i6 = bj.m4865a(i6, ah.m1943j(this.f2144a));
        }
        if (m4455a(this.f2149f)) {
            max2 += m4448a(this.f2149f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2149f.getMeasuredHeight() + m4460c(this.f2149f));
            i6 = bj.m4865a(i6, ah.m1943j(this.f2149f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0878b) childAt.getLayoutParams()).f2125b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (m4455a(childAt)) {
                max2 += m4448a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m4460c(childAt));
                i7 = bj.m4865a(i5, ah.m1943j(childAt));
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.f2161r + this.f2162s;
        max = this.f2159p + this.f2160q;
        if (m4455a(this.f2146c)) {
            m4448a(this.f2146c, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = m4457b(this.f2146c) + this.f2146c.getMeasuredWidth();
            i7 = this.f2146c.getMeasuredHeight() + m4460c(this.f2146c);
            i5 = bj.m4865a(i5, ah.m1943j(this.f2146c));
        }
        if (m4455a(this.f2147d)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, m4448a(this.f2147d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f2147d.getMeasuredHeight() + m4460c(this.f2147d);
            i5 = bj.m4865a(i5, ah.m1943j(this.f2147d));
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = ah.m1906a(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ah.m1906a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m4470r()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0880d) {
            C0880d c0880d = (C0880d) parcelable;
            super.onRestoreInstanceState(c0880d.m249a());
            Menu d = this.f2145b != null ? this.f2145b.m3643d() : null;
            if (!(c0880d.f2126a == 0 || this.f2138K == null || d == null)) {
                MenuItem findItem = d.findItem(c0880d.f2126a);
                if (findItem != null) {
                    C0550q.m2363b(findItem);
                }
            }
            if (c0880d.f2127b) {
                m4469q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        av avVar = this.f2163t;
        if (i != 1) {
            z = false;
        }
        avVar.m4720a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0880d = new C0880d(super.onSaveInstanceState());
        if (!(this.f2138K == null || this.f2138K.f2123b == null)) {
            c0880d.f2126a = this.f2138K.f2123b.getItemId();
        }
        c0880d.f2127b = m4479b();
        return c0880d;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0560t.m2392a(motionEvent);
        if (a == 0) {
            this.f2129B = false;
        }
        if (!this.f2129B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f2129B = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f2129B = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f2141N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2165v) {
            this.f2165v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2164u) {
            this.f2164u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(this.f2143P.m5013a(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m4464l();
            if (!m4463d(this.f2149f)) {
                m4453a(this.f2149f, true);
            }
        } else if (this.f2149f != null && m4463d(this.f2149f)) {
            removeView(this.f2149f);
            this.f2132E.remove(this.f2149f);
        }
        if (this.f2149f != null) {
            this.f2149f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4464l();
        }
        if (this.f2149f != null) {
            this.f2149f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4467o();
        }
        if (this.f2148e != null) {
            this.f2148e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f2143P.m5013a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m4467o();
            if (!m4463d(this.f2148e)) {
                m4453a(this.f2148e, true);
            }
        } else if (this.f2148e != null && m4463d(this.f2148e)) {
            removeView(this.f2148e);
            this.f2132E.remove(this.f2148e);
        }
        if (this.f2148e != null) {
            this.f2148e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m4467o();
        this.f2148e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(C0702c c0702c) {
        this.f2134G = c0702c;
    }

    public void setOverflowIcon(Drawable drawable) {
        m4465m();
        this.f2145b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f2154k != i) {
            this.f2154k = i;
            if (i == 0) {
                this.f2153j = getContext();
            } else {
                this.f2153j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2147d == null) {
                Context context = getContext();
                this.f2147d = new TextView(context);
                this.f2147d.setSingleLine();
                this.f2147d.setEllipsize(TruncateAt.END);
                if (this.f2156m != 0) {
                    this.f2147d.setTextAppearance(context, this.f2156m);
                }
                if (this.f2128A != 0) {
                    this.f2147d.setTextColor(this.f2128A);
                }
            }
            if (!m4463d(this.f2147d)) {
                m4453a(this.f2147d, true);
            }
        } else if (this.f2147d != null && m4463d(this.f2147d)) {
            removeView(this.f2147d);
            this.f2132E.remove(this.f2147d);
        }
        if (this.f2147d != null) {
            this.f2147d.setText(charSequence);
        }
        this.f2168y = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f2128A = i;
        if (this.f2147d != null) {
            this.f2147d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2146c == null) {
                Context context = getContext();
                this.f2146c = new TextView(context);
                this.f2146c.setSingleLine();
                this.f2146c.setEllipsize(TruncateAt.END);
                if (this.f2155l != 0) {
                    this.f2146c.setTextAppearance(context, this.f2155l);
                }
                if (this.f2169z != 0) {
                    this.f2146c.setTextColor(this.f2169z);
                }
            }
            if (!m4463d(this.f2146c)) {
                m4453a(this.f2146c, true);
            }
        } else if (this.f2146c != null && m4463d(this.f2146c)) {
            removeView(this.f2146c);
            this.f2132E.remove(this.f2146c);
        }
        if (this.f2146c != null) {
            this.f2146c.setText(charSequence);
        }
        this.f2167x = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.f2162s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f2160q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f2159p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f2161r = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.f2169z = i;
        if (this.f2146c != null) {
            this.f2146c.setTextColor(i);
        }
    }
}
