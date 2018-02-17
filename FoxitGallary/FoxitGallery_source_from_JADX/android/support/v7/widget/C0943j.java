package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p022c.C0225a;
import android.support.v4.widget.ac;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* renamed from: android.support.v7.widget.j */
public class C0943j extends CheckBox implements ac {
    private C0951m f2456a;
    private C0945l f2457b;

    public C0943j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.checkboxStyle);
    }

    public C0943j(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f2456a = C0951m.m4995a();
        this.f2457b = new C0945l(this, this.f2456a);
        this.f2457b.m4979a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2457b != null ? this.f2457b.m4975a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f2457b != null ? this.f2457b.m4976a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.f2457b != null ? this.f2457b.m4980b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2456a != null ? this.f2456a.m5013a(getContext(), i) : C0225a.m808a(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2457b != null) {
            this.f2457b.m4981c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2457b != null) {
            this.f2457b.m4977a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f2457b != null) {
            this.f2457b.m4978a(mode);
        }
    }
}
