package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0110a.C0105c;
import android.support.design.C0110a.C0106d;
import android.support.design.C0110a.C0107e;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.widget.C0641z;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.view.menu.C0114p.C0112a;
import android.support.v7.view.menu.C0772j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C0111a implements C0112a {
    private static final int[] f165c;
    private final int f166d;
    private final CheckedTextView f167e;
    private FrameLayout f168f;
    private C0772j f169g;
    private ColorStateList f170h;

    static {
        f165c = new int[]{16842912};
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0107e.design_navigation_menu_item, this, true);
        this.f166d = context.getResources().getDimensionPixelSize(C0105c.design_navigation_icon_size);
        this.f167e = (CheckedTextView) findViewById(C0106d.design_menu_item_text);
        this.f167e.setDuplicateParentStateEnabled(true);
    }

    private StateListDrawable m235b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0720a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f165c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (this.f168f == null) {
            this.f168f = (FrameLayout) ((ViewStub) findViewById(C0106d.design_menu_item_action_area_stub)).inflate();
        }
        this.f168f.removeAllViews();
        if (view != null) {
            this.f168f.addView(view);
        }
    }

    public void m236a(C0772j c0772j, int i) {
        this.f169g = c0772j;
        setVisibility(c0772j.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m235b());
        }
        setCheckable(c0772j.isCheckable());
        setChecked(c0772j.isChecked());
        setEnabled(c0772j.isEnabled());
        setTitle(c0772j.getTitle());
        setIcon(c0772j.getIcon());
        setActionView(c0772j.getActionView());
    }

    public boolean m237a() {
        return false;
    }

    public C0772j getItemData() {
        return this.f169g;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f169g != null && this.f169g.isCheckable() && this.f169g.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f165c);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f167e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C0326a.m1272f(drawable).mutate();
            drawable.setBounds(0, 0, this.f166d, this.f166d);
            C0326a.m1262a(drawable, this.f170h);
        }
        C0641z.m2809a(this.f167e, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f170h = colorStateList;
        if (this.f169g != null) {
            setIcon(this.f169g.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f167e.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f167e.setText(charSequence);
    }
}
