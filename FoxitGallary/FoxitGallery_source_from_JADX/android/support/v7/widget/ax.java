package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p033a.C0645a.C0644c;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.view.C0739a;
import android.support.v7.widget.ak.C0796a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ax extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2298j;
    Runnable f2299a;
    int f2300b;
    int f2301c;
    private C0914b f2302d;
    private ak f2303e;
    private Spinner f2304f;
    private boolean f2305g;
    private int f2306h;
    private int f2307i;

    /* renamed from: android.support.v7.widget.ax.1 */
    class C09121 implements Runnable {
        final /* synthetic */ View f2288a;
        final /* synthetic */ ax f2289b;

        C09121(ax axVar, View view) {
            this.f2289b = axVar;
            this.f2288a = view;
        }

        public void run() {
            this.f2289b.smoothScrollTo(this.f2288a.getLeft() - ((this.f2289b.getWidth() - this.f2288a.getWidth()) / 2), 0);
            this.f2289b.f2299a = null;
        }
    }

    /* renamed from: android.support.v7.widget.ax.a */
    private class C0913a extends BaseAdapter {
        final /* synthetic */ ax f2290a;

        private C0913a(ax axVar) {
            this.f2290a = axVar;
        }

        public int getCount() {
            return this.f2290a.f2303e.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0915c) this.f2290a.f2303e.getChildAt(i)).m4730b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f2290a.m4732a((C0644c) getItem(i), true);
            }
            ((C0915c) view).m4729a((C0644c) getItem(i));
            return view;
        }
    }

    /* renamed from: android.support.v7.widget.ax.b */
    private class C0914b implements OnClickListener {
        final /* synthetic */ ax f2291a;

        private C0914b(ax axVar) {
            this.f2291a = axVar;
        }

        public void onClick(View view) {
            ((C0915c) view).m4730b().m2814d();
            int childCount = this.f2291a.f2303e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f2291a.f2303e.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ax.c */
    private class C0915c extends ak implements OnLongClickListener {
        final /* synthetic */ ax f2292a;
        private final int[] f2293b;
        private C0644c f2294c;
        private TextView f2295d;
        private ImageView f2296e;
        private View f2297f;

        public C0915c(ax axVar, Context context, C0644c c0644c, boolean z) {
            this.f2292a = axVar;
            super(context, null, C0720a.actionBarTabStyle);
            this.f2293b = new int[]{16842964};
            this.f2294c = c0644c;
            bf a = bf.m4774a(context, null, this.f2293b, C0720a.actionBarTabStyle, 0);
            if (a.m4791g(0)) {
                setBackgroundDrawable(a.m4777a(0));
            }
            a.m4778a();
            if (z) {
                setGravity(8388627);
            }
            m4728a();
        }

        public void m4728a() {
            C0644c c0644c = this.f2294c;
            View c = c0644c.m2813c();
            if (c != null) {
                C0915c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f2297f = c;
                if (this.f2295d != null) {
                    this.f2295d.setVisibility(8);
                }
                if (this.f2296e != null) {
                    this.f2296e.setVisibility(8);
                    this.f2296e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f2297f != null) {
                removeView(this.f2297f);
                this.f2297f = null;
            }
            Drawable a = c0644c.m2811a();
            CharSequence b = c0644c.m2812b();
            if (a != null) {
                if (this.f2296e == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams c0796a = new C0796a(-2, -2);
                    c0796a.f1710h = 16;
                    imageView.setLayoutParams(c0796a);
                    addView(imageView, 0);
                    this.f2296e = imageView;
                }
                this.f2296e.setImageDrawable(a);
                this.f2296e.setVisibility(0);
            } else if (this.f2296e != null) {
                this.f2296e.setVisibility(8);
                this.f2296e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.f2295d == null) {
                    imageView = new aa(getContext(), null, C0720a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    c0796a = new C0796a(-2, -2);
                    c0796a.f1710h = 16;
                    imageView.setLayoutParams(c0796a);
                    addView(imageView);
                    this.f2295d = imageView;
                }
                this.f2295d.setText(b);
                this.f2295d.setVisibility(0);
            } else if (this.f2295d != null) {
                this.f2295d.setVisibility(8);
                this.f2295d.setText(null);
            }
            if (this.f2296e != null) {
                this.f2296e.setContentDescription(c0644c.m2815e());
            }
            if (z || TextUtils.isEmpty(c0644c.m2815e())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public void m4729a(C0644c c0644c) {
            this.f2294c = c0644c;
            m4728a();
        }

        public C0644c m4730b() {
            return this.f2294c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0644c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(C0644c.class.getName());
            }
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f2294c.m2815e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f2292a.f2300b > 0 && getMeasuredWidth() > this.f2292a.f2300b) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2292a.f2300b, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        f2298j = new DecelerateInterpolator();
    }

    private C0915c m4732a(C0644c c0644c, boolean z) {
        C0915c c0915c = new C0915c(this, getContext(), c0644c, z);
        if (z) {
            c0915c.setBackgroundDrawable(null);
            c0915c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2306h));
        } else {
            c0915c.setFocusable(true);
            if (this.f2302d == null) {
                this.f2302d = new C0914b();
            }
            c0915c.setOnClickListener(this.f2302d);
        }
        return c0915c;
    }

    private boolean m4734a() {
        return this.f2304f != null && this.f2304f.getParent() == this;
    }

    private void m4735b() {
        if (!m4734a()) {
            if (this.f2304f == null) {
                this.f2304f = m4737d();
            }
            removeView(this.f2303e);
            addView(this.f2304f, new LayoutParams(-2, -1));
            if (this.f2304f.getAdapter() == null) {
                this.f2304f.setAdapter(new C0913a());
            }
            if (this.f2299a != null) {
                removeCallbacks(this.f2299a);
                this.f2299a = null;
            }
            this.f2304f.setSelection(this.f2307i);
        }
    }

    private boolean m4736c() {
        if (m4734a()) {
            removeView(this.f2304f);
            addView(this.f2303e, new LayoutParams(-2, -1));
            setTabSelected(this.f2304f.getSelectedItemPosition());
        }
        return false;
    }

    private Spinner m4737d() {
        Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, C0720a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new C0796a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public void m4738a(int i) {
        View childAt = this.f2303e.getChildAt(i);
        if (this.f2299a != null) {
            removeCallbacks(this.f2299a);
        }
        this.f2299a = new C09121(this, childAt);
        post(this.f2299a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2299a != null) {
            post(this.f2299a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0739a a = C0739a.m3212a(getContext());
        setContentHeight(a.m3217e());
        this.f2301c = a.m3219g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2299a != null) {
            removeCallbacks(this.f2299a);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0915c) view).m4730b().m2814d();
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2303e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2300b = -1;
        } else {
            if (childCount > 2) {
                this.f2300b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2300b = MeasureSpec.getSize(i) / 2;
            }
            this.f2300b = Math.min(this.f2300b, this.f2301c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f2306h, 1073741824);
        if (z || !this.f2305g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2303e.measure(0, mode);
            if (this.f2303e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m4735b();
            } else {
                m4736c();
            }
        } else {
            m4736c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f2307i);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f2305g = z;
    }

    public void setContentHeight(int i) {
        this.f2306h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f2307i = i;
        int childCount = this.f2303e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2303e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m4738a(i);
            }
            i2++;
        }
        if (this.f2304f != null && i >= 0) {
            this.f2304f.setSelection(i);
        }
    }
}
