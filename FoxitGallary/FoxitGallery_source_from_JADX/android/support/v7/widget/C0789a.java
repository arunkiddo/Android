package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.az;
import android.support.v4.p016k.bd;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* renamed from: android.support.v7.widget.a */
abstract class C0789a extends ViewGroup {
    protected final C0882a f1658a;
    protected final Context f1659b;
    protected ActionMenuView f1660c;
    protected C0931d f1661d;
    protected int f1662e;
    protected az f1663f;
    private boolean f1664g;
    private boolean f1665h;

    /* renamed from: android.support.v7.widget.a.a */
    protected class C0882a implements bd {
        int f2175a;
        final /* synthetic */ C0789a f2176b;
        private boolean f2177c;

        protected C0882a(C0789a c0789a) {
            this.f2176b = c0789a;
            this.f2177c = false;
        }

        public C0882a m4491a(az azVar, int i) {
            this.f2176b.f1663f = azVar;
            this.f2175a = i;
            return this;
        }

        public void m4492a(View view) {
            super.setVisibility(0);
            this.f2177c = false;
        }

        public void m4493b(View view) {
            if (!this.f2177c) {
                this.f2176b.f1663f = null;
                super.setVisibility(this.f2175a);
            }
        }

        public void m4494c(View view) {
            this.f2177c = true;
        }
    }

    C0789a(Context context) {
        this(context, null);
    }

    C0789a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0789a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1658a = new C0882a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0720a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1659b = context;
        } else {
            this.f1659b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int m3571a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m3574a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m3575a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public az m3576a(int i, long j) {
        if (this.f1663f != null) {
            this.f1663f.m2164b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ah.m1927c((View) this, 0.0f);
            }
            az a = ah.m1951r(this).m2157a(1.0f);
            a.m2158a(j);
            a.m2159a(this.f1658a.m4491a(a, i));
            return a;
        }
        a = ah.m1951r(this).m2157a(0.0f);
        a.m2158a(j);
        a.m2159a(this.f1658a.m4491a(a, i));
        return a;
    }

    public boolean m3577a() {
        return this.f1661d != null ? this.f1661d.m4910d() : false;
    }

    public int getAnimatedVisibility() {
        return this.f1663f != null ? this.f1658a.f2175a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1662e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0729j.ActionBar, C0720a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0729j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1661d != null) {
            this.f1661d.m4896a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0560t.m2392a(motionEvent);
        if (a == 9) {
            this.f1665h = false;
        }
        if (!this.f1665h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1665h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1665h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0560t.m2392a(motionEvent);
        if (a == 0) {
            this.f1664g = false;
        }
        if (!this.f1664g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1664g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1664g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1662e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1663f != null) {
                this.f1663f.m2164b();
            }
            super.setVisibility(i);
        }
    }
}
