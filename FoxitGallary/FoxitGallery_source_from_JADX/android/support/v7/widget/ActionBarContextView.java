package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p016k.az;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.C0716b;
import android.support.v7.view.menu.C0769h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0789a {
    private CharSequence f1666g;
    private CharSequence f1667h;
    private View f1668i;
    private View f1669j;
    private LinearLayout f1670k;
    private TextView f1671l;
    private TextView f1672m;
    private int f1673n;
    private int f1674o;
    private boolean f1675p;
    private int f1676q;

    /* renamed from: android.support.v7.widget.ActionBarContextView.1 */
    class C07881 implements OnClickListener {
        final /* synthetic */ C0716b f1656a;
        final /* synthetic */ ActionBarContextView f1657b;

        C07881(ActionBarContextView actionBarContextView, C0716b c0716b) {
            this.f1657b = actionBarContextView;
            this.f1656a = c0716b;
        }

        public void onClick(View view) {
            this.f1656a.m3116c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bf a = bf.m4774a(context, attributeSet, C0729j.ActionMode, i, 0);
        setBackgroundDrawable(a.m4777a(C0729j.ActionMode_background));
        this.f1673n = a.m4790g(C0729j.ActionMode_titleTextStyle, 0);
        this.f1674o = a.m4790g(C0729j.ActionMode_subtitleTextStyle, 0);
        this.e = a.m4788f(C0729j.ActionMode_height, 0);
        this.f1676q = a.m4790g(C0729j.ActionMode_closeItemLayout, C0726g.abc_action_mode_close_item_material);
        a.m4778a();
    }

    private void m3578e() {
        int i = 8;
        Object obj = 1;
        if (this.f1670k == null) {
            LayoutInflater.from(getContext()).inflate(C0726g.abc_action_bar_title_item, this);
            this.f1670k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1671l = (TextView) this.f1670k.findViewById(C0725f.action_bar_title);
            this.f1672m = (TextView) this.f1670k.findViewById(C0725f.action_bar_subtitle);
            if (this.f1673n != 0) {
                this.f1671l.setTextAppearance(getContext(), this.f1673n);
            }
            if (this.f1674o != 0) {
                this.f1672m.setTextAppearance(getContext(), this.f1674o);
            }
        }
        this.f1671l.setText(this.f1666g);
        this.f1672m.setText(this.f1667h);
        Object obj2 = !TextUtils.isEmpty(this.f1666g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1667h)) {
            obj = null;
        }
        this.f1672m.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.f1670k;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f1670k.getParent() == null) {
            addView(this.f1670k);
        }
    }

    public /* bridge */ /* synthetic */ az m3579a(int i, long j) {
        return super.m3576a(i, j);
    }

    public void m3580a(C0716b c0716b) {
        if (this.f1668i == null) {
            this.f1668i = LayoutInflater.from(getContext()).inflate(this.f1676q, this, false);
            addView(this.f1668i);
        } else if (this.f1668i.getParent() == null) {
            addView(this.f1668i);
        }
        this.f1668i.findViewById(C0725f.action_mode_close_button).setOnClickListener(new C07881(this, c0716b));
        C0769h c0769h = (C0769h) c0716b.m3113b();
        if (this.d != null) {
            this.d.m4912f();
        }
        this.d = new C0931d(getContext());
        this.d.m4908c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0769h.m3438a(this.d, this.b);
        this.c = (ActionMenuView) this.d.m4893a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public boolean m3581a() {
        return this.d != null ? this.d.m4910d() : false;
    }

    public void m3582b() {
        if (this.f1668i == null) {
            m3583c();
        }
    }

    public void m3583c() {
        removeAllViews();
        this.f1669j = null;
        this.c = null;
    }

    public boolean m3584d() {
        return this.f1675p;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1667h;
    }

    public CharSequence getTitle() {
        return this.f1666g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m4911e();
            this.d.m4913g();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1666g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bj.m4867a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1668i == null || this.f1668i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1668i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0789a.m3571a(paddingRight, i5, a);
            i5 = C0789a.m3571a(m3575a(this.f1668i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1670k == null || this.f1669j != null || this.f1670k.getVisibility() == 8)) {
            i5 += m3575a(this.f1670k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1669j != null) {
            int a2 = m3575a(this.f1669j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m3575a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1668i != null) {
                a = m3574a(this.f1668i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1668i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m3574a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1670k != null && this.f1669j == null) {
                if (this.f1675p) {
                    this.f1670k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1670k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1670k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m3574a(this.f1670k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1669j != null) {
                LayoutParams layoutParams = this.f1669j.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.f1669j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1669j != null) {
            removeView(this.f1669j);
        }
        this.f1669j = view;
        if (!(view == null || this.f1670k == null)) {
            removeView(this.f1670k);
            this.f1670k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1667h = charSequence;
        m3578e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1666g = charSequence;
        m3578e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1675p) {
            requestLayout();
        }
        this.f1675p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
