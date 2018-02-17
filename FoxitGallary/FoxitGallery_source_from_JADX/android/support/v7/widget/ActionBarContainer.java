package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable f1646a;
    Drawable f1647b;
    Drawable f1648c;
    boolean f1649d;
    boolean f1650e;
    private boolean f1651f;
    private View f1652g;
    private View f1653h;
    private View f1654i;
    private int f1655j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(VERSION.SDK_INT >= 21 ? new C0921c(this) : new C0917b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.ActionBar);
        this.f1646a = obtainStyledAttributes.getDrawable(C0729j.ActionBar_background);
        this.f1647b = obtainStyledAttributes.getDrawable(C0729j.ActionBar_backgroundStacked);
        this.f1655j = obtainStyledAttributes.getDimensionPixelSize(C0729j.ActionBar_height, -1);
        if (getId() == C0725f.split_action_bar) {
            this.f1649d = true;
            this.f1648c = obtainStyledAttributes.getDrawable(C0729j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1649d ? this.f1648c == null : this.f1646a == null && this.f1647b == null;
        setWillNotDraw(z);
    }

    private boolean m3569a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m3570b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1646a != null && this.f1646a.isStateful()) {
            this.f1646a.setState(getDrawableState());
        }
        if (this.f1647b != null && this.f1647b.isStateful()) {
            this.f1647b.setState(getDrawableState());
        }
        if (this.f1648c != null && this.f1648c.isStateful()) {
            this.f1648c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1652g;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1646a != null) {
                this.f1646a.jumpToCurrentState();
            }
            if (this.f1647b != null) {
                this.f1647b.jumpToCurrentState();
            }
            if (this.f1648c != null) {
                this.f1648c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1653h = findViewById(C0725f.action_bar);
        this.f1654i = findViewById(C0725f.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1651f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1652g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1649d) {
            int i6;
            if (this.f1646a != null) {
                if (this.f1653h.getVisibility() == 0) {
                    this.f1646a.setBounds(this.f1653h.getLeft(), this.f1653h.getTop(), this.f1653h.getRight(), this.f1653h.getBottom());
                } else if (this.f1654i == null || this.f1654i.getVisibility() != 0) {
                    this.f1646a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1646a.setBounds(this.f1654i.getLeft(), this.f1654i.getTop(), this.f1654i.getRight(), this.f1654i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1650e = z2;
            if (!z2 || this.f1647b == null) {
                i5 = i6;
            } else {
                this.f1647b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1648c != null) {
            this.f1648c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f1653h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1655j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1655j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1653h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1652g != null && this.f1652g.getVisibility() != 8 && mode != 1073741824) {
                int b = !m3569a(this.f1653h) ? m3570b(this.f1653h) : !m3569a(this.f1654i) ? m3570b(this.f1654i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m3570b(this.f1652g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1646a != null) {
            this.f1646a.setCallback(null);
            unscheduleDrawable(this.f1646a);
        }
        this.f1646a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1653h != null) {
                this.f1646a.setBounds(this.f1653h.getLeft(), this.f1653h.getTop(), this.f1653h.getRight(), this.f1653h.getBottom());
            }
        }
        if (this.f1649d) {
            if (this.f1648c != null) {
                z = false;
            }
        } else if (!(this.f1646a == null && this.f1647b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1648c != null) {
            this.f1648c.setCallback(null);
            unscheduleDrawable(this.f1648c);
        }
        this.f1648c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1649d && this.f1648c != null) {
                this.f1648c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1649d) {
            if (this.f1648c != null) {
                z = false;
            }
        } else if (!(this.f1646a == null && this.f1647b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1647b != null) {
            this.f1647b.setCallback(null);
            unscheduleDrawable(this.f1647b);
        }
        this.f1647b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1650e && this.f1647b != null) {
                this.f1647b.setBounds(this.f1652g.getLeft(), this.f1652g.getTop(), this.f1652g.getRight(), this.f1652g.getBottom());
            }
        }
        if (this.f1649d) {
            if (this.f1648c != null) {
                z = false;
            }
        } else if (!(this.f1646a == null && this.f1647b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ax axVar) {
        if (this.f1652g != null) {
            removeView(this.f1652g);
        }
        this.f1652g = axVar;
        if (axVar != null) {
            addView(axVar);
            ViewGroup.LayoutParams layoutParams = axVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            axVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1651f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1646a != null) {
            this.f1646a.setVisible(z, false);
        }
        if (this.f1647b != null) {
            this.f1647b.setVisible(z, false);
        }
        if (this.f1648c != null) {
            this.f1648c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        return i != 0 ? super.startActionModeForChild(view, callback, i) : null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1646a && !this.f1649d) || ((drawable == this.f1647b && this.f1650e) || ((drawable == this.f1648c && this.f1649d) || super.verifyDrawable(drawable)));
    }
}
