package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0110a.C0105c;
import android.support.design.widget.C0179g.C0144a;
import android.support.design.widget.C0202q.C0115a;
import android.support.design.widget.CoordinatorLayout.C0122b;
import android.support.design.widget.CoordinatorLayout.C0136c;
import android.support.design.widget.CoordinatorLayout.C0138e;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.p016k.ac;
import android.support.v4.p016k.ah;
import android.support.v4.p022c.p023a.C0301a;
import android.support.v7.widget.C0954p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.List;

@C0136c(a = Behavior.class)
public class FloatingActionButton extends C0150z {
    private ColorStateList f294a;
    private Mode f295b;
    private int f296c;
    private int f297d;
    private int f298e;
    private int f299f;
    private boolean f300g;
    private final Rect f301h;
    private final Rect f302i;
    private C0954p f303j;
    private C0179g f304k;

    /* renamed from: android.support.design.widget.FloatingActionButton.1 */
    class C01451 implements C0144a {
        final /* synthetic */ C0147a f284a;
        final /* synthetic */ FloatingActionButton f285b;

        C01451(FloatingActionButton floatingActionButton, C0147a c0147a) {
            this.f285b = floatingActionButton;
            this.f284a = c0147a;
        }

        public void m496a() {
            this.f284a.m511a(this.f285b);
        }

        public void m497b() {
            this.f284a.m512b(this.f285b);
        }
    }

    public static class Behavior extends C0122b<FloatingActionButton> {
        private static final boolean f288a;
        private C0202q f289b;
        private float f290c;
        private Rect f291d;

        /* renamed from: android.support.design.widget.FloatingActionButton.Behavior.1 */
        class C01461 implements C0115a {
            final /* synthetic */ FloatingActionButton f286a;
            final /* synthetic */ Behavior f287b;

            C01461(Behavior behavior, FloatingActionButton floatingActionButton) {
                this.f287b = behavior;
                this.f286a = floatingActionButton;
            }

            public void m498a(C0202q c0202q) {
                ah.m1923b(this.f286a, c0202q.m751d());
            }
        }

        static {
            f288a = VERSION.SDK_INT >= 11;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private float m499a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            float f = 0.0f;
            List d = coordinatorLayout.m492d((View) floatingActionButton);
            int size = d.size();
            int i = 0;
            while (i < size) {
                View view = (View) d.get(i);
                float min = ((view instanceof SnackbarLayout) && coordinatorLayout.m483a((View) floatingActionButton, view)) ? Math.min(f, ah.m1947n(view) - ((float) view.getHeight())) : f;
                i++;
                f = min;
            }
            return f;
        }

        private void m500a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, boolean z) {
            float a = m499a(coordinatorLayout, floatingActionButton);
            if (this.f290c != a) {
                float n = ah.m1947n(floatingActionButton);
                if (this.f289b != null && this.f289b.m749b()) {
                    this.f289b.m752e();
                }
                if (z && floatingActionButton.isShown() && Math.abs(n - a) > ((float) floatingActionButton.getHeight()) * 0.667f) {
                    if (this.f289b == null) {
                        this.f289b = C0215x.m789a();
                        this.f289b.m748a(C0170a.f350b);
                        this.f289b.m747a(new C01461(this, floatingActionButton));
                    }
                    this.f289b.m744a(n, a);
                    this.f289b.m743a();
                } else {
                    ah.m1923b((View) floatingActionButton, a);
                }
                this.f290c = a;
            }
        }

