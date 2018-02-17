package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p022c.C0225a;
import android.support.v4.widget.ac;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* renamed from: android.support.v7.widget.u */
public class C0959u extends RadioButton implements ac {
    private C0951m f2504a;
    private C0945l f2505b;

    public C0959u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.radioButtonStyle);
    }

    public C0959u(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f2504a = C0951m.m4995a();
        this.f2505b = new C0945l(this, this.f2504a);
        this.f2505b.m4979a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2505b != null ? this.f2505b.m4975a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f2505b != null ? this.f2505b.m4976a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.f2505b != null ? this.f2505b.m4980b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2504a != null ? this.f2504a.m5013a(getContext(), i) : C0225a.m808a(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2505b != null) {
            this.f2505b.m4981c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2505b != null) {
            this.f2505b.m4977a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f2505b != null) {
            this.f2505b.m4978a(mode);
        }
    }
}