        private boolean m501a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((C0138e) floatingActionButton.getLayoutParams()).m433a() != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.f291d == null) {
                this.f291d = new Rect();
            }
            Rect rect = this.f291d;
            C0211t.m780b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m531b(null, false);
            } else {
                floatingActionButton.m527a(null, false);
            }
            return true;
        }

        private void m502b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect a = floatingActionButton.f301h;
            if (a != null && a.centerX() > 0 && a.centerY() > 0) {
                C0138e c0138e = (C0138e) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0138e.rightMargin ? a.right : floatingActionButton.getLeft() <= c0138e.leftMargin ? -a.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - c0138e.bottomMargin) {
                    i = a.bottom;
                } else if (floatingActionButton.getTop() <= c0138e.topMargin) {
                    i = -a.top;
                }
                floatingActionButton.offsetTopAndBottom(i);
                floatingActionButton.offsetLeftAndRight(i2);
            }
        }

        public boolean m503a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List d = coordinatorLayout.m492d((View) floatingActionButton);
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) d.get(i2);
                if ((view instanceof AppBarLayout) && m501a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m476a((View) floatingActionButton, i);
            m502b(coordinatorLayout, floatingActionButton);
            m500a(coordinatorLayout, floatingActionButton, false);
            return true;
        }

        public boolean m504a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return f288a && (view instanceof SnackbarLayout);
        }

        public boolean m506b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof SnackbarLayout) {
                m500a(coordinatorLayout, floatingActionButton, true);
            } else if (view instanceof AppBarLayout) {
                m501a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            }
            return false;
        }

        public /* synthetic */ boolean m507b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m504a(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public void m508c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof SnackbarLayout) {
                m500a(coordinatorLayout, floatingActionButton, true);
            }
        }

        public /* synthetic */ boolean m509c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m506b(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public /* synthetic */ void m510d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m508c(coordinatorLayout, (FloatingActionButton) view, view2);
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButton.a */
    public static abstract class C0147a {
        public void m511a(FloatingActionButton floatingActionButton) {
        }

        public void m512b(FloatingActionButton floatingActionButton) {
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButton.b */
    private class C0149b implements C0148m {
        final /* synthetic */ FloatingActionButton f292a;

        private C0149b(FloatingActionButton floatingActionButton) {
            this.f292a = floatingActionButton;
        }

        public float m517a() {
            return ((float) this.f292a.getSizeDimension()) / 2.0f;
        }

        public void m518a(int i, int i2, int i3, int i4) {
            this.f292a.f301h.set(i, i2, i3, i4);
            this.f292a.setPadding(this.f292a.f298e + i, this.f292a.f298e + i2, this.f292a.f298e + i3, this.f292a.f298e + i4);
        }

        public void m519a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean m520b() {
            return this.f292a.f300g;
        }
    }

    private int m522a(int i) {
        Resources resources = getResources();
        switch (i) {
            case ac.POSITION_UNCHANGED /*-1*/:
                return Math.max(C0301a.m1171b(resources), C0301a.m1170a(resources)) < 470 ? m522a(1) : m522a(0);
            case C1373c.View_android_focusable /*1*/:
                return resources.getDimensionPixelSize(C0105c.design_fab_size_mini);
            default:
                return resources.getDimensionPixelSize(C0105c.design_fab_size_normal);
        }
    }

    private static int m523a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private C0144a m525a(C0147a c0147a) {
        return c0147a == null ? null : new C01451(this, c0147a);
    }

    private C0179g m526a() {
        int i = VERSION.SDK_INT;
        return i >= 21 ? new C0185h(this, new C0149b()) : i >= 14 ? new C0183f(this, new C0149b()) : new C0180e(this, new C0149b());
    }

    private void m527a(C0147a c0147a, boolean z) {
        getImpl().m645b(m525a(c0147a), z);
    }

    private void m531b(C0147a c0147a, boolean z) {
        getImpl().m640a(m525a(c0147a), z);
    }

    private C0179g getImpl() {
        if (this.f304k == null) {
            this.f304k = m526a();
        }
        return this.f304k;
    }

    private int getSizeDimension() {
        return m522a(this.f297d);
    }

    public boolean m535a(Rect rect) {
        if (!ah.m1901D(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.f301h.left;
        rect.top += this.f301h.top;
        rect.right -= this.f301h.right;
        rect.bottom -= this.f301h.bottom;
        return true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().m641a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f294a;
    }

    public Mode getBackgroundTintMode() {
        return this.f295b;
    }

    public float getCompatElevation() {
        return getImpl().m634a();
    }

    public Drawable getContentBackground() {
        return getImpl().m649f();
    }

    public int getSize() {
        return this.f297d;
    }

    public boolean getUseCompatPadding() {
        return this.f300g;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().m642b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m651h();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m652i();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f298e = (sizeDimension - this.f299f) / 2;
        getImpl().m650g();
        sizeDimension = Math.min(m523a(sizeDimension, i), m523a(sizeDimension, i2));
        setMeasuredDimension((this.f301h.left + sizeDimension) + this.f301h.right, (sizeDimension + this.f301h.top) + this.f301h.bottom);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (!m535a(this.f302i) || this.f302i.contains((int) motionEvent.getX(), (int) motionEvent.getY())) ? super.onTouchEvent(motionEvent) : false;
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f294a != colorStateList) {
            this.f294a = colorStateList;
            getImpl().m637a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f295b != mode) {
            this.f295b = mode;
            getImpl().m638a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().m643b(f);
    }

    public void setImageResource(int i) {
        this.f303j.m5017a(i);
    }

    public void setRippleColor(int i) {
        if (this.f296c != i) {
            this.f296c = i;
            getImpl().m636a(i);
        }
    }

    public void setSize(int i) {
        if (i != this.f297d) {
            this.f297d = i;
            requestLayout();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f300g != z) {
            this.f300g = z;
            getImpl().m646c();
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
